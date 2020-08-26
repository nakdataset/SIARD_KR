/*======================================================================
CubridResultSetMetaData implements a wrapped Cubrid ResultSetMetaData.
Version     : $Id: $
Application : SIARD2
Description : CubridResultSetMetaData implements a wrapped Cubrid ResultSetMetaData.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 31.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.math.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import ch.enterag.utils.jdbc.*;

/* =============================================================================== */
/**
 * CubridResultSetMetaData implements a wrapped Cubrid ResultSetMetaData.
 * @author Simon Jutz
 */
public class CUBRIDResultSetMetaData extends BaseResultSetMetaData implements ResultSetMetaData 
{
	boolean is_closed;
	int major_version;
	int minor_version;
	
	private String _sPrimaryColumn = null;
	private static Map<String,Class<?>> mapCLASS_CUBRID_TO_ISO = new HashMap<String,Class<?>>();
	static 
	{
		mapCLASS_CUBRID_TO_ISO.put(byte[].class.getName(), byte[].class); // or String in case of GEOMETRY types
		mapCLASS_CUBRID_TO_ISO.put(String.class.getName(), String.class);
		mapCLASS_CUBRID_TO_ISO.put(Boolean.class.getName(), Boolean.class);
		mapCLASS_CUBRID_TO_ISO.put(Short.class.getName(), Short.class);
		mapCLASS_CUBRID_TO_ISO.put(Integer.class.getName(), Integer.class);
		mapCLASS_CUBRID_TO_ISO.put(BigInteger.class.getName(), BigInteger.class);
		mapCLASS_CUBRID_TO_ISO.put(Long.class.getName(), Long.class);
		mapCLASS_CUBRID_TO_ISO.put(Float.class.getName(), Float.class);
		mapCLASS_CUBRID_TO_ISO.put(Double.class.getName(), Double.class);
		mapCLASS_CUBRID_TO_ISO.put(BigDecimal.class.getName(), BigDecimal.class);
		mapCLASS_CUBRID_TO_ISO.put(Date.class.getName(), Date.class);
		mapCLASS_CUBRID_TO_ISO.put(Time.class.getName(), Time.class);
		mapCLASS_CUBRID_TO_ISO.put(Timestamp.class.getName(), Timestamp.class);
	}

	/* ------------------------------------------------------------------------ */
	/**
	 * Constructor
	 * @param rsmdWrapped ResultSetMetaData to be wrapped
	 */
	public CUBRIDResultSetMetaData(ResultSetMetaData rsmdWrapped, String sPrimaryColumn) 
	{
		super(rsmdWrapped);
    _sPrimaryColumn = sPrimaryColumn;
	} /* constructor */

  /* ------------------------------------------------------------------------ */
	/** {@inheritDoc} */
	@Override
	public int getColumnCount() throws SQLException
	{
	  int iColumnCount = super.getColumnCount();
	  if (_sPrimaryColumn != null)
	    iColumnCount--;
	  return iColumnCount;
	} /* getColumnCount */
	
  /* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getColumnType(int column) throws SQLException {
		return CUBRIDMetaColumns.getDataType(super.getColumnTypeName(column).toLowerCase());
	} /* getColumnType */ 

	/* ------------------------------------------------------------------------ */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getColumnClassName(int column) throws SQLException {
		String sClassName = super.getColumnClassName(column);
		String sTypeName = super.getColumnTypeName(column);
		Class<?> cls = mapCLASS_CUBRID_TO_ISO.get(sClassName);
		if(sTypeName.equals("GEOMETRY") ||
				sTypeName.equals("POINT") ||
				sTypeName.equals("LINESTRING") ||
				sTypeName.equals("POLYGON") ||
				sTypeName.equals("MULTIPOINT") ||
				sTypeName.equals("MULTILINESTRING") ||
				sTypeName.equals("MULTIPOLYGON") ||
				sTypeName.equals("GEOMETRYCOLLECTION")) {
			cls = String.class;
		}
		return cls.getName();
	} /* getColumnClassName */

	@Override
	public boolean isCaseSensitive(int column) throws SQLException
	{
	  /***
    String sTypeName = super.getColumnTypeName(column);
    System.out.print(sTypeName+":"+String.valueOf(super.isCaseSensitive(column))+"\t\n");
    ***/
    return super.isCaseSensitive(column);
	}
} /* class CubridResultSetMetaData */
