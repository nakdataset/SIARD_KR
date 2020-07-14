// Generated from Sql.g4 by ANTLR 4.5.2
package ch.enterag.sqlparser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlStatement(SqlParser.SqlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#ddlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlStatement(SqlParser.DdlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dmlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlStatement(SqlParser.DmlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropSchemaStatement(SqlParser.DropSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createSchemaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateSchemaStatement(SqlParser.CreateSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#userName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserName(SqlParser.UserNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#roleName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleName(SqlParser.RoleNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#authorizationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthorizationName(SqlParser.AuthorizationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(SqlParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(SqlParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#attributeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeName(SqlParser.AttributeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastIdentifier(SqlParser.CastIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#parameterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterName(SqlParser.ParameterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#queryName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryName(SqlParser.QueryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#correlationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorrelationName(SqlParser.CorrelationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowName(SqlParser.WindowNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#catalogName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatalogName(SqlParser.CatalogNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(SqlParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(SqlParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(SqlParser.SchemaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#qualifiedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedId(SqlParser.QualifiedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#identifierChain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierChain(SqlParser.IdentifierChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SqlParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#constraintName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintName(SqlParser.ConstraintNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#udtName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdtName(SqlParser.UdtNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#specificMethodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificMethodName(SqlParser.SpecificMethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#routineName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineName(SqlParser.RoutineNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#triggerName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerName(SqlParser.TriggerNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sequenceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceName(SqlParser.SequenceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#columnReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnReference(SqlParser.ColumnReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#targetArrayReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetArrayReference(SqlParser.TargetArrayReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#arrayReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayReference(SqlParser.ArrayReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropBehavior}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropBehavior(SqlParser.DropBehaviorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#commitAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommitAction(SqlParser.CommitActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#defaultsOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultsOption(SqlParser.DefaultsOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#identityOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityOption(SqlParser.IdentityOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#match}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(SqlParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referenceGeneration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceGeneration(SqlParser.ReferenceGenerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referenceScopeCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceScopeCheck(SqlParser.ReferenceScopeCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referentialAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferentialAction(SqlParser.ReferentialActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableScope(SqlParser.TableScopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#instantiability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstantiability(SqlParser.InstantiabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#finality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinality(SqlParser.FinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#parameterMode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterMode(SqlParser.ParameterModeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#languageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageName(SqlParser.LanguageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#parameterStyle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterStyle(SqlParser.ParameterStyleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#nullCallClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCallClause(SqlParser.NullCallClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#deterministic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeterministic(SqlParser.DeterministicContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dataAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataAccess(SqlParser.DataAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodType(SqlParser.MethodTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#symmetricOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymmetricOption(SqlParser.SymmetricOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(SqlParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#setQuantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetQuantifier(SqlParser.SetQuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sampleMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSampleMethod(SqlParser.SampleMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#joinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinType(SqlParser.JoinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#orderingSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderingSpecification(SqlParser.OrderingSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#nullOrdering}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullOrdering(SqlParser.NullOrderingContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#rankFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRankFunction(SqlParser.RankFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#setFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetFunction(SqlParser.SetFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#binarySetFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarySetFunction(SqlParser.BinarySetFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#inverseDistributionFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInverseDistributionFunction(SqlParser.InverseDistributionFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameUnits(SqlParser.WindowFrameUnitsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameExclusion(SqlParser.WindowFrameExclusionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperator(SqlParser.MultiplicativeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#additiveOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperator(SqlParser.AdditiveOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#booleanOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOperator(SqlParser.BooleanOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#timeZoneField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeZoneField(SqlParser.TimeZoneFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#multiplier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplier(SqlParser.MultiplierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#withOrWithoutTimeZone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithOrWithoutTimeZone(SqlParser.WithOrWithoutTimeZoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#multisetOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetOperator(SqlParser.MultisetOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#queryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryOperator(SqlParser.QueryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#primaryDatetimeField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryDatetimeField(SqlParser.PrimaryDatetimeFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(SqlParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(SqlParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#withOrWithoutData}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithOrWithoutData(SqlParser.WithOrWithoutDataContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#constraintCheckTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintCheckTime(SqlParser.ConstraintCheckTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#deferrability}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferrability(SqlParser.DeferrabilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#levels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevels(SqlParser.LevelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#triggerActionTime}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerActionTime(SqlParser.TriggerActionTimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#overrideClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverrideClause(SqlParser.OverrideClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#specialValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialValue(SqlParser.SpecialValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(SqlParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(SqlParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#alterTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTableStatement(SqlParser.AlterTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropViewStatement(SqlParser.DropViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createViewStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateViewStatement(SqlParser.CreateViewStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumnDefinition}
	 * labeled alternative in {@link SqlParser#alterTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumnDefinition(SqlParser.AddColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropColumnDefinition}
	 * labeled alternative in {@link SqlParser#alterTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropColumnDefinition(SqlParser.DropColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alterColumnDefinition}
	 * labeled alternative in {@link SqlParser#alterTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnDefinition(SqlParser.AlterColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addTableConstraintDefinition}
	 * labeled alternative in {@link SqlParser#alterTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddTableConstraintDefinition(SqlParser.AddTableConstraintDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropTableConstraintDefinition}
	 * labeled alternative in {@link SqlParser#alterTableAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableConstraintDefinition(SqlParser.DropTableConstraintDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setColumnDefaultClause}
	 * labeled alternative in {@link SqlParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetColumnDefaultClause(SqlParser.SetColumnDefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropColumnDefaultClause}
	 * labeled alternative in {@link SqlParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropColumnDefaultClause(SqlParser.DropColumnDefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumnScopeClause}
	 * labeled alternative in {@link SqlParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumnScopeClause(SqlParser.AddColumnScopeClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropColumnScopeClause}
	 * labeled alternative in {@link SqlParser#alterColumnAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropColumnScopeClause(SqlParser.DropColumnScopeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableContents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableContents(SqlParser.TableContentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#subtableClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtableClause(SqlParser.SubtableClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElementList(SqlParser.TableElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableElement(SqlParser.TableElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#viewSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewSpecification(SqlParser.ViewSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#subviewClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubviewClause(SqlParser.SubviewClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#viewElementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewElementList(SqlParser.ViewElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#viewElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitViewElement(SqlParser.ViewElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(SqlParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableConstraintDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstraintDefinition(SqlParser.TableConstraintDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#likeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeClause(SqlParser.LikeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#selfrefColumnSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfrefColumnSpecification(SqlParser.SelfrefColumnSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#columnOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnOptions(SqlParser.ColumnOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#defaultOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultOption(SqlParser.DefaultOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#generationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerationClause(SqlParser.GenerationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#columnConstraintDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraintDefinition(SqlParser.ColumnConstraintDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableConstraint(SqlParser.TableConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#constraintCharacteristics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintCharacteristics(SqlParser.ConstraintCharacteristicsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraint(SqlParser.ColumnConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referencesSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencesSpecification(SqlParser.ReferencesSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referentialTriggeredAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferentialTriggeredAction(SqlParser.ReferentialTriggeredActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#updateAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateAction(SqlParser.UpdateActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#deleteAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteAction(SqlParser.DeleteActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetType}
	 * labeled alternative in {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetType(SqlParser.MultisetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowType}
	 * labeled alternative in {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowType(SqlParser.RowTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(SqlParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preType}
	 * labeled alternative in {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreType(SqlParser.PreTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structType}
	 * labeled alternative in {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(SqlParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refType}
	 * labeled alternative in {@link SqlParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefType(SqlParser.RefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(SqlParser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#scopeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeDefinition(SqlParser.ScopeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#fieldDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDefinition(SqlParser.FieldDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#predefinedType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredefinedType(SqlParser.PredefinedTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#charType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(SqlParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#varcharType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharType(SqlParser.VarcharTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#clobType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClobType(SqlParser.ClobTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#ncharType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNcharType(SqlParser.NcharTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#nvarcharType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNvarcharType(SqlParser.NvarcharTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#nclobType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNclobType(SqlParser.NclobTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#xmlType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlType(SqlParser.XmlTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#binaryType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryType(SqlParser.BinaryTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#varbinaryType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarbinaryType(SqlParser.VarbinaryTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#blobType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlobType(SqlParser.BlobTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType(SqlParser.NumericTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#decimalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalType(SqlParser.DecimalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#smallintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallintType(SqlParser.SmallintTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#integerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerType(SqlParser.IntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#bigintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigintType(SqlParser.BigintTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#floatType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(SqlParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#realType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(SqlParser.RealTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#doubleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(SqlParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#booleanType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(SqlParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dateType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateType(SqlParser.DateTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#timeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeType(SqlParser.TimeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#timestampType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampType(SqlParser.TimestampTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#intervalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalType(SqlParser.IntervalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#intervalQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalQualifier(SqlParser.IntervalQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#lobLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLobLength(SqlParser.LobLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#secondsDecimals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondsDecimals(SqlParser.SecondsDecimalsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#precision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecision(SqlParser.PrecisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScale(SqlParser.ScaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#length}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(SqlParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#querySpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuerySpecification(SqlParser.QuerySpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(SqlParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#selectSublist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSublist(SqlParser.SelectSublistContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(SqlParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(SqlParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(SqlParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#havingClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavingClause(SqlParser.HavingClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowClause(SqlParser.WindowClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableReference(SqlParser.TableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#joinSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinSpecification(SqlParser.JoinSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tablePrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTablePrimary(SqlParser.TablePrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableAlias(SqlParser.TableAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#groupingElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingElement(SqlParser.GroupingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#ordinaryGroupingSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdinaryGroupingSet(SqlParser.OrdinaryGroupingSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#queryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpression(SqlParser.QueryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryExpressionBody(SqlParser.QueryExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableRowValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableRowValueExpression(SqlParser.TableRowValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#correspondingSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorrespondingSpecification(SqlParser.CorrespondingSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#withClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithClause(SqlParser.WithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#withElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithElement(SqlParser.WithElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#searchOrCycleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchOrCycleClause(SqlParser.SearchOrCycleClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#searchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchClause(SqlParser.SearchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#cycleClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCycleClause(SqlParser.CycleClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpression(SqlParser.ValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#commonValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonValueExpression(SqlParser.CommonValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#numericValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericValueExpression(SqlParser.NumericValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lengthExpression}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthExpression(SqlParser.LengthExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positionExpression}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionExpression(SqlParser.PositionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extractExpression}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractExpression(SqlParser.ExtractExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cardinalityExpression}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinalityExpression(SqlParser.CardinalityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absoluteValueExpression}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteValueExpression(SqlParser.AbsoluteValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modulusExpression}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusExpression(SqlParser.ModulusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code naturalLogarithm}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturalLogarithm(SqlParser.NaturalLogarithmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exponentialFunction}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponentialFunction(SqlParser.ExponentialFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powerFunction}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerFunction(SqlParser.PowerFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code squareRoot}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareRoot(SqlParser.SquareRootContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floorFunction}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloorFunction(SqlParser.FloorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ceilingFunction}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCeilingFunction(SqlParser.CeilingFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code widthBucketFunction}
	 * labeled alternative in {@link SqlParser#numericValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidthBucketFunction(SqlParser.WidthBucketFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#extractField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractField(SqlParser.ExtractFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#widthBucketOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidthBucketOperand(SqlParser.WidthBucketOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#widthBucketBound1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidthBucketBound1(SqlParser.WidthBucketBound1Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#widthBucketBound2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidthBucketBound2(SqlParser.WidthBucketBound2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#widthBucketCount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWidthBucketCount(SqlParser.WidthBucketCountContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#stringValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValueExpression(SqlParser.StringValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#stringValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValueFunction(SqlParser.StringValueFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#startPosition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartPosition(SqlParser.StartPositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#stringLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLength(SqlParser.StringLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#datetimeValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeValueExpression(SqlParser.DatetimeValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#timeZone}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeZone(SqlParser.TimeZoneContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#intervalPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalPrimary(SqlParser.IntervalPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#datetimeValueFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeValueFunction(SqlParser.DatetimeValueFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#intervalValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalValueExpression(SqlParser.IntervalValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#udtValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdtValueExpression(SqlParser.UdtValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referenceValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceValueExpression(SqlParser.ReferenceValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#arrayValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValueExpression(SqlParser.ArrayValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#multisetValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetValueExpression(SqlParser.MultisetValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#booleanValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValueExpression(SqlParser.BooleanValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#booleanPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanPrimary(SqlParser.BooleanPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#comparisonCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonCondition(SqlParser.ComparisonConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#betweenCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenCondition(SqlParser.BetweenConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#inCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInCondition(SqlParser.InConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#likeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeCondition(SqlParser.LikeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#similarCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimilarCondition(SqlParser.SimilarConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#nullCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullCondition(SqlParser.NullConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#quantifiedComparisonCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedComparisonCondition(SqlParser.QuantifiedComparisonConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#matchCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchCondition(SqlParser.MatchConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#overlapsCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverlapsCondition(SqlParser.OverlapsConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#distinctCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistinctCondition(SqlParser.DistinctConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#memberCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberCondition(SqlParser.MemberConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#submultisetCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubmultisetCondition(SqlParser.SubmultisetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#setCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCondition(SqlParser.SetConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#typeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCondition(SqlParser.TypeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#udtSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdtSpecification(SqlParser.UdtSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#rowValuePredicand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowValuePredicand(SqlParser.RowValuePredicandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#rowValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowValueExpression(SqlParser.RowValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unsignedLit}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedLit(SqlParser.UnsignedLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newSpec}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewSpec(SqlParser.NewSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castSpec}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastSpec(SqlParser.CastSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElementRefConcat}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElementRefConcat(SqlParser.ArrayElementRefConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvoc}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvoc(SqlParser.MethodInvocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scalarSubq}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarSubq(SqlParser.ScalarSubqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetElementRef}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetElementRef(SqlParser.MultisetElementRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeOrMethodRef}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeOrMethodRef(SqlParser.AttributeOrMethodRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code generalValueSpec}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralValueSpec(SqlParser.GeneralValueSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code windowFunc}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunc(SqlParser.WindowFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subtypeTreat}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtypeTreat(SqlParser.SubtypeTreatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code aggregateFunc}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunc(SqlParser.AggregateFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code generalizedMethodInvoc}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralizedMethodInvoc(SqlParser.GeneralizedMethodInvocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code routineInvoc}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineInvoc(SqlParser.RoutineInvocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayValueConstruct}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValueConstruct(SqlParser.ArrayValueConstructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nextValueExp}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextValueExp(SqlParser.NextValueExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multisetValueConstruct}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetValueConstruct(SqlParser.MultisetValueConstructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpressionPrimaryParen}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpressionPrimaryParen(SqlParser.ValueExpressionPrimaryParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticMethodInvoc}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticMethodInvoc(SqlParser.StaticMethodInvocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElementRef}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElementRef(SqlParser.ArrayElementRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referenceRes}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceRes(SqlParser.ReferenceResContext ctx);
	/**
	 * Visit a parse tree produced by the {@code caseExp}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExp(SqlParser.CaseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupingOp}
	 * labeled alternative in {@link SqlParser#valueExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingOp(SqlParser.GroupingOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(SqlParser.AggregateFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#rankFunctionArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRankFunctionArgumentList(SqlParser.RankFunctionArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dependentVariableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependentVariableExpression(SqlParser.DependentVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#independentVariableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndependentVariableExpression(SqlParser.IndependentVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#withinGroupSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithinGroupSpecification(SqlParser.WithinGroupSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sortSpecificationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortSpecificationList(SqlParser.SortSpecificationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sortSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortSpecification(SqlParser.SortSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#filterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterClause(SqlParser.FilterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#groupingOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingOperation(SqlParser.GroupingOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunction(SqlParser.WindowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFunctionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFunctionType(SqlParser.WindowFunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowDefinition(SqlParser.WindowDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowSpecification(SqlParser.WindowSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowPartitionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowPartitionClause(SqlParser.WindowPartitionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowOrderClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowOrderClause(SqlParser.WindowOrderClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameClause(SqlParser.WindowFrameClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameStart(SqlParser.WindowFrameStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameBetween(SqlParser.WindowFrameBetweenContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameBound1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameBound1(SqlParser.WindowFrameBound1Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameBound2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameBound2(SqlParser.WindowFrameBound2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#windowFrameBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWindowFrameBound(SqlParser.WindowFrameBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#scalarSubquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarSubquery(SqlParser.ScalarSubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#caseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpression(SqlParser.CaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#simpleWhenClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleWhenClause(SqlParser.SimpleWhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#searchedWhenClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchedWhenClause(SqlParser.SearchedWhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(SqlParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#whenOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenOperand(SqlParser.WhenOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastSpecification(SqlParser.CastSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastOperand(SqlParser.CastOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#subtypeTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtypeTreatment(SqlParser.SubtypeTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#generalizedInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralizedInvocation(SqlParser.GeneralizedInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlArgumentList(SqlParser.SqlArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlArgument(SqlParser.SqlArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#generalizedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralizedExpression(SqlParser.GeneralizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#targetSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTargetSpecification(SqlParser.TargetSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#simpleTargetSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTargetSpecification(SqlParser.SimpleTargetSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#staticMethodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticMethodInvocation(SqlParser.StaticMethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#newSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewSpecification(SqlParser.NewSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#routineInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineInvocation(SqlParser.RoutineInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referenceResolution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceResolution(SqlParser.ReferenceResolutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#arrayValueConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValueConstructor(SqlParser.ArrayValueConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#multisetValueConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetValueConstructor(SqlParser.MultisetValueConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#multisetElementReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultisetElementReference(SqlParser.MultisetElementReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#nextValueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNextValueExpression(SqlParser.NextValueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#unsignedValueSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedValueSpecification(SqlParser.UnsignedValueSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#generalValueSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralValueSpecification(SqlParser.GeneralValueSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(SqlParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#indicatorVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndicatorVariable(SqlParser.IndicatorVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#simpleValueSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleValueSpecification(SqlParser.SimpleValueSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#unsignedLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedLiteral(SqlParser.UnsignedLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#unsignedNumericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumericLiteral(SqlParser.UnsignedNumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#exactNumericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExactNumericLiteral(SqlParser.ExactNumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#generalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralLiteral(SqlParser.GeneralLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#intervalLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalLiteral(SqlParser.IntervalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTypeStatement(SqlParser.DropTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTypeStatement(SqlParser.CreateTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#alterTypeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterTypeStatement(SqlParser.AlterTypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addAttributeDefinition}
	 * labeled alternative in {@link SqlParser#alterTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddAttributeDefinition(SqlParser.AddAttributeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropAttributeDefinition}
	 * labeled alternative in {@link SqlParser#alterTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropAttributeDefinition(SqlParser.DropAttributeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addMethodSpecification}
	 * labeled alternative in {@link SqlParser#alterTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddMethodSpecification(SqlParser.AddMethodSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropMethodSpecification}
	 * labeled alternative in {@link SqlParser#alterTypeAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMethodSpecification(SqlParser.DropMethodSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#methodDesignator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDesignator(SqlParser.MethodDesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#subTypeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubTypeClause(SqlParser.SubTypeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#attributeDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDefinitions(SqlParser.AttributeDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#attributeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDefinition(SqlParser.AttributeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#udtOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdtOptions(SqlParser.UdtOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#udtOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUdtOption(SqlParser.UdtOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#referenceTypeSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceTypeSpecification(SqlParser.ReferenceTypeSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#userDefinedRepresentation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserDefinedRepresentation(SqlParser.UserDefinedRepresentationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#derivedRepresentation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerivedRepresentation(SqlParser.DerivedRepresentationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#systemGeneratedRepresentation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystemGeneratedRepresentation(SqlParser.SystemGeneratedRepresentationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#refCastOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefCastOption(SqlParser.RefCastOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castToRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastToRef(SqlParser.CastToRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castToType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastToType(SqlParser.CastToTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastOption(SqlParser.CastOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castToDistinct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastToDistinct(SqlParser.CastToDistinctContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#castToSource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastToSource(SqlParser.CastToSourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropProcedureStatement(SqlParser.DropProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropFunctionStatement(SqlParser.DropFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropMethodStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropMethodStatement(SqlParser.DropMethodStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#dropTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTriggerStatement(SqlParser.DropTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createProcedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateProcedureStatement(SqlParser.CreateProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createFunctionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateFunctionStatement(SqlParser.CreateFunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createMethodStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateMethodStatement(SqlParser.CreateMethodStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#createTriggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTriggerStatement(SqlParser.CreateTriggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#methodSpecifications}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSpecifications(SqlParser.MethodSpecificationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#methodSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSpecification(SqlParser.MethodSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#originalMethodSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOriginalMethodSpecification(SqlParser.OriginalMethodSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#overridingMethodSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverridingMethodSpecification(SqlParser.OverridingMethodSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#partialMethodSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartialMethodSpecification(SqlParser.PartialMethodSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#triggerEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerEvent(SqlParser.TriggerEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#oldOrNewValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldOrNewValue(SqlParser.OldOrNewValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#triggeredAction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggeredAction(SqlParser.TriggeredActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlParameterDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlParameterDeclarations(SqlParser.SqlParameterDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sqlParameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqlParameterDeclaration(SqlParser.SqlParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterType(SqlParser.ParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#returnsClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnsClause(SqlParser.ReturnsClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#returnsType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnsType(SqlParser.ReturnsTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#returnsDataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnsDataType(SqlParser.ReturnsDataTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#resultCast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultCast(SqlParser.ResultCastContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#returnsTableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnsTableType(SqlParser.ReturnsTableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableColumns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableColumns(SqlParser.TableColumnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tableColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableColumn(SqlParser.TableColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#routineCharacteristics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineCharacteristics(SqlParser.RoutineCharacteristicsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#routineCharacteristic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineCharacteristic(SqlParser.RoutineCharacteristicContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#routineBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutineBody(SqlParser.RoutineBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#insertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStatement(SqlParser.InsertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#fromConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromConstructor(SqlParser.FromConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#fromSubquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromSubquery(SqlParser.FromSubqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#insertColumnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertColumnList(SqlParser.InsertColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#fromDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromDefault(SqlParser.FromDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#deleteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStatement(SqlParser.DeleteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(SqlParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#setClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetClause(SqlParser.SetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#setTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetTarget(SqlParser.SetTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#updateTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateTarget(SqlParser.UpdateTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#updateSource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSource(SqlParser.UpdateSourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#assignedRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignedRow(SqlParser.AssignedRowContext ctx);
}