/*======================================================================
PrimaryDataToDb transfers primary data from SIARD files to databases.
Application : Siard2
Description : PrimaryDataToDb transfers primary data from SIARD files to databases.
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2008
Created    : 01.09.2016, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/
package ch.admin.bar.siard2.cmd;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.Cell;
import ch.admin.bar.siard2.api.Field;
import ch.admin.bar.siard2.api.MetaColumn;
import ch.admin.bar.siard2.api.MetaData;
import ch.admin.bar.siard2.api.MetaField;
import ch.admin.bar.siard2.api.MetaForeignKey;
import ch.admin.bar.siard2.api.MetaSchema;
import ch.admin.bar.siard2.api.MetaTable;
import ch.admin.bar.siard2.api.MetaType;
import ch.admin.bar.siard2.api.MetaUniqueKey;
import ch.admin.bar.siard2.api.Record;
import ch.admin.bar.siard2.api.RecordDispenser;
import ch.admin.bar.siard2.api.Schema;
import ch.admin.bar.siard2.api.Table;
import ch.admin.bar.siard2.api.Value;
import ch.admin.bar.siard2.api.generated.CategoryType;
import ch.enterag.sqlparser.SqlLiterals;
import ch.enterag.sqlparser.identifier.QualifiedId;
import ch.enterag.utils.EU;
import ch.enterag.utils.StopWatch;
import ch.enterag.utils.background.Progress;
import ch.enterag.utils.logging.IndentLogger;

/*====================================================================*/
/** Transfers primary data from SIARD files to databases.
 @author Hartwig Thomas
 */
