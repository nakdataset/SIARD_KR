/*======================================================================
CubridPredefinedType implements the type translation from ISO SQL to Cubrid
Version     : $Id: $
Application : SIARD2
Description : CubridPredefinedType implements the type translation from ISO SQL to Cubrid
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 02.11.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.cubrid.datatype;

import java.util.HashMap;
import java.util.Map;

import ch.enterag.sqlparser.SqlFactory;
import ch.enterag.sqlparser.datatype.PredefinedType;
import ch.enterag.sqlparser.datatype.enums.PreType;

/*====================================================================*/
/**
 * CubridPredefinedType implements the type translation from ISO SQL to Cubrid
 * @author Simon Jutz
 */
public class CubridPredefinedType extends PredefinedType 
{
	private static Map<PreType, String> mapISO_TO_CUBRID = new HashMap<PreType, String>();
		  
	static {
		mapISO_TO_CUBRID.put(PreType.BINARY, "BIT");
		mapISO_TO_CUBRID.put(PreType.CHAR, "CHAR");
		mapISO_TO_CUBRID.put(PreType.VARCHAR, "VARCHAR");
		mapISO_TO_CUBRID.put(PreType.CLOB, "CLOB");
		mapISO_TO_CUBRID.put(PreType.BLOB, "BLOB");
		mapISO_TO_CUBRID.put(PreType.NUMERIC, "NUMERIC");
		mapISO_TO_CUBRID.put(PreType.DECIMAL, "DECIMAL");
		mapISO_TO_CUBRID.put(PreType.SMALLINT, "SMALLINT");
		mapISO_TO_CUBRID.put(PreType.INTEGER, "INTEGER");
		mapISO_TO_CUBRID.put(PreType.BIGINT, "BIGINT");
		mapISO_TO_CUBRID.put(PreType.FLOAT, "FLOAT");
		mapISO_TO_CUBRID.put(PreType.REAL, "REAL");
		mapISO_TO_CUBRID.put(PreType.DOUBLE, "DOUBLE");
		mapISO_TO_CUBRID.put(PreType.BOOLEAN, "BOOLEAN");
		mapISO_TO_CUBRID.put(PreType.DATE, "DATE");
		mapISO_TO_CUBRID.put(PreType.TIME, "TIME");
		mapISO_TO_CUBRID.put(PreType.TIMESTAMP, "TIMESTAMP");
		mapISO_TO_CUBRID.put(PreType.INTERVAL, "VARBINARY");
	}
	/**
	 * Constructor
	 * @param sf factory
	 */
	public CubridPredefinedType(SqlFactory sf) {
		super(sf);
	} /* constructor */
	
  /*------------------------------------------------------------------*/
  /** decimals of seconds in parentheses.
   * @param iDefaultDecimals default decimals.
   * @return seconds decimals in parentheses.
   */
  protected String formatSecondsDecimals(int iDefaultDecimals)
  {
    String sSecondsDecimals = "";
    int iSecondsDecimals = getSecondsDecimals();
    if (iSecondsDecimals != iUNDEFINED)
    {
      if (iSecondsDecimals > 6)
        iSecondsDecimals = 6; // maximum precision for DATETIME
      if (iSecondsDecimals != iDefaultDecimals)
        sSecondsDecimals = sSecondsDecimals + sLEFT_PAREN + String.valueOf(iSecondsDecimals) + sRIGHT_PAREN;
    }
    return sSecondsDecimals;
  } /* formatSecondsDecimals */
  
	/**
	 * format the predefined data type.
	 * @return the SQL string corresponding to the fields of the data type.
	 */
	public String format() 
	{
		String sType = null;
		sType = mapISO_TO_CUBRID.get(getType());
		if( getType() == PreType.NUMERIC || 
				getType() == PreType.DECIMAL) 
			sType = sType + formatPrecisionScale(); // [(M,D)]
		else if (getType() == PreType.FLOAT || 
				getType() == PreType.REAL || 
				getType() == PreType.DOUBLE || 
				getType() == PreType.FLOAT) 
			sType = sType + formatPrecisionScale(); // [(M[,D])]
		else if (getType() == PreType.SMALLINT || 
				getType() == PreType.INTEGER || 
				getType() == PreType.BIGINT) 
			sType = sType + formatPrecisionScale(); // [(M)]
		else if (getType() == PreType.CHAR || 
    		getType() == PreType.VARCHAR || 
    		getType() == PreType.NCHAR ||
    		getType() == PreType.NVARCHAR)
		{
			sType = sType + formatLength(); // (M)
		}
    
		else if (getType() == PreType.BINARY)
    	  sType = "BIT" + formatLength();
		else if (getType() == PreType.VARBINARY)
    	  sType = "BIT VARYING" + formatLength();
		else if (getType() == PreType.TIME ||
				 getType() == PreType.TIMESTAMP ||
				 getType() == PreType.DATE) 
			sType = sType + formatSecondsDecimals(iTIME_DECIMALS_DEFAULT); // [(M)]
		else if (getType() == PreType.INTERVAL)
		  sType = sType + "(255)";
		else if ((getType() == PreType.CLOB) ||
		         (getType() == PreType.NCLOB))
		{
			long l = getLength();
			if (getLength() != (long)iUNDEFINED)
			{
				if (getMultiplier() != null)
					l = l * getMultiplier().getValue();
				if (l < 65536)
					sType = "TEXT"; // 2 bytes
				else if (l < 16777216)
					sType = "MEDIUMTEXT"; // 3 bytes
			}
		}
		else if ((getType() == PreType.BLOB))
		{
			if (getLength() != iUNDEFINED)
			{
				long l = getLength();
				if (getMultiplier() != null)
					l = l * getMultiplier().getValue();
				if (l < 65536) // 2 bytes
					sType = "BLOB";
				else if (l < 16777216)
					sType = "MEDIUMBLOB"; // 3 bytes
			}
		}

		return sType;
	} /* format */

} /* class CubridPredefinedType */
