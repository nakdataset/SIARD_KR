/*======================================================================
BaseDatabaseMetaData implements wrapped DatabaseMetaData.
Version     : $Id: $
Application : SIARD2
Description : BaseDatabaseMetaData implements wrapped DatabaseMetaData.
              See https://docs.oracle.com/javase/7/docs/api/java/sql/DatabaseMetaData.html
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 11.05.2016, Hartwig Thomas
======================================================================*/
package ch.enterag.utils.jdbc;

import java.sql.*;

/*====================================================================*/
/** BaseDatabaseMetaData implements wrapped DatabaseMetaData and serves 
 * as a base for derived JDBC wrappers.
 * @author Hartwig Thomas
 */
public abstract class BaseDatabaseMetaData
  implements DatabaseMetaData
{
  /* additional field in getTables() */
  public static final String _sQUERY_TEXT = "QUERY_TEXT";
  
  /*------------------------------------------------------------------*/
  public String toPattern(String sIdentifier)
    throws SQLException
  {
    String sPattern = sIdentifier;
    if (sPattern != null)
    {
      if (sPattern.length() > 0)
      {
        sPattern = sPattern.
          replace("%", getSearchStringEscape()+"%").
          replace("_", getSearchStringEscape()+"_");
      }
      else
        sPattern = "%";
    }
    return sPattern;
  } /* toPattern */

  /** wrapped database meta data */
  private DatabaseMetaData _dmdWrapped = null;
  
  /*------------------------------------------------------------------*/
  /** convert an AbstractMethodError into an SQLFeatureNotSupportedEception.
   * This error indicates that the JDBC driver wrapped implements an
   * earlier version of JDBC which did not include this method.
   * @param ame
   * @throws SQLFeatureNotSupportedException
   */
  private void throwUndefinedMethod(AbstractMethodError ame)
    throws SQLFeatureNotSupportedException
  {
    throw new SQLFeatureNotSupportedException("Undefined JDBC method!", ame);
  } /* throwUndefinedMethod */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param dmdWrapped database meta data to be wrapped.
   */
  public BaseDatabaseMetaData(DatabaseMetaData dmdWrapped)
  {
    _dmdWrapped = dmdWrapped;
  } /* constructor BaseDatabaseMetaData */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Connection getConnection() throws SQLException
  {
    return _dmdWrapped.getConnection();
  } /* getConnection */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean allProceduresAreCallable() throws SQLException
  {
    return _dmdWrapped.allProceduresAreCallable();
  } /* allProceduresAreCallable */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean allTablesAreSelectable() throws SQLException
  {
    return _dmdWrapped.allTablesAreSelectable();
  } /* allTablesAreSelectable */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getURL() throws SQLException
  {
    return _dmdWrapped.getURL();
  } /* getURL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getUserName() throws SQLException
  {
    return _dmdWrapped.getUserName();
  } /* getUserName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isReadOnly() throws SQLException
  {
    return _dmdWrapped.isReadOnly();
  } /* isReadOnly */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean nullsAreSortedHigh() throws SQLException
  {
    return _dmdWrapped.nullsAreSortedHigh();
  } /* nullsAreSortedHigh */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean nullsAreSortedLow() throws SQLException
  {
    return _dmdWrapped.nullsAreSortedLow();
  } /* nullsAreSortedLow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean nullsAreSortedAtStart() throws SQLException
  {
    return _dmdWrapped.nullsAreSortedAtStart();
  } /* nullsAreSortedAtStart */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean nullsAreSortedAtEnd() throws SQLException
  {
    return _dmdWrapped.nullsAreSortedAtEnd();
  } /* nullsAreSortedAtEnd */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getDatabaseProductName() throws SQLException
  {
    return _dmdWrapped.getDatabaseProductName();
  } /* getDatabaseProductName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getDatabaseProductVersion() throws SQLException
  {
    return _dmdWrapped.getDatabaseProductVersion();
  } /* getDatabaseProductVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getDriverName() throws SQLException
  {
    return _dmdWrapped.getDriverName();
  } /* getDriverName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getDriverVersion() throws SQLException
  {
    return _dmdWrapped.getDriverVersion();
  } /* getDriverVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getDriverMajorVersion()
  {
    return _dmdWrapped.getDriverMajorVersion();
  } /* getDriverMajorVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getDriverMinorVersion()
  {
    return _dmdWrapped.getDriverMinorVersion();
  } /* getDriverMinorVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean usesLocalFiles() throws SQLException
  {
    return _dmdWrapped.usesLocalFiles();
  } /* usesLocalFiles */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean usesLocalFilePerTable() throws SQLException
  {
    return _dmdWrapped.usesLocalFilePerTable();
  } /* usesLocalFilePerTable */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsMixedCaseIdentifiers() throws SQLException
  {
    return _dmdWrapped.supportsMixedCaseIdentifiers();
  } /* supportsMixedCaseIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean storesUpperCaseIdentifiers() throws SQLException
  {
    return _dmdWrapped.storesUpperCaseIdentifiers();
  } /* storesUpperCaseIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean storesLowerCaseIdentifiers() throws SQLException
  {
    return _dmdWrapped.storesLowerCaseIdentifiers();
  } /* storesLowerCaseIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean storesMixedCaseIdentifiers() throws SQLException
  {
    return _dmdWrapped.storesMixedCaseIdentifiers();
  } /* storesMixedCaseIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsMixedCaseQuotedIdentifiers()
    throws SQLException
  {
    return _dmdWrapped.supportsMixedCaseQuotedIdentifiers();
  } /* supportsMixedCaseQuotedIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean storesUpperCaseQuotedIdentifiers() throws SQLException
  {
    return _dmdWrapped.storesUpperCaseQuotedIdentifiers();
  } /* storesUpperCaseQuotedIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean storesLowerCaseQuotedIdentifiers() throws SQLException
  {
    return _dmdWrapped.storesLowerCaseQuotedIdentifiers();
  } /* storesLowerCaseQuotedIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean storesMixedCaseQuotedIdentifiers() throws SQLException
  {
    return _dmdWrapped.storesMixedCaseQuotedIdentifiers();
  } /* storesMixedCaseQuotedIdentifiers */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getIdentifierQuoteString() throws SQLException
  {
    return _dmdWrapped.getIdentifierQuoteString();
  } /* getIdentifierQuoteString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getSQLKeywords() throws SQLException
  {
    return _dmdWrapped.getSQLKeywords();
  } /* getSQLKeywords */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getNumericFunctions() throws SQLException
  {
    return _dmdWrapped.getNumericFunctions();
  } /* getNumericFunctions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getStringFunctions() throws SQLException
  {
    return _dmdWrapped.getStringFunctions();
  } /* getStringFunctions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getSystemFunctions() throws SQLException
  {
    return _dmdWrapped.getSystemFunctions();
  } /* getSystemFunctions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getTimeDateFunctions() throws SQLException
  {
    return _dmdWrapped.getTimeDateFunctions();
  } /* getTimeDateFunctions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getSearchStringEscape() throws SQLException
  {
    return _dmdWrapped.getSearchStringEscape();
  } /* getSearchStringEscape */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getExtraNameCharacters() throws SQLException
  {
    return _dmdWrapped.getExtraNameCharacters();
  } /* getExtraNameCharacters */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsAlterTableWithAddColumn() throws SQLException
  {
    return _dmdWrapped.supportsAlterTableWithAddColumn();
  } /* supportsAlterTableWithAddColumn */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsAlterTableWithDropColumn() throws SQLException
  {
    return _dmdWrapped.supportsAlterTableWithDropColumn();
  } /* supportsAlterTableWithDropColumn */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsColumnAliasing() throws SQLException
  {
    return _dmdWrapped.supportsColumnAliasing();
  } /* supportsColumnAliasing */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean nullPlusNonNullIsNull() throws SQLException
  {
    return _dmdWrapped.nullPlusNonNullIsNull();
  } /* nullPlusNonNullIsNull */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsConvert() throws SQLException
  {
    return _dmdWrapped.supportsConvert();
  } /* supportsConvert */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsConvert(int fromType, int toType)
    throws SQLException
  {
    return _dmdWrapped.supportsConvert(fromType, toType);
  } /* supportsConvert */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsTableCorrelationNames() throws SQLException
  {
    return _dmdWrapped.supportsTableCorrelationNames();
  } /* supportsTableCorrelationNames */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsDifferentTableCorrelationNames()
    throws SQLException
  {
    return _dmdWrapped.supportsDifferentTableCorrelationNames();
  } /* supportsDifferentTableCorrelationNames */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsExpressionsInOrderBy() throws SQLException
  {
    return _dmdWrapped.supportsExpressionsInOrderBy();
  } /* supportsExpressionsInOrderBy */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsOrderByUnrelated() throws SQLException
  {
    return _dmdWrapped.supportsOrderByUnrelated();
  } /* supportsOrderByUnrelated */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsGroupBy() throws SQLException
  {
    return _dmdWrapped.supportsGroupBy();
  } /* supportsGroupBy */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsGroupByUnrelated() throws SQLException
  {
    return _dmdWrapped.supportsGroupByUnrelated();
  } /* supportsGroupByUnrelated */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsGroupByBeyondSelect() throws SQLException
  {
    return _dmdWrapped.supportsGroupByBeyondSelect();
  } /* supportsGroupByBeyondSelect */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsLikeEscapeClause() throws SQLException
  {
    return _dmdWrapped.supportsLikeEscapeClause();
  } /* supportsLikeEscapeClause */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsMultipleResultSets() throws SQLException
  {
    return _dmdWrapped.supportsMultipleResultSets();
  } /* supportsMultipleResultSets */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsMultipleTransactions() throws SQLException
  {
    return _dmdWrapped.supportsMultipleTransactions();
  } /* supportsMultipleTransactions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsNonNullableColumns() throws SQLException
  {
    return _dmdWrapped.supportsNonNullableColumns();
  } /* supportsNonNullableColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsMinimumSQLGrammar() throws SQLException
  {
    return _dmdWrapped.supportsMinimumSQLGrammar();
  } /* supportsMinimumSQLGrammar */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCoreSQLGrammar() throws SQLException
  {
    return _dmdWrapped.supportsCoreSQLGrammar();
  } /* supportsCoreSQLGrammar */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsExtendedSQLGrammar() throws SQLException
  {
    return _dmdWrapped.supportsExtendedSQLGrammar();
  } /* supportsExtendedSQLGrammar */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsANSI92EntryLevelSQL() throws SQLException
  {
    return _dmdWrapped.supportsANSI92EntryLevelSQL();
  } /* supportsANSI92EntryLevelSQL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsANSI92IntermediateSQL() throws SQLException
  {
    return _dmdWrapped.supportsANSI92IntermediateSQL();
  } /* supportsANSI92IntermediateSQL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsANSI92FullSQL() throws SQLException
  {
    return _dmdWrapped.supportsANSI92FullSQL();
  } /* supportsANSI92FullSQL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsIntegrityEnhancementFacility()
    throws SQLException
  {
    return _dmdWrapped.supportsIntegrityEnhancementFacility();
  } /* supportsIntegrityEnhancementFacility */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsOuterJoins() throws SQLException
  {
    return _dmdWrapped.supportsOuterJoins();
  } /* supportsOuterJoins */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsFullOuterJoins() throws SQLException
  {
    return _dmdWrapped.supportsFullOuterJoins();
  } /* supportsFullOuterJoins */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsLimitedOuterJoins() throws SQLException
  {
    return _dmdWrapped.supportsLimitedOuterJoins();
  } /* supportsLimitedOuterJoins() */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getSchemaTerm() throws SQLException
  {
    return _dmdWrapped.getSchemaTerm();
  } /* getSchemaTerm */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getProcedureTerm() throws SQLException
  {
    return _dmdWrapped.getProcedureTerm();
  } /* getProcedureTerm */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getCatalogTerm() throws SQLException
  {
    return _dmdWrapped.getCatalogTerm();
  } /* getCatalogTerm */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isCatalogAtStart() throws SQLException
  {
    return _dmdWrapped.isCatalogAtStart();
  } /* isCatalogAtStart */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getCatalogSeparator() throws SQLException
  {
    return _dmdWrapped.getCatalogSeparator();
  } /* getCatalogSeparator */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSchemasInDataManipulation()
    throws SQLException
  {
    return _dmdWrapped.supportsSchemasInDataManipulation();
  } /* supportsSchemasInDataManipulation */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSchemasInProcedureCalls() throws SQLException
  {
    return _dmdWrapped.supportsSchemasInProcedureCalls();
  } /* supportsSchemasInProcedureCalls */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSchemasInTableDefinitions()
    throws SQLException
  {
    return _dmdWrapped.supportsSchemasInTableDefinitions();
  } /* supportsSchemasInTableDefinitions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSchemasInIndexDefinitions()
    throws SQLException
  {
    return _dmdWrapped.supportsSchemasInIndexDefinitions();
  } /* supportsSchemasInIndexDefinitions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSchemasInPrivilegeDefinitions()
    throws SQLException
  {
    return _dmdWrapped.supportsSchemasInPrivilegeDefinitions();
  } /* supportsSchemasInPrivilegeDefinitions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCatalogsInDataManipulation()
    throws SQLException
  {
    return _dmdWrapped.supportsCatalogsInDataManipulation();
  } /* supportsCatalogsInDataManipulation */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCatalogsInProcedureCalls() throws SQLException
  {
    return _dmdWrapped.supportsCatalogsInProcedureCalls();
  } /* supportsCatalogsInProcedureCalls */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCatalogsInTableDefinitions()
    throws SQLException
  {
    return _dmdWrapped.supportsCatalogsInTableDefinitions();
  } /* supportsCatalogsInTableDefinitions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCatalogsInIndexDefinitions()
    throws SQLException
  {
    return _dmdWrapped.supportsCatalogsInIndexDefinitions();
  } /* supportsCatalogsInIndexDefinitions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCatalogsInPrivilegeDefinitions()
    throws SQLException
  {
    return _dmdWrapped.supportsCatalogsInPrivilegeDefinitions();
  } /* supportsCatalogsInPrivilegeDefinitions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsPositionedDelete() throws SQLException
  {
    return _dmdWrapped.supportsPositionedDelete();
  } /* supportsPositionedDelete */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsPositionedUpdate() throws SQLException
  {
    return _dmdWrapped.supportsPositionedUpdate();
  } /* supportsPositionedUpdate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSelectForUpdate() throws SQLException
  {
    return _dmdWrapped.supportsSelectForUpdate();
  } /* supportsSelectForUpdate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsStoredProcedures() throws SQLException
  {
    return _dmdWrapped.supportsStoredProcedures();
  } /* supportsStoredProcedures */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSubqueriesInComparisons() throws SQLException
  {
    return _dmdWrapped.supportsSubqueriesInComparisons();
  } /* supportsSubqueriesInComparisons */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSubqueriesInExists() throws SQLException
  {
    return _dmdWrapped.supportsSubqueriesInExists();
  } /* supportsSubqueriesInExists */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSubqueriesInIns() throws SQLException
  {
    return _dmdWrapped.supportsSubqueriesInIns();
  } /* supportsSubqueriesInIns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSubqueriesInQuantifieds() throws SQLException
  {
    return _dmdWrapped.supportsSubqueriesInQuantifieds();
  } /* supportsSubqueriesInQuantifieds */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsCorrelatedSubqueries() throws SQLException
  {
    return _dmdWrapped.supportsCorrelatedSubqueries();
  } /* supportsCorrelatedSubqueries */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsUnion() throws SQLException
  {
    return _dmdWrapped.supportsUnion();
  } /* supportsUnion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsUnionAll() throws SQLException
  {
    return _dmdWrapped.supportsUnionAll();
  } /* supportsUnionAll */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsOpenCursorsAcrossCommit() throws SQLException
  {
    return _dmdWrapped.supportsOpenCursorsAcrossCommit();
  } /* supportsOpenCursorsAcrossCommit */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsOpenCursorsAcrossRollback()
    throws SQLException
  {
    return _dmdWrapped.supportsOpenCursorsAcrossRollback();
  } /* supportsOpenCursorsAcrossRollback */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsOpenStatementsAcrossCommit()
    throws SQLException
  {
    return _dmdWrapped.supportsOpenStatementsAcrossCommit();
  } /* supportsOpenStatementsAcrossCommit */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsOpenStatementsAcrossRollback()
    throws SQLException
  {
    return _dmdWrapped.supportsOpenStatementsAcrossRollback();
  } /* supportsOpenStatementsAcrossRollback */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxBinaryLiteralLength() throws SQLException
  {
    return _dmdWrapped.getMaxBinaryLiteralLength();
  } /* getMaxBinaryLiteralLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxCharLiteralLength() throws SQLException
  {
    return _dmdWrapped.getMaxCharLiteralLength();
  } /* getMaxCharLiteralLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxColumnNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxColumnNameLength();
  } /* getMaxColumnNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxColumnsInGroupBy() throws SQLException
  {
    return _dmdWrapped.getMaxColumnsInGroupBy();
  } /* getMaxColumnsInGroupBy */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxColumnsInIndex() throws SQLException
  {
    return _dmdWrapped.getMaxColumnsInIndex();
  } /* getMaxColumnsInIndex */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxColumnsInOrderBy() throws SQLException
  {
    return _dmdWrapped.getMaxColumnsInOrderBy();
  } /* getMaxColumnsInOrderBy */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxColumnsInSelect() throws SQLException
  {
    return _dmdWrapped.getMaxColumnsInSelect();
  } /* getMaxColumnsInSelect */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxColumnsInTable() throws SQLException
  {
    return _dmdWrapped.getMaxColumnsInTable();
  } /* getMaxColumnsInTable */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxConnections() throws SQLException
  {
    return _dmdWrapped.getMaxConnections();
  } /* getMaxConnections */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxCursorNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxCursorNameLength();
  } /* getMaxCursorNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxIndexLength() throws SQLException
  {
    return _dmdWrapped.getMaxIndexLength();
  } /* getMaxIndexLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxSchemaNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxSchemaNameLength();
  } /* getMaxSchemaNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxProcedureNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxProcedureNameLength();
  } /* getMaxProcedureNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxCatalogNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxCatalogNameLength();
  } /* getMaxCatalogNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxRowSize() throws SQLException
  {
    return _dmdWrapped.getMaxRowSize();
  } /* getMaxRowSize */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean doesMaxRowSizeIncludeBlobs() throws SQLException
  {
    return _dmdWrapped.doesMaxRowSizeIncludeBlobs();
  } /* doesMaxRowSizeIncludeBlobs */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxStatementLength() throws SQLException
  {
    return _dmdWrapped.getMaxStatementLength();
  } /* getMaxStatementLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxStatements() throws SQLException
  {
    return _dmdWrapped.getMaxStatements();
  } /* getMaxStatements */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxTableNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxTableNameLength();
  } /* getMaxTableNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxTablesInSelect() throws SQLException
  {
    return _dmdWrapped.getMaxTablesInSelect();
  } /* getMaxTablesInSelect */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getMaxUserNameLength() throws SQLException
  {
    return _dmdWrapped.getMaxUserNameLength();
  } /* getMaxUserNameLength */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getDefaultTransactionIsolation() throws SQLException
  {
    return _dmdWrapped.getDefaultTransactionIsolation();
  } /* getDefaultTransactionIsolation */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsTransactions() throws SQLException
  {
    return _dmdWrapped.supportsTransactions();
  } /* supportsTransactions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsTransactionIsolationLevel(int level)
    throws SQLException
  {
    return _dmdWrapped.supportsTransactionIsolationLevel(level);
  } /* supportsTransactionIsolationLevel */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsDataDefinitionAndDataManipulationTransactions()
    throws SQLException
  {
    return _dmdWrapped.supportsDataDefinitionAndDataManipulationTransactions();
  } /* supportsDataDefinitionAndDataManipulationTransactions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsDataManipulationTransactionsOnly()
    throws SQLException
  {
    return _dmdWrapped.supportsDataManipulationTransactionsOnly();
  } /* supportsDataManipulationTransactionsOnly */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean dataDefinitionCausesTransactionCommit()
    throws SQLException
  {
    return _dmdWrapped.dataDefinitionCausesTransactionCommit();
  } /* dataDefinitionCausesTransactionCommit */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean dataDefinitionIgnoredInTransactions()
    throws SQLException
  {
    return _dmdWrapped.dataDefinitionIgnoredInTransactions();
  } /* dataDefinitionIgnoredInTransactions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getProcedures(String catalog, String schemaPattern,
    String procedureNamePattern) throws SQLException
  {
    return _dmdWrapped.getProcedures(catalog, schemaPattern, procedureNamePattern);
  } /* getProcedures */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getProcedureColumns(String catalog,
    String schemaPattern, String procedureNamePattern,
    String columnNamePattern) throws SQLException
  {
    return _dmdWrapped.getProcedureColumns(catalog, schemaPattern, 
      procedureNamePattern, columnNamePattern);
  } /* getProcedureColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getTables(String catalog, String schemaPattern,
    String tableNamePattern, String[] types) throws SQLException
  {
    return _dmdWrapped.getTables(catalog, schemaPattern, tableNamePattern, types);
  } /* getTables */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getSchemas() throws SQLException
  {
    return _dmdWrapped.getSchemas();
  } /* getSchemas */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getCatalogs() throws SQLException
  {
    return _dmdWrapped.getCatalogs();
  } /* getCatalogs */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getTableTypes() throws SQLException
  {
    return _dmdWrapped.getTableTypes();
  } /* getTableTypes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getColumns(String catalog, String schemaPattern,
    String tableNamePattern, String columnNamePattern)
    throws SQLException
  {
    return _dmdWrapped.getColumns(catalog, schemaPattern, tableNamePattern, 
      columnNamePattern);
  } /* getColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getColumnPrivileges(String catalog, String schema,
    String table, String columnNamePattern) throws SQLException
  {
    return _dmdWrapped.getColumnPrivileges(catalog, schema, table, 
      columnNamePattern);
  } /* getColumnPrivileges */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getTablePrivileges(String catalog,
    String schemaPattern, String tableNamePattern) throws SQLException
  {
    return _dmdWrapped.getTablePrivileges(catalog, schemaPattern, 
      tableNamePattern);
  } /* getTablePrivileges */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getBestRowIdentifier(String catalog, String schema,
    String table, int scope, boolean nullable) throws SQLException
  {
    return _dmdWrapped.getBestRowIdentifier(catalog, schema, table, scope, 
      nullable);
  } /* getBestRowIdentifier */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getVersionColumns(String catalog, String schema,
    String table) throws SQLException
  {
    return _dmdWrapped.getVersionColumns(catalog, schema, table);
  } /* getVersionColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getPrimaryKeys(String catalog, String schema,
    String table) throws SQLException
  {
    return _dmdWrapped.getPrimaryKeys(catalog, schema, table);
  } /* getPrimaryKeys */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getImportedKeys(String catalog, String schema,
    String table) throws SQLException
  {
    return _dmdWrapped.getImportedKeys(catalog, schema, table);
  } /* getImportedKeys */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getExportedKeys(String catalog, String schema,
    String table) throws SQLException
  {
    return _dmdWrapped.getExportedKeys(catalog, schema, table);
  } /* getExportedKeys */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getCrossReference(String parentCatalog,
    String parentSchema, String parentTable, String foreignCatalog,
    String foreignSchema, String foreignTable) throws SQLException
  {
    return _dmdWrapped.getCrossReference(parentCatalog, parentSchema, 
      parentTable, foreignCatalog, foreignSchema, foreignTable);
  } /* getCrossReference */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getTypeInfo() throws SQLException
  {
    return _dmdWrapped.getTypeInfo();
  } /* getTypeInfo */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getIndexInfo(String catalog, String schema,
    String table, boolean unique, boolean approximate)
    throws SQLException
  {
    return _dmdWrapped.getIndexInfo(catalog, schema, table, unique, 
      approximate);
  } /* getIndexInfo */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsResultSetType(int type) throws SQLException
  {
    return _dmdWrapped.supportsResultSetType(type);
  } /* supportsResultSetType */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsResultSetConcurrency(int type, int concurrency)
    throws SQLException
  {
    return _dmdWrapped.supportsResultSetConcurrency(type, concurrency);
  } /* supportsResultSetConcurrency */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean ownUpdatesAreVisible(int type) throws SQLException
  {
    return _dmdWrapped.ownUpdatesAreVisible(type);
  } /* ownUpdatesAreVisible */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean ownDeletesAreVisible(int type) throws SQLException
  {
    return _dmdWrapped.ownDeletesAreVisible(type);
  } /* ownDeletesAreVisible */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean ownInsertsAreVisible(int type) throws SQLException
  {
    return _dmdWrapped.ownInsertsAreVisible(type);
  } /* ownInsertsAreVisible */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean othersUpdatesAreVisible(int type) throws SQLException
  {
    return _dmdWrapped.othersUpdatesAreVisible(type);
  } /* othersUpdatesAreVisible */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean othersDeletesAreVisible(int type) throws SQLException
  {
    return _dmdWrapped.othersDeletesAreVisible(type);
  } /* othersDeletesAreVisible */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean othersInsertsAreVisible(int type) throws SQLException
  {
    return _dmdWrapped.othersInsertsAreVisible(type);
  } /* othersInsertsAreVisible */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean updatesAreDetected(int type) throws SQLException
  {
    return _dmdWrapped.updatesAreDetected(type);
  } /* updatesAreDetected */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean deletesAreDetected(int type) throws SQLException
  {
    return _dmdWrapped.deletesAreDetected(type);
  } /* deletesAreDetected */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean insertsAreDetected(int type) throws SQLException
  {
    return _dmdWrapped.insertsAreDetected(type);
  } /* insertsAreDetected */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsBatchUpdates() throws SQLException
  {
    return _dmdWrapped.supportsBatchUpdates();
  } /* supportsBatchUpdates */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getUDTs(String catalog, String schemaPattern,
    String typeNamePattern, int[] types) throws SQLException
  {
    return _dmdWrapped.getUDTs(catalog, schemaPattern, typeNamePattern, 
      types);
  } /* getUDTs */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsSavepoints() throws SQLException
  {
    return _dmdWrapped.supportsSavepoints();
  } /* supportsSavepoints */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsNamedParameters() throws SQLException
  {
    return _dmdWrapped.supportsNamedParameters();
  } /* supportsNamedParameters */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsMultipleOpenResults() throws SQLException
  {
    return _dmdWrapped.supportsMultipleOpenResults();
  } /* supportsMultipleOpenResults */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsGetGeneratedKeys() throws SQLException
  {
    return _dmdWrapped.supportsGetGeneratedKeys();
  } /* supportsGetGeneratedKeys */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getSuperTypes(String catalog, String schemaPattern,
    String typeNamePattern) throws SQLException
  {
    return _dmdWrapped.getSuperTypes(catalog, schemaPattern, typeNamePattern);
  } /* getSuperTypes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getSuperTables(String catalog, String schemaPattern,
    String tableNamePattern) throws SQLException
  {
    return _dmdWrapped.getSuperTables(catalog, schemaPattern, tableNamePattern);
  } /* getSuperTables */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getAttributes(String catalog, String schemaPattern,
    String typeNamePattern, String attributeNamePattern)
    throws SQLException
  {
    return _dmdWrapped.getAttributes(catalog, schemaPattern, typeNamePattern, 
      attributeNamePattern);
  } /* getAttributes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsResultSetHoldability(int holdability)
    throws SQLException
  {
    return _dmdWrapped.supportsResultSetHoldability(holdability);
  } /* supportsResultSetHoldability */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getResultSetHoldability() throws SQLException
  {
    return _dmdWrapped.getResultSetHoldability();
  } /* getResultSetHoldability */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getDatabaseMajorVersion() throws SQLException
  {
    return _dmdWrapped.getDatabaseMajorVersion();
  } /* getDatabaseMajorVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getDatabaseMinorVersion() throws SQLException
  {
    return _dmdWrapped.getDatabaseMinorVersion();
  } /* getDatabaseMinorVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getJDBCMajorVersion() throws SQLException
  {
    return _dmdWrapped.getJDBCMajorVersion();
  } /* getJDBCMajorVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getJDBCMinorVersion() throws SQLException
  {
    return _dmdWrapped.getJDBCMinorVersion();
  } /* getJDBCMinorVersion */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getSQLStateType() throws SQLException
  {
    return _dmdWrapped.getSQLStateType();
  } /* getSQLStateType */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean locatorsUpdateCopy() throws SQLException
  {
    return _dmdWrapped.locatorsUpdateCopy();
  } /* locatorsUpdateCopy */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsStatementPooling() throws SQLException
  {
    return _dmdWrapped.supportsStatementPooling();
  } /* supportsStatementPooling */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public RowIdLifetime getRowIdLifetime() throws SQLException
  {
    return _dmdWrapped.getRowIdLifetime();
  } /* getRowIdLifetime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getSchemas(String catalog, String schemaPattern)
    throws SQLException
  {
    return _dmdWrapped.getSchemas(catalog,schemaPattern);
  } /* getSchemas */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean supportsStoredFunctionsUsingCallSyntax()
    throws SQLException
  {
    return _dmdWrapped.supportsStoredFunctionsUsingCallSyntax();
  } /* supportsStoredFunctionsUsingCallSyntax */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean autoCommitFailureClosesAllResultSets()
    throws SQLException
  {
    return _dmdWrapped.autoCommitFailureClosesAllResultSets();
  } /* autoCommitFailureClosesAllResultSets */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getClientInfoProperties() throws SQLException
  {
    return _dmdWrapped.getClientInfoProperties();
  } /* getClientInfoProperties */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getFunctions(String catalog, String schemaPattern,
    String functionNamePattern) throws SQLException
  {
    return _dmdWrapped.getFunctions(catalog, schemaPattern, functionNamePattern);
  } /* getFunctions */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getFunctionColumns(String catalog,
    String schemaPattern, String functionNamePattern,
    String columnNamePattern) throws SQLException
  {
    return _dmdWrapped.getFunctionColumns(catalog, schemaPattern, 
      functionNamePattern, columnNamePattern);
  } /* getFunctionColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getPseudoColumns(String catalog,
    String schemaPattern, String tableNamePattern,
    String columnNamePattern) throws SQLException
  {
    ResultSet rs = null;
    try { rs = _dmdWrapped.getPseudoColumns(catalog, schemaPattern, 
      tableNamePattern, columnNamePattern); }
    catch (AbstractMethodError ame) { throwUndefinedMethod(ame); }
    return rs;
  } /* getPseudoColumns */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean generatedKeyAlwaysReturned() throws SQLException
  {
    boolean bGeneratedKeyAlwaysReturned = false;
    try { bGeneratedKeyAlwaysReturned = _dmdWrapped.generatedKeyAlwaysReturned(); }
    catch (AbstractMethodError ame) { throwUndefinedMethod(ame); }
    return bGeneratedKeyAlwaysReturned;
  } /* generatedKeyAlwaysReturned */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException
  {
    return (iface == DatabaseMetaData.class);
  } /* isWrapperFor */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @SuppressWarnings("unchecked")
  public <T> T unwrap(Class<T> iface) throws SQLException
  {
    T wrapped = null;
    if (isWrapperFor(iface))
      wrapped = (T)_dmdWrapped;
    return wrapped;
  } /* unwrap */

} /* class BaseDatabaseMetaData */
