package ch.admin.bar.siard2.jdbc;

import java.io.*;
import java.math.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.xml.datatype.*;
import static org.junit.Assert.*;

import org.junit.*;

import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.utils.uuid.*;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;
import ch.admin.bar.siard2.h2.*;
import ch.admin.bar.siard2.jdbcx.*;

public class H2ResultSetTester
  extends BaseResultSetTester
{
  private static String _sNativeQuerySimple = null;
  private static String _sNativeQueryComplex = null;
  private static String _sSqlQuerySimple = null;
  private static String _sSqlQueryComplex = null;
  static
  {
    StringBuilder sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestH2Database._listCdSimple.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestH2Database._listCdSimple.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestH2Database.getQualifiedSimpleTable().format());
    _sNativeQuerySimple = sbSql.toString();
    
    sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestH2Database._listCdComplex.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestH2Database._listCdComplex.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestH2Database.getQualifiedComplexTable().format());
    _sNativeQueryComplex = sbSql.toString();
    
    sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestSqlDatabase._listCdSimple.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestSqlDatabase._listCdSimple.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestSqlDatabase.getQualifiedSimpleTable().format());
    _sSqlQuerySimple = sbSql.toString();
    
    sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestSqlDatabase._listCdComplex.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestSqlDatabase._listCdComplex.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestSqlDatabase.getQualifiedComplexTable().format());
    _sSqlQueryComplex = sbSql.toString();
  }

  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private SqlFactory _sf = new BaseSqlFactory();

  @SuppressWarnings("deprecation")
  private static List<TestColumnDefinition> getListCdSimple()
  {
    List<TestColumnDefinition> listCdSimple = new ArrayList<TestColumnDefinition>();
    listCdSimple.add(new TestColumnDefinition("CCHAR_5","CHAR(5)","wxyZ"));
    listCdSimple.add(new TestColumnDefinition("CVARCHAR_255","VARCHAR(255)",TestUtils.getString(92)));
    listCdSimple.add(new TestColumnDefinition("CCLOB_2M","CLOB(2M)",TestUtils.getString(1000000)));
    listCdSimple.add(new TestColumnDefinition("CNCHAR_5","NCHAR(5)","Auää"));
    listCdSimple.add(new TestColumnDefinition("CNVARCHAR_127","NCHAR VARYING(127)",TestUtils.getNString(53)));
    listCdSimple.add(new TestColumnDefinition("CNCLOB_1M","NCLOB(1M)",TestUtils.getNString(500000)));
    listCdSimple.add(new TestColumnDefinition("CXML","XML","<a>foöäpwkfèégopàèwerkgv fviodsjv jdsjd idsjidsjsiudojiou operkv &lt; and &amp; ifjeifj</a>"));
    listCdSimple.add(new TestColumnDefinition("CBINARY_5","BINARY(5)",new byte[] {5,-4,3,-2} ));
    listCdSimple.add(new TestColumnDefinition("CVARBINARY_255","VARBINARY(255)",TestUtils.getBytes(76) ));
    listCdSimple.add(new TestColumnDefinition("CBLOB","BLOB",TestUtils.getBytes(500000)));
    listCdSimple.add(new TestColumnDefinition("CNUMERIC_31","NUMERIC(31)",BigInteger.valueOf(987654321098765432l)));
    listCdSimple.add(new TestColumnDefinition("CDECIMAL_15_5","DECIMAL(15,5)",new BigDecimal(BigInteger.valueOf(9876543210987l),5)));
    listCdSimple.add(new TestColumnDefinition("CSMALLINT","SMALLINT",Short.valueOf((short)23000)));
    listCdSimple.add(new TestColumnDefinition("CINTEGER","INTEGER",Integer.valueOf(987654321)));
    listCdSimple.add(new TestColumnDefinition("CBIGINT","BIGINT",Long.valueOf(-987654321098765432l)));
    listCdSimple.add(new TestColumnDefinition("CFLOAT_10","FLOAT(10)",Float.valueOf((float)Math.PI)));
    listCdSimple.add(new TestColumnDefinition("CREAL","REAL",Float.valueOf((float)Math.E)));
    listCdSimple.add(new TestColumnDefinition("CDOUBLE","DOUBLE PRECISION",Double.valueOf(Math.PI)));
    listCdSimple.add(new TestColumnDefinition("CBOOLEAN","BOOLEAN",Boolean.valueOf(false)));
    listCdSimple.add(new TestColumnDefinition("CDATE","DATE",new Date(2016-1900,12,2)));
    listCdSimple.add(new TestColumnDefinition("CTIME","TIME",new Time(14,24,12)));
    listCdSimple.add(new TestColumnDefinition("CTIMESTAMP","TIMESTAMP(9)",new Timestamp(2016-1900,12,2,14,24,12,987654321)));
    listCdSimple.add(new TestColumnDefinition("CINTERVAL_YEAR_2_MONTH","INTERVAL YEAR(2) TO MONTH",new Interval(1,3,6)));
    listCdSimple.add(new TestColumnDefinition("CINTERVAL_DAY_2_SECONDS_6","INTERVAL DAY(2) TO SECOND(6)",new Interval(1,0,17,54,23,123456000l)));
    return listCdSimple;
  }
  public static List<TestColumnDefinition> _listCdSimple = getListCdSimple();

  private static List<TestColumnDefinition> getListCdArray()
  {
    List<TestColumnDefinition> listCd = new ArrayList<TestColumnDefinition>();
    listCd.add(new TestColumnDefinition("CARRAY[1]","VARCHAR(255)","A"));
    listCd.add(new TestColumnDefinition("CARRAY[2]","VARCHAR(255)","BB"));
    listCd.add(new TestColumnDefinition("CARRAY[3]","VARCHAR(255)",null));
    listCd.add(new TestColumnDefinition("CARRAY[4]","VARCHAR(255)","DDDD"));
    return listCd;
  }
  public static List<TestColumnDefinition> _listCdArray = getListCdArray();
  
  private static List<TestColumnDefinition> getListCdComplex()
  {
    List<TestColumnDefinition> listCd = new ArrayList<TestColumnDefinition>();
    listCd.add(new TestColumnDefinition("CID","LONG",Long.valueOf(6174)));
    listCd.add(new TestColumnDefinition("CARRAY","VARCHAR(255) ARRAY[4]",_listCdArray));
    return listCd;
  }
  public static List<TestColumnDefinition> _listCdComplex = getListCdComplex();
  
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
      Connection conn = dsH2.getConnection();
      /* drop and create the test database */
      new TestH2Database(conn);
      new TestSqlDatabase(conn);
      conn.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* setUpClass */
  
  private Connection closeResultSet()
    throws SQLException
  {
    Connection conn = null;
    ResultSet rs = getResultSet();
    if (rs != null)
    {
      if (!rs.isClosed())
      {
        Statement stmt = rs.getStatement();
        rs.close();
        setResultSet(null);
        if (!stmt.isClosed())
        {
          conn = stmt.getConnection();
          stmt.close();
          conn.commit();
        }
      }
    }
    return conn;
  } /* closeResultSet */
  
  private void openResultSet(Connection conn, String sQuery)
    throws SQLException
  {
    closeResultSet();
    Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery(sQuery);
    setResultSet(rs);
    rs.next();
  } /* openResultSet */
  
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
      conn.setAutoCommit(false);
      openResultSet(conn,_sSqlQuerySimple);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUp */
  
  @After
  @Override
  public void tearDown()
 {
    try
    {
      Connection conn = closeResultSet();
      if (conn != null)
      {
        if (!conn.isClosed())
        {
          conn.commit();
          conn.close();
        }
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* tearDown */
  
  private TestColumnDefinition findColumnDefinition(List<TestColumnDefinition> listCd, String sName)
  {
    TestColumnDefinition tcd = null;
    for (Iterator<TestColumnDefinition> iterCd = listCd.iterator(); iterCd.hasNext(); )
    {
      TestColumnDefinition tcdTry = iterCd.next();
      if (sName.equals(tcdTry.getName()))
        tcd = tcdTry;
    }
    return tcd;
  } /* findColumnDefinition */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong result set class!", H2ResultSet.class, getResultSet().getClass());
  } /* testClass */
  
  @Override
  @Test
  public void testIsBeforeFirst()
  {
    enter();
    try { getResultSet().isBeforeFirst(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testIsBeforeFirst */
  
  @Override
  @Test
  public void testIsAfterLast()
  {
    enter();
    try { getResultSet().isAfterLast(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testIsAfterLast */
  
  @Override
  @Test
  public void testIsFirst()
  {
    enter();
    try { getResultSet().isFirst(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testIsFirst */
  
  @Override
  @Test
  public void testIsLast()
  {
    enter();
    try { getResultSet().isLast(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testIsLast */
  
  @Override
  @Test
  public void testBeforeFirst()
  {
    enter();
    try { getResultSet().beforeFirst(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testBeforeFirst */
  
  @Override
  @Test
  public void testAfterLast()
  {
    enter();
    try { getResultSet().afterLast(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testAfterLast */
  
  @Override
  @Test
  public void testAbsolute()
  {
    enter();
    try { getResultSet().absolute(1); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testAbsolute */
  
  @Override
  @Test
  public void testRelative()
  {
    enter();
    try { getResultSet().relative(1); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testRelative */
  
  @Override
  @Test
  public void testPrevious()
  {
    enter();
    try 
    {
      getResultSet().next();
      getResultSet().previous();
    }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testPrevious */
  
  @Override
  @Test
  public void testFirst()
  {
    enter();
    try { getResultSet().first(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { printExceptionMessage(se); }
  } /* testFirst */
  
  @Override
  @Test
  public void testLast()
  {
    enter();
    try { getResultSet().last(); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testLast */
  
  @Test
  public void testSetFetchDirection()
  {
    enter();
    try { getResultSet().setFetchDirection(ResultSet.FETCH_UNKNOWN); }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testSetFetchDirection */

  @Override
  @Test
  public void testFindColumn()
  {
    enter();
    try 
    {
      int iColumn = 1;
      assertEquals("Wrong column found!",getResultSet().findColumn(TestSqlDatabase._listCdSimple.get(iColumn-1).getName()),iColumn); 
    }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testFindColumn */
  
  @Override
  @Test
  public void testGetString()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CVARCHAR_255");
      String s = getResultSet().getString(tcd.getName());
      assertEquals("Invalid String!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetString */
  
  @Override
  @Test
  public void testGetNString()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CNVARCHAR_127");
      String s = getResultSet().getNString(tcd.getName());
      assertEquals("Invalid String!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetNString */
  
  @Override
  @Test
  public void testGetClob()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CCLOB_2M");
      Clob clob = getResultSet().getClob(tcd.getName());
      String s = clob.getSubString(1l,(int)clob.length());
      assertEquals("Invalid Clob!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetClob */
  
  @Override
  @Test
  public void testGetNClob()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CNCLOB_1M");
      NClob nclob = getResultSet().getNClob(tcd.getName());
      String s = nclob.getSubString(1l,(int)nclob.length());
      assertEquals("Invalid NClob!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetNClob */
  
  @Override
  @Test
  public void testGetSqlXml()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CXML");
      SQLXML sqlxml = getResultSet().getSQLXML(tcd.getName());
      String s = sqlxml.getString();
      assertEquals("Invalid SQLXML!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetSqlXml */
  
  @Override
  @Test
  public void testGetBytes()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CVARBINARY_255");
      byte[] buf = getResultSet().getBytes(tcd.getName());
      assertTrue("Invalid byte array!",Arrays.equals((byte[])tcd.getValue(),buf));
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetBytes */
  
  @Override
  @Test
  public void testGetBlob()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CBLOB");
      Blob blob = getResultSet().getBlob(tcd.getName());
      byte[] buf = blob.getBytes(1l,(int)blob.length());
      assertTrue("Invalid Blob!",Arrays.equals((byte[])tcd.getValue(),buf));
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetBlob */
  
  @Override
  @Test
  public void testGetBigDecimal()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDECIMAL_15_5");
      BigDecimal bd = getResultSet().getBigDecimal(tcd.getName());
      assertEquals("Invalid BigDecimal!",(BigDecimal)tcd.getValue(),bd);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetBigDecimal */
  
  @Override
  @Test
  @SuppressWarnings("deprecation")
  public void testGetBigDecimal_Int()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDECIMAL_15_5");
      BigDecimal bd = getResultSet().getBigDecimal(tcd.getName(),3);
      assertEquals("Invalid BigDecimal!",((BigDecimal)tcd.getValue()).setScale(3,RoundingMode.DOWN),bd);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetBigDecimal_String_Int */
  
  @Override
  @Test
  public void testGetByte()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CBOOLEAN");
      byte by = getResultSet().getByte(tcd.getName());
      assertEquals("Invalid byte!",((Boolean)tcd.getValue()).booleanValue()?(byte)1:(byte)0,by);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetByte */

  @Override
  @Test
  public void testGetShort()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CSMALLINT");
      short sh = getResultSet().getShort(tcd.getName());
      assertEquals("Invalid short!",((Short)tcd.getValue()).shortValue(),sh);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetShort */
  
  @Override
  @Test
  public void testGetInt()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CINTEGER");
      int i = getResultSet().getInt(tcd.getName());
      assertEquals("Invalid int!",((Integer)tcd.getValue()).intValue(),i);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetInt */
  
  @Override
  @Test
  public void testGetLong()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CBIGINT");
      long l = getResultSet().getLong(tcd.getName());
      assertEquals("Invalid long!",((Long)tcd.getValue()).longValue(),l);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetLong */
  
  @Override
  @Test
  public void testGetFloat()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CREAL");
      float f = getResultSet().getFloat(tcd.getName());
      assertEquals("Invalid float!",(Float)tcd.getValue(),Float.valueOf(f));
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetFloat */
  
  @Override
  @Test
  public void testGetDouble()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDOUBLE");
      double d = getResultSet().getDouble(tcd.getName());
      assertEquals("Invalid double!",(Double)tcd.getValue(),Double.valueOf(d));
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetDouble */
  
  @Override
  @Test
  public void testGetBoolean()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CBOOLEAN");
      boolean b = getResultSet().getBoolean(tcd.getName());
      assertEquals("Invalid boolean!",((Boolean)tcd.getValue()).booleanValue(),b);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetBoolean */
  
  @Override
  @Test
  public void testGetDate()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDATE");
      Date date = getResultSet().getDate(tcd.getName());
      assertEquals("Invalid Date!",(Date)tcd.getValue(),date);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetDate */
  
  @Override
  @Test
  public void testGetDate_Calendar()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDATE");
      Calendar cal = new GregorianCalendar();
      Date date = getResultSet().getDate(tcd.getName(),cal);
      assertEquals("Invalid Date!",(Date)tcd.getValue(),date);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetDate_Calendar */
  
  @Override
  @Test
  public void testGetTime()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CTIME");
      Time time = getResultSet().getTime(tcd.getName());
      assertEquals("Invalid Time!",(Time)tcd.getValue(),time);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetTime */
  
  @Override
  @Test
  public void testGetTime_Calendar()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CTIME");
      Calendar cal = new GregorianCalendar();
      Time time = getResultSet().getTime(tcd.getName(),cal);
      assertEquals("Invalid Time!",(Time)tcd.getValue(),time);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetTime_Calendar */
  
  @Override
  @Test
  public void testGetTimestamp()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CTIMESTAMP");
      Timestamp ts = getResultSet().getTimestamp(tcd.getName());
      assertEquals("Invalid Timestamp!",(Timestamp)tcd.getValue(),ts);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetTimestamp */

  @Override
  @Test
  public void testGetTimestamp_Calendar()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CTIMESTAMP");
      Calendar cal = new GregorianCalendar();
      Timestamp ts = getResultSet().getTimestamp(tcd.getName(),cal);
      assertEquals("Invalid Timestamp!",(Timestamp)tcd.getValue(),ts);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetTimestamp_Calendar */
  
  @Override
  @Test
  public void testGetDuration()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CINTERVAL_YEAR_2_MONTH");
      Duration duration = getBaseResultSet().getDuration(tcd.getName());
      assertEquals("Invalid Timestamp!",((Interval)tcd.getValue()).toDuration(),duration);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetDuration */

  @Override
  @Test
  public void testGetAsciiStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CVARCHAR_255");
      InputStream is = getResultSet().getAsciiStream(tcd.getName());
      byte[] buf = new byte[((String)tcd.getValue()).length()];
      is.read(buf);
      if (is.read() != -1)
        fail("Invalid length of ASCII stream!");
      is.close();
      String s = new String(buf);
      assertEquals("Invalid String!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* testGetAsciiStream */

  @Override
  @Test
  @SuppressWarnings("deprecation")
  public void testGetUnicodeStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CNVARCHAR_127");
      Reader rdr = new InputStreamReader(getResultSet().getUnicodeStream(tcd.getName()),SU.sUTF8_CHARSET_NAME);
      char[] cbuf = new char[((String)tcd.getValue()).length()];
      rdr.read(cbuf);
      if (rdr.read() != -1)
        fail("Invalid length of character stream!");
      rdr.close();
      String s = new String(cbuf);
      assertEquals("Invalid String!",(String)tcd.getValue(),s);
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* testGetUnicodeStream */
  
  @Override
  @Test
  public void testGetCharacterStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CVARCHAR_255");
      Reader rdr = getResultSet().getCharacterStream(tcd.getName());
      char[] cbuf = new char[((String)tcd.getValue()).length()];
      rdr.read(cbuf);
      if (rdr.read() != -1)
        fail("Invalid length of character stream!");
      rdr.close();
      String s = new String(cbuf);
      assertEquals("Invalid String!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* testGetCharacterStream */
  
  @Override
  @Test
  public void testGetNCharacterStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CNVARCHAR_127");
      Reader rdr = getResultSet().getNCharacterStream(tcd.getName());
      char[] cbuf = new char[((String)tcd.getValue()).length()];
      rdr.read(cbuf);
      if (rdr.read() != -1)
        fail("Invalid length of character stream!");
      rdr.close();
      String s = new String(cbuf);
      assertEquals("Invalid String!",(String)tcd.getValue(),s);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* testGetNCharacterStream */
  
  @Override
  @Test
  public void testGetBinaryStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CVARBINARY_255");
      InputStream is = getResultSet().getBinaryStream(tcd.getName());
      byte[] buf = new byte[((byte[])tcd.getValue()).length];
      is.read(buf);
      if (is.read() != -1)
        fail("Invalid length of binary stream!");
      is.close();
      assertTrue("Invalid byte array!",Arrays.equals((byte[])tcd.getValue(),buf));
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* testGetBinaryStream */
  
  @Test
  @Override
  public void testGetArray()
  {
    enter();
    try 
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdComplex,"CARRAY");
      String sBaseType = null;
      @SuppressWarnings("unchecked")
      List<TestColumnDefinition> listElements = (List<TestColumnDefinition>)tcd.getValue();
      for (int iElement = 0; iElement < listElements.size(); iElement++)
      {
        TestColumnDefinition tcdElement = listElements.get(iElement);
        if (sBaseType == null)
          sBaseType = tcdElement.getType();
        else
        {
          if (!sBaseType.equals(tcdElement.getType()))
            fail("The elements of an array do not all have the same type!");
        }
      }
      PredefinedType pt = _sf.newPredefinedType();
      pt.parse(sBaseType);
      Array array = getResultSet().getArray(tcd.getName());
      assertEquals("Array of "+sBaseType+" expected!",array.getBaseType(),pt.getType().getSqlType());
      Object[] aoElements = (Object[])array.getArray();
      assertEquals("Unexpected array length!",listElements.size(),aoElements.length);
      for (int iElement = 0; iElement < aoElements.length; iElement++)
      {
        TestColumnDefinition tcdElement = listElements.get(iElement);
        Object oElement = aoElements[iElement];
        assertEquals("Invalid value of array element!",tcdElement.getValue(),oElement);
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetArray */
  
  @Override
  @Test
  public void testGetRef()
  {
  } /* testGetRef */
  
  @Override
  @Test
  public void testGetRowId()
  {
  } /* testGetRowId */
  
  @Override
  @Test
  public void testGetUrl()
  {
  } /* testGetUrl */
  
  @Override
  @Test
  public void testGetObject()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDATE");
      Object o = getResultSet().getObject(tcd.getName());
      assertEquals("Invalid Date!",tcd.getValue(),o);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObject */

  @Override
  @Test
  public void testGetObject_Class()
  {
    enter();
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDATE");
      Date date = getResultSet().getObject(tcd.getName(),Date.class);
      assertEquals("Invalid Date!",(Date)tcd.getValue(),date);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObject_Class */
  
  @Override
  @Test
  public void testGetObject_Map()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        TestSqlDatabase._listCdSimple,"CDATE");
      Map<String,Class<?>> map = new HashMap<String,Class<?>>();
      map.put(tcd.getType(), tcd.getValue().getClass());
      Object o = getResultSet().getObject(tcd.getName(),map);
      assertEquals("Invalid Date!",tcd.getValue(),o);
    }
    catch(SQLFeatureNotSupportedException snse) { System.out.println(EU.getExceptionMessage(snse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObject_Map */
  
  @Test
  public void testGetObjectSqlSimple()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQuerySimple);
      for (int iColumn = 0; iColumn < TestSqlDatabase._listCdSimple.size(); iColumn++)
      {
        TestColumnDefinition tcd = TestSqlDatabase._listCdSimple.get(iColumn);
        Object o = getResultSet().getObject(tcd.getName());
        if (tcd.getName().equals("CCHAR_5") ||
            tcd.getName().equals("CNCHAR_5"))
        {
          if (o instanceof String)
          {
            String s = (String)o;
            s = s.substring(0,((String)tcd.getValue()).length());
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),s);
          }
          else
            fail("Type String expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CVARCHAR_255") ||
          tcd.getName().equals("CNVARCHAR_127"))
        {
          if (o instanceof String)
          {
            String s = (String)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),s);
          }
          else
            fail("Type String expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CCLOB_2M") ||
          tcd.getName().equals("CNCLOB_1M"))
        {
          if (o instanceof Clob)
          {
            Clob clob = (Clob)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),clob.getSubString(1l,(int)clob.length()));
          }
          else
            fail("Type Clob expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CXML"))
        {
          if (o instanceof SQLXML)
          {
            SQLXML sqlxml = (SQLXML)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(String)tcd.getValue(),sqlxml.getString());
          }
          else if (o instanceof Clob)
          {
            Clob clob = (Clob)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(String)tcd.getValue(),clob.getSubString(1l,(int)clob.length()));
          }
          else
            fail("Type SQLXML or Clob expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBINARY_5"))
        {
          if (o instanceof byte[])
          {
            byte[] buf = (byte[])o;
            buf = Arrays.copyOf(buf, ((byte[])tcd.getValue()).length);
            assertTrue("Invalid value for "+tcd.getType()+"!",Arrays.equals((byte[])tcd.getValue(), buf));
          }
          else
            fail("Type byte[] expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CVARBINARY_255"))
        {
          if (o instanceof byte[])
          {
            byte[] buf = (byte[])o;
            assertTrue("Invalid value for "+tcd.getType()+"!",Arrays.equals((byte[])tcd.getValue(), buf));
          }
          else
            fail("Type byte[] expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBLOB"))
        {
          if ( o instanceof Blob)
          {
            Blob blob = (Blob)o;
            assertTrue("Invalid value for "+tcd.getType()+"!",Arrays.equals((byte[])tcd.getValue(),blob.getBytes(1l,(int)blob.length())));
          }
          else
            fail("Type Blob expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CDECIMAL_15_5") ||
          tcd.getName().equals("CNUMERIC_31"))
        {
          if (o instanceof BigDecimal)
          {
            BigDecimal bd = (BigDecimal)o;
            Object oExpected = tcd.getValue();
            if (oExpected instanceof BigDecimal)
            {
              BigDecimal bdExpected = (BigDecimal)o;
              assertEquals("Invalid value for "+tcd.getType()+"!",bdExpected,bd);
            }
            else if (oExpected instanceof BigInteger)
            {
              BigInteger biExpected = (BigInteger)oExpected;
              BigInteger bi = bd.toBigInteger();
              assertEquals("Invalid value for "+tcd.getType()+"!",biExpected,bi);
            }
          }
          else
            fail("Type BigDecimal expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CSMALLINT"))
        {
          if (o instanceof Short)
          {
            Short sh = (Short)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Short)tcd.getValue(),sh);
          }
          else
            fail("Type Short expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CINTEGER"))
        {
          if (o instanceof Integer)
          {
            Integer i = (Integer)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Integer)tcd.getValue(),i);
          }
          else
            fail("Type Integer expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBIGINT"))
        {
          if (o instanceof Long)
          {
            Long l = (Long)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Long)tcd.getValue(),l);
          }
          else
            fail("Type Long expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CREAL") ||
                 tcd.getName().equals("CFLOAT_10"))
        {
          if (o instanceof Float)
          {
            Float f = (Float)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Float)tcd.getValue(),f);
          }
          else if (o instanceof Double)
          {
            Float f = Float.valueOf(((Double)o).floatValue());
            assertEquals("Invalid value for "+tcd.getType()+"!",(Float)tcd.getValue(),f);
          }
          else
            fail("Type Float or Double expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CDOUBLE"))
        {
          if (o instanceof Double)
          {
            Double d = (Double)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),d);
          }
          else
            fail("Type Double expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBOOLEAN"))
        {
          if (o instanceof Short)
          {
            Short sh = (Short)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Boolean)tcd.getValue(),Boolean.valueOf(sh != 0));
          }
        }
        else if (tcd.getName().equals("CDATE"))
        {
          if (o instanceof Date)
          {
            Date date = (Date)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Date)tcd.getValue(),date);
          }
          else
            fail("Type Date expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CTIME"))
        {
          if (o instanceof Time)
          {
            Time time = (Time)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Time)tcd.getValue(),time);
          }
          else
            fail("Type Time expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CTIMESTAMP"))
        {
          if (o instanceof Timestamp)
          {
            Timestamp ts = (Timestamp)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Timestamp)tcd.getValue(),ts);
          }
          else
            fail("Type Timestamp expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CINTERVAL_YEAR_2_MONTH"))
        {
          if (o instanceof Duration)
          {
            Duration duration = (Duration)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",((Interval)tcd.getValue()).toDuration(),duration);
          }
          else
            fail("Type Duration expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CINTERVAL_DAY_2_SECONDS_6"))
        {
          if (o instanceof Duration)
          {
            Duration duration = (Duration)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",((Interval)tcd.getValue()).toDuration(),duration);
          }
          else
            fail("Type Duration expected for "+tcd.getType()+"!");
        }
        else
          fail("Unexpected column: "+tcd.getName()+"!");
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObjectSqlSimple */
  
  @Test
  public void testGetObjectNativeSimple()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sNativeQuerySimple);
      for (int iColumn = 0; iColumn < TestH2Database._listCdSimple.size(); iColumn++)
      {
        TestColumnDefinition tcd = TestH2Database._listCdSimple.get(iColumn);
        Object o = getResultSet().getObject(tcd.getName());
        if (tcd.getName().equals("CCHAR_255"))
        {
          if (o instanceof String)
          {
            String s = (String)o;
            s = s.substring(0,((String)tcd.getValue()).length());
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),s);
          }
          else
            fail("Type String expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CVARCHAR_255") ||
                 tcd.getName().equals("CVARCHAR_IGNORECASE_255") ||
                 tcd.getName().equals("CLONGVARCHAR_10000"))
        {
          if (o instanceof String)
          {
            String s = (String)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),s);
          }
          else
            fail("Type String expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CCLOB"))
        {
          if (o instanceof Clob)
          {
            Clob clob = (Clob)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),clob.getSubString(1l,(int)clob.length()));
          }
          else
            fail("Type Clob expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CUUID"))
        {
          if (o instanceof byte[])
          {
            byte[] buf = (byte[])o;
            UUID uuid = UUIDLE.uuidFromBytes(buf);
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),uuid);
          }
          else
            fail("Type byte[] expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBINARY_255"))
        {
          if (o instanceof byte[])
          {
            byte[] buf = (byte[])o;
            buf = Arrays.copyOf(buf, ((byte[])tcd.getValue()).length);
            assertTrue("Invalid value for "+tcd.getType()+"!",Arrays.equals((byte[])tcd.getValue(), buf));
          }
          else
            fail("Type byte[] expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CVARBINARY_255") ||
                 tcd.getName().equals("CLONGVARBINARY_100000"))
        {
          if (o instanceof byte[])
          {
            byte[] buf = (byte[])o;
            assertTrue("Invalid value for "+tcd.getType()+"!",Arrays.equals((byte[])tcd.getValue(), buf));
          }
          else
            fail("Type byte[] expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBLOB"))
        {
          if (o instanceof Blob)
          {
            Blob blob = (Blob)o;
            assertTrue("Invalid value for "+tcd.getType()+"!",Arrays.equals((byte[])tcd.getValue(),blob.getBytes(1l,(int)blob.length())));
          }
          else
            fail("Type Blob expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CTINYINT"))
        {
          if (o instanceof Byte)
          {
            Byte by = (Byte)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Byte)tcd.getValue(),by);
          }
          else
            fail("Type Byte expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CSMALLINT"))
        {
          if (o instanceof Short)
          {
            Short sh = (Short)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Short)tcd.getValue(),sh);
          }
          else
            fail("Type Short expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CINTEGER") ||
                 tcd.getName().equals("CSERIAL"))
        {
          if (o instanceof Integer)
          {
            Integer i = (Integer)o;
            if (tcd.getValue() != null)
              assertEquals("Invalid value for "+tcd.getType()+"!",(Integer)tcd.getValue(),i);
            else
              System.out.println(tcd.getName()+": "+String.valueOf(i.intValue()));
          }
          else
            fail("Type Integer expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBIGINT"))
        {
          if (o instanceof Long)
          {
            Long l = (Long)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Long)tcd.getValue(),l);
          }
          else
            fail("Type Long expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CDECIMAL_15_5") ||
                 tcd.getName().equals("CNUMERIC_15_5"))
        {
          if (o instanceof BigDecimal)
          {
            BigDecimal bd = (BigDecimal)o;
            Object oExpected = tcd.getValue();
            if (oExpected instanceof BigDecimal)
            {
              BigDecimal bdExpected = (BigDecimal)o;
              assertEquals("Invalid value for "+tcd.getType()+"!",bdExpected,bd);
            }
            else if (oExpected instanceof BigInteger)
            {
              BigInteger biExpected = (BigInteger)oExpected;
              BigInteger bi = bd.toBigInteger();
              assertEquals("Invalid value for "+tcd.getType()+"!",biExpected,bi);
            }
            else if (oExpected instanceof Double)
            {
              Double dExpected = (Double)oExpected;
              Double d = Double.valueOf(bd.doubleValue());
              assertEquals("Invalid value for "+tcd.getType()+"!",dExpected,d);
            }
          }
          else
            fail("Type BigDecimal expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CREAL"))
        {
          if (o instanceof Float)
          {
            Float f = (Float)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Float)tcd.getValue(),f);
          }
          else
            fail("Type Float expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CDOUBLE") ||
                (tcd.getName().equals("CFLOAT")))
        {
          if (o instanceof Double)
          {
            Double d = (Double)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Double)tcd.getValue(),d);
          }
          else
            fail("Type Double expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CBOOLEAN"))
        {
          if (o instanceof Short)
          {
            Short sh = (Short)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Boolean)tcd.getValue(),Boolean.valueOf(sh != 0));
          }
        }
        else if (tcd.getName().equals("CDATE"))
        {
          if (o instanceof Date)
          {
            Date date = (Date)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Date)tcd.getValue(),date);
          }
          else
            fail("Type Date expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CTIME"))
        {
          if (o instanceof Time)
          {
            Time time = (Time)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Time)tcd.getValue(),time);
          }
          else
            fail("Type Time expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CTIMESTAMP"))
        {
          if (o instanceof Timestamp)
          {
            Timestamp ts = (Timestamp)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Timestamp)tcd.getValue(),ts);
          }
          else
            fail("Type Timestamp expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CGEOMETRY"))
        {
          if (o instanceof String)
          {
            String s = (String)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),s);
          }
          else
            fail("Type String expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("COTHER"))
        {
          if (o instanceof Blob)
          {
            Blob blob = (Blob)o;
            o = SqlLiterals.deserializeObject(blob.getBytes(1l, (int)blob.length()));
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),o);
          }
          else
            fail("Type Blob expected for "+tcd.getType()+"!");
        }
        else
          fail("Unexpected column: "+tcd.getName()+"!");
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObjectNativeSimple */

  private boolean equalsArrayValue(Array array, List<TestColumnDefinition> listElements)
    throws SQLException
  {
    boolean bEqual = true;
    Object[] aoElements = (Object[])array.getArray();
    if (aoElements.length == listElements.size())
    {
      for (int iElement = 0; bEqual && (iElement < aoElements.length); iElement++)
      {
        Object oElement = aoElements[iElement];
        TestColumnDefinition tcdElement = listElements.get(iElement);
        if (oElement != null)
          bEqual = oElement.equals(tcdElement.getValue());
        else
        {
          if (tcdElement.getValue() != null)
            bEqual = false;
        }
      }
    }
    else
      bEqual = false;
    return bEqual;
  } /* equalsArrayValue */
  
  @Test
  public void testGetObjectSqlComplex()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      for (int iColumn = 0; iColumn < TestSqlDatabase._listCdComplex.size(); iColumn++)
      {
        TestColumnDefinition tcd = TestSqlDatabase._listCdComplex.get(iColumn);
        Object o = getResultSet().getObject(tcd.getName());
        if (tcd.getName().equals("CID"))
        {
          if (o instanceof Long)
          {
            Long l = (Long)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",(Long)tcd.getValue(),l);
          }
          else
            fail("Type Long expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CARRAY"))
        {
          if (o instanceof Array)
          {
            Array array = (Array)o;
            @SuppressWarnings("unchecked")
            List<TestColumnDefinition> listElements = (List<TestColumnDefinition>)tcd.getValue();
            assertTrue("Invalid value for "+tcd.getType()+"!",equalsArrayValue(array,listElements));
          }
          else
            fail("Type Array expected for "+tcd.getType()+"!");
        }
        else
          fail("Unexpected column: "+tcd.getName()+"!");
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObjectNativeComplex */
  
  @Test
  public void testGetObjectNativeComplex()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sNativeQueryComplex);
      for (int iColumn = 0; iColumn < TestH2Database._listCdComplex.size(); iColumn++)
      {
        TestColumnDefinition tcd = TestH2Database._listCdComplex.get(iColumn);
        Object o = getResultSet().getObject(tcd.getName());
        if (tcd.getName().equals("CIDENTITY"))
        {
          if (o instanceof Long)
          {
            Long l = (Long)o;
            assertEquals("Invalid value for "+tcd.getType()+"!",tcd.getValue(),l);
          }
          else
            fail("Type Integer expected for "+tcd.getType()+"!");
        }
        else if (tcd.getName().equals("CARRAY_4"))
        {
          if (o instanceof Array)
          {
            Array array = (Array)o;
            @SuppressWarnings("unchecked")
            List<TestColumnDefinition> listElements = (List<TestColumnDefinition>)tcd.getValue();
            assertTrue("Invalid value for "+tcd.getType()+"!",equalsArrayValue(array,listElements));
          }
          else
            fail("Type Array expected for "+tcd.getType()+"!");
        }
        else
          fail("Unexpected column: "+tcd.getName()+"!");
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetObjectNativeComplex */

  @Override
  @Test
  public void testUpdateString()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      getResultSet().updateString(tcd.getName(),(String)tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateString */
  
  @Override
  @Test
  public void testUpdateNString()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNVARCHAR_127");
      getResultSet().updateNString(tcd.getName(),(String)tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNString */
  
  @Override
  @Test
  public void testUpdateClob()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CCLOB_2M");
      Clob clob = getResultSet().getStatement().getConnection().createClob();
      clob.setString(1l,(String)tcd.getValue());
      getResultSet().updateClob(tcd.getName(),clob);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateClob */

  @Override
  @Test
  public void testUpdateClob_Reader()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CCLOB_2M");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateClob(tcd.getName(),rdr);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateClob_Reader */
  
  @Override
  @Test
  public void testUpdateClob_Reader_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CCLOB_2M");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateClob(tcd.getName(),rdr,((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateClob_Reader_Long */
  
  @Override
  @Test
  public void testUpdateNClob()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNCLOB_1M");
      NClob nclob = getResultSet().getStatement().getConnection().createNClob();
      nclob.setString(1l, (String)tcd.getValue());
      getResultSet().updateNClob(tcd.getName(),nclob);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNClob */
  
  @Override
  @Test
  public void testUpdateNClob_Reader()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNCLOB_1M");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateNClob(tcd.getName(),rdr);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNClob_Reader */
  
  @Override
  @Test
  public void testUpdateNClob_Reader_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNCLOB_1M");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateNClob(tcd.getName(),rdr,((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNClob_Reader_Long */
  
  
  @Override
  @Test
  public void testUpdateSqlXml()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CXML");
      SQLXML sqlxml = getResultSet().getStatement().getConnection().createSQLXML();
      sqlxml.setString((String)tcd.getValue());
      getResultSet().updateSQLXML(tcd.getName(),sqlxml);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateSqlXml */
  
  @Override
  @Test
  public void testUpdateBytes()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARBINARY_255");
      getResultSet().updateBytes(tcd.getName(),(byte[])tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBytes */
  
  @Override
  @Test
  public void testUpdateBlob()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CBLOB");
      Blob blob = getResultSet().getStatement().getConnection().createBlob();
      blob.setBytes(1, (byte[])tcd.getValue());
      getResultSet().updateBlob(tcd.getName(),blob);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBlob */

  @Override
  @Test
  public void testUpdateBlob_InputStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CBLOB");
      InputStream is = new ByteArrayInputStream((byte[])tcd.getValue());
      getResultSet().updateBlob(tcd.getName(),is);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBlob_InputStream */
  
  @Override
  @Test
  public void testUpdateBlob_InputStream_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CBLOB");
      InputStream is = new ByteArrayInputStream((byte[])tcd.getValue());
      getResultSet().updateBlob(tcd.getName(),is,((byte[])tcd.getValue()).length);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBlob_String_InputStream_Long */
  
  @Override
  @Test
  public void testUpdateBigDecimal()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CDECIMAL_15_5");
      getResultSet().updateBigDecimal(tcd.getName(),(BigDecimal)tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBigDecimal */
  
  @Override
  @Test
  public void testUpdateByte()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CBOOLEAN");
      getResultSet().updateByte(tcd.getName(),((Boolean)tcd.getValue()).booleanValue()?(byte)1:(byte)0);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateByte */
  
  @Override
  @Test
  public void testUpdateShort()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CSMALLINT");
      getResultSet().updateShort(tcd.getName(),((Short)tcd.getValue()).shortValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateShort */
  
  @Override
  @Test
  public void testUpdateInt()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CINTEGER");
      getResultSet().updateInt(tcd.getName(),((Integer)tcd.getValue()).intValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateInt */
  
  @Override
  @Test
  public void testUpdateLong()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(_listCdSimple,"CBIGINT");
      getResultSet().updateLong(tcd.getName(),((Long)tcd.getValue()).longValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateLong */
  
  @Override
  @Test
  public void testUpdateFloat()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CREAL");
      getResultSet().updateFloat(tcd.getName(),((Float)tcd.getValue()).floatValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateFloat */
  
  @Override
  @Test
  public void testUpdateDouble()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CDOUBLE");
      getResultSet().updateDouble(tcd.getName(),((Double)tcd.getValue()).doubleValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateDouble */
  
  @Override
  @Test
  public void testUpdateBoolean()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CBOOLEAN");
      getResultSet().updateBoolean(tcd.getName(),((Boolean)tcd.getValue()).booleanValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBoolean */
  
  @Override
  @Test
  public void testUpdateDate()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CDATE");
      getResultSet().updateDate(tcd.getName(),(Date)tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateDate */
  
  @Override
  @Test
  public void testUpdateTime()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CTIME");
      getResultSet().updateTime(tcd.getName(),(Time)tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetTime */
  
  @Override
  @Test
  public void testUpdateTimestamp()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CTIMESTAMP");
      getResultSet().updateTimestamp(tcd.getName(),(Timestamp)tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateTimestamp */

  @Override
  @Test
  public void testUpdateDuration()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CINTERVAL_DAY_2_SECONDS_6");
      getBaseResultSet().updateDuration(tcd.getName(),((Interval)tcd.getValue()).toDuration());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateDuration */
  
  @Override
  @Test
  public void testUpdateAsciiStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      InputStream is = new ByteArrayInputStream(((String)tcd.getValue()).getBytes());
      getResultSet().updateAsciiStream(tcd.getName(),is);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateAsciiStream */
  
  @Override
  @Test
  public void testUpdateAsciiStream_Int()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      InputStream is = new ByteArrayInputStream(((String)tcd.getValue()).getBytes());
      getResultSet().updateAsciiStream(tcd.getName(),is,((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateAsciiStream_Int */
  
  @Override
  @Test
  public void testUpdateAsciiStream_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      InputStream is = new ByteArrayInputStream(((String)tcd.getValue()).getBytes());
      getResultSet().updateAsciiStream(tcd.getName(),is,(long)((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateAsciiStream_Long */
  
  @Override
  @Test
  public void testUpdateCharacterStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateCharacterStream(tcd.getName(),rdr);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateCharacterStream */
  
  @Override
  @Test
  public void testUpdateCharacterStream_Int()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateCharacterStream(tcd.getName(),rdr,((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateCharacterStream_Int */
  
  @Override
  @Test
  public void testUpdateCharacterStream_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARCHAR_255");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateCharacterStream(tcd.getName(),rdr,(long)((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateCharacterStream_Long */
  
  @Override
  @Test
  public void testUpdateNCharacterStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNVARCHAR_127");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateCharacterStream(tcd.getName(),rdr);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNCharacterStream */
  
  @Override
  @Test
  public void testUpdateNCharacterStream_Int()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNVARCHAR_127");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateCharacterStream(tcd.getName(),rdr,((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNCharacterStream_String_Int */
  
  @Override
  @Test
  public void testUpdateNCharacterStream_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CNVARCHAR_127");
      Reader rdr = new StringReader((String)tcd.getValue());
      getResultSet().updateCharacterStream(tcd.getName(),rdr,(long)((String)tcd.getValue()).length());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNCharacterStream_String_Long */

  @Override
  @Test
  public void testUpdateBinaryStream()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARBINARY_255");
      InputStream is = new ByteArrayInputStream((byte[])tcd.getValue());
      getResultSet().updateBinaryStream(tcd.getName(),is);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBinaryStream */
  
  @Override
  @Test
  public void testUpdateBinaryStream_Int()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARBINARY_255");
      InputStream is = new ByteArrayInputStream((byte[])tcd.getValue());
      getResultSet().updateBinaryStream(tcd.getName(),is,((byte[])tcd.getValue()).length);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBinaryStream_Int */
  
  @Override
  @Test
  public void testUpdateBinaryStream_Long()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CVARBINARY_255");
      InputStream is = new ByteArrayInputStream((byte[])tcd.getValue());
      getResultSet().updateBinaryStream(tcd.getName(),is,(long)((byte[])tcd.getValue()).length);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateBinaryStream_Long */
  
  @Test
  @Override
  public void testUpdateArray()
  {
    enter();
    try 
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdComplex,"CARRAY");
      Object[] aoElements = new Object[_listCdArray.size()];
      for (int iElement = 0; iElement < _listCdArray.size(); iElement++)
        aoElements[iElement] = _listCdArray.get(iElement).getValue();
      Array array = getResultSet().getStatement().getConnection().createArrayOf(tcd.getType(),
        aoElements);
      getResultSet().updateArray(tcd.getName(),array); 
    }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateArray */
  
  
  @Override
  @Test
  public void testUpdateRef()
  {
    // no REFs in DB/2 tables
  } /* testUpdateRef */
  
  @Override
  @Test
  public void testUpdateRowId()
  {
  } /* testUpdateRowId */
  
  @Override
  @Test
  public void testUpdateObject()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CDATE");
      getResultSet().updateObject(tcd.getName(),tcd.getValue());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateObject */
  
  @Override
  @Test
  public void testUpdateObject_Int()
  {
    try
    {
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CDECIMAL_15_5");
      getResultSet().updateObject(tcd.getName(),tcd.getValue(),3);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateObject_Int */
  
  @Override
  @Test
  public void testUpdateNull()
  {
    enter();
    try 
    {
      int iColumn = 1;
      TestColumnDefinition tcd = _listCdSimple.get(iColumn-1);
      getResultSet().updateNull(tcd.getName());
    }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testUpdateNull */
  
  @Override
  @Test
  public void testRefreshRow() throws SQLException
  {
    enter();
    try { getResultSet().refreshRow(); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* refreshRow */

  @Override
  @Test
  public void testDeleteRow() throws SQLException
  {
    try 
    {
      // cannot delete row in simple table because of foreign key
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      getResultSet().deleteRow();
      // restore the database
      tearDown();
      setUpClass();
    }
    catch(Exception e) { fail(EU.getExceptionMessage(e)); }
  } /* testDeleteRow */
  
  @Override
  @Test
  public void testUpdateRow() throws SQLException
  {
    try 
    { 
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CXML");
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQuerySimple);
      SQLXML sqlxml = getResultSet().getStatement().getConnection().createSQLXML();
      sqlxml.setString("<a>Konrad Zuse</a>");
      getResultSet().updateSQLXML(tcd.getName(), sqlxml);
      getResultSet().updateRow(); 
      sqlxml.free();
      // restore the database
      tearDown();
      setUpClass();
    }
    catch(Exception e) { fail(EU.getExceptionMessage(e)); }
  } /* testUpdateRow */

  @Override
  @Test
  public void testInsertRow() throws SQLException
  {
    try 
    {
      getResultSet().moveToInsertRow();
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdSimple,"CINTEGER");
      getResultSet().updateInt(tcd.getName(),((Integer)tcd.getValue()).intValue());
      getResultSet().insertRow();
      // restore the database
      tearDown();
      setUpClass();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testInsertRow */
  
  @Test
  public void testInsertRowSimple() throws SQLException
  {
    try 
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQuerySimple);
      getResultSet().moveToInsertRow();
      TestColumnDefinition tcd = findColumnDefinition(_listCdSimple,"CCHAR_5");
      getResultSet().updateString(tcd.getName(),(String)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CVARCHAR_255");
      getResultSet().updateString(tcd.getName(),(String)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CCLOB_2M");
      Clob clob = getResultSet().getStatement().getConnection().createClob();
      clob.setString(1l, (String)tcd.getValue());
      getResultSet().updateClob(tcd.getName(), clob);
      tcd = findColumnDefinition(_listCdSimple,"CNCHAR_5");
      getResultSet().updateString(tcd.getName(),(String)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CNVARCHAR_127");
      getResultSet().updateString(tcd.getName(),(String)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CNCLOB_1M");
      NClob nclob = getResultSet().getStatement().getConnection().createNClob();
      nclob.setString(1l, (String)tcd.getValue());
      getResultSet().updateNClob(tcd.getName(), nclob);
      tcd = findColumnDefinition(_listCdSimple,"CXML");
      SQLXML sqlxml = getResultSet().getStatement().getConnection().createSQLXML();
      sqlxml.setString((String)tcd.getValue());
      getResultSet().updateSQLXML(tcd.getName(), sqlxml);
      tcd = findColumnDefinition(_listCdSimple,"CBINARY_5");
      getResultSet().updateBytes(tcd.getName(),(byte[])tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CVARBINARY_255");
      getResultSet().updateBytes(tcd.getName(),(byte[])tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CBLOB");
      Blob blob = getResultSet().getStatement().getConnection().createBlob();
      blob.setBytes(1l, (byte[])tcd.getValue());
      getResultSet().updateBlob(tcd.getName(), blob);
      tcd = findColumnDefinition(_listCdSimple,"CNUMERIC_31");
      getResultSet().updateBigDecimal(tcd.getName(),new BigDecimal((BigInteger)tcd.getValue()));
      tcd = findColumnDefinition(_listCdSimple,"CDECIMAL_15_5");
      getResultSet().updateBigDecimal(tcd.getName(),(BigDecimal)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CSMALLINT");
      getResultSet().updateShort(tcd.getName(),((Short)tcd.getValue()).shortValue());
      tcd = findColumnDefinition(_listCdSimple,"CINTEGER");
      getResultSet().updateInt(tcd.getName(),((Integer)tcd.getValue()).intValue());
      tcd = findColumnDefinition(_listCdSimple,"CBIGINT");
      getResultSet().updateLong(tcd.getName(),((Long)tcd.getValue()).longValue());
      tcd = findColumnDefinition(_listCdSimple,"CFLOAT_10");
      getResultSet().updateFloat(tcd.getName(),((Float)tcd.getValue()).floatValue());
      tcd = findColumnDefinition(_listCdSimple,"CREAL");
      getResultSet().updateFloat(tcd.getName(),((Float)tcd.getValue()).floatValue());
      tcd = findColumnDefinition(_listCdSimple,"CDOUBLE");
      getResultSet().updateDouble(tcd.getName(),((Double)tcd.getValue()).doubleValue());
      tcd = findColumnDefinition(_listCdSimple,"CBOOLEAN");
      getResultSet().updateBoolean(tcd.getName(),((Boolean)tcd.getValue()).booleanValue());
      tcd = findColumnDefinition(_listCdSimple,"CDATE");
      getResultSet().updateDate(tcd.getName(),(Date)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CTIME");
      getResultSet().updateTime(tcd.getName(),(Time)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CTIMESTAMP");
      getResultSet().updateTimestamp(tcd.getName(),(Timestamp)tcd.getValue());
      tcd = findColumnDefinition(_listCdSimple,"CINTERVAL_YEAR_2_MONTH");
      ((BaseResultSet)getResultSet()).updateDuration(tcd.getName(),((Interval)tcd.getValue()).toDuration());
      tcd = findColumnDefinition(_listCdSimple,"CINTERVAL_DAY_2_SECONDS_6");
      ((BaseResultSet)getResultSet()).updateDuration(tcd.getName(),((Interval)tcd.getValue()).toDuration());
      getResultSet().insertRow();
      getResultSet().moveToCurrentRow();
      
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQuerySimple);
      tcd = findColumnDefinition(
        _listCdSimple,"CINTEGER");
      while ((getResultSet().getInt(tcd.getName()) != ((Integer)tcd.getValue()).intValue()) && 
        getResultSet().next()) {}
      tcd = findColumnDefinition(_listCdSimple,"CCHAR_5");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        (getResultSet().getString(tcd.getName())).substring(0,((String)tcd.getValue()).length()));
      tcd = findColumnDefinition(_listCdSimple,"CVARCHAR_255");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        getResultSet().getString(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CCLOB_2M");
      clob = getResultSet().getClob(tcd.getName());
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        clob.getSubString(1l, (int)clob.length()));
      tcd = findColumnDefinition(_listCdSimple,"CNCHAR_5");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        (getResultSet().getString(tcd.getName())).substring(0,((String)tcd.getValue()).length()));
      tcd = findColumnDefinition(_listCdSimple,"CNVARCHAR_127");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        getResultSet().getString(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CNCLOB_1M");
      nclob = getResultSet().getNClob(tcd.getName());
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        nclob.getSubString(1l, (int)nclob.length()));
      tcd = findColumnDefinition(_listCdSimple,"CXML");
      sqlxml = getResultSet().getSQLXML(tcd.getName());
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (String)tcd.getValue(),
        sqlxml.getString());
      tcd = findColumnDefinition(_listCdSimple,"CBINARY_5");
      assertTrue("Insert of "+tcd.getType()+" failed!",
        Arrays.equals(
          (byte[])tcd.getValue(),
          Arrays.copyOf(
            getResultSet().getBytes(tcd.getName()),
            ((byte[])tcd.getValue()).length)));
      tcd = findColumnDefinition(_listCdSimple,"CVARBINARY_255");
      assertTrue("Insert of "+tcd.getType()+" failed!",
        Arrays.equals(
          (byte[])tcd.getValue(),
          getResultSet().getBytes(tcd.getName())));
      tcd = findColumnDefinition(_listCdSimple,"CBLOB");
      blob = getResultSet().getBlob(tcd.getName());
      assertTrue("Insert of "+tcd.getType()+" failed!",
        Arrays.equals(
          (byte[])tcd.getValue(),
          blob.getBytes(1l,(int)blob.length())));
      tcd = findColumnDefinition(_listCdSimple,"CNUMERIC_31");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (BigInteger)tcd.getValue(),
        getResultSet().getBigDecimal(tcd.getName()).toBigInteger());
      tcd = findColumnDefinition(_listCdSimple,"CDECIMAL_15_5");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (BigDecimal)tcd.getValue(),
        getResultSet().getBigDecimal(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CSMALLINT");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        ((Short)tcd.getValue()).shortValue(),
        getResultSet().getShort(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CINTEGER");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        ((Integer)tcd.getValue()).intValue(),
        getResultSet().getInt(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CBIGINT");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        ((Long)tcd.getValue()).longValue(),
        getResultSet().getLong(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CFLOAT_10");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Float)tcd.getValue(),
        Float.valueOf(getResultSet().getFloat(tcd.getName())));
      tcd = findColumnDefinition(_listCdSimple,"CREAL");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Float)tcd.getValue(),
        Float.valueOf(getResultSet().getFloat(tcd.getName())));
      tcd = findColumnDefinition(_listCdSimple,"CDOUBLE");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Double)tcd.getValue(),
        Double.valueOf(getResultSet().getDouble(tcd.getName())));
      tcd = findColumnDefinition(_listCdSimple,"CBOOLEAN");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Boolean)tcd.getValue(),
        Boolean.valueOf(getResultSet().getBoolean(tcd.getName())));
      tcd = findColumnDefinition(_listCdSimple,"CDATE");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Date)tcd.getValue(),
        getResultSet().getDate(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CTIME");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Time)tcd.getValue(),
        getResultSet().getTime(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CTIMESTAMP");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Timestamp)tcd.getValue(),
        getResultSet().getTimestamp(tcd.getName()));
      tcd = findColumnDefinition(_listCdSimple,"CINTERVAL_YEAR_2_MONTH");
      assertEquals("Insert of "+tcd.getType()+" failed!",
        (Interval)tcd.getValue(),
        Interval.fromDuration(((BaseResultSet)getResultSet()).getDuration(tcd.getName())));
      tcd = findColumnDefinition(_listCdSimple,"CINTERVAL_DAY_2_SECONDS_6");
      Date dateZero = new Date(0);
      assertEquals("Insert of "+tcd.getType()+" failed!",
        ((Interval)tcd.getValue()).toDuration().getTimeInMillis(dateZero)/1000,
        ((BaseResultSet)getResultSet()).getDuration(tcd.getName()).getTimeInMillis(dateZero)/1000);
      // restore the database
      tearDown();
      setUpClass();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testInsertRow */
  
  @SuppressWarnings("unchecked")
  private Array getArrayValue(String sBaseType, List<TestColumnDefinition> listElements)
    throws SQLException
  {
    Object[] aoElements = new Object[listElements.size()];
    for (int iElement = 0; iElement < listElements.size(); iElement++)
    {
      TestColumnDefinition tcdElement = listElements.get(iElement);
      Object o = tcdElement.getValue();
      if (o instanceof List<?>)
        o = getArrayValue(tcdElement.getType(),(List<TestColumnDefinition>)tcdElement.getValue());
      aoElements[iElement] = o;
    }
    Array array = getResultSet().getStatement().getConnection().createArrayOf(sBaseType,aoElements);
    return array;
  } /* getArrayValue */
  
  @SuppressWarnings("unchecked")
  @Test
  public void testInsertRowComplex() throws SQLException
  {
    try 
    {
      TestColumnDefinition tcdSimple = findColumnDefinition(
        _listCdSimple,"CINTEGER");
      TestColumnDefinition tcd = findColumnDefinition(
        _listCdComplex,"CID");
      // needed for foreign key constraint ...
      getResultSet().moveToInsertRow();
      getResultSet().updateInt(tcdSimple.getName(),((Long)tcd.getValue()).intValue());
      getResultSet().insertRow();

      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      getResultSet().moveToInsertRow();
      getResultSet().updateLong(tcd.getName(),((Long)tcd.getValue()).longValue());
      tcd = findColumnDefinition(_listCdComplex,"CARRAY");
      int i = tcd.getType().indexOf(" ARRAY[");
      String sBaseType = tcd.getType().substring(0,i);
      Array array = getArrayValue(sBaseType, (List<TestColumnDefinition>)tcd.getValue());
      getResultSet().updateArray(tcd.getName(), array);
      getResultSet().insertRow();
      getResultSet().moveToCurrentRow();
      
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      tcd = findColumnDefinition(_listCdComplex,"CID");
      while ((getResultSet().getLong(tcd.getName()) != ((Long)tcd.getValue()).longValue()) && 
        getResultSet().next()) {}
      assertEquals("Insert of "+tcd.getType()+" failed!",
        ((Long)tcd.getValue()).longValue(),
        getResultSet().getLong(tcd.getName()));
      tcd = findColumnDefinition(_listCdComplex,"CARRAY");
      assertTrue("Insert of  "+tcd.getType()+"failed!",
        equalsArrayValue(
          (Array)getResultSet().getObject(tcd.getName()),
          (List<TestColumnDefinition>)tcd.getValue()));
    }
    catch(SQLFeatureNotSupportedException sfnse) { printExceptionMessage(sfnse); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    finally
    {
      // restore the database
      tearDown();
      setUpClass();
    }
  } /* testInsertRowComplex */
  
}
