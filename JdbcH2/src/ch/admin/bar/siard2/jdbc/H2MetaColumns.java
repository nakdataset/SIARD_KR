/*======================================================================
H2MetaColumn implements data type mapping from H2 to ISO SQL.
Version     : $Id: $
Application : SIARD2
Description : H2MetaColumn implements data type mapping from H2 to ISO SQL.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 19.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import com.vividsolutions.jts.geom.*;
import ch.enterag.sqlparser.datatype.enums.*;
import ch.enterag.sqlparser.identifier.*;

/*====================================================================*/
/** H2MetaColumns implements the type translation from H2 ot ISO SQL.
 * @author Hartwig Thomas
 */
public class H2MetaColumns
  extends H2ResultSet
{
  private static Map<String,PreType> mapNAME_H2_TO_ISO = new HashMap<String,PreType>();
  private static Map<Integer, Integer> mapTYPE_H2_TO_ISO = new HashMap<Integer, Integer>();
  static
  {
    mapNAME_H2_TO_ISO.put("CHAR",PreType.CHAR);
    mapNAME_H2_TO_ISO.put("LONGVARCHAR",PreType.CLOB);
    mapNAME_H2_TO_ISO.put("VARCHAR",PreType.VARCHAR);
    mapNAME_H2_TO_ISO.put("VARCHAR_IGNORECASE",PreType.VARCHAR);
    mapNAME_H2_TO_ISO.put("CLOB",PreType.CLOB);
    mapNAME_H2_TO_ISO.put("LONGVARBINARY",PreType.BLOB);
    mapNAME_H2_TO_ISO.put("VARBINARY",PreType.VARBINARY);
    mapNAME_H2_TO_ISO.put("BINARY",PreType.BINARY);
    mapNAME_H2_TO_ISO.put("UUID",PreType.BINARY);
    mapNAME_H2_TO_ISO.put("BLOB",PreType.BLOB);
    mapNAME_H2_TO_ISO.put("NUMERIC",PreType.DECIMAL);
    mapNAME_H2_TO_ISO.put("DECIMAL",PreType.DECIMAL);
    mapNAME_H2_TO_ISO.put("TINYINT",PreType.SMALLINT);
    mapNAME_H2_TO_ISO.put("SMALLINT",PreType.SMALLINT);
    mapNAME_H2_TO_ISO.put("INTEGER",PreType.INTEGER);
    mapNAME_H2_TO_ISO.put("SERIAL",PreType.INTEGER);
    mapNAME_H2_TO_ISO.put("BIGINT",PreType.BIGINT);
    mapNAME_H2_TO_ISO.put("IDENTITY",PreType.BIGINT);
    mapNAME_H2_TO_ISO.put("FLOAT",PreType.DOUBLE);
    mapNAME_H2_TO_ISO.put("REAL",PreType.REAL);
    mapNAME_H2_TO_ISO.put("DOUBLE",PreType.DOUBLE);
    mapNAME_H2_TO_ISO.put("BOOLEAN",PreType.BOOLEAN);
    mapNAME_H2_TO_ISO.put("DATE",PreType.DATE);
    mapNAME_H2_TO_ISO.put("TIME",PreType.TIME);
    mapNAME_H2_TO_ISO.put("TIMESTAMP",PreType.TIMESTAMP);
    mapNAME_H2_TO_ISO.put("GEOMETRY",PreType.CLOB); // WKT
    mapNAME_H2_TO_ISO.put("OTHER",PreType.INTERVAL);
    mapNAME_H2_TO_ISO.put("ARRAY",null); // ARRAY is not a predefined type and must be handled in DataType
    
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.CHAR), Integer.valueOf(Types.CHAR));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.VARCHAR), Integer.valueOf(Types.VARCHAR));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.LONGVARCHAR), Integer.valueOf(Types.CLOB));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.CLOB), Integer.valueOf(Types.CLOB));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.VARBINARY), Integer.valueOf(Types.VARBINARY));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.LONGVARBINARY), Integer.valueOf(Types.BLOB));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.BINARY), Integer.valueOf(Types.BINARY));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.BLOB), Integer.valueOf(Types.BLOB));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.DECIMAL), Integer.valueOf(Types.DECIMAL));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.TINYINT), Integer.valueOf(Types.SMALLINT));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.SMALLINT), Integer.valueOf(Types.SMALLINT));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.INTEGER), Integer.valueOf(Types.INTEGER));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.BIGINT), Integer.valueOf(Types.BIGINT));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.DOUBLE), Integer.valueOf(Types.DOUBLE));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.REAL), Integer.valueOf(Types.REAL));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.BOOLEAN), Integer.valueOf(Types.BOOLEAN));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.DATE), Integer.valueOf(Types.DATE));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.TIME), Integer.valueOf(Types.TIME));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.TIMESTAMP), Integer.valueOf(Types.TIMESTAMP));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.ARRAY), Integer.valueOf(Types.ARRAY));
    mapTYPE_H2_TO_ISO.put(Integer.valueOf(Types.OTHER), Integer.valueOf(Types.OTHER));
  }

  private int _iCatalog = -1;
  private int _iSchema = -1;
  private int _iTable = -1;
  private int _iColumn = -1;
  private int _iDataType = -1;
  private int _iTypeName = -1;
  private int _iPrecision = -1;
  private int _iLength = -1;
  private int _iScale = -1;
  
  /*------------------------------------------------------------------*/
  static int getDataType(int iType, long lColumnSize, String sClassName)
  {
    if (iType == Types.OTHER)
    { 
      if (sClassName.equals(Geometry.class.getName()))
        iType = Types.CLOB;
      else
        iType = Types.BLOB;
    }
    else if (iType == Types.VARBINARY)
    {
      if (lColumnSize > 4000)
        iType = Types.BLOB;
    }
    else if (iType == Types.VARCHAR)
    {
      if (lColumnSize > 2000)
        iType = Types.CLOB;
    }
    else
      iType = mapTYPE_H2_TO_ISO.get(Integer.valueOf(iType)).intValue();
    return iType;
  } /* getDataType */
  
  /*------------------------------------------------------------------*/
  static long getColumnSize(int iType, long lColumnSize, String sClassName) 
    throws SQLException
  {
    int iDataType = getDataType(iType, lColumnSize, sClassName);
    if ((iDataType == Types.CLOB) ||
        (iDataType == Types.BLOB) ||
        (iDataType == Types.NCLOB) ||
        (iDataType == Types.SQLXML))
      lColumnSize = -1;
    else if ((iDataType == Types.CHAR) ||
             (iDataType == Types.BINARY))
    {
      if (lColumnSize == Integer.MAX_VALUE)
        lColumnSize = -1;
    }
    else if ((iDataType == Types.DECIMAL) ||
             (iDataType == Types.NUMERIC))
    {
      if (lColumnSize == 0x000000000000FFFFl)
        lColumnSize = -1;
    }
    if (sClassName.equals(UUID.class.getName()))
      lColumnSize = 16;
    return lColumnSize;
  } /* getColumnSize */
  
  /*------------------------------------------------------------------*/
  static String getTypeName(String sTypeName, int iColumnSize, int iDecimals,
    Connection conn, String sCatalogName, String sSchemaName, String sTableName, String sColumnName)
    throws SQLException
  {
    PreType pt = mapNAME_H2_TO_ISO.get(sTypeName);
    /**
    if (pt != null)
    {
      BaseSqlFactory bsf = new BaseSqlFactory();
      PredefinedType preType = bsf.newPredefinedType();
      preType.initialize(pt.getSqlType(), iColumnSize, iDecimals);
      sTypeName = preType.format();
    }
    **/
    if ((pt == null) && (sTableName != null) && (sColumnName != null))
    {
      /* must become "<base> ARRAY[<length>]" */
      String sBaseType = null;
      int iLength = -1;
      QualifiedId qiTable = new QualifiedId(sCatalogName, sSchemaName, sTableName);
      Identifier idColumn = new Identifier(sColumnName);
      String sSql = "SELECT " + idColumn.format() + " AS CARRAY FROM " + qiTable.format();
      Statement stmt = conn.createStatement();
      ResultSet rsArray = stmt.executeQuery(sSql);
      while ((iLength < 0) && rsArray.next())
      {
        Array array = rsArray.getArray("CARRAY");
        if (array != null)
        {
          sBaseType = array.getBaseTypeName();
          Object[] ao = (Object[])array.getArray();
          iLength = ao.length;
        }
      }
      rsArray.close();
      sTypeName = sBaseType + " ARRAY["+String.valueOf(iLength)+"]";
    }
    return sTypeName;
  } /* getTypeName */
  
  /*------------------------------------------------------------------*/
  /** constructor for table columns
   * @param rsWrapped DatabaseMetaData.getColumns() result set to be wrapped.
   * @param conn open database connection.
   * @param iCatalog columnIndex (1-based) for catalog name of table. 
   * @param iSchema columnIndex (1-based) for schema name of table. 
   * @param iTable columnIndex (1-based) for name of table. 
   * @param iColumn columnIndex (1-based) for name of column.
   * @param iDataType columnIndex (1-based) for java.sql.Types value.
   * @param iTypeName columnIndex (1-based) for type name.
   * @param iPrecision column index (1-based) of precision (length) of numeric types.
   * @param iLength columnIndex (1-based) of length of non-numeric types.
   * @param iScale column index (1-based) of number of decimals of numeric types.
   */
  public H2MetaColumns(ResultSet rsWrapped, Connection conn,
    int iCatalog, int iSchema, int iTable, int iColumn,
    int iDataType, int iTypeName, int iPrecision, int iLength, int iScale)
    throws SQLException
  {
    super(rsWrapped,conn);
    _iCatalog = iCatalog;
    _iSchema = iSchema;
    _iTable = iTable;
    _iColumn = iColumn;
    _iDataType = iDataType;
    _iTypeName = iTypeName;
    _iPrecision = iPrecision;
    _iLength = iLength;
    _iScale = iScale;
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** constructor for table columns
   * @param rsWrapped DatabaseMetaData.getColumns() result set to be wrapped.
   * @param conn open database connection.
   * @param iDataType columnIndex (1-based) for java.sql.Types value.
   * @param iTypeName columnIndex (1-based) for type name.
   * @param iPrecision column index (1-based) of precision (length) of numeric types.
   * @param iLength columnIndex (1-based) of length of non-numeric types.
   * @param iScale column index (1-based) of number of decimals of numeric types.
   */
  public H2MetaColumns(ResultSet rsWrapped, Connection conn,
    int iDataType, int iTypeName, int iPrecision, int iLength, int iScale)
    throws SQLException
  {
    super(rsWrapped,conn);
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
      int iLength = getInt(_iPrecision);
      if (iLength <= 0)
        iLength = getInt(_iLength);
      String sCatalog = null;
      if (_iCatalog > 0)
        sCatalog = super.getString(_iCatalog);
      String sSchema = null;
      if (_iSchema > 0)
        sSchema = super.getString(_iSchema);
      String sTable = null;
      if (_iTable > 0)
        sTable = super.getString(_iTable);
      String sColumn = null;
      if (_iColumn > 0)
        sColumn = super.getString(_iColumn);
      sResult = getTypeName(
        sResult, 
        iLength, 
        super.getInt(_iScale), 
        _conn, 
        sCatalog, 
        sSchema, 
        sTable, 
        sColumn);
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
    String sTypeName = super.getString(_iTypeName);
    String sClassName = Object.class.getName();
    if ("GEOMETRY".equalsIgnoreCase(sTypeName))
      sClassName = Geometry.class.getName();
    else if ("UUID".equalsIgnoreCase(sTypeName))
      sClassName = UUID.class.getName();
    long lLength = super.getLong(_iPrecision);
    if (lLength <= 0)
      lLength = super.getLong(_iLength);
    if (columnIndex == _iDataType)
    {
      /***
      ResultSetMetaData rsmd = super.getMetaData();
      for (int i = 0; i < rsmd.getColumnCount(); i++)
      {
        String sColumnName = rsmd.getColumnName(i+1);
        Object o = null;
        try { o = super.getObject(i+1); }
        catch(SQLException se) { o = se; }
        System.out.println(sColumnName + ": "+String.valueOf(o));
      }
      ***/
      iResult = getDataType(
        super.getInt(_iDataType), 
        lLength,
        sClassName);
    }
    else if ((columnIndex == _iLength) ||
             (columnIndex == _iPrecision))
    {
      iResult = (int)getColumnSize(
        super.getInt(_iDataType), 
        lLength, 
        sClassName);
    }
    else if (columnIndex == _iScale)
    {
      iResult = super.getInt(_iScale);
      int iDataType = getDataType(
        super.getInt(_iDataType), 
        lLength,
        sClassName);
      if ((iDataType == Types.TIMESTAMP) && (iResult > 9))
        iResult = 9;
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
    String sTypeName = super.getString(_iTypeName);
    String sClassName = Object.class.getName();
    if ("GEOMETRY".equalsIgnoreCase(sTypeName))
      sClassName = Geometry.class.getName();
    else if ("UUID".equalsIgnoreCase(sTypeName))
      sClassName = UUID.class.getName();
    if ((columnIndex == _iLength) ||
        (columnIndex == _iPrecision))
    {
      lResult = getColumnSize(
        super.getInt(_iDataType), 
        lLength, 
        sClassName);
    }
    else
      lResult = super.getLong(columnIndex);
    return lResult;
  } /* getLong */
  
} /* class H2MetaColumns */
