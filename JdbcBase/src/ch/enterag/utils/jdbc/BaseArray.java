/*======================================================================
BaseArray implements a wrapped Array.
Application : SIARD2
Description : BaseArray implements a wrapped Array.
              See https://docs.oracle.com/javase/7/docs/api/java/sql/Array.html
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 25.03.2016, Hartwig Thomas
======================================================================*/
package ch.enterag.utils.jdbc;

import java.sql.*;
import java.util.Map;

/*====================================================================*/
/** BaseArray implements a wrapped Array and serves as a base
 * for derived JDBC wrappers.
 * @author Hartwig Thomas
 */
public abstract class BaseArray
  implements Array
{
  /** wrapped array */
  private Array _arrayWrapped = null;

  /*------------------------------------------------------------------*/
  /** constructor
   * @param arrayWrapped connection to be wrapped.
   */
  public BaseArray(Array arrayWrapped)
  {
    _arrayWrapped = arrayWrapped;
  } /* constructor BaseArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getBaseTypeName() throws SQLException
  {
    return _arrayWrapped.getBaseTypeName();
  } /* getBaseTypeName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getBaseType() throws SQLException
  {
    return _arrayWrapped.getBaseType();
  } /* getBaseType */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray() throws SQLException
  {
    return _arrayWrapped.getArray();
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray(Map<String, Class<?>> map) throws SQLException
  {
    return _arrayWrapped.getArray(map);
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray(long index, int count) throws SQLException
  {
    return _arrayWrapped.getArray(index, count);
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray(long index, int count,
    Map<String, Class<?>> map) throws SQLException
  {
    return _arrayWrapped.getArray(index, count, map);
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet() throws SQLException
  {
    return _arrayWrapped.getResultSet();
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet(Map<String, Class<?>> map)
    throws SQLException
  {
    return _arrayWrapped.getResultSet(map);
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet(long index, int count)
    throws SQLException
  {
    return _arrayWrapped.getResultSet(index, count);
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet(long index, int count,
    Map<String, Class<?>> map) throws SQLException
  {
    return _arrayWrapped.getResultSet(index, count, map);
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void free() throws SQLException
  {
    _arrayWrapped.free();
  }
  
  /*------------------------------------------------------------------*/
  /** as for all other JDBC interfaces .... */
  public boolean isWrapperFor(Class<?> iface) throws SQLException
  {
    return (iface == Array.class);
  } /* isWrapperFor */

  /*------------------------------------------------------------------*/
  /** as for all other JDBC interfaces .... */
  @SuppressWarnings("unchecked")
  public <T> T unwrap(Class<T> iface) throws SQLException
  {
    T wrapped = null;
    if (isWrapperFor(iface))
      wrapped = (T)_arrayWrapped;
    return wrapped;
  } /* unwrap */
  
} /* BaseArray */
