/*======================================================================
PrimaryDataFromDb transfers primary data from databases to SIARD files.
Application : Siard2
Description : Transfers primary data from databases to SIARD files.
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2008
Created    : 01.09.2016, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/
package ch.admin.bar.siard2.cmd;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.datatype.Duration;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.Cell;
import ch.admin.bar.siard2.api.MetaColumn;
import ch.admin.bar.siard2.api.MetaTable;
import ch.admin.bar.siard2.api.MetaType;
import ch.admin.bar.siard2.api.Record;
import ch.admin.bar.siard2.api.RecordRetainer;
import ch.admin.bar.siard2.api.Schema;
import ch.admin.bar.siard2.api.Table;
import ch.admin.bar.siard2.api.Value;
import ch.admin.bar.siard2.api.generated.CategoryType;
import ch.admin.bar.siard2.api.primary.FileDownloadModel;
import ch.admin.bar.siard2.cmd.util.FileUtils;
import ch.config.db.HistoryDAO;
import ch.enterag.sqlparser.identifier.QualifiedId;
import ch.enterag.utils.StopWatch;
import ch.enterag.utils.background.Progress;
import ch.enterag.utils.database.SqlTypes;
import ch.enterag.utils.logging.IndentLogger;

/*====================================================================*/
/** Transfers primary data from databases to SIARD files.
 @author Hartwig Thomas
 */
