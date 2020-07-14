/*======================================================================
H2DataType implements the type translation from ISO SQL to H2 for complex types.
Version     : $Id: $
Application : SIARD2
Description : H2DataType implements the type translation from ISO 
              SQL:2008 to H2 for complex types.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 26.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.h2.datatype;

import ch.enterag.sqlparser.*;
import ch.enterag.sqlparser.datatype.*;

/*====================================================================*/
/** H2DataType implements the type translation from ISO SQL to H2 for
 * complex types.
 * @author Hartwig Thomas
 */
public class H2DataType
  extends DataType
{

  /*------------------------------------------------------------------*/
  /** format an ARRAY type.
   * In H2 an ARRAY is stored as a ARRAY (without base type) and with
   * parentheses instead of brackets around the length.
   * @return SQL for ARRAY type.
   */
  @Override
  protected String formatArrayType()
  {
    String sDataType = K.ARRAY.getKeyword();
    if (getLength() != iUNDEFINED)
      sDataType = sDataType + sLEFT_PAREN + String.valueOf(getLength()) + sRIGHT_PAREN;
    return sDataType;
  } /* formatArrayType */
  
  /*------------------------------------------------------------------*/
  /** format the data type for H2.
   * @return the SQL string corresponding to the fields of the data type.
   */
  @Override
  public String format()
  {
    String sDataType = null;
    switch (getType())
    {
      case PRE: sDataType = getPredefinedType().format(); break;
      case STRUCT: sDataType = formatStructType(); break;
      case ROW: sDataType = formatRowType(); break;
      case REF: sDataType = formatRefType(); break;
      case ARRAY: sDataType = formatArrayType(); break;
      case MULTISET: sDataType = formatMultisetType(); break;
    }
    return sDataType;
  } /* format */

  /*------------------------------------------------------------------*/
  /** constructor with factory only to be called by factory.
   * @param sf factory.
   */
  public H2DataType(SqlFactory sf)
  {
    super(sf);
  } /* constructor */

} /* class H2DataType */
