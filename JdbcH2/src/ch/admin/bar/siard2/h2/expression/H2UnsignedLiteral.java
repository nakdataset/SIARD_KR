/*======================================================================
H2UnsignedLiteral implements the value translation from ISO SQL to H2.
Version     : $Id: $
Application : SIARD2
Description : H2UnsignedLiteral implements the value translation from ISO 
              SQL:2008 to H2.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 23.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.h2.expression;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.expression.*;
import ch.admin.bar.siard2.h2.*;

/*====================================================================*/
/** H2UnsignedLiteral implements the value translation from ISO SQL to H2.
 * @author Hartwig Thomas
 */
public class H2UnsignedLiteral
  extends UnsignedLiteral
{
  /*------------------------------------------------------------------*/
  /** format the unsigned literal
   * @return the SQL string corresponding to the fields of the unsigned literal.
   */
  @Override
  public String format()
  {
    String sFormatted = null;
    if (getInterval() != null) // INTERVAL type is modeled as H2 OTHER!
      sFormatted = H2Literals.formatIntervalLiteral(getInterval());
    else if (getBoolean() != null) // H2 does not like boolean value UNKNOWN
      sFormatted = H2Literals.formatBooleanLiteral(getBoolean());
    else
      sFormatted = super.format();
    return sFormatted;
  } /* format */

  /*------------------------------------------------------------------*/
  /** constructor with factory only to be called by factory.
   * @param sf factory.
   */
  public H2UnsignedLiteral(SqlFactory sf)
  {
    super(sf);
  } /* constructor */

} /* class H2UnsignedLiteral */