public class PrimaryDataFromDb extends PrimaryDataTransfer
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(PrimaryDataFromDb.class.getName());
  private static long _lREPORT_RECORDS = 1000;
  private Progress _progress = null;
  private long _lRecordsDownloaded = -1;
  private long _lRecordsTotal = -1;
  private long _lRecordsPercent = -1;
  private StopWatch _swGetCell = null;
  private StopWatch _swGetValue = null;
  private StopWatch _swSetValue = null;

	private java.time.Duration downtimesum = java.time.Duration.ZERO;
	private int downcount = 0;
	private long downsizesum = 0;

  /*------------------------------------------------------------------*/
  /** increment the number or records downloaded, issuing a notification,
   * when a percent is reached.
   */
  private void incDownloaded()
  {
    _lRecordsDownloaded++;
    if ((_progress != null) && (_lRecordsTotal > 0) && ((_lRecordsDownloaded % _lRecordsPercent) == 0))
    {
      int iPercent = (int)((100*_lRecordsDownloaded)/_lRecordsTotal);
      _progress.notifyProgress(iPercent);
    }
  } /* incDownloaded */

  /*------------------------------------------------------------------*/
  /** check if cancel was requested.
   * @return true, if cancel was requested.
   */
  private boolean cancelRequested()
  {
    boolean bCancelRequested = false;
    if (_progress != null)
      bCancelRequested = _progress.cancelRequested();
    return bCancelRequested;
  } /* cancelRequested */

  private void setValue(Value value, Object oValue)
    throws IOException, SQLException
  {
    if (oValue != null)
    {
      if (oValue instanceof String)
        value.setString((String)oValue);
      else if (oValue instanceof byte[])
        value.setBytes((byte[])oValue);
      else if (oValue instanceof Boolean)
        value.setBoolean(((Boolean)oValue).booleanValue());
      else if (oValue instanceof Short)
      	value.setShort(((Short)oValue).shortValue());
      else if (oValue instanceof Integer)
        value.setInt(((Integer)oValue).intValue());
      else if (oValue instanceof Long)
        value.setLong(((Long)oValue).longValue());
      else if (oValue instanceof BigInteger)
        value.setBigInteger((BigInteger)oValue);
      else if (oValue instanceof BigDecimal)
        value.setBigDecimal((BigDecimal)oValue);
      else if (oValue instanceof Float)
        value.setFloat(((Float)oValue).floatValue());
      else if (oValue instanceof Double)
        value.setDouble(((Double)oValue).doubleValue());
      else if (oValue instanceof Timestamp)
        value.setTimestamp((Timestamp)oValue);
      else if (oValue instanceof Time)
        value.setTime((Time)oValue);
      else if (oValue instanceof Date)
        value.setDate((Date)oValue);
      else if (oValue instanceof Duration)
        value.setDuration((Duration)oValue);
      else if (oValue instanceof Clob)
      {
        Clob clob = (Clob)oValue;
        value.setReader(clob.getCharacterStream());
        clob.free();
      }
      else if (oValue instanceof SQLXML)
      {
        SQLXML sqlxml = (SQLXML)oValue;
        value.setReader(sqlxml.getCharacterStream());
        sqlxml.free();
      }
      else if (oValue instanceof NClob)
      {
        NClob nclob = (NClob)oValue;
        value.setReader(nclob.getCharacterStream());
        nclob.free();
      }
      else if (oValue instanceof Blob)
      {
        Blob blob = (Blob)oValue;
        value.setInputStream(blob.getBinaryStream());
        blob.free();
      }
      else if (oValue instanceof Array)
      {
        Array array = (Array)oValue;
        Object[] ao = (Object[])array.getArray();
        for (int iElement = 0; iElement < ao.length; iElement++)
        {
          Value valueElement = value.getElement(iElement);
          setValue(valueElement,ao[iElement]);
        }
        array.free();
      }
      else if (oValue instanceof Struct)
      {
        Struct struct = (Struct)oValue;
        Object[] ao = struct.getAttributes();
        for (int iAttribute = 0; iAttribute < ao.length; iAttribute++)
        {
          Value valueAttribute = value.getAttribute(iAttribute);
          setValue(valueAttribute,ao[iAttribute]);
        }
      }
      else
        throw new SQLException("Invalid value type "+oValue.getClass().getName()+" encountered!");
    }
  } /* setValue */

  /*------------------------------------------------------------------*/
  /** extract primary data of a record from the result set.
   * @param rs result set.
   * @param record record to be filled.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  private void getRecord(ResultSet rs, Record record, Map<String, Long> map)
    throws IOException, SQLException
  {

    ResultSetMetaData rsmd = rs.getMetaData();
    if (rsmd.getColumnCount() != record.getCells())
      throw new IOException("Invalid number of result columns found!");

    for (int iCell = 0; iCell < record.getCells(); iCell++)
    {
    	_swGetCell.start();
      int iPosition = iCell+1;
      Cell cell = record.getCell(iCell);
      MetaColumn mc = cell.getMetaColumn();
      // String sColumnName = mc.getName();
      int iDataType = mc.getPreType();
      if (mc.getCardinality() >= 0)
        iDataType = Types.ARRAY;
      MetaType mt = mc.getMetaType();
      if (mt != null)
      {
        CategoryType cat = mt.getCategoryType();
        if (cat == CategoryType.DISTINCT)
          iDataType = mt.getBasePreType();
        else
          iDataType = Types.STRUCT;
      }
      _swGetCell.stop();
      _swGetValue.start();
      Object oValue = null;
      switch (iDataType)
      {
        case Types.CHAR:
        case Types.VARCHAR:
          oValue = rs.getString(iPosition);
          break;
        case Types.CLOB:
          oValue = rs.getClob(iPosition);
          break;
        case Types.SQLXML:
          oValue = rs.getSQLXML(iPosition);
          break;
        case Types.NCHAR:
        case Types.NVARCHAR:
          oValue = rs.getNString(iPosition);
          break;
        case Types.NCLOB:
          oValue = rs.getNClob(iPosition);
          break;
        case Types.BINARY:
        case Types.VARBINARY:
          oValue = rs.getBytes(iPosition);
          break;
        case Types.BLOB:
          oValue = rs.getBlob(iPosition);
          break;
        case Types.BOOLEAN:
          oValue = Boolean.valueOf(rs.getBoolean(iPosition));
          break;
        case Types.SMALLINT:
          oValue = Integer.valueOf(rs.getInt(iPosition));
          break;
        case Types.INTEGER:
          oValue = Long.valueOf(rs.getLong(iPosition));
          break;
        case Types.BIGINT:
          BigDecimal bdInt = rs.getBigDecimal(iPosition);
          if (bdInt != null)
            oValue = bdInt.toBigIntegerExact();
          break;
        case Types.DECIMAL:
        case Types.NUMERIC:
          oValue = rs.getBigDecimal(iPosition);
          break;
        case Types.REAL:
          oValue = Float.valueOf(rs.getFloat(iPosition));
          break;
        case Types.FLOAT:
        case Types.DOUBLE:
          oValue = Double.valueOf(rs.getDouble(iPosition));
          break;
        case Types.DATE:
					/* S: ORACLE DATE형 시분초 없어지는 현상 수정 - Cubrid 김병욱 전문위원 수정 */
					if(_dbms.equals("Oracle"))
					{
						mc.setPreType(Types.TIMESTAMP, 0, mc.getScale());
						oValue = rs.getTimestamp(iPosition);
					}
					else
					{
						oValue = rs.getDate(iPosition);
					}
					/* E: ORACLE DATE형 시분초 없어지는 현상 수정 - Cubrid 김병욱 전문위원 수정 */
          break;
        case Types.TIME:
          oValue = rs.getTime(iPosition);
          break;
        case Types.TIMESTAMP:
          oValue = rs.getTimestamp(iPosition);
          break;
        case Types.OTHER:
          oValue = rs.getObject(iPosition);
          break;
        case Types.ARRAY:
					if(_dbms.equals("CUBRID"))
					{
						oValue = rs.getString(iPosition);
					}
					else
					{
						oValue = rs.getArray(iPosition);
					}
          break;
        case Types.STRUCT:
          oValue = rs.getObject(iPosition);
          break;
        //데이터타입이 null(0) 인 경우 처리 로직 추가.
        case Types.NULL:
          //2020.07.28 - Types에 정의되어 있지 않은 타입(json 등)의 경우  null(0)로 들어옴.이 경우 varchar로 전환되도록 함.
          oValue = rs.getString(iPosition);
          break;
        default:
          throw new SQLException("Invalid data type "+
            String.valueOf(iDataType)+" ("+
            SqlTypes.getTypeName(iDataType)+") encountered!");
      } /* switch */
      if (rs.wasNull())
        oValue = null;
      _swGetValue.stop();
      _swSetValue.start();

      setValue(cell, oValue);

			for(String key : _archive.getColumnCheckedMap().keySet() ) {
				FileDownloadModel fileDownloadModel = _archive.getColumnCheckedMap().get(key);

				//테이블 컬럼 선택값이 null이면 continue
				if(fileDownloadModel == null) continue;

				String sourceFileRootPath = "";
				boolean chooseColumnFlag = false;
				for (int i = 0; i < fileDownloadModel.getChooseColumnList().size(); i++) {
					if(mc.getName().equals(fileDownloadModel.getChooseColumnList().get(i).getColumnName())) {
						chooseColumnFlag = true;
						sourceFileRootPath = fileDownloadModel.getChooseColumnList().get(i).getSourceFileRootPath();
						if(sourceFileRootPath == null) sourceFileRootPath = "";

						break;
					}
				}

				//20200904 - 파일 경로의 데이터가 null인경우 제외 추가 by.pks
        if(!chooseColumnFlag || oValue == null) continue;


				//TODO 테스트 용 로그
//				System.out.println();
//				System.out.println("현재컬럼 => " + mc.getName());
//				System.out.println("선택컬럼 => " + fileDownloadModel.getChooseColumnList().toString());
//				System.out.println("rootPath => " + sourceFileRootPath);
//				System.out.println("존재여부 => " + chooseColumnFlag);

//				final String SOURCE_FILE = sourceFileRootPath + File.separator +  oValue.toString();
				final String SOURCE_FILE = sourceFileRootPath + oValue.toString();

				if(fileDownloadModel.isSftpFlag()) {
					try {
						String targetFilePath = "";
						targetFilePath = fileDownloadModel.getTargetFilePath();

						if("".equals(targetFilePath.trim())) {
							targetFilePath = _archive.getFile().getParent();
						}
						FileDownloadModel model = new FileDownloadModel();
						model.setSourceFile(SOURCE_FILE);
						model.setTargetFile(targetFilePath);

						SFTPConnection sftpConnection = new SFTPConnection(fileDownloadModel.getHost(), fileDownloadModel.getUser(), fileDownloadModel.getPassword(), fileDownloadModel.getPort());
						sftpConnection.download(model);

						map.put("sourceFileSize", map.get("sourceFileSize") + sftpConnection.sourceFileSize);
						map.put("executeTime", map.get("executeTime") + sftpConnection.executeTime);
						map.put("fileCount", map.get("fileCount") + 1);

					} catch (Exception e) {
					}

				}else if(fileDownloadModel.isFileCopyFlag()) {

					try {
						String targetFilePath = "";
						targetFilePath = fileDownloadModel.getTargetFilePath();

						if("".equals(targetFilePath.trim())) {
							targetFilePath = _archive.getFile().getParent();
						}
						FileUtils fileUtis = new FileUtils();
						fileUtis.copy(SOURCE_FILE, targetFilePath + File.separator + SOURCE_FILE.substring(0, SOURCE_FILE.lastIndexOf("/") + 1));

						map.put("sourceFileSize", map.get("sourceFileSize") + fileUtis.sourceFileSize);
						map.put("executeTime", map.get("executeTime") + fileUtis.executeTime);
						map.put("fileCount", map.get("fileCount") + 1);

					} catch (Exception e) {
					}


				}

			}

		} /* loop over values */

    _swSetValue.stop();
	} /* getRecord */

  /*------------------------------------------------------------------*/
  /** download primary data of a table using a SELECT query for all
   * fields.
   * @param table table.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  private void getTable(Table table)
    throws IOException, SQLException
  {
    _il.enter(table.getMetaTable().getName());
    _swGetCell = StopWatch.getInstance();
    _swGetValue = StopWatch.getInstance();
    _swSetValue = StopWatch.getInstance();
    QualifiedId qiTable = new QualifiedId(null,
      table.getParentSchema().getMetaSchema().getName(),
      table.getMetaTable().getName());
    System.out.println("  Table: "+qiTable.format());
    long lRecord = 0;
    RecordRetainer rr = table.createRecords();
    ResultSet rs = openTable(table, null);
    Statement stmt = rs.getStatement();
    StopWatch swCreate = StopWatch.getInstance();
    StopWatch swGet = StopWatch.getInstance();
    StopWatch swPut = StopWatch.getInstance();
    StopWatch sw = StopWatch.getInstance();
  	sw.start();
  	long lBytesStart = rr.getByteCount();

  	Map<String, Long> map = new HashMap<String, Long>();
  	map.put("sourceFileSize", (long) 0);
		map.put("executeTime", (long) 0);
		map.put("fileCount", (long) 0);

		try {

			while(rs.next() && (!cancelRequested()))
	    {
	    	swCreate.start();
	      Record record = rr.create();
	      swCreate.stop();
	      swGet.start();

	      /***
	      if (qiTable.getName().equals("Products") && (lRecord >=4) && (lRecord <= 5))
	      {
	        Cell cell = record.getCell(0);
	        MetaColumn mc = cell.getMetaColumn();
	        System.out.println("start: "+String.valueOf(mc.getMetaFields()));
	      }
	      ***/
	      getRecord(rs,record, map);




	      /***
	      if (qiTable.getName().equals("Products") && (lRecord >=4) && (lRecord <= 5))
	      {
	      	for (int iCell = 0; iCell < record.getCells(); iCell++)
	      	{
	      		Cell cell = record.getCell(iCell);
	      		MetaColumn mc = cell.getMetaColumn();
	    			Object oCell = cell.getObject();
	      		if (mc.getCardinality() > 0)
	      		{
	      			System.out.println(String.valueOf(iCell)+": "+mc.getName()+" "+String.valueOf(oCell)+": "+((oCell == null)?"null":oCell.getClass().getName())+" "+mc.getCardinality());
	      			for (int iElement = 0; iElement < cell.getElements(); iElement++)
	      			{
	      				Field field = cell.getElement(iElement);
	      				Object oField = field.getObject();
	      				System.out.println("  "+String.valueOf(iElement)+" "+String.valueOf(oField));
	      			}
	      		}
	      		else
	      			System.out.println(String.valueOf(iCell)+": "+mc.getName()+" "+String.valueOf(oCell)+": "+((oCell == null)?"null":oCell.getClass().getName()));
	      	}
	    		Cell cell = record.getCell(0);
	        MetaColumn mc = cell.getMetaColumn();
	        System.out.println("stop: "+String.valueOf(mc.getMetaFields()));
	      }
	      ***/
	      swGet.stop();
	      swPut.start();
	      rr.put(record);
	      swPut.stop();
	      lRecord++;
	      if ((lRecord % _lREPORT_RECORDS) == 0)
	      {
	        System.out.println("    Record "+String.valueOf(lRecord)+" ("+sw.formatRate(rr.getByteCount()-lBytesStart,sw.stop())+" kB/s)");
	      	lBytesStart = rr.getByteCount();
	      	sw.start();
	      }
	      incDownloaded();

	    }

		}catch(Exception e) {

		}

