/*======================================================================
MsSqlMetaColumn implements data type mapping from MSSQL to ISO SQL.
Application : SIARD2
Description : MsSqlMetaColumn implements data type mapping from MSSQL to ISO SQL.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 19.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import ch.enterag.utils.database.*;
import ch.enterag.utils.logging.*;
import ch.enterag.sqlparser.datatype.enums.*;
import ch.enterag.sqlparser.identifier.*;

/*====================================================================*/
/** MsSqlMetaColumns implements the type translation from MSSQL ot ISO SQL.
 * N.B.: column TYPE_NAME (6) has the original MSSQL data type name.
 * @author Hartwig Thomas
 */
public class MsSqlMetaColumns
  extends MsSqlResultSet
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(MsSqlMetaColumns.class.getName());

  private static final String sIDENTITY_SUFFIX = "identity";
  private static Map<String,PreType> mapNAME_MSSQL_TO_ISO = new HashMap<String,PreType>();
  private static Map<Integer, Integer> mapTYPE_MSSQL_TO_ISO = new HashMap<Integer, Integer>();
  static
  {
    mapNAME_MSSQL_TO_ISO.put("varbinary",PreType.VARBINARY);
    mapNAME_MSSQL_TO_ISO.put("binary",PreType.BINARY);
    mapNAME_MSSQL_TO_ISO.put("image",PreType.BLOB);
    mapNAME_MSSQL_TO_ISO.put("timestamp",PreType.BINARY);
    mapNAME_MSSQL_TO_ISO.put("uniqueidentifier",PreType.CHAR);
    mapNAME_MSSQL_TO_ISO.put("char",PreType.CHAR);
    mapNAME_MSSQL_TO_ISO.put("varchar",PreType.VARCHAR);
    mapNAME_MSSQL_TO_ISO.put("text",PreType.CLOB);
    mapNAME_MSSQL_TO_ISO.put("nchar",PreType.NCHAR);
    mapNAME_MSSQL_TO_ISO.put("nvarchar",PreType.NVARCHAR);
    mapNAME_MSSQL_TO_ISO.put("ntext",PreType.NCLOB);
    mapNAME_MSSQL_TO_ISO.put("xml",PreType.XML);
    mapNAME_MSSQL_TO_ISO.put("bit",PreType.BOOLEAN);
    mapNAME_MSSQL_TO_ISO.put("tinyint",PreType.SMALLINT);
    mapNAME_MSSQL_TO_ISO.put("smallint",PreType.SMALLINT);
    mapNAME_MSSQL_TO_ISO.put("int",PreType.INTEGER);
    mapNAME_MSSQL_TO_ISO.put("bigint",PreType.BIGINT);
    mapNAME_MSSQL_TO_ISO.put("smallmoney",PreType.DECIMAL);
    mapNAME_MSSQL_TO_ISO.put("money",PreType.DECIMAL);
    mapNAME_MSSQL_TO_ISO.put("numeric",PreType.NUMERIC);
    mapNAME_MSSQL_TO_ISO.put("decimal",PreType.DECIMAL);
    mapNAME_MSSQL_TO_ISO.put("real",PreType.REAL);
    mapNAME_MSSQL_TO_ISO.put("float",PreType.DOUBLE);
    mapNAME_MSSQL_TO_ISO.put("date",PreType.DATE);
    mapNAME_MSSQL_TO_ISO.put("time",PreType.TIME);
    mapNAME_MSSQL_TO_ISO.put("smalldatetime",PreType.TIMESTAMP);
    mapNAME_MSSQL_TO_ISO.put("datetime",PreType.TIMESTAMP);
    mapNAME_MSSQL_TO_ISO.put("datetime2",PreType.TIMESTAMP);
    mapNAME_MSSQL_TO_ISO.put("datetimeoffset",PreType.VARCHAR);
    
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.BINARY), Integer.valueOf(Types.BINARY));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.VARBINARY), Integer.valueOf(Types.VARBINARY));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.LONGVARBINARY), Integer.valueOf(Types.BLOB));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.CHAR), Integer.valueOf(Types.CHAR));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.VARCHAR), Integer.valueOf(Types.VARCHAR));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.LONGVARCHAR), Integer.valueOf(Types.CLOB));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.NCHAR), Integer.valueOf(Types.NCHAR));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.NVARCHAR), Integer.valueOf(Types.NVARCHAR));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.LONGNVARCHAR), Integer.valueOf(Types.NCLOB)); // or SQLXML!
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.BIT), Integer.valueOf(Types.BOOLEAN));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.TINYINT), Integer.valueOf(Types.SMALLINT));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.SMALLINT), Integer.valueOf(Types.SMALLINT));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.INTEGER), Integer.valueOf(Types.INTEGER));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.BIGINT), Integer.valueOf(Types.BIGINT));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.DECIMAL), Integer.valueOf(Types.DECIMAL));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.NUMERIC), Integer.valueOf(Types.NUMERIC));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.REAL), Integer.valueOf(Types.REAL));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.DOUBLE), Integer.valueOf(Types.DOUBLE));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.DATE), Integer.valueOf(Types.DATE));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.TIME), Integer.valueOf(Types.TIME));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(Types.TIMESTAMP), Integer.valueOf(Types.TIMESTAMP));
    mapTYPE_MSSQL_TO_ISO.put(Integer.valueOf(-155), Integer.valueOf(Types.VARCHAR)); // DateTimeOffset
  }
  
  private int _iCatalog = -1;
  private int _iSchema = -1;
  private int _iDataType = -1;
  private int _iTypeName = -1;
  private int _iPrecision = -1;
  private int _iLength = -1;
  private int _iScale = -1;
  
  /*------------------------------------------------------------------*/
  static int getDataType(int iType, String sTypeName,
    Connection conn, String sCatalogName, String sSchemaName)
    throws SQLException
  {
    _il.enter(SqlTypes.getTypeName(iType),sTypeName);
    if (sTypeName.startsWith("\"") && sTypeName.endsWith("\""))
      sTypeName = sTypeName.substring(1,sTypeName.length()-1);
    if (sTypeName.equals("xml"))
      iType = Integer.valueOf(Types.SQLXML);
    else if (sTypeName.equals("datetimeoffset"))
      iType = Integer.valueOf(Types.VARCHAR);
    else if (sTypeName.equals("sql_variant"))
      iType = Integer.valueOf(Types.VARBINARY);
    else
    {
      if (sTypeName.endsWith(sIDENTITY_SUFFIX))
        sTypeName = sTypeName.substring(0,sTypeName.length()-sIDENTITY_SUFFIX.length()).trim();
      PreType pt = mapNAME_MSSQL_TO_ISO.get(sTypeName);
      if (pt != null)
        iType = mapTYPE_MSSQL_TO_ISO.get(Integer.valueOf(iType)).intValue();
      else
      {
        MsSqlDatabaseMetaData dmd = (MsSqlDatabaseMetaData)conn.getMetaData();
        ResultSet rs = dmd.getUDTs(null, null, dmd.toPattern(sTypeName), null);
        while (rs.next())
        {
          iType = rs.getInt("DATA_TYPE");
          if (iType == Types.JAVA_OBJECT)
            iType = Types.VARCHAR;
        }
        rs.close();
      }
    }
    _il.exit(SqlTypes.getTypeName(iType));
    return iType;
  } /* getDataType */
  
  /*------------------------------------------------------------------*/
  static long getColumnSize(int iType, String sTypeName, 
    long lColumnSize, Connection conn, String sCatalogName, 
    String sSchemaName)
    throws SQLException
  {
    int iDataType = getDataType(iType, sTypeName, conn, sCatalogName, sSchemaName);
    if (sTypeName.equals("uniqueidentifier"))
      lColumnSize = 36;
    else if (sTypeName.equals("datetimeoffset"))
      lColumnSize = 64;
    else if ((iDataType == Types.CLOB) ||
        (iDataType == Types.BLOB) ||
        (iDataType == Types.NCLOB) ||
        (iDataType == Types.SQLXML))
      lColumnSize = -1;
    /*** these type are not limited in size any more because of (max) declaration!
    else if (iDataType == Types.VARBINARY)
    {
      int iMaxLength = 8000;
      if (lColumnSize > iMaxLength)
        lColumnSize = iMaxLength;
    }
    else if (iDataType == Types.VARCHAR)
    {
      int iMaxLength = 4000;
      if (lColumnSize > iMaxLength)
        lColumnSize = iMaxLength;
    }
    else if (iDataType == Types.NVARCHAR)
    {
      int iMaxLength = 4000;
      if (lColumnSize > iMaxLength)
        lColumnSize = iMaxLength;
    }
    ***/
    return lColumnSize;
  } /* getColumnSize */
  
  /*------------------------------------------------------------------*/
  static String getTypeName(String sTypeName, int iColumnSize, int iDecimals,
    Connection conn, String sCatalogName, String sSchemaName)
    throws SQLException
  {
    PreType pt = mapNAME_MSSQL_TO_ISO.get(sTypeName);
    /***
    if (pt != null)
    {
      BaseSqlFactory bsf = new BaseSqlFactory();
      PredefinedType preType = bsf.newPredefinedType();
      preType.initialize(pt.getSqlType(), iColumnSize, iDecimals);
      sTypeName = preType.format();
    }
    ***/
    if (pt == null)
    {
      String sTypeSchema = null;
      MsSqlDatabaseMetaData dmd = (MsSqlDatabaseMetaData)conn.getMetaData();
      ResultSet rs = dmd.getUDTs(null, null, dmd.toPattern(sTypeName), null);
      while ((!sSchemaName.equals(sTypeSchema)) && rs.next())
      {
        if (sCatalogName.equals(rs.getString("TYPE_CAT")))
          sTypeSchema = rs.getString("TYPE_SCHEM");
      }
      rs.close();
      QualifiedId qiType = new QualifiedId(null,null,sTypeName);
      if (!sSchemaName.equals(sTypeSchema))
        qiType.setSchema(sTypeSchema);
      sTypeName = qiType.format();
    }
    return sTypeName;
  } /* getTypeName */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param rsWrapped DatabaseMetaData.getColumns() result set to be wrapped.
   */
  public MsSqlMetaColumns(ResultSet rsWrapped, MsSqlConnection conn,
    int iCatalog, int iSchema, int iDataType, int iTypeName,
    int iPrecision, int iLength, int iScale)
    throws SQLException
  {
    super(rsWrapped, conn);
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
    String sResult = super.getString(columnIndex);
    if (columnIndex == _iTypeName)
    {
      int iLength = super.getInt(_iPrecision);
      if (iLength <= 0)
        iLength = super.getInt(_iLength);
      sResult = getTypeName(
        sResult, 
        iLength, 
        super.getInt(_iScale),
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
    if (columnIndex == _iDataType)
    {
      iResult = getDataType(
        super.getInt(_iDataType), 
        super.getString(_iTypeName),
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
    }
    else if ((columnIndex == _iLength) ||
             (columnIndex == _iPrecision))
    {
      int iLength = super.getInt(_iPrecision);
      if (iLength <= 0)
        iLength = super.getInt(_iLength);
      iResult = (int)getColumnSize(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        iLength,
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
    if ((columnIndex == _iLength) ||
             (columnIndex == _iPrecision))
    {
      lResult = getColumnSize(
        super.getInt(_iDataType),
        super.getString(_iTypeName),
        lLength,
        _conn,
        super.getString(_iCatalog), 
        super.getString(_iSchema));
    }
    else
      lResult = super.getLong(columnIndex);
    return lResult;
  } /* getLong */
  
} /*class MsSqlMetaColumns */
