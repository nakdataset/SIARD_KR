package ch.admin.bar.siard2.h2;

import java.io.*;
import java.math.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import static org.junit.Assert.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;
import ch.enterag.sqlparser.ddl.*;
import ch.enterag.sqlparser.ddl.enums.*;
import ch.enterag.sqlparser.dml.*;
import ch.enterag.sqlparser.dml.enums.SpecialValue;
import ch.enterag.sqlparser.expression.*;
import ch.enterag.sqlparser.expression.enums.*;
import ch.enterag.sqlparser.identifier.*;

@SuppressWarnings("deprecation")
public class TestSqlDatabase
{
  public static final String _sTEST_SCHEMA = "TESTSQLSCHEMA";
  public static final String _sTEST_TABLE_SIMPLE = "TSQLSIMPLE";
  public static QualifiedId getQualifiedSimpleTable() { return new QualifiedId(null,_sTEST_SCHEMA,_sTEST_TABLE_SIMPLE); }
  private static final String _sTEST_TABLE_COMPLEX = "TSQLCOMPLEX";
  public static QualifiedId getQualifiedComplexTable() { return new QualifiedId(null,_sTEST_SCHEMA,_sTEST_TABLE_COMPLEX); }
  private static final String _sTEST_VIEW_SIMPLE = "VSQLSIMPLE";
  public static QualifiedId getQualifiedSimpleView() { return new QualifiedId(null,_sTEST_SCHEMA,_sTEST_VIEW_SIMPLE); }

  public static int _iPrimarySimple = -1;
  private static List<TestColumnDefinition> getListCdSimple()
  {
    List<TestColumnDefinition> listCd = new ArrayList<TestColumnDefinition>();
    listCd.add(new TestColumnDefinition("CCHAR_5","CHAR(5)","Abcd"));
    listCd.add(new TestColumnDefinition("CVARCHAR_255","VARCHAR(255)",TestUtils.getString(196)));
    listCd.add(new TestColumnDefinition("CCLOB_2M","CLOB(2M)",TestUtils.getString(2000000)));
    listCd.add(new TestColumnDefinition("CNCHAR_5","NCHAR(5)","Niño"));
    listCd.add(new TestColumnDefinition("CNVARCHAR_127","NCHAR VARYING(127)",TestUtils.getNString(100)));
    listCd.add(new TestColumnDefinition("CNCLOB_1M","NCLOB(1M)",TestUtils.getNString(1000000)));
    listCd.add(new TestColumnDefinition("CXML","XML","<a>foöäpwkfèégopàèwerkgvoperkv &lt; and &amp; ifjeifj</a>"));
    listCd.add(new TestColumnDefinition("CBINARY_5","BINARY(5)",new byte[] {1,-2,3,-4} ));
    listCd.add(new TestColumnDefinition("CVARBINARY_255","VARBINARY(255)",TestUtils.getBytes(196) ));
    listCd.add(new TestColumnDefinition("CBLOB","BLOB",TestUtils.getBytes(1000000)));
    listCd.add(new TestColumnDefinition("CNUMERIC_31","NUMERIC(31)",BigInteger.valueOf(1234567890123456789l)));
    listCd.add(new TestColumnDefinition("CDECIMAL_15_5","DECIMAL(15,5)",new BigDecimal(BigInteger.valueOf(3141592653210l),5)));
    listCd.add(new TestColumnDefinition("CSMALLINT","SMALLINT",new Short((short)-32000)));
    _iPrimarySimple = listCd.size(); // next column will be primary key column 
    listCd.add(new TestColumnDefinition("CINTEGER","INTEGER",new Integer(1234567890)));
    listCd.add(new TestColumnDefinition("CBIGINT","BIGINT",new Long(-123456789012345678l)));
    listCd.add(new TestColumnDefinition("CFLOAT_10","FLOAT(10)",new Float(Math.E)));
    listCd.add(new TestColumnDefinition("CREAL","REAL",new Float(Math.PI)));
    listCd.add(new TestColumnDefinition("CDOUBLE","DOUBLE PRECISION",new Double(Math.E)));
    listCd.add(new TestColumnDefinition("CBOOLEAN","BOOLEAN",new Boolean(true)));
    listCd.add(new TestColumnDefinition("CDATE","DATE",new Date(2016-1900,11,28)));
    listCd.add(new TestColumnDefinition("CTIME","TIME",new Time(13,45,28)));
    listCd.add(new TestColumnDefinition("CTIMESTAMP","TIMESTAMP(9)",new Timestamp(2016-1900,11,28,13,45,28,123456789)));
    listCd.add(new TestColumnDefinition("CINTERVAL_YEAR_2_MONTH","INTERVAL YEAR(2) TO MONTH",new Interval(1,123,3)));
    listCd.add(new TestColumnDefinition("CINTERVAL_DAY_2_SECONDS_6","INTERVAL DAY(2) TO SECOND(6)",new Interval(1,4,17,54,23,123456000l)));
    return listCd;
  }
  public static List<TestColumnDefinition> _listCdSimple = getListCdSimple();

