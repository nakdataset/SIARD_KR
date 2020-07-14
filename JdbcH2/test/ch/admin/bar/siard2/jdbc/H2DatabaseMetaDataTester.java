package ch.admin.bar.siard2.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.admin.bar.siard2.h2.*;
import ch.admin.bar.siard2.jdbcx.*;
import ch.enterag.utils.*;
import ch.enterag.utils.database.*;
import ch.enterag.utils.jdbc.*;

public class H2DatabaseMetaDataTester extends BaseDatabaseMetaDataTester
{
  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private static final String _sDB_CATALOG = "conn";
  private H2DatabaseMetaData _dmdH2 = null;

  @BeforeClass
  public static void setUpClass()
  {
    try 
    { 
      FU.copy(fileSOURCE_DB, fileTMP_DB);
      FU.copy(fileSOURCE_TRACE, fileTMP_TRACE);
      H2DataSource dsH2 = new H2DataSource();
      dsH2.setUrl(_sDB_URL);
      dsH2.setUser(_sDB_USER);
      dsH2.setPassword(_sDB_PASSWORD);
      H2Connection connH2 = (H2Connection)dsH2.getConnection();
      /* drop and create the test schemas */
      new TestH2Database(connH2);
      new TestSqlDatabase(connH2);
      connH2.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* setUpClass */
  
  @Before
  public void setUp()
  {
    try 
    { 
      H2DataSource dsH2 = new H2DataSource();
      dsH2.setUrl(_sDB_URL);
      dsH2.setUser(_sDB_USER);
      dsH2.setPassword(_sDB_PASSWORD);
      Connection conn = dsH2.getConnection();
      _dmdH2 = (H2DatabaseMetaData)conn.getMetaData();
      setDatabaseMetaData(_dmdH2);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* setUp */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong database meta data class!", H2DatabaseMetaData.class, _dmdH2.getClass());
  } /* testClass */

  @Test
  public void testSchemas()
  {
    enter();
    try 
    { 
      ResultSet rs = _dmdH2.getSchemas();
      if ((rs != null) && (!rs.isClosed()))
      {
        boolean bTestSchemaFound = false;
        while (rs.next())
        {
          String sCatalogName = rs.getString("TABLE_CATALOG");
          String sSchemaName = rs.getString("TABLE_SCHEM");
          if (!_sDB_CATALOG.equalsIgnoreCase(sCatalogName))
            fail("Unexpected catalog: "+sCatalogName);
          if (TestH2Database._sTEST_SCHEMA.equals(sSchemaName))
            bTestSchemaFound = true;
        }
        rs.close();
        if (!bTestSchemaFound)
          fail("Schema "+TestH2Database._sTEST_SCHEMA+" not found!");
      }
      else 
        fail("Invalid schema meta data result set!");
    } 
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSchemas */
  
  @Test
  public void testSchema()
  {
    enter();
    try 
    { 
      ResultSet rs = _dmdH2.getSchemas(null,TestH2Database._sTEST_SCHEMA);
      if ((rs != null) && (!rs.isClosed()))
      {
        boolean bTestSchemaFound = true;
        while (rs.next())
        {
          String sCatalogName = rs.getString("TABLE_CATALOG");
          String sSchemaName = rs.getString("TABLE_SCHEM");
          if (!_sDB_CATALOG.equalsIgnoreCase(sCatalogName))
            fail("Unexpected catalog: "+sCatalogName);
          if (!TestH2Database._sTEST_SCHEMA.equals(sSchemaName))
          {
            System.out.println(sSchemaName);
            bTestSchemaFound = false;
          }
        }
        rs.close();
        if (!bTestSchemaFound)
          fail("Other schema than "+TestH2Database._sTEST_SCHEMA+" found!");
      }
      else 
        fail("Invalid schema meta data result set!");
    } 
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSchema */
  
  @Test
  public void testTable()
  {
    enter();
    try
    {
      ResultSet rs = _dmdH2.getTables(_sDB_CATALOG.toUpperCase(), TestH2Database._sTEST_SCHEMA, "%", new String[]{"TABLE"});
      if ((rs != null) && (!rs.isClosed()))
      {
        boolean bTestTableFound = false;
        while (rs.next())
        {
          String sCatalogName = rs.getString("TABLE_CAT");
          String sSchemaName = rs.getString("TABLE_SCHEM");
          String sTableName = rs.getString("TABLE_NAME");
          String sRemarks = rs.getString("REMARKS");
          if (!_sDB_CATALOG.equalsIgnoreCase(sCatalogName))
            fail("Unexpected catalog: "+sCatalogName);
          if (!TestH2Database._sTEST_SCHEMA.equals(sSchemaName))
            fail("Unexpected schema: "+sSchemaName);
          if (TestH2Database._sTEST_TABLE_SIMPLE.equals(sTableName))
            bTestTableFound = true;
          System.out.println("Found: "+sCatalogName+"."+sSchemaName+"."+sTableName+"\t"+sRemarks+"");
        }
        if (!bTestTableFound)
          fail("Table "+TestH2Database._sTEST_TABLE_SIMPLE+" not found!");
      }
      else 
        fail("Invalid table meta data result set!");
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testTable */

  @Test
  public void testH2Columns()
  {
    enter();
    try
    {
      ResultSet rs = _dmdH2.getColumns(_sDB_CATALOG.toUpperCase(), TestH2Database._sTEST_SCHEMA, TestH2Database._sTEST_TABLE_COMPLEX, "%");
      if ((rs != null) && (!rs.isClosed()))
      {
        while (rs.next())
        {
          String sCatalogName = rs.getString("TABLE_CAT");
          String sSchemaName = rs.getString("TABLE_SCHEM");
          String sTableName = rs.getString("TABLE_NAME");
          String sColumnName = rs.getString("COLUMN_NAME");
          int iDataType = rs.getInt("DATA_TYPE");
          String sTypeName = rs.getString("TYPE_NAME");
          int iColumnSize = rs.getInt("COLUMN_SIZE");
          int iDecimalDigits = rs.getInt("DECIMAL_DIGITS");
          if (!_sDB_CATALOG.toUpperCase().equals(sCatalogName))
            fail("Unexpected catalog: "+sCatalogName);
          if (!TestH2Database._sTEST_SCHEMA.equals(sSchemaName))
            fail("Unexpected schema: "+sSchemaName);
          if (!TestH2Database._sTEST_TABLE_COMPLEX.equals(sTableName))
            fail("Unexpected table: "+sTableName);
          System.out.println(sColumnName + "\t"+SqlTypes.getTypeName(iDataType)+"\t\""+sTypeName+"\"\t"+String.valueOf(iColumnSize)+"\t"+String.valueOf(iDecimalDigits));
        }
      }
      else 
        fail("Invalid column meta data result set!");
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testH2Columns */
  
  @Test
  public void testSqlColumns()
  {
    enter();
    try
    {
      ResultSet rs = _dmdH2.getColumns(_sDB_CATALOG.toUpperCase(), TestSqlDatabase._sTEST_SCHEMA, TestSqlDatabase._sTEST_TABLE_SIMPLE, "%");
      if ((rs != null) && (!rs.isClosed()))
      {
        while (rs.next())
        {
          String sCatalogName = rs.getString("TABLE_CAT");
          String sSchemaName = rs.getString("TABLE_SCHEM");
          String sTableName = rs.getString("TABLE_NAME");
          String sColumnName = rs.getString("COLUMN_NAME");
          int iDataType = rs.getInt("DATA_TYPE");
          String sTypeName = rs.getString("TYPE_NAME");
          int iColumnSize = rs.getInt("COLUMN_SIZE");
          int iDecimalDigits = rs.getInt("DECIMAL_DIGITS");
          if (!_sDB_CATALOG.toUpperCase().equals(sCatalogName))
            fail("Unexpected catalog: "+sCatalogName);
          if (!TestSqlDatabase._sTEST_SCHEMA.equals(sSchemaName))
            fail("Unexpected schema: "+sSchemaName);
          if (!TestSqlDatabase._sTEST_TABLE_SIMPLE.equals(sTableName))
            fail("Unexpected table: "+sTableName);
          System.out.println(sColumnName + "\t"+SqlTypes.getTypeName(iDataType)+"\t\""+sTypeName+"\"\t"+String.valueOf(iColumnSize)+"\t"+String.valueOf(iDecimalDigits));
        }
      }
      else 
        fail("Invalid column meta data result set!");
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSqlColumns */
  
  @Test
  public void testH2Types()
  {
    try
    {
      ResultSet rs = _dmdH2.getColumns(_sDB_CATALOG.toUpperCase(), TestH2Database._sTEST_SCHEMA, TestH2Database._sTEST_TABLE_COMPLEX, "%");
      if ((rs != null) && (!rs.isClosed()))
      {
        while (rs.next())
        {
          String sColumnName = rs.getString("COLUMN_NAME");
          int iDataType = rs.getInt("DATA_TYPE");
          String sTypeName = rs.getString("TYPE_NAME");
          int iColumnSize = rs.getInt("COLUMN_SIZE");
          int iDecimalDigits = rs.getInt("DECIMAL_DIGITS");
          String sRemarks = rs.getString("REMARKS");
          int iOriginalDataType = rs.getInt("SQL_DATA_TYPE");
          System.out.println(sColumnName + "\t"+SqlTypes.getTypeName(iDataType)+"\t\""+sTypeName+"\"\t"+String.valueOf(iColumnSize)+"\t"+String.valueOf(iDecimalDigits)+"\t"+SqlTypes.getTypeName(iOriginalDataType)+"\t\""+String.valueOf(sRemarks)+"\"");
        }
      }
      else 
        fail("Invalid column meta data result set!");
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testH2Types */

  @Test
  public void testSqlTypes()
  {
    try
    {
      ResultSet rs = _dmdH2.getColumns(_sDB_CATALOG.toUpperCase(), TestSqlDatabase._sTEST_SCHEMA, TestSqlDatabase._sTEST_TABLE_SIMPLE, "%");
      if ((rs != null) && (!rs.isClosed()))
      {
        while (rs.next())
        {
          String sColumnName = rs.getString("COLUMN_NAME");
          int iDataType = rs.getInt("DATA_TYPE");
          String sTypeName = rs.getString("TYPE_NAME");
          int iColumnSize = rs.getInt("COLUMN_SIZE");
          int iDecimalDigits = rs.getInt("DECIMAL_DIGITS");
          String sRemarks = rs.getString("REMARKS");
          int iOriginalDataType = rs.getInt("SQL_DATA_TYPE");
          System.out.println(sColumnName + "\t"+SqlTypes.getTypeName(iDataType)+"\t\""+sTypeName+"\"\t"+String.valueOf(iColumnSize)+"\t"+String.valueOf(iDecimalDigits)+"\t"+SqlTypes.getTypeName(iOriginalDataType)+"\t\""+String.valueOf(sRemarks)+"\"");
        }
      }
      else 
        fail("Invalid column meta data result set!");
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSqlTypes */

  @Override
  @Test
  public void testGetPrimaryKeys()
  {
    try
    {
      ResultSet rs = _dmdH2.getPrimaryKeys(_sDB_CATALOG.toUpperCase(), TestSqlDatabase._sTEST_SCHEMA, TestSqlDatabase._sTEST_TABLE_SIMPLE);
      while(rs.next())
      {
        String sCatalog = rs.getString("TABLE_CAT");
        String sSchema = rs.getString("TABLE_SCHEM");
        String sTable = rs.getString("TABLE_NAME");
        String sColumn = rs.getString("COLUMN_NAME");
        int iPosition = rs.getInt("KEY_SEQ");
        String sPkName = rs.getString("PK_NAME");
        assertEquals("Wrong catalog!",_sDB_CATALOG.toUpperCase(),sCatalog);
        assertEquals("Wrong schema!",TestSqlDatabase._sTEST_SCHEMA,sSchema);
        assertEquals("Wrong table!",TestSqlDatabase._sTEST_TABLE_SIMPLE,sTable);
        System.out.println(sPkName+": "+String.valueOf(iPosition)+" "+sColumn);
      }
      rs.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
  
  @Override
  @Test
  public void testGetIndexInfo()
  {
    try
    {
      ResultSet rs = _dmdH2.getIndexInfo(_sDB_CATALOG.toUpperCase(), TestSqlDatabase._sTEST_SCHEMA, TestSqlDatabase._sTEST_TABLE_SIMPLE, true, false);
      while (rs.next())
      {
        String sCatalog = rs.getString("TABLE_CAT");
        String sSchema = rs.getString("TABLE_SCHEM");
        String sTable = rs.getString("TABLE_NAME");
        boolean bNonUnique = rs.getBoolean("NON_UNIQUE");
        String sIndexName = rs.getString("INDEX_NAME");
        int iPosition = rs.getInt("ORDINAL_POSITION");
        String sColumn = rs.getString("COLUMN_NAME");
        assertEquals("Wrong catalog!",_sDB_CATALOG.toUpperCase(),sCatalog);
        assertEquals("Wrong schema!",TestSqlDatabase._sTEST_SCHEMA,sSchema);
        assertEquals("Wrong table!",TestSqlDatabase._sTEST_TABLE_SIMPLE,sTable);
        assertEquals("Wrong uniqueness!",false,bNonUnique);
        System.out.println(sIndexName+": "+String.valueOf(iPosition)+" "+sColumn);
      }
      rs.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
  
  @Test
  @Override
  public void testGetTables()
  {
    enter();
    try { print(_dmdH2.getTables(null, TestSqlDatabase._sTEST_SCHEMA, "%", new String[] {"TABLE"})); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
  @Test
  public void testGetViews()
  {
    enter();
    try { print(_dmdH2.getTables(null, TestSqlDatabase._sTEST_SCHEMA, "%", new String[] {"VIEW"})); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
} /* class H2DatabaseMetaDataTester */
