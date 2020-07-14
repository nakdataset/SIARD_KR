/*======================================================================
OracleMetaColumn implements data type mapping from Oracle to ISO SQL.
Version     : $Id: $
Application : SIARD2
Description : OracleMetaColumn implements data type mapping from Oracle to ISO SQL.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 19.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import ch.enterag.utils.database.*;
import ch.enterag.utils.logging.*;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;
import ch.enterag.sqlparser.datatype.enums.*;
import ch.enterag.sqlparser.identifier.*;

/*====================================================================*/
/** OracleMetaColumns implements the type translation from Oracle to ISO SQL.
 * N.B.: column TYPE_NAME (6) has the original Oracle data type name.
 * @author Hartwig Thomas
 */
public class OracleMetaColumns
  extends OracleResultSet
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(OracleMetaColumns.class.getName());
  private static Pattern _patVarrayText = 
    Pattern.compile("^TYPE.*VARRAY\\s*\\((\\d+)\\)\\s+OF\\s+(.*?)\\s*;?\\s*$",
    Pattern.CASE_INSENSITIVE+Pattern.DOTALL);
  private static Pattern _patTableText = 
    Pattern.compile("^TYPE.*TABLE\\s+OF\\s+(.*?)\\s*;?\\s*$",
    Pattern.CASE_INSENSITIVE+Pattern.DOTALL);
  private static Pattern _patType = Pattern.compile("^(.*?)(\\(\\s*(\\d+)\\s*(,\\s*(\\d)+\\s*)?\\))?$");
  private static final int _iDEFAULT_TABLE_MAXIMUM = Integer.MAX_VALUE;
  
  private static Map<String, PreType> mapNAME_ORACLE_TO_ISO = new HashMap<String, PreType>();
  // private static Map<Integer, Integer> mapTYPE_ORACLE_TO_ISO = new HashMap<Integer, Integer>();
  static 
  {
    mapNAME_ORACLE_TO_ISO.put("INTERVALDS", PreType.INTERVAL);
    mapNAME_ORACLE_TO_ISO.put("INTERVALYM", PreType.INTERVAL);
    mapNAME_ORACLE_TO_ISO.put("DATE", PreType.TIMESTAMP);
    mapNAME_ORACLE_TO_ISO.put("TIME", PreType.TIME);
    mapNAME_ORACLE_TO_ISO.put("TIMESTAMP", PreType.TIMESTAMP);
    mapNAME_ORACLE_TO_ISO.put("TIMESTAMP WITH LOCAL TIME ZONE", PreType.TIMESTAMP);
    mapNAME_ORACLE_TO_ISO.put("TIMESTAMP WITH TIME ZONE", PreType.TIMESTAMP);
    mapNAME_ORACLE_TO_ISO.put("LONG RAW", PreType.BLOB);
    mapNAME_ORACLE_TO_ISO.put("RAW", PreType.VARBINARY);
    mapNAME_ORACLE_TO_ISO.put("BLOB", PreType.BLOB);
    mapNAME_ORACLE_TO_ISO.put("BFILE", PreType.BLOB);
    mapNAME_ORACLE_TO_ISO.put("LONG", PreType.CLOB);
    mapNAME_ORACLE_TO_ISO.put("CHAR", PreType.CHAR);
    mapNAME_ORACLE_TO_ISO.put("NCHAR", PreType.NCHAR);
    mapNAME_ORACLE_TO_ISO.put("VARCHAR", PreType.VARCHAR);
    mapNAME_ORACLE_TO_ISO.put("VARCHAR2", PreType.VARCHAR);
    mapNAME_ORACLE_TO_ISO.put("NVARCHAR", PreType.NVARCHAR);
    mapNAME_ORACLE_TO_ISO.put("NVARCHAR2", PreType.NVARCHAR);
    mapNAME_ORACLE_TO_ISO.put("CLOB", PreType.CLOB);
    mapNAME_ORACLE_TO_ISO.put("NCLOB", PreType.NCLOB);
    mapNAME_ORACLE_TO_ISO.put("XMLTYPE", PreType.XML);
    mapNAME_ORACLE_TO_ISO.put("NUMBER", PreType.DECIMAL);
    mapNAME_ORACLE_TO_ISO.put("NUMERIC", PreType.NUMERIC);
    mapNAME_ORACLE_TO_ISO.put("DECIMAL", PreType.DECIMAL);
    mapNAME_ORACLE_TO_ISO.put("INTEGER", PreType.INTEGER);
    mapNAME_ORACLE_TO_ISO.put("TINYINT", PreType.SMALLINT);
    mapNAME_ORACLE_TO_ISO.put("SMALLINT", PreType.SMALLINT);
    mapNAME_ORACLE_TO_ISO.put("BIGINT", PreType.BIGINT);
    mapNAME_ORACLE_TO_ISO.put("ROWID", PreType.BIGINT);
    mapNAME_ORACLE_TO_ISO.put("FLOAT", PreType.FLOAT);
    mapNAME_ORACLE_TO_ISO.put("REAL", PreType.REAL);
    mapNAME_ORACLE_TO_ISO.put("DOUBLE", PreType.DOUBLE);
    mapNAME_ORACLE_TO_ISO.put("DOUBLE PRECISION", PreType.DOUBLE);
    mapNAME_ORACLE_TO_ISO.put("BINARY_FLOAT", PreType.REAL);
    mapNAME_ORACLE_TO_ISO.put("BINARY_DOUBLE", PreType.DOUBLE);
    

    /***
    mapTYPE_ORACLE_TO_ISO.put(new Integer(-104), new Integer(Types.OTHER)); // INTERVALDS
    mapTYPE_ORACLE_TO_ISO.put(new Integer(-103), new Integer(Types.OTHER)); // INTERVALYM
    mapTYPE_ORACLE_TO_ISO.put(new Integer(-102), new Integer(Types.TIMESTAMP)); // TIMESTAMP WITH LOCAL TIME ZONE
    mapTYPE_ORACLE_TO_ISO.put(new Integer(-101), new Integer(Types.TIMESTAMP)); // TIMESTAMP WITH TIME ZONE
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.BIT), new Integer(Types.BOOLEAN));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.TINYINT), new Integer(Types.SMALLINT));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.BIGINT), new Integer(Types.BIGINT));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.LONGVARBINARY), new Integer(Types.BLOB));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.VARBINARY), new Integer(Types.VARBINARY));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.LONGVARCHAR), new Integer(Types.CLOB));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.CHAR), new Integer(Types.CHAR));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.NUMERIC), new Integer(Types.NUMERIC));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.INTEGER), new Integer(Types.DECIMAL));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.SMALLINT), new Integer(Types.SMALLINT));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.FLOAT), new Integer(Types.FLOAT));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.REAL), new Integer(Types.REAL));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.VARCHAR), new Integer(Types.VARCHAR));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.TIME), new Integer(Types.TIME));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.TIMESTAMP), new Integer(Types.TIMESTAMP));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.BLOB), new Integer(Types.BLOB));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.CLOB), new Integer(Types.CLOB));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.NCHAR), new Integer(Types.NCHAR));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.NVARCHAR), new Integer(Types.NVARCHAR));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.NCLOB), new Integer(Types.NCLOB));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.SQLXML), new Integer(Types.SQLXML));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(Types.ROWID), new Integer(Types.BIGINT));
    mapTYPE_ORACLE_TO_ISO.put(new Integer(2007), new Integer(Types.SQLXML)); // XMLType
    mapTYPE_ORACLE_TO_ISO.put(new Integer(100), new Integer(Types.FLOAT)); // BINARY_FLOAT
    mapTYPE_ORACLE_TO_ISO.put(new Integer(101), new Integer(Types.DOUBLE)); // BINARY_DOUBLE
    mapTYPE_ORACLE_TO_ISO.put(new Integer(-13), new Integer(Types.BLOB)); // BFILE
    ***/
  }
  
  protected int _iCatalog = -1;
  private int _iSchema = -1;
  private int _iDataType = -1;
  private int _iTypeName = -1;
  private int _iPrecision = -1;
  private int _iLength = -1;
  private int _iScale = -1;
  
  /*------------------------------------------------------------------*/
  private static QualifiedId parseTypeName(String sTypeName)
  {
    QualifiedId qiTypeName = new QualifiedId();
    try 
    { 
      qiTypeName = new QualifiedId(sTypeName); 
      sTypeName = qiTypeName.getName();
    }
    catch(ParseException pe) { qiTypeName.setName(sTypeName); }
    return qiTypeName;
  } /* parseTypeName */
  
  /*------------------------------------------------------------------*/
  private static PredefinedType getPredefinedType(String sTypeName, int iColumnSize, int iDecimals)
  {
    BaseSqlFactory bsf = new BaseSqlFactory();
    PredefinedType preType = bsf.newPredefinedType();
    PreType pt = mapNAME_ORACLE_TO_ISO.get(sTypeName);
    if (pt == null)
    {
      try 
      { 
        preType.parse(sTypeName);
        pt = preType.getType();
      }
      catch(Exception e) { }
    }
    if (pt != null)
    {
      if (sTypeName.equalsIgnoreCase("NUMBER") || sTypeName.equalsIgnoreCase("NUMERIC"))
      {
        if (iDecimals >= 0)
        {
          if (iDecimals == 0)
          {
            if (iColumnSize <= 5)
              pt = PreType.SMALLINT;
            else if (iColumnSize <= 10)
              pt = PreType.INTEGER;
            else
              pt = PreType.BIGINT;
          }
        }
        else
        {
          pt = PreType.FLOAT;
          iDecimals = PredefinedType.iUNDEFINED;
          iColumnSize = PredefinedType.iUNDEFINED;
        }
      }
      else if (sTypeName.equalsIgnoreCase("DATE"))
      {
        if (iColumnSize >= 0)
        {
          if (iColumnSize < 7)
            pt = PreType.TIME;
        }
      }
      preType.initialize(pt.getSqlType(), iColumnSize, iDecimals);
    }
    return preType;
  } /* getPredefinedType */
  
  /*------------------------------------------------------------------*/
  static int getDataType(int iType, String sTypeName, long lColumnSize, int iDecimals,
    Connection conn, String sCatalogName, String sSchemaName)
    throws SQLException
  {
    _il.enter(SqlTypes.getTypeName(iType));
    if (iType != Types.ARRAY)
    {
      QualifiedId qiTypeName = parseTypeName(sTypeName);
      PredefinedType preType = getPredefinedType(qiTypeName.getName(),(int)lColumnSize,iDecimals);
      if (preType.getType() != null)
        iType = preType.getType().getSqlType();
      else if ("ANYDATA".equals(qiTypeName.getName()) && "SYS".equals(qiTypeName.getSchema()))
        iType = Types.CLOB;
      else
        iType = Types.STRUCT;
    }
    _il.exit(SqlTypes.getTypeName(iType));
    return iType;
  } /* getDataType */
  
  /*------------------------------------------------------------------*/
  static long getColumnSize(int iType, String sTypeName, 
    long lColumnSize, int iDecimals, Connection conn, String sCatalogName, 
    String sSchemaName)
    throws SQLException
  {
    int iDataType = getDataType(iType, sTypeName, lColumnSize, iDecimals,
      conn, sCatalogName, sSchemaName);
    if ((iDataType == Types.CLOB) ||
        (iDataType == Types.BLOB) ||
        (iDataType == Types.NCLOB) ||
        (iDataType == Types.SQLXML))
      lColumnSize = -1;
    return lColumnSize;
  } /* getColumnSize */
  
  /*------------------------------------------------------------------*/
  static String getFullArrayTypeName(Connection conn, QualifiedId qiVarray)
    throws SQLException
  {
    _il.enter(conn,qiVarray);
    String sTypeName = null;
    String sSql = "SELECT TEXT FROM ALL_SOURCE WHERE OWNER = " +
      SqlLiterals.formatStringLiteral(qiVarray.getSchema()) + 
      " AND NAME = " + 
      SqlLiterals.formatStringLiteral(qiVarray.getName());
    Statement ostmt = conn.createStatement();
    String sText = "";
    _il.event("Unwrapped query: "+sSql);
    ResultSet rs = ostmt.executeQuery(sSql);
    while (rs.next())
      sText = sText + rs.getString("TEXT");
    rs.close();
    ostmt.close();
    String sNumber = String.valueOf(_iDEFAULT_TABLE_MAXIMUM);
    String sBaseType = null;
    Matcher match = _patVarrayText.matcher(sText);
    if (match.matches())
    {
      sNumber = match.group(1);
      sBaseType = match.group(2);
    }
    else
    {
      match = _patTableText.matcher(sText);
      if (match.matches())
        sBaseType = match.group(1);
      else
        throw new SQLException("Pattern match for VARRAY and TABLE failed!");
    }
    int iColumnSize = -1;
    int iDecimals = -1;
    Matcher matchType = _patType.matcher(sBaseType);
    if (matchType.matches())
    {
      sBaseType = matchType.group(1);
      String sColumnSize = matchType.group(3);
      String sDecimals = matchType.group(5);
      if (sColumnSize != null)
      {
        if (!sBaseType.toUpperCase().startsWith("TIME"))
          iColumnSize = Integer.parseInt(sColumnSize);
        else
          iDecimals = Integer.parseInt(sColumnSize);
      }
      if (sDecimals != null)
        iDecimals = Integer.parseInt(sDecimals);
      sBaseType = getTypeName(sBaseType,Types.NULL,iColumnSize,iDecimals,new OracleConnection(conn),qiVarray.getCatalog(),qiVarray.getSchema()); 
    }
    else
      throw new SQLException("Pattern match for base type of VARRAY failed!");
    sTypeName = sBaseType + " ARRAY["+sNumber+"]";
    _il.exit(sTypeName);
    return sTypeName;
  } /* getFullArrayTypeName */
  
  /*------------------------------------------------------------------*/
  static String getTypeName(String sTypeName, int iDataType, int iColumnSize, int iDecimals,
    Connection conn, String sCatalogName, String sSchemaName)
    throws SQLException
  {
    _il.enter(sTypeName);
    if (sTypeName != null)
    {
      QualifiedId qiTypeName = parseTypeName(sTypeName);
      PredefinedType preType = getPredefinedType(qiTypeName.getName(),iColumnSize,iDecimals);
      if (preType.getType() != null)
        sTypeName = preType.format();
      else
      {
        sTypeName = qiTypeName.getName();
        String sTypeSchema = qiTypeName.getSchema();
        /* search for the type name in some system schema if no schema was given */ 
        if ((sTypeSchema == null) || "PUBLIC".equals(sTypeSchema))
        {
          OracleDatabaseMetaData dmd = (OracleDatabaseMetaData)conn.getMetaData(); 
          ResultSet rs = dmd.getUDTs(sCatalogName, null, dmd.toPattern(sTypeName), null);
          while((!sSchemaName.equals(sTypeSchema)) && rs.next())
          {
            if (sTypeName.equals(rs.getString("TYPE_NAME")))
              sTypeSchema = rs.getString("TYPE_SCHEM");
          }
          rs.close();
        }
        if ((sSchemaName != null) && sSchemaName.equals(sTypeName))
          sTypeSchema = null;
        qiTypeName.setSchema(sTypeSchema);
        /* check, if it is a VARRAY type */
        if (iDataType != Types.ARRAY)
          sTypeName = qiTypeName.format();
        else
        {
          oracle.jdbc.OracleConnection oconn = (oracle.jdbc.OracleConnection)conn.unwrap(Connection.class);
          sTypeName = getFullArrayTypeName(oconn,qiTypeName);
        }
      }
    }
    _il.exit(sTypeName);
    return sTypeName;
  } /* getTypeName */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param rsWrapped DatabaseMetaData.getColumns() result set to be wrapped.
   */
  public OracleMetaColumns(ResultSet rsWrapped, Connection conn, Statement stmt,
    int iCatalog, int iSchema, int iDataType, int iTypeName,
    int iPrecision, int iLength, int iScale)
    throws SQLException
  {
    super(rsWrapped, conn, stmt);
    _iCatalog = iCatalog;
    _iSchema = iSchema;
    _iDataType = iDataType;
    _iTypeName = iTypeName;
    _iPrecision = iPrecision;
    _iLength = iLength;
    _iScale = iScale;
  } /* constructor */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * Type name (mapped to ISO SQL) is returned in TYPE_NAME.
   * Original type name can be retrieved by using unwrap. 
   */
  @Override
  public String getString(int columnIndex) throws SQLException
  {
    String sResult = null;
    sResult = super.getString(columnIndex);
    if (columnIndex == _iTypeName)
    {
      int iLength = super.getInt(_iPrecision);
      if (iLength <= 0)
        iLength = super.getInt(_iLength);
      int iScale = super.getInt(_iScale);
      if (super.wasNull())
        iScale = PredefinedType.iUNDEFINED;
      int iDataType = getDataType(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        iLength,
        iScale,
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
      if ((iDataType == Types.ARRAY) || 
          (iDataType == Types.DISTINCT) || 
          (iDataType == Types.STRUCT) ||
          (iDataType == Types.OTHER))
        sResult = getTypeName(
          sResult, 
          super.getInt(_iDataType),
          iLength, 
          iScale,
          _conn,
          super.getString(_iCatalog), 
          super.getString(_iSchema));
    }
    return sResult;
  } /* getString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * Mapped java.sql.Types type is returned in DATA_TYPE.
   * Original java.sql.Types type can be retrieved by using unwrap. 
   */
  @Override
  public int getInt(int columnIndex) throws SQLException
  {
    int iResult = -1;
    int iLength = super.getInt(_iPrecision);
    if (iLength <= 0)
      iLength = super.getInt(_iLength);
    int iScale = super.getInt(_iScale);
    if (super.wasNull())
      iScale = PredefinedType.iUNDEFINED;
    if (columnIndex == _iDataType)
    {
      iResult = getDataType(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        iLength,
        iScale,
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
    }
    else if ((columnIndex == _iLength) ||
             (columnIndex == _iPrecision))
    {
      iResult = (int)getColumnSize(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        iLength,
        iScale,
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
    }
    else
      iResult = super.getInt(columnIndex);
    return iResult;
  } /* getInt */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * Mapped java.sql.Types type is returned in DATA_TYPE.
   * Original java.sql.Types type can be retrieved by using unwrap. 
   */
  @Override
  public long getLong(int columnIndex) throws SQLException
  {
    long lResult = -1;
    long lLength = super.getLong(_iPrecision);
    if (lLength <= 0)
      lLength = super.getLong(_iLength);
    int iScale = super.getInt(_iScale);
    if (super.wasNull())
      iScale = PredefinedType.iUNDEFINED;
    if ((columnIndex == _iLength) ||
        (columnIndex == _iPrecision))
    {
      lResult = getColumnSize(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        (int)lLength,
        iScale,
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
    }
    else if (columnIndex == _iDataType)
    {
      lResult = getDataType(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        lLength,
        iScale,
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
    }
    else
      lResult = super.getLong(columnIndex);
    return lResult;
  } /* getLong */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * Mapped java.sql.Types type is returned in DATA_TYPE.
   * Original java.sql.Types type can be retrieved by using unwrap. 
   * Column size is adjusted to CHARS rather than BYTES.  
   */
  @Override
  public Object getObject(int columnIndex) throws SQLException
  {
    Object oResult = null;
    oResult = super.getObject(columnIndex);
    // getProcedureColumns returns DATA_TYPE (and others ...) as BigDecimal
    if (oResult instanceof BigDecimal)
    {
      try
      {
        BigDecimal bd = (BigDecimal)oResult;
        long l = bd.longValueExact();
        oResult = Long.valueOf(l);
      }
      catch (ArithmeticException ae) {}
    }
    if (oResult instanceof Integer)
      oResult = Integer.valueOf(getInt(columnIndex));
    else if (oResult instanceof Long)
      oResult = Long.valueOf(getLong(columnIndex));
    else if (oResult instanceof String)
      oResult = getString(columnIndex);
    return oResult;
  } /* getObject */
  
} /* OracleMetaColumns */
