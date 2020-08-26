package ch.admin.bar.siard2.cubrid.ddl;

import ch.enterag.sqlparser.K;
import ch.enterag.sqlparser.SqlFactory;
import ch.enterag.sqlparser.ddl.AlterTableStatement;

public class CubridAlterTableStatement extends AlterTableStatement {
	public CubridAlterTableStatement(SqlFactory sf) {
		super(sf);
		// TODO Auto-generated constructor stub
	}

	@Override
	  public String format()
	  {
	    String sStatement = K.ALTER.getKeyword() + sSP + K.TABLE.getKeyword() + sSP + 
	      getTableName().format();
	    if (getColumnDefinition() != null)
	      sStatement = sStatement + sSP + K.ADD.getKeyword() + sSP + K.COLUMN.getKeyword() + sSP + 
	        getColumnDefinition().format();
	    else if (getAlterColumnAction() != null)
	      sStatement = sStatement + sSP + K.ALTER.getKeyword() + sSP + K.COLUMN.getKeyword() + sSP +
	        getColumnName().format() + sSP + getAlterColumnAction().format();
	    else if (getColumnName().isSet())
	      sStatement = sStatement + sSP + K.DROP.getKeyword() + sSP + K.COLUMN.getKeyword() + sSP +
	        getColumnName().format();
	    else if (getTableConstraintDefinition() != null)
	      sStatement = sStatement + sSP + K.ADD.getKeyword() + sSP + 
	        getTableConstraintDefinition().format();
	    else if (getConstraintName().isSet())
	      sStatement = sStatement + sSP + K.DROP.getKeyword() + sSP + K.CONSTRAINT.getKeyword() + sSP +
	        getConstraintName().format() + sSP + getDropBehavior().getKeywords();
	    return sStatement;
	  } /* format */
}
