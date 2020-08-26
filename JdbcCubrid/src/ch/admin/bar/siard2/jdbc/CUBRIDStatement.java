/*======================================================================
CubridStatement implements a wrapped Cubrid Statement
Version     : $Id: $
Application : SIARD2
Description : CubridSqlFactory implements a wrapped Cubrid SqlFactory.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 26.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.sqlparser.identifier.*;

/* =============================================================================== */
/**
 * CubridStatement implements a wrapped Cubrid Statement
 * @author Simon Jutz
 */
public class CUBRIDStatement extends BaseStatement implements Statement 
{
  private CUBRIDConnection _conn = null;
  
	/* ------------------------------------------------------------------------ */
	/**
	 * @param stmtWrapped Statement to be wrapped
	 */
	public CUBRIDStatement(Statement stmtWrapped, CUBRIDConnection conn)
	  throws SQLException
	{
		super(stmtWrapped);
    _conn = conn;
	} /* constructor */

	/* ------------------------------------------------------------------------ */
	/** {@inheritDoc} */
	@Override
	public Connection getConnection() throws SQLException {
		return _conn;
	} /* getConnection */

	  /*------------------------------------------------------------------*/
	  /** dropReferencingKeys drops referencing foreign keys in preparation 
	   * for a DROP TABLE CASCADE statement.
	   * @param qiTable table referenced by foreign keys to be dropped.
	   * @throws SQLException
	   */
	  private void dropReferencingKeys(QualifiedId qiTable)
	    throws SQLException
	  {
	    if (qiTable != null)
	    {
	      BaseDatabaseMetaData bdmd = (BaseDatabaseMetaData)getConnection().getMetaData();
	      ResultSet rs = null;
	      try
	      {
	        rs = bdmd.getCrossReference(
	          qiTable.getCatalog(), 
	          bdmd.toPattern(qiTable.getSchema()), 
	          bdmd.toPattern(qiTable.getName()), 
	          null,null,"%");
	        while (rs.next())
	        {
	          QualifiedId qiFkTable = new QualifiedId(
	            rs.getString("FKTABLE_CAT"),
	            rs.getString("FKTABLE_SCHEM"),
	            rs.getString("FKTABLE_NAME"));
	          Identifier idFkName = new Identifier(rs.getString("FK_NAME"));
	          Statement stmt = null;
	          try
	          {
	            stmt = _conn.createStatement();
	            String sSql = "ALTER TABLE "+qiFkTable.format()+" DROP FOREIGN KEY "+idFkName.format();
	            stmt.execute(sSql);
	          }
	          finally { if (stmt != null) stmt.close(); }
	        }
	      }
	      finally { rs.close(); }
	    }
	  } /* dropReferencingKeys */
  
	/*------------------------------------------------------------------*/
	/** add a autoincremented primary key column to the single primary 
	 * table in the query which does not have a primary key.
	 */
	private String addPrimaryColumn()
	  throws SQLException
	{
	  String sPrimaryColumn = null;
	  QualifiedId qiTable = _conn.getTableWithoutPrimaryKey();
	  if ((qiTable != null) && (getResultSetConcurrency() == ResultSet.CONCUR_UPDATABLE))
	  {
	    BaseDatabaseMetaData bdmd = (BaseDatabaseMetaData)_conn.getMetaData();
	    /* find unused column name for PK column */
	    boolean bFound = false;
	    int iUnused = 0;
	    for (bFound = false; !bFound; iUnused++)
	    {
	      sPrimaryColumn = "PK"+String.valueOf(iUnused);
  	    ResultSet rs = bdmd.getColumns(qiTable.getCatalog(),
  	      bdmd.toPattern(qiTable.getSchema()),
  	      bdmd.toPattern(qiTable.getName()),
  	      sPrimaryColumn);
  	    if (!rs.next())
  	      bFound = true;
        rs.close();
	    }
	    String sSql = "ALTER TABLE "+qiTable.format()+" ADD "+sPrimaryColumn+" INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
      Statement stmt = null;
	    try
	    {
	      stmt = _conn.unwrap(Connection.class).createStatement();
	      stmt.executeUpdate(sSql);
	    }
	    catch(SQLException se) { sPrimaryColumn = null; }
	    finally { if (stmt != null) stmt.close(); }
	  }
	  return sPrimaryColumn;
	} /* addPrimaryColumn */

