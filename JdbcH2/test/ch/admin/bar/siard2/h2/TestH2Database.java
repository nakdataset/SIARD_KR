package ch.admin.bar.siard2.h2;

import java.io.*;
import java.math.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import static org.junit.Assert.*;
import ch.enterag.utils.*;
import ch.enterag.utils.uuid.*;
import ch.enterag.utils.base.*;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.identifier.*;

@SuppressWarnings("deprecation")
public class TestH2Database
{
  
  private static class ColumnDefinition extends TestColumnDefinition
  {
    @Override
    public String getValueLiteral()
    {
      String sValueLiteral = SqlLiterals.sNULL;
      if (_oValue != null)
      {
        if (_sType.equals("OTHER"))
          sValueLiteral = SqlLiterals.formatBytesLiteral(SqlLiterals.serialize(_oValue));
        else
        {
          if (_oValue instanceof UUID)
            sValueLiteral = SqlLiterals.formatBytesLiteral(UUIDLE.uuidToBytes((UUID)_oValue));
          else if (_oValue instanceof Byte)
            sValueLiteral = String.valueOf((Byte)_oValue);
          else if (_oValue instanceof List)
          {
            @SuppressWarnings("unchecked")
            List<ColumnDefinition> listCdElements = (List<ColumnDefinition>)_oValue;
            sValueLiteral = "(";
            for (int iElement = 0; iElement < listCdElements.size(); iElement++)
            {
              if (iElement > 0)
                sValueLiteral = sValueLiteral + ",";
              ColumnDefinition cd = listCdElements.get(iElement);
              sValueLiteral = sValueLiteral + cd.getValueLiteral();
            }
            sValueLiteral = sValueLiteral + ")";
          }
          else
            sValueLiteral = super.getValueLiteral();
        }
      }
      return sValueLiteral;
    }
    public ColumnDefinition(String sName, String sType, Object oValue)
    {
      super(sName,sType,oValue);
    }
  } /* ColumnDefinition */
  
  public static final String _sTEST_SCHEMA = "TESTH2SCHEMA";
  public static final String _sTEST_TABLE_SIMPLE = "TH2SIMPLE";
  public static QualifiedId getQualifiedSimpleTable() { return new QualifiedId(null,_sTEST_SCHEMA,_sTEST_TABLE_SIMPLE); }
  public static final String _sTEST_TABLE_COMPLEX = "TH2COMPLEX";
  public static QualifiedId getQualifiedComplexTable() { return new QualifiedId(null,_sTEST_SCHEMA,_sTEST_TABLE_COMPLEX); }
  
  private static List<ColumnDefinition> getListCdSimple()
  {
    List<ColumnDefinition> listCd = new ArrayList<ColumnDefinition>();
    listCd.add(new ColumnDefinition("CLONGVARBINARY_100000","LONGVARBINARY(10000)",TestUtils.getBytes(5000)));
    listCd.add(new ColumnDefinition("CBINARY_255","BINARY(255)",TestUtils.getBytes(254)));
    listCd.add(new ColumnDefinition("CVARBINARY_255","VARBINARY(255)",TestUtils.getBytes(200)));
    listCd.add(new ColumnDefinition("CUUID","UUID",UUID.randomUUID()));
    listCd.add(new ColumnDefinition("CLONGVARCHAR_10000","LONGVARCHAR(10000)",TestUtils.getString(5000)));
    listCd.add(new ColumnDefinition("CCHAR_255","CHAR(255)",TestUtils.getString(253)));
    listCd.add(new ColumnDefinition("CVARCHAR_255","VARCHAR(255)",TestUtils.getString(200)));
    listCd.add(new ColumnDefinition("CVARCHAR_IGNORECASE_255","VARCHAR_IGNORECASE(255)",TestUtils.getString(200)));
    listCd.add(new ColumnDefinition("CNUMERIC_15_5","NUMERIC(15,5)",BigDecimal.valueOf(123456789012345l, 5)));
    listCd.add(new ColumnDefinition("CDECIMAL_15_5","DECIMAL(15,5)",BigDecimal.valueOf(543210987654321l, 5)));
    listCd.add(new ColumnDefinition("CTINYINT","TINYINT",new Byte((byte)64)));
    listCd.add(new ColumnDefinition("CSMALLINT","SMALLINT",new Short((short)31000)));
    listCd.add(new ColumnDefinition("CINTEGER","INTEGER",new Integer(1000000)));
    listCd.add(new ColumnDefinition("CSERIAL","SERIAL",null)); // must be primary key
    listCd.add(new ColumnDefinition("CBIGINT","BIGINT",new Long(8000000000l)));
    listCd.add(new ColumnDefinition("CFLOAT","FLOAT",new Double(Math.PI)));
    listCd.add(new ColumnDefinition("CREAL","REAL",new Float(Math.E)));
    listCd.add(new ColumnDefinition("CDOUBLE","DOUBLE",new Double(-Math.PI)));
    listCd.add(new ColumnDefinition("CBOOLEAN","BOOLEAN",Boolean.FALSE));
    listCd.add(new ColumnDefinition("CDATE","DATE",new Date(2016-1900,4,20)));
    listCd.add(new ColumnDefinition("CTIME","TIME",new Time(15,57,47)));
    listCd.add(new ColumnDefinition("CTIMESTAMP","TIMESTAMP",new Timestamp(2016-1900,4,20,15,57,47,123456789)));
    listCd.add(new ColumnDefinition("COTHER","OTHER",new java.util.Date()));
    listCd.add(new ColumnDefinition("CGEOMETRY","GEOMETRY","LINESTRING (30 10, 10 30, 40 40)"));
    listCd.add(new ColumnDefinition("CBLOB","BLOB",TestUtils.getBytes(500)));
    listCd.add(new ColumnDefinition("CCLOB","CLOB",TestUtils.getString(500)));
    return listCd;
  }
  public static List<ColumnDefinition> _listCdSimple = getListCdSimple();

