package ch.admin.bar.siard2.cubrid.datatype;

import java.sql.Types;

import ch.admin.bar.siard2.cubrid.K;

public enum CubridPreType {
	  CHAR(Types.CHAR, K.CHARACTER.getKeyword()),
	  VARCHAR(Types.VARCHAR, K.VARCHAR.getKeyword()),
	  BLOB(Types.BLOB, K.BLOB.getKeyword()),
	  CLOB(Types.CLOB, K.CLOB.getKeyword()),
	  NCHAR(Types.NCHAR, K.NCHAR.getKeyword()),
	  NVARCHAR(Types.NVARCHAR, K.NCHAR.getKeyword()+" "+K.VARYING.getKeyword()),
	  BINARY(Types.BINARY, K.BINARY.getKeyword()),
	  BIT(Types.BIT, K.BIT.getKeyword()),
	  SET(Types.OTHER, K.SET.getKeyword()),
	  MULTISET(Types.OTHER, K.MULTISET.getKeyword()),
	  SEQUENCE(Types.OTHER, K.SEQUENCE.getKeyword()),
	  ENUM(Types.OTHER, K.ENUM.getKeyword()),
	  NUMERIC(Types.NUMERIC, K.NUMERIC.getKeyword()),
	  DECIMAL(Types.DECIMAL, K.DECIMAL.getKeyword()),
	  SMALLINT(Types.SMALLINT, K.SMALLINT.getKeyword()),
	  INTEGER(Types.INTEGER, K.INTEGER.getKeyword()),
	  BIGINT(Types.BIGINT, K.BIGINT.getKeyword()),
	  FLOAT(Types.FLOAT, K.FLOAT.getKeyword()),
	  REAL(Types.REAL, K.REAL.getKeyword()),
	  DOUBLE(Types.DOUBLE, K.DOUBLE.getKeyword()+" "+K.PRECISION.getKeyword()),
	  BOOLEAN(Types.BOOLEAN, K.BOOLEAN.getKeyword()),
	  DATE(Types.DATE, K.DATE.getKeyword()),
	  TIME(Types.TIME, K.TIME.getKeyword()),
	  DATETIME(Types.TIME, K.TIME.getKeyword()),
	  TIMESTAMP(Types.TIMESTAMP, K.TIMESTAMP.getKeyword()),
	  XML(Types.SQLXML, K.XML.getKeyword()),
	  INTERVAL(Types.OTHER, K.INTERVAL.getKeyword()); // INTERVAL not supported by JDBC!
	  private String _sKeyword = null;
	  public String getKeyword() { return _sKeyword; }
	  private int _iSqlType = Types.NULL;
	  public int getSqlType() { return _iSqlType; }
	  private CubridPreType(int iSqlType, String sKeyword)
	  {
	    _iSqlType = iSqlType;
	    _sKeyword = sKeyword;
	  } /* constructor */
	  public static CubridPreType getBySqlType(int iSqlType)
	  {
	    CubridPreType datatype  = null;
	    for (int i = 0; (datatype == null) && (i < CubridPreType.values().length); i++)
	    {
	      CubridPreType dt = CubridPreType.values()[i];
	      if (dt.getSqlType() == iSqlType)
	        datatype = dt;
	    }
	    return datatype;
	  } /* getBySqlType */
}
