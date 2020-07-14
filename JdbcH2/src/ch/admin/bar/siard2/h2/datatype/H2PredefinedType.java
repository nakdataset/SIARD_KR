/*======================================================================
H2PredefinedType implements the type translation from ISO SQL to H2.
Version     : $Id: $
Application : SIARD2
Description : H2PredefinedType implements the type translation from ISO 
              SQL:2008 to H2.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 19.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.h2.datatype;

import java.util.*;
import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;
import ch.enterag.sqlparser.datatype.enums.*;

/*====================================================================*/
/** H2PredefinedType implements the type translation from ISO SQL to H2.
 * @author Hartwig Thomas
 */
public class H2PredefinedType
  extends PredefinedType
{
  /* translation of ISO SQL data types to H2 data types in DDL */
  private static Map<PreType, String> mapISO_TO_H2 = new HashMap<PreType, String>();
  static
  {
    mapISO_TO_H2.put(PreType.CHAR,"CHAR");
    mapISO_TO_H2.put(PreType.VARCHAR,"VARCHAR");
    mapISO_TO_H2.put(PreType.CLOB,"CLOB");
    mapISO_TO_H2.put(PreType.NCHAR,"CHAR");
    mapISO_TO_H2.put(PreType.NVARCHAR,"VARCHAR");
    mapISO_TO_H2.put(PreType.NCLOB,"CLOB");
    mapISO_TO_H2.put(PreType.XML,"CLOB");
    mapISO_TO_H2.put(PreType.BINARY, "BINARY");
    mapISO_TO_H2.put(PreType.VARBINARY, "VARBINARY");
    mapISO_TO_H2.put(PreType.BLOB,"BLOB");
    mapISO_TO_H2.put(PreType.NUMERIC,"NUMERIC");
    mapISO_TO_H2.put(PreType.DECIMAL,"DECIMAL");
    mapISO_TO_H2.put(PreType.SMALLINT,"SMALLINT");
    mapISO_TO_H2.put(PreType.INTEGER,"INTEGER");
    mapISO_TO_H2.put(PreType.BIGINT,"BIGINT");
    mapISO_TO_H2.put(PreType.FLOAT,"FLOAT");
    mapISO_TO_H2.put(PreType.REAL,"REAL");
    mapISO_TO_H2.put(PreType.DOUBLE,"DOUBLE");
    mapISO_TO_H2.put(PreType.BOOLEAN,"BOOLEAN");
    mapISO_TO_H2.put(PreType.DATE,"DATE");
    mapISO_TO_H2.put(PreType.TIME,"TIME");
    mapISO_TO_H2.put(PreType.TIMESTAMP,"TIMESTAMP");
    mapISO_TO_H2.put(PreType.INTERVAL,"BLOB");
  }
  
  /*------------------------------------------------------------------*/
  /** format the predefined data type for H2.
   * In H2 SMALLINT is a short, INTEGER is an int and BIGINT is a long.
   * There are no limits to character or binary strings.
   * @return the SQL string corresponding to the fields of the data type.
   */
  @Override
  public String format()
  {
    String sType = null;
    if (getType() != null)
    {
      sType = mapISO_TO_H2.get(getType());
      if ((getType() == PreType.CHAR) ||
          (getType() == PreType.VARCHAR) ||
          (getType() == PreType.NCHAR) ||
          (getType() == PreType.NVARCHAR) ||
          (getType() == PreType.BINARY) ||
          (getType() == PreType.VARBINARY))
        sType = sType + formatLength();
      else if ((getType() == PreType.CLOB) ||
          (getType() == PreType.NCLOB) ||
          (getType() == PreType.BLOB))
        sType = sType + formatLobLength();
      else if ((getType() == PreType.NUMERIC) ||
          (getType() == PreType.DECIMAL) ||
          (getType() == PreType.FLOAT))
        sType = sType + formatPrecisionScale();
      else if (getType() == PreType.TIME)
        sType = sType + formatSecondsDecimals(iTIME_DECIMALS_DEFAULT);
      else if (getType() == PreType.TIMESTAMP)
        sType = sType + formatSecondsDecimals(iTIMESTAMP_DECIMALS_DEFAULT);
      /* H2 cannot handle time zone nonsense */
   }
    return sType;
  } /* format */

  /*------------------------------------------------------------------*/
  /** constructor with factory only to be called by factory.
   * @param sf factory.
   */
  public H2PredefinedType(SqlFactory sf)
  {
    super(sf);
  } /* constructor */

} /* H2PredefinedType */
