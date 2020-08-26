/*======================================================================
CubridLiteral implements the value translation from ISO SQL to Cubrid
Version     : $Id: $
Application : SIARD2
Description : CubridLiteral implements the value translation 
			  from ISO SQL to Cubrid
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 30.11.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.cubrid.expression;

import ch.admin.bar.siard2.cubrid.CubridLiterals;
import ch.enterag.sqlparser.SqlFactory;
import ch.enterag.sqlparser.expression.Literal;

/* =============================================================================== */
/**
 * CubridLiteral implements the value translation from ISO SQL:2008 to My Sql Server
 * @author Simon Jutz
 */
public class CubridLiteral extends Literal {
	
	/* ------------------------------------------------------------------------ */
	/**
	 * Constructor with factory only to be called by factory
	 * @param sf factory
	 */
	public CubridLiteral(SqlFactory sf) {
		super(sf);
	} /* constructor */
	
	/* ------------------------------------------------------------------------ */
	/**
	 * format the literal
	 * @return the Cubrid string corresponding to the fields of the literal
	 */
	@Override
	public String format() 
	{
		String sFormatted = "";
		
		if (getBytes() != null) {
			sFormatted = CubridLiterals.formatBytesLiteral(getBytes());
		}
		
		return sFormatted;
	}  /* format */

} /* class CubridLiteral */