  private static List<ColumnDefinition> getListCdArray()
  {
    List<ColumnDefinition> listCd = new ArrayList<ColumnDefinition>();
    listCd.add(new ColumnDefinition("CARRAY_4[1]","INTEGER",new Integer(1)));
    listCd.add(new ColumnDefinition("CARRAY_4[2]","INTEGER",new Integer(2)));
    listCd.add(new ColumnDefinition("CARRAY_4[3]","INTEGER",new Integer(3)));
    listCd.add(new ColumnDefinition("CARRAY_4[4]","INTEGER",new Integer(4)));
    return listCd;
  }
  public static List<ColumnDefinition> _listCdArray = getListCdArray();

  private static List<ColumnDefinition> getListCdComplex()
  {
    List<ColumnDefinition> listCd = new ArrayList<ColumnDefinition>();
    listCd.add(new ColumnDefinition("CIDENTITY","IDENTITY",new Long(6174)));
    listCd.add(new ColumnDefinition("CARRAY_4","ARRAY(4)",_listCdArray));
    return listCd;
  }
  public static List<ColumnDefinition> _listCdComplex = getListCdComplex();
  private Connection _conn = null;

  /*------------------------------------------------------------------*/
  private void rollback(String sMessage, SQLException se)
  {
    System.out.println(sMessage+": "+EU.getExceptionMessage(se));
    try { _conn.rollback(); }
    catch(SQLException seRollback) 
    {
      System.err.println("Rollback failed: " +
        EU.getExceptionMessage(seRollback)); 
    }
  } /* rollback */

  /*------------------------------------------------------------------*/
  public TestH2Database(Connection conn)
    throws SQLException
  {
    _conn = conn.unwrap(Connection.class);
    _conn.setAutoCommit(false);
    drop();
    create();
  }

  /*------------------------------------------------------------------*/
  private void drop()
  {
    deleteTables();
    dropTables();
    dropSchema();
  } /* drop */
  
  /*------------------------------------------------------------------*/
  private void deleteTable(QualifiedId qiTable)
  {
    try
    {
      String sSql = "DELETE FROM "+qiTable.format();
      Statement stmt = _conn.createStatement();
      stmt.executeUpdate(sSql);
      stmt.close();
      _conn.commit();
    }
    catch (SQLException se) { rollback("Drop table", se); }
  } /* deleteTable */
  
  /*------------------------------------------------------------------*/
  private void deleteTables()
  {
    deleteTable(getQualifiedSimpleTable());
    deleteTable(getQualifiedComplexTable());
  } /* deleteTables */
  
  /*------------------------------------------------------------------*/
  private void dropTable(QualifiedId qiTable)
  {
    try
    {
      String sSql = "DROP TABLE "+qiTable.format();
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(sSql);
      assertSame("Table drop failed!",0,iResult);
      stmt.close();
      _conn.commit();
    }
    catch (SQLException se) { rollback("Drop table", se); }
  } /* dropTable */
  
  /*------------------------------------------------------------------*/
  private void dropTables()
  {
    dropTable(getQualifiedSimpleTable());
    dropTable(getQualifiedComplexTable());
  } /* dropTables */
  
  /*------------------------------------------------------------------*/
  private void dropSchema()
  {
    try
    {
      String sSql = "DROP SCHEMA "+SqlLiterals.formatId(_sTEST_SCHEMA);
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(sSql);
      assertSame("Schema drop failed!",0,iResult);
      stmt.close();
      _conn.commit();
    }
    catch (SQLException se) { rollback("Drop schema", se); }
  } /* dropSchema */
  
  /*------------------------------------------------------------------*/
  private void create()
    throws SQLException
  {
    createSchema();
    createTables();
    insertTables();
  } /* create */