  private static List<TestColumnDefinition> getListCdArray()
  {
    List<TestColumnDefinition> listCd = new ArrayList<TestColumnDefinition>();
    listCd.add(new TestColumnDefinition("CARRAY[1]","VARCHAR(255)",TestUtils.getString(196)));
    listCd.add(new TestColumnDefinition("CARRAY[2]","VARCHAR(255)","Cannot be null!"));
    listCd.add(new TestColumnDefinition("CARRAY[3]","VARCHAR(255)",TestUtils.getString(5)));
    listCd.add(new TestColumnDefinition("CARRAY[4]","VARCHAR(255)",TestUtils.getString(64)));
    return listCd;
  }
  public static List<TestColumnDefinition> _listCdArray = getListCdArray();
  
  private static int _iPrimaryComplex = -1;
  private static List<TestColumnDefinition> getListCdComplex()
  {
    List<TestColumnDefinition> listCd = new ArrayList<TestColumnDefinition>();
    _iPrimaryComplex = listCd.size(); // next column will be primary key column
    listCd.add(new TestColumnDefinition("CID","LONG",new Long(1234567890l)));
    listCd.add(new TestColumnDefinition("CARRAY","VARCHAR(255) ARRAY[1000]",_listCdArray));
    return listCd;
  }
  public static List<TestColumnDefinition> _listCdComplex = getListCdComplex();

  private SqlFactory _sf = new BaseSqlFactory();
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
  public TestSqlDatabase(Connection conn)
    throws SQLException
  {
    _conn = conn;
    _conn.setAutoCommit(false);
    drop();
    create();
  } /* constructor */

  /*------------------------------------------------------------------*/
  private void drop()
  {
    deleteTables();
    dropTables();
    dropSchema();
  } /* drop */
  
  /*------------------------------------------------------------------*/
  private void dropTable(QualifiedId qiTable)
  {
    try
    {
      DropTableStatement dts = _sf.newDropTableStatement();
      dts.initialize(qiTable,DropBehavior.RESTRICT);
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(dts.format());
      if (iResult != 0)
        throw new SQLException("Drop table "+qiTable.format()+" failed!");
      stmt.close();
      _conn.commit();
    }
    catch (SQLException se) { rollback("Drop table "+qiTable.format(), se); }
  } /* dropTable */
  
  /*------------------------------------------------------------------*/
  private void dropView(QualifiedId qiView)
  {
    try
    {
      DropViewStatement dvs = _sf.newDropViewStatement();
      dvs.initialize(qiView,DropBehavior.RESTRICT);
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(dvs.format());
      if (iResult != 0)
        throw new SQLException("Drop view "+qiView.format()+" failed!");
      stmt.close();
      _conn.commit();
    }
    catch (SQLException se) { rollback("Drop view "+qiView.format(), se); }
  } /* dropView */
  
  /*------------------------------------------------------------------*/
  private void dropTables()
  {
    dropView(getQualifiedSimpleView()); // first because it depends on table
    dropTable(getQualifiedComplexTable()); // first, because of foreign key ...
    dropTable(getQualifiedSimpleTable());
  } /* dropTables */

  /*------------------------------------------------------------------*/
  private void deleteTable(QualifiedId qiTable)
  {
    try
    {
      DeleteStatement ds = _sf.newDeleteStatement();
      ds.initialize(qiTable, null);
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(ds.format());
      if (iResult != 0)
        throw new SQLException("Delete table "+qiTable.format()+" failed!");
      stmt.close();
      _conn.commit();
    }
    catch (SQLException se) { rollback("Delete table "+qiTable.format(), se); }
  } /* deleteTable */
  
