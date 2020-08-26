/*======================================================================
CubridConnection implements a wrapped Cubrid Connection.
Version     : $Id: $
Application : SIARD2
Description : CubridConnection implements a wrapped Cubrid Connection.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 26.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.List;
import java.util.concurrent.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.utils.logging.*;
import cubrid.jdbc.driver.*;
import cubrid.jdbc.jci.UConnection;
import cubrid.jdbc.jci.UError;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.DataType;
import ch.enterag.sqlparser.datatype.PredefinedType;
import ch.enterag.sqlparser.datatype.enums.PreType;
import ch.enterag.sqlparser.ddl.*;
import ch.enterag.sqlparser.ddl.enums.*;
import ch.enterag.sqlparser.expression.*;
import ch.enterag.sqlparser.identifier.*;
import ch.admin.bar.siard2.cubrid.*;
import ch.admin.bar.siard2.cubrid.ddl.CubridAlterTableStatement;

/* ===============================================================================- */
/**
 * CubridConnection implements a wrapped Cubrid Connection
 * @author Byungwook Kim
 */
public class CUBRIDConnection extends BaseConnection implements Connection {
	// logger
	UConnection u_con;
	private static IndentLogger _il = IndentLogger.getIndentLogger(CUBRIDConnection.class.getName());
  private QualifiedId _qiTableDropCascade = null;
  public QualifiedId getTableDropCascade() { return _qiTableDropCascade; }
  public void resetTableDropCascade() { _qiTableDropCascade = null; }
	private QualifiedId _qiTableWithoutPrimaryKey = null;
	public QualifiedId getTableWithoutPrimaryKey() { return _qiTableWithoutPrimaryKey; }
	public void resetTableWithoutPrimaryKey() { _qiTableWithoutPrimaryKey = null; }
	public static final String _sSET_FOREIGN_KEYS = "SET FOREIGN_KEY_CHECKS = {0};";

	/*------------------------------------------------------------------*/
	/**
	 * {@inheritDoc}
	 * 
	 * @param connWrapped Connection to be wrapped
	 * @throws SQLException
	 */
	public CUBRIDConnection(Connection connNative) throws SQLException 
	{
		super(connNative);
	} /* constructor */
	
	/*------------------------------------------------------------------*/
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String nativeSQL(String sql) 
	{
		CubridAlterTableStatement cubrid_ats = null;
		AlterTableStatement ats = null;
		
		_il.enter(sql);
		SqlFactory sf = new CubridSqlFactory();
		SqlStatement ss = sf.newSqlStatement();
		ss.parse(sql);
		resetTableDropCascade();
		DdlStatement ds = ss.getDdlStatement();
		if (ds != null)
		{
		  DropTableStatement dts = ds.getDropTableStatement();
		  CreateTableStatement cts = ds.getCreateTableStatement();
		  
		  if (cts != null) cts.getTableName().setSchema(null);
		  
		  ats = ds.getAlterTableStatement();
		  if (ats != null) {
			  ats.getTableName().setSchema(null);
			  ats.getConstraintName().setSchema(null);
			  ats.getTableConstraintDefinition().getReferencedTable().setSchema(null);
			  
			  cubrid_ats = new CubridAlterTableStatement(sf);
			  cubrid_ats.initialize(ats.getTableName(), ats.getColumnDefinition(),
					  ats.getColumnName(), ats.getAlterColumnAction(),
					  ats.getTableConstraintDefinition(), ats.getConstraintName(), ats.getDropBehavior()
			  );
		  }
		  
		  if (dts != null)
		  {
		    if (dts.getDropBehavior() == DropBehavior.CASCADE)
          _qiTableDropCascade = dts.getTableName();
		  }
		}

		resetTableWithoutPrimaryKey();
		QuerySpecification qs = ss.getQuerySpecification();
		
		if (qs != null)
		{
		  int tables = qs.getTableReferences().size();
		  TableReference tbl_rf;
		  TablePrimary tbl_pr;
		  
		  for (int i = 0; i < tables; i++) {
			  tbl_rf = qs.getTableReferences().get(i);
			  tbl_pr = tbl_rf.getTablePrimary();
			  tbl_pr.getTableName().setSchema(null);
		  }
		  
		  if (qs.getTableReferences().size() == 1)
		  {
		    TableReference tr = qs.getTableReferences().get(0);
		    if (tr != null)
		    {
		      TablePrimary tp = tr.getTablePrimary();
		      tp.getTableName().setSchema(null);
		      
		      if ((!tp.isOnly()) &&
		        (!tp.isTable()) &&
		        (!tp.isUnnest()) &&
		        (tp.getQueryExpression() == null) &&
		        (tp.getTableReference() == null))
		      {
		        QualifiedId qiTable = tp.getTableName();
		        try
		        {
  		        BaseDatabaseMetaData bdmd = (BaseDatabaseMetaData)getMetaData();
  		        ResultSet rs = getMetaData().getPrimaryKeys(
  		          qiTable.getCatalog(), 
  		          bdmd.toPattern(qiTable.getSchema()), 
  		          bdmd.toPattern(qiTable.getName()));
  		        if (!rs.next())
  		          _qiTableWithoutPrimaryKey = qiTable;
  		        rs.close();
		        }
		        catch(SQLException se) { _il.exception(se); }
		      }
		    }
		  }
		}
		
		if (cubrid_ats != null) {
			//sql = cubrid_ats.format();
		}
		else {
			sql = ss.format();
		}
		_il.exit(sql);
		return sql;
	} /* nativeSQL */

