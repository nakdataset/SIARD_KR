/*======================================================================
H2SqlFactory overrides the BaseSqlFactory for the H2-specific SQL parser classes.
Version     : $Id: $
Application : SIARD2
Description : H2SqlFactory overrides the BaseSqlFactory for the H2-specific 
              SQL parser classes.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 19.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.h2;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;
import ch.enterag.sqlparser.ddl.*;
import ch.enterag.sqlparser.expression.*;
import ch.admin.bar.siard2.h2.datatype.*;
import ch.admin.bar.siard2.h2.ddl.*;
import ch.admin.bar.siard2.h2.expression.*;

/*====================================================================*/
/** H2SqlFactory overrides the BaseSqlFactory for the H2-specific SQL 
 * parser classes.
 * @author Hartwig Thomas
 */
public class H2SqlFactory
  extends BaseSqlFactory
  implements SqlFactory
{
  @Override
  public DataType newDataType()
  {
    return new H2DataType(this);
  } /* newDataType */
  
  @Override
  public PredefinedType newPredefinedType()
  {
    return new H2PredefinedType(this);
  } /* newPredefinedType */
  
  @Override
  public DropSchemaStatement newDropSchemaStatement()
  {
    return new H2DropSchemaStatement(this);
  } /* newDropSchemaStatement */
  
  @Override
  public UnsignedLiteral newUnsignedLiteral()
  {
    return new H2UnsignedLiteral(this);
  } /* newUnsignedLiteral */
  
  @Override
  public ValueExpressionPrimary newValueExpressionPrimary()
  {
    return new H2ValueExpressionPrimary(this);
  } /* newValueExpressionPrimary */
  
} /* H2SqlFactory */
