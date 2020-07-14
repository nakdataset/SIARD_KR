/*======================================================================
H2ValueExpressionPrimary implements the array value translation from ISO SQL to H2.
Version     : $Id: $
Application : SIARD2
Description : H2ValueExpressionPrimary implements the array value translation 
              from ISO SQL:2008 to H2. 
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 26.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.h2.expression;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.expression.*;

/*====================================================================*/
/** H2ValueExpressionPrimary implements the array value translation from 
 * ISO SQL to H2 using parentheses instead of brackets.
 * @author Hartwig Thomas
 */
public class H2ValueExpressionPrimary
  extends ValueExpressionPrimary
{

  protected String formatCollectionValueComponents()
  {
    String s = "";
    if (getCollectionValueComponents().size() > 0)
    {
      s = sLEFT_PAREN;
      for (int i = 0; i < getCollectionValueComponents().size(); i++)
      {
        if (i > 0)
          s = s + sCOMMA + sSP;
        s = s + getCollectionValueComponents().get(i).format();
      }
      s = s + sRIGHT_PAREN;
    }
    return s;
  } /* formatCollectionValueComponents */
  
  /*------------------------------------------------------------------*/
  /** format the value expression primary.
   * @return the SQL string corresponding to the fields of the value 
   *   expression primary.
   */
  @Override
  public String format()
  {
    String sExpression = "";
    /* arrayValueConstruct */
    if (isArrayValueConstructor())
    {
      if (getQueryExpression() == null)
        sExpression = sExpression + formatCollectionValueComponents();
      else
        throw new IllegalArgumentException("ARRAY expression from subquery is not available in H2!");
    }
    else
      sExpression = super.format();
    return sExpression;
  } /* format */
  
  /*------------------------------------------------------------------*/
  /** constructor with factory only to be called by factory.
   * @param sf factory.
   */
  public H2ValueExpressionPrimary(SqlFactory sf)
  {
    super(sf);
  } /* constructor */

} /* class H2ValueExpressionPrimary */
