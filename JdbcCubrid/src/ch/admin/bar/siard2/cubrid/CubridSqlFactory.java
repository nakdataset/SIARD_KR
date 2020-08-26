/*======================================================================
CubridSqlFactory implements a wrapped Cubrid SqlFactory.
Version     : $Id: $
Application : SIARD2
Description : CubridSqlFactory implements a wrapped Cubrid SqlFactory.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 26.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.cubrid;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;
import ch.enterag.sqlparser.ddl.*;
import ch.enterag.sqlparser.expression.*;
import ch.admin.bar.siard2.cubrid.datatype.*;
import ch.admin.bar.siard2.cubrid.ddl.*;
import ch.admin.bar.siard2.cubrid.expression.*;

/* =============================================================================== */
/**
 * CubridSqlFactory implements a wrapped Cubrid SqlFactory
 * @author Simon Jutz
 */
public class CubridSqlFactory extends BaseSqlFactory implements SqlFactory 
{
  
	/* ------------------------------------------------------------------------ */
	/**
	 * Returns a new wrapped predefined type
	 */
	@Override
	public PredefinedType newPredefinedType() {
		return new CubridPredefinedType(this);
	} /* newPredefinedType */

	/* ------------------------------------------------------------------------ */
	/**
	 * Returns a new wrapped literal
	 */
	@Override
	public Literal newLiteral() {
		return new CubridLiteral(this);
	} /* newLiteral */

	/* ------------------------------------------------------------------------ */
	/**
	 * Creates a new wrapped unsigned literal
	 */
	@Override
	public UnsignedLiteral newUnsignedLiteral() {
		return new CubridUnsignedLiteral(this);
	} /* newUnsignedLiteral */

	/* ------------------------------------------------------------------------ */
	/**
	 * Creates a new wrapped value expression primary
	 */
	@Override
	public ValueExpressionPrimary newValueExpressionPrimary() {
		return new CubridValueExpressionPrimary(this);
	} /* newValueExpressionPrimary */

	/* ------------------------------------------------------------------------ */
	/**
	 * Creates a new DROP SCHEMA statement 
	 */
	@Override
	public DropSchemaStatement newDropSchemaStatement() {
		return new CubridDropSchemaStatement(this);
	} /* newDropSchemaStatement */

  /* ------------------------------------------------------------------------ */
  /** Creates a new DROP TABLE statement */
  @Override
  public DropTableStatement newDropTableStatement() 
  {
    return new CubridDropTableStatement(this);
  } /* newDropTableStatement */
	
} /* class CubridSqlFactory */