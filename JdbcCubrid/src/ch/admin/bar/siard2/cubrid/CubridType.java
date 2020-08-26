package ch.admin.bar.siard2.cubrid;

/**
 * Contains all built-in Cubrid Types
 * @author Byungwook Kim
 */
public enum CubridType {
	BIT("bit"),
	VARBIT("bit varying"),
	SHORT("short"),
	SMALLINT("smallint"),
	BIGINT("bigint"),
	INT("int"),
	INTEGER("integer"),
	FLOAT("float"),
	REAL("real"),
	DOUBLE("double"),
	DOUBLEPRECISION("double precision"),
	DECIMAL("decimal"),
	NUMERIC("numeric"),
	DATE("date"),
	TIME("time"),
	DATETIME("datetime"),
	TIMESTAMP("timestamp"),
	TIMESTAMPLTZ("timestampltz"),
	TIMESTAMPTZ("timestamptz"),
	DATETIMELTZ("datetimeltz"),
	DATETIMETZ("datetimetz"),
	CHAR("char"),
	STRING("string"),
	VARCHAR("varchar"),
	BLOB("blob"),
	CLOB("clob"),
	ENUM("enum"),
	SET("set"),
	MULTISET("multiset"),
	LIST("list"),
	SEQUENCE("sequence"),
	OBJECT("object");
	
	private String sTypeName = null;
	
	/**
	 * constructor
	 * @param _sTypeName the system name of the type
	 */
	CubridType(String _sTypeName) {
		sTypeName = _sTypeName;
	} /* constructor */
	
	/**
	 * Gets the enum constant with a given type name
	 * @param _sTypeName the type name
	 * @return enum constant with the given type name
	 */
	public static CubridType getByTypeName(String _sTypeName) {
		CubridType result = null;
		for(int i=0;i<CubridType.values().length;i++) {
			CubridType t = CubridType.values()[i];
			if(t.getTypeName().equalsIgnoreCase(_sTypeName)) {
				result = t;
				break;
			}
		}
		return result;
	} /* getByTypeName */
	
	/**
	 * Gets the type name
	 * @return the type name
	 */
	public String getTypeName() {
		return sTypeName;
	}
		
} /* enum CubridType */