	/*------------------------------------------------------------------*/
	/** remove the primary key column from the single primary table in the
	 * query which should not have a primary key.
	 */
	public void removePrimaryColumn(QualifiedId qiTable, String sPrimaryColumn)
	  throws SQLException
	{
	  if ((qiTable != null) && (sPrimaryColumn != null))
	  {
	    // remove 
      Statement stmt = null;
	    try
	    {
	      stmt = _conn.unwrap(Connection.class).createStatement();
	      stmt.executeUpdate("ALTER TABLE "+qiTable.format()+" DROP "+sPrimaryColumn);
	    }
	    finally { if (stmt != null) stmt.close(); }
	    _conn.resetTableWithoutPrimaryKey();
	  }
	} /* removePrimaryColumn */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet executeQuery(String sql) throws SQLException 
	{
	    String sNative = getConnection().nativeSQL(sql);
	    String sPrimaryColumn = null; //addPrimaryColumn();
	    if (sPrimaryColumn != null)
	    {
	      int i = sNative.indexOf(_conn.getTableWithoutPrimaryKey().format());
	      i = sNative.substring(0,i).lastIndexOf("FROM");
	      for (i--; Character.isWhitespace(sNative.charAt(i-1)); i--) {}
	      String sSelect = sNative.substring(0,i);
	      String sFrom = sNative.substring(i);
	      sNative = sSelect + ",\r\n" +sPrimaryColumn+sFrom;
	    }
	    
	    CUBRIDResultSet rs;
	    if (sNative.indexOf("FROM \"_db_stored_procedure\"") >=0) {
	    	if (sNative.indexOf("SELECT\r\n  \"sp_name\"") >= 0) {
		    	rs = new CUBRIDResultSet(super.executeQuery("SELECT #get#stored#body#"),_conn);
		    	rs.setPrimaryColumn(_conn.getTableWithoutPrimaryKey(), sPrimaryColumn);
		    	return rs;
		    }
	    	
	    	if (sNative.indexOf("SELECT\r\n  COUNT(*)") >= 0) {
		    	rs = new CUBRIDResultSet(super.executeQuery("SELECT #get#stored#count#"),_conn);
		    	rs.setPrimaryColumn(_conn.getTableWithoutPrimaryKey(), sPrimaryColumn);
		    	return rs;
		    }
	    }

	    rs = new CUBRIDResultSet(super.executeQuery(sNative),_conn);
	    rs.setPrimaryColumn(_conn.getTableWithoutPrimaryKey(), sPrimaryColumn);
		return rs;
	} /* executeQuery */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int executeUpdate(String sql) throws SQLException
	{
	    String sNative = sql; //getConnection().nativeSQL(sql);
	    dropReferencingKeys(_conn.getTableDropCascade());
			int iResult = super.executeUpdate(sNative);
	    _conn.resetTableDropCascade();
			if (iResult == -1) iResult = 0; // MySQL does not conform to JDBC specification
		return iResult;
	} /* executeUpdate */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException 
	{
	    String sNative = getConnection().nativeSQL(sql);
	    dropReferencingKeys(_conn.getTableDropCascade());
			int iResult = super.executeUpdate(sNative, autoGeneratedKeys);
	    _conn.resetTableDropCascade();
		  if (iResult == -1) iResult = 0; // CUBRID does not conform to JDBC specification
		return iResult;
	} /* executeUpdate */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException 
	{
	    String sNative = getConnection().nativeSQL(sql);
	    dropReferencingKeys(_conn.getTableDropCascade());
			int iResult = super.executeUpdate(sNative, columnIndexes);
	    _conn.resetTableDropCascade();
		  if (iResult == -1) iResult = 0; // CUBRID does not conform to JDBC specification
		return iResult;
	} /* executeUpdate */

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException 
	{
	    String sNative = getConnection().nativeSQL(sql);
	    dropReferencingKeys(_conn.getTableDropCascade());
			int iResult = super.executeUpdate(sNative, columnNames);
	    _conn.resetTableDropCascade();
			if (iResult == -1) iResult = 0; // CUBRID does not conform to JDBC specification
		return iResult;
	} /* executeUpdate */

	@Override
	public boolean execute(String sql) throws SQLException
	{
		String sNative = getConnection().nativeSQL(sql);
		boolean iResult = super.execute(sNative);
		return iResult;
	}
	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResultSet getResultSet() throws SQLException
	{
		ResultSet rs = new CUBRIDResultSet(super.getResultSet(),_conn);
		return rs;
	} /* getResultSet */
	
} /* class CubridStatement */