/*
		String hms = String.format("%2d:%02d:%02d",
									downtimesum.toHours(),
									downtimesum.toMinutes(),
									(downtimesum.toMillis() / 1000));
		float downavg = 0.0f;
		if(this.downcount > 0)
		{
			downavg = ((this.downsizesum / 1000) / this.downcount);
			파일사이즈 / 1000 / 파일갯수
		}
    System.out.println("    다운로드 총 파일 크기 " + (this.downsizesum / 1000) + "kB,  평균 다운로드 속도 (" +  downavg + " kB/s), 다운로드 시간 " + hms);
*/
    /**
     * 다운로드 총 파일 크기 (KB/S)
     * 평균 다운로드 속도 (KB/s)
     * 다운로드 시간
     * */
    DecimalFormat formatter = new DecimalFormat("###,###");

    /* 파일크기, 수행시간, 파일 수 체크 */
    if(map.get("sourceFileSize") > 0
    		&& map.get("executeTime") > 0
    		&& map.get("fileCount") > 0) {
    	System.out.println("    다운로드 총 파일 크기 " + formatter.format((map.get("sourceFileSize")/1024)) + "KB,  "
    			+ "평균 다운로드 속도 (" + formatter.format(((map.get("sourceFileSize") / map.get("executeTime")) / map.get("fileCount"))) + " KB/s), "
    			+ "다운로드 시간 " + formatter.format(map.get("executeTime")/1000) + "s");
    }

    System.out.println("    Record "+String.valueOf(lRecord)+" ("+sw.formatRate(rr.getByteCount()-lBytesStart,sw.stop())+" kB/s)");
    System.out.println("    Total: "+StopWatch.formatLong(lRecord)+" records ("+StopWatch.formatLong(rr.getByteCount())+" bytes in "+sw.formatMs()+" ms)");
    // System.out.println("    Create: "+swCreate.formatMs()+" ms, Get: "+swGet.formatMs()+" ms, Put: "+swPut.formatMs()+" ms");
    // System.out.println("    Get Cell: "+_swGetCell.formatMs()+" ms, Get Value: "+_swGetValue.formatMs()+" ms, Set Value: "+_swSetValue.formatMs()+" ms");
    if (!rs.isClosed())
      rs.close();
    if (!stmt.isClosed())
      stmt.close();
    rr.close();
    _il.exit();
  } /* getTable */

  /*------------------------------------------------------------------*/
  /** download primary data of a schema.
   * @param schema schema
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  @SuppressWarnings("unchecked")
	private void getSchema(Schema schema, String history_idx)
    throws IOException, SQLException, Exception
  {
  	String schema_name = schema.getMetaSchema().getName();
    _il.enter(schema_name);

		List<String>	list = _archive.getTableCheckedList();
		List<String> schemaSelList = new ArrayList<>(); //특정 스키마 전체 테이블 다운로드 할 스키마 List
		boolean is_table_select	= false;
		if(list != null && list.size() > 0)
		{
		  //스키마와 테이블명에 대한 전체 다운로드
			if(!"all".equals(list.get(0))) {
				is_table_select = true;
			}

		  //특정 스키마 전체 테이블 다운로드 할 스키마 List
			for(int ix = 0; ix < list.size(); ix++)
			{
				String str = list.get(ix);
				if(str.indexOf("*") > -1) {
					schemaSelList.add(str.substring(0, str.indexOf(".")));
				}
			}
		}

		HistoryDAO dao = new HistoryDAO();
		Map<String, String> tableParams = null;
		boolean is_schema_all = false;


			for (int iTable = 0; (iTable < schema.getTables()) && (!cancelRequested()); iTable++)
	    {
	    	try {

	    		try {

			      Table table = schema.getTable(iTable);

			      tableParams = new LinkedHashMap<String, String>();
			      tableParams.put("history_idx", history_idx);
						tableParams.put("table_name", table.getMetaTable().getName());
						tableParams.put("table_column_count", table.getMetaTable().getMetaColumns() + "");
						tableParams.put("table_record_count", table.getMetaTable().getRows() + "");

			      //특정 스키마에 대한 전체 테이블 (*)다운로드 처리
			      if(!is_schema_all && schemaSelList.size() > 0) {
			      	for (int j = 0; j < schemaSelList.size(); j++)
			      	{
			      		if(schema_name.toUpperCase().equals(schemaSelList.get(j).toUpperCase())) {
			      			is_schema_all = true;

			      			schemaSelList.remove(j);
			      			break;
			      		}
			      	}
			      }

			      //테이블 선택 로직
						// 테이블을 명시하면
						// 해당 테이블만 내려 받는다.

			      //테이블에 schema 추가함.
			      String schemaName = "";
			      String tableName = "";

						if(is_table_select && !is_schema_all)
						{
							MetaTable meta_table = table.getMetaTable();

							for(int ix = 0; ix < list.size(); ix++)
							{
								String name = list.get(ix);

								//"."이 없으면 스키마가 없는것으로 간주함.
								if(name.indexOf(".") < 0) {
									throw new IOException("스키마가 없는 테이블이 존재합니다. 테이블(t) 파라미터값 입력 형식은 \"스키마.테이블\"입니다. \n테이블:"+name + "\n스키마 및 테이블에 대한 전체 다운로드 시에서는 \"all\"을 입력해주세요.");
								}

								StringTokenizer st = new StringTokenizer(name, ".");

								int index = 0;
								while (st.hasMoreElements())
			      		{
			      			String parmName = (String) st.nextElement();
			      			if(parmName != null && !parmName.isEmpty()) {
			      				if(index == 0) { //스키마명
			      					schemaName = parmName.trim().toUpperCase();
			      				} else if(index == 1) {//테이블명
			      					tableName = parmName.trim().toUpperCase();
			      				}
			      			}
			      			index++;
			      		}

							  //스키마와 테이블명이 모두 같아야 함.
								if(meta_table.getName().toUpperCase().equals(tableName)
										&& schema_name.toUpperCase().equals(schemaName))
								{
									getTable(table);
									break;
								}
							}
						}
						else
						{
							getTable(table);
						}

						tableParams.put("execute_result", "1");

	    		}catch(Exception e) {
	    			tableParams.put("execute_result", "0");

	    		}

	    		dao.insertHistoryDetail(tableParams);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			}

    _il.exit();
  } /* getSchema */

  /*------------------------------------------------------------------*/
  /** download primary data.
   * @param progress receives progress notifications and sends cancel
   *   requests.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  public void download(Progress progress)
    throws IOException, SQLException
  {
    _il.enter();
    System.out.println("\r\nPrimary Data");

		/* S: SIARD 다운로드 시작 시간 */
		String siardDownloadStartTime = dateToString();
		System.out.println("SIARD Download Start Date : " + siardDownloadStartTime + "\r\n");
		_il.event("SIARD Download Start Date : " + siardDownloadStartTime + "\r\n");
		/* E: SIARD 다운로드 시작 시간 */

    _progress = progress;
    /* determine total number of records in the database */
    _lRecordsTotal = 0;
    for(int iSchema = 0; iSchema < _archive.getSchemas(); iSchema++)
    {
      Schema schema = _archive.getSchema(iSchema);
      for (int iTable = 0; iTable < schema.getTables(); iTable++)
      {
        Table table = schema.getTable(iTable);
        _lRecordsTotal = _lRecordsTotal + table.getMetaTable().getRows();
      }
    }
    _lRecordsPercent = (_lRecordsTotal+99)/100;
    _lRecordsDownloaded = 0;

    String history_idx = "";
    Map<String, String> params = new LinkedHashMap<String, String>();
    HistoryDAO dao = new HistoryDAO();

    	/* now download */
    	for (int iSchema = 0; (iSchema < _archive.getSchemas()) && (!cancelRequested()); iSchema++)
    	{
    		Schema schema = _archive.getSchema(iSchema);

    		try {
    			history_idx = dao.selectMaxHistoryIdx();
    			params.put("history_idx", history_idx);
    			params.put("div", "0001");
    			params.put("db_name", schema.getParentArchive().getMetaData().getDatabaseProduct());
    			params.put("db_con_url", schema.getParentArchive().getMetaData().getConnection());
    			params.put("schema_name", schema.getMetaSchema().getName());
    			params.put("table_count", schema.getMetaSchema().getMetaTables() + "");
    			getSchema(schema, history_idx);
    			params.put("execute_result", "1");
    		}catch(Exception e) {
    			params.put("execute_result", "0");

    		}

    		try { dao.insertHistory(params); }catch(Exception e) {}

    	}

    if (cancelRequested())
      throw new IOException("\r\nDownload of primary data cancelled!");
    System.out.println("\r\nDownload terminated successfully.");

		/* S: SIARD 업로드 종료시간 */
		String siardDownloadEndTime = dateToString();
		System.out.println("SIARD Download End Date : " + siardDownloadEndTime);
		_il.event("SIARD Download End Date : " + siardDownloadEndTime);

		String diffTime = "";

		try
		{
			diffTime = timeDifference(siardDownloadStartTime, siardDownloadEndTime);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}

		System.out.println("총 소요시간 : " + diffTime);
		_il.event("총 소요시간 : " + diffTime);
		/* E: SIARD 업로드 종료시간 */

    _conn.rollback();
    _il.exit();
  } /* download */

  /*------------------------------------------------------------------*/
  /** constructor
   * @param conn database connection.
   * @param archive SIARD archive.
   */
  private PrimaryDataFromDb(Connection conn, Archive archive)
  {
    super(conn,archive,null,true,true,true);
  } /* constructor PrimaryDataTransfer */

  /*------------------------------------------------------------------*/
  /** factory
   * @param conn database connection.
   * @param archive SIARD archive.
   * @return new instance of PrimaryDataFromDb.
   */
  public static PrimaryDataFromDb newInstance(Connection conn, Archive archive)
  {
    return new PrimaryDataFromDb(conn, archive);
  } /* newInstance */

	/* S: 현재시간 조회 */
	private String dateToString()
	{
		String dateToString = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		return dateToString;
	}
	/* E: 현재시간 조회 */


	/* S: 시간비교 */
	public String timeDifference(String startTime, String endTime) throws ParseException
	{
		int		hour = 60 * 60;
		int		minute = 60;

		long	diffHour = 0;
		long	diffMinute = 0;
		long	diffSec = 0;
		long	remainderSec = 0;

		String	result = "";
		String	trimStartTime	= startTime.trim();
		String	trimEndTime = endTime.trim();

		if(trimStartTime == null || trimStartTime == "" || trimEndTime == null || trimEndTime == "")
		{
			return "-초";
		}

		java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date startDate = f.parse(startTime);
		java.util.Date endDate = f.parse(endTime);

		long diffTime	= (endDate.getTime() - startDate.getTime()) / 1000;

		if(diffTime >= hour)
		{
			diffHour = diffTime / hour;
			remainderSec = diffTime % hour;
			diffMinute = remainderSec / minute;
			remainderSec = remainderSec % minute;
			diffSec = remainderSec;

			result = diffHour + "시간 " + diffMinute + "분 " + diffSec + "초";
		}
		else if(diffTime >= minute)
		{
			diffMinute = diffTime / minute;
			remainderSec = diffTime % minute;
			diffSec = remainderSec;

			result = diffMinute + "분 " + diffSec + "초";
		}
		else
		{
			result = diffTime + "초";
		}

		return result;
	}
	/* E: 시간비교 */
} /* class PrimaryDataFromDb */
