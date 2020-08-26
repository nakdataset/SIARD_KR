/*======================================================================
Implements the type translation between Cubrid and ISO SQL
Version     : $Id: $
Application : SIARD2
Description : Implements the type translation between Cubrid and ISO SQL
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 31.10.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import ch.admin.bar.siard2.cubrid.*;
import ch.enterag.sqlparser.datatype.enums.*;

/* =============================================================================== */
/**
 * Implements the type translation between Cubrid and ISO SQL
 * @author Simon Jutz
 */
public class CUBRIDMetaColumns extends CUBRIDResultSet 
{
	private static Map<CubridType,PreType> mapNAME_CUBRID_TO_ISO = new HashMap<CubridType,PreType>();

	static 
	{
		mapNAME_CUBRID_TO_ISO.put(CubridType.BIGINT, PreType.BIGINT);
		mapNAME_CUBRID_TO_ISO.put(CubridType.BIT, PreType.VARCHAR);
		mapNAME_CUBRID_TO_ISO.put(CubridType.BLOB, PreType.BLOB);
		mapNAME_CUBRID_TO_ISO.put(CubridType.CLOB, PreType.CLOB);
		mapNAME_CUBRID_TO_ISO.put(CubridType.CHAR, PreType.CHAR);
		mapNAME_CUBRID_TO_ISO.put(CubridType.DATE, PreType.DATE);
		mapNAME_CUBRID_TO_ISO.put(CubridType.DATETIME, PreType.TIMESTAMP);
		mapNAME_CUBRID_TO_ISO.put(CubridType.DECIMAL, PreType.DECIMAL);
		mapNAME_CUBRID_TO_ISO.put(CubridType.DOUBLE, PreType.DOUBLE);
		mapNAME_CUBRID_TO_ISO.put(CubridType.ENUM, PreType.VARCHAR);
		mapNAME_CUBRID_TO_ISO.put(CubridType.FLOAT, PreType.FLOAT);
		mapNAME_CUBRID_TO_ISO.put(CubridType.INT, PreType.INTEGER);
		mapNAME_CUBRID_TO_ISO.put(CubridType.INTEGER, PreType.INTEGER);
		mapNAME_CUBRID_TO_ISO.put(CubridType.SET, PreType.VARCHAR);
		mapNAME_CUBRID_TO_ISO.put(CubridType.SMALLINT, PreType.SMALLINT);
		mapNAME_CUBRID_TO_ISO.put(CubridType.TIME, PreType.TIME);
		mapNAME_CUBRID_TO_ISO.put(CubridType.TIMESTAMP, PreType.TIMESTAMP);
		mapNAME_CUBRID_TO_ISO.put(CubridType.STRING, PreType.VARCHAR);
		mapNAME_CUBRID_TO_ISO.put(CubridType.VARCHAR, PreType.VARCHAR);
		mapNAME_CUBRID_TO_ISO.put(CubridType.OBJECT, PreType.VARCHAR);
	}

	private static final int iMAX_VARCHAR_LENGTH = 1073741823; 
	private int _iDataType = -1;
	private int _iTypeName = -1;
	private int _iPrecision = -1;
	private int _iLength = -1;
	private ResultSet _rsUnwrapped = null;

	/* ------------------------------------------------------------------------ */
	/**
	 * Constructor
	 * @param rsWrapped ResultSet to be wrapped
	 */
	public CUBRIDMetaColumns(ResultSet rsWrapped, int iDataType, int iTypeName,
			int iPrecision, int iLength, CUBRIDConnection conn) throws SQLException
  {
		super(rsWrapped, conn);
		_iDataType = iDataType;
		_iTypeName = iTypeName;
		_iPrecision = iPrecision;
		_iLength = iLength;
		_rsUnwrapped = unwrap(ResultSet.class);
	} /* constructor */

	/* ------------------------------------------------------------------------ */
	/** Implements the type translation between Cubrid and ISO SQL
	 * @param sTypeName original type name.
	 * @return data type from java.sql.Types.
	 */
	static int getDataType(String sTypeName)
	{
		CubridType mst = CubridType.getByTypeName(sTypeName);
		PreType pt = mapNAME_CUBRID_TO_ISO.get(mst);
		return pt.getSqlType();
	} /* getDataType */

	/*------------------------------------------------------------------*/
	/** implements length translation.
	 * @param lColumnSize unwrapped length
	 * @param sTypeName original type name.
	 * @return translated length.
	 */
	static long getColumnSize(long lColumnSize, String sTypeName)
	{
		if (lColumnSize <= 0) // VARCHAR must always have a length > 0!
		{
			int iDataType = getDataType(sTypeName);
			if ((iDataType == Types.VARCHAR) ||
					(iDataType == Types.NVARCHAR) ||
					(iDataType == Types.VARBINARY))
				lColumnSize = iMAX_VARCHAR_LENGTH;
		}
		return lColumnSize;
	} /* getColumnSize */
	
	/* ------------------------------------------------------------------------ */
	@Override
	public int getInt(int columnIndex) throws SQLException 
	{
		int iResult = -1;
		if(columnIndex == _iDataType) 
			iResult = getDataType(_rsUnwrapped.getString(_iTypeName));
		else if ((columnIndex == _iPrecision) ||
				(columnIndex == _iLength))
		{
			int iLength = _rsUnwrapped.getInt(_iPrecision);
			if (iLength <= 0)
				iLength = _rsUnwrapped.getInt(_iLength);
			iResult = (int)getColumnSize(
					iLength,
					_rsUnwrapped.getString(_iTypeName));
		}
		else
			iResult = super.getInt(columnIndex);
		return iResult;
	} /* getInt */

	/*------------------------------------------------------------------*/
	/** {@inheritDoc}
	 * Mapped java.sql.Types type is returned in DATA_TYPE.
	 * Original java.sql.Types type can be retrieved by using unwrap. 
	 * Column size is adjusted to CHARS rather than BYTES.  
	 */
	@Override
	public long getLong(int columnIndex) throws SQLException
	{
		long lResult = -1;
		if ((columnIndex == _iPrecision) ||
				(columnIndex == _iLength))
		{
			long lLength = _rsUnwrapped.getLong(_iPrecision);
			if (lLength <= 0)
				lLength = _rsUnwrapped.getLong(_iLength);
			lResult = getColumnSize(
					lLength,
					_rsUnwrapped.getString(_iTypeName));
		}
		else if (columnIndex == _iDataType)
			lResult = getDataType(_rsUnwrapped.getString(_iTypeName));
		else
			lResult = _rsUnwrapped.getLong(columnIndex);
		return lResult;
	} /* getLong */

	/* ------------------------------------------------------------------------ */
	@Override
	public Object getObject(int columnIndex) throws SQLException 
	{
		Object oResult = _rsUnwrapped.getObject(columnIndex);

		
		if (oResult instanceof Integer)
			oResult = Integer.valueOf(getInt(columnIndex));
		else if (oResult instanceof Long)
			oResult = Long.valueOf(getLong(columnIndex));
		else if (oResult instanceof String)
			oResult = getString(columnIndex);

		if(columnIndex == _iLength)
			oResult = Long.valueOf(getLong(columnIndex));
			
		return oResult;
	} /* getObject */

	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	public boolean next() throws SQLException
	{
		return _rsUnwrapped.next();
	} /* next */

} /* class CubridMetaColumns */