  /*------------------------------------------------------------------*/
  private void deleteTables()
  {
    deleteTable(getQualifiedComplexTable()); // first, because of foreign key ...
    deleteTable(getQualifiedSimpleTable());
  }

  /*------------------------------------------------------------------*/
  private void dropSchema()
  {
    try
    {
      DropSchemaStatement dss = _sf.newDropSchemaStatement();
      dss.initialize(new SchemaId(null,_sTEST_SCHEMA),DropBehavior.CASCADE);
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(dss.format());
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
      CreateSchemaStatement css = _sf.newCreateSchemaStatement();
      css.initialize(new SchemaId(null,_sTEST_SCHEMA), new Identifier());
      Statement stmt = _conn.createStatement();
      int iResult = stmt.executeUpdate(css.format());
      if (iResult != 0)
        throw new SQLException("Create schema "+_sTEST_SCHEMA+" failed!");
      stmt.close();
      _conn.commit();
  } /* createSchema */

  /*------------------------------------------------------------------*/
  private TableElement getTableElement(TestColumnDefinition tcd, boolean bNotNull)
    throws SQLException
  {
    DataType dt = _sf.newDataType();
    dt.parse(tcd.getType());
    ColumnDefinition cd = _sf.newColumnDefinition();
    if (bNotNull)
    {
      ColumnConstraintDefinition ccd = cd.getColumnConstraintDefinition();
      if (ccd == null)
      {
        ccd = _sf.newColumnConstraintDefinition();
        cd.setColumnConstraintDefinition(ccd);
      }
      ccd.setType(ColumnConstraintType.NOT_NULL);
    }
    cd.initNameType(new Identifier(tcd.getName()), dt);
    TableElement te = _sf.newTableElement();
    te.initColumnDefinition(cd);
    return te;
  } /* getTableElement */
  
  /*------------------------------------------------------------------*/
  private TableElement getPrimaryTableElement(String sPkName, List<TestColumnDefinition> listCdPrimary)
  {
    IdList ilPrimary = new IdList();
    for (int i = 0; i < listCdPrimary.size(); i++)
    {
      TestColumnDefinition tcd = listCdPrimary.get(i);
      ilPrimary.get().add(tcd.getName());
    }
    TableConstraintDefinition tcd = _sf.newTableConstraintDefinition();
    tcd.initPrimaryKey(new QualifiedId(null,null,sPkName), ilPrimary);
    TableElement te = _sf.newTableElement();
    te.initTableConstraintDefinition(tcd);
    return te;
  } /* getPrimaryTableElement */

  /*------------------------------------------------------------------*/
  private TableElement getForeignTableElement(String sFkName, List<TestColumnDefinition> listCdForeign,
    QualifiedId qiTableReferenced, List<TestColumnDefinition> listCdReferenced)
  {
    IdList ilForeign = new IdList();
    for (int i = 0; i < listCdForeign.size();i++)
    {
      TestColumnDefinition tcd = listCdForeign.get(i);
      ilForeign.get().add(tcd.getName());
    }
    IdList ilReferenced = new IdList();
    for (int i = 0; i < listCdReferenced.size();i++)
    {
      TestColumnDefinition tcd = listCdReferenced.get(i);
      ilReferenced.get().add(tcd.getName());
    }
    TableConstraintDefinition tcd = _sf.newTableConstraintDefinition();
    tcd.initialize(new QualifiedId(null,null,sFkName), TableConstraintType.FOREIGN_KEY,
      ilForeign, qiTableReferenced, ilReferenced, null, ReferentialAction.CASCADE, 
      null, null, null, null);
    TableElement te = _sf.newTableElement();
    te.initTableConstraintDefinition(tcd);
    return te;
  } /* getForeignTableElement */
  
  /*------------------------------------------------------------------*/
  private void createTable(QualifiedId qiTable, List<TestColumnDefinition> listCd,
    List<TestColumnDefinition> listCdPrimary, List<TestColumnDefinition> listCdForeign,
    QualifiedId qiTableReferenced, List<TestColumnDefinition> listCdReferenced)
    throws SQLException
  {
    CreateTableStatement cts = _sf.newCreateTableStatement();
    List<TableElement> listTableElements = new ArrayList<TableElement>();
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      TestColumnDefinition tcd = listCd.get(iColumn);
      listTableElements.add(getTableElement(tcd, listCdPrimary.contains(tcd)));
    }
    listTableElements.add(getPrimaryTableElement("PK"+qiTable.getName(), listCdPrimary));
    if (listCdForeign != null)
      listTableElements.add(getForeignTableElement("FK"+qiTable.getName(),
        listCdForeign,qiTableReferenced,listCdReferenced));
    cts.initTableElements(null,
      qiTable,
      listTableElements,null);
    Statement stmt = _conn.createStatement();
    int iResult = stmt.executeUpdate(cts.format());
    if (iResult != 0)
      throw new SQLException("Create table "+qiTable.format()+" failed!");
    stmt.close();
    _conn.commit();
  } /* createTable */
  
