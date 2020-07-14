package ch.admin.bar.siard2.h2;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.expression.enums.*;

public abstract class H2Literals extends SqlLiterals
{
  /*------------------------------------------------------------------*/
  /** format a boolean literal value.
   * in H2 the BOOLEAN data type cannot handle the value UNKNOWN. 
   * @param blValue boolean value to be formatted.
   * @return boolean literal.
   */
  public static String formatBooleanLiteral(BooleanLiteral blValue)
  {
    String sFormatted = blValue.getKeywords();
    if (blValue == BooleanLiteral.UNKNOWN)
      sFormatted = K.NULL.getKeyword();
    return sFormatted;
  } /* formatBooleanLiteral */
  
  /*------------------------------------------------------------------*/
  /** format an interval value
   * In H2 an interval is serialized to a BLOB.
   * @param ivValue interval value to be formatted.
   * @return interval literal.
   */
  public static String formatIntervalLiteral(Interval ivValue)
  {
    return formatBytesLiteral(serialize(ivValue));
  } /* formatIntervalLiteral */
  
} /* class H2SqlLiteral */