public class PrimaryDataToDb extends PrimaryDataTransfer
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(PrimaryDataToDb.class.getName());
  private static final int iBUFFER_SIZE = 8192;
  private static final long lCOMMIT_RECORDS = 1000;
  private Progress _progress = null;
  private long _lRecordsUploaded = -1;
  private long _lRecordsTotal = -1;
  private long _lRecordsPercent = -1;

  /*------------------------------------------------------------------*/
  /** increment the number or records uploaded, issuing a notification,
   * when a percent is reached.
   */
  private void incUploaded()
  {
    _lRecordsUploaded++;
    if ((_progress != null) && (_lRecordsTotal > 0) && ((_lRecordsUploaded % _lRecordsPercent) == 0))
    {
      int iPercent = (int)((100*_lRecordsUploaded)/_lRecordsTotal);
      _progress.notifyProgress(iPercent);
    }
  } /* incUploaded */

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

  private void copyFromReaderToWriter(Reader rdr, Writer wr)
    throws IOException
  {
    char[] cbuf = new char[iBUFFER_SIZE];
    for (int iRead = rdr.read(cbuf); iRead != -1; iRead = rdr.read(cbuf))
      wr.write(cbuf,0,iRead);
    rdr.close();
    wr.close();
  } /* copyFromReaderToWriter */

  private void copyFromInputToOutput(InputStream is, OutputStream os)
    throws IOException
  {
    byte[] buf = new byte[iBUFFER_SIZE];
    for (int iRead = is.read(buf); iRead != -1; iRead = is.read(buf))
      os.write(buf,0,iRead);
    is.close();
    os.close();
  } /* copyFromInputToOutput */

  private void freeResources(Set<Object> setResources)
    throws SQLException
  {
    for (Iterator<Object> iterResource = setResources.iterator(); iterResource.hasNext(); )
    {
      Object oResource = iterResource.next();
      if (oResource instanceof Clob)
        ((Clob)oResource).free();
      else if (oResource instanceof NClob)
        ((NClob)oResource).free();
      else if (oResource instanceof SQLXML)
        ((SQLXML)oResource).free();
      else if (oResource instanceof Blob)
        ((Blob)oResource).free();
      else if (oResource instanceof Array)
        ((Array)oResource).free();
    }
  } /* freeResources */

  public void addCandidateKeys(Connection conn, MetaTable mt)
    throws SQLException
  {
    _il.enter(mt.getName());
    if (mt.getMetaCandidateKeys() > 0)
    {
      SchemaMapping sm = _am.getSchemaMapping(mt.getParentMetaSchema().getName());
      TableMapping tm = sm.getTableMapping(mt.getName());
      QualifiedId qiTable = new QualifiedId(null,sm.getMappedSchemaName(),tm.getMappedTableName());
			String tableName = qiTable.format();
			if (_dbms.equals("CUBRID"))
			{
				tableName = tm.getMappedTableName();
				if (!tableName.contains("\""))
				{
					tableName = "\"" + tableName + "\"";
				}
			}
			String sSql = "ALTER TABLE " + tableName;
      for (int iCandidateKey = 0; iCandidateKey < mt.getMetaCandidateKeys(); iCandidateKey++)
      {
        MetaUniqueKey mck = mt.getMetaCandidateKey(iCandidateKey);
        StringBuilder sbSql = new StringBuilder(sSql + " ADD CONSTRAINT " + mck.getName()+" UNIQUE(");
        for (int iColumn = 0; iColumn < mck.getColumns(); iColumn++)
        {
          if (iColumn > 0)
            sbSql.append(",");
          String sMappedColumnName = SqlLiterals.formatId(tm.getMappedColumnName(mck.getColumn(iColumn)));
          if (_dbms.equals("CUBRID"))
					{
						if (!sMappedColumnName.contains("\""))
						{
							sMappedColumnName = "\"" + sMappedColumnName + "\"";
						}
					}
          sbSql.append(sMappedColumnName);
        }
        sbSql.append(")");
        Statement stmt = conn.createStatement();
        stmt.setQueryTimeout(_iQueryTimeoutSeconds);

				/* S: err탭에 PK생성 구문 출력 */
		    System.out.println("\r\n" + sbSql.toString());
		    /* E: err탭에 PK생성 구문 출력 */

        stmt.execute(sbSql.toString());
        stmt.close();
      }
    }
  } /* addCandidateKeys */

  public void addForeignKeys(Connection conn, MetaTable mt)
    throws SQLException
  {
    _il.enter(mt.getName());
    if (mt.getMetaForeignKeys() > 0)
    {
      SchemaMapping sm = _am.getSchemaMapping(mt.getParentMetaSchema().getName());
      TableMapping tm = sm.getTableMapping(mt.getName());
      QualifiedId qiTable = new QualifiedId(null,sm.getMappedSchemaName(),tm.getMappedTableName());
			String sSql;
			String tableName = qiTable.format();
			if (_dbms.equals("CUBRID"))
			{
				tableName = tm.getMappedTableName();
				if (!tableName.contains("\""))
				{
					tableName = "\"" + tableName + "\"";
				}
			}
			sSql = "ALTER TABLE " + tableName;
      for (int iForeignKey = 0; iForeignKey < mt.getMetaForeignKeys(); iForeignKey++)
      {
        MetaForeignKey mfk = mt.getMetaForeignKey(iForeignKey);
				String fkName = mfk.getName();
				StringBuilder sbSql = new StringBuilder(sSql + " ADD CONSTRAINT " + fkName + " FOREIGN KEY(");
        SchemaMapping smReferenced = sm;
        if (mfk.getReferencedSchema() != null)
          smReferenced = _am.getSchemaMapping(mfk.getReferencedSchema());
        TableMapping tmReferenced = smReferenced.getTableMapping(mfk.getReferencedTable());
        QualifiedId qiReferenced = new QualifiedId(null,
          smReferenced.getMappedSchemaName(),tmReferenced.getMappedTableName());
				String rfName = qiReferenced.format();
				if (_dbms.equals("CUBRID"))
				{
					rfName = tmReferenced.getMappedTableName();
					if (!rfName.contains("\""))
					{
						rfName = "\"" + rfName + "\"";
					}
				}
				StringBuilder sbReferences = new StringBuilder(" REFERENCES " + rfName + "(");
        for (int iReference = 0; iReference < mfk.getReferences(); iReference++)
        {
          if (iReference > 0)
          {
            sbSql.append(", ");
            sbReferences.append(", ");
          }
					String fkCol = tm.getMappedColumnName(mfk.getColumn(iReference));
					String rfCol = tmReferenced.getMappedColumnName(mfk.getReferenced(iReference));
					if (_dbms.equals("CUBRID"))
					{
						if (!fkCol.contains("\""))
						{
							fkCol = "\"" + fkCol + "\"";
						}
						if (!rfCol.contains("\""))
						{
							rfCol = "\"" + rfCol + "\"";
						}
					}
					sbSql.append(fkCol);
					sbReferences.append(rfCol);
				}
        sbSql.append(")");
        sbReferences.append(")");
        sbSql.append(sbReferences.toString());
        Statement stmt = conn.createStatement();
        stmt.setQueryTimeout(_iQueryTimeoutSeconds);

				/* S: err탭에 FK생성 구문 출력 */
		    System.out.println("\r\n" + sbSql.toString());
		    /* E: err탭에 FK생성 구문 출력 */

        stmt.execute(sbSql.toString());
        stmt.close();
      }
    }
    _il.exit();
  } /* addForeignKeys */

  private void enableConstraints(MetaSchema ms)
  {
    _il.enter(ms.getName());
    for (int iTable = 0; (iTable < ms.getMetaTables()) && (!cancelRequested()); iTable++)
    {
      MetaTable mt = ms.getMetaTable(iTable);
      try { addCandidateKeys(_conn, mt); }
      catch(SQLException se) { System.err.println(EU.getExceptionMessage(se)); }
      try { addForeignKeys(_conn, mt); }
      catch(SQLException se) { System.err.println(EU.getExceptionMessage(se)); }
    }
    _il.exit();
  }  /* enableConstraints */

  /*------------------------------------------------------------------*/
  /** try to enable all table constraints.
   * displays warnings on failure but continues.
   * (Rationale: DB systems differ too much in constraint handling.)
   */
  private void enableConstraints()
  {
    _il.enter();
    MetaData md = _archive.getMetaData();
    for(int iSchema = 0; iSchema < md.getMetaSchemas(); iSchema++)
    {
      MetaSchema ms = md.getMetaSchema(iSchema);
      enableConstraints(ms);
    }
    _il.exit();
  } /* enableConstraints */

  /*------------------------------------------------------------------*/
  /** return the value of the Cell or Field using an appropriate type.
   * @param value Cell or Field instance.
   * @param conn database connection.
   * @param setResources set of resources that need to be freed after insert.
   * @return JAVA object of appropriate type.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  private Object getValue(Value value, Connection conn, Set<Object> setResources)
    throws IOException, SQLException
  {
    Object o = null;
    if (!value.isNull())
    {
      String sType = null;
      int iDataType = Types.NULL;
      int iCardinality = -1;
      MetaType mt = null;
      if (value instanceof Cell)
      {
        Cell cell = (Cell)value;
        MetaColumn mc = cell.getMetaColumn();
        sType = mc.getType();
        iDataType = mc.getPreType();
        iCardinality = mc.getCardinality();
        mt = mc.getMetaType();
      }
      else if (value instanceof Field)
      {
        Field field = (Field)value;
        MetaField mf = field.getMetaField();
        sType = mf.getType();
        iDataType = mf.getPreType();
        iCardinality = mf.getCardinality();
        mt = mf.getMetaType();
      }
      CategoryType cat = null;
      if (mt != null)
        cat = mt.getCategoryType();
      if (((cat == null) || (cat == CategoryType.DISTINCT)) && (iCardinality < 0))
      {
        switch (iDataType)
        {
          case Types.CHAR:
          case Types.VARCHAR:
            o = value.getString();
            break;
          case Types.NCHAR:
          case Types.NVARCHAR:
            o = value.getString();
            break;
          case Types.BINARY:
          case Types.VARBINARY:
            o = value.getBytes();
            break;
          case Types.BOOLEAN:
            o = value.getBoolean();
            break;
          case Types.SMALLINT:
            o = value.getLong();
            break;
          case Types.INTEGER:
            o = value.getLong();
            break;
          case Types.BIGINT:
            o = new BigDecimal(value.getBigInteger());
            break;
          case Types.DECIMAL:
          case Types.NUMERIC:
            o = value.getBigDecimal();
            break;
          case Types.REAL:
            o = value.getFloat();
            break;
          case Types.FLOAT:
          case Types.DOUBLE:
            o = value.getDouble();
            break;
          case Types.DATE:
            o = value.getDate();
            break;
          case Types.TIME:
            o = value.getTime();
            break;
          case Types.TIMESTAMP:
            o = value.getTimestamp();
            break;
          case Types.OTHER:
            o = value.getDuration();
            break;
          case Types.CLOB:
            Clob clob = conn.createClob();
            copyFromReaderToWriter(value.getReader(),clob.setCharacterStream(1));
            o = clob;
            setResources.add(o);
            break;
          case Types.SQLXML:
            SQLXML sqlxml = conn.createSQLXML();
            copyFromReaderToWriter(value.getReader(),sqlxml.setCharacterStream());
            o = sqlxml;
            setResources.add(o);
            break;
          case Types.NCLOB:
            NClob nclob = conn.createNClob();
            copyFromReaderToWriter(value.getReader(),nclob.setCharacterStream(1));
            o = nclob;
            setResources.add(o);
            break;
          case Types.BLOB:
            Blob blob = conn.createBlob();
            copyFromInputToOutput(value.getInputStream(),blob.setBinaryStream(1));
            o = blob;
            setResources.add(o);
            break;
        } /* switch */
      }
      else if (iCardinality >= 0)
      {
        Object[] aoValues = new Object[value.getElements()];
        // collect values
        for (int iElement = 0; iElement < value.getElements(); iElement++)
        {
          Value valueElement = value.getElement(iElement);
          aoValues[iElement] = getValue(valueElement,conn,setResources);
        }
        o = conn.createArrayOf(sType,aoValues);
        setResources.add(o);
      }
      else if (cat == CategoryType.UDT)
      {
        SchemaMapping sm = _am.getSchemaMapping(mt.getParentMetaSchema().getName());
        QualifiedId qiType = new QualifiedId(null,
          sm.getMappedSchemaName(),
          sm.getMappedTypeName(mt.getName()));
        Object[] aoAttributes = new Object[value.getAttributes()];
        // collect attributes
        for (int iAttribute = 0; iAttribute < value.getAttributes(); iAttribute++)
        {
          Value valueAttribute = value.getAttribute(iAttribute);
          aoAttributes[iAttribute] = getValue(valueAttribute,conn,setResources);
        }
        o = conn.createStruct(qiType.format(), aoAttributes);
        setResources.add(o);
      }
    }
    return o;
  } /* getValue */

  /*------------------------------------------------------------------*/
  /** put primary data from a record to the result set.
   * @param record record to be filled.
   * @param rs result set.
   * @param setResources set of resources that need to be freed after insert.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  private void putRecord(Record record, ResultSet rs,Set<Object> setResources)
    throws IOException, SQLException
  {
    List<Value> listValues = record.getValues(supportsArrays(),supportsUdts());
    ResultSetMetaData rsmd = rs.getMetaData();
    if (rsmd.getColumnCount() != listValues.size())
      throw new IOException("Invalid number of result columns found!");

		/* S: DATA적재 VALUES 로그 출력 사전작업 Array 생성 */
		String[] oValueArr = new String[listValues.size()];
		/* E: DATA적재 VALUES 로그 출력 사전작업 Array 생성 */

    for (int iValue = 0; iValue < listValues.size(); iValue++)
    {
      Value value = listValues.get(iValue);
      if (!value.isNull())
      {
        Object oValue = getValue(value,rs.getStatement().getConnection(),setResources);

				/* S: DATA적재 VALUES 로그 출력 사전작업 Array add column value  */
				oValueArr[iValue] = oValue.toString();
				/* E: DATA적재 VALUES 로그 출력 사전작업 Array add column value  */

        rs.updateObject(iValue+1, oValue);
      } /* if not NULL */
    } /* loop over values */

		/* S: DATA적재 VALUES 로그 출력  */
		String str = "";

		for(int i=0; i<oValueArr.length; i++) {
			if(i == oValueArr.length-1) {
				if(oValueArr[i] != null){
					str += "'" + oValueArr[i] + "'";
				}else{
					str += oValueArr[i];
				}
			}else {
				if(oValueArr[i] != null){
					str += "'" + oValueArr[i] + "',";
				}else{
					str += oValueArr[i] + ",";
				}
			}
		}

		_il.info("Insert before bind parameters : " + str);
		/* E: DATA적재 VALUES 로그 출력  */
	} /* putRecord */

  /*------------------------------------------------------------------*/
  /** upload primary data of a table using a SELECT query for all fields.
   * @param table table.
   * @param sm mapping of names in schema.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  private void putTable(Table table,SchemaMapping sm)
    throws IOException, SQLException
  {
    _il.enter(table);
    MetaTable mt = table.getMetaTable();
    QualifiedId qiTable = new QualifiedId(null,
      mt.getParentMetaSchema().getName(),
      mt.getName());
    System.out.println("  Table: "+qiTable.format());
		_il.info("  Table: " + qiTable.format());
    RecordDispenser rd = table.openRecords();
    ResultSet rs = openTable(table,sm);
    Statement stmt = rs.getStatement();
    Set<Object>setResources = new HashSet<Object>();
    long lRecord = 0;
    Record record = null;
    StopWatch sw = StopWatch.getInstance();
  	sw.start();
  	long lBytesStart = rd.getByteCount();
		//ResultSetMetaData meta = rs.getMetaData();
		//int column_count = meta.getColumnCount();
    while ((lRecord < mt.getRows()) && (!cancelRequested()))
    {
      record = rd.get();
      setResources.clear();
      rs.moveToInsertRow();
      putRecord(record,rs,setResources);
      /***
      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 0; i < rsmd.getColumnCount(); i++)
      {
        Object o = rs.getObject(i+1);
        System.out.println(String.valueOf(i)+". "+rsmd.getColumnName(i+1)+"/"+rsmd.getColumnLabel(i+1)+": "+o.toString());
      }
      ***/
      rs.insertRow();
      freeResources(setResources);
      rs.moveToCurrentRow();
      lRecord++;
      if ((lRecord % lCOMMIT_RECORDS) == 0)
      {
        System.out.println("    Record "+String.valueOf(lRecord)+" ("+sw.formatRate(rd.getByteCount()-lBytesStart,sw.stop())+" kB/s)");
      	lBytesStart = rd.getByteCount();
      	sw.start();
      }
      incUploaded();
    }
    System.out.println("    Record "+String.valueOf(lRecord)+" ("+sw.formatRate(rd.getByteCount()-lBytesStart,sw.stop())+" kB/s)");
    System.out.println("    Total: "+StopWatch.formatLong(lRecord)+" records ("+StopWatch.formatLong(rd.getByteCount())+" bytes in "+sw.formatMs()+" ms)");
    if (!rs.isClosed())
      rs.close();
    if (!stmt.isClosed())
      stmt.close();
    rd.close();
    _conn.commit();
    _il.exit();
  } /* putTable */

  /*------------------------------------------------------------------*/
  /** upload primary data of a schema.
   * @param schema schema
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  private void putSchema(Schema schema)
    throws IOException, SQLException
  {
    MetaSchema ms = schema.getMetaSchema();
    _il.enter(ms.getName());
    SchemaMapping sm = _am.getSchemaMapping(ms.getName());
		String todb = _conn.getMetaData().getDatabaseProductName();
		String ardb = _archive.getMetaData().getDatabaseProduct().substring(0, 6);
    for (int iTable = 0; (iTable < schema.getTables()) && (!cancelRequested()); iTable++)
    {
      Table table = schema.getTable(iTable);
			if (ardb.equals("CUBRID") && !todb.equals("CUBRID"))
			{
				MetaTable mt = table.getMetaTable();
				if (mt.getName().equals("_db_stored_procedure"))
					continue;
				if (mt.getName().equals("db_serial"))
					continue;
			}
      putTable(table,sm);
    }
    _conn.commit();
    _il.exit();
  } /* putSchema */

  /*------------------------------------------------------------------*/
  /** upload primary data.
   * @throws IOException if an I/O error occurred.
   * @throws SQLException if a database error occurred.
   */
  public void upload(Progress progress)
    throws IOException, SQLException
  {
    _il.enter();
    System.out.println("\r\nPrimary Data");

		/* S: SIARD 업로드 시작 시간 */
		String siardUploadStartTime = dateToString();
		System.out.println("SIARD Upload Start Date : " + siardUploadStartTime + "\r\n");
		_il.event("SIARD Upload Start Date : " + siardUploadStartTime + "\r\n");
		/* E: SIARD 업로드 시작 시간 */

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
    _lRecordsUploaded = 0;
    /* now upload */
    for (int iSchema = 0; (iSchema < _archive.getSchemas()) && (!cancelRequested()); iSchema++)
    {
      Schema schema = _archive.getSchema(iSchema);
      putSchema(schema);
    }
    if (!cancelRequested())
      enableConstraints();
    if (cancelRequested())
      throw new IOException("\r\nUpload of primary data cancelled!");
    System.out.println("\r\nUpload terminated successfully.");

		/* S: SIARD 업로드 종료시간 */
		String siardUploadEndTime = dateToString();
		System.out.println("SIARD Upload End Date : " + siardUploadEndTime);
		_il.event("SIARD Upload End Date : " + siardUploadEndTime);

		String diffTime = "";
		try
		{
			diffTime = timeDifference(siardUploadStartTime, siardUploadEndTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		System.out.println("총 소요시간 : " + diffTime);
		_il.event("총 소요시간 : " + diffTime);
	  /* E: SIARD 업로드 종료시간 */

    _conn.commit();
    _il.exit();
  } /* upload */

  /*------------------------------------------------------------------*/
  /** constructor
   * @param conn database connection.
   * @param archive SIARD archive.
   * @param am mapping of names in archive.
   * @param bSupportsArrays true, if database supports Arrays.
   * @param bSupportsDistincts true, if database supports DISTINCTs.
   * @param bSupportsUdts true, if database supports UDTs.
   * @throws SQLException if a database error occurred.
   */
  private PrimaryDataToDb(Connection conn, Archive archive,
    ArchiveMapping am, boolean bSupportsArrays, boolean bSupportsDistincts, boolean bSupportsUdts)
    throws SQLException
  {
    super(conn,archive,am,bSupportsArrays,bSupportsDistincts,bSupportsUdts);
    conn.setAutoCommit(false);
  } /* constructor PrimaryDataTransfer */

  /*------------------------------------------------------------------*/
  /** factory
   * @param conn database connection.
   * @param archive SIARD archive.
   * @param am mapping of names in archive.
   * @param bSupportsArrays true, if database supports Arrays.
   * @param bSupportsDistincts true, if database supports DISTINCTs.
   * @param bSupportsUdts true, if database supports UDTs.
   * @return new instance of PrimaryDataTransfer.
   * @throws SQLException if a database error occurred.
   */
  public static PrimaryDataToDb newInstance(Connection conn, Archive archive,
    ArchiveMapping am, boolean bSupportsArrays, boolean bSupportsDistincts, boolean bSupportsUdts)
    throws SQLException
  {
    return new PrimaryDataToDb(conn, archive, am, bSupportsArrays, bSupportsDistincts, bSupportsUdts);
  } /* newInstance */

	/* S: 현재시간 조회 */
	private String dateToString() {
		String dateToString = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		return dateToString;
	}
	/* E: 현재시간 조회 */

	/* S: 시간비교 */
	public String timeDifference(String startTime, String endTime) throws ParseException {
		int hour = 60*60;
		int minute = 60;
		long diffHour = 0;
		long diffMinute = 0;
		long diffSec = 0;
		long remainderSec = 0;
		String result = "";
		String trimStartTime = startTime.trim();
		String trimEndTime = endTime.trim();

		if(trimStartTime == null || trimStartTime == "" || trimEndTime == null || trimEndTime == "") {
			return "-초";
		}

		java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date startDate = f.parse(startTime);
		java.util.Date endDate = f.parse(endTime);

		long diffTime = (endDate.getTime() - startDate.getTime()) / 1000;

		if(diffTime >= hour) {
			diffHour = diffTime/hour;
			remainderSec = diffTime%hour;
			diffMinute = remainderSec/minute;
			remainderSec = remainderSec%minute;
			diffSec = remainderSec;

			result = diffHour + "시간 " + diffMinute + "분 " + diffSec + "초";
		}else if(diffTime >= minute) {
			diffMinute = diffTime/minute;
			remainderSec = diffTime%minute;
			diffSec = remainderSec;

			result = diffMinute + "분 " + diffSec + "초";
		}else {
			result = diffTime + "초";
		}

		return result;
	}
	/* E: 시간비교 */
} /* class PrimaryDataToDb */