  /*------------------------------------------------------------------*/
  private void createView(QualifiedId qiView, 
    List<TestColumnDefinition> listCd, QualifiedId qiTable)
    throws SQLException
  {
    TablePrimary tp = _sf.newTablePrimary();
    tp.initialize(qiTable, new Identifier(), new ArrayList<Identifier>(), 
      null, false, null, false, false, null, null, false, false);
    TableReference tr = _sf.newTableReference();
    tr.initialize(tp, null, null, null, null, null, new ArrayList<Identifier>(), null, null);
    List<TableReference> listTableReferences = new ArrayList<TableReference>();
    listTableReferences.add(tr);
    QuerySpecification qs = _sf.newQuerySpecification();
    qs.initialize(true, new ArrayList<SelectSublist>(), listTableReferences, null);
    QueryExpressionBody qeb = _sf.newQueryExpressionBody();
    qeb.initialize(null, null, null, null, false, new ArrayList<Identifier>(), null,
      qs, new QualifiedId(), new ArrayList<TableRowValueExpression>());
    QueryExpression qe = _sf.newQueryExpression();
    qe.initialize(false, new ArrayList<WithElement>(), qeb);
    IdList ilColumnNames = new IdList();
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      TestColumnDefinition tcd = listCd.get(iColumn);
      ilColumnNames.get().add(tcd.getName());
    }
    CreateViewStatement cvs = _sf.newCreateViewStatement();
    cvs.initialize(false, qiView, 
      ilColumnNames, new QualifiedId(), new ArrayList<ViewElement>(), 
      new QualifiedId(), qe, false, null);
    Statement stmt = _conn.createStatement();
    int iResult = stmt.executeUpdate(cvs.format());
    if (iResult != 0)
      throw new SQLException("Create view "+qiView.format()+" failed!");
    stmt.close();
    _conn.commit();
  } /* createView */

  /*------------------------------------------------------------------*/
  private List<TestColumnDefinition> getSingle(TestColumnDefinition tcd)
  {
    List<TestColumnDefinition> listSingle = 
      Arrays.asList(new TestColumnDefinition[]{tcd});
    return listSingle;
  } /* getSingle */
  
  /*------------------------------------------------------------------*/
  private void createTables()
    throws SQLException
  {
    createTable(getQualifiedSimpleTable(),_listCdSimple,
      getSingle(_listCdSimple.get(_iPrimarySimple)),
      null,null,null);
    createTable(getQualifiedComplexTable(),_listCdComplex,
      getSingle(_listCdComplex.get(_iPrimaryComplex)),
      getSingle(_listCdComplex.get(_iPrimaryComplex)),
      getQualifiedSimpleTable(), 
      getSingle(_listCdSimple.get(_iPrimarySimple)));
    createView(getQualifiedSimpleView(),_listCdSimple,getQualifiedSimpleTable());
  } /* createTables */

  /*------------------------------------------------------------------*/
  private CommonValueExpression getCommonValueExpression()
  {
    ValueExpressionPrimary vep = _sf.newValueExpressionPrimary();
    CommonValueExpression cve = _sf.newCommonValueExpression();
    cve.initialize(null, null, null, null, null, null, vep);
    return cve;
  } /* getCommonValueExpressionArray */

  /*------------------------------------------------------------------*/
  private CommonValueExpression getCommonValueExpressionLiteral()
  {
    UnsignedLiteral ul = _sf.newUnsignedLiteral();
    ValueExpressionPrimary vep = _sf.newValueExpressionPrimary();
    vep.initUnsignedLiteral(ul);
    CommonValueExpression cve = _sf.newCommonValueExpression();
    cve.initialize(null, null, null, null, null, null, vep);
    return cve;
  } /* getCommonValueExpression */
  
  /*------------------------------------------------------------------*/
  private CommonValueExpression getCommonValueExpressionDynamic()
  {
    GeneralValueSpecification gvs = _sf.newGeneralValueSpecification();
    gvs.initialize(new ColonId(), new ColonId(), new IdChain(), GeneralValue.QUESTION_MARK);
    CommonValueExpression cve = getCommonValueExpression();
    cve.getValueExpressionPrimary().setGeneralValueSpecification(gvs);
    return cve;
  } /* getCommonValueExpressionDynamic */
  
  /*------------------------------------------------------------------*/
  private CommonValueExpression getCommonValueExpressionNumeric()
  {
    UnsignedLiteral ul = _sf.newUnsignedLiteral();
    ValueExpressionPrimary vep = _sf.newValueExpressionPrimary();
    vep.initUnsignedLiteral(ul);
    NumericValueExpression nve = _sf.newNumericValueExpression();
    nve.initialize(null, null, null, null, null, null, vep, null);
    CommonValueExpression cve = _sf.newCommonValueExpression();
    cve.initialize(nve, null, null, null, null, null, null);
    return cve;
  } /* getCommonValueExpressionNumeric */
  
  /*------------------------------------------------------------------*/
  private ValueExpression getValueExpression(TestColumnDefinition tcd, 
    List<TestColumnDefinition> listLobs)
    throws SQLException
  {
    ValueExpression ve = _sf.newValueExpression();
    CommonValueExpression cve = null;
    Object o = tcd.getValue();
    if (o != null)
    {
      if ((o instanceof String) ||
        (o instanceof byte[]) ||
        (o instanceof Boolean) ||
        (o instanceof Date) ||
        (o instanceof Time) ||
        (o instanceof Timestamp) ||
        (o instanceof Interval))
        cve = getCommonValueExpressionLiteral();
      else if ((o instanceof BigDecimal) ||
               (o instanceof BigInteger) ||
               (o instanceof Short) ||
               (o instanceof Integer) ||
               (o instanceof Long) ||
               (o instanceof Float) ||
               (o instanceof Double))
        cve = getCommonValueExpressionNumeric();
      else if (o instanceof List<?>)
        cve = getCommonValueExpression();
      
      if (o instanceof String)
      {
        String s = (String)o;
        if (s.length() < 256)
          cve.getValueExpressionPrimary().getUnsignedLit().
            initCharacterString(s);
        else
        {
          cve = getCommonValueExpressionDynamic();
          listLobs.add(tcd);
        }
      }
      else if (o instanceof byte[])
      {
        byte[] buf = (byte[])o;
        if (buf.length < 256)
          cve.getValueExpressionPrimary().getUnsignedLit().
            initBytes(buf);
        else
        {
          cve = getCommonValueExpressionDynamic();
          listLobs.add(tcd);
        }
      }
      else if (o instanceof BigDecimal)
      {
        BigDecimal bd = (BigDecimal)o;
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initBigDecimal(bd.abs());
      if (bd.signum() < 0)
        cve.getNumericValueExpression().
          setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof BigInteger)
      {
        BigInteger bi = (BigInteger)o;
        BigDecimal bd = new BigDecimal(bi);
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initBigDecimal(bd.abs());
      if (bd.signum() < 0)
        cve.getNumericValueExpression().
          setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof Short)
      {
        short sh = ((Short)o).shortValue();
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initInteger(Math.abs(sh));
        if (sh < 0)
          cve.getNumericValueExpression().
            setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof Integer)
      {
        int i = ((Integer)o).intValue();
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initInteger(Math.abs(i));
        if (i < 0)
          cve.getNumericValueExpression().
            setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof Long)
      {
        long l = ((Long)o).longValue();
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initLong(Math.abs(l));
        if (l < 0)
          cve.getNumericValueExpression().
            setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof Float)
      {
        double d = ((Float)o).doubleValue();
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initDouble(Math.abs(d));
        if (d < 0)
          cve.getNumericValueExpression().
            setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof Double)
      {
        double d = ((Double)o).doubleValue();
        cve.getNumericValueExpression().getValueExpressionPrimary().getUnsignedLit().
          initDouble(Math.abs(d));
        if (d < 0)
          cve.getNumericValueExpression().
            setSign(Sign.MINUS_SIGN);
      }
      else if (o instanceof Boolean)
      {
        boolean b = ((Boolean)o).booleanValue();
        cve.getValueExpressionPrimary().getUnsignedLit().
          initBoolean(b? BooleanLiteral.TRUE: BooleanLiteral.FALSE);
      }
      else if (o instanceof Date)
      {
        cve.getValueExpressionPrimary().getUnsignedLit().
          initDate((Date)o);
      }
      else if (o instanceof Time)
      {
        cve.getValueExpressionPrimary().getUnsignedLit().
          initTime((Time)o);
      }
      else if (o instanceof Timestamp)
      {
        cve.getValueExpressionPrimary().getUnsignedLit().
          initTimestamp((Timestamp)o);
      }
      else if (o instanceof Interval)
      {
        Interval iv = (Interval)o;
        cve.getValueExpressionPrimary().getUnsignedLit().initInterval(iv);
      }
      else if (o instanceof List<?>)
      {
        @SuppressWarnings("unchecked")
        List<TestColumnDefinition> listCdArray = (List<TestColumnDefinition>)o;
        List<ValueExpression> listArrayValues = new ArrayList<ValueExpression>();
        for (int iElement = 0; iElement < listCdArray.size(); iElement++)
        {
          TestColumnDefinition tcdElement = listCdArray.get(iElement);
          ValueExpression veElement = getValueExpression(tcdElement,listLobs);
          listArrayValues.add(veElement);
        }
        cve.getValueExpressionPrimary().
          initArrayValueConstructor(listArrayValues);
      }
      else
        throw new SQLException("Unexpected value type "+o.getClass().getName()+"!");
    }
    ve.initialize(cve, null, null);
    return ve;
  } /* getValueExpression */
  
  /*------------------------------------------------------------------*/
  private UpdateSource getUpdateSource(TestColumnDefinition tcd, 
    List<TestColumnDefinition> listLobs)
    throws SQLException
  {
    UpdateSource us = _sf.newUpdateSource();
    if (tcd.getValue() != null)
    {
      ValueExpression ve = getValueExpression(tcd,listLobs);
      us.initialize(ve, null);
    }
    else
      us.initialize(null, SpecialValue.NULL);
    return us;
  } /* getUpdateSource */
  
  /*------------------------------------------------------------------*/
  private void insertTable(QualifiedId qiTable, List<TestColumnDefinition> listCd)
    throws SQLException
  {
    IdList ilColumns = new IdList();
    List<AssignedRow> listValues = new ArrayList<AssignedRow>();
    AssignedRow ar = _sf.newAssignedRow();
    listValues.add(ar);
    List<TestColumnDefinition> listLobs = new ArrayList<TestColumnDefinition>();
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      TestColumnDefinition tcd = listCd.get(iColumn);
      ilColumns.get().add(tcd.getName());
      ar.getUpdateSources().add(getUpdateSource(tcd,listLobs));
    }
    InsertStatement is = _sf.newInsertStatement();
    is.initialize(qiTable, ilColumns, listValues, 
      null, null, false);
    PreparedStatement pstmt = _conn.prepareStatement(is.format());
    for (int iLob = 0; iLob < listLobs.size();iLob++)
    {
      TestColumnDefinition tcd = listLobs.get(iLob);
      if (tcd.getValue() instanceof String)
      {
        Reader rdrClob = new StringReader((String)tcd.getValue());
        pstmt.setCharacterStream(iLob+1, rdrClob);
      }
      else if (tcd.getValue() instanceof byte[])
      {
        InputStream isBlob = new ByteArrayInputStream((byte[])tcd.getValue());
        pstmt.setBinaryStream(iLob+1, isBlob);
      }
      else
        throw new SQLException("Invalid LOB!");
    }
    int iResult = pstmt.executeUpdate();
    if (iResult != 1)
      throw new SQLException("Insert into table "+qiTable.format()+" failed!");
    pstmt.close();
    _conn.commit();  
  } /* insertTable */
  
  /*------------------------------------------------------------------*/
  private void insertTables()
    throws SQLException
  {
    insertTable(getQualifiedSimpleTable(),_listCdSimple);
    insertTable(getQualifiedComplexTable(),_listCdComplex);
  } /* insertTables */
  
} /* TestDatabase */
