/*======================================================================
CubridUnsignedLiteral implements the value translation from ISO SQL to Cubrid
Version     : $Id: $
Application : SIARD2
Description : CubridUnsignedLiteral implements the value translation 
			  from ISO SQL to Cubrid
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 30.11.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.cubrid.expression;

import ch.admin.bar.siard2.cubrid.CubridLiterals;
import ch.enterag.sqlparser.SqlFactory;
import ch.enterag.sqlparser.expression.UnsignedLiteral;

/* =============================================================================== */
/**
 * CubridLiteral implements the value translation from ISO SQL:2008 to Cubrid Server
 * @author Simon Jutz
 */
public class CubridUnsignedLiteral extends UnsignedLiteral {

	/* ------------------------------------------------------------------------ */
	/**
	 * Constructor with factory only to be called by factory
	 * @param sf factory
	 */
	public CubridUnsignedLiteral(SqlFactory sf) {
		super(sf);
	}

	/* ------------------------------------------------------------------------ */
	
	/**
	 * formats the unsigned literal value
	 */
	@Override
	public String format() {
		String sExpression = null;
		
		if(getInterval() != null) {
			sExpression = CubridLiterals.formatIntervalLiteral(getInterval()); // no interval data type in Cubrid
		} else {
			sExpression = super.format(); 
		}
		
		return sExpression;
	} /* format */
	
} /* class CubridUnsignedLiteral */
