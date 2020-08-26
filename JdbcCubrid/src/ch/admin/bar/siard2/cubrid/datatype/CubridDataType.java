/*======================================================================
CubridDataType implements the type translation from ISO SQL to MySQL for 
              complex types.
Version     : $Id: $
Application : SIARD2
Description : CubridDataType implements the type translation from ISO 
              SQL:2008 to MySQL for complex types.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 08.11.2016, Simon Jutz
======================================================================*/
package ch.admin.bar.siard2.cubrid.datatype;

import ch.enterag.sqlparser.SqlFactory;
import ch.enterag.sqlparser.datatype.DataType;
import ch.enterag.sqlparser.datatype.PredefinedType;

/*====================================================================*/
/** CubridDataType implements the type translation from ISO SQL to MySQL
 * for complex types.
 * @author Simon Jutz
 */
public class CubridDataType extends DataType {

	/*------------------------------------------------------------------*/
	/** constructor with factory only to be called by factory.
	 * @param sf factory.
	 */
	public CubridDataType(SqlFactory sf) {
		super(sf);
	} /* constructor */

	/*------------------------------------------------------------------*/
	/**
	 * format the STRUCT type for Cubrid (serialized as a BLOB)
	 */
	@Override
	public String formatStructType() {
	    PredefinedType pt = getSqlFactory().newPredefinedType();
	    pt.initBlobType(PredefinedType.iUNDEFINED, null);
	    return pt.format();
	} /* formatStructType */

	/*------------------------------------------------------------------*/
	/**
	 * format the ROW type for Cubrid (serialized as a BLOB)
	 */
	@Override
	public String formatRowType() {
	    PredefinedType pt = getSqlFactory().newPredefinedType();
	    pt.initBlobType(PredefinedType.iUNDEFINED, null);
	    return pt.format();
	} /* formatStructType */

	/*------------------------------------------------------------------*/
	/**
	 * format the REF type for Cubrid (serialized as a BLOB)
	 */
	@Override
	public String formatRefType() {
	    PredefinedType pt = getSqlFactory().newPredefinedType();
	    pt.initBlobType(PredefinedType.iUNDEFINED, null);
	    return pt.format();
	} /* formatStructType */

	/*------------------------------------------------------------------*/
	/**
	 * format the ARRAY type for Cubrid (serialized as a BLOB)
	 */
	@Override
	public String formatArrayType() {
	    PredefinedType pt = getSqlFactory().newPredefinedType();
	    pt.initBlobType(PredefinedType.iUNDEFINED, null);
	    return pt.format();
	} /* formatStructType */

	/*------------------------------------------------------------------*/
	/**
	 * format the MULTISET type for Cubrid (serialized as a BLOB)
	 */
	@Override
	public String formatMultisetType() {
	    PredefinedType pt = getSqlFactory().newPredefinedType();
	    pt.initBlobType(PredefinedType.iUNDEFINED, null);
	    return pt.format();
	} /* formatStructType */

	/*------------------------------------------------------------------*/
	/** format the data type for Cubrid.
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

} /* class CubridDataType */