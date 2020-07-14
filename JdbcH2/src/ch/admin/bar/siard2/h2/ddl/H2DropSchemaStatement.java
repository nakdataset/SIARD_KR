/*======================================================================
H2DropSchemaStatement overrides DropSchemaStatement of SQL parser.
Version     : $Id: $
Application : SIARD2
Description : H2DropSchemaStatement overrides DropSchemaStatement of SQL 
              parser because H2 does not support drop behavior 
              (CASCADE, RESTRICT) for schemas. (RESTRICT is the implicit
              default.) 
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 19.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.h2.ddl;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.ddl.*;
import ch.enterag.sqlparser.ddl.enums.*;

/*====================================================================*/
/** H2DropSchemaStatement overrides DropSchemaStatement of SQL parser 
 * because H2 does not support drop behavior (CASCADE, RESTRICT) for 
 * schemas. (CASCADE is the implicit default.)
 * @author Hartwig Thomas
 */
public class H2DropSchemaStatement
  extends DropSchemaStatement
{
  /*------------------------------------------------------------------*/
  /** format the drop schema statement for H2 without the drop behavior.
   * @return the SQL string corresponding to the fields of the drop schema statement.
   */
  @Override
  public String format()
  {
    if (getDropBehavior() == DropBehavior.RESTRICT)
      throw new IllegalArgumentException("Schema drop behavior RESTRICT not supported by H2!");
    String sStatement = K.DROP.getKeyword() + sSP + K.SCHEMA.getKeyword() + sSP + 
      getSchemaName().format(); 
    return sStatement;
  } /* format */

  /*------------------------------------------------------------------*/
  /** constructor with factory only to be called by factory.
   * @param sf factory.
   */
  public H2DropSchemaStatement(SqlFactory sf)
  {
    super(sf);
  } /* constructor */
  
} /* class H2DropSchemaStatement */
