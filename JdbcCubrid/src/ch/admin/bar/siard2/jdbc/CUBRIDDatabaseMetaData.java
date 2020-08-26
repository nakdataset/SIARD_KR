/*======================================================================
CubridDatabaseMetaData implements a wrapped Cubrid DatabaseMetaData.
Version     : $Id: $
Application : SIARD2
Description : CubridDatabaseMetaData implements a wrapped Cubrid DatabaseMetaData.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 27.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.ArrayList;

import ch.enterag.utils.jdbc.*;
import ch.enterag.sqlparser.*;

/* =============================================================================== */
/**
 * CubridDatabaseMetaData implements a wrapped Cubrid DatabaseMetaData
 * @author Byungwook Kim
 */
public class CUBRIDDatabaseMetaData 
  extends BaseDatabaseMetaData 
  implements DatabaseMetaData 
{
	boolean is_closed;
	int major_version;
	int minor_version;
	
	private CUBRIDConnection _conn = null;
	/**
	 * Constructor 
	 * @param dmdWrapped database meta data to wrapped
	 */
	public CUBRIDDatabaseMetaData(DatabaseMetaData dmdWrapped, CUBRIDConnection conn)
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
  
	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		return super.getBestRowIdentifier(schema, catalog, table, scope, nullable);
	} /* getBestRowIdentifier */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException 
	{
	  ResultSet rs = null;
		if (catalog == null)
		  rs = super.getVersionColumns(schema, catalog, table);
		else
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		return rs; 
	} /* getVersionColumns */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
		return super.supportsResultSetConcurrency(type, concurrency);
	} /* supportsResultSetConcurrency */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		
		return super.getIndexInfo(catalog, schema, table, unique, approximate);
	} /* getIndexInfo */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		return super.getColumnPrivileges(schema, catalog, table, columnNamePattern);
	} /* getColumnPrivileges */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		
		return super.getTablePrivileges(catalog, schemaPattern, tableNamePattern);
	} /* getTablePrivileges */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException 
	{
		if (catalog != null) { throw new SQLException("Cubrid does not support catalogs, argument must be NULL."); }
		
		return super.getPrimaryKeys(catalog, schema, table);
	} /* getPrimaryKeys */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		return super.getAttributes(schemaPattern, catalog, typeNamePattern, attributeNamePattern);
	} /* getAttributes */

  /* ------------------------------------------------------------------------ */
	@SuppressWarnings("unused")
	private String getNameCondition(String sColumn, String sName)
	{
	  StringBuilder sbCondition = new StringBuilder();
    if (sName != null)
    {
      sbCondition.append("  AND ");
      if (sName.startsWith("\""))
      {
        sbCondition.append(sColumn);
        sbCondition.append(" = ");
        sbCondition.append(SqlLiterals.formatStringLiteral(sName));
      }
      else
      {
        sbCondition.append("LOWER(");
        sbCondition.append(sColumn);
        sbCondition.append(") = LOWER(");
        sbCondition.append(SqlLiterals.formatStringLiteral(sName));
        sbCondition.append(")");
      }
      sbCondition.append("\r\n");
    }
    return sbCondition.toString();
	} /* getNameCondition */
	
  /* ------------------------------------------------------------------------ */
  /**
   * {@inheritDoc}
   */
  @Override
  public ResultSet getCrossReference(
    String parentCatalog, String parentSchema, String parentTable, 
    String foreignCatalog, String foreignSchema, String foreignTable) 
      throws SQLException 
  {
    if (parentCatalog != null || foreignCatalog != null) 
      throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
    
    return super.getCrossReference(parentCatalog, parentSchema, parentTable, foreignCatalog, foreignSchema, foreignTable);
  } /* getCrossReference */

  /* ------------------------------------------------------------------------ */
  /**
   * {@inheritDoc}
   */
  @Override
  public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException 
  {
    if (catalog != null) { throw new SQLException("Cubrid does not support catalogs, argument must be NULL."); }
 
	return super.getImportedKeys(catalog, schema, table);
  } /* getImportedKeys */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException 
	{
		if (catalog != null) { 
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		
		return super.getExportedKeys(catalog, schema, table);
	} /* getExportedKeys */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT  NULL AS FUNCTION_CAT,\n" + 
				"'" +	getConnection().getSchema() + "' AS FUNCTION_SCHEM, \n" + 
				"		a.SP_NAME AS FUNCTION_NAME, \n" + 
				"		arg_name AS COLUMN_NAME, \n" + 
				"		CASE \n" + 
				"			WHEN MODE = 'OUT' THEN 4 \n" + 
				"			WHEN MODE = 'INOUT' THEN 2 \n" + 
				"			WHEN MODE = 'IN' THEN 1 \n" + 
				"			WHEN MODE = NULL THEN 5 \n" + 
				"		ELSE 0 END AS COLUMN_TYPE, \n" + 
				"		-1 AS DATA_TYPE, \n" + 
				"		DATA_TYPE AS TYPE_NAME, \n" + 
				"		NULL AS `PRECISION`, \n" + 
				"		NULL AS LENGTH, \n" + 
				"		NULL AS SCALE, \n" + 
				"		10 AS RADIX, \n" + 
				"		0 AS NULLABLE, \n" + 
				"		NULL AS REMARKS, \n" + 
				"		NULL AS CHAR_OCTET_LENGTH, \n" + 
				"		index_of + 1 as ORDINAL_POSITION, \n" + 
				"		'' AS IS_NULLABLE, \n" + 
				"		NULL as SPECIFIC_NAME \n" + 
				"FROM db_stored_procedure p, db_stored_procedure_args a \n");

		// where clause criteria
		ArrayList<String> whereClauseComponents = new ArrayList<String>();
		whereClauseComponents.add("P.SP_TYPE = 'FUNCTION'");
		whereClauseComponents.add("P.SP_NAME = A.SP_NAME");
		
		if(functionNamePattern != null) {
			whereClauseComponents.add("P.SP_NAME LIKE " + SqlLiterals.formatStringLiteral(functionNamePattern));
		}
		if(columnNamePattern != null) {
			whereClauseComponents.add("A.ARG_NAME LIKE " + SqlLiterals.formatStringLiteral(columnNamePattern));
		}

		StringBuilder sbWhereClause = new StringBuilder();
		for(int i=0; i<whereClauseComponents.size(); i++) {
			if(i>0) {
				sbWhereClause.append(" AND ");
			}
			sbWhereClause.append(whereClauseComponents.get(i));
		}
		sb.append("WHERE ");
		sb.append(sbWhereClause.toString());
		sb.append("\r\n");

		// order according to the JDBC specification
		sb.append("ORDER BY FUNCTION_CAT, FUNCTION_SCHEM, FUNCTION_NAME, SPECIFIC_NAME, ORDINAL_POSITION");
		
		Statement stmt = this.getConnection().createStatement();
		return new CUBRIDMetaColumns(stmt.unwrap(Statement.class).executeQuery(sb.toString()), 6, 7, 8, 9, _conn);
	} /* getFunctionColumns */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT  NULL AS PROCEDURE_CAT,\n" + 
				"'" +	getConnection().getSchema() + "' AS PROCEDURE_SCHEM, \n" + 
				"		a.SP_NAME AS PROCEDURE_NAME, \n" + 
				"		arg_name AS COLUMN_NAME, \n" + 
				"		CASE \n" + 
				"			WHEN MODE = 'OUT' THEN 4 \n" + 
				"			WHEN MODE = 'INOUT' THEN 2 \n" + 
				"			WHEN MODE = 'IN' THEN 1 \n" + 
				"			WHEN MODE = NULL THEN 5 \n" + 
				"		ELSE 0 END AS COLUMN_TYPE, \n" + 
				"		-1 AS DATA_TYPE, \n" + 
				"		DATA_TYPE AS TYPE_NAME, \n" + 
				"		NULL AS `PRECISION`, \n" + 
				"		NULL AS LENGTH, \n" + 
				"		NULL AS SCALE, \n" + 
				"		10 AS RADIX, \n" + 
				"		0 AS NULLABLE, \n" + 
				"		NULL AS REMARKS, \n" + 
				"		NULL AS CHAR_OCTET_LENGTH, \n" + 
				"		index_of + 1 as ORDINAL_POSITION, \n" + 
				"		'' AS IS_NULLABLE, \n" + 
				"		NULL as SPECIFIC_NAME \n" + 
				"FROM db_stored_procedure p, db_stored_procedure_args a \n");

		// where clause criteria
		ArrayList<String> whereClauseComponents = new ArrayList<String>();
		whereClauseComponents.add("P.SP_TYPE = 'PROCEDURE'");
		whereClauseComponents.add("P.SP_NAME = A.SP_NAME");
		
		if(procedureNamePattern != null) {
			whereClauseComponents.add("P.SP_NAME LIKE " + SqlLiterals.formatStringLiteral(procedureNamePattern));
		}
		if(columnNamePattern != null) {
			whereClauseComponents.add("A.ARG_NAME LIKE " + SqlLiterals.formatStringLiteral(columnNamePattern));
		}

		StringBuilder sbWhereClause = new StringBuilder();
		for(int i=0; i<whereClauseComponents.size(); i++) {
			if(i>0) {
				sbWhereClause.append(" AND ");
			}
			sbWhereClause.append(whereClauseComponents.get(i));
		}
		sb.append("WHERE ");
		sb.append(sbWhereClause.toString());
		sb.append("\r\n");

		// order according to the JDBC specification
		sb.append("ORDER BY PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME, SPECIFIC_NAME, ORDINAL_POSITION");
		
		Statement stmt = this.getConnection().createStatement();
		return new CUBRIDMetaColumns(stmt.unwrap(Statement.class).executeQuery(sb.toString()), 6, 7, 8, 9, _conn);
	} /* getProcedureColumns */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	public ResultSet getTriggers(String catalog, String schemaPattern, String tableNamePattern, String triggerNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}

		StringBuilder sbCondition = new StringBuilder();
		String cond;
		
		sbCondition.append("target_class in (SELECT class_of FROM db_class WHERE");
		
		if ((triggerNamePattern == null) || triggerNamePattern.equals("%"))
		    {
		      sbCondition.append(" class_name LIKE '%' ");      
		    }
		else
		    {
			  cond = SqlLiterals.formatStringLiteral(triggerNamePattern);
		      sbCondition.append(" class_name LIKE ");
		      sbCondition.append(cond);
		    }		 
		
		sbCondition.append(")");
	    
		ResultSet rsTriggers = null;

	    String sSql = "SELECT\r\n" +
	    		"name,\r\n" +
	    		"status,\r\n" +
	    		"priority,\r\n" +
	    		"event,\r\n" +
	    		"target_attribute,\r\n" +
	    		"condition_type,\r\n" +
	    		"condition,\r\n" +
	    		"condition_time,\r\n" +
	    		"action_type,\r\n" +
	    		"action_definition,\r\n" +
	    		"action_time,\r\n" +
	    		"comment\r\n" +
			"FROM db_trigger\r\n" +
	 		"WHERE " + sbCondition.toString();
		
		  Statement stmt = getConnection().createStatement();
		  rsTriggers = stmt.unwrap(Statement.class).executeQuery(sSql);
		  return rsTriggers;
	} /* getProcedures */
	
	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		
		StringBuilder sbCondition = new StringBuilder();
		
		sbCondition.append("SP_TYPE = 'FUNCTION' ");
		if ((functionNamePattern == null) || functionNamePattern.equals("%"))
		    {
		      sbCondition.append("AND SP_NAME LIKE '%' ");
		      
		    }
		else
		    {
		      sbCondition.append("AND SP_NAME LIKE ");
		      sbCondition.append(SqlLiterals.formatStringLiteral(functionNamePattern));
		    }
		 
		ResultSet rsFunctions = null;
		    
	    String sSql = "SELECT\r\n" +
	    		"NULL as FUNCTION_CAT,\r\n" +
	    		"'" + getConnection().getSchema() + "' as FUNCTION_SCHEM,\r\n" +
	    		"SP_NAME AS FUNCTION_NAME,\r\n" +
	    		"'RETURN ' + return_type + ' AS Language ' + lang + ' NAME ' + '''' + target + '''' as REMARKS,\r\n" +
	    		"0 as FUNCTION_TYPE,\r\n" +
	    		"NULL AS SPECIFIC_NAME \r\n" +
			"FROM db_stored_procedure\r\n" +
	 		"WHERE " + sbCondition.toString() + "\r\n" + 
	 		"ORDER BY FUNCTION_CAT, FUNCTION_SCHEM, FUNCTION_NAME, SPECIFIC_NAME";
		
		  Statement stmt = getConnection().createStatement();
		  rsFunctions = stmt.unwrap(Statement.class).executeQuery(sSql);
		  return rsFunctions;
	} /* getFunctions */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}

		StringBuilder sbCondition = new StringBuilder();
		String cond;

		sbCondition.append("SP_TYPE = 'PROCEDURE'");
		
		if ((procedureNamePattern == null) || procedureNamePattern.equals("%"))
		    {
		      sbCondition.append(" AND SP_NAME LIKE '%' ");      
		    }
		else
		    {
			  cond = SqlLiterals.formatStringLiteral(procedureNamePattern);
		      sbCondition.append(" AND SP_NAME LIKE ");
		      sbCondition.append(cond);
		    }		 
		
		ResultSet rsProcedures = null;

	    String sSql = "SELECT\r\n" +
	    		"NULL as PROCEDURE_CAT,\r\n" +
	    		"'" + getConnection().getSchema() + "' as PROCEDURE_SCHEM,\r\n" +
	    		"SP_NAME AS PROCEDURE_NAME,\r\n" +
	    		"NULL as RESERVED1,\r\n" +
	    		"NULL as RESERVED2,\r\n" +
	    		"NULL as RESERVED3,\r\n" +
	    		"'AS Language ' + lang + ' NAME ' + '''' + target + '''' as REMARKS,\r\n" +
	    		"0 as PROCEDURE_TYPE,\r\n" +
	    		"NULL as SPECIFIC_NAME\r\n" +
			"FROM db_stored_procedure\r\n" +
	 		"WHERE " + sbCondition.toString() + "\r\n" + 
	 		"ORDER BY PROCEDURE_CAT, PROCEDURE_SCHEM, PROCEDURE_NAME, SPECIFIC_NAME";
		
		  Statement stmt = getConnection().createStatement();
		  rsProcedures = stmt.unwrap(Statement.class).executeQuery(sSql);
		  return rsProcedures;
	} /* getProcedures */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@Override}
	 */
	@Override
	public ResultSet getSchemas() throws SQLException {
		String sSql = "SELECT " + getConnection().getSchema() + "' AS TABLE_SCHEM, NULL AS TABLE_CATALOG FROM DB_ROOT";
		Statement stmt = this.getConnection().createStatement();
		return stmt.unwrap(Statement.class).executeQuery(sSql);
	} /* getSchemas */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}

		return super.getSchemas(catalog, schemaPattern);
	} /* getSchemas */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		return super.getSuperTables(schemaPattern, catalog, tableNamePattern);
	} /* getSuperTables */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}
		return super.getSuperTypes(schemaPattern, catalog, typeNamePattern);
	} /* getSuperTypes */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 * @throws SQLException 
	 */
	@Override
	public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException 
	{
		if (catalog != null)
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		
		return super.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern);
	} /* getColumns */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}

		return super.getTables(catalog, schemaPattern, tableNamePattern, types);
	} /* getTables */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types) throws SQLException {
		if (catalog != null) {
			throw new SQLException("Cubrid does not support catalogs, argument must be NULL.");
		}

		ResultSet rsUdts;

		StringBuilder sbCondition = new StringBuilder("T.TYPE_NAME LIKE ");
	    sbCondition.append(SqlLiterals.formatStringLiteral(typeNamePattern));
		    
	    String sSql = "SELECT\r\n" +
	    		"NULL as TYPE_CAT,\r\n" +
	    		"'" + getConnection().getSchema() + "' as TYPE_SCHEM,\r\n" +
	    		"T.TYPE_NAME AS TYPE_NAME,\r\n" +
				"null AS TYPE_NAME,\r\n" +
	    		"NULL as CLASS_NAME,\r\n" +
	    		String.valueOf(Types.STRUCT) + " as DATA_TYPE,\r\n" +
				"NULL as DATA_TYPE,\r\n" +
	    		"NULL as REMARKS,\r\n" +
	    		"NULL as BASE_TYPE\r\n" +
			"FROM _db_data_type T\r\n" +
	 		"WHERE " + sbCondition.toString() + "\r\n" + 
	 		"ORDER BY DATA_TYPE, TYPE_CAT, TYPE_SCHEM, TYPE_NAME";
		
		  Statement stmt = getConnection().createStatement();
		  rsUdts = stmt.unwrap(Statement.class).executeQuery(sSql);
		  return rsUdts;
	} /* getUDTs */


} /* class CubridDatabaseMetaData */
