/*======================================================================
CubridLiterals extends SqlLiterals 
Version     : $Id: $
Application : SIARD2
Description : CubridLiterals extends SqlLiterals 
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 30.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.cubrid;

import ch.enterag.utils.BU;
import ch.enterag.sqlparser.Interval;
import ch.enterag.sqlparser.SqlLiterals;

/* =============================================================================== */
/**
 * CubridLiterals extends SqlLiterals by overriding non-JDBC-conformant literal formatters
 * @author Simon Jutz
 */
public abstract class CubridLiterals extends SqlLiterals {
	private static final String sBYTE_LITERAL_PREFIX = "x";

	  public static String formatStringLiteral(String sValue)
	  {
	    String sQuoted = sNULL;
	    if (sValue != null)
	      sQuoted = sAPOSTROPHE + sValue.replaceAll(sAPOSTROPHE, sDOUBLE_APOSTROPHE) + sAPOSTROPHE;
	      
	    return sQuoted;
	  } /* formatStringLiteral */

	/* ------------------------------------------------------------------------ */
	  
	/**
	 * format byte buffer value
	 * @param bufValue byte buffer value to be formatted
	 * @return byte string literal
	 */
	public static String formatBytesLiteral(byte[] bufValue) 
	{
		String sFormatted = sNULL;
		if (bufValue != null) {
			sFormatted = sBYTE_LITERAL_PREFIX + formatStringLiteral(BU.toHex(bufValue));
		}
		return sFormatted;
	} /* formatBytesLiteral */
	

	/* ------------------------------------------------------------------------ */
	
	/**
	 * format interval value
	 * @param intervalValue the interval value to be formatted
	 * @return byte string literal
	 */
	public static String formatIntervalLiteral(Interval intervalValue) 
	{
		String sFormatted = sNULL;
		if(intervalValue != null) {
			sFormatted = formatBytesLiteral(serialize(intervalValue));
		}
		return sFormatted;
	} /* formatIntervalLiteral */
	
} /* class CubridLiterals */