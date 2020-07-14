/*======================================================================
H2ResultSetMetaData implements wrapped H2 ResultSetMetaData.
Version     : $Id: $
Application : SIARD2
Description : H2ResultSetMetaData implements wrapped H2 ResultSetMetaData.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 25.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.math.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.vividsolutions.jts.geom.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.sqlparser.*;

/*====================================================================*/
/** H2ResultSetMetaData implements wrapped H2 ResultSetMetaData.
 * @author Hartwig Thomas
 */
public class H2ResultSetMetaData
  extends BaseResultSetMetaData
  implements ResultSetMetaData
{
  private static Map<String,Class<?>> mapCLASS_H2_TO_ISO = new HashMap<String,Class<?>>();
  static
  {
    mapCLASS_H2_TO_ISO.put(String.class.getName(), String.class);
    mapCLASS_H2_TO_ISO.put(Clob.class.getName(), Clob.class);
    mapCLASS_H2_TO_ISO.put(byte[].class.getName(), byte[].class);
    mapCLASS_H2_TO_ISO.put(UUID.class.getName(), byte[].class);
    mapCLASS_H2_TO_ISO.put(Blob.class.getName(), Blob.class);
    mapCLASS_H2_TO_ISO.put(BigDecimal.class.getName(), BigDecimal.class);
    mapCLASS_H2_TO_ISO.put(Byte.class.getName(), Short.class);
    mapCLASS_H2_TO_ISO.put(Short.class.getName(), Short.class);
    mapCLASS_H2_TO_ISO.put(Integer.class.getName(), Integer.class);
    mapCLASS_H2_TO_ISO.put(Long.class.getName(), Long.class);
    mapCLASS_H2_TO_ISO.put(Float.class.getName(), Float.class);
    mapCLASS_H2_TO_ISO.put(Double.class.getName(), Double.class);
    mapCLASS_H2_TO_ISO.put(Boolean.class.getName(), Boolean.class);
    mapCLASS_H2_TO_ISO.put(Date.class.getName(), Date.class);
    mapCLASS_H2_TO_ISO.put(Time.class.getName(), Time.class);
    mapCLASS_H2_TO_ISO.put(Timestamp.class.getName(), Timestamp.class);
    mapCLASS_H2_TO_ISO.put(Object.class.getName(), Blob.class);
    mapCLASS_H2_TO_ISO.put(Geometry.class.getName(), String.class);
    mapCLASS_H2_TO_ISO.put(Interval.class.getName(), Interval.class);
    mapCLASS_H2_TO_ISO.put(Array.class.getName(), Array.class);
  }
  private Connection _conn = null;
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param rsWrapped result set to be wrapped.
   */
  public H2ResultSetMetaData(ResultSetMetaData rsmdWrapped, ResultSet rsOrigin, Connection conn)
  {
    super(rsmdWrapped);
    _conn = conn;
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * fix invalid original class name.
   */
  @Override
  public String getColumnClassName(int column) throws SQLException
  {
    /* handle strange UUID case first */
    String sClassName = super.getColumnClassName(column);
    if ("UUID".equalsIgnoreCase(getColumnTypeName(column)))
      sClassName = UUID.class.getName();
    /* now map */
    if ((super.getColumnType(column) == Types.OTHER) && 
        (!sClassName.equals(Geometry.class.getName())))
      sClassName = Blob.class.getName();
    else 
      sClassName = mapCLASS_H2_TO_ISO.get(sClassName).getName();
    return sClassName;
  } /* getColumnClassName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * map java.sql.Types type.
   */
  @Override
  public int getColumnType(int column) throws SQLException
  {
    int iType = super.getColumnType(column);
    long lColumnSize = super.getPrecision(column);
    String sClassName = super.getColumnClassName(column);
    return H2MetaColumns.getDataType(iType,lColumnSize,sClassName);
  } /* getColumnType */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * map java.sql.Types type.
   */
  @Override
  public int getPrecision(int column) throws SQLException
  {
    int iType = super.getColumnType(column);
    long lColumnSize = super.getPrecision(column);
    String sClassName = super.getColumnClassName(column);
    return (int)H2MetaColumns.getColumnSize(
      iType, 
      lColumnSize, 
      sClassName);
  } /* getPrecision */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * map type name.
   */
  @Override
  public String getColumnTypeName(int column) throws SQLException
  {
    return H2MetaColumns.getTypeName(
      super.getColumnTypeName(column),
      super.getPrecision(column),
      super.getScale(column),
      _conn,      
      super.getCatalogName(column),
      super.getSchemaName(column),
      super.getTableName(column),
      super.getColumnName(column));
  } /* getColumnTypeName */

} /* class H2ResultSetMetaData */
