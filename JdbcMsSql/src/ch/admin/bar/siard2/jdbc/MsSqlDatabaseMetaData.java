/*======================================================================
MsSqlDatabaseMetaData implements wrapped MSSQL DatabaseMetaData.
Version     : $Id: $
Application : SIARD2
Description : MsSqlDatabaseMetaData implements wrapped MSSQL DatabaseMetaData.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 01.06.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.text.*;
import java.util.*;
import java.sql.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.identifier.*;
import ch.admin.bar.siard2.mssql.*;

/*====================================================================*/
/** MsSqlDatabaseMetaData implements wrapped MSSQL DatabaseMetaData.
 * @author Hartwig Thomas
 */
public class MsSqlDatabaseMetaData
  extends BaseDatabaseMetaData
  implements DatabaseMetaData
{
  private MsSqlConnection _conn = null;
  
  private static Map<Integer,Integer> _mapTYPE_MSSQL_TO_JAVA = new HashMap<Integer,Integer>();
  private static Map<Integer, Integer> _mapTYPE_TO_ISO = new HashMap<Integer, Integer>();
  static
  {
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.IMAGE.getSystemTypeId()), Integer.valueOf(java.sql.Types.BLOB));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.TEXT.getSystemTypeId()), Integer.valueOf(java.sql.Types.CLOB));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.UUID.getSystemTypeId()), Integer.valueOf(java.sql.Types.CHAR));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.DATE.getSystemTypeId()), Integer.valueOf(java.sql.Types.DATE));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.TIME.getSystemTypeId()), Integer.valueOf(java.sql.Types.TIME));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.DATETIME2.getSystemTypeId()), Integer.valueOf(java.sql.Types.TIMESTAMP));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.DATETIMEOFFSET.getSystemTypeId()), Integer.valueOf(java.sql.Types.OTHER));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.TINYINT.getSystemTypeId()), Integer.valueOf(java.sql.Types.TINYINT));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.SMALLINT.getSystemTypeId()), Integer.valueOf(java.sql.Types.SMALLINT));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.INTEGER.getSystemTypeId()), Integer.valueOf(java.sql.Types.INTEGER));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.SMALLDATETIME.getSystemTypeId()), Integer.valueOf(java.sql.Types.TIMESTAMP));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.REAL.getSystemTypeId()), Integer.valueOf(java.sql.Types.REAL));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.MONEY.getSystemTypeId()), Integer.valueOf(java.sql.Types.DECIMAL));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.DATETIME.getSystemTypeId()), Integer.valueOf(java.sql.Types.TIMESTAMP));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.FLOAT.getSystemTypeId()), Integer.valueOf(java.sql.Types.FLOAT));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.SQL_VARIANT.getSystemTypeId()), Integer.valueOf(java.sql.Types.OTHER));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.NTEXT.getSystemTypeId()), Integer.valueOf(java.sql.Types.NCLOB));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.BIT.getSystemTypeId()), Integer.valueOf(java.sql.Types.BOOLEAN));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.DECIMAL.getSystemTypeId()), Integer.valueOf(java.sql.Types.DECIMAL));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.NUMERIC.getSystemTypeId()), Integer.valueOf(java.sql.Types.NUMERIC));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.SMALLMONEY.getSystemTypeId()), Integer.valueOf(java.sql.Types.DECIMAL));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.BIGINT.getSystemTypeId()), Integer.valueOf(java.sql.Types.BIGINT));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.VARBINARY.getSystemTypeId()), Integer.valueOf(java.sql.Types.VARBINARY));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.VARCHAR.getSystemTypeId()), Integer.valueOf(java.sql.Types.VARCHAR));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.BINARY.getSystemTypeId()), Integer.valueOf(java.sql.Types.BINARY));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.CHAR.getSystemTypeId()), Integer.valueOf(java.sql.Types.CHAR));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.TIMESTAMP.getSystemTypeId()), Integer.valueOf(java.sql.Types.BINARY));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.NVARCHAR.getSystemTypeId()), Integer.valueOf(java.sql.Types.NVARCHAR));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.NCHAR.getSystemTypeId()), Integer.valueOf(java.sql.Types.NCHAR));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.CLRUDT.getSystemTypeId()), Integer.valueOf(java.sql.Types.JAVA_OBJECT));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.XML.getSystemTypeId()), Integer.valueOf(java.sql.Types.SQLXML));
    _mapTYPE_MSSQL_TO_JAVA.put(Integer.valueOf(MsSqlType.TABLEUDT.getSystemTypeId()), Integer.valueOf(java.sql.Types.STRUCT));

    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.CHAR), Integer.valueOf(Types.CHAR));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.VARCHAR), Integer.valueOf(Types.VARCHAR));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.CLOB), Integer.valueOf(Types.CLOB));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.NCHAR), Integer.valueOf(Types.NCHAR));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.NVARCHAR), Integer.valueOf(Types.NVARCHAR));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.NCLOB), Integer.valueOf(Types.NCLOB));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.SQLXML), Integer.valueOf(Types.SQLXML));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.VARBINARY), Integer.valueOf(Types.VARBINARY));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.BINARY), Integer.valueOf(Types.BINARY));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.BLOB), Integer.valueOf(Types.BLOB));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.DECIMAL), Integer.valueOf(Types.DECIMAL));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.NUMERIC), Integer.valueOf(Types.NUMERIC));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.TINYINT), Integer.valueOf(Types.SMALLINT));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.SMALLINT), Integer.valueOf(Types.SMALLINT));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.INTEGER), Integer.valueOf(Types.INTEGER));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.BIGINT), Integer.valueOf(Types.BIGINT));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.REAL), Integer.valueOf(Types.REAL));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.FLOAT), Integer.valueOf(Types.FLOAT));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.BOOLEAN), Integer.valueOf(Types.BOOLEAN));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.DATE), Integer.valueOf(Types.DATE));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.TIME), Integer.valueOf(Types.TIME));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.TIMESTAMP), Integer.valueOf(Types.TIMESTAMP));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.OTHER), Integer.valueOf(Types.BLOB));
    _mapTYPE_TO_ISO.put(Integer.valueOf(Types.JAVA_OBJECT), Integer.valueOf(Types.BLOB));
  }

  /* map SPECIFIC_NAME ... */
  private class MetaSpecificName extends MsSqlResultSet
  {
    private static final String sSPECIFIC_NAME = "SPECIFIC_NAME";
    private int _iSpecificName = -1;
    private int _iProcedureName = -1;

    public MetaSpecificName(ResultSet rsWrapped, MsSqlConnection conn,
      int iProcedureName, int iSpecificName)
      throws SQLException
    {
      super(rsWrapped, conn);
      _iSpecificName = iSpecificName;
      _iProcedureName = iProcedureName;
    } /* constructor */

    @Override
    public String getString(int columnIndex) throws SQLException
    {
      if (columnIndex == _iSpecificName)
        columnIndex = _iProcedureName;
      return super.getString(columnIndex);
    } /* getString */

    @Override
    public String getString(String columnLabel) throws SQLException
    {
      String sResult = null;
      if (columnLabel.equals(sSPECIFIC_NAME))
      {
        /***
        ResultSetMetaData rsmd = getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
        {
          System.out.println(String.valueOf(i)+" "+rsmd.getColumnName(i)+
            ": "+getString(rsmd.getColumnLabel(i)));
        }
        ***/
        sResult = getString(_iSpecificName);
      }
      else
        sResult = super.getString(columnLabel);
      return sResult;
    } /* getString */
  } /* MetaSpecificName */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param dmdWrapped database meta data to be wrapped.
   */
  public MsSqlDatabaseMetaData(DatabaseMetaData dmdWrapped, MsSqlConnection conn)
  {
    super(dmdWrapped);
    _conn = conn;
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Connection getConnection() throws SQLException
  {
    return _conn;
  } /* getConnection */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * Use MsSqlMetaColumn for data type translation.
   */
  @Override
  public ResultSet getColumns(String catalog, String schemaPattern,
    String tableNamePattern, String columnNamePattern)
    throws SQLException
  {
    return new MsSqlMetaColumns(super.getColumns(catalog, schemaPattern, 
      tableNamePattern, columnNamePattern),_conn,
      1,2,5,6,7,7,9);
  } /* getColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getTypeInfo() throws SQLException
  {
    return super.getTypeInfo();
  } /* getTypeInfo */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getProcedures(String catalog, String schemaPattern,
    String procedureNamePattern) throws SQLException
  {
    return new MetaSpecificName(
      super.getProcedures(catalog, schemaPattern, procedureNamePattern),
      _conn,3,9);
  } /* getProcedures */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getProcedureColumns(String catalog,
    String schemaPattern, String procedureNamePattern,
    String columnNamePattern) throws SQLException
  {
    return new MetaSpecificName(
      new MsSqlMetaColumns(
        super.getProcedureColumns(catalog, schemaPattern,procedureNamePattern, columnNamePattern),
        _conn,1,2,6,7,8,9,10),
      _conn,3,20);
  } /* getProcedureColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getTables(String catalog, String schemaPattern, 
    String tableNamePattern, String[] types)
    throws SQLException
  {
    if (types == null)
      types = new String[] {"TABLE", "VIEW", "TABLE TYPE", "SYSTEM TABLE"};
    StringBuilder sbCondition = new StringBuilder();
    for (int i = 0; i < types.length; i++)
    {
      if (i == 0)
      { 
        if (types.length > 1)
          sbCondition.append(" (");
      }
      else
        sbCondition.append("  OR ");
      sbCondition.append("o.type = '");
      if (types[i].equals("TABLE"))
        sbCondition.append("U");
      else if (types[i].equals("VIEW"))
        sbCondition.append("V");
      else if (types[i].equals("TABLE TYPE"))
        sbCondition.append("TT");
      else if (types[i].equals("SYSTEM TABLE"))
        sbCondition.append("S");
      sbCondition.append("' AND is_ms_shipped = ");
      if (!types[i].equals("SYSTEM TABLE"))
        sbCondition.append("0");
      else
        sbCondition.append("1");
      if (i == types.length-1)
      {
        if (types.length > 1)
          sbCondition.append(")");
      }
      sbCondition.append("\r\n");
    }
    if (catalog != null)
      sbCondition.append(" AND DB_NAME() = "+SqlLiterals.formatStringLiteral(catalog)+"\r\n");
    if (schemaPattern != null)
      sbCondition.append(" AND s.name LIKE "+SqlLiterals.formatStringLiteral(schemaPattern)+" ESCAPE '"+getSearchStringEscape()+"'\r\n");
    if (tableNamePattern != null)
      sbCondition.append(" AND o.name LIKE "+SqlLiterals.formatStringLiteral(tableNamePattern)+" ESCAPE '"+getSearchStringEscape()+"'\r\n");
    StringBuilder sbCaseTableType = new StringBuilder("  case o.type\r\n");
    sbCaseTableType.append("    when 'U' then 'TABLE'\r\n");
    sbCaseTableType.append("    when 'V' then 'VIEW'\r\n");
    sbCaseTableType.append("    when 'TT' then 'TABLE TYPE'\r\n");
    sbCaseTableType.append("    else 'SYSTEM TABLE'\r\n");
    sbCaseTableType.append("  end");
    StringBuilder sbSql = new StringBuilder("SELECT\r\n");
    sbSql.append("  DB_NAME() AS TABLE_CAT,\r\n");
    sbSql.append("  s.name AS TABLE_SCHEM,\r\n");
    sbSql.append("  o.name AS TABLE_NAME,\r\n");
    sbSql.append(sbCaseTableType.toString());
    sbSql.append(" AS TABLE_TYPE,\r\n");
    sbSql.append("  CAST(p.value AS VARCHAR(7500)) AS REMARKS,\r\n");
    sbSql.append("  NULL AS TYPE_CAT,\r\n");
    sbSql.append("  NULL AS TYPE_SCHEM,\r\n");
    sbSql.append("  NULL AS TYPE_NAME,\r\n");
    sbSql.append("  NULL AS SELF_REFERENCING_COL_NAME,\r\n");
    sbSql.append("  NULL AS REF_GENERATION,\r\n");
    sbSql.append("  m.definition as "+_sQUERY_TEXT+"\r\n");
    sbSql.append("FROM sys.all_objects o\r\n");
    sbSql.append("  JOIN sys.schemas s\r\n");
    sbSql.append("    ON (o.schema_id = s.schema_id)\r\n");
    sbSql.append("  LEFT JOIN sys.sql_modules m\r\n"); 
    sbSql.append("    ON (m.object_id = o.object_id)\r\n");
    sbSql.append("  LEFT JOIN sys.extended_properties p\r\n");
    sbSql.append("    ON (p.major_id = o.object_id\r\n");
    sbSql.append("        AND p.minor_id = 0\r\n");
    sbSql.append("        AND p.class = 1)\r\n");
    sbSql.append("WHERE\r\n");
    sbSql.append(sbCondition.toString());
    sbSql.append("ORDER BY TABLE_TYPE, TABLE_CAT, TABLE_SCHEM, TABLE_NAME");
    Statement stmt = getConnection().createStatement();
    return stmt.unwrap(Statement.class).executeQuery(sbSql.toString());
  } /* getTables */
  
  @Override
  public ResultSet getTableTypes()
    throws SQLException
  {
    return super.getTableTypes();
  } /* getTableTypes */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getUDTs(String catalog, String schemaPattern,
    String typeNamePattern, int[] types) throws SQLException
  {
    StringBuilder sbCaseDataType = new StringBuilder("case t.system_type_id\r\n");
    sbCaseDataType.append("when ");
    sbCaseDataType.append(String.valueOf(MsSqlType.CLRUDT.getSystemTypeId()));
    sbCaseDataType.append(" then ");
    sbCaseDataType.append(String.valueOf(Types.JAVA_OBJECT)); // using "JAVA_OBJECT" for "CLR UDT"
    sbCaseDataType.append("\r\n");
    sbCaseDataType.append("when ");
    sbCaseDataType.append(String.valueOf(MsSqlType.TABLEUDT.getSystemTypeId()));
    sbCaseDataType.append(" then ");
    sbCaseDataType.append(String.valueOf(Types.STRUCT));
    sbCaseDataType.append("\r\n");
    sbCaseDataType.append("else ");
    sbCaseDataType.append(String.valueOf(Types.DISTINCT));
    sbCaseDataType.append("\r\nend");
    
    // Type name may be "fully qualified". In that case it cannot be "as it is stored in the database"!
    try 
    {
      // attempt to parse the typeNamePattern as a fully qualified name.
      QualifiedId qi = new QualifiedId(typeNamePattern);
      // if it succeeds and is qualified at least by a schema, then overwrite schemaPattern and catalog 
      if (qi.getSchema() != null)
      {
        schemaPattern = qi.getSchema();
        catalog = qi.getCatalog();
      }
    }
    catch(ParseException pe) { }
    StringBuilder sbCondition = new StringBuilder("t.system_type_id <> t.user_type_id\r\n");
    if (catalog != null)
      sbCondition.append("AND DB_NAME() = "+SqlLiterals.formatStringLiteral(catalog)+"\r\n");
    if (schemaPattern != null)
      sbCondition.append("AND s.name LIKE "+SqlLiterals.formatStringLiteral(schemaPattern)+" ESCAPE '"+getSearchStringEscape()+"'\r\n");
    if (typeNamePattern != null)
      sbCondition.append("AND t.name LIKE "+SqlLiterals.formatStringLiteral(typeNamePattern)+" ESCAPE '"+getSearchStringEscape()+"'\r\n");
    if (types != null)
    {
      StringBuilder sbTypesSet = new StringBuilder();
      for (int i = 0; i < types.length; i++)
      {
        if (i > 0)
          sbTypesSet.append(", ");
        sbTypesSet.append(String.valueOf(types[i]));
      }
      if (sbTypesSet.length() > 0)
        sbCondition.append("AND "+sbCaseDataType.toString()+" IN ("+sbTypesSet.toString()+")\r\n");
    }
    
    StringBuilder sbCaseBaseType = new StringBuilder("case t.system_type_id\r\n");
    for (int i = 0; i < MsSqlType.values().length; i++)
    {
      MsSqlType mst = MsSqlType.values()[i];
      int iType = _mapTYPE_MSSQL_TO_JAVA.get(mst.getSystemTypeId()).intValue();
      if (iType != Types.STRUCT)
      {
        if (i > 0)
          sbCaseBaseType.append("\r\n");
        sbCaseBaseType.append("when ");
        sbCaseBaseType.append(String.valueOf(mst.getSystemTypeId()));
        sbCaseBaseType.append(" then ");
        sbCaseBaseType.append(_mapTYPE_TO_ISO.get(Integer.valueOf(iType)).toString());
      }
    }
    sbCaseBaseType.append("\r\nelse NULL\r\n");
    sbCaseBaseType.append("end");
    
    String sSql = "select\r\n"+
      "DB_NAME() AS TYPE_CAT,\r\n"+
      "s.name AS TYPE_SCHEM,\r\n"+
      "t.name AS TYPE_NAME,\r\n"+
      "at.assembly_qualified_name AS CLASSNAME,\r\n"+ // is really the CLR class ...
      sbCaseDataType.toString()+" AS DATA_TYPE,\r\n"+
      "NULL AS REMARKS,\r\n"+
      sbCaseBaseType.toString()+" AS BASE_TYPE\r\n"+
      "from\r\n"+
      "sys.schemas s\r\n"+
      "  INNER JOIN\r\n"+
      "(sys.types t\r\n"+
      "   LEFT JOIN\r\n"+
      " sys.assembly_types at\r\n"+
      " ON t.user_type_id = at.user_type_id\r\n"+
      ")\r\n"+
      "ON s.schema_id = t.schema_id\r\n"+
      "WHERE "+sbCondition.toString()+
      "ORDER BY DATA_TYPE, TYPE_CAT, TYPE_SCHEM, TYPE_NAME";
    Statement stmt = getConnection().createStatement();
    return stmt.unwrap(Statement.class).executeQuery(sSql);
  } /* getUDTs */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getAttributes(String catalog, String schemaPattern,
    String typeNamePattern, String attributeNamePattern)
    throws SQLException
  {
    return new MsSqlMetaColumns(
      super.getAttributes(catalog, schemaPattern, typeNamePattern, attributeNamePattern), 
      _conn, 1,2,5,6,7,7,8);
  } /* getAttributes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getFunctions(String catalog, String schemaPattern,
    String functionNamePattern) throws SQLException
  {
    return new MetaSpecificName(
      super.getFunctions(catalog, schemaPattern, functionNamePattern),
      _conn,3,6);
  } /* getFunctions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getFunctionColumns(String catalog,
    String schemaPattern, String functionNamePattern,
    String columnNamePattern) throws SQLException
  {
    return new MetaSpecificName(
      new MsSqlMetaColumns(
        super.getFunctionColumns(catalog, schemaPattern,functionNamePattern, columnNamePattern),
        _conn,1,2,6,7,8,9,10),
      _conn,3,17);
    
  } /* getFunctionColumns */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getCrossReference(
    String parentCatalog, String parentSchema, String parentTable,
    String foreignCatalog, String foreignSchema, String foreignTable)
    throws SQLException
  {
    String sSql = "SELECT\r\n"+ 
      "  TCPK.TABLE_CATALOG AS PKTABLE_CAT,\r\n"+
      "  TCPK.TABLE_SCHEMA AS PKTABLE_SCHEM,\r\n"+
      "  TCPK.TABLE_NAME AS PKTABLE_NAME,\r\n"+
      "  KCUPK.COLUMN_NAME AS PKCOLUMN_NAME,\r\n"+
      "  TCFK.TABLE_CATALOG AS FKTABLE_CAT,\r\n"+
      "  TCFK.TABLE_SCHEMA AS FKTABLE_SCHEM,\r\n"+
      "  TCFK.TABLE_NAME AS FKTABLE_NAME,\r\n"+
      "  KCUFK.COLUMN_NAME AS FKCOLUMN_NAME,\r\n"+
      "  KCUFK.ORDINAL_POSITION AS KEY_SEQ,\r\n"+
      "  CASE RC.UPDATE_RULE\r\n"+
      "    WHEN 'NO ACTION' THEN "+String.valueOf(DatabaseMetaData.importedKeyNoAction)+"\r\n"+
      "    WHEN 'CASCADE' THEN "+String.valueOf(DatabaseMetaData.importedKeyCascade)+"\r\n"+
      "    WHEN 'SET NULL' THEN "+String.valueOf(DatabaseMetaData.importedKeySetNull)+"\r\n"+
      "    WHEN 'SET DEFAULT' THEN "+String.valueOf(DatabaseMetaData.importedKeySetDefault)+"\r\n"+
      "    WHEN 'RESTRICT' THEN "+String.valueOf(DatabaseMetaData.importedKeyRestrict)+"\r\n"+
      "  END AS UPDATE_RULE,\r\n"+
      "  CASE RC.DELETE_RULE\r\n"+
      "    WHEN 'NO ACTION' THEN "+String.valueOf(DatabaseMetaData.importedKeyNoAction)+"\r\n"+
      "    WHEN 'CASCADE' THEN "+String.valueOf(DatabaseMetaData.importedKeyCascade)+"\r\n"+
      "    WHEN 'SET NULL' THEN "+String.valueOf(DatabaseMetaData.importedKeySetNull)+"\r\n"+
      "    WHEN 'SET DEFAULT' THEN "+String.valueOf(DatabaseMetaData.importedKeySetDefault)+"\r\n"+
      "    WHEN 'RESTRICT' THEN "+String.valueOf(DatabaseMetaData.importedKeyRestrict)+"\r\n"+
      "  END AS DELETE_RULE,\r\n"+
      "  TCFK.CONSTRAINT_NAME AS FK_NAME,\r\n"+
      "  TCPK.CONSTRAINT_NAME AS PK_NAME,\r\n"+
      "  CASE\r\n"+
      "    WHEN TCFK.IS_DEFERRABLE = 'NO' THEN "+String.valueOf(DatabaseMetaData.importedKeyNotDeferrable)+"\r\n"+
      "    WHEN TCFK.IS_DEFERRABLE = 'YES' AND TCFK.INITIALLY_DEFERRED = 'YES' THEN "+String.valueOf(DatabaseMetaData.importedKeyInitiallyDeferred)+"\r\n"+
      "    ELSE "+String.valueOf(DatabaseMetaData.importedKeyInitiallyImmediate)+"\r\n"+
      "  END AS DEFERRABILITY\r\n"+
      "FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS RC\r\n"+
      "  INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS TCFK\r\n"+
      "    ON (RC.CONSTRAINT_CATALOG = TCFK.CONSTRAINT_CATALOG AND\r\n"+
      "        RC.CONSTRAINT_SCHEMA = TCFK.CONSTRAINT_SCHEMA AND\r\n"+
      "        RC.CONSTRAINT_NAME = TCFK.CONSTRAINT_NAME AND\r\n"+
      "        TCFK.CONSTRAINT_TYPE = 'FOREIGN KEY')\r\n"+
      "  INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE KCUFK\r\n"+
      "    ON (RC.CONSTRAINT_CATALOG = KCUFK.CONSTRAINT_CATALOG AND\r\n"+
      "        RC.CONSTRAINT_SCHEMA = KCUFK.CONSTRAINT_SCHEMA AND\r\n"+
      "        RC.CONSTRAINT_NAME = KCUFK.CONSTRAINT_NAME)\r\n"+
      "  INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS TCPK\r\n"+
      "    ON (RC.UNIQUE_CONSTRAINT_CATALOG = TCPK.CONSTRAINT_CATALOG AND\r\n"+
      "        RC.UNIQUE_CONSTRAINT_SCHEMA = TCPK.CONSTRAINT_SCHEMA AND\r\n"+
      "        RC.UNIQUE_CONSTRAINT_NAME = TCPK.CONSTRAINT_NAME)\r\n"+
      "  INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE KCUPK\r\n"+
      "    ON (RC.UNIQUE_CONSTRAINT_CATALOG = KCUPK.CONSTRAINT_CATALOG AND\r\n"+
      "        RC.UNIQUE_CONSTRAINT_SCHEMA = KCUPK.CONSTRAINT_SCHEMA AND\r\n"+
      "        RC.UNIQUE_CONSTRAINT_NAME = KCUPK.CONSTRAINT_NAME)\r\n";
    StringBuilder sbCondition = new StringBuilder();
    if (parentCatalog != null)
    {
      if (sbCondition.length() > 0) sbCondition.append(" AND ");
      sbCondition.append("TCPK.TABLE_CATALOG = "+SqlLiterals.formatStringLiteral(parentCatalog));
    }
    if (parentSchema != null)
    {
      if (sbCondition.length() > 0) sbCondition.append(" AND ");
      sbCondition.append("TCPK.TABLE_SCHEMA = "+SqlLiterals.formatStringLiteral(parentSchema));
    }
    if (parentTable != null)
    {
      if (sbCondition.length() > 0) sbCondition.append(" AND ");
      sbCondition.append("TCPK.TABLE_NAME = "+SqlLiterals.formatStringLiteral(parentTable));
    }
    if (foreignCatalog != null)
    {
      if (sbCondition.length() > 0) sbCondition.append(" AND ");
      sbCondition.append("TCFK.TABLE_CATALOG = "+SqlLiterals.formatStringLiteral(foreignCatalog));
    }
    if (foreignSchema != null)
    {
      if (sbCondition.length() > 0) sbCondition.append(" AND ");
      sbCondition.append("TCFK.TABLE_SCHEMA = "+SqlLiterals.formatStringLiteral(foreignSchema));
    }
    if (foreignTable != null)
    {
      if (sbCondition.length() > 0) sbCondition.append(" AND ");
      sbCondition.append("TCFK.TABLE_NAME = "+SqlLiterals.formatStringLiteral(foreignTable));
    }
    if (sbCondition.length() > 0)
      sSql = sSql + "WHERE "+sbCondition+"\r\n"+
        "ORDER BY FKTABLE_SCHEM, FKTABLE_NAME, KEY_SEQ";
        // "ORDER BY TC.TABLE_SCHEMA, TC.TABLE_NAME,KCU.POSITION_IN_UNIQUE_CONSTRAINT";
    Statement stmt = this.getConnection().createStatement();
    return stmt.unwrap(Statement.class).executeQuery(sSql);
  } /* getCrossReference */

} /* class MsSqlDatabaseMetaData */