	/*------------------------------------------------------------------*/
	/**
	 * {@inheritDoc} Cubrid does not allow the executor argument to be null
	 */
	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException 
	{
		if (executor == null) {
			throw new SQLFeatureNotSupportedException("Cubrid does not allow the executor argument to be null");
		}
		super.setNetworkTimeout(executor, milliseconds);
	} /* setNetworkTimeout */

	/*------------------------------------------------------------------*/

	/**
	 * {@inheritDoc} Wraps database meta data
	 * @throws SQLException 
	 */
	@Override
	public DatabaseMetaData getMetaData() throws SQLException 
	{
		return new CUBRIDDatabaseMetaData(super.getMetaData(),this);
	} /* getMetaData */

	/*------------------------------------------------------------------*/
	/**
	 * {@inheritDoc} wraps statement.
	 */
	@Override
	public Statement createStatement() throws SQLException 
	{
    Statement stmt = super.createStatement();
    return new CUBRIDStatement(stmt,this);
	} /* createStatement */

	/*------------------------------------------------------------------*/
	/**
	 * {@inheritDoc} wraps statement.
	 */
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException 
	{
    Statement stmt = super.createStatement(resultSetType, resultSetConcurrency);
    return new CUBRIDStatement(stmt,this);
	} /* createStatement */
	
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Statement createStatement(int resultSetType,
    int resultSetConcurrency, int resultSetHoldability)
    throws SQLException
  {
    Statement stmt = super.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    return new CUBRIDStatement(stmt,this);
  } /* createStatement */

  /*------------------------------------------------------------------*/
  /**
   * {@inheritDoc} wraps creation of an SQLXML object
   */
  @Override
  public SQLXML createSQLXML() throws SQLException 
  {
    return CUBRIDSqlXml.getInstance();
  } /* createSQLXML */
  
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException 
	{
    String sNative = nativeSQL(sql);
		PreparedStatement ps = super.prepareStatement(sNative);
    return ps;
	} /* prepareStatement */

	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException 
	{
    String sNative = nativeSQL(sql);
		PreparedStatement ps = super.prepareStatement(sNative, resultSetType, resultSetConcurrency);
    return ps;
	} /* prepareStatement */

	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
	{
    String sNative = nativeSQL(sql);
		PreparedStatement ps = super.prepareStatement(sNative, resultSetType, resultSetConcurrency, resultSetHoldability);
		return ps;
	} /* prepareStatement */
	
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException 
	{
    String sNative = nativeSQL(sql);
		PreparedStatement ps = super.prepareStatement(sNative, autoGeneratedKeys);
		return ps;
	} /* prepareStatement */
	
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException 
	{
    String sNative = nativeSQL(sql);
    PreparedStatement ps = super.prepareStatement(sNative, columnIndexes);
		return ps;
	} /* prepareStatement */
	
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException 
	{
    String sNative = nativeSQL(sql);
    PreparedStatement ps = super.prepareStatement(sNative, columnNames);
    return ps;
	} /* prepareStatement */
	
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public CallableStatement prepareCall(String sql) throws SQLException 
	{
    String sNative = nativeSQL(sql);
    CallableStatement cs = super.prepareCall(sNative);
    return cs;
	} /* prepareCall */
	
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException 
	{
    String sNative = nativeSQL(sql);
    CallableStatement cs = super.prepareCall(sNative, resultSetType, resultSetConcurrency);
    return cs;
	} /* prepareCall */
	
	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException 
	{
    String sNative = nativeSQL(sql);
    CallableStatement cs = super.prepareCall(sNative, resultSetType, resultSetConcurrency, resultSetHoldability);
    return cs;
	} /* prepareCall */
	
	@Override
	public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
		throw new SQLFeatureNotSupportedException();
	}
	
	CUBRIDException createCUBRIDException(UError error) {
	    CUBRIDException e = new CUBRIDException(error);
	    return e;
	}
} /* class CubridConnection */