  /*------------------------------------------------------------------*/
  private void createSchema()
    throws SQLException
  {
    String sSql = "CREATE SCHEMA "+SqlLiterals.formatId(_sTEST_SCHEMA);
    Statement stmt = _conn.createStatement();
    int iResult = stmt.executeUpdate(sSql);
    assertSame("Schema creation failed!",0,iResult);
    stmt.close();
    _conn.commit();
  } /* createSchema */
  
  /*------------------------------------------------------------------*/
  private void createTable(QualifiedId qiTable, List<ColumnDefinition> listCd)
    throws SQLException
  {
    StringBuilder sbSql = new StringBuilder("CREATE TABLE ");
    sbSql.append(qiTable.format());
    sbSql.append("\r\n(\r\n  ");
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      ColumnDefinition cd = listCd.get(iColumn); 
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      sbSql.append(cd.getName());
      sbSql.append(" ");
      sbSql.append(cd.getType());
    }
    sbSql.append("\r\n)");
    Statement stmt = _conn.createStatement();
    int iResult = stmt.executeUpdate(sbSql.toString());
    assertSame("Table creation failed!",0,iResult);
    iResult = stmt.executeUpdate("COMMENT ON COLUMN "+qiTable.format()+"."+SqlLiterals.formatId(listCd.get(0).getName())+
      " IS 'This is a remark on the column'");
    assertSame("Column comment failed!",0,iResult);
    iResult = stmt.executeUpdate("COMMENT ON TABLE "+qiTable.format() +
      " IS 'This is a remark on the table'");
    assertSame("Table comment failed!",0,iResult);
    stmt.close();
    _conn.commit();
  } /* createTable */

  /*------------------------------------------------------------------*/
  public void createTables()
    throws SQLException
  {
      createTable(getQualifiedSimpleTable(),_listCdSimple);
      createTable(getQualifiedComplexTable(),_listCdComplex);
  } /* createTables */

  /*------------------------------------------------------------------*/
  private void insertTable(QualifiedId qiTable, List<ColumnDefinition> listCd)
    throws SQLException
  {
    StringBuilder sbSql = new StringBuilder("INSERT INTO ");
    sbSql.append(qiTable.format());
    sbSql.append("\r\n(\r\n  ");
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      ColumnDefinition cd = listCd.get(iColumn);
      if (cd.getValue() != null)
      {
        if (iColumn > 0)
          sbSql.append(",\r\n  ");
        sbSql.append(listCd.get(iColumn).getName());
      }
    }
    sbSql.append("\r\n)\r\nVALUES\r\n(\r\n  ");
    List<ColumnDefinition> listLob = new ArrayList<ColumnDefinition>();
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      ColumnDefinition cd = listCd.get(iColumn);
      if (cd.getValue() != null)
      {
        if (iColumn > 0)
          sbSql.append(",\r\n  ");
        String sLiteral = cd.getValueLiteral();
        if (sLiteral.length() < 1000)
          sbSql.append(sLiteral);
        else
        {
          sbSql.append("?");
          listLob.add(cd);
        }
      }
    }
    sbSql.append("\r\n)");
    PreparedStatement pstmt = _conn.prepareStatement(sbSql.toString());
    for (int iLob = 0; iLob < listLob.size(); iLob++)
    {
      ColumnDefinition cd = listLob.get(iLob);
      Object oValue = cd.getValue();
      if (oValue instanceof String)
      {
        Reader rdrClob = new StringReader((String)oValue);
        pstmt.setCharacterStream(iLob+1, rdrClob);
      }
      else if (oValue instanceof byte[])
      {
        InputStream isBlob = new ByteArrayInputStream((byte[])oValue);
        pstmt.setBinaryStream(iLob+1, isBlob);
      }
      else if (oValue instanceof Blob)
      {
        Blob blob = (Blob)oValue;
        pstmt.setBinaryStream(iLob+1, blob.getBinaryStream());
      }
      else if (oValue instanceof Clob)
      {
        Clob clob = (Clob)oValue;
        pstmt.setCharacterStream(iLob+1, clob.getCharacterStream());
        
      }
      else if (oValue instanceof NClob)
      {
        NClob nclob = (NClob)oValue;
        pstmt.setCharacterStream(iLob+1, nclob.getCharacterStream());
      }
      else if (oValue instanceof SQLXML)
      {
        SQLXML sqlxml = (SQLXML)oValue;
        pstmt.setCharacterStream(iLob+1, sqlxml.getCharacterStream());
      }
    }
    int iResult = pstmt.executeUpdate();
    assertSame("Table insert failed!",1,iResult);
    pstmt.close();
    _conn.commit();
  } /* insertTable */

  /*------------------------------------------------------------------*/
  public void insertTables()
    throws SQLException
  {
      insertTable(getQualifiedSimpleTable(),_listCdSimple);
      insertTable(getQualifiedComplexTable(),_listCdComplex);
  } /* insertTables */
  
} /* TestDatabase */
