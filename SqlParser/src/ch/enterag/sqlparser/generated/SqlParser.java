// Generated from Sql.g4 by ANTLR 4.5.2
package ch.enterag.sqlparser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN_LITERAL=1, TIMESTAMP_LITERAL=2, TIME_LITERAL=3, DATE_LITERAL=4, 
		BYTE_STRING_LITERAL=5, BIT_STRING_LITERAL=6, NATIONAL_CHARACTER_STRING_LITERAL=7, 
		A=8, ABS=9, ACTION=10, ADD=11, AFTER=12, ALL=13, ALLOCATE=14, ALTER=15, 
		ALWAYS=16, AND=17, ANY=18, ARE=19, ARRAY=20, AS=21, ASC=22, ASENSITIVE=23, 
		ASYMMETRIC=24, AT=25, ATOMIC=26, AUTHORIZATION=27, AVG=28, BEFORE=29, 
		BEGIN=30, BERNOULLI=31, BETWEEN=32, BIGINT=33, BINARY=34, BLOB=35, BOOLEAN=36, 
		BOTH=37, BY=38, CALL=39, CALLED=40, CARDINALITY=41, CASCADE=42, CASCADED=43, 
		CASE=44, CAST=45, CEIL=46, CEILING=47, CHAR=48, CHARACTER=49, CHARACTER_LENGTH=50, 
		CHAR_LENGTH=51, CHECK=52, CHECKED=53, CLOB=54, CLOSE=55, COALESCE=56, 
		COLLATE=57, COLLECT=58, COLUMN=59, COMMIT=60, CONNECT=61, CONSTRAINT=62, 
		CONTINUE=63, CORRESPONDING=64, COVAR_POP=65, COVAR_SAMP=66, COUNT=67, 
		CREATE=68, CROSS=69, CUBE=70, CUME_DIST=71, CURRENT=72, CURRENT_DATE=73, 
		CURRENT_DEFAULT_TRANSFORM_GROUP=74, CURRENT_PATH=75, CURRENT_ROLE=76, 
		CURRENT_TIME=77, CURRENT_TIMESTAMP=78, CURRENT_TRANSFORM_GROUP_FOR_TYPE=79, 
		CURRENT_USER=80, CURSOR=81, CYCLE=82, DATA=83, DATE=84, DAY=85, DEALLOCATE=86, 
		DEC=87, DECIMAL=88, DECLARE=89, DEFAULT=90, DEFERRABLE=91, DEFERRED=92, 
		DELETE=93, DENSE_RANK=94, DEREF=95, DERIVED=96, DESC=97, DESCRIBE=98, 
		DETERMINISTIC=99, DISCONNECT=100, DISTINCT=101, DOUBLE=102, DROP=103, 
		DYNAMIC=104, EACH=105, ELEMENT=106, ELSE=107, END=108, END_EXEC=109, ESCAPE=110, 
		EVERY=111, EXCEPT=112, EXCLUDING=113, EXEC=114, EXECUTE=115, EXISTS=116, 
		EXP=117, EXTERNAL=118, EXTRACT=119, FALSE=120, FETCH=121, FILTER=122, 
		FINAL=123, FLOAT=124, FLOOR=125, FOLLOWING=126, FOR=127, FOREIGN=128, 
		FREE=129, FROM=130, FULL=131, FUNCTION=132, FUSION=133, G=134, GENERATED=135, 
		GET=136, GLOBAL=137, GRANT=138, GROUP=139, GROUPING=140, HAVING=141, HOLD=142, 
		HOUR=143, IDENTITY=144, IMMEDIATE=145, IN=146, INCLUDING=147, INDICATOR=148, 
		INITIALLY=149, INNER=150, INOUT=151, INPUT=152, INSENSITIVE=153, INSERT=154, 
		INSTANCE=155, INSTANTIABLE=156, INT=157, INTEGER=158, INTERSECT=159, INTERSECTION=160, 
		INTERVAL=161, INTO=162, IS=163, ISOLATION=164, JOIN=165, K=166, KEY=167, 
		LANGUAGE=168, LARGE=169, LATERAL=170, LEADING=171, LEFT=172, LIKE=173, 
		LN=174, LOCAL=175, LOCALTIME=176, LOCALTIMESTAMP=177, LOWER=178, M=179, 
		MATCH=180, MAX=181, MEMBER=182, MERGE=183, METHOD=184, MIN=185, MINUTE=186, 
		MOD=187, MODIFIES=188, MODULE=189, MONTH=190, MULTISET=191, NATIONAL=192, 
		NATURAL=193, NCHAR=194, NCLOB=195, NEW=196, NEXT=197, NO=198, NONE=199, 
		NORMALIZE=200, NORMALIZED=201, NOT=202, NULL=203, NULLIF=204, NUMERIC=205, 
		OBJECT=206, OCTET_LENGTH=207, OF=208, OLD=209, ON=210, ONLY=211, OPEN=212, 
		OPTION=213, OPTIONS=214, OR=215, ORDER=216, ORDINALITY=217, OUT=218, OUTER=219, 
		OUTPUT=220, OVER=221, OVERLAPS=222, OVERRIDING=223, PARAMETER=224, PARTITION=225, 
		PERCENT_RANK=226, PERCENTILE_CONT=227, PERCENTILE_DISC=228, POWER=229, 
		PRECEDING=230, PRECISION=231, PREPARE=232, PRIMARY=233, PROCEDURE=234, 
		RANGE=235, RANK=236, READS=237, REAL=238, RECURSIVE=239, REF=240, REFERENCES=241, 
		REFERENCING=242, REGR_AVGX=243, REGR_AVGY=244, REGR_COUNT=245, REGR_INTERCEPT=246, 
		REGR_RSQUARED=247, REGR_SLOPE=248, REGR_SXX=249, REGR_SXY=250, REGR_SYY=251, 
		RELEASE=252, REPEATABLE=253, RESTRICT=254, RESULT=255, RETURN=256, RETURNS=257, 
		REVOKE=258, RIGHT=259, ROLLBACK=260, ROLLUP=261, ROW=262, ROW_NUMBER=263, 
		ROWS=264, SAVEPOINT=265, SCHEMA=266, SCOPE=267, SCROLL=268, SEARCH=269, 
		SECOND=270, SELECT=271, SENSITIVE=272, SESSION_USER=273, SET=274, SIMILAR=275, 
		SIMPLE=276, SMALLINT=277, SOME=278, SPECIFIC=279, SPECIFICTYPE=280, SQL=281, 
		SQLEXCEPTION=282, SQLSTATE=283, SQLWARNING=284, SQRT=285, START=286, STATIC=287, 
		STDDEV_POP=288, STDDEV_SAMP=289, STYLE=290, SUBMULTISET=291, SUBSTRING=292, 
		SUM=293, SYMMETRIC=294, SYSTEM=295, SYSTEM_USER=296, TABLE=297, TABLESAMPLE=298, 
		TEMPORARY=299, THEN=300, TIME=301, TIMESTAMP=302, TIMEZONE_HOUR=303, TIMEZONE_MINUTE=304, 
		TO=305, TRAILING=306, TRANSLATION=307, TREAT=308, TRIGGER=309, TRIM=310, 
		TRUE=311, TYPE=312, UESCAPE=313, UNBOUNDED=314, UNDER=315, UNION=316, 
		UNIQUE=317, UNKNOWN=318, UNNEST=319, UPDATE=320, UPPER=321, USER=322, 
		USING=323, VALUE=324, VALUES=325, VAR_POP=326, VAR_SAMP=327, VARBINARY=328, 
		VARCHAR=329, VARYING=330, VIEW=331, WHEN=332, WHENEVER=333, WHERE=334, 
		WIDTH_BUCKET=335, WINDOW=336, WITH=337, WITHIN=338, WITHOUT=339, XML=340, 
		YEAR=341, ZONE=342, IDENTIFIER=343, ABSOLUTE=344, ADA=345, ADMIN=346, 
		ASSERTION=347, ASSIGNMENT=348, ATTRIBUTE=349, ATTRIBUTES=350, BREADTH=351, 
		C=352, CATALOG=353, CATALOG_NAME=354, CHAIN=355, CHARACTERISTICS=356, 
		CHARACTERS=357, CHARACTER_SET_CATALOG=358, CHARACTER_SET_NAME=359, CHARACTER_SET_SCHEMA=360, 
		CLASS_ORIGIN=361, COBOL=362, CODE_UNITS=363, COLLATION=364, COLLATION_CATALOG=365, 
		COLLATION_NAME=366, COLLATION_SCHEMA=367, COLUMN_NAME=368, COMMAND_FUNCTION=369, 
		COMMAND_FUNCTION_CODE=370, COMMITTED=371, CONDITION=372, CONDITION_NUMBER=373, 
		CONNECTION_NAME=374, CONSTRAINTS=375, CONSTRAINT_CATALOG=376, CONSTRAINT_NAME=377, 
		CONSTRAINT_SCHEMA=378, CONSTRUCTOR=379, CONSTRUCTORS=380, CONTAINS=381, 
		CONVERT=382, CORR=383, CURRENT_COLLATION=384, CURSOR_NAME=385, DATETIME_INTERVAL_CODE=386, 
		DATETIME_INTERVAL_PRECISION=387, DEFAULTS=388, DEFINED=389, DEFINER=390, 
		DEGREE=391, DEPTH=392, DESCRIPTOR=393, DIAGNOSTICS=394, DISPATCH=395, 
		DOMAIN=396, DYNAMIC_FUNCTION=397, DYNAMIC_FUNCTION_CODE=398, EQUALS=399, 
		EXCEPTION=400, EXCLUDE=401, FIRST=402, FORTRAN=403, FOUND=404, GENERAL=405, 
		GO=406, GOTO=407, GRANTED=408, HIERARCHY=409, IMPLEMENTATION=410, INCREMENT=411, 
		INVOKER=412, KEY_MEMBER=413, KEY_TYPE=414, LAST=415, LENGTH=416, LEVEL=417, 
		LOCATOR=418, MAP=419, MATCHED=420, MAXVALUE=421, MESSAGE_LENGTH=422, MESSAGE_OCTET_LENGTH=423, 
		MESSAGE_TEXT=424, MINVALUE=425, MORE_=426, MUMPS=427, NAME=428, NAMES=429, 
		NESTING=430, NULLABLE=431, NULLS=432, NUMBER=433, OCTETS=434, ORDERING=435, 
		OTHERS=436, OVERLAY=437, PAD=438, PARAMETER_MODE=439, PARAMETER_NAME=440, 
		PARAMETER_ORDINAL_POSITION=441, PARAMETER_SPECIFIC_CATALOG=442, PARAMETER_SPECIFIC_NAME=443, 
		PARAMETER_SPECIFIC_SCHEMA=444, PARTIAL=445, PASCAL=446, PATH=447, PLACING=448, 
		PLI=449, POSITION=450, PRESERVE=451, PRIOR=452, PRIVILEGES=453, PUBLIC=454, 
		READ=455, RELATIVE=456, RESTART=457, RETURNED_CARDINALITY=458, RETURNED_LENGTH=459, 
		RETURNED_OCTET_LENGTH=460, RETURNED_SQLSTATE=461, ROLE=462, ROUTINE=463, 
		ROUTINE_CATALOG=464, ROUTINE_NAME=465, ROUTINE_SCHEMA=466, ROW_COUNT=467, 
		SCALE=468, SCHEMA_NAME=469, SCOPE_CATALOG=470, SCOPE_NAME=471, SCOPE_SCHEMA=472, 
		SECTION=473, SECURITY=474, SELF=475, SEQUENCE=476, SERIALIZABLE=477, SERVER_NAME=478, 
		SESSION=479, SETS=480, SIZE=481, SOURCE=482, SPACE=483, SPECIFIC_NAME=484, 
		STATE=485, STATEMENT=486, STRUCTURE=487, SUBCLASS_ORIGIN=488, TABLE_NAME=489, 
		TIES=490, TOP_LEVEL_COUNT=491, TRANSACTION=492, TRANSACTIONS_COMMITTED=493, 
		TRANSACTIONS_ROLLED_BACK=494, TRANSACTION_ACTIVE=495, TRANSFORM=496, TRANSFORMS=497, 
		TRANSLATE=498, TRIGGER_CATALOG=499, TRIGGER_NAME=500, TRIGGER_SCHEMA=501, 
		UNCOMMITTED=502, UNNAMED=503, USAGE=504, USER_DEFINED_TYPE_CATALOG=505, 
		USER_DEFINED_TYPE_CODE=506, USER_DEFINED_TYPE_NAME=507, USER_DEFINED_TYPE_SCHEMA=508, 
		WORK=509, WRITE=510, NON_RESERVED_KEYWORD=511, UNSIGNED_APPROXIMATE=512, 
		UNSIGNED_INTEGER=513, CHARACTER_STRING_LITERAL=514, DELIMITED_IDENTIFIER=515, 
		REGULAR_IDENTIFIER=516, HEX_CHAR=517, BYTE=518, BIT=519, B=520, D=521, 
		E=522, F=523, H=524, I=525, J=526, L=527, N=528, O=529, P=530, Q=531, 
		R=532, S=533, T=534, U=535, V=536, W=537, X=538, Y=539, Z=540, SIMPLE_COMMENT=541, 
		BRACKETED_COMMENT=542, WS=543, DEREFERENCE_OPERATOR=544, NOT_EQUALS_OPERATOR=545, 
		GREATER_THAN_OR_EQUALS_OPERATOR=546, LESS_THAN_OR_EQUALS_OPERATOR=547, 
		CONCATENATION_OPERATOR=548, DUPLICATED_DOUBLE_QUOTE=549, DUPLICATED_QUOTE=550, 
		DOUBLE_COLON=551, DOUBLE_QUOTE=552, PERCENT=553, AMPERSAND=554, QUOTE=555, 
		LEFT_PAREN=556, RIGHT_PAREN=557, ASTERISK=558, PLUS_SIGN=559, COMMA=560, 
		MINUS_SIGN=561, PERIOD=562, SOLIDUS=563, COLON=564, SEMICOLON=565, LESS_THAN_OPERATOR=566, 
		EQUALS_OPERATOR=567, GREATER_THAN_OPERATOR=568, QUESTION_MARK=569, LEFT_BRACKET=570, 
		RIGHT_BRACKET=571, CIRCUMFLEX=572, UNDERSCORE=573, VERTICAL_BAR=574, LEFT_BRACE=575, 
		RIGHT_BRACE=576, DIGIT=577, ZERO=578, ONE=579, TWO=580, THREE=581, FOUR=582, 
		FIVE=583, SIX=584, SEVEN=585, EIGHT=586, NINE=587, NON_DOUBLE_QUOTE=588, 
		NON_QUOTE=589, LETTER=590;
	public static final int
		RULE_sqlStatement = 0, RULE_ddlStatement = 1, RULE_dmlStatement = 2, RULE_dropSchemaStatement = 3, 
		RULE_createSchemaStatement = 4, RULE_userName = 5, RULE_roleName = 6, 
		RULE_authorizationName = 7, RULE_fieldName = 8, RULE_columnName = 9, RULE_attributeName = 10, 
		RULE_castIdentifier = 11, RULE_parameterName = 12, RULE_queryName = 13, 
		RULE_correlationName = 14, RULE_windowName = 15, RULE_catalogName = 16, 
		RULE_methodName = 17, RULE_variableName = 18, RULE_schemaName = 19, RULE_qualifiedId = 20, 
		RULE_identifierChain = 21, RULE_tableName = 22, RULE_constraintName = 23, 
		RULE_udtName = 24, RULE_specificMethodName = 25, RULE_routineName = 26, 
		RULE_triggerName = 27, RULE_sequenceName = 28, RULE_columnReference = 29, 
		RULE_targetArrayReference = 30, RULE_arrayReference = 31, RULE_dropBehavior = 32, 
		RULE_commitAction = 33, RULE_defaultsOption = 34, RULE_identityOption = 35, 
		RULE_match = 36, RULE_referenceGeneration = 37, RULE_referenceScopeCheck = 38, 
		RULE_referentialAction = 39, RULE_tableScope = 40, RULE_instantiability = 41, 
		RULE_finality = 42, RULE_parameterMode = 43, RULE_languageName = 44, RULE_parameterStyle = 45, 
		RULE_nullCallClause = 46, RULE_deterministic = 47, RULE_dataAccess = 48, 
		RULE_methodType = 49, RULE_symmetricOption = 50, RULE_quantifier = 51, 
		RULE_setQuantifier = 52, RULE_sampleMethod = 53, RULE_joinType = 54, RULE_orderingSpecification = 55, 
		RULE_nullOrdering = 56, RULE_rankFunction = 57, RULE_setFunction = 58, 
		RULE_binarySetFunction = 59, RULE_inverseDistributionFunction = 60, RULE_windowFrameUnits = 61, 
		RULE_windowFrameExclusion = 62, RULE_multiplicativeOperator = 63, RULE_additiveOperator = 64, 
		RULE_booleanOperator = 65, RULE_timeZoneField = 66, RULE_multiplier = 67, 
		RULE_withOrWithoutTimeZone = 68, RULE_multisetOperator = 69, RULE_queryOperator = 70, 
		RULE_primaryDatetimeField = 71, RULE_compOp = 72, RULE_sign = 73, RULE_withOrWithoutData = 74, 
		RULE_constraintCheckTime = 75, RULE_deferrability = 76, RULE_levels = 77, 
		RULE_triggerActionTime = 78, RULE_overrideClause = 79, RULE_specialValue = 80, 
		RULE_dropTableStatement = 81, RULE_createTableStatement = 82, RULE_alterTableStatement = 83, 
		RULE_dropViewStatement = 84, RULE_createViewStatement = 85, RULE_alterTableAction = 86, 
		RULE_alterColumnAction = 87, RULE_tableContents = 88, RULE_subtableClause = 89, 
		RULE_tableElementList = 90, RULE_tableElement = 91, RULE_viewSpecification = 92, 
		RULE_subviewClause = 93, RULE_viewElementList = 94, RULE_viewElement = 95, 
		RULE_columnDefinition = 96, RULE_tableConstraintDefinition = 97, RULE_likeClause = 98, 
		RULE_selfrefColumnSpecification = 99, RULE_columnOptions = 100, RULE_defaultOption = 101, 
		RULE_generationClause = 102, RULE_columnConstraintDefinition = 103, RULE_tableConstraint = 104, 
		RULE_constraintCharacteristics = 105, RULE_columnConstraint = 106, RULE_referencesSpecification = 107, 
		RULE_referentialTriggeredAction = 108, RULE_updateAction = 109, RULE_deleteAction = 110, 
		RULE_dataType = 111, RULE_referenceType = 112, RULE_scopeDefinition = 113, 
		RULE_fieldDefinition = 114, RULE_predefinedType = 115, RULE_charType = 116, 
		RULE_varcharType = 117, RULE_clobType = 118, RULE_ncharType = 119, RULE_nvarcharType = 120, 
		RULE_nclobType = 121, RULE_xmlType = 122, RULE_binaryType = 123, RULE_varbinaryType = 124, 
		RULE_blobType = 125, RULE_numericType = 126, RULE_decimalType = 127, RULE_smallintType = 128, 
		RULE_integerType = 129, RULE_bigintType = 130, RULE_floatType = 131, RULE_realType = 132, 
		RULE_doubleType = 133, RULE_booleanType = 134, RULE_dateType = 135, RULE_timeType = 136, 
		RULE_timestampType = 137, RULE_intervalType = 138, RULE_intervalQualifier = 139, 
		RULE_lobLength = 140, RULE_secondsDecimals = 141, RULE_precision = 142, 
		RULE_scale = 143, RULE_length = 144, RULE_querySpecification = 145, RULE_selectList = 146, 
		RULE_selectSublist = 147, RULE_fromClause = 148, RULE_whereClause = 149, 
		RULE_groupByClause = 150, RULE_havingClause = 151, RULE_windowClause = 152, 
		RULE_tableReference = 153, RULE_joinSpecification = 154, RULE_tablePrimary = 155, 
		RULE_tableAlias = 156, RULE_groupingElement = 157, RULE_ordinaryGroupingSet = 158, 
		RULE_queryExpression = 159, RULE_queryExpressionBody = 160, RULE_tableRowValueExpression = 161, 
		RULE_correspondingSpecification = 162, RULE_withClause = 163, RULE_withElement = 164, 
		RULE_searchOrCycleClause = 165, RULE_searchClause = 166, RULE_cycleClause = 167, 
		RULE_valueExpression = 168, RULE_commonValueExpression = 169, RULE_numericValueExpression = 170, 
		RULE_numericValueFunction = 171, RULE_extractField = 172, RULE_widthBucketOperand = 173, 
		RULE_widthBucketBound1 = 174, RULE_widthBucketBound2 = 175, RULE_widthBucketCount = 176, 
		RULE_stringValueExpression = 177, RULE_stringValueFunction = 178, RULE_startPosition = 179, 
		RULE_stringLength = 180, RULE_datetimeValueExpression = 181, RULE_timeZone = 182, 
		RULE_intervalPrimary = 183, RULE_datetimeValueFunction = 184, RULE_intervalValueExpression = 185, 
		RULE_udtValueExpression = 186, RULE_referenceValueExpression = 187, RULE_arrayValueExpression = 188, 
		RULE_multisetValueExpression = 189, RULE_booleanValueExpression = 190, 
		RULE_booleanPrimary = 191, RULE_comparisonCondition = 192, RULE_betweenCondition = 193, 
		RULE_inCondition = 194, RULE_likeCondition = 195, RULE_similarCondition = 196, 
		RULE_nullCondition = 197, RULE_quantifiedComparisonCondition = 198, RULE_matchCondition = 199, 
		RULE_overlapsCondition = 200, RULE_distinctCondition = 201, RULE_memberCondition = 202, 
		RULE_submultisetCondition = 203, RULE_setCondition = 204, RULE_typeCondition = 205, 
		RULE_udtSpecification = 206, RULE_rowValuePredicand = 207, RULE_rowValueExpression = 208, 
		RULE_valueExpressionPrimary = 209, RULE_aggregateFunction = 210, RULE_rankFunctionArgumentList = 211, 
		RULE_dependentVariableExpression = 212, RULE_independentVariableExpression = 213, 
		RULE_withinGroupSpecification = 214, RULE_sortSpecificationList = 215, 
		RULE_sortSpecification = 216, RULE_filterClause = 217, RULE_groupingOperation = 218, 
		RULE_windowFunction = 219, RULE_windowFunctionType = 220, RULE_windowDefinition = 221, 
		RULE_windowSpecification = 222, RULE_windowPartitionClause = 223, RULE_windowOrderClause = 224, 
		RULE_windowFrameClause = 225, RULE_windowFrameStart = 226, RULE_windowFrameBetween = 227, 
		RULE_windowFrameBound1 = 228, RULE_windowFrameBound2 = 229, RULE_windowFrameBound = 230, 
		RULE_scalarSubquery = 231, RULE_caseExpression = 232, RULE_simpleWhenClause = 233, 
		RULE_searchedWhenClause = 234, RULE_result = 235, RULE_whenOperand = 236, 
		RULE_castSpecification = 237, RULE_castOperand = 238, RULE_subtypeTreatment = 239, 
		RULE_generalizedInvocation = 240, RULE_sqlArgumentList = 241, RULE_sqlArgument = 242, 
		RULE_generalizedExpression = 243, RULE_targetSpecification = 244, RULE_simpleTargetSpecification = 245, 
		RULE_staticMethodInvocation = 246, RULE_newSpecification = 247, RULE_routineInvocation = 248, 
		RULE_referenceResolution = 249, RULE_arrayValueConstructor = 250, RULE_multisetValueConstructor = 251, 
		RULE_multisetElementReference = 252, RULE_nextValueExpression = 253, RULE_unsignedValueSpecification = 254, 
		RULE_generalValueSpecification = 255, RULE_reference = 256, RULE_indicatorVariable = 257, 
		RULE_simpleValueSpecification = 258, RULE_literal = 259, RULE_unsignedLiteral = 260, 
		RULE_unsignedNumericLiteral = 261, RULE_exactNumericLiteral = 262, RULE_generalLiteral = 263, 
		RULE_intervalLiteral = 264, RULE_dropTypeStatement = 265, RULE_createTypeStatement = 266, 
		RULE_alterTypeStatement = 267, RULE_alterTypeAction = 268, RULE_methodDesignator = 269, 
		RULE_subTypeClause = 270, RULE_attributeDefinitions = 271, RULE_attributeDefinition = 272, 
		RULE_udtOptions = 273, RULE_udtOption = 274, RULE_referenceTypeSpecification = 275, 
		RULE_userDefinedRepresentation = 276, RULE_derivedRepresentation = 277, 
		RULE_systemGeneratedRepresentation = 278, RULE_refCastOption = 279, RULE_castToRef = 280, 
		RULE_castToType = 281, RULE_castOption = 282, RULE_castToDistinct = 283, 
		RULE_castToSource = 284, RULE_dropProcedureStatement = 285, RULE_dropFunctionStatement = 286, 
		RULE_dropMethodStatement = 287, RULE_dropTriggerStatement = 288, RULE_createProcedureStatement = 289, 
		RULE_createFunctionStatement = 290, RULE_createMethodStatement = 291, 
		RULE_createTriggerStatement = 292, RULE_methodSpecifications = 293, RULE_methodSpecification = 294, 
		RULE_originalMethodSpecification = 295, RULE_overridingMethodSpecification = 296, 
		RULE_partialMethodSpecification = 297, RULE_triggerEvent = 298, RULE_oldOrNewValue = 299, 
		RULE_triggeredAction = 300, RULE_sqlParameterDeclarations = 301, RULE_sqlParameterDeclaration = 302, 
		RULE_parameterType = 303, RULE_returnsClause = 304, RULE_returnsType = 305, 
		RULE_returnsDataType = 306, RULE_resultCast = 307, RULE_returnsTableType = 308, 
		RULE_tableColumns = 309, RULE_tableColumn = 310, RULE_routineCharacteristics = 311, 
		RULE_routineCharacteristic = 312, RULE_routineBody = 313, RULE_insertStatement = 314, 
		RULE_fromConstructor = 315, RULE_fromSubquery = 316, RULE_insertColumnList = 317, 
		RULE_fromDefault = 318, RULE_deleteStatement = 319, RULE_updateStatement = 320, 
		RULE_setClause = 321, RULE_setTarget = 322, RULE_updateTarget = 323, RULE_updateSource = 324, 
		RULE_assignedRow = 325;
	public static final String[] ruleNames = {
		"sqlStatement", "ddlStatement", "dmlStatement", "dropSchemaStatement", 
		"createSchemaStatement", "userName", "roleName", "authorizationName", 
		"fieldName", "columnName", "attributeName", "castIdentifier", "parameterName", 
		"queryName", "correlationName", "windowName", "catalogName", "methodName", 
		"variableName", "schemaName", "qualifiedId", "identifierChain", "tableName", 
		"constraintName", "udtName", "specificMethodName", "routineName", "triggerName", 
		"sequenceName", "columnReference", "targetArrayReference", "arrayReference", 
		"dropBehavior", "commitAction", "defaultsOption", "identityOption", "match", 
		"referenceGeneration", "referenceScopeCheck", "referentialAction", "tableScope", 
		"instantiability", "finality", "parameterMode", "languageName", "parameterStyle", 
		"nullCallClause", "deterministic", "dataAccess", "methodType", "symmetricOption", 
		"quantifier", "setQuantifier", "sampleMethod", "joinType", "orderingSpecification", 
		"nullOrdering", "rankFunction", "setFunction", "binarySetFunction", "inverseDistributionFunction", 
		"windowFrameUnits", "windowFrameExclusion", "multiplicativeOperator", 
		"additiveOperator", "booleanOperator", "timeZoneField", "multiplier", 
		"withOrWithoutTimeZone", "multisetOperator", "queryOperator", "primaryDatetimeField", 
		"compOp", "sign", "withOrWithoutData", "constraintCheckTime", "deferrability", 
		"levels", "triggerActionTime", "overrideClause", "specialValue", "dropTableStatement", 
		"createTableStatement", "alterTableStatement", "dropViewStatement", "createViewStatement", 
		"alterTableAction", "alterColumnAction", "tableContents", "subtableClause", 
		"tableElementList", "tableElement", "viewSpecification", "subviewClause", 
		"viewElementList", "viewElement", "columnDefinition", "tableConstraintDefinition", 
		"likeClause", "selfrefColumnSpecification", "columnOptions", "defaultOption", 
		"generationClause", "columnConstraintDefinition", "tableConstraint", "constraintCharacteristics", 
		"columnConstraint", "referencesSpecification", "referentialTriggeredAction", 
		"updateAction", "deleteAction", "dataType", "referenceType", "scopeDefinition", 
		"fieldDefinition", "predefinedType", "charType", "varcharType", "clobType", 
		"ncharType", "nvarcharType", "nclobType", "xmlType", "binaryType", "varbinaryType", 
		"blobType", "numericType", "decimalType", "smallintType", "integerType", 
		"bigintType", "floatType", "realType", "doubleType", "booleanType", "dateType", 
		"timeType", "timestampType", "intervalType", "intervalQualifier", "lobLength", 
		"secondsDecimals", "precision", "scale", "length", "querySpecification", 
		"selectList", "selectSublist", "fromClause", "whereClause", "groupByClause", 
		"havingClause", "windowClause", "tableReference", "joinSpecification", 
		"tablePrimary", "tableAlias", "groupingElement", "ordinaryGroupingSet", 
		"queryExpression", "queryExpressionBody", "tableRowValueExpression", "correspondingSpecification", 
		"withClause", "withElement", "searchOrCycleClause", "searchClause", "cycleClause", 
		"valueExpression", "commonValueExpression", "numericValueExpression", 
		"numericValueFunction", "extractField", "widthBucketOperand", "widthBucketBound1", 
		"widthBucketBound2", "widthBucketCount", "stringValueExpression", "stringValueFunction", 
		"startPosition", "stringLength", "datetimeValueExpression", "timeZone", 
		"intervalPrimary", "datetimeValueFunction", "intervalValueExpression", 
		"udtValueExpression", "referenceValueExpression", "arrayValueExpression", 
		"multisetValueExpression", "booleanValueExpression", "booleanPrimary", 
		"comparisonCondition", "betweenCondition", "inCondition", "likeCondition", 
		"similarCondition", "nullCondition", "quantifiedComparisonCondition", 
		"matchCondition", "overlapsCondition", "distinctCondition", "memberCondition", 
		"submultisetCondition", "setCondition", "typeCondition", "udtSpecification", 
		"rowValuePredicand", "rowValueExpression", "valueExpressionPrimary", "aggregateFunction", 
		"rankFunctionArgumentList", "dependentVariableExpression", "independentVariableExpression", 
		"withinGroupSpecification", "sortSpecificationList", "sortSpecification", 
		"filterClause", "groupingOperation", "windowFunction", "windowFunctionType", 
		"windowDefinition", "windowSpecification", "windowPartitionClause", "windowOrderClause", 
		"windowFrameClause", "windowFrameStart", "windowFrameBetween", "windowFrameBound1", 
		"windowFrameBound2", "windowFrameBound", "scalarSubquery", "caseExpression", 
		"simpleWhenClause", "searchedWhenClause", "result", "whenOperand", "castSpecification", 
		"castOperand", "subtypeTreatment", "generalizedInvocation", "sqlArgumentList", 
		"sqlArgument", "generalizedExpression", "targetSpecification", "simpleTargetSpecification", 
		"staticMethodInvocation", "newSpecification", "routineInvocation", "referenceResolution", 
		"arrayValueConstructor", "multisetValueConstructor", "multisetElementReference", 
		"nextValueExpression", "unsignedValueSpecification", "generalValueSpecification", 
		"reference", "indicatorVariable", "simpleValueSpecification", "literal", 
		"unsignedLiteral", "unsignedNumericLiteral", "exactNumericLiteral", "generalLiteral", 
		"intervalLiteral", "dropTypeStatement", "createTypeStatement", "alterTypeStatement", 
		"alterTypeAction", "methodDesignator", "subTypeClause", "attributeDefinitions", 
		"attributeDefinition", "udtOptions", "udtOption", "referenceTypeSpecification", 
		"userDefinedRepresentation", "derivedRepresentation", "systemGeneratedRepresentation", 
		"refCastOption", "castToRef", "castToType", "castOption", "castToDistinct", 
		"castToSource", "dropProcedureStatement", "dropFunctionStatement", "dropMethodStatement", 
		"dropTriggerStatement", "createProcedureStatement", "createFunctionStatement", 
		"createMethodStatement", "createTriggerStatement", "methodSpecifications", 
		"methodSpecification", "originalMethodSpecification", "overridingMethodSpecification", 
		"partialMethodSpecification", "triggerEvent", "oldOrNewValue", "triggeredAction", 
		"sqlParameterDeclarations", "sqlParameterDeclaration", "parameterType", 
		"returnsClause", "returnsType", "returnsDataType", "resultCast", "returnsTableType", 
		"tableColumns", "tableColumn", "routineCharacteristics", "routineCharacteristic", 
		"routineBody", "insertStatement", "fromConstructor", "fromSubquery", "insertColumnList", 
		"fromDefault", "deleteStatement", "updateStatement", "setClause", "setTarget", 
		"updateTarget", "updateSource", "assignedRow"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "'\"\"'", "''''", 
		"'::'", "'\"'", "'%'", "'&'", "'''", "'('", "')'", "'*'", "'+'", "','", 
		"'-'", "'.'", "'/'", "':'", "';'", "'<'", "'='", "'>'", "'?'", "'['", 
		"']'", "'^'", "'_'", "'|'", null, null, null, "'0'", "'1'", "'2'", "'3'", 
		"'4'", "'5'", "'6'", "'7'", "'8'", "'9'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOLEAN_LITERAL", "TIMESTAMP_LITERAL", "TIME_LITERAL", "DATE_LITERAL", 
		"BYTE_STRING_LITERAL", "BIT_STRING_LITERAL", "NATIONAL_CHARACTER_STRING_LITERAL", 
		"A", "ABS", "ACTION", "ADD", "AFTER", "ALL", "ALLOCATE", "ALTER", "ALWAYS", 
		"AND", "ANY", "ARE", "ARRAY", "AS", "ASC", "ASENSITIVE", "ASYMMETRIC", 
		"AT", "ATOMIC", "AUTHORIZATION", "AVG", "BEFORE", "BEGIN", "BERNOULLI", 
		"BETWEEN", "BIGINT", "BINARY", "BLOB", "BOOLEAN", "BOTH", "BY", "CALL", 
		"CALLED", "CARDINALITY", "CASCADE", "CASCADED", "CASE", "CAST", "CEIL", 
		"CEILING", "CHAR", "CHARACTER", "CHARACTER_LENGTH", "CHAR_LENGTH", "CHECK", 
		"CHECKED", "CLOB", "CLOSE", "COALESCE", "COLLATE", "COLLECT", "COLUMN", 
		"COMMIT", "CONNECT", "CONSTRAINT", "CONTINUE", "CORRESPONDING", "COVAR_POP", 
		"COVAR_SAMP", "COUNT", "CREATE", "CROSS", "CUBE", "CUME_DIST", "CURRENT", 
		"CURRENT_DATE", "CURRENT_DEFAULT_TRANSFORM_GROUP", "CURRENT_PATH", "CURRENT_ROLE", 
		"CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_TRANSFORM_GROUP_FOR_TYPE", 
		"CURRENT_USER", "CURSOR", "CYCLE", "DATA", "DATE", "DAY", "DEALLOCATE", 
		"DEC", "DECIMAL", "DECLARE", "DEFAULT", "DEFERRABLE", "DEFERRED", "DELETE", 
		"DENSE_RANK", "DEREF", "DERIVED", "DESC", "DESCRIBE", "DETERMINISTIC", 
		"DISCONNECT", "DISTINCT", "DOUBLE", "DROP", "DYNAMIC", "EACH", "ELEMENT", 
		"ELSE", "END", "END_EXEC", "ESCAPE", "EVERY", "EXCEPT", "EXCLUDING", "EXEC", 
		"EXECUTE", "EXISTS", "EXP", "EXTERNAL", "EXTRACT", "FALSE", "FETCH", "FILTER", 
		"FINAL", "FLOAT", "FLOOR", "FOLLOWING", "FOR", "FOREIGN", "FREE", "FROM", 
		"FULL", "FUNCTION", "FUSION", "G", "GENERATED", "GET", "GLOBAL", "GRANT", 
		"GROUP", "GROUPING", "HAVING", "HOLD", "HOUR", "IDENTITY", "IMMEDIATE", 
		"IN", "INCLUDING", "INDICATOR", "INITIALLY", "INNER", "INOUT", "INPUT", 
		"INSENSITIVE", "INSERT", "INSTANCE", "INSTANTIABLE", "INT", "INTEGER", 
		"INTERSECT", "INTERSECTION", "INTERVAL", "INTO", "IS", "ISOLATION", "JOIN", 
		"K", "KEY", "LANGUAGE", "LARGE", "LATERAL", "LEADING", "LEFT", "LIKE", 
		"LN", "LOCAL", "LOCALTIME", "LOCALTIMESTAMP", "LOWER", "M", "MATCH", "MAX", 
		"MEMBER", "MERGE", "METHOD", "MIN", "MINUTE", "MOD", "MODIFIES", "MODULE", 
		"MONTH", "MULTISET", "NATIONAL", "NATURAL", "NCHAR", "NCLOB", "NEW", "NEXT", 
		"NO", "NONE", "NORMALIZE", "NORMALIZED", "NOT", "NULL", "NULLIF", "NUMERIC", 
		"OBJECT", "OCTET_LENGTH", "OF", "OLD", "ON", "ONLY", "OPEN", "OPTION", 
		"OPTIONS", "OR", "ORDER", "ORDINALITY", "OUT", "OUTER", "OUTPUT", "OVER", 
		"OVERLAPS", "OVERRIDING", "PARAMETER", "PARTITION", "PERCENT_RANK", "PERCENTILE_CONT", 
		"PERCENTILE_DISC", "POWER", "PRECEDING", "PRECISION", "PREPARE", "PRIMARY", 
		"PROCEDURE", "RANGE", "RANK", "READS", "REAL", "RECURSIVE", "REF", "REFERENCES", 
		"REFERENCING", "REGR_AVGX", "REGR_AVGY", "REGR_COUNT", "REGR_INTERCEPT", 
		"REGR_RSQUARED", "REGR_SLOPE", "REGR_SXX", "REGR_SXY", "REGR_SYY", "RELEASE", 
		"REPEATABLE", "RESTRICT", "RESULT", "RETURN", "RETURNS", "REVOKE", "RIGHT", 
		"ROLLBACK", "ROLLUP", "ROW", "ROW_NUMBER", "ROWS", "SAVEPOINT", "SCHEMA", 
		"SCOPE", "SCROLL", "SEARCH", "SECOND", "SELECT", "SENSITIVE", "SESSION_USER", 
		"SET", "SIMILAR", "SIMPLE", "SMALLINT", "SOME", "SPECIFIC", "SPECIFICTYPE", 
		"SQL", "SQLEXCEPTION", "SQLSTATE", "SQLWARNING", "SQRT", "START", "STATIC", 
		"STDDEV_POP", "STDDEV_SAMP", "STYLE", "SUBMULTISET", "SUBSTRING", "SUM", 
		"SYMMETRIC", "SYSTEM", "SYSTEM_USER", "TABLE", "TABLESAMPLE", "TEMPORARY", 
		"THEN", "TIME", "TIMESTAMP", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TO", 
		"TRAILING", "TRANSLATION", "TREAT", "TRIGGER", "TRIM", "TRUE", "TYPE", 
		"UESCAPE", "UNBOUNDED", "UNDER", "UNION", "UNIQUE", "UNKNOWN", "UNNEST", 
		"UPDATE", "UPPER", "USER", "USING", "VALUE", "VALUES", "VAR_POP", "VAR_SAMP", 
		"VARBINARY", "VARCHAR", "VARYING", "VIEW", "WHEN", "WHENEVER", "WHERE", 
		"WIDTH_BUCKET", "WINDOW", "WITH", "WITHIN", "WITHOUT", "XML", "YEAR", 
		"ZONE", "IDENTIFIER", "ABSOLUTE", "ADA", "ADMIN", "ASSERTION", "ASSIGNMENT", 
		"ATTRIBUTE", "ATTRIBUTES", "BREADTH", "C", "CATALOG", "CATALOG_NAME", 
		"CHAIN", "CHARACTERISTICS", "CHARACTERS", "CHARACTER_SET_CATALOG", "CHARACTER_SET_NAME", 
		"CHARACTER_SET_SCHEMA", "CLASS_ORIGIN", "COBOL", "CODE_UNITS", "COLLATION", 
		"COLLATION_CATALOG", "COLLATION_NAME", "COLLATION_SCHEMA", "COLUMN_NAME", 
		"COMMAND_FUNCTION", "COMMAND_FUNCTION_CODE", "COMMITTED", "CONDITION", 
		"CONDITION_NUMBER", "CONNECTION_NAME", "CONSTRAINTS", "CONSTRAINT_CATALOG", 
		"CONSTRAINT_NAME", "CONSTRAINT_SCHEMA", "CONSTRUCTOR", "CONSTRUCTORS", 
		"CONTAINS", "CONVERT", "CORR", "CURRENT_COLLATION", "CURSOR_NAME", "DATETIME_INTERVAL_CODE", 
		"DATETIME_INTERVAL_PRECISION", "DEFAULTS", "DEFINED", "DEFINER", "DEGREE", 
		"DEPTH", "DESCRIPTOR", "DIAGNOSTICS", "DISPATCH", "DOMAIN", "DYNAMIC_FUNCTION", 
		"DYNAMIC_FUNCTION_CODE", "EQUALS", "EXCEPTION", "EXCLUDE", "FIRST", "FORTRAN", 
		"FOUND", "GENERAL", "GO", "GOTO", "GRANTED", "HIERARCHY", "IMPLEMENTATION", 
		"INCREMENT", "INVOKER", "KEY_MEMBER", "KEY_TYPE", "LAST", "LENGTH", "LEVEL", 
		"LOCATOR", "MAP", "MATCHED", "MAXVALUE", "MESSAGE_LENGTH", "MESSAGE_OCTET_LENGTH", 
		"MESSAGE_TEXT", "MINVALUE", "MORE_", "MUMPS", "NAME", "NAMES", "NESTING", 
		"NULLABLE", "NULLS", "NUMBER", "OCTETS", "ORDERING", "OTHERS", "OVERLAY", 
		"PAD", "PARAMETER_MODE", "PARAMETER_NAME", "PARAMETER_ORDINAL_POSITION", 
		"PARAMETER_SPECIFIC_CATALOG", "PARAMETER_SPECIFIC_NAME", "PARAMETER_SPECIFIC_SCHEMA", 
		"PARTIAL", "PASCAL", "PATH", "PLACING", "PLI", "POSITION", "PRESERVE", 
		"PRIOR", "PRIVILEGES", "PUBLIC", "READ", "RELATIVE", "RESTART", "RETURNED_CARDINALITY", 
		"RETURNED_LENGTH", "RETURNED_OCTET_LENGTH", "RETURNED_SQLSTATE", "ROLE", 
		"ROUTINE", "ROUTINE_CATALOG", "ROUTINE_NAME", "ROUTINE_SCHEMA", "ROW_COUNT", 
		"SCALE", "SCHEMA_NAME", "SCOPE_CATALOG", "SCOPE_NAME", "SCOPE_SCHEMA", 
		"SECTION", "SECURITY", "SELF", "SEQUENCE", "SERIALIZABLE", "SERVER_NAME", 
		"SESSION", "SETS", "SIZE", "SOURCE", "SPACE", "SPECIFIC_NAME", "STATE", 
		"STATEMENT", "STRUCTURE", "SUBCLASS_ORIGIN", "TABLE_NAME", "TIES", "TOP_LEVEL_COUNT", 
		"TRANSACTION", "TRANSACTIONS_COMMITTED", "TRANSACTIONS_ROLLED_BACK", "TRANSACTION_ACTIVE", 
		"TRANSFORM", "TRANSFORMS", "TRANSLATE", "TRIGGER_CATALOG", "TRIGGER_NAME", 
		"TRIGGER_SCHEMA", "UNCOMMITTED", "UNNAMED", "USAGE", "USER_DEFINED_TYPE_CATALOG", 
		"USER_DEFINED_TYPE_CODE", "USER_DEFINED_TYPE_NAME", "USER_DEFINED_TYPE_SCHEMA", 
		"WORK", "WRITE", "NON_RESERVED_KEYWORD", "UNSIGNED_APPROXIMATE", "UNSIGNED_INTEGER", 
		"CHARACTER_STRING_LITERAL", "DELIMITED_IDENTIFIER", "REGULAR_IDENTIFIER", 
		"HEX_CHAR", "BYTE", "BIT", "B", "D", "E", "F", "H", "I", "J", "L", "N", 
		"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "SIMPLE_COMMENT", 
		"BRACKETED_COMMENT", "WS", "DEREFERENCE_OPERATOR", "NOT_EQUALS_OPERATOR", 
		"GREATER_THAN_OR_EQUALS_OPERATOR", "LESS_THAN_OR_EQUALS_OPERATOR", "CONCATENATION_OPERATOR", 
		"DUPLICATED_DOUBLE_QUOTE", "DUPLICATED_QUOTE", "DOUBLE_COLON", "DOUBLE_QUOTE", 
		"PERCENT", "AMPERSAND", "QUOTE", "LEFT_PAREN", "RIGHT_PAREN", "ASTERISK", 
		"PLUS_SIGN", "COMMA", "MINUS_SIGN", "PERIOD", "SOLIDUS", "COLON", "SEMICOLON", 
		"LESS_THAN_OPERATOR", "EQUALS_OPERATOR", "GREATER_THAN_OPERATOR", "QUESTION_MARK", 
		"LEFT_BRACKET", "RIGHT_BRACKET", "CIRCUMFLEX", "UNDERSCORE", "VERTICAL_BAR", 
		"LEFT_BRACE", "RIGHT_BRACE", "DIGIT", "ZERO", "ONE", "TWO", "THREE", "FOUR", 
		"FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "NON_DOUBLE_QUOTE", "NON_QUOTE", 
		"LETTER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SqlStatementContext extends ParserRuleContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public DdlStatementContext ddlStatement() {
			return getRuleContext(DdlStatementContext.class,0);
		}
		public DmlStatementContext dmlStatement() {
			return getRuleContext(DmlStatementContext.class,0);
		}
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSqlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sqlStatement);
		try {
			setState(655);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(652);
				querySpecification();
				}
				break;
			case ALTER:
			case CREATE:
			case DROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(653);
				ddlStatement();
				}
				break;
			case DELETE:
			case INSERT:
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(654);
				dmlStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DdlStatementContext extends ParserRuleContext {
		public CreateSchemaStatementContext createSchemaStatement() {
			return getRuleContext(CreateSchemaStatementContext.class,0);
		}
		public DropSchemaStatementContext dropSchemaStatement() {
			return getRuleContext(DropSchemaStatementContext.class,0);
		}
		public CreateTableStatementContext createTableStatement() {
			return getRuleContext(CreateTableStatementContext.class,0);
		}
		public DropTableStatementContext dropTableStatement() {
			return getRuleContext(DropTableStatementContext.class,0);
		}
		public AlterTableStatementContext alterTableStatement() {
			return getRuleContext(AlterTableStatementContext.class,0);
		}
		public CreateViewStatementContext createViewStatement() {
			return getRuleContext(CreateViewStatementContext.class,0);
		}
		public DropViewStatementContext dropViewStatement() {
			return getRuleContext(DropViewStatementContext.class,0);
		}
		public CreateTypeStatementContext createTypeStatement() {
			return getRuleContext(CreateTypeStatementContext.class,0);
		}
		public DropTypeStatementContext dropTypeStatement() {
			return getRuleContext(DropTypeStatementContext.class,0);
		}
		public AlterTypeStatementContext alterTypeStatement() {
			return getRuleContext(AlterTypeStatementContext.class,0);
		}
		public CreateMethodStatementContext createMethodStatement() {
			return getRuleContext(CreateMethodStatementContext.class,0);
		}
		public DropMethodStatementContext dropMethodStatement() {
			return getRuleContext(DropMethodStatementContext.class,0);
		}
		public CreateFunctionStatementContext createFunctionStatement() {
			return getRuleContext(CreateFunctionStatementContext.class,0);
		}
		public DropFunctionStatementContext dropFunctionStatement() {
			return getRuleContext(DropFunctionStatementContext.class,0);
		}
		public CreateProcedureStatementContext createProcedureStatement() {
			return getRuleContext(CreateProcedureStatementContext.class,0);
		}
		public DropProcedureStatementContext dropProcedureStatement() {
			return getRuleContext(DropProcedureStatementContext.class,0);
		}
		public CreateTriggerStatementContext createTriggerStatement() {
			return getRuleContext(CreateTriggerStatementContext.class,0);
		}
		public DropTriggerStatementContext dropTriggerStatement() {
			return getRuleContext(DropTriggerStatementContext.class,0);
		}
		public DdlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ddlStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDdlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DdlStatementContext ddlStatement() throws RecognitionException {
		DdlStatementContext _localctx = new DdlStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ddlStatement);
		try {
			setState(675);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(657);
				createSchemaStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(658);
				dropSchemaStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(659);
				createTableStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(660);
				dropTableStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(661);
				alterTableStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(662);
				createViewStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(663);
				dropViewStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(664);
				createTypeStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(665);
				dropTypeStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(666);
				alterTypeStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(667);
				createMethodStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(668);
				dropMethodStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(669);
				createFunctionStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(670);
				dropFunctionStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(671);
				createProcedureStatement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(672);
				dropProcedureStatement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(673);
				createTriggerStatement();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(674);
				dropTriggerStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DmlStatementContext extends ParserRuleContext {
		public InsertStatementContext insertStatement() {
			return getRuleContext(InsertStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public UpdateStatementContext updateStatement() {
			return getRuleContext(UpdateStatementContext.class,0);
		}
		public DmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dmlStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDmlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DmlStatementContext dmlStatement() throws RecognitionException {
		DmlStatementContext _localctx = new DmlStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dmlStatement);
		try {
			setState(680);
			switch (_input.LA(1)) {
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(677);
				insertStatement();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 2);
				{
				setState(678);
				deleteStatement();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(679);
				updateStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropSchemaStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode SCHEMA() { return getToken(SqlParser.SCHEMA, 0); }
		public SchemaNameContext schemaName() {
			return getRuleContext(SchemaNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public DropSchemaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropSchemaStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropSchemaStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropSchemaStatementContext dropSchemaStatement() throws RecognitionException {
		DropSchemaStatementContext _localctx = new DropSchemaStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dropSchemaStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(DROP);
			setState(683);
			match(SCHEMA);
			setState(684);
			schemaName();
			setState(685);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateSchemaStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode SCHEMA() { return getToken(SqlParser.SCHEMA, 0); }
		public SchemaNameContext schemaName() {
			return getRuleContext(SchemaNameContext.class,0);
		}
		public TerminalNode AUTHORIZATION() { return getToken(SqlParser.AUTHORIZATION, 0); }
		public AuthorizationNameContext authorizationName() {
			return getRuleContext(AuthorizationNameContext.class,0);
		}
		public CreateSchemaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createSchemaStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateSchemaStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateSchemaStatementContext createSchemaStatement() throws RecognitionException {
		CreateSchemaStatementContext _localctx = new CreateSchemaStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_createSchemaStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			match(CREATE);
			setState(688);
			match(SCHEMA);
			setState(689);
			schemaName();
			setState(692);
			_la = _input.LA(1);
			if (_la==AUTHORIZATION) {
				{
				setState(690);
				match(AUTHORIZATION);
				setState(691);
				authorizationName();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UserNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public UserNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUserName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserNameContext userName() throws RecognitionException {
		UserNameContext _localctx = new UserNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_userName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoleNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public RoleNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roleName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoleName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoleNameContext roleName() throws RecognitionException {
		RoleNameContext _localctx = new RoleNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_roleName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuthorizationNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public AuthorizationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_authorizationName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAuthorizationName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AuthorizationNameContext authorizationName() throws RecognitionException {
		AuthorizationNameContext _localctx = new AuthorizationNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_authorizationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAttributeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public CastIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castIdentifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastIdentifierContext castIdentifier() throws RecognitionException {
		CastIdentifierContext _localctx = new CastIdentifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_castIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public ParameterNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitParameterName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterNameContext parameterName() throws RecognitionException {
		ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public QueryNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQueryName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryNameContext queryName() throws RecognitionException {
		QueryNameContext _localctx = new QueryNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_queryName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorrelationNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public CorrelationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correlationName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCorrelationName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorrelationNameContext correlationName() throws RecognitionException {
		CorrelationNameContext _localctx = new CorrelationNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_correlationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public WindowNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowNameContext windowName() throws RecognitionException {
		WindowNameContext _localctx = new WindowNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_windowName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatalogNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public CatalogNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catalogName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCatalogName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatalogNameContext catalogName() throws RecognitionException {
		CatalogNameContext _localctx = new CatalogNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_catalogName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(SqlParser.COLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			match(COLON);
			setState(721);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SchemaNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SqlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SqlParser.IDENTIFIER, i);
		}
		public TerminalNode PERIOD() { return getToken(SqlParser.PERIOD, 0); }
		public SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSchemaName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaNameContext schemaName() throws RecognitionException {
		SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_schemaName);
		try {
			setState(727);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(723);
				match(IDENTIFIER);
				setState(724);
				match(PERIOD);
				setState(725);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(726);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedIdContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SqlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SqlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(SqlParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(SqlParser.PERIOD, i);
		}
		public QualifiedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQualifiedId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedIdContext qualifiedId() throws RecognitionException {
		QualifiedIdContext _localctx = new QualifiedIdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_qualifiedId);
		try {
			setState(738);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(729);
				match(IDENTIFIER);
				setState(730);
				match(PERIOD);
				setState(731);
				match(IDENTIFIER);
				setState(732);
				match(PERIOD);
				setState(733);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
				match(IDENTIFIER);
				setState(735);
				match(PERIOD);
				setState(736);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(737);
				match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierChainContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(SqlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SqlParser.IDENTIFIER, i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(SqlParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(SqlParser.PERIOD, i);
		}
		public IdentifierChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierChain; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIdentifierChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierChainContext identifierChain() throws RecognitionException {
		IdentifierChainContext _localctx = new IdentifierChainContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_identifierChain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			match(IDENTIFIER);
			setState(745);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(741);
					match(PERIOD);
					setState(742);
					match(IDENTIFIER);
					}
					} 
				}
				setState(747);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public ConstraintNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitConstraintName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintNameContext constraintName() throws RecognitionException {
		ConstraintNameContext _localctx = new ConstraintNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constraintName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public UdtNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUdtName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtNameContext udtName() throws RecognitionException {
		UdtNameContext _localctx = new UdtNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_udtName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecificMethodNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public SpecificMethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specificMethodName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSpecificMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecificMethodNameContext specificMethodName() throws RecognitionException {
		SpecificMethodNameContext _localctx = new SpecificMethodNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_specificMethodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(754);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public RoutineNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoutineName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineNameContext routineName() throws RecognitionException {
		RoutineNameContext _localctx = new RoutineNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_routineName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(756);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public TriggerNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTriggerName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerNameContext triggerName() throws RecognitionException {
		TriggerNameContext _localctx = new TriggerNameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_triggerName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceNameContext extends ParserRuleContext {
		public QualifiedIdContext qualifiedId() {
			return getRuleContext(QualifiedIdContext.class,0);
		}
		public SequenceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSequenceName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceNameContext sequenceName() throws RecognitionException {
		SequenceNameContext _localctx = new SequenceNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sequenceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			qualifiedId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnReferenceContext extends ParserRuleContext {
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public ColumnReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnReferenceContext columnReference() throws RecognitionException {
		ColumnReferenceContext _localctx = new ColumnReferenceContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_columnReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762);
			identifierChain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetArrayReferenceContext extends ParserRuleContext {
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public TargetArrayReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetArrayReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTargetArrayReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetArrayReferenceContext targetArrayReference() throws RecognitionException {
		TargetArrayReferenceContext _localctx = new TargetArrayReferenceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_targetArrayReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			identifierChain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayReferenceContext extends ParserRuleContext {
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public ArrayReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayReferenceContext arrayReference() throws RecognitionException {
		ArrayReferenceContext _localctx = new ArrayReferenceContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arrayReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			identifierChain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropBehaviorContext extends ParserRuleContext {
		public TerminalNode CASCADE() { return getToken(SqlParser.CASCADE, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlParser.RESTRICT, 0); }
		public DropBehaviorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropBehavior; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropBehavior(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropBehaviorContext dropBehavior() throws RecognitionException {
		DropBehaviorContext _localctx = new DropBehaviorContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_dropBehavior);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			_la = _input.LA(1);
			if ( !(_la==CASCADE || _la==RESTRICT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommitActionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public TerminalNode COMMIT() { return getToken(SqlParser.COMMIT, 0); }
		public TerminalNode ROWS() { return getToken(SqlParser.ROWS, 0); }
		public TerminalNode PRESERVE() { return getToken(SqlParser.PRESERVE, 0); }
		public TerminalNode DELETE() { return getToken(SqlParser.DELETE, 0); }
		public CommitActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commitAction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCommitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommitActionContext commitAction() throws RecognitionException {
		CommitActionContext _localctx = new CommitActionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_commitAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			match(ON);
			setState(771);
			match(COMMIT);
			setState(772);
			_la = _input.LA(1);
			if ( !(_la==DELETE || _la==PRESERVE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(773);
			match(ROWS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultsOptionContext extends ParserRuleContext {
		public TerminalNode DEFAULTS() { return getToken(SqlParser.DEFAULTS, 0); }
		public TerminalNode INCLUDING() { return getToken(SqlParser.INCLUDING, 0); }
		public TerminalNode EXCLUDING() { return getToken(SqlParser.EXCLUDING, 0); }
		public DefaultsOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultsOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDefaultsOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultsOptionContext defaultsOption() throws RecognitionException {
		DefaultsOptionContext _localctx = new DefaultsOptionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_defaultsOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(776);
			match(DEFAULTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentityOptionContext extends ParserRuleContext {
		public TerminalNode IDENTITY() { return getToken(SqlParser.IDENTITY, 0); }
		public TerminalNode INCLUDING() { return getToken(SqlParser.INCLUDING, 0); }
		public TerminalNode EXCLUDING() { return getToken(SqlParser.EXCLUDING, 0); }
		public IdentityOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identityOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIdentityOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentityOptionContext identityOption() throws RecognitionException {
		IdentityOptionContext _localctx = new IdentityOptionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_identityOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			_la = _input.LA(1);
			if ( !(_la==EXCLUDING || _la==INCLUDING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(779);
			match(IDENTITY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatchContext extends ParserRuleContext {
		public TerminalNode FULL() { return getToken(SqlParser.FULL, 0); }
		public TerminalNode PARTIAL() { return getToken(SqlParser.PARTIAL, 0); }
		public TerminalNode SIMPLE() { return getToken(SqlParser.SIMPLE, 0); }
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_match);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			_la = _input.LA(1);
			if ( !(_la==FULL || _la==SIMPLE || _la==PARTIAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceGenerationContext extends ParserRuleContext {
		public TerminalNode SYSTEM() { return getToken(SqlParser.SYSTEM, 0); }
		public TerminalNode GENERATED() { return getToken(SqlParser.GENERATED, 0); }
		public TerminalNode USER() { return getToken(SqlParser.USER, 0); }
		public TerminalNode DERIVED() { return getToken(SqlParser.DERIVED, 0); }
		public ReferenceGenerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceGeneration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceGeneration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceGenerationContext referenceGeneration() throws RecognitionException {
		ReferenceGenerationContext _localctx = new ReferenceGenerationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_referenceGeneration);
		try {
			setState(788);
			switch (_input.LA(1)) {
			case SYSTEM:
				enterOuterAlt(_localctx, 1);
				{
				setState(783);
				match(SYSTEM);
				setState(784);
				match(GENERATED);
				}
				break;
			case USER:
				enterOuterAlt(_localctx, 2);
				{
				setState(785);
				match(USER);
				setState(786);
				match(GENERATED);
				}
				break;
			case DERIVED:
				enterOuterAlt(_localctx, 3);
				{
				setState(787);
				match(DERIVED);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceScopeCheckContext extends ParserRuleContext {
		public TerminalNode REFERENCES() { return getToken(SqlParser.REFERENCES, 0); }
		public TerminalNode ARE() { return getToken(SqlParser.ARE, 0); }
		public TerminalNode CHECKED() { return getToken(SqlParser.CHECKED, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public ReferenceScopeCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceScopeCheck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceScopeCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceScopeCheckContext referenceScopeCheck() throws RecognitionException {
		ReferenceScopeCheckContext _localctx = new ReferenceScopeCheckContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_referenceScopeCheck);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			match(REFERENCES);
			setState(791);
			match(ARE);
			setState(793);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(792);
				match(NOT);
				}
			}

			setState(795);
			match(CHECKED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferentialActionContext extends ParserRuleContext {
		public TerminalNode CASCADE() { return getToken(SqlParser.CASCADE, 0); }
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public TerminalNode RESTRICT() { return getToken(SqlParser.RESTRICT, 0); }
		public TerminalNode NO() { return getToken(SqlParser.NO, 0); }
		public TerminalNode ACTION() { return getToken(SqlParser.ACTION, 0); }
		public ReferentialActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referentialAction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferentialAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferentialActionContext referentialAction() throws RecognitionException {
		ReferentialActionContext _localctx = new ReferentialActionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_referentialAction);
		try {
			setState(805);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(797);
				match(CASCADE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(798);
				match(SET);
				setState(799);
				match(NULL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(800);
				match(SET);
				setState(801);
				match(DEFAULT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(802);
				match(RESTRICT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(803);
				match(NO);
				setState(804);
				match(ACTION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableScopeContext extends ParserRuleContext {
		public TerminalNode TEMPORARY() { return getToken(SqlParser.TEMPORARY, 0); }
		public TerminalNode GLOBAL() { return getToken(SqlParser.GLOBAL, 0); }
		public TerminalNode LOCAL() { return getToken(SqlParser.LOCAL, 0); }
		public TableScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableScope; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableScopeContext tableScope() throws RecognitionException {
		TableScopeContext _localctx = new TableScopeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_tableScope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			_la = _input.LA(1);
			if ( !(_la==GLOBAL || _la==LOCAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(808);
			match(TEMPORARY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstantiabilityContext extends ParserRuleContext {
		public TerminalNode INSTANTIABLE() { return getToken(SqlParser.INSTANTIABLE, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public InstantiabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInstantiability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiabilityContext instantiability() throws RecognitionException {
		InstantiabilityContext _localctx = new InstantiabilityContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_instantiability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(810);
				match(NOT);
				}
			}

			setState(813);
			match(INSTANTIABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalityContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(SqlParser.FINAL, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public FinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalityContext finality() throws RecognitionException {
		FinalityContext _localctx = new FinalityContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_finality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(815);
				match(NOT);
				}
			}

			setState(818);
			match(FINAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterModeContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SqlParser.IN, 0); }
		public TerminalNode OUT() { return getToken(SqlParser.OUT, 0); }
		public TerminalNode INOUT() { return getToken(SqlParser.INOUT, 0); }
		public ParameterModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterMode; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitParameterMode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterModeContext parameterMode() throws RecognitionException {
		ParameterModeContext _localctx = new ParameterModeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parameterMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			_la = _input.LA(1);
			if ( !(_la==IN || _la==INOUT || _la==OUT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LanguageNameContext extends ParserRuleContext {
		public TerminalNode ADA() { return getToken(SqlParser.ADA, 0); }
		public TerminalNode C() { return getToken(SqlParser.C, 0); }
		public TerminalNode COBOL() { return getToken(SqlParser.COBOL, 0); }
		public TerminalNode FORTRAN() { return getToken(SqlParser.FORTRAN, 0); }
		public TerminalNode MUMPS() { return getToken(SqlParser.MUMPS, 0); }
		public TerminalNode PASCAL() { return getToken(SqlParser.PASCAL, 0); }
		public TerminalNode PLI() { return getToken(SqlParser.PLI, 0); }
		public TerminalNode SQL() { return getToken(SqlParser.SQL, 0); }
		public LanguageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_languageName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLanguageName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LanguageNameContext languageName() throws RecognitionException {
		LanguageNameContext _localctx = new LanguageNameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_languageName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			_la = _input.LA(1);
			if ( !(_la==SQL || ((((_la - 345)) & ~0x3f) == 0 && ((1L << (_la - 345)) & ((1L << (ADA - 345)) | (1L << (C - 345)) | (1L << (COBOL - 345)) | (1L << (FORTRAN - 345)))) != 0) || ((((_la - 427)) & ~0x3f) == 0 && ((1L << (_la - 427)) & ((1L << (MUMPS - 427)) | (1L << (PASCAL - 427)) | (1L << (PLI - 427)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterStyleContext extends ParserRuleContext {
		public TerminalNode SQL() { return getToken(SqlParser.SQL, 0); }
		public TerminalNode GENERAL() { return getToken(SqlParser.GENERAL, 0); }
		public ParameterStyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterStyle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitParameterStyle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterStyleContext parameterStyle() throws RecognitionException {
		ParameterStyleContext _localctx = new ParameterStyleContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_parameterStyle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			_la = _input.LA(1);
			if ( !(_la==SQL || _la==GENERAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullCallClauseContext extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(SqlParser.RETURNS, 0); }
		public List<TerminalNode> NULL() { return getTokens(SqlParser.NULL); }
		public TerminalNode NULL(int i) {
			return getToken(SqlParser.NULL, i);
		}
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public TerminalNode INPUT() { return getToken(SqlParser.INPUT, 0); }
		public TerminalNode CALLED() { return getToken(SqlParser.CALLED, 0); }
		public NullCallClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullCallClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNullCallClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullCallClauseContext nullCallClause() throws RecognitionException {
		NullCallClauseContext _localctx = new NullCallClauseContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_nullCallClause);
		try {
			setState(835);
			switch (_input.LA(1)) {
			case RETURNS:
				enterOuterAlt(_localctx, 1);
				{
				setState(826);
				match(RETURNS);
				setState(827);
				match(NULL);
				setState(828);
				match(ON);
				setState(829);
				match(NULL);
				setState(830);
				match(INPUT);
				}
				break;
			case CALLED:
				enterOuterAlt(_localctx, 2);
				{
				setState(831);
				match(CALLED);
				setState(832);
				match(ON);
				setState(833);
				match(NULL);
				setState(834);
				match(INPUT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeterministicContext extends ParserRuleContext {
		public TerminalNode DETERMINISTIC() { return getToken(SqlParser.DETERMINISTIC, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public DeterministicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deterministic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDeterministic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeterministicContext deterministic() throws RecognitionException {
		DeterministicContext _localctx = new DeterministicContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_deterministic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(837);
				match(NOT);
				}
			}

			setState(840);
			match(DETERMINISTIC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataAccessContext extends ParserRuleContext {
		public TerminalNode NO() { return getToken(SqlParser.NO, 0); }
		public TerminalNode SQL() { return getToken(SqlParser.SQL, 0); }
		public TerminalNode CONTAINS() { return getToken(SqlParser.CONTAINS, 0); }
		public TerminalNode READS() { return getToken(SqlParser.READS, 0); }
		public TerminalNode DATA() { return getToken(SqlParser.DATA, 0); }
		public TerminalNode MODIFIES() { return getToken(SqlParser.MODIFIES, 0); }
		public DataAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataAccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDataAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataAccessContext dataAccess() throws RecognitionException {
		DataAccessContext _localctx = new DataAccessContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_dataAccess);
		try {
			setState(852);
			switch (_input.LA(1)) {
			case NO:
				enterOuterAlt(_localctx, 1);
				{
				setState(842);
				match(NO);
				setState(843);
				match(SQL);
				}
				break;
			case CONTAINS:
				enterOuterAlt(_localctx, 2);
				{
				setState(844);
				match(CONTAINS);
				setState(845);
				match(SQL);
				}
				break;
			case READS:
				enterOuterAlt(_localctx, 3);
				{
				setState(846);
				match(READS);
				setState(847);
				match(SQL);
				setState(848);
				match(DATA);
				}
				break;
			case MODIFIES:
				enterOuterAlt(_localctx, 4);
				{
				setState(849);
				match(MODIFIES);
				setState(850);
				match(SQL);
				setState(851);
				match(DATA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public TerminalNode INSTANCE() { return getToken(SqlParser.INSTANCE, 0); }
		public TerminalNode STATIC() { return getToken(SqlParser.STATIC, 0); }
		public TerminalNode CONSTRUCTOR() { return getToken(SqlParser.CONSTRUCTOR, 0); }
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMethodType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_methodType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
			_la = _input.LA(1);
			if ( !(_la==INSTANCE || _la==STATIC || _la==CONSTRUCTOR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymmetricOptionContext extends ParserRuleContext {
		public TerminalNode ASYMMETRIC() { return getToken(SqlParser.ASYMMETRIC, 0); }
		public TerminalNode SYMMETRIC() { return getToken(SqlParser.SYMMETRIC, 0); }
		public SymmetricOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symmetricOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSymmetricOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymmetricOptionContext symmetricOption() throws RecognitionException {
		SymmetricOptionContext _localctx = new SymmetricOptionContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_symmetricOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			_la = _input.LA(1);
			if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SqlParser.ALL, 0); }
		public TerminalNode SOME() { return getToken(SqlParser.SOME, 0); }
		public TerminalNode ANY() { return getToken(SqlParser.ANY, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==ANY || _la==SOME) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SqlParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SqlParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampleMethodContext extends ParserRuleContext {
		public TerminalNode BERNOULLI() { return getToken(SqlParser.BERNOULLI, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlParser.SYSTEM, 0); }
		public SampleMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sampleMethod; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSampleMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampleMethodContext sampleMethod() throws RecognitionException {
		SampleMethodContext _localctx = new SampleMethodContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_sampleMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862);
			_la = _input.LA(1);
			if ( !(_la==BERNOULLI || _la==SYSTEM) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(SqlParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(SqlParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SqlParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SqlParser.FULL, 0); }
		public TerminalNode OUTER() { return getToken(SqlParser.OUTER, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_joinType);
		int _la;
		try {
			setState(869);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(864);
				match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(865);
				_la = _input.LA(1);
				if ( !(_la==FULL || _la==LEFT || _la==RIGHT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(867);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(866);
					match(OUTER);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderingSpecificationContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(SqlParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SqlParser.DESC, 0); }
		public OrderingSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderingSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOrderingSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderingSpecificationContext orderingSpecification() throws RecognitionException {
		OrderingSpecificationContext _localctx = new OrderingSpecificationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_orderingSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(871);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullOrderingContext extends ParserRuleContext {
		public TerminalNode NULLS() { return getToken(SqlParser.NULLS, 0); }
		public TerminalNode FIRST() { return getToken(SqlParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SqlParser.LAST, 0); }
		public NullOrderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullOrdering; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNullOrdering(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullOrderingContext nullOrdering() throws RecognitionException {
		NullOrderingContext _localctx = new NullOrderingContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_nullOrdering);
		try {
			setState(877);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(873);
				match(NULLS);
				setState(874);
				match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(875);
				match(NULLS);
				setState(876);
				match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RankFunctionContext extends ParserRuleContext {
		public TerminalNode RANK() { return getToken(SqlParser.RANK, 0); }
		public TerminalNode DENSE_RANK() { return getToken(SqlParser.DENSE_RANK, 0); }
		public TerminalNode PERCENT_RANK() { return getToken(SqlParser.PERCENT_RANK, 0); }
		public TerminalNode CUME_DIST() { return getToken(SqlParser.CUME_DIST, 0); }
		public RankFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rankFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRankFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RankFunctionContext rankFunction() throws RecognitionException {
		RankFunctionContext _localctx = new RankFunctionContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_rankFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(879);
			_la = _input.LA(1);
			if ( !(_la==CUME_DIST || _la==DENSE_RANK || _la==PERCENT_RANK || _la==RANK) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetFunctionContext extends ParserRuleContext {
		public TerminalNode AVG() { return getToken(SqlParser.AVG, 0); }
		public TerminalNode MAX() { return getToken(SqlParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(SqlParser.MIN, 0); }
		public TerminalNode SUM() { return getToken(SqlParser.SUM, 0); }
		public TerminalNode EVERY() { return getToken(SqlParser.EVERY, 0); }
		public TerminalNode ANY() { return getToken(SqlParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(SqlParser.SOME, 0); }
		public TerminalNode COUNT() { return getToken(SqlParser.COUNT, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SqlParser.STDDEV_POP, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SqlParser.STDDEV_SAMP, 0); }
		public TerminalNode VAR_POP() { return getToken(SqlParser.VAR_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SqlParser.VAR_SAMP, 0); }
		public TerminalNode COLLECT() { return getToken(SqlParser.COLLECT, 0); }
		public TerminalNode FUSION() { return getToken(SqlParser.FUSION, 0); }
		public TerminalNode INTERSECTION() { return getToken(SqlParser.INTERSECTION, 0); }
		public SetFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSetFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetFunctionContext setFunction() throws RecognitionException {
		SetFunctionContext _localctx = new SetFunctionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_setFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ANY) | (1L << AVG) | (1L << COLLECT))) != 0) || _la==COUNT || _la==EVERY || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (FUSION - 133)) | (1L << (INTERSECTION - 133)) | (1L << (MAX - 133)) | (1L << (MIN - 133)))) != 0) || ((((_la - 278)) & ~0x3f) == 0 && ((1L << (_la - 278)) & ((1L << (SOME - 278)) | (1L << (STDDEV_POP - 278)) | (1L << (STDDEV_SAMP - 278)) | (1L << (SUM - 278)) | (1L << (VAR_POP - 278)) | (1L << (VAR_SAMP - 278)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinarySetFunctionContext extends ParserRuleContext {
		public TerminalNode COVAR_POP() { return getToken(SqlParser.COVAR_POP, 0); }
		public TerminalNode COVAR_SAMP() { return getToken(SqlParser.COVAR_SAMP, 0); }
		public TerminalNode CORR() { return getToken(SqlParser.CORR, 0); }
		public TerminalNode REGR_SLOPE() { return getToken(SqlParser.REGR_SLOPE, 0); }
		public TerminalNode REGR_INTERCEPT() { return getToken(SqlParser.REGR_INTERCEPT, 0); }
		public TerminalNode REGR_COUNT() { return getToken(SqlParser.REGR_COUNT, 0); }
		public TerminalNode REGR_RSQUARED() { return getToken(SqlParser.REGR_RSQUARED, 0); }
		public TerminalNode REGR_AVGX() { return getToken(SqlParser.REGR_AVGX, 0); }
		public TerminalNode REGR_AVGY() { return getToken(SqlParser.REGR_AVGY, 0); }
		public TerminalNode REGR_SXX() { return getToken(SqlParser.REGR_SXX, 0); }
		public TerminalNode REGR_SYY() { return getToken(SqlParser.REGR_SYY, 0); }
		public TerminalNode REGR_SXY() { return getToken(SqlParser.REGR_SXY, 0); }
		public BinarySetFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarySetFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBinarySetFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinarySetFunctionContext binarySetFunction() throws RecognitionException {
		BinarySetFunctionContext _localctx = new BinarySetFunctionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_binarySetFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			_la = _input.LA(1);
			if ( !(_la==COVAR_POP || _la==COVAR_SAMP || ((((_la - 243)) & ~0x3f) == 0 && ((1L << (_la - 243)) & ((1L << (REGR_AVGX - 243)) | (1L << (REGR_AVGY - 243)) | (1L << (REGR_COUNT - 243)) | (1L << (REGR_INTERCEPT - 243)) | (1L << (REGR_RSQUARED - 243)) | (1L << (REGR_SLOPE - 243)) | (1L << (REGR_SXX - 243)) | (1L << (REGR_SXY - 243)) | (1L << (REGR_SYY - 243)))) != 0) || _la==CORR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InverseDistributionFunctionContext extends ParserRuleContext {
		public TerminalNode PERCENTILE_CONT() { return getToken(SqlParser.PERCENTILE_CONT, 0); }
		public TerminalNode PERCENTILE_DISC() { return getToken(SqlParser.PERCENTILE_DISC, 0); }
		public InverseDistributionFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inverseDistributionFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInverseDistributionFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InverseDistributionFunctionContext inverseDistributionFunction() throws RecognitionException {
		InverseDistributionFunctionContext _localctx = new InverseDistributionFunctionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_inverseDistributionFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			_la = _input.LA(1);
			if ( !(_la==PERCENTILE_CONT || _la==PERCENTILE_DISC) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameUnitsContext extends ParserRuleContext {
		public TerminalNode ROWS() { return getToken(SqlParser.ROWS, 0); }
		public TerminalNode RANGE() { return getToken(SqlParser.RANGE, 0); }
		public WindowFrameUnitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameUnits; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameUnits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameUnitsContext windowFrameUnits() throws RecognitionException {
		WindowFrameUnitsContext _localctx = new WindowFrameUnitsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_windowFrameUnits);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			_la = _input.LA(1);
			if ( !(_la==RANGE || _la==ROWS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameExclusionContext extends ParserRuleContext {
		public TerminalNode EXCLUDE() { return getToken(SqlParser.EXCLUDE, 0); }
		public TerminalNode CURRENT() { return getToken(SqlParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public TerminalNode GROUP() { return getToken(SqlParser.GROUP, 0); }
		public TerminalNode TIES() { return getToken(SqlParser.TIES, 0); }
		public TerminalNode NO() { return getToken(SqlParser.NO, 0); }
		public TerminalNode OTHERS() { return getToken(SqlParser.OTHERS, 0); }
		public WindowFrameExclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameExclusion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameExclusion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameExclusionContext windowFrameExclusion() throws RecognitionException {
		WindowFrameExclusionContext _localctx = new WindowFrameExclusionContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_windowFrameExclusion);
		try {
			setState(899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				match(EXCLUDE);
				setState(890);
				match(CURRENT);
				setState(891);
				match(ROW);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(892);
				match(EXCLUDE);
				setState(893);
				match(GROUP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(894);
				match(EXCLUDE);
				setState(895);
				match(TIES);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(896);
				match(EXCLUDE);
				setState(897);
				match(NO);
				setState(898);
				match(OTHERS);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeOperatorContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(SqlParser.ASTERISK, 0); }
		public TerminalNode SOLIDUS() { return getToken(SqlParser.SOLIDUS, 0); }
		public MultiplicativeOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultiplicativeOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeOperatorContext multiplicativeOperator() throws RecognitionException {
		MultiplicativeOperatorContext _localctx = new MultiplicativeOperatorContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_multiplicativeOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			_la = _input.LA(1);
			if ( !(_la==ASTERISK || _la==SOLIDUS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS_SIGN() { return getToken(SqlParser.PLUS_SIGN, 0); }
		public TerminalNode MINUS_SIGN() { return getToken(SqlParser.MINUS_SIGN, 0); }
		public AdditiveOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAdditiveOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveOperatorContext additiveOperator() throws RecognitionException {
		AdditiveOperatorContext _localctx = new AdditiveOperatorContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_additiveOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			_la = _input.LA(1);
			if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanOperatorContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SqlParser.AND, 0); }
		public TerminalNode OR() { return getToken(SqlParser.OR, 0); }
		public BooleanOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBooleanOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanOperatorContext booleanOperator() throws RecognitionException {
		BooleanOperatorContext _localctx = new BooleanOperatorContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_booleanOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(905);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeZoneFieldContext extends ParserRuleContext {
		public TerminalNode TIMEZONE_HOUR() { return getToken(SqlParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SqlParser.TIMEZONE_MINUTE, 0); }
		public TimeZoneFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeZoneField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTimeZoneField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeZoneFieldContext timeZoneField() throws RecognitionException {
		TimeZoneFieldContext _localctx = new TimeZoneFieldContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_timeZoneField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			_la = _input.LA(1);
			if ( !(_la==TIMEZONE_HOUR || _la==TIMEZONE_MINUTE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplierContext extends ParserRuleContext {
		public TerminalNode K() { return getToken(SqlParser.K, 0); }
		public TerminalNode M() { return getToken(SqlParser.M, 0); }
		public TerminalNode G() { return getToken(SqlParser.G, 0); }
		public MultiplierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultiplier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplierContext multiplier() throws RecognitionException {
		MultiplierContext _localctx = new MultiplierContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_multiplier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			_la = _input.LA(1);
			if ( !(((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (G - 134)) | (1L << (K - 134)) | (1L << (M - 134)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithOrWithoutTimeZoneContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(SqlParser.TIME, 0); }
		public TerminalNode ZONE() { return getToken(SqlParser.ZONE, 0); }
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public TerminalNode WITHOUT() { return getToken(SqlParser.WITHOUT, 0); }
		public WithOrWithoutTimeZoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withOrWithoutTimeZone; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWithOrWithoutTimeZone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithOrWithoutTimeZoneContext withOrWithoutTimeZone() throws RecognitionException {
		WithOrWithoutTimeZoneContext _localctx = new WithOrWithoutTimeZoneContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_withOrWithoutTimeZone);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			_la = _input.LA(1);
			if ( !(_la==WITH || _la==WITHOUT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(912);
			match(TIME);
			setState(913);
			match(ZONE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultisetOperatorContext extends ParserRuleContext {
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public TerminalNode INTERSECT() { return getToken(SqlParser.INTERSECT, 0); }
		public TerminalNode UNION() { return getToken(SqlParser.UNION, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlParser.EXCEPT, 0); }
		public MultisetOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multisetOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultisetOperatorContext multisetOperator() throws RecognitionException {
		MultisetOperatorContext _localctx = new MultisetOperatorContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_multisetOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(MULTISET);
			setState(916);
			_la = _input.LA(1);
			if ( !(_la==EXCEPT || _la==INTERSECT || _la==UNION) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryOperatorContext extends ParserRuleContext {
		public TerminalNode INTERSECT() { return getToken(SqlParser.INTERSECT, 0); }
		public TerminalNode UNION() { return getToken(SqlParser.UNION, 0); }
		public TerminalNode EXCEPT() { return getToken(SqlParser.EXCEPT, 0); }
		public QueryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQueryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryOperatorContext queryOperator() throws RecognitionException {
		QueryOperatorContext _localctx = new QueryOperatorContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_queryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			_la = _input.LA(1);
			if ( !(_la==EXCEPT || _la==INTERSECT || _la==UNION) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryDatetimeFieldContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(SqlParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(SqlParser.MONTH, 0); }
		public TerminalNode DAY() { return getToken(SqlParser.DAY, 0); }
		public TerminalNode HOUR() { return getToken(SqlParser.HOUR, 0); }
		public TerminalNode MINUTE() { return getToken(SqlParser.MINUTE, 0); }
		public TerminalNode SECOND() { return getToken(SqlParser.SECOND, 0); }
		public PrimaryDatetimeFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryDatetimeField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPrimaryDatetimeField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryDatetimeFieldContext primaryDatetimeField() throws RecognitionException {
		PrimaryDatetimeFieldContext _localctx = new PrimaryDatetimeFieldContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_primaryDatetimeField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			_la = _input.LA(1);
			if ( !(_la==DAY || _la==HOUR || _la==MINUTE || _la==MONTH || _la==SECOND || _la==YEAR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQUALS_OPERATOR() { return getToken(SqlParser.EQUALS_OPERATOR, 0); }
		public TerminalNode NOT_EQUALS_OPERATOR() { return getToken(SqlParser.NOT_EQUALS_OPERATOR, 0); }
		public TerminalNode LESS_THAN_OPERATOR() { return getToken(SqlParser.LESS_THAN_OPERATOR, 0); }
		public TerminalNode GREATER_THAN_OPERATOR() { return getToken(SqlParser.GREATER_THAN_OPERATOR, 0); }
		public TerminalNode LESS_THAN_OR_EQUALS_OPERATOR() { return getToken(SqlParser.LESS_THAN_OR_EQUALS_OPERATOR, 0); }
		public TerminalNode GREATER_THAN_OR_EQUALS_OPERATOR() { return getToken(SqlParser.GREATER_THAN_OR_EQUALS_OPERATOR, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			_la = _input.LA(1);
			if ( !(((((_la - 545)) & ~0x3f) == 0 && ((1L << (_la - 545)) & ((1L << (NOT_EQUALS_OPERATOR - 545)) | (1L << (GREATER_THAN_OR_EQUALS_OPERATOR - 545)) | (1L << (LESS_THAN_OR_EQUALS_OPERATOR - 545)) | (1L << (LESS_THAN_OPERATOR - 545)) | (1L << (EQUALS_OPERATOR - 545)) | (1L << (GREATER_THAN_OPERATOR - 545)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignContext extends ParserRuleContext {
		public TerminalNode PLUS_SIGN() { return getToken(SqlParser.PLUS_SIGN, 0); }
		public TerminalNode MINUS_SIGN() { return getToken(SqlParser.MINUS_SIGN, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(924);
			_la = _input.LA(1);
			if ( !(_la==PLUS_SIGN || _la==MINUS_SIGN) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithOrWithoutDataContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public TerminalNode DATA() { return getToken(SqlParser.DATA, 0); }
		public TerminalNode NO() { return getToken(SqlParser.NO, 0); }
		public WithOrWithoutDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withOrWithoutData; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWithOrWithoutData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithOrWithoutDataContext withOrWithoutData() throws RecognitionException {
		WithOrWithoutDataContext _localctx = new WithOrWithoutDataContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_withOrWithoutData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			match(WITH);
			setState(928);
			_la = _input.LA(1);
			if (_la==NO) {
				{
				setState(927);
				match(NO);
				}
			}

			setState(930);
			match(DATA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintCheckTimeContext extends ParserRuleContext {
		public TerminalNode INITIALLY() { return getToken(SqlParser.INITIALLY, 0); }
		public TerminalNode DEFERRED() { return getToken(SqlParser.DEFERRED, 0); }
		public TerminalNode IMMEDIATE() { return getToken(SqlParser.IMMEDIATE, 0); }
		public ConstraintCheckTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintCheckTime; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitConstraintCheckTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintCheckTimeContext constraintCheckTime() throws RecognitionException {
		ConstraintCheckTimeContext _localctx = new ConstraintCheckTimeContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_constraintCheckTime);
		try {
			setState(936);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(932);
				match(INITIALLY);
				setState(933);
				match(DEFERRED);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(934);
				match(INITIALLY);
				setState(935);
				match(IMMEDIATE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeferrabilityContext extends ParserRuleContext {
		public TerminalNode DEFERRABLE() { return getToken(SqlParser.DEFERRABLE, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public DeferrabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deferrability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDeferrability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeferrabilityContext deferrability() throws RecognitionException {
		DeferrabilityContext _localctx = new DeferrabilityContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_deferrability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(938);
				match(NOT);
				}
			}

			setState(941);
			match(DEFERRABLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LevelsContext extends ParserRuleContext {
		public TerminalNode CASCADED() { return getToken(SqlParser.CASCADED, 0); }
		public TerminalNode LOCAL() { return getToken(SqlParser.LOCAL, 0); }
		public LevelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_levels; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLevels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelsContext levels() throws RecognitionException {
		LevelsContext _localctx = new LevelsContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_levels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			_la = _input.LA(1);
			if ( !(_la==CASCADED || _la==LOCAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerActionTimeContext extends ParserRuleContext {
		public TerminalNode BEFORE() { return getToken(SqlParser.BEFORE, 0); }
		public TerminalNode AFTER() { return getToken(SqlParser.AFTER, 0); }
		public TriggerActionTimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerActionTime; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTriggerActionTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerActionTimeContext triggerActionTime() throws RecognitionException {
		TriggerActionTimeContext _localctx = new TriggerActionTimeContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_triggerActionTime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			_la = _input.LA(1);
			if ( !(_la==AFTER || _la==BEFORE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OverrideClauseContext extends ParserRuleContext {
		public TerminalNode OVERRIDING() { return getToken(SqlParser.OVERRIDING, 0); }
		public TerminalNode USER() { return getToken(SqlParser.USER, 0); }
		public TerminalNode VALUE() { return getToken(SqlParser.VALUE, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlParser.SYSTEM, 0); }
		public OverrideClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overrideClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOverrideClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverrideClauseContext overrideClause() throws RecognitionException {
		OverrideClauseContext _localctx = new OverrideClauseContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_overrideClause);
		try {
			setState(953);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(947);
				match(OVERRIDING);
				setState(948);
				match(USER);
				setState(949);
				match(VALUE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(950);
				match(OVERRIDING);
				setState(951);
				match(SYSTEM);
				setState(952);
				match(VALUE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecialValueContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode ARRAY() { return getToken(SqlParser.ARRAY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public SpecialValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSpecialValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialValueContext specialValue() throws RecognitionException {
		SpecialValueContext _localctx = new SpecialValueContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_specialValue);
		try {
			setState(963);
			switch (_input.LA(1)) {
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(955);
				match(NULL);
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(956);
				match(ARRAY);
				setState(957);
				match(LEFT_BRACKET);
				setState(958);
				match(RIGHT_BRACKET);
				}
				break;
			case MULTISET:
				enterOuterAlt(_localctx, 3);
				{
				setState(959);
				match(MULTISET);
				setState(960);
				match(LEFT_BRACKET);
				setState(961);
				match(RIGHT_BRACKET);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(962);
				match(DEFAULT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropTableStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public DropTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTableStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropTableStatementContext dropTableStatement() throws RecognitionException {
		DropTableStatementContext _localctx = new DropTableStatementContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_dropTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(965);
			match(DROP);
			setState(966);
			match(TABLE);
			setState(967);
			tableName();
			setState(968);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTableStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TableContentsContext tableContents() {
			return getRuleContext(TableContentsContext.class,0);
		}
		public TableScopeContext tableScope() {
			return getRuleContext(TableScopeContext.class,0);
		}
		public CommitActionContext commitAction() {
			return getRuleContext(CommitActionContext.class,0);
		}
		public CreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_createTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			match(CREATE);
			setState(972);
			_la = _input.LA(1);
			if (_la==GLOBAL || _la==LOCAL) {
				{
				setState(971);
				tableScope();
				}
			}

			setState(974);
			match(TABLE);
			setState(975);
			tableName();
			setState(976);
			tableContents();
			setState(978);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(977);
				commitAction();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterTableStatementContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(SqlParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AlterTableActionContext alterTableAction() {
			return getRuleContext(AlterTableActionContext.class,0);
		}
		public AlterTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTableStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAlterTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterTableStatementContext alterTableStatement() throws RecognitionException {
		AlterTableStatementContext _localctx = new AlterTableStatementContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_alterTableStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(980);
			match(ALTER);
			setState(981);
			match(TABLE);
			setState(982);
			tableName();
			setState(983);
			alterTableAction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropViewStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode VIEW() { return getToken(SqlParser.VIEW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public DropViewStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropViewStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropViewStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropViewStatementContext dropViewStatement() throws RecognitionException {
		DropViewStatementContext _localctx = new DropViewStatementContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_dropViewStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(985);
			match(DROP);
			setState(986);
			match(VIEW);
			setState(987);
			tableName();
			setState(988);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateViewStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode VIEW() { return getToken(SqlParser.VIEW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ViewSpecificationContext viewSpecification() {
			return getRuleContext(ViewSpecificationContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RECURSIVE() { return getToken(SqlParser.RECURSIVE, 0); }
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public TerminalNode CHECK() { return getToken(SqlParser.CHECK, 0); }
		public TerminalNode OPTION() { return getToken(SqlParser.OPTION, 0); }
		public LevelsContext levels() {
			return getRuleContext(LevelsContext.class,0);
		}
		public CreateViewStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createViewStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateViewStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateViewStatementContext createViewStatement() throws RecognitionException {
		CreateViewStatementContext _localctx = new CreateViewStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_createViewStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(990);
			match(CREATE);
			setState(992);
			_la = _input.LA(1);
			if (_la==RECURSIVE) {
				{
				setState(991);
				match(RECURSIVE);
				}
			}

			setState(994);
			match(VIEW);
			setState(995);
			tableName();
			setState(996);
			viewSpecification();
			setState(997);
			match(AS);
			setState(998);
			queryExpression();
			setState(1005);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(999);
				match(WITH);
				setState(1001);
				_la = _input.LA(1);
				if (_la==CASCADED || _la==LOCAL) {
					{
					setState(1000);
					levels();
					}
				}

				setState(1003);
				match(CHECK);
				setState(1004);
				match(OPTION);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterTableActionContext extends ParserRuleContext {
		public AlterTableActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTableAction; }
	 
		public AlterTableActionContext() { }
		public void copyFrom(AlterTableActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddColumnDefinitionContext extends AlterTableActionContext {
		public TerminalNode ADD() { return getToken(SqlParser.ADD, 0); }
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(SqlParser.COLUMN, 0); }
		public AddColumnDefinitionContext(AlterTableActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlterColumnDefinitionContext extends AlterTableActionContext {
		public TerminalNode ALTER() { return getToken(SqlParser.ALTER, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public AlterColumnActionContext alterColumnAction() {
			return getRuleContext(AlterColumnActionContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(SqlParser.COLUMN, 0); }
		public AlterColumnDefinitionContext(AlterTableActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAlterColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColumnDefinitionContext extends AlterTableActionContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public TerminalNode COLUMN() { return getToken(SqlParser.COLUMN, 0); }
		public DropColumnDefinitionContext(AlterTableActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropTableConstraintDefinitionContext extends AlterTableActionContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SqlParser.CONSTRAINT, 0); }
		public ConstraintNameContext constraintName() {
			return getRuleContext(ConstraintNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public DropTableConstraintDefinitionContext(AlterTableActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropTableConstraintDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddTableConstraintDefinitionContext extends AlterTableActionContext {
		public TerminalNode ADD() { return getToken(SqlParser.ADD, 0); }
		public TableConstraintDefinitionContext tableConstraintDefinition() {
			return getRuleContext(TableConstraintDefinitionContext.class,0);
		}
		public AddTableConstraintDefinitionContext(AlterTableActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddTableConstraintDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterTableActionContext alterTableAction() throws RecognitionException {
		AlterTableActionContext _localctx = new AlterTableActionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_alterTableAction);
		int _la;
		try {
			setState(1033);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new AddColumnDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1007);
				match(ADD);
				setState(1009);
				_la = _input.LA(1);
				if (_la==COLUMN) {
					{
					setState(1008);
					match(COLUMN);
					}
				}

				setState(1011);
				columnDefinition();
				}
				break;
			case 2:
				_localctx = new DropColumnDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1012);
				match(DROP);
				setState(1014);
				_la = _input.LA(1);
				if (_la==COLUMN) {
					{
					setState(1013);
					match(COLUMN);
					}
				}

				setState(1016);
				columnName();
				setState(1017);
				dropBehavior();
				}
				break;
			case 3:
				_localctx = new AlterColumnDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1019);
				match(ALTER);
				setState(1021);
				_la = _input.LA(1);
				if (_la==COLUMN) {
					{
					setState(1020);
					match(COLUMN);
					}
				}

				setState(1023);
				columnName();
				setState(1024);
				alterColumnAction();
				}
				break;
			case 4:
				_localctx = new AddTableConstraintDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1026);
				match(ADD);
				setState(1027);
				tableConstraintDefinition();
				}
				break;
			case 5:
				_localctx = new DropTableConstraintDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1028);
				match(DROP);
				setState(1029);
				match(CONSTRAINT);
				setState(1030);
				constraintName();
				setState(1031);
				dropBehavior();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterColumnActionContext extends ParserRuleContext {
		public AlterColumnActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterColumnAction; }
	 
		public AlterColumnActionContext() { }
		public void copyFrom(AlterColumnActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetColumnDefaultClauseContext extends AlterColumnActionContext {
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public DefaultOptionContext defaultOption() {
			return getRuleContext(DefaultOptionContext.class,0);
		}
		public SetColumnDefaultClauseContext(AlterColumnActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSetColumnDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColumnScopeClauseContext extends AlterColumnActionContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode SCOPE() { return getToken(SqlParser.SCOPE, 0); }
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public DropColumnScopeClauseContext(AlterColumnActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropColumnScopeClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddColumnScopeClauseContext extends AlterColumnActionContext {
		public TerminalNode ADD() { return getToken(SqlParser.ADD, 0); }
		public TerminalNode SCOPE() { return getToken(SqlParser.SCOPE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AddColumnScopeClauseContext(AlterColumnActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddColumnScopeClause(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColumnDefaultClauseContext extends AlterColumnActionContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public DropColumnDefaultClauseContext(AlterColumnActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropColumnDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterColumnActionContext alterColumnAction() throws RecognitionException {
		AlterColumnActionContext _localctx = new AlterColumnActionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_alterColumnAction);
		try {
			setState(1046);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new SetColumnDefaultClauseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1035);
				match(SET);
				setState(1036);
				match(DEFAULT);
				setState(1037);
				defaultOption();
				}
				break;
			case 2:
				_localctx = new DropColumnDefaultClauseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1038);
				match(DROP);
				setState(1039);
				match(DEFAULT);
				}
				break;
			case 3:
				_localctx = new AddColumnScopeClauseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1040);
				match(ADD);
				setState(1041);
				match(SCOPE);
				setState(1042);
				tableName();
				}
				break;
			case 4:
				_localctx = new DropColumnScopeClauseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1043);
				match(DROP);
				setState(1044);
				match(SCOPE);
				setState(1045);
				dropBehavior();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableContentsContext extends ParserRuleContext {
		public TableElementListContext tableElementList() {
			return getRuleContext(TableElementListContext.class,0);
		}
		public TerminalNode OF() { return getToken(SqlParser.OF, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public SubtableClauseContext subtableClause() {
			return getRuleContext(SubtableClauseContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SqlParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SqlParser.LEFT_PAREN, i);
		}
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SqlParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SqlParser.RIGHT_PAREN, i);
		}
		public WithOrWithoutDataContext withOrWithoutData() {
			return getRuleContext(WithOrWithoutDataContext.class,0);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TableContentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableContents; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableContents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContentsContext tableContents() throws RecognitionException {
		TableContentsContext _localctx = new TableContentsContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_tableContents);
		int _la;
		try {
			setState(1075);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1048);
				tableElementList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1049);
				match(OF);
				setState(1050);
				udtName();
				setState(1052);
				_la = _input.LA(1);
				if (_la==UNDER) {
					{
					setState(1051);
					subtableClause();
					}
				}

				setState(1054);
				tableElementList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1067);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1056);
					match(LEFT_PAREN);
					setState(1057);
					columnName();
					setState(1062);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1058);
						match(COMMA);
						setState(1059);
						columnName();
						}
						}
						setState(1064);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1065);
					match(RIGHT_PAREN);
					}
				}

				setState(1069);
				match(AS);
				setState(1070);
				match(LEFT_PAREN);
				setState(1071);
				queryExpression();
				setState(1072);
				match(RIGHT_PAREN);
				setState(1073);
				withOrWithoutData();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubtableClauseContext extends ParserRuleContext {
		public TerminalNode UNDER() { return getToken(SqlParser.UNDER, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public SubtableClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtableClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSubtableClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtableClauseContext subtableClause() throws RecognitionException {
		SubtableClauseContext _localctx = new SubtableClauseContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_subtableClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1077);
			match(UNDER);
			setState(1078);
			tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableElementListContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<TableElementContext> tableElement() {
			return getRuleContexts(TableElementContext.class);
		}
		public TableElementContext tableElement(int i) {
			return getRuleContext(TableElementContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TableElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableElementList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableElementListContext tableElementList() throws RecognitionException {
		TableElementListContext _localctx = new TableElementListContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_tableElementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080);
			match(LEFT_PAREN);
			setState(1081);
			tableElement();
			setState(1086);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1082);
				match(COMMA);
				setState(1083);
				tableElement();
				}
				}
				setState(1088);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1089);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableElementContext extends ParserRuleContext {
		public ColumnDefinitionContext columnDefinition() {
			return getRuleContext(ColumnDefinitionContext.class,0);
		}
		public TableConstraintDefinitionContext tableConstraintDefinition() {
			return getRuleContext(TableConstraintDefinitionContext.class,0);
		}
		public LikeClauseContext likeClause() {
			return getRuleContext(LikeClauseContext.class,0);
		}
		public SelfrefColumnSpecificationContext selfrefColumnSpecification() {
			return getRuleContext(SelfrefColumnSpecificationContext.class,0);
		}
		public ColumnOptionsContext columnOptions() {
			return getRuleContext(ColumnOptionsContext.class,0);
		}
		public TableElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableElementContext tableElement() throws RecognitionException {
		TableElementContext _localctx = new TableElementContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_tableElement);
		try {
			setState(1096);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1091);
				columnDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1092);
				tableConstraintDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1093);
				likeClause();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1094);
				selfrefColumnSpecification();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1095);
				columnOptions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewSpecificationContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode OF() { return getToken(SqlParser.OF, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public ViewElementListContext viewElementList() {
			return getRuleContext(ViewElementListContext.class,0);
		}
		public SubviewClauseContext subviewClause() {
			return getRuleContext(SubviewClauseContext.class,0);
		}
		public ViewSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitViewSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewSpecificationContext viewSpecification() throws RecognitionException {
		ViewSpecificationContext _localctx = new ViewSpecificationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_viewSpecification);
		int _la;
		try {
			setState(1116);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1098);
				match(LEFT_PAREN);
				setState(1099);
				columnName();
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1100);
					match(COMMA);
					setState(1101);
					columnName();
					}
					}
					setState(1106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1107);
				match(RIGHT_PAREN);
				}
				break;
			case OF:
				enterOuterAlt(_localctx, 2);
				{
				setState(1109);
				match(OF);
				setState(1110);
				udtName();
				setState(1112);
				_la = _input.LA(1);
				if (_la==UNDER) {
					{
					setState(1111);
					subviewClause();
					}
				}

				setState(1114);
				viewElementList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubviewClauseContext extends ParserRuleContext {
		public TerminalNode UNDER() { return getToken(SqlParser.UNDER, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public SubviewClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subviewClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSubviewClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubviewClauseContext subviewClause() throws RecognitionException {
		SubviewClauseContext _localctx = new SubviewClauseContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_subviewClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			match(UNDER);
			setState(1119);
			tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewElementListContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ViewElementContext> viewElement() {
			return getRuleContexts(ViewElementContext.class);
		}
		public ViewElementContext viewElement(int i) {
			return getRuleContext(ViewElementContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public ViewElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewElementList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitViewElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewElementListContext viewElementList() throws RecognitionException {
		ViewElementListContext _localctx = new ViewElementListContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_viewElementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1121);
			match(LEFT_PAREN);
			setState(1122);
			viewElement();
			setState(1127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1123);
				match(COMMA);
				setState(1124);
				viewElement();
				}
				}
				setState(1129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1130);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ViewElementContext extends ParserRuleContext {
		public SelfrefColumnSpecificationContext selfrefColumnSpecification() {
			return getRuleContext(SelfrefColumnSpecificationContext.class,0);
		}
		public ColumnOptionsContext columnOptions() {
			return getRuleContext(ColumnOptionsContext.class,0);
		}
		public ViewElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitViewElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewElementContext viewElement() throws RecognitionException {
		ViewElementContext _localctx = new ViewElementContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_viewElement);
		try {
			setState(1134);
			switch (_input.LA(1)) {
			case REF:
				enterOuterAlt(_localctx, 1);
				{
				setState(1132);
				selfrefColumnSpecification();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1133);
				columnOptions();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ReferenceScopeCheckContext referenceScopeCheck() {
			return getRuleContext(ReferenceScopeCheckContext.class,0);
		}
		public DeleteActionContext deleteAction() {
			return getRuleContext(DeleteActionContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public DefaultOptionContext defaultOption() {
			return getRuleContext(DefaultOptionContext.class,0);
		}
		public GenerationClauseContext generationClause() {
			return getRuleContext(GenerationClauseContext.class,0);
		}
		public ColumnConstraintDefinitionContext columnConstraintDefinition() {
			return getRuleContext(ColumnConstraintDefinitionContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1136);
			columnName();
			setState(1137);
			dataType(0);
			setState(1139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(1138);
				referenceScopeCheck();
				}
				break;
			}
			setState(1142);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1141);
				deleteAction();
				}
			}

			setState(1146);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1144);
				match(DEFAULT);
				setState(1145);
				defaultOption();
				}
			}

			setState(1149);
			_la = _input.LA(1);
			if (_la==GENERATED) {
				{
				setState(1148);
				generationClause();
				}
			}

			setState(1152);
			_la = _input.LA(1);
			if (_la==CHECK || _la==CONSTRAINT || ((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & ((1L << (NOT - 202)) | (1L << (PRIMARY - 202)) | (1L << (REFERENCES - 202)))) != 0) || _la==UNIQUE) {
				{
				setState(1151);
				columnConstraintDefinition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableConstraintDefinitionContext extends ParserRuleContext {
		public TableConstraintContext tableConstraint() {
			return getRuleContext(TableConstraintContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(SqlParser.CONSTRAINT, 0); }
		public ConstraintNameContext constraintName() {
			return getRuleContext(ConstraintNameContext.class,0);
		}
		public ConstraintCharacteristicsContext constraintCharacteristics() {
			return getRuleContext(ConstraintCharacteristicsContext.class,0);
		}
		public TableConstraintDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableConstraintDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableConstraintDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableConstraintDefinitionContext tableConstraintDefinition() throws RecognitionException {
		TableConstraintDefinitionContext _localctx = new TableConstraintDefinitionContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_tableConstraintDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1154);
				match(CONSTRAINT);
				setState(1155);
				constraintName();
				}
			}

			setState(1158);
			tableConstraint();
			setState(1160);
			_la = _input.LA(1);
			if (_la==DEFERRABLE || _la==INITIALLY || _la==NOT) {
				{
				setState(1159);
				constraintCharacteristics();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeClauseContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(SqlParser.LIKE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public IdentityOptionContext identityOption() {
			return getRuleContext(IdentityOptionContext.class,0);
		}
		public DefaultsOptionContext defaultsOption() {
			return getRuleContext(DefaultsOptionContext.class,0);
		}
		public LikeClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLikeClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeClauseContext likeClause() throws RecognitionException {
		LikeClauseContext _localctx = new LikeClauseContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_likeClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1162);
			match(LIKE);
			setState(1163);
			tableName();
			setState(1166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(1164);
				identityOption();
				}
				break;
			case 2:
				{
				setState(1165);
				defaultsOption();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelfrefColumnSpecificationContext extends ParserRuleContext {
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public ReferenceGenerationContext referenceGeneration() {
			return getRuleContext(ReferenceGenerationContext.class,0);
		}
		public SelfrefColumnSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfrefColumnSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSelfrefColumnSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfrefColumnSpecificationContext selfrefColumnSpecification() throws RecognitionException {
		SelfrefColumnSpecificationContext _localctx = new SelfrefColumnSpecificationContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_selfrefColumnSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1168);
			match(REF);
			setState(1169);
			match(IS);
			setState(1170);
			columnName();
			setState(1171);
			referenceGeneration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnOptionsContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public TerminalNode OPTIONS() { return getToken(SqlParser.OPTIONS, 0); }
		public ScopeDefinitionContext scopeDefinition() {
			return getRuleContext(ScopeDefinitionContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public DefaultOptionContext defaultOption() {
			return getRuleContext(DefaultOptionContext.class,0);
		}
		public ColumnConstraintDefinitionContext columnConstraintDefinition() {
			return getRuleContext(ColumnConstraintDefinitionContext.class,0);
		}
		public ColumnOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnOptions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitColumnOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnOptionsContext columnOptions() throws RecognitionException {
		ColumnOptionsContext _localctx = new ColumnOptionsContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_columnOptions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1173);
			columnName();
			setState(1174);
			match(WITH);
			setState(1175);
			match(OPTIONS);
			setState(1180);
			switch (_input.LA(1)) {
			case SCOPE:
				{
				setState(1176);
				scopeDefinition();
				}
				break;
			case DEFAULT:
				{
				setState(1177);
				match(DEFAULT);
				setState(1178);
				defaultOption();
				}
				break;
			case CHECK:
			case CONSTRAINT:
			case NOT:
			case PRIMARY:
			case REFERENCES:
			case UNIQUE:
				{
				setState(1179);
				columnConstraintDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultOptionContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode CURRENT_DATE() { return getToken(SqlParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SqlParser.CURRENT_TIME, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public SecondsDecimalsContext secondsDecimals() {
			return getRuleContext(SecondsDecimalsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode LOCALTIME() { return getToken(SqlParser.LOCALTIME, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(SqlParser.LOCALTIMESTAMP, 0); }
		public TerminalNode USER() { return getToken(SqlParser.USER, 0); }
		public TerminalNode CURRENT_USER() { return getToken(SqlParser.CURRENT_USER, 0); }
		public TerminalNode CURRENT_ROLE() { return getToken(SqlParser.CURRENT_ROLE, 0); }
		public TerminalNode SESSION_USER() { return getToken(SqlParser.SESSION_USER, 0); }
		public TerminalNode SYSTEM_USER() { return getToken(SqlParser.SYSTEM_USER, 0); }
		public TerminalNode CURRENT_PATH() { return getToken(SqlParser.CURRENT_PATH, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode ARRAY() { return getToken(SqlParser.ARRAY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public DefaultOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDefaultOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultOptionContext defaultOption() throws RecognitionException {
		DefaultOptionContext _localctx = new DefaultOptionContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_defaultOption);
		int _la;
		try {
			setState(1225);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case INTERVAL:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case PERIOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(1182);
				literal();
				}
				break;
			case CURRENT_DATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1183);
				match(CURRENT_DATE);
				}
				break;
			case CURRENT_TIME:
				enterOuterAlt(_localctx, 3);
				{
				setState(1184);
				match(CURRENT_TIME);
				setState(1189);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1185);
					match(LEFT_PAREN);
					setState(1186);
					secondsDecimals();
					setState(1187);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LOCALTIME:
				enterOuterAlt(_localctx, 4);
				{
				setState(1191);
				match(LOCALTIME);
				setState(1196);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1192);
					match(LEFT_PAREN);
					setState(1193);
					secondsDecimals();
					setState(1194);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 5);
				{
				setState(1198);
				match(CURRENT_TIMESTAMP);
				setState(1203);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1199);
					match(LEFT_PAREN);
					setState(1200);
					secondsDecimals();
					setState(1201);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LOCALTIMESTAMP:
				enterOuterAlt(_localctx, 6);
				{
				setState(1205);
				match(LOCALTIMESTAMP);
				setState(1210);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1206);
					match(LEFT_PAREN);
					setState(1207);
					secondsDecimals();
					setState(1208);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case USER:
				enterOuterAlt(_localctx, 7);
				{
				setState(1212);
				match(USER);
				}
				break;
			case CURRENT_USER:
				enterOuterAlt(_localctx, 8);
				{
				setState(1213);
				match(CURRENT_USER);
				}
				break;
			case CURRENT_ROLE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1214);
				match(CURRENT_ROLE);
				}
				break;
			case SESSION_USER:
				enterOuterAlt(_localctx, 10);
				{
				setState(1215);
				match(SESSION_USER);
				}
				break;
			case SYSTEM_USER:
				enterOuterAlt(_localctx, 11);
				{
				setState(1216);
				match(SYSTEM_USER);
				}
				break;
			case CURRENT_PATH:
				enterOuterAlt(_localctx, 12);
				{
				setState(1217);
				match(CURRENT_PATH);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 13);
				{
				setState(1218);
				match(NULL);
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 14);
				{
				setState(1219);
				match(ARRAY);
				setState(1220);
				match(LEFT_BRACKET);
				setState(1221);
				match(RIGHT_BRACKET);
				}
				break;
			case MULTISET:
				enterOuterAlt(_localctx, 15);
				{
				setState(1222);
				match(MULTISET);
				setState(1223);
				match(LEFT_BRACKET);
				setState(1224);
				match(RIGHT_BRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenerationClauseContext extends ParserRuleContext {
		public TerminalNode GENERATED() { return getToken(SqlParser.GENERATED, 0); }
		public TerminalNode ALWAYS() { return getToken(SqlParser.ALWAYS, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public GenerationClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generationClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGenerationClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenerationClauseContext generationClause() throws RecognitionException {
		GenerationClauseContext _localctx = new GenerationClauseContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_generationClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1227);
			match(GENERATED);
			setState(1228);
			match(ALWAYS);
			setState(1229);
			match(AS);
			setState(1230);
			match(LEFT_PAREN);
			setState(1231);
			valueExpression();
			setState(1232);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnConstraintDefinitionContext extends ParserRuleContext {
		public ColumnConstraintContext columnConstraint() {
			return getRuleContext(ColumnConstraintContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(SqlParser.CONSTRAINT, 0); }
		public ConstraintNameContext constraintName() {
			return getRuleContext(ConstraintNameContext.class,0);
		}
		public ConstraintCharacteristicsContext constraintCharacteristics() {
			return getRuleContext(ConstraintCharacteristicsContext.class,0);
		}
		public ColumnConstraintDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraintDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitColumnConstraintDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintDefinitionContext columnConstraintDefinition() throws RecognitionException {
		ColumnConstraintDefinitionContext _localctx = new ColumnConstraintDefinitionContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_columnConstraintDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1236);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(1234);
				match(CONSTRAINT);
				setState(1235);
				constraintName();
				}
			}

			setState(1238);
			columnConstraint();
			setState(1240);
			_la = _input.LA(1);
			if (_la==DEFERRABLE || _la==INITIALLY || _la==NOT) {
				{
				setState(1239);
				constraintCharacteristics();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableConstraintContext extends ParserRuleContext {
		public TerminalNode UNIQUE() { return getToken(SqlParser.UNIQUE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode PRIMARY() { return getToken(SqlParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(SqlParser.KEY, 0); }
		public TerminalNode FOREIGN() { return getToken(SqlParser.FOREIGN, 0); }
		public ReferencesSpecificationContext referencesSpecification() {
			return getRuleContext(ReferencesSpecificationContext.class,0);
		}
		public TerminalNode CHECK() { return getToken(SqlParser.CHECK, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public TableConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableConstraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableConstraintContext tableConstraint() throws RecognitionException {
		TableConstraintContext _localctx = new TableConstraintContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_tableConstraint);
		int _la;
		try {
			setState(1286);
			switch (_input.LA(1)) {
			case UNIQUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1242);
				match(UNIQUE);
				setState(1243);
				match(LEFT_PAREN);
				setState(1244);
				columnName();
				setState(1249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1245);
					match(COMMA);
					setState(1246);
					columnName();
					}
					}
					setState(1251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1252);
				match(RIGHT_PAREN);
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(1254);
				match(PRIMARY);
				setState(1255);
				match(KEY);
				setState(1256);
				match(LEFT_PAREN);
				setState(1257);
				columnName();
				setState(1262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1258);
					match(COMMA);
					setState(1259);
					columnName();
					}
					}
					setState(1264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1265);
				match(RIGHT_PAREN);
				}
				break;
			case FOREIGN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1267);
				match(FOREIGN);
				setState(1268);
				match(KEY);
				setState(1269);
				match(LEFT_PAREN);
				setState(1270);
				columnName();
				setState(1275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1271);
					match(COMMA);
					setState(1272);
					columnName();
					}
					}
					setState(1277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1278);
				match(RIGHT_PAREN);
				setState(1279);
				referencesSpecification();
				}
				break;
			case CHECK:
				enterOuterAlt(_localctx, 4);
				{
				setState(1281);
				match(CHECK);
				setState(1282);
				match(LEFT_PAREN);
				setState(1283);
				booleanValueExpression(0);
				setState(1284);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintCharacteristicsContext extends ParserRuleContext {
		public ConstraintCheckTimeContext constraintCheckTime() {
			return getRuleContext(ConstraintCheckTimeContext.class,0);
		}
		public DeferrabilityContext deferrability() {
			return getRuleContext(DeferrabilityContext.class,0);
		}
		public ConstraintCharacteristicsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintCharacteristics; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitConstraintCharacteristics(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintCharacteristicsContext constraintCharacteristics() throws RecognitionException {
		ConstraintCharacteristicsContext _localctx = new ConstraintCharacteristicsContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_constraintCharacteristics);
		int _la;
		try {
			setState(1296);
			switch (_input.LA(1)) {
			case INITIALLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(1288);
				constraintCheckTime();
				setState(1290);
				_la = _input.LA(1);
				if (_la==DEFERRABLE || _la==NOT) {
					{
					setState(1289);
					deferrability();
					}
				}

				}
				break;
			case DEFERRABLE:
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1292);
				deferrability();
				setState(1294);
				_la = _input.LA(1);
				if (_la==INITIALLY) {
					{
					setState(1293);
					constraintCheckTime();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnConstraintContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode UNIQUE() { return getToken(SqlParser.UNIQUE, 0); }
		public TerminalNode VALUE() { return getToken(SqlParser.VALUE, 0); }
		public TerminalNode PRIMARY() { return getToken(SqlParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(SqlParser.KEY, 0); }
		public TerminalNode REFERENCES() { return getToken(SqlParser.REFERENCES, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode MATCH() { return getToken(SqlParser.MATCH, 0); }
		public MatchContext match() {
			return getRuleContext(MatchContext.class,0);
		}
		public ReferentialTriggeredActionContext referentialTriggeredAction() {
			return getRuleContext(ReferentialTriggeredActionContext.class,0);
		}
		public TerminalNode CHECK() { return getToken(SqlParser.CHECK, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitColumnConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_columnConstraint);
		int _la;
		try {
			setState(1323);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1298);
				match(NOT);
				setState(1299);
				match(NULL);
				}
				break;
			case UNIQUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1300);
				match(UNIQUE);
				setState(1302);
				_la = _input.LA(1);
				if (_la==VALUE) {
					{
					setState(1301);
					match(VALUE);
					}
				}

				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 3);
				{
				setState(1304);
				match(PRIMARY);
				setState(1305);
				match(KEY);
				}
				break;
			case REFERENCES:
				enterOuterAlt(_localctx, 4);
				{
				setState(1306);
				match(REFERENCES);
				setState(1307);
				tableName();
				setState(1308);
				match(LEFT_PAREN);
				setState(1309);
				columnName();
				setState(1310);
				match(RIGHT_PAREN);
				setState(1313);
				_la = _input.LA(1);
				if (_la==MATCH) {
					{
					setState(1311);
					match(MATCH);
					setState(1312);
					match();
					}
				}

				setState(1316);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1315);
					referentialTriggeredAction();
					}
				}

				}
				break;
			case CHECK:
				enterOuterAlt(_localctx, 5);
				{
				setState(1318);
				match(CHECK);
				setState(1319);
				match(LEFT_PAREN);
				setState(1320);
				booleanValueExpression(0);
				setState(1321);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferencesSpecificationContext extends ParserRuleContext {
		public TerminalNode REFERENCES() { return getToken(SqlParser.REFERENCES, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode MATCH() { return getToken(SqlParser.MATCH, 0); }
		public MatchContext match() {
			return getRuleContext(MatchContext.class,0);
		}
		public ReferentialTriggeredActionContext referentialTriggeredAction() {
			return getRuleContext(ReferentialTriggeredActionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public ReferencesSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referencesSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferencesSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferencesSpecificationContext referencesSpecification() throws RecognitionException {
		ReferencesSpecificationContext _localctx = new ReferencesSpecificationContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_referencesSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1325);
			match(REFERENCES);
			setState(1326);
			tableName();
			setState(1338);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1327);
				match(LEFT_PAREN);
				setState(1328);
				columnName();
				setState(1333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1329);
					match(COMMA);
					setState(1330);
					columnName();
					}
					}
					setState(1335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1336);
				match(RIGHT_PAREN);
				}
			}

			setState(1342);
			_la = _input.LA(1);
			if (_la==MATCH) {
				{
				setState(1340);
				match(MATCH);
				setState(1341);
				match();
				}
			}

			setState(1345);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1344);
				referentialTriggeredAction();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferentialTriggeredActionContext extends ParserRuleContext {
		public UpdateActionContext updateAction() {
			return getRuleContext(UpdateActionContext.class,0);
		}
		public DeleteActionContext deleteAction() {
			return getRuleContext(DeleteActionContext.class,0);
		}
		public ReferentialTriggeredActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referentialTriggeredAction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferentialTriggeredAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferentialTriggeredActionContext referentialTriggeredAction() throws RecognitionException {
		ReferentialTriggeredActionContext _localctx = new ReferentialTriggeredActionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_referentialTriggeredAction);
		int _la;
		try {
			setState(1355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1347);
				updateAction();
				setState(1349);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1348);
					deleteAction();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1351);
				deleteAction();
				setState(1353);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1352);
					updateAction();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateActionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public TerminalNode UPDATE() { return getToken(SqlParser.UPDATE, 0); }
		public ReferentialActionContext referentialAction() {
			return getRuleContext(ReferentialActionContext.class,0);
		}
		public UpdateActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateAction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUpdateAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateActionContext updateAction() throws RecognitionException {
		UpdateActionContext _localctx = new UpdateActionContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_updateAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1357);
			match(ON);
			setState(1358);
			match(UPDATE);
			setState(1359);
			referentialAction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteActionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public TerminalNode DELETE() { return getToken(SqlParser.DELETE, 0); }
		public ReferentialActionContext referentialAction() {
			return getRuleContext(ReferentialActionContext.class,0);
		}
		public DeleteActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteAction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDeleteAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteActionContext deleteAction() throws RecognitionException {
		DeleteActionContext _localctx = new DeleteActionContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_deleteAction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1361);
			match(ON);
			setState(1362);
			match(DELETE);
			setState(1363);
			referentialAction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultisetTypeContext extends DataTypeContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public MultisetTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowTypeContext extends DataTypeContext {
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<FieldDefinitionContext> fieldDefinition() {
			return getRuleContexts(FieldDefinitionContext.class);
		}
		public FieldDefinitionContext fieldDefinition(int i) {
			return getRuleContext(FieldDefinitionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public RowTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRowType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayTypeContext extends DataTypeContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ARRAY() { return getToken(SqlParser.ARRAY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public ArrayTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PreTypeContext extends DataTypeContext {
		public PredefinedTypeContext predefinedType() {
			return getRuleContext(PredefinedTypeContext.class,0);
		}
		public PreTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPreType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructTypeContext extends DataTypeContext {
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public StructTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefTypeContext extends DataTypeContext {
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ScopeDefinitionContext scopeDefinition() {
			return getRuleContext(ScopeDefinitionContext.class,0);
		}
		public RefTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		return dataType(0);
	}

	private DataTypeContext dataType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DataTypeContext _localctx = new DataTypeContext(_ctx, _parentState);
		DataTypeContext _prevctx = _localctx;
		int _startState = 222;
		enterRecursionRule(_localctx, 222, RULE_dataType, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1387);
			switch (_input.LA(1)) {
			case BIGINT:
			case BINARY:
			case BLOB:
			case BOOLEAN:
			case CHAR:
			case CHARACTER:
			case CLOB:
			case DATE:
			case DEC:
			case DECIMAL:
			case DOUBLE:
			case FLOAT:
			case INT:
			case INTEGER:
			case INTERVAL:
			case NATIONAL:
			case NCHAR:
			case NCLOB:
			case NUMERIC:
			case REAL:
			case SMALLINT:
			case TIME:
			case TIMESTAMP:
			case VARBINARY:
			case VARCHAR:
			case XML:
				{
				_localctx = new PreTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1366);
				predefinedType();
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new StructTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1367);
				udtName();
				}
				break;
			case ROW:
				{
				_localctx = new RowTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1368);
				match(ROW);
				setState(1369);
				match(LEFT_PAREN);
				setState(1370);
				fieldDefinition();
				setState(1375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1371);
					match(COMMA);
					setState(1372);
					fieldDefinition();
					}
					}
					setState(1377);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1378);
				match(RIGHT_PAREN);
				}
				break;
			case REF:
				{
				_localctx = new RefTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1380);
				match(REF);
				setState(1381);
				match(LEFT_PAREN);
				setState(1382);
				udtName();
				setState(1383);
				match(RIGHT_PAREN);
				setState(1385);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(1384);
					scopeDefinition();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1401);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1399);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
					case 1:
						{
						_localctx = new ArrayTypeContext(new DataTypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_dataType);
						setState(1389);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1390);
						match(ARRAY);
						setState(1395);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
						case 1:
							{
							setState(1391);
							match(LEFT_BRACKET);
							setState(1392);
							length();
							setState(1393);
							match(RIGHT_BRACKET);
							}
							break;
						}
						}
						break;
					case 2:
						{
						_localctx = new MultisetTypeContext(new DataTypeContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_dataType);
						setState(1397);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1398);
						match(MULTISET);
						}
						break;
					}
					} 
				}
				setState(1403);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ReferenceTypeContext extends ParserRuleContext {
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ScopeDefinitionContext scopeDefinition() {
			return getRuleContext(ScopeDefinitionContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_referenceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1404);
			match(REF);
			setState(1405);
			match(LEFT_PAREN);
			setState(1406);
			udtName();
			setState(1407);
			match(RIGHT_PAREN);
			setState(1409);
			_la = _input.LA(1);
			if (_la==SCOPE) {
				{
				setState(1408);
				scopeDefinition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScopeDefinitionContext extends ParserRuleContext {
		public TerminalNode SCOPE() { return getToken(SqlParser.SCOPE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ScopeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitScopeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeDefinitionContext scopeDefinition() throws RecognitionException {
		ScopeDefinitionContext _localctx = new ScopeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_scopeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1411);
			match(SCOPE);
			setState(1412);
			tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDefinitionContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ReferenceScopeCheckContext referenceScopeCheck() {
			return getRuleContext(ReferenceScopeCheckContext.class,0);
		}
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public TerminalNode DELETE() { return getToken(SqlParser.DELETE, 0); }
		public ReferentialActionContext referentialAction() {
			return getRuleContext(ReferentialActionContext.class,0);
		}
		public FieldDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFieldDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefinitionContext fieldDefinition() throws RecognitionException {
		FieldDefinitionContext _localctx = new FieldDefinitionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_fieldDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1414);
			fieldName();
			setState(1415);
			dataType(0);
			setState(1417);
			_la = _input.LA(1);
			if (_la==REFERENCES) {
				{
				setState(1416);
				referenceScopeCheck();
				}
			}

			setState(1422);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1419);
				match(ON);
				setState(1420);
				match(DELETE);
				setState(1421);
				referentialAction();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredefinedTypeContext extends ParserRuleContext {
		public CharTypeContext charType() {
			return getRuleContext(CharTypeContext.class,0);
		}
		public VarcharTypeContext varcharType() {
			return getRuleContext(VarcharTypeContext.class,0);
		}
		public ClobTypeContext clobType() {
			return getRuleContext(ClobTypeContext.class,0);
		}
		public NcharTypeContext ncharType() {
			return getRuleContext(NcharTypeContext.class,0);
		}
		public NvarcharTypeContext nvarcharType() {
			return getRuleContext(NvarcharTypeContext.class,0);
		}
		public NclobTypeContext nclobType() {
			return getRuleContext(NclobTypeContext.class,0);
		}
		public XmlTypeContext xmlType() {
			return getRuleContext(XmlTypeContext.class,0);
		}
		public VarbinaryTypeContext varbinaryType() {
			return getRuleContext(VarbinaryTypeContext.class,0);
		}
		public BinaryTypeContext binaryType() {
			return getRuleContext(BinaryTypeContext.class,0);
		}
		public BlobTypeContext blobType() {
			return getRuleContext(BlobTypeContext.class,0);
		}
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public DecimalTypeContext decimalType() {
			return getRuleContext(DecimalTypeContext.class,0);
		}
		public SmallintTypeContext smallintType() {
			return getRuleContext(SmallintTypeContext.class,0);
		}
		public IntegerTypeContext integerType() {
			return getRuleContext(IntegerTypeContext.class,0);
		}
		public BigintTypeContext bigintType() {
			return getRuleContext(BigintTypeContext.class,0);
		}
		public FloatTypeContext floatType() {
			return getRuleContext(FloatTypeContext.class,0);
		}
		public RealTypeContext realType() {
			return getRuleContext(RealTypeContext.class,0);
		}
		public DoubleTypeContext doubleType() {
			return getRuleContext(DoubleTypeContext.class,0);
		}
		public BooleanTypeContext booleanType() {
			return getRuleContext(BooleanTypeContext.class,0);
		}
		public DateTypeContext dateType() {
			return getRuleContext(DateTypeContext.class,0);
		}
		public TimeTypeContext timeType() {
			return getRuleContext(TimeTypeContext.class,0);
		}
		public TimestampTypeContext timestampType() {
			return getRuleContext(TimestampTypeContext.class,0);
		}
		public IntervalTypeContext intervalType() {
			return getRuleContext(IntervalTypeContext.class,0);
		}
		public PredefinedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefinedType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPredefinedType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredefinedTypeContext predefinedType() throws RecognitionException {
		PredefinedTypeContext _localctx = new PredefinedTypeContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_predefinedType);
		try {
			setState(1447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1424);
				charType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1425);
				varcharType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1426);
				clobType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1427);
				ncharType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1428);
				nvarcharType();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1429);
				nclobType();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1430);
				xmlType();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1431);
				varbinaryType();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1432);
				binaryType();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1433);
				blobType();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1434);
				numericType();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1435);
				decimalType();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1436);
				smallintType();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1437);
				integerType();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1438);
				bigintType();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1439);
				floatType();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1440);
				realType();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1441);
				doubleType();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1442);
				booleanType();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(1443);
				dateType();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(1444);
				timeType();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(1445);
				timestampType();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(1446);
				intervalType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CharTypeContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(SqlParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(SqlParser.CHAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public CharTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharTypeContext charType() throws RecognitionException {
		CharTypeContext _localctx = new CharTypeContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_charType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1449);
			_la = _input.LA(1);
			if ( !(_la==CHAR || _la==CHARACTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(1454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(1450);
				match(LEFT_PAREN);
				setState(1451);
				length();
				setState(1452);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarcharTypeContext extends ParserRuleContext {
		public TerminalNode VARYING() { return getToken(SqlParser.VARYING, 0); }
		public TerminalNode VARCHAR() { return getToken(SqlParser.VARCHAR, 0); }
		public TerminalNode CHARACTER() { return getToken(SqlParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(SqlParser.CHAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public VarcharTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varcharType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitVarcharType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarcharTypeContext varcharType() throws RecognitionException {
		VarcharTypeContext _localctx = new VarcharTypeContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_varcharType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1459);
			switch (_input.LA(1)) {
			case CHAR:
			case CHARACTER:
				{
				setState(1456);
				_la = _input.LA(1);
				if ( !(_la==CHAR || _la==CHARACTER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1457);
				match(VARYING);
				}
				break;
			case VARCHAR:
				{
				setState(1458);
				match(VARCHAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(1461);
				match(LEFT_PAREN);
				setState(1462);
				length();
				setState(1463);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClobTypeContext extends ParserRuleContext {
		public TerminalNode LARGE() { return getToken(SqlParser.LARGE, 0); }
		public TerminalNode OBJECT() { return getToken(SqlParser.OBJECT, 0); }
		public TerminalNode CLOB() { return getToken(SqlParser.CLOB, 0); }
		public TerminalNode CHARACTER() { return getToken(SqlParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(SqlParser.CHAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LobLengthContext lobLength() {
			return getRuleContext(LobLengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ClobTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clobType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitClobType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClobTypeContext clobType() throws RecognitionException {
		ClobTypeContext _localctx = new ClobTypeContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_clobType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1471);
			switch (_input.LA(1)) {
			case CHAR:
			case CHARACTER:
				{
				setState(1467);
				_la = _input.LA(1);
				if ( !(_la==CHAR || _la==CHARACTER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1468);
				match(LARGE);
				setState(1469);
				match(OBJECT);
				}
				break;
			case CLOB:
				{
				setState(1470);
				match(CLOB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(1473);
				match(LEFT_PAREN);
				setState(1474);
				lobLength();
				setState(1475);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NcharTypeContext extends ParserRuleContext {
		public TerminalNode NATIONAL() { return getToken(SqlParser.NATIONAL, 0); }
		public TerminalNode NCHAR() { return getToken(SqlParser.NCHAR, 0); }
		public TerminalNode CHARACTER() { return getToken(SqlParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(SqlParser.CHAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public NcharTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ncharType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNcharType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NcharTypeContext ncharType() throws RecognitionException {
		NcharTypeContext _localctx = new NcharTypeContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_ncharType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1482);
			switch (_input.LA(1)) {
			case NATIONAL:
				{
				setState(1479);
				match(NATIONAL);
				setState(1480);
				_la = _input.LA(1);
				if ( !(_la==CHAR || _la==CHARACTER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case NCHAR:
				{
				setState(1481);
				match(NCHAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(1484);
				match(LEFT_PAREN);
				setState(1485);
				length();
				setState(1486);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NvarcharTypeContext extends ParserRuleContext {
		public TerminalNode NATIONAL() { return getToken(SqlParser.NATIONAL, 0); }
		public TerminalNode VARYING() { return getToken(SqlParser.VARYING, 0); }
		public TerminalNode NCHAR() { return getToken(SqlParser.NCHAR, 0); }
		public TerminalNode CHARACTER() { return getToken(SqlParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(SqlParser.CHAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public NvarcharTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nvarcharType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNvarcharType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NvarcharTypeContext nvarcharType() throws RecognitionException {
		NvarcharTypeContext _localctx = new NvarcharTypeContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_nvarcharType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1495);
			switch (_input.LA(1)) {
			case NATIONAL:
				{
				setState(1490);
				match(NATIONAL);
				setState(1491);
				_la = _input.LA(1);
				if ( !(_la==CHAR || _la==CHARACTER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1492);
				match(VARYING);
				}
				break;
			case NCHAR:
				{
				setState(1493);
				match(NCHAR);
				setState(1494);
				match(VARYING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(1497);
				match(LEFT_PAREN);
				setState(1498);
				length();
				setState(1499);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NclobTypeContext extends ParserRuleContext {
		public TerminalNode NATIONAL() { return getToken(SqlParser.NATIONAL, 0); }
		public TerminalNode LARGE() { return getToken(SqlParser.LARGE, 0); }
		public TerminalNode OBJECT() { return getToken(SqlParser.OBJECT, 0); }
		public TerminalNode NCHAR() { return getToken(SqlParser.NCHAR, 0); }
		public TerminalNode NCLOB() { return getToken(SqlParser.NCLOB, 0); }
		public TerminalNode CHARACTER() { return getToken(SqlParser.CHARACTER, 0); }
		public TerminalNode CHAR() { return getToken(SqlParser.CHAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LobLengthContext lobLength() {
			return getRuleContext(LobLengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public NclobTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nclobType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNclobType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NclobTypeContext nclobType() throws RecognitionException {
		NclobTypeContext _localctx = new NclobTypeContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_nclobType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1511);
			switch (_input.LA(1)) {
			case NATIONAL:
				{
				setState(1503);
				match(NATIONAL);
				setState(1504);
				_la = _input.LA(1);
				if ( !(_la==CHAR || _la==CHARACTER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1505);
				match(LARGE);
				setState(1506);
				match(OBJECT);
				}
				break;
			case NCHAR:
				{
				setState(1507);
				match(NCHAR);
				setState(1508);
				match(LARGE);
				setState(1509);
				match(OBJECT);
				}
				break;
			case NCLOB:
				{
				setState(1510);
				match(NCLOB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1517);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(1513);
				match(LEFT_PAREN);
				setState(1514);
				lobLength();
				setState(1515);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XmlTypeContext extends ParserRuleContext {
		public TerminalNode XML() { return getToken(SqlParser.XML, 0); }
		public XmlTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitXmlType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlTypeContext xmlType() throws RecognitionException {
		XmlTypeContext _localctx = new XmlTypeContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_xmlType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1519);
			match(XML);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryTypeContext extends ParserRuleContext {
		public TerminalNode BINARY() { return getToken(SqlParser.BINARY, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public BinaryTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBinaryType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryTypeContext binaryType() throws RecognitionException {
		BinaryTypeContext _localctx = new BinaryTypeContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_binaryType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1521);
			match(BINARY);
			setState(1526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(1522);
				match(LEFT_PAREN);
				setState(1523);
				length();
				setState(1524);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarbinaryTypeContext extends ParserRuleContext {
		public TerminalNode BINARY() { return getToken(SqlParser.BINARY, 0); }
		public TerminalNode VARYING() { return getToken(SqlParser.VARYING, 0); }
		public TerminalNode VARBINARY() { return getToken(SqlParser.VARBINARY, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public VarbinaryTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varbinaryType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitVarbinaryType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarbinaryTypeContext varbinaryType() throws RecognitionException {
		VarbinaryTypeContext _localctx = new VarbinaryTypeContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_varbinaryType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1531);
			switch (_input.LA(1)) {
			case BINARY:
				{
				setState(1528);
				match(BINARY);
				setState(1529);
				match(VARYING);
				}
				break;
			case VARBINARY:
				{
				setState(1530);
				match(VARBINARY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1537);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(1533);
				match(LEFT_PAREN);
				setState(1534);
				length();
				setState(1535);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlobTypeContext extends ParserRuleContext {
		public TerminalNode BINARY() { return getToken(SqlParser.BINARY, 0); }
		public TerminalNode LARGE() { return getToken(SqlParser.LARGE, 0); }
		public TerminalNode OBJECT() { return getToken(SqlParser.OBJECT, 0); }
		public TerminalNode BLOB() { return getToken(SqlParser.BLOB, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public LobLengthContext lobLength() {
			return getRuleContext(LobLengthContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public BlobTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blobType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBlobType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlobTypeContext blobType() throws RecognitionException {
		BlobTypeContext _localctx = new BlobTypeContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_blobType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1543);
			switch (_input.LA(1)) {
			case BINARY:
				{
				setState(1539);
				match(BINARY);
				setState(1540);
				match(LARGE);
				setState(1541);
				match(OBJECT);
				}
				break;
			case BLOB:
				{
				setState(1542);
				match(BLOB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(1545);
				match(LEFT_PAREN);
				setState(1546);
				lobLength();
				setState(1547);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericTypeContext extends ParserRuleContext {
		public TerminalNode NUMERIC() { return getToken(SqlParser.NUMERIC, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(SqlParser.COMMA, 0); }
		public ScaleContext scale() {
			return getRuleContext(ScaleContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNumericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_numericType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1551);
			match(NUMERIC);
			setState(1560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				{
				setState(1552);
				match(LEFT_PAREN);
				setState(1553);
				precision();
				setState(1556);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1554);
					match(COMMA);
					setState(1555);
					scale();
					}
				}

				setState(1558);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalTypeContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(SqlParser.DECIMAL, 0); }
		public TerminalNode DEC() { return getToken(SqlParser.DEC, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(SqlParser.COMMA, 0); }
		public ScaleContext scale() {
			return getRuleContext(ScaleContext.class,0);
		}
		public DecimalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimalType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDecimalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalTypeContext decimalType() throws RecognitionException {
		DecimalTypeContext _localctx = new DecimalTypeContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_decimalType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1562);
			_la = _input.LA(1);
			if ( !(_la==DEC || _la==DECIMAL) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(1571);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
			case 1:
				{
				setState(1563);
				match(LEFT_PAREN);
				setState(1564);
				precision();
				setState(1567);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1565);
					match(COMMA);
					setState(1566);
					scale();
					}
				}

				setState(1569);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SmallintTypeContext extends ParserRuleContext {
		public TerminalNode SMALLINT() { return getToken(SqlParser.SMALLINT, 0); }
		public SmallintTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_smallintType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSmallintType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SmallintTypeContext smallintType() throws RecognitionException {
		SmallintTypeContext _localctx = new SmallintTypeContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_smallintType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1573);
			match(SMALLINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerTypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(SqlParser.INTEGER, 0); }
		public TerminalNode INT() { return getToken(SqlParser.INT, 0); }
		public IntegerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIntegerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerTypeContext integerType() throws RecognitionException {
		IntegerTypeContext _localctx = new IntegerTypeContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_integerType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BigintTypeContext extends ParserRuleContext {
		public TerminalNode BIGINT() { return getToken(SqlParser.BIGINT, 0); }
		public BigintTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bigintType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBigintType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BigintTypeContext bigintType() throws RecognitionException {
		BigintTypeContext _localctx = new BigintTypeContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_bigintType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1577);
			match(BIGINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatTypeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SqlParser.FLOAT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public FloatTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatTypeContext floatType() throws RecognitionException {
		FloatTypeContext _localctx = new FloatTypeContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_floatType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1579);
			match(FLOAT);
			setState(1584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				setState(1580);
				match(LEFT_PAREN);
				setState(1581);
				precision();
				setState(1582);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RealTypeContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(SqlParser.REAL, 0); }
		public RealTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRealType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RealTypeContext realType() throws RecognitionException {
		RealTypeContext _localctx = new RealTypeContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_realType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1586);
			match(REAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoubleTypeContext extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(SqlParser.DOUBLE, 0); }
		public TerminalNode PRECISION() { return getToken(SqlParser.PRECISION, 0); }
		public DoubleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDoubleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleTypeContext doubleType() throws RecognitionException {
		DoubleTypeContext _localctx = new DoubleTypeContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_doubleType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1588);
			match(DOUBLE);
			setState(1589);
			match(PRECISION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(SqlParser.BOOLEAN, 0); }
		public BooleanTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanTypeContext booleanType() throws RecognitionException {
		BooleanTypeContext _localctx = new BooleanTypeContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_booleanType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1591);
			match(BOOLEAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateTypeContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(SqlParser.DATE, 0); }
		public DateTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDateType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateTypeContext dateType() throws RecognitionException {
		DateTypeContext _localctx = new DateTypeContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_dateType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1593);
			match(DATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeTypeContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(SqlParser.TIME, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public SecondsDecimalsContext secondsDecimals() {
			return getRuleContext(SecondsDecimalsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public WithOrWithoutTimeZoneContext withOrWithoutTimeZone() {
			return getRuleContext(WithOrWithoutTimeZoneContext.class,0);
		}
		public TimeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTimeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeTypeContext timeType() throws RecognitionException {
		TimeTypeContext _localctx = new TimeTypeContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_timeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1595);
			match(TIME);
			setState(1600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				{
				setState(1596);
				match(LEFT_PAREN);
				setState(1597);
				secondsDecimals();
				setState(1598);
				match(RIGHT_PAREN);
				}
				break;
			}
			setState(1603);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				{
				setState(1602);
				withOrWithoutTimeZone();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimestampTypeContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(SqlParser.TIMESTAMP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public SecondsDecimalsContext secondsDecimals() {
			return getRuleContext(SecondsDecimalsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public WithOrWithoutTimeZoneContext withOrWithoutTimeZone() {
			return getRuleContext(WithOrWithoutTimeZoneContext.class,0);
		}
		public TimestampTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestampType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTimestampType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimestampTypeContext timestampType() throws RecognitionException {
		TimestampTypeContext _localctx = new TimestampTypeContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_timestampType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1605);
			match(TIMESTAMP);
			setState(1610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(1606);
				match(LEFT_PAREN);
				setState(1607);
				secondsDecimals();
				setState(1608);
				match(RIGHT_PAREN);
				}
				break;
			}
			setState(1613);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(1612);
				withOrWithoutTimeZone();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalTypeContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(SqlParser.INTERVAL, 0); }
		public IntervalQualifierContext intervalQualifier() {
			return getRuleContext(IntervalQualifierContext.class,0);
		}
		public IntervalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIntervalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalTypeContext intervalType() throws RecognitionException {
		IntervalTypeContext _localctx = new IntervalTypeContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_intervalType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1615);
			match(INTERVAL);
			setState(1616);
			intervalQualifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalQualifierContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(SqlParser.YEAR, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SqlParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SqlParser.LEFT_PAREN, i);
		}
		public PrecisionContext precision() {
			return getRuleContext(PrecisionContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SqlParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SqlParser.RIGHT_PAREN, i);
		}
		public TerminalNode TO() { return getToken(SqlParser.TO, 0); }
		public TerminalNode MONTH() { return getToken(SqlParser.MONTH, 0); }
		public TerminalNode DAY() { return getToken(SqlParser.DAY, 0); }
		public TerminalNode HOUR() { return getToken(SqlParser.HOUR, 0); }
		public TerminalNode MINUTE() { return getToken(SqlParser.MINUTE, 0); }
		public TerminalNode SECOND() { return getToken(SqlParser.SECOND, 0); }
		public SecondsDecimalsContext secondsDecimals() {
			return getRuleContext(SecondsDecimalsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SqlParser.COMMA, 0); }
		public IntervalQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalQualifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIntervalQualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalQualifierContext intervalQualifier() throws RecognitionException {
		IntervalQualifierContext _localctx = new IntervalQualifierContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_intervalQualifier);
		try {
			setState(1703);
			switch (_input.LA(1)) {
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1618);
				match(YEAR);
				setState(1623);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(1619);
					match(LEFT_PAREN);
					setState(1620);
					precision();
					setState(1621);
					match(RIGHT_PAREN);
					}
					break;
				}
				setState(1627);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
				case 1:
					{
					setState(1625);
					match(TO);
					setState(1626);
					match(MONTH);
					}
					break;
				}
				}
				break;
			case MONTH:
				enterOuterAlt(_localctx, 2);
				{
				setState(1629);
				match(MONTH);
				setState(1634);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(1630);
					match(LEFT_PAREN);
					setState(1631);
					precision();
					setState(1632);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case DAY:
				enterOuterAlt(_localctx, 3);
				{
				setState(1636);
				match(DAY);
				setState(1641);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(1637);
					match(LEFT_PAREN);
					setState(1638);
					precision();
					setState(1639);
					match(RIGHT_PAREN);
					}
					break;
				}
				setState(1655);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
				case 1:
					{
					setState(1643);
					match(TO);
					setState(1644);
					match(HOUR);
					}
					break;
				case 2:
					{
					setState(1645);
					match(TO);
					setState(1646);
					match(MINUTE);
					}
					break;
				case 3:
					{
					setState(1647);
					match(TO);
					setState(1648);
					match(SECOND);
					setState(1653);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
					case 1:
						{
						setState(1649);
						match(LEFT_PAREN);
						setState(1650);
						secondsDecimals();
						setState(1651);
						match(RIGHT_PAREN);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case HOUR:
				enterOuterAlt(_localctx, 4);
				{
				setState(1657);
				match(HOUR);
				setState(1662);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
				case 1:
					{
					setState(1658);
					match(LEFT_PAREN);
					setState(1659);
					precision();
					setState(1660);
					match(RIGHT_PAREN);
					}
					break;
				}
				setState(1674);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
				case 1:
					{
					setState(1664);
					match(TO);
					setState(1665);
					match(MINUTE);
					}
					break;
				case 2:
					{
					setState(1666);
					match(TO);
					setState(1667);
					match(SECOND);
					setState(1672);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
					case 1:
						{
						setState(1668);
						match(LEFT_PAREN);
						setState(1669);
						secondsDecimals();
						setState(1670);
						match(RIGHT_PAREN);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case MINUTE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1676);
				match(MINUTE);
				setState(1681);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
				case 1:
					{
					setState(1677);
					match(LEFT_PAREN);
					setState(1678);
					precision();
					setState(1679);
					match(RIGHT_PAREN);
					}
					break;
				}
				setState(1691);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
				case 1:
					{
					setState(1683);
					match(TO);
					setState(1684);
					match(SECOND);
					setState(1689);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,124,_ctx) ) {
					case 1:
						{
						setState(1685);
						match(LEFT_PAREN);
						setState(1686);
						secondsDecimals();
						setState(1687);
						match(RIGHT_PAREN);
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 6);
				{
				setState(1693);
				match(SECOND);
				setState(1701);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
				case 1:
					{
					setState(1694);
					match(LEFT_PAREN);
					setState(1695);
					precision();
					{
					setState(1696);
					match(COMMA);
					setState(1697);
					secondsDecimals();
					}
					setState(1699);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LobLengthContext extends ParserRuleContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public MultiplierContext multiplier() {
			return getRuleContext(MultiplierContext.class,0);
		}
		public LobLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lobLength; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLobLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LobLengthContext lobLength() throws RecognitionException {
		LobLengthContext _localctx = new LobLengthContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_lobLength);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1705);
			length();
			setState(1707);
			_la = _input.LA(1);
			if (((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (G - 134)) | (1L << (K - 134)) | (1L << (M - 134)))) != 0)) {
				{
				setState(1706);
				multiplier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SecondsDecimalsContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_INTEGER() { return getToken(SqlParser.UNSIGNED_INTEGER, 0); }
		public SecondsDecimalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondsDecimals; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSecondsDecimals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SecondsDecimalsContext secondsDecimals() throws RecognitionException {
		SecondsDecimalsContext _localctx = new SecondsDecimalsContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_secondsDecimals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1709);
			match(UNSIGNED_INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrecisionContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_INTEGER() { return getToken(SqlParser.UNSIGNED_INTEGER, 0); }
		public PrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPrecision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecisionContext precision() throws RecognitionException {
		PrecisionContext _localctx = new PrecisionContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_precision);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1711);
			match(UNSIGNED_INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScaleContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_INTEGER() { return getToken(SqlParser.UNSIGNED_INTEGER, 0); }
		public ScaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scale; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitScale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScaleContext scale() throws RecognitionException {
		ScaleContext _localctx = new ScaleContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_scale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1713);
			match(UNSIGNED_INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LengthContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_INTEGER() { return getToken(SqlParser.UNSIGNED_INTEGER, 0); }
		public LengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthContext length() throws RecognitionException {
		LengthContext _localctx = new LengthContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1715);
			match(UNSIGNED_INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SqlParser.SELECT, 0); }
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public WindowClauseContext windowClause() {
			return getRuleContext(WindowClauseContext.class,0);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1717);
			match(SELECT);
			setState(1719);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1718);
				setQuantifier();
				}
			}

			setState(1721);
			selectList();
			setState(1722);
			fromClause();
			setState(1724);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				{
				setState(1723);
				whereClause();
				}
				break;
			}
			setState(1727);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				{
				setState(1726);
				groupByClause();
				}
				break;
			}
			setState(1730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				{
				setState(1729);
				havingClause();
				}
				break;
			}
			setState(1733);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(1732);
				windowClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectListContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(SqlParser.ASTERISK, 0); }
		public List<SelectSublistContext> selectSublist() {
			return getRuleContexts(SelectSublistContext.class);
		}
		public SelectSublistContext selectSublist(int i) {
			return getRuleContext(SelectSublistContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSelectList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_selectList);
		int _la;
		try {
			setState(1744);
			switch (_input.LA(1)) {
			case ASTERISK:
				enterOuterAlt(_localctx, 1);
				{
				setState(1735);
				match(ASTERISK);
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case ABS:
			case ANY:
			case ARRAY:
			case AVG:
			case CARDINALITY:
			case CASE:
			case CAST:
			case CEIL:
			case CEILING:
			case CHARACTER_LENGTH:
			case CHAR_LENGTH:
			case COALESCE:
			case COLLECT:
			case COVAR_POP:
			case COVAR_SAMP:
			case COUNT:
			case CUME_DIST:
			case CURRENT_DATE:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case CURRENT_USER:
			case DENSE_RANK:
			case DEREF:
			case ELEMENT:
			case EVERY:
			case EXISTS:
			case EXP:
			case EXTRACT:
			case FLOOR:
			case FUSION:
			case GROUPING:
			case INTERSECTION:
			case INTERVAL:
			case LN:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case LOWER:
			case MAX:
			case MIN:
			case MOD:
			case MULTISET:
			case NEW:
			case NEXT:
			case NORMALIZE:
			case NOT:
			case NULLIF:
			case OCTET_LENGTH:
			case PERCENT_RANK:
			case PERCENTILE_CONT:
			case PERCENTILE_DISC:
			case POWER:
			case RANK:
			case REGR_AVGX:
			case REGR_AVGY:
			case REGR_COUNT:
			case REGR_INTERCEPT:
			case REGR_RSQUARED:
			case REGR_SLOPE:
			case REGR_SXX:
			case REGR_SXY:
			case REGR_SYY:
			case ROW:
			case ROW_NUMBER:
			case SESSION_USER:
			case SET:
			case SOME:
			case SQRT:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBSTRING:
			case SUM:
			case SYSTEM_USER:
			case TABLE:
			case TREAT:
			case TRIM:
			case UNIQUE:
			case UPPER:
			case USER:
			case VALUE:
			case VAR_POP:
			case VAR_SAMP:
			case WIDTH_BUCKET:
			case IDENTIFIER:
			case CORR:
			case POSITION:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case LEFT_PAREN:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(1736);
				selectSublist();
				setState(1741);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1737);
					match(COMMA);
					setState(1738);
					selectSublist();
					}
					}
					setState(1743);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectSublistContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(SqlParser.PERIOD, 0); }
		public TerminalNode ASTERISK() { return getToken(SqlParser.ASTERISK, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SelectSublistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectSublist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSelectSublist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectSublistContext selectSublist() throws RecognitionException {
		SelectSublistContext _localctx = new SelectSublistContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_selectSublist);
		int _la;
		try {
			setState(1772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1746);
				valueExpression();
				setState(1749);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1747);
					match(AS);
					setState(1748);
					columnName();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1751);
				identifierChain();
				setState(1752);
				match(PERIOD);
				setState(1753);
				match(ASTERISK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1755);
				valueExpression();
				setState(1756);
				match(PERIOD);
				setState(1757);
				match(ASTERISK);
				setState(1770);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1758);
					match(AS);
					setState(1759);
					match(LEFT_PAREN);
					setState(1760);
					columnName();
					setState(1765);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1761);
						match(COMMA);
						setState(1762);
						columnName();
						}
						}
						setState(1767);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1768);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public List<TableReferenceContext> tableReference() {
			return getRuleContexts(TableReferenceContext.class);
		}
		public TableReferenceContext tableReference(int i) {
			return getRuleContext(TableReferenceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_fromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1774);
			match(FROM);
			setState(1775);
			tableReference(0);
			setState(1780);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1776);
					match(COMMA);
					setState(1777);
					tableReference(0);
					}
					} 
				}
				setState(1782);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SqlParser.WHERE, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1783);
			match(WHERE);
			setState(1784);
			booleanValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(SqlParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public List<GroupingElementContext> groupingElement() {
			return getRuleContexts(GroupingElementContext.class);
		}
		public GroupingElementContext groupingElement(int i) {
			return getRuleContext(GroupingElementContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGroupByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_groupByClause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1786);
			match(GROUP);
			setState(1787);
			match(BY);
			setState(1789);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(1788);
				setQuantifier();
				}
			}

			setState(1791);
			groupingElement();
			setState(1796);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1792);
					match(COMMA);
					setState(1793);
					groupingElement();
					}
					} 
				}
				setState(1798);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HavingClauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SqlParser.HAVING, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitHavingClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1799);
			match(HAVING);
			setState(1800);
			booleanValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowClauseContext extends ParserRuleContext {
		public TerminalNode WINDOW() { return getToken(SqlParser.WINDOW, 0); }
		public List<WindowDefinitionContext> windowDefinition() {
			return getRuleContexts(WindowDefinitionContext.class);
		}
		public WindowDefinitionContext windowDefinition(int i) {
			return getRuleContext(WindowDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public WindowClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowClauseContext windowClause() throws RecognitionException {
		WindowClauseContext _localctx = new WindowClauseContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_windowClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1802);
			match(WINDOW);
			setState(1803);
			windowDefinition();
			setState(1808);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1804);
					match(COMMA);
					setState(1805);
					windowDefinition();
					}
					} 
				}
				setState(1810);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableReferenceContext extends ParserRuleContext {
		public TablePrimaryContext tablePrimary() {
			return getRuleContext(TablePrimaryContext.class,0);
		}
		public TerminalNode TABLESAMPLE() { return getToken(SqlParser.TABLESAMPLE, 0); }
		public SampleMethodContext sampleMethod() {
			return getRuleContext(SampleMethodContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SqlParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SqlParser.LEFT_PAREN, i);
		}
		public List<NumericValueExpressionContext> numericValueExpression() {
			return getRuleContexts(NumericValueExpressionContext.class);
		}
		public NumericValueExpressionContext numericValueExpression(int i) {
			return getRuleContext(NumericValueExpressionContext.class,i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SqlParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SqlParser.RIGHT_PAREN, i);
		}
		public TerminalNode REPEATABLE() { return getToken(SqlParser.REPEATABLE, 0); }
		public List<TableReferenceContext> tableReference() {
			return getRuleContexts(TableReferenceContext.class);
		}
		public TableReferenceContext tableReference(int i) {
			return getRuleContext(TableReferenceContext.class,i);
		}
		public TerminalNode CROSS() { return getToken(SqlParser.CROSS, 0); }
		public TerminalNode JOIN() { return getToken(SqlParser.JOIN, 0); }
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinSpecificationContext joinSpecification() {
			return getRuleContext(JoinSpecificationContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SqlParser.NATURAL, 0); }
		public TerminalNode UNION() { return getToken(SqlParser.UNION, 0); }
		public TableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableReferenceContext tableReference() throws RecognitionException {
		return tableReference(0);
	}

	private TableReferenceContext tableReference(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TableReferenceContext _localctx = new TableReferenceContext(_ctx, _parentState);
		TableReferenceContext _prevctx = _localctx;
		int _startState = 306;
		enterRecursionRule(_localctx, 306, RULE_tableReference, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1825);
			switch (_input.LA(1)) {
			case LATERAL:
			case ONLY:
			case TABLE:
			case UNNEST:
			case IDENTIFIER:
			case LEFT_PAREN:
				{
				setState(1812);
				tablePrimary();
				}
				break;
			case TABLESAMPLE:
				{
				setState(1813);
				match(TABLESAMPLE);
				setState(1814);
				sampleMethod();
				setState(1815);
				match(LEFT_PAREN);
				setState(1816);
				numericValueExpression(0);
				setState(1817);
				match(RIGHT_PAREN);
				setState(1823);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
				case 1:
					{
					setState(1818);
					match(REPEATABLE);
					setState(1819);
					match(LEFT_PAREN);
					setState(1820);
					numericValueExpression(0);
					setState(1821);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1848);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1846);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
					case 1:
						{
						_localctx = new TableReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_tableReference);
						setState(1827);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1828);
						match(CROSS);
						setState(1829);
						match(JOIN);
						setState(1830);
						tablePrimary();
						}
						break;
					case 2:
						{
						_localctx = new TableReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_tableReference);
						setState(1831);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1832);
						joinType();
						setState(1833);
						match(JOIN);
						setState(1834);
						tableReference(0);
						setState(1835);
						joinSpecification();
						}
						break;
					case 3:
						{
						_localctx = new TableReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_tableReference);
						setState(1837);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1838);
						match(NATURAL);
						setState(1839);
						joinType();
						setState(1840);
						match(JOIN);
						setState(1841);
						tablePrimary();
						}
						break;
					case 4:
						{
						_localctx = new TableReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_tableReference);
						setState(1843);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1844);
						match(UNION);
						setState(1845);
						tablePrimary();
						}
						break;
					}
					} 
				}
				setState(1850);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class JoinSpecificationContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SqlParser.USING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public JoinSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitJoinSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinSpecificationContext joinSpecification() throws RecognitionException {
		JoinSpecificationContext _localctx = new JoinSpecificationContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_joinSpecification);
		int _la;
		try {
			setState(1865);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1851);
				match(ON);
				setState(1852);
				booleanValueExpression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1853);
				match(USING);
				setState(1854);
				match(LEFT_PAREN);
				setState(1855);
				columnName();
				setState(1860);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1856);
					match(COMMA);
					setState(1857);
					columnName();
					}
					}
					setState(1862);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1863);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePrimaryContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TableReferenceContext tableReference() {
			return getRuleContext(TableReferenceContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode LATERAL() { return getToken(SqlParser.LATERAL, 0); }
		public TerminalNode UNNEST() { return getToken(SqlParser.UNNEST, 0); }
		public ArrayValueExpressionContext arrayValueExpression() {
			return getRuleContext(ArrayValueExpressionContext.class,0);
		}
		public MultisetValueExpressionContext multisetValueExpression() {
			return getRuleContext(MultisetValueExpressionContext.class,0);
		}
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public TerminalNode ORDINALITY() { return getToken(SqlParser.ORDINALITY, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TerminalNode ONLY() { return getToken(SqlParser.ONLY, 0); }
		public TablePrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePrimary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTablePrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePrimaryContext tablePrimary() throws RecognitionException {
		TablePrimaryContext _localctx = new TablePrimaryContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_tablePrimary);
		int _la;
		try {
			setState(1915);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1867);
				tableName();
				setState(1869);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
				case 1:
					{
					setState(1868);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1871);
				match(LEFT_PAREN);
				setState(1872);
				tableReference(0);
				setState(1873);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1876);
				_la = _input.LA(1);
				if (_la==LATERAL) {
					{
					setState(1875);
					match(LATERAL);
					}
				}

				setState(1878);
				match(LEFT_PAREN);
				setState(1879);
				queryExpression();
				setState(1880);
				match(RIGHT_PAREN);
				setState(1882);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
				case 1:
					{
					setState(1881);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1884);
				match(UNNEST);
				setState(1885);
				match(LEFT_PAREN);
				setState(1888);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
				case 1:
					{
					setState(1886);
					arrayValueExpression(0);
					}
					break;
				case 2:
					{
					setState(1887);
					multisetValueExpression(0);
					}
					break;
				}
				setState(1890);
				match(RIGHT_PAREN);
				setState(1893);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
				case 1:
					{
					setState(1891);
					match(WITH);
					setState(1892);
					match(ORDINALITY);
					}
					break;
				}
				setState(1896);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
				case 1:
					{
					setState(1895);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1898);
				match(TABLE);
				setState(1899);
				match(LEFT_PAREN);
				setState(1902);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1900);
					arrayValueExpression(0);
					}
					break;
				case 2:
					{
					setState(1901);
					multisetValueExpression(0);
					}
					break;
				}
				setState(1904);
				match(RIGHT_PAREN);
				setState(1906);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
				case 1:
					{
					setState(1905);
					tableAlias();
					}
					break;
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1908);
				match(ONLY);
				setState(1909);
				match(LEFT_PAREN);
				setState(1910);
				tableName();
				setState(1911);
				match(RIGHT_PAREN);
				setState(1913);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
				case 1:
					{
					setState(1912);
					tableAlias();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableAliasContext extends ParserRuleContext {
		public CorrelationNameContext correlationName() {
			return getRuleContext(CorrelationNameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_tableAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1918);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1917);
				match(AS);
				}
			}

			setState(1920);
			correlationName();
			setState(1932);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
			case 1:
				{
				setState(1921);
				match(LEFT_PAREN);
				setState(1922);
				columnName();
				setState(1927);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1923);
					match(COMMA);
					setState(1924);
					columnName();
					}
					}
					setState(1929);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1930);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingElementContext extends ParserRuleContext {
		public OrdinaryGroupingSetContext ordinaryGroupingSet() {
			return getRuleContext(OrdinaryGroupingSetContext.class,0);
		}
		public TerminalNode ROLLUP() { return getToken(SqlParser.ROLLUP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode CUBE() { return getToken(SqlParser.CUBE, 0); }
		public TerminalNode GROUPING() { return getToken(SqlParser.GROUPING, 0); }
		public TerminalNode SETS() { return getToken(SqlParser.SETS, 0); }
		public List<GroupingElementContext> groupingElement() {
			return getRuleContexts(GroupingElementContext.class);
		}
		public GroupingElementContext groupingElement(int i) {
			return getRuleContext(GroupingElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public GroupingElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGroupingElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingElementContext groupingElement() throws RecognitionException {
		GroupingElementContext _localctx = new GroupingElementContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_groupingElement);
		int _la;
		try {
			setState(1960);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1934);
				ordinaryGroupingSet();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1935);
				match(ROLLUP);
				setState(1936);
				match(LEFT_PAREN);
				setState(1937);
				ordinaryGroupingSet();
				setState(1938);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1940);
				match(CUBE);
				setState(1941);
				match(LEFT_PAREN);
				setState(1942);
				ordinaryGroupingSet();
				setState(1943);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1945);
				match(GROUPING);
				setState(1946);
				match(SETS);
				setState(1947);
				match(LEFT_PAREN);
				setState(1948);
				groupingElement();
				setState(1953);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1949);
					match(COMMA);
					setState(1950);
					groupingElement();
					}
					}
					setState(1955);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1956);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1958);
				match(LEFT_PAREN);
				setState(1959);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrdinaryGroupingSetContext extends ParserRuleContext {
		public List<IdentifierChainContext> identifierChain() {
			return getRuleContexts(IdentifierChainContext.class);
		}
		public IdentifierChainContext identifierChain(int i) {
			return getRuleContext(IdentifierChainContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public OrdinaryGroupingSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinaryGroupingSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOrdinaryGroupingSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrdinaryGroupingSetContext ordinaryGroupingSet() throws RecognitionException {
		OrdinaryGroupingSetContext _localctx = new OrdinaryGroupingSetContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_ordinaryGroupingSet);
		int _la;
		try {
			setState(1974);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1962);
				identifierChain();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1963);
				match(LEFT_PAREN);
				setState(1964);
				identifierChain();
				setState(1969);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1965);
					match(COMMA);
					setState(1966);
					identifierChain();
					}
					}
					setState(1971);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1972);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryExpressionContext extends ParserRuleContext {
		public QueryExpressionBodyContext queryExpressionBody() {
			return getRuleContext(QueryExpressionBodyContext.class,0);
		}
		public WithClauseContext withClause() {
			return getRuleContext(WithClauseContext.class,0);
		}
		public QueryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryExpressionContext queryExpression() throws RecognitionException {
		QueryExpressionContext _localctx = new QueryExpressionContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_queryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1977);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1976);
				withClause();
				}
			}

			setState(1979);
			queryExpressionBody(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryExpressionBodyContext extends ParserRuleContext {
		public TableReferenceContext tableReference() {
			return getRuleContext(TableReferenceContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<QueryExpressionBodyContext> queryExpressionBody() {
			return getRuleContexts(QueryExpressionBodyContext.class);
		}
		public QueryExpressionBodyContext queryExpressionBody(int i) {
			return getRuleContext(QueryExpressionBodyContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SqlParser.VALUES, 0); }
		public List<TableRowValueExpressionContext> tableRowValueExpression() {
			return getRuleContexts(TableRowValueExpressionContext.class);
		}
		public TableRowValueExpressionContext tableRowValueExpression(int i) {
			return getRuleContext(TableRowValueExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public QueryOperatorContext queryOperator() {
			return getRuleContext(QueryOperatorContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public CorrespondingSpecificationContext correspondingSpecification() {
			return getRuleContext(CorrespondingSpecificationContext.class,0);
		}
		public QueryExpressionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryExpressionBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQueryExpressionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryExpressionBodyContext queryExpressionBody() throws RecognitionException {
		return queryExpressionBody(0);
	}

	private QueryExpressionBodyContext queryExpressionBody(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryExpressionBodyContext _localctx = new QueryExpressionBodyContext(_ctx, _parentState);
		QueryExpressionBodyContext _prevctx = _localctx;
		int _startState = 320;
		enterRecursionRule(_localctx, 320, RULE_queryExpressionBody, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2002);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				{
				setState(1982);
				tableReference(0);
				}
				break;
			case 2:
				{
				setState(1983);
				match(LEFT_PAREN);
				setState(1984);
				queryExpressionBody(0);
				setState(1985);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(1987);
				querySpecification();
				}
				break;
			case 4:
				{
				setState(1988);
				match(TABLE);
				setState(1989);
				tableName();
				}
				break;
			case 5:
				{
				setState(1990);
				match(VALUES);
				setState(1991);
				match(LEFT_PAREN);
				setState(1992);
				tableRowValueExpression();
				setState(1997);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1993);
					match(COMMA);
					setState(1994);
					tableRowValueExpression();
					}
					}
					setState(1999);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2000);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2016);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new QueryExpressionBodyContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_queryExpressionBody);
					setState(2004);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(2005);
					queryOperator();
					setState(2007);
					_la = _input.LA(1);
					if (_la==ALL || _la==DISTINCT) {
						{
						setState(2006);
						setQuantifier();
						}
					}

					setState(2010);
					_la = _input.LA(1);
					if (_la==CORRESPONDING) {
						{
						setState(2009);
						correspondingSpecification();
						}
					}

					setState(2012);
					queryExpressionBody(7);
					}
					} 
				}
				setState(2018);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TableRowValueExpressionContext extends ParserRuleContext {
		public RowValueExpressionContext rowValueExpression() {
			return getRuleContext(RowValueExpressionContext.class,0);
		}
		public CommonValueExpressionContext commonValueExpression() {
			return getRuleContext(CommonValueExpressionContext.class,0);
		}
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TableRowValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRowValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableRowValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableRowValueExpressionContext tableRowValueExpression() throws RecognitionException {
		TableRowValueExpressionContext _localctx = new TableRowValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_tableRowValueExpression);
		try {
			setState(2023);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2019);
				rowValueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2020);
				commonValueExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2021);
				booleanValueExpression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2022);
				valueExpressionPrimary(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorrespondingSpecificationContext extends ParserRuleContext {
		public TerminalNode CORRESPONDING() { return getToken(SqlParser.CORRESPONDING, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public CorrespondingSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correspondingSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCorrespondingSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorrespondingSpecificationContext correspondingSpecification() throws RecognitionException {
		CorrespondingSpecificationContext _localctx = new CorrespondingSpecificationContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_correspondingSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2025);
			match(CORRESPONDING);
			setState(2038);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(2026);
				match(BY);
				setState(2027);
				match(LEFT_PAREN);
				setState(2028);
				columnName();
				setState(2033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2029);
					match(COMMA);
					setState(2030);
					columnName();
					}
					}
					setState(2035);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2036);
				match(RIGHT_PAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithClauseContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public TerminalNode RECURSIVE() { return getToken(SqlParser.RECURSIVE, 0); }
		public List<WithElementContext> withElement() {
			return getRuleContexts(WithElementContext.class);
		}
		public WithElementContext withElement(int i) {
			return getRuleContext(WithElementContext.class,i);
		}
		public WithClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWithClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithClauseContext withClause() throws RecognitionException {
		WithClauseContext _localctx = new WithClauseContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_withClause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2040);
			match(WITH);
			setState(2042);
			_la = _input.LA(1);
			if (_la==RECURSIVE) {
				{
				setState(2041);
				match(RECURSIVE);
				}
			}

			setState(2045); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2044);
					withElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2047); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithElementContext extends ParserRuleContext {
		public QueryNameContext queryName() {
			return getRuleContext(QueryNameContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SqlParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SqlParser.LEFT_PAREN, i);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SqlParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SqlParser.RIGHT_PAREN, i);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SearchOrCycleClauseContext searchOrCycleClause() {
			return getRuleContext(SearchOrCycleClauseContext.class,0);
		}
		public WithElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWithElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithElementContext withElement() throws RecognitionException {
		WithElementContext _localctx = new WithElementContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_withElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2049);
			queryName();
			setState(2061);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				{
				setState(2050);
				match(LEFT_PAREN);
				setState(2051);
				columnName();
				setState(2056);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2052);
					match(COMMA);
					setState(2053);
					columnName();
					}
					}
					setState(2058);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2059);
				match(RIGHT_PAREN);
				}
				break;
			}
			setState(2070);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2063);
				match(AS);
				setState(2064);
				match(LEFT_PAREN);
				setState(2065);
				queryExpression();
				setState(2066);
				match(RIGHT_PAREN);
				setState(2068);
				_la = _input.LA(1);
				if (_la==CYCLE || _la==DEFAULT || ((((_la - 269)) & ~0x3f) == 0 && ((1L << (_la - 269)) & ((1L << (SEARCH - 269)) | (1L << (SET - 269)) | (1L << (USING - 269)))) != 0)) {
					{
					setState(2067);
					searchOrCycleClause();
					}
				}

				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchOrCycleClauseContext extends ParserRuleContext {
		public SearchClauseContext searchClause() {
			return getRuleContext(SearchClauseContext.class,0);
		}
		public CycleClauseContext cycleClause() {
			return getRuleContext(CycleClauseContext.class,0);
		}
		public SearchOrCycleClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchOrCycleClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSearchOrCycleClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchOrCycleClauseContext searchOrCycleClause() throws RecognitionException {
		SearchOrCycleClauseContext _localctx = new SearchOrCycleClauseContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_searchOrCycleClause);
		try {
			setState(2077);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2072);
				searchClause();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2073);
				cycleClause();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2074);
				searchClause();
				setState(2075);
				cycleClause();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchClauseContext extends ParserRuleContext {
		public TerminalNode SEARCH() { return getToken(SqlParser.SEARCH, 0); }
		public TerminalNode DEPTH() { return getToken(SqlParser.DEPTH, 0); }
		public TerminalNode FIRST() { return getToken(SqlParser.FIRST, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public SortSpecificationListContext sortSpecificationList() {
			return getRuleContext(SortSpecificationListContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode BREADTH() { return getToken(SqlParser.BREADTH, 0); }
		public SearchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSearchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchClauseContext searchClause() throws RecognitionException {
		SearchClauseContext _localctx = new SearchClauseContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_searchClause);
		try {
			setState(2095);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2079);
				match(SEARCH);
				setState(2080);
				match(DEPTH);
				setState(2081);
				match(FIRST);
				setState(2082);
				match(BY);
				setState(2083);
				sortSpecificationList();
				setState(2084);
				match(SET);
				setState(2085);
				columnName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2087);
				match(SEARCH);
				setState(2088);
				match(BREADTH);
				setState(2089);
				match(FIRST);
				setState(2090);
				match(BY);
				setState(2091);
				sortSpecificationList();
				setState(2092);
				match(SET);
				setState(2093);
				columnName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CycleClauseContext extends ParserRuleContext {
		public TerminalNode CYCLE() { return getToken(SqlParser.CYCLE, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public TerminalNode TO() { return getToken(SqlParser.TO, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public TerminalNode USING() { return getToken(SqlParser.USING, 0); }
		public CycleClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycleClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCycleClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CycleClauseContext cycleClause() throws RecognitionException {
		CycleClauseContext _localctx = new CycleClauseContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_cycleClause);
		int _la;
		try {
			setState(2115);
			switch (_input.LA(1)) {
			case CYCLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2097);
				match(CYCLE);
				setState(2098);
				columnName();
				setState(2103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2099);
					match(COMMA);
					setState(2100);
					columnName();
					}
					}
					setState(2105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(2106);
				match(SET);
				setState(2107);
				columnName();
				setState(2108);
				match(TO);
				setState(2109);
				valueExpression();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(2111);
				match(DEFAULT);
				setState(2112);
				valueExpression();
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 4);
				{
				setState(2113);
				match(USING);
				setState(2114);
				columnName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public CommonValueExpressionContext commonValueExpression() {
			return getRuleContext(CommonValueExpressionContext.class,0);
		}
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public RowValueExpressionContext rowValueExpression() {
			return getRuleContext(RowValueExpressionContext.class,0);
		}
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_valueExpression);
		try {
			setState(2120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2117);
				commonValueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2118);
				booleanValueExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2119);
				rowValueExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommonValueExpressionContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public StringValueExpressionContext stringValueExpression() {
			return getRuleContext(StringValueExpressionContext.class,0);
		}
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public DatetimeValueExpressionContext datetimeValueExpression() {
			return getRuleContext(DatetimeValueExpressionContext.class,0);
		}
		public IntervalValueExpressionContext intervalValueExpression() {
			return getRuleContext(IntervalValueExpressionContext.class,0);
		}
		public ArrayValueExpressionContext arrayValueExpression() {
			return getRuleContext(ArrayValueExpressionContext.class,0);
		}
		public MultisetValueExpressionContext multisetValueExpression() {
			return getRuleContext(MultisetValueExpressionContext.class,0);
		}
		public CommonValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commonValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCommonValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommonValueExpressionContext commonValueExpression() throws RecognitionException {
		CommonValueExpressionContext _localctx = new CommonValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_commonValueExpression);
		try {
			setState(2129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2122);
				valueExpressionPrimary(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2123);
				stringValueExpression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2124);
				numericValueExpression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2125);
				datetimeValueExpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2126);
				intervalValueExpression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2127);
				arrayValueExpression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2128);
				multisetValueExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericValueExpressionContext extends ParserRuleContext {
		public NumericValueFunctionContext numericValueFunction() {
			return getRuleContext(NumericValueFunctionContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<NumericValueExpressionContext> numericValueExpression() {
			return getRuleContexts(NumericValueExpressionContext.class);
		}
		public NumericValueExpressionContext numericValueExpression(int i) {
			return getRuleContext(NumericValueExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public MultiplicativeOperatorContext multiplicativeOperator() {
			return getRuleContext(MultiplicativeOperatorContext.class,0);
		}
		public AdditiveOperatorContext additiveOperator() {
			return getRuleContext(AdditiveOperatorContext.class,0);
		}
		public NumericValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNumericValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericValueExpressionContext numericValueExpression() throws RecognitionException {
		return numericValueExpression(0);
	}

	private NumericValueExpressionContext numericValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NumericValueExpressionContext _localctx = new NumericValueExpressionContext(_ctx, _parentState);
		NumericValueExpressionContext _prevctx = _localctx;
		int _startState = 340;
		enterRecursionRule(_localctx, 340, RULE_numericValueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				{
				setState(2133);
				_la = _input.LA(1);
				if (_la==PLUS_SIGN || _la==MINUS_SIGN) {
					{
					setState(2132);
					sign();
					}
				}

				setState(2135);
				numericValueFunction();
				}
				break;
			case 2:
				{
				setState(2136);
				match(LEFT_PAREN);
				setState(2137);
				numericValueExpression(0);
				setState(2138);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(2141);
				_la = _input.LA(1);
				if (_la==PLUS_SIGN || _la==MINUS_SIGN) {
					{
					setState(2140);
					sign();
					}
				}

				setState(2143);
				valueExpressionPrimary(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2154);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
					case 1:
						{
						_localctx = new NumericValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numericValueExpression);
						setState(2146);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2147);
						multiplicativeOperator();
						setState(2148);
						numericValueExpression(5);
						}
						break;
					case 2:
						{
						_localctx = new NumericValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numericValueExpression);
						setState(2150);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2151);
						additiveOperator();
						setState(2152);
						numericValueExpression(4);
						}
						break;
					}
					} 
				}
				setState(2158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,192,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NumericValueFunctionContext extends ParserRuleContext {
		public NumericValueFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericValueFunction; }
	 
		public NumericValueFunctionContext() { }
		public void copyFrom(NumericValueFunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExtractExpressionContext extends NumericValueFunctionContext {
		public TerminalNode EXTRACT() { return getToken(SqlParser.EXTRACT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ExtractFieldContext extractField() {
			return getRuleContext(ExtractFieldContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public DatetimeValueExpressionContext datetimeValueExpression() {
			return getRuleContext(DatetimeValueExpressionContext.class,0);
		}
		public IntervalValueExpressionContext intervalValueExpression() {
			return getRuleContext(IntervalValueExpressionContext.class,0);
		}
		public ExtractExpressionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExtractExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CardinalityExpressionContext extends NumericValueFunctionContext {
		public TerminalNode CARDINALITY() { return getToken(SqlParser.CARDINALITY, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ArrayValueExpressionContext arrayValueExpression() {
			return getRuleContext(ArrayValueExpressionContext.class,0);
		}
		public MultisetValueExpressionContext multisetValueExpression() {
			return getRuleContext(MultisetValueExpressionContext.class,0);
		}
		public CardinalityExpressionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCardinalityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SquareRootContext extends NumericValueFunctionContext {
		public TerminalNode SQRT() { return getToken(SqlParser.SQRT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public SquareRootContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSquareRoot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModulusExpressionContext extends NumericValueFunctionContext {
		public TerminalNode MOD() { return getToken(SqlParser.MOD, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<NumericValueExpressionContext> numericValueExpression() {
			return getRuleContexts(NumericValueExpressionContext.class);
		}
		public NumericValueExpressionContext numericValueExpression(int i) {
			return getRuleContext(NumericValueExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SqlParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ModulusExpressionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitModulusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LengthExpressionContext extends NumericValueFunctionContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public StringValueExpressionContext stringValueExpression() {
			return getRuleContext(StringValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode CHAR_LENGTH() { return getToken(SqlParser.CHAR_LENGTH, 0); }
		public TerminalNode CHARACTER_LENGTH() { return getToken(SqlParser.CHARACTER_LENGTH, 0); }
		public TerminalNode OCTET_LENGTH() { return getToken(SqlParser.OCTET_LENGTH, 0); }
		public LengthExpressionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLengthExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CeilingFunctionContext extends NumericValueFunctionContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode CEIL() { return getToken(SqlParser.CEIL, 0); }
		public TerminalNode CEILING() { return getToken(SqlParser.CEILING, 0); }
		public CeilingFunctionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCeilingFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloorFunctionContext extends NumericValueFunctionContext {
		public TerminalNode FLOOR() { return getToken(SqlParser.FLOOR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public FloorFunctionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFloorFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PositionExpressionContext extends NumericValueFunctionContext {
		public TerminalNode POSITION() { return getToken(SqlParser.POSITION, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<StringValueExpressionContext> stringValueExpression() {
			return getRuleContexts(StringValueExpressionContext.class);
		}
		public StringValueExpressionContext stringValueExpression(int i) {
			return getRuleContext(StringValueExpressionContext.class,i);
		}
		public TerminalNode IN() { return getToken(SqlParser.IN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public PositionExpressionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPositionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExponentialFunctionContext extends NumericValueFunctionContext {
		public TerminalNode EXP() { return getToken(SqlParser.EXP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ExponentialFunctionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExponentialFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WidthBucketFunctionContext extends NumericValueFunctionContext {
		public TerminalNode WIDTH_BUCKET() { return getToken(SqlParser.WIDTH_BUCKET, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public WidthBucketOperandContext widthBucketOperand() {
			return getRuleContext(WidthBucketOperandContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public WidthBucketBound1Context widthBucketBound1() {
			return getRuleContext(WidthBucketBound1Context.class,0);
		}
		public WidthBucketBound2Context widthBucketBound2() {
			return getRuleContext(WidthBucketBound2Context.class,0);
		}
		public WidthBucketCountContext widthBucketCount() {
			return getRuleContext(WidthBucketCountContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public WidthBucketFunctionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWidthBucketFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NaturalLogarithmContext extends NumericValueFunctionContext {
		public TerminalNode LN() { return getToken(SqlParser.LN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public NaturalLogarithmContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNaturalLogarithm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerFunctionContext extends NumericValueFunctionContext {
		public TerminalNode POWER() { return getToken(SqlParser.POWER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<NumericValueExpressionContext> numericValueExpression() {
			return getRuleContexts(NumericValueExpressionContext.class);
		}
		public NumericValueExpressionContext numericValueExpression(int i) {
			return getRuleContext(NumericValueExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SqlParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public PowerFunctionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPowerFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AbsoluteValueExpressionContext extends NumericValueFunctionContext {
		public TerminalNode ABS() { return getToken(SqlParser.ABS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public AbsoluteValueExpressionContext(NumericValueFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAbsoluteValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericValueFunctionContext numericValueFunction() throws RecognitionException {
		NumericValueFunctionContext _localctx = new NumericValueFunctionContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_numericValueFunction);
		int _la;
		try {
			setState(2244);
			switch (_input.LA(1)) {
			case CHARACTER_LENGTH:
			case CHAR_LENGTH:
			case OCTET_LENGTH:
				_localctx = new LengthExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2159);
				_la = _input.LA(1);
				if ( !(_la==CHARACTER_LENGTH || _la==CHAR_LENGTH || _la==OCTET_LENGTH) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(2160);
				match(LEFT_PAREN);
				setState(2161);
				stringValueExpression(0);
				setState(2162);
				match(RIGHT_PAREN);
				}
				break;
			case POSITION:
				_localctx = new PositionExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2164);
				match(POSITION);
				setState(2165);
				match(LEFT_PAREN);
				setState(2166);
				stringValueExpression(0);
				setState(2167);
				match(IN);
				setState(2168);
				stringValueExpression(0);
				setState(2169);
				match(RIGHT_PAREN);
				}
				break;
			case EXTRACT:
				_localctx = new ExtractExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2171);
				match(EXTRACT);
				setState(2172);
				match(LEFT_PAREN);
				setState(2173);
				extractField();
				setState(2174);
				match(FROM);
				setState(2177);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
				case 1:
					{
					setState(2175);
					datetimeValueExpression(0);
					}
					break;
				case 2:
					{
					setState(2176);
					intervalValueExpression(0);
					}
					break;
				}
				setState(2179);
				match(RIGHT_PAREN);
				}
				break;
			case CARDINALITY:
				_localctx = new CardinalityExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2181);
				match(CARDINALITY);
				setState(2182);
				match(LEFT_PAREN);
				setState(2185);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
				case 1:
					{
					setState(2183);
					arrayValueExpression(0);
					}
					break;
				case 2:
					{
					setState(2184);
					multisetValueExpression(0);
					}
					break;
				}
				setState(2187);
				match(RIGHT_PAREN);
				}
				break;
			case ABS:
				_localctx = new AbsoluteValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(2189);
				match(ABS);
				setState(2190);
				match(LEFT_PAREN);
				setState(2191);
				numericValueExpression(0);
				setState(2192);
				match(RIGHT_PAREN);
				}
				break;
			case MOD:
				_localctx = new ModulusExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(2194);
				match(MOD);
				setState(2195);
				match(LEFT_PAREN);
				setState(2196);
				numericValueExpression(0);
				setState(2197);
				match(COMMA);
				setState(2198);
				numericValueExpression(0);
				setState(2199);
				match(RIGHT_PAREN);
				}
				break;
			case LN:
				_localctx = new NaturalLogarithmContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(2201);
				match(LN);
				setState(2202);
				match(LEFT_PAREN);
				setState(2203);
				numericValueExpression(0);
				setState(2204);
				match(RIGHT_PAREN);
				}
				break;
			case EXP:
				_localctx = new ExponentialFunctionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(2206);
				match(EXP);
				setState(2207);
				match(LEFT_PAREN);
				setState(2208);
				numericValueExpression(0);
				setState(2209);
				match(RIGHT_PAREN);
				}
				break;
			case POWER:
				_localctx = new PowerFunctionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(2211);
				match(POWER);
				setState(2212);
				match(LEFT_PAREN);
				setState(2213);
				numericValueExpression(0);
				setState(2214);
				match(COMMA);
				setState(2215);
				numericValueExpression(0);
				setState(2216);
				match(RIGHT_PAREN);
				}
				break;
			case SQRT:
				_localctx = new SquareRootContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(2218);
				match(SQRT);
				setState(2219);
				match(LEFT_PAREN);
				setState(2220);
				numericValueExpression(0);
				setState(2221);
				match(RIGHT_PAREN);
				}
				break;
			case FLOOR:
				_localctx = new FloorFunctionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(2223);
				match(FLOOR);
				setState(2224);
				match(LEFT_PAREN);
				setState(2225);
				numericValueExpression(0);
				setState(2226);
				match(RIGHT_PAREN);
				}
				break;
			case CEIL:
			case CEILING:
				_localctx = new CeilingFunctionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(2228);
				_la = _input.LA(1);
				if ( !(_la==CEIL || _la==CEILING) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(2229);
				match(LEFT_PAREN);
				setState(2230);
				numericValueExpression(0);
				setState(2231);
				match(RIGHT_PAREN);
				}
				break;
			case WIDTH_BUCKET:
				_localctx = new WidthBucketFunctionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(2233);
				match(WIDTH_BUCKET);
				setState(2234);
				match(LEFT_PAREN);
				setState(2235);
				widthBucketOperand();
				setState(2236);
				match(COMMA);
				setState(2237);
				widthBucketBound1();
				setState(2238);
				match(COMMA);
				setState(2239);
				widthBucketBound2();
				setState(2240);
				match(COMMA);
				setState(2241);
				widthBucketCount();
				setState(2242);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtractFieldContext extends ParserRuleContext {
		public PrimaryDatetimeFieldContext primaryDatetimeField() {
			return getRuleContext(PrimaryDatetimeFieldContext.class,0);
		}
		public TimeZoneFieldContext timeZoneField() {
			return getRuleContext(TimeZoneFieldContext.class,0);
		}
		public ExtractFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extractField; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExtractField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtractFieldContext extractField() throws RecognitionException {
		ExtractFieldContext _localctx = new ExtractFieldContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_extractField);
		try {
			setState(2248);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2246);
				primaryDatetimeField();
				}
				break;
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2247);
				timeZoneField();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WidthBucketOperandContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public WidthBucketOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widthBucketOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWidthBucketOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthBucketOperandContext widthBucketOperand() throws RecognitionException {
		WidthBucketOperandContext _localctx = new WidthBucketOperandContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_widthBucketOperand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2250);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WidthBucketBound1Context extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public WidthBucketBound1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widthBucketBound1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWidthBucketBound1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthBucketBound1Context widthBucketBound1() throws RecognitionException {
		WidthBucketBound1Context _localctx = new WidthBucketBound1Context(_ctx, getState());
		enterRule(_localctx, 348, RULE_widthBucketBound1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2252);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WidthBucketBound2Context extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public WidthBucketBound2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widthBucketBound2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWidthBucketBound2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthBucketBound2Context widthBucketBound2() throws RecognitionException {
		WidthBucketBound2Context _localctx = new WidthBucketBound2Context(_ctx, getState());
		enterRule(_localctx, 350, RULE_widthBucketBound2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2254);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WidthBucketCountContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public WidthBucketCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_widthBucketCount; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWidthBucketCount(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WidthBucketCountContext widthBucketCount() throws RecognitionException {
		WidthBucketCountContext _localctx = new WidthBucketCountContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_widthBucketCount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2256);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringValueExpressionContext extends ParserRuleContext {
		public StringValueFunctionContext stringValueFunction() {
			return getRuleContext(StringValueFunctionContext.class,0);
		}
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public List<StringValueExpressionContext> stringValueExpression() {
			return getRuleContexts(StringValueExpressionContext.class);
		}
		public StringValueExpressionContext stringValueExpression(int i) {
			return getRuleContext(StringValueExpressionContext.class,i);
		}
		public TerminalNode CONCATENATION_OPERATOR() { return getToken(SqlParser.CONCATENATION_OPERATOR, 0); }
		public StringValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStringValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringValueExpressionContext stringValueExpression() throws RecognitionException {
		return stringValueExpression(0);
	}

	private StringValueExpressionContext stringValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StringValueExpressionContext _localctx = new StringValueExpressionContext(_ctx, _parentState);
		StringValueExpressionContext _prevctx = _localctx;
		int _startState = 354;
		enterRecursionRule(_localctx, 354, RULE_stringValueExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
			case 1:
				{
				setState(2259);
				stringValueFunction();
				}
				break;
			case 2:
				{
				setState(2260);
				valueExpressionPrimary(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StringValueExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stringValueExpression);
					setState(2263);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(2264);
					match(CONCATENATION_OPERATOR);
					setState(2265);
					stringValueExpression(3);
					}
					} 
				}
				setState(2270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StringValueFunctionContext extends ParserRuleContext {
		public TerminalNode SUBSTRING() { return getToken(SqlParser.SUBSTRING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<StringValueExpressionContext> stringValueExpression() {
			return getRuleContexts(StringValueExpressionContext.class);
		}
		public StringValueExpressionContext stringValueExpression(int i) {
			return getRuleContext(StringValueExpressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public StartPositionContext startPosition() {
			return getRuleContext(StartPositionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode FOR() { return getToken(SqlParser.FOR, 0); }
		public StringLengthContext stringLength() {
			return getRuleContext(StringLengthContext.class,0);
		}
		public TerminalNode SIMILAR() { return getToken(SqlParser.SIMILAR, 0); }
		public TerminalNode ESCAPE() { return getToken(SqlParser.ESCAPE, 0); }
		public TerminalNode CHARACTER_STRING_LITERAL() { return getToken(SqlParser.CHARACTER_STRING_LITERAL, 0); }
		public TerminalNode UPPER() { return getToken(SqlParser.UPPER, 0); }
		public TerminalNode LOWER() { return getToken(SqlParser.LOWER, 0); }
		public TerminalNode TRIM() { return getToken(SqlParser.TRIM, 0); }
		public TerminalNode NORMALIZE() { return getToken(SqlParser.NORMALIZE, 0); }
		public UdtValueExpressionContext udtValueExpression() {
			return getRuleContext(UdtValueExpressionContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(SqlParser.PERIOD, 0); }
		public TerminalNode SPECIFICTYPE() { return getToken(SqlParser.SPECIFICTYPE, 0); }
		public StringValueFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringValueFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStringValueFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringValueFunctionContext stringValueFunction() throws RecognitionException {
		StringValueFunctionContext _localctx = new StringValueFunctionContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_stringValueFunction);
		int _la;
		try {
			setState(2310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2271);
				match(SUBSTRING);
				setState(2272);
				match(LEFT_PAREN);
				setState(2273);
				stringValueExpression(0);
				setState(2274);
				match(FROM);
				setState(2275);
				startPosition();
				setState(2278);
				_la = _input.LA(1);
				if (_la==FOR) {
					{
					setState(2276);
					match(FOR);
					setState(2277);
					stringLength();
					}
				}

				setState(2280);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2282);
				match(SUBSTRING);
				setState(2283);
				match(LEFT_PAREN);
				setState(2284);
				stringValueExpression(0);
				setState(2285);
				match(SIMILAR);
				setState(2286);
				stringValueExpression(0);
				setState(2287);
				match(ESCAPE);
				setState(2288);
				match(CHARACTER_STRING_LITERAL);
				setState(2289);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2291);
				_la = _input.LA(1);
				if ( !(_la==LOWER || _la==UPPER) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(2292);
				match(LEFT_PAREN);
				setState(2293);
				stringValueExpression(0);
				setState(2294);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2296);
				match(TRIM);
				setState(2297);
				match(LEFT_PAREN);
				setState(2298);
				stringValueExpression(0);
				setState(2299);
				match(RIGHT_PAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2301);
				match(NORMALIZE);
				setState(2302);
				match(LEFT_PAREN);
				setState(2303);
				stringValueExpression(0);
				setState(2304);
				match(RIGHT_PAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2306);
				udtValueExpression();
				setState(2307);
				match(PERIOD);
				setState(2308);
				match(SPECIFICTYPE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartPositionContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public StartPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startPosition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStartPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartPositionContext startPosition() throws RecognitionException {
		StartPositionContext _localctx = new StartPositionContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_startPosition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2312);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLengthContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public StringLengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLength; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStringLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLengthContext stringLength() throws RecognitionException {
		StringLengthContext _localctx = new StringLengthContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_stringLength);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2314);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatetimeValueExpressionContext extends ParserRuleContext {
		public DatetimeValueFunctionContext datetimeValueFunction() {
			return getRuleContext(DatetimeValueFunctionContext.class,0);
		}
		public TimeZoneContext timeZone() {
			return getRuleContext(TimeZoneContext.class,0);
		}
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public DatetimeValueExpressionContext datetimeValueExpression() {
			return getRuleContext(DatetimeValueExpressionContext.class,0);
		}
		public TerminalNode MINUS_SIGN() { return getToken(SqlParser.MINUS_SIGN, 0); }
		public IntervalValueExpressionContext intervalValueExpression() {
			return getRuleContext(IntervalValueExpressionContext.class,0);
		}
		public TerminalNode PLUS_SIGN() { return getToken(SqlParser.PLUS_SIGN, 0); }
		public DatetimeValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetimeValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDatetimeValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatetimeValueExpressionContext datetimeValueExpression() throws RecognitionException {
		return datetimeValueExpression(0);
	}

	private DatetimeValueExpressionContext datetimeValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DatetimeValueExpressionContext _localctx = new DatetimeValueExpressionContext(_ctx, _parentState);
		DatetimeValueExpressionContext _prevctx = _localctx;
		int _startState = 362;
		enterRecursionRule(_localctx, 362, RULE_datetimeValueExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2325);
			switch (_input.LA(1)) {
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case LOCALTIME:
			case LOCALTIMESTAMP:
				{
				setState(2317);
				datetimeValueFunction();
				setState(2319);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
				case 1:
					{
					setState(2318);
					timeZone();
					}
					break;
				}
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case ANY:
			case ARRAY:
			case AVG:
			case CASE:
			case CAST:
			case COALESCE:
			case COLLECT:
			case COVAR_POP:
			case COVAR_SAMP:
			case COUNT:
			case CUME_DIST:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_USER:
			case DENSE_RANK:
			case DEREF:
			case ELEMENT:
			case EVERY:
			case FUSION:
			case GROUPING:
			case INTERSECTION:
			case INTERVAL:
			case MAX:
			case MIN:
			case MULTISET:
			case NEW:
			case NEXT:
			case NULLIF:
			case PERCENT_RANK:
			case PERCENTILE_CONT:
			case PERCENTILE_DISC:
			case RANK:
			case REGR_AVGX:
			case REGR_AVGY:
			case REGR_COUNT:
			case REGR_INTERCEPT:
			case REGR_RSQUARED:
			case REGR_SLOPE:
			case REGR_SXX:
			case REGR_SXY:
			case REGR_SYY:
			case ROW_NUMBER:
			case SESSION_USER:
			case SOME:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUM:
			case SYSTEM_USER:
			case TABLE:
			case TREAT:
			case USER:
			case VALUE:
			case VAR_POP:
			case VAR_SAMP:
			case IDENTIFIER:
			case CORR:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case LEFT_PAREN:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				{
				setState(2321);
				valueExpressionPrimary(0);
				setState(2323);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(2322);
					timeZone();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(2335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2333);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
					case 1:
						{
						_localctx = new DatetimeValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_datetimeValueExpression);
						setState(2327);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2328);
						match(MINUS_SIGN);
						setState(2329);
						intervalValueExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new DatetimeValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_datetimeValueExpression);
						setState(2330);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2331);
						match(PLUS_SIGN);
						setState(2332);
						intervalValueExpression(0);
						}
						break;
					}
					} 
				}
				setState(2337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TimeZoneContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(SqlParser.AT, 0); }
		public TerminalNode LOCAL() { return getToken(SqlParser.LOCAL, 0); }
		public TerminalNode TIME() { return getToken(SqlParser.TIME, 0); }
		public TerminalNode ZONE() { return getToken(SqlParser.ZONE, 0); }
		public IntervalPrimaryContext intervalPrimary() {
			return getRuleContext(IntervalPrimaryContext.class,0);
		}
		public TimeZoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeZone; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTimeZone(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeZoneContext timeZone() throws RecognitionException {
		TimeZoneContext _localctx = new TimeZoneContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_timeZone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2338);
			match(AT);
			setState(2343);
			switch (_input.LA(1)) {
			case LOCAL:
				{
				setState(2339);
				match(LOCAL);
				}
				break;
			case TIME:
				{
				setState(2340);
				match(TIME);
				setState(2341);
				match(ZONE);
				setState(2342);
				intervalPrimary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalPrimaryContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public IntervalQualifierContext intervalQualifier() {
			return getRuleContext(IntervalQualifierContext.class,0);
		}
		public TerminalNode ABS() { return getToken(SqlParser.ABS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public IntervalValueExpressionContext intervalValueExpression() {
			return getRuleContext(IntervalValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public IntervalPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalPrimary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIntervalPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalPrimaryContext intervalPrimary() throws RecognitionException {
		IntervalPrimaryContext _localctx = new IntervalPrimaryContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_intervalPrimary);
		try {
			setState(2354);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case ANY:
			case ARRAY:
			case AVG:
			case CASE:
			case CAST:
			case COALESCE:
			case COLLECT:
			case COVAR_POP:
			case COVAR_SAMP:
			case COUNT:
			case CUME_DIST:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_USER:
			case DENSE_RANK:
			case DEREF:
			case ELEMENT:
			case EVERY:
			case FUSION:
			case GROUPING:
			case INTERSECTION:
			case INTERVAL:
			case MAX:
			case MIN:
			case MULTISET:
			case NEW:
			case NEXT:
			case NULLIF:
			case PERCENT_RANK:
			case PERCENTILE_CONT:
			case PERCENTILE_DISC:
			case RANK:
			case REGR_AVGX:
			case REGR_AVGY:
			case REGR_COUNT:
			case REGR_INTERCEPT:
			case REGR_RSQUARED:
			case REGR_SLOPE:
			case REGR_SXX:
			case REGR_SXY:
			case REGR_SYY:
			case ROW_NUMBER:
			case SESSION_USER:
			case SOME:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUM:
			case SYSTEM_USER:
			case TABLE:
			case TREAT:
			case USER:
			case VALUE:
			case VAR_POP:
			case VAR_SAMP:
			case IDENTIFIER:
			case CORR:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case LEFT_PAREN:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(2345);
				valueExpressionPrimary(0);
				setState(2347);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(2346);
					intervalQualifier();
					}
					break;
				}
				}
				break;
			case ABS:
				enterOuterAlt(_localctx, 2);
				{
				setState(2349);
				match(ABS);
				setState(2350);
				match(LEFT_PAREN);
				setState(2351);
				intervalValueExpression(0);
				setState(2352);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatetimeValueFunctionContext extends ParserRuleContext {
		public TerminalNode CURRENT_DATE() { return getToken(SqlParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SqlParser.CURRENT_TIME, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public SecondsDecimalsContext secondsDecimals() {
			return getRuleContext(SecondsDecimalsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SqlParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode LOCALTIME() { return getToken(SqlParser.LOCALTIME, 0); }
		public TerminalNode LOCALTIMESTAMP() { return getToken(SqlParser.LOCALTIMESTAMP, 0); }
		public DatetimeValueFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetimeValueFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDatetimeValueFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatetimeValueFunctionContext datetimeValueFunction() throws RecognitionException {
		DatetimeValueFunctionContext _localctx = new DatetimeValueFunctionContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_datetimeValueFunction);
		try {
			setState(2385);
			switch (_input.LA(1)) {
			case CURRENT_DATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2356);
				match(CURRENT_DATE);
				}
				break;
			case CURRENT_TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2357);
				match(CURRENT_TIME);
				setState(2362);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
				case 1:
					{
					setState(2358);
					match(LEFT_PAREN);
					setState(2359);
					secondsDecimals();
					setState(2360);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 3);
				{
				setState(2364);
				match(CURRENT_TIMESTAMP);
				setState(2369);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
				case 1:
					{
					setState(2365);
					match(LEFT_PAREN);
					setState(2366);
					secondsDecimals();
					setState(2367);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LOCALTIME:
				enterOuterAlt(_localctx, 4);
				{
				setState(2371);
				match(LOCALTIME);
				setState(2376);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
				case 1:
					{
					setState(2372);
					match(LEFT_PAREN);
					setState(2373);
					secondsDecimals();
					setState(2374);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			case LOCALTIMESTAMP:
				enterOuterAlt(_localctx, 5);
				{
				setState(2378);
				match(LOCALTIMESTAMP);
				setState(2383);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(2379);
					match(LEFT_PAREN);
					setState(2380);
					secondsDecimals();
					setState(2381);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalValueExpressionContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(SqlParser.ASTERISK, 0); }
		public List<IntervalValueExpressionContext> intervalValueExpression() {
			return getRuleContexts(IntervalValueExpressionContext.class);
		}
		public IntervalValueExpressionContext intervalValueExpression(int i) {
			return getRuleContext(IntervalValueExpressionContext.class,i);
		}
		public TerminalNode ABS() { return getToken(SqlParser.ABS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public List<DatetimeValueExpressionContext> datetimeValueExpression() {
			return getRuleContexts(DatetimeValueExpressionContext.class);
		}
		public DatetimeValueExpressionContext datetimeValueExpression(int i) {
			return getRuleContext(DatetimeValueExpressionContext.class,i);
		}
		public TerminalNode MINUS_SIGN() { return getToken(SqlParser.MINUS_SIGN, 0); }
		public IntervalQualifierContext intervalQualifier() {
			return getRuleContext(IntervalQualifierContext.class,0);
		}
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public AdditiveOperatorContext additiveOperator() {
			return getRuleContext(AdditiveOperatorContext.class,0);
		}
		public MultiplicativeOperatorContext multiplicativeOperator() {
			return getRuleContext(MultiplicativeOperatorContext.class,0);
		}
		public IntervalValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIntervalValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalValueExpressionContext intervalValueExpression() throws RecognitionException {
		return intervalValueExpression(0);
	}

	private IntervalValueExpressionContext intervalValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IntervalValueExpressionContext _localctx = new IntervalValueExpressionContext(_ctx, _parentState);
		IntervalValueExpressionContext _prevctx = _localctx;
		int _startState = 370;
		enterRecursionRule(_localctx, 370, RULE_intervalValueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2414);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				{
				setState(2388);
				numericValueExpression(0);
				setState(2389);
				match(ASTERISK);
				setState(2390);
				intervalValueExpression(5);
				}
				break;
			case 2:
				{
				setState(2393);
				_la = _input.LA(1);
				if (_la==PLUS_SIGN || _la==MINUS_SIGN) {
					{
					setState(2392);
					sign();
					}
				}

				setState(2395);
				match(ABS);
				setState(2396);
				match(LEFT_PAREN);
				setState(2397);
				intervalValueExpression(0);
				setState(2398);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				{
				setState(2400);
				match(LEFT_PAREN);
				setState(2401);
				datetimeValueExpression(0);
				setState(2402);
				match(MINUS_SIGN);
				setState(2403);
				datetimeValueExpression(0);
				setState(2404);
				match(RIGHT_PAREN);
				setState(2405);
				intervalQualifier();
				}
				break;
			case 4:
				{
				setState(2408);
				_la = _input.LA(1);
				if (_la==PLUS_SIGN || _la==MINUS_SIGN) {
					{
					setState(2407);
					sign();
					}
				}

				setState(2410);
				valueExpressionPrimary(0);
				setState(2412);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
				case 1:
					{
					setState(2411);
					intervalQualifier();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2426);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2424);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
					case 1:
						{
						_localctx = new IntervalValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_intervalValueExpression);
						setState(2416);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2417);
						additiveOperator();
						setState(2418);
						intervalValueExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new IntervalValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_intervalValueExpression);
						setState(2420);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2421);
						multiplicativeOperator();
						setState(2422);
						numericValueExpression(0);
						}
						break;
					}
					} 
				}
				setState(2428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UdtValueExpressionContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public UdtValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUdtValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtValueExpressionContext udtValueExpression() throws RecognitionException {
		UdtValueExpressionContext _localctx = new UdtValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_udtValueExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2429);
			valueExpressionPrimary(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceValueExpressionContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public ReferenceValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceValueExpressionContext referenceValueExpression() throws RecognitionException {
		ReferenceValueExpressionContext _localctx = new ReferenceValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_referenceValueExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2431);
			valueExpressionPrimary(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayValueExpressionContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public List<ArrayValueExpressionContext> arrayValueExpression() {
			return getRuleContexts(ArrayValueExpressionContext.class);
		}
		public ArrayValueExpressionContext arrayValueExpression(int i) {
			return getRuleContext(ArrayValueExpressionContext.class,i);
		}
		public TerminalNode CONCATENATION_OPERATOR() { return getToken(SqlParser.CONCATENATION_OPERATOR, 0); }
		public ArrayValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValueExpressionContext arrayValueExpression() throws RecognitionException {
		return arrayValueExpression(0);
	}

	private ArrayValueExpressionContext arrayValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayValueExpressionContext _localctx = new ArrayValueExpressionContext(_ctx, _parentState);
		ArrayValueExpressionContext _prevctx = _localctx;
		int _startState = 376;
		enterRecursionRule(_localctx, 376, RULE_arrayValueExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2434);
			valueExpressionPrimary(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,220,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayValueExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayValueExpression);
					setState(2436);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2437);
					match(CONCATENATION_OPERATOR);
					setState(2438);
					arrayValueExpression(2);
					}
					} 
				}
				setState(2443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,220,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultisetValueExpressionContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<MultisetValueExpressionContext> multisetValueExpression() {
			return getRuleContexts(MultisetValueExpressionContext.class);
		}
		public MultisetValueExpressionContext multisetValueExpression(int i) {
			return getRuleContext(MultisetValueExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public MultisetOperatorContext multisetOperator() {
			return getRuleContext(MultisetOperatorContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public MultisetValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multisetValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultisetValueExpressionContext multisetValueExpression() throws RecognitionException {
		return multisetValueExpression(0);
	}

	private MultisetValueExpressionContext multisetValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultisetValueExpressionContext _localctx = new MultisetValueExpressionContext(_ctx, _parentState);
		MultisetValueExpressionContext _prevctx = _localctx;
		int _startState = 378;
		enterRecursionRule(_localctx, 378, RULE_multisetValueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2451);
			switch (_input.LA(1)) {
			case SET:
				{
				setState(2445);
				match(SET);
				setState(2446);
				match(LEFT_PAREN);
				setState(2447);
				multisetValueExpression(0);
				setState(2448);
				match(RIGHT_PAREN);
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case ANY:
			case ARRAY:
			case AVG:
			case CASE:
			case CAST:
			case COALESCE:
			case COLLECT:
			case COVAR_POP:
			case COVAR_SAMP:
			case COUNT:
			case CUME_DIST:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_USER:
			case DENSE_RANK:
			case DEREF:
			case ELEMENT:
			case EVERY:
			case FUSION:
			case GROUPING:
			case INTERSECTION:
			case INTERVAL:
			case MAX:
			case MIN:
			case MULTISET:
			case NEW:
			case NEXT:
			case NULLIF:
			case PERCENT_RANK:
			case PERCENTILE_CONT:
			case PERCENTILE_DISC:
			case RANK:
			case REGR_AVGX:
			case REGR_AVGY:
			case REGR_COUNT:
			case REGR_INTERCEPT:
			case REGR_RSQUARED:
			case REGR_SLOPE:
			case REGR_SXX:
			case REGR_SXY:
			case REGR_SYY:
			case ROW_NUMBER:
			case SESSION_USER:
			case SOME:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUM:
			case SYSTEM_USER:
			case TABLE:
			case TREAT:
			case USER:
			case VALUE:
			case VAR_POP:
			case VAR_SAMP:
			case IDENTIFIER:
			case CORR:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case LEFT_PAREN:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				{
				setState(2450);
				valueExpressionPrimary(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(2472);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2470);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
					case 1:
						{
						_localctx = new MultisetValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multisetValueExpression);
						setState(2453);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2454);
						multisetOperator();
						setState(2456);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(2455);
							setQuantifier();
							}
						}

						setState(2458);
						valueExpressionPrimary(0);
						}
						break;
					case 2:
						{
						_localctx = new MultisetValueExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multisetValueExpression);
						setState(2460);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2461);
						multisetOperator();
						setState(2463);
						_la = _input.LA(1);
						if (_la==ALL || _la==DISTINCT) {
							{
							setState(2462);
							setQuantifier();
							}
						}

						setState(2465);
						match(SET);
						setState(2466);
						match(LEFT_PAREN);
						setState(2467);
						multisetValueExpression(0);
						setState(2468);
						match(RIGHT_PAREN);
						}
						break;
					}
					} 
				}
				setState(2474);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanValueExpressionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public List<BooleanValueExpressionContext> booleanValueExpression() {
			return getRuleContexts(BooleanValueExpressionContext.class);
		}
		public BooleanValueExpressionContext booleanValueExpression(int i) {
			return getRuleContext(BooleanValueExpressionContext.class,i);
		}
		public BooleanPrimaryContext booleanPrimary() {
			return getRuleContext(BooleanPrimaryContext.class,0);
		}
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(SqlParser.BOOLEAN_LITERAL, 0); }
		public BooleanOperatorContext booleanOperator() {
			return getRuleContext(BooleanOperatorContext.class,0);
		}
		public BooleanValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBooleanValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueExpressionContext booleanValueExpression() throws RecognitionException {
		return booleanValueExpression(0);
	}

	private BooleanValueExpressionContext booleanValueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanValueExpressionContext _localctx = new BooleanValueExpressionContext(_ctx, _parentState);
		BooleanValueExpressionContext _prevctx = _localctx;
		int _startState = 380;
		enterRecursionRule(_localctx, 380, RULE_booleanValueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2486);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(2476);
				match(NOT);
				setState(2477);
				booleanValueExpression(3);
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case ABS:
			case ANY:
			case ARRAY:
			case AVG:
			case CARDINALITY:
			case CASE:
			case CAST:
			case CEIL:
			case CEILING:
			case CHARACTER_LENGTH:
			case CHAR_LENGTH:
			case COALESCE:
			case COLLECT:
			case COVAR_POP:
			case COVAR_SAMP:
			case COUNT:
			case CUME_DIST:
			case CURRENT_DATE:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case CURRENT_USER:
			case DENSE_RANK:
			case DEREF:
			case ELEMENT:
			case EVERY:
			case EXISTS:
			case EXP:
			case EXTRACT:
			case FLOOR:
			case FUSION:
			case GROUPING:
			case INTERSECTION:
			case INTERVAL:
			case LN:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case LOWER:
			case MAX:
			case MIN:
			case MOD:
			case MULTISET:
			case NEW:
			case NEXT:
			case NORMALIZE:
			case NULLIF:
			case OCTET_LENGTH:
			case PERCENT_RANK:
			case PERCENTILE_CONT:
			case PERCENTILE_DISC:
			case POWER:
			case RANK:
			case REGR_AVGX:
			case REGR_AVGY:
			case REGR_COUNT:
			case REGR_INTERCEPT:
			case REGR_RSQUARED:
			case REGR_SLOPE:
			case REGR_SXX:
			case REGR_SXY:
			case REGR_SYY:
			case ROW:
			case ROW_NUMBER:
			case SESSION_USER:
			case SET:
			case SOME:
			case SQRT:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBSTRING:
			case SUM:
			case SYSTEM_USER:
			case TABLE:
			case TREAT:
			case TRIM:
			case UNIQUE:
			case UPPER:
			case USER:
			case VALUE:
			case VAR_POP:
			case VAR_SAMP:
			case WIDTH_BUCKET:
			case IDENTIFIER:
			case CORR:
			case POSITION:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case LEFT_PAREN:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				{
				setState(2478);
				booleanPrimary();
				setState(2484);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,227,_ctx) ) {
				case 1:
					{
					setState(2479);
					match(IS);
					setState(2481);
					_la = _input.LA(1);
					if (_la==NOT) {
						{
						setState(2480);
						match(NOT);
						}
					}

					setState(2483);
					match(BOOLEAN_LITERAL);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(2494);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,229,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanValueExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanValueExpression);
					setState(2488);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(2489);
					booleanOperator();
					setState(2490);
					booleanValueExpression(3);
					}
					} 
				}
				setState(2496);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,229,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanPrimaryContext extends ParserRuleContext {
		public RowValuePredicandContext rowValuePredicand() {
			return getRuleContext(RowValuePredicandContext.class,0);
		}
		public ComparisonConditionContext comparisonCondition() {
			return getRuleContext(ComparisonConditionContext.class,0);
		}
		public BetweenConditionContext betweenCondition() {
			return getRuleContext(BetweenConditionContext.class,0);
		}
		public InConditionContext inCondition() {
			return getRuleContext(InConditionContext.class,0);
		}
		public LikeConditionContext likeCondition() {
			return getRuleContext(LikeConditionContext.class,0);
		}
		public SimilarConditionContext similarCondition() {
			return getRuleContext(SimilarConditionContext.class,0);
		}
		public NullConditionContext nullCondition() {
			return getRuleContext(NullConditionContext.class,0);
		}
		public QuantifiedComparisonConditionContext quantifiedComparisonCondition() {
			return getRuleContext(QuantifiedComparisonConditionContext.class,0);
		}
		public TerminalNode EXISTS() { return getToken(SqlParser.EXISTS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode UNIQUE() { return getToken(SqlParser.UNIQUE, 0); }
		public StringValueExpressionContext stringValueExpression() {
			return getRuleContext(StringValueExpressionContext.class,0);
		}
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode NORMALIZED() { return getToken(SqlParser.NORMALIZED, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public MatchConditionContext matchCondition() {
			return getRuleContext(MatchConditionContext.class,0);
		}
		public OverlapsConditionContext overlapsCondition() {
			return getRuleContext(OverlapsConditionContext.class,0);
		}
		public DistinctConditionContext distinctCondition() {
			return getRuleContext(DistinctConditionContext.class,0);
		}
		public MemberConditionContext memberCondition() {
			return getRuleContext(MemberConditionContext.class,0);
		}
		public SubmultisetConditionContext submultisetCondition() {
			return getRuleContext(SubmultisetConditionContext.class,0);
		}
		public SetConditionContext setCondition() {
			return getRuleContext(SetConditionContext.class,0);
		}
		public TypeConditionContext typeCondition() {
			return getRuleContext(TypeConditionContext.class,0);
		}
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public BooleanPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanPrimary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBooleanPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanPrimaryContext booleanPrimary() throws RecognitionException {
		BooleanPrimaryContext _localctx = new BooleanPrimaryContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_booleanPrimary);
		int _la;
		try {
			setState(2561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,231,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2497);
				rowValuePredicand();
				setState(2498);
				comparisonCondition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2500);
				rowValuePredicand();
				setState(2501);
				betweenCondition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2503);
				rowValuePredicand();
				setState(2504);
				inCondition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2506);
				rowValuePredicand();
				setState(2507);
				likeCondition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2509);
				rowValuePredicand();
				setState(2510);
				similarCondition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2512);
				rowValuePredicand();
				setState(2513);
				nullCondition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2515);
				rowValuePredicand();
				setState(2516);
				quantifiedComparisonCondition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2518);
				match(EXISTS);
				setState(2519);
				match(LEFT_PAREN);
				setState(2520);
				queryExpression();
				setState(2521);
				match(RIGHT_PAREN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2523);
				match(UNIQUE);
				setState(2524);
				match(LEFT_PAREN);
				setState(2525);
				queryExpression();
				setState(2526);
				match(RIGHT_PAREN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2528);
				stringValueExpression(0);
				setState(2529);
				match(IS);
				setState(2531);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(2530);
					match(NOT);
					}
				}

				setState(2533);
				match(NORMALIZED);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2535);
				rowValuePredicand();
				setState(2536);
				matchCondition();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2538);
				rowValuePredicand();
				setState(2539);
				overlapsCondition();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2541);
				rowValuePredicand();
				setState(2542);
				distinctCondition();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(2544);
				rowValuePredicand();
				setState(2545);
				memberCondition();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(2547);
				rowValuePredicand();
				setState(2548);
				submultisetCondition();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(2550);
				rowValuePredicand();
				setState(2551);
				setCondition();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(2553);
				rowValuePredicand();
				setState(2554);
				typeCondition();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(2556);
				match(LEFT_PAREN);
				setState(2557);
				booleanValueExpression(0);
				setState(2558);
				match(RIGHT_PAREN);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(2560);
				valueExpressionPrimary(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonConditionContext extends ParserRuleContext {
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public RowValuePredicandContext rowValuePredicand() {
			return getRuleContext(RowValuePredicandContext.class,0);
		}
		public ComparisonConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitComparisonCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonConditionContext comparisonCondition() throws RecognitionException {
		ComparisonConditionContext _localctx = new ComparisonConditionContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_comparisonCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2563);
			compOp();
			setState(2564);
			rowValuePredicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BetweenConditionContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(SqlParser.BETWEEN, 0); }
		public List<RowValuePredicandContext> rowValuePredicand() {
			return getRuleContexts(RowValuePredicandContext.class);
		}
		public RowValuePredicandContext rowValuePredicand(int i) {
			return getRuleContext(RowValuePredicandContext.class,i);
		}
		public TerminalNode AND() { return getToken(SqlParser.AND, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public SymmetricOptionContext symmetricOption() {
			return getRuleContext(SymmetricOptionContext.class,0);
		}
		public BetweenConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitBetweenCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenConditionContext betweenCondition() throws RecognitionException {
		BetweenConditionContext _localctx = new BetweenConditionContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_betweenCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2567);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2566);
				match(NOT);
				}
			}

			setState(2569);
			match(BETWEEN);
			setState(2571);
			_la = _input.LA(1);
			if (_la==ASYMMETRIC || _la==SYMMETRIC) {
				{
				setState(2570);
				symmetricOption();
				}
			}

			setState(2573);
			rowValuePredicand();
			setState(2574);
			match(AND);
			setState(2575);
			rowValuePredicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InConditionContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SqlParser.IN, 0); }
		public List<RowValueExpressionContext> rowValueExpression() {
			return getRuleContexts(RowValueExpressionContext.class);
		}
		public RowValueExpressionContext rowValueExpression(int i) {
			return getRuleContext(RowValueExpressionContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public InConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InConditionContext inCondition() throws RecognitionException {
		InConditionContext _localctx = new InConditionContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_inCondition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2578);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2577);
				match(NOT);
				}
			}

			setState(2580);
			match(IN);
			setState(2593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				{
				setState(2581);
				rowValueExpression();
				setState(2586);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,235,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2582);
						match(COMMA);
						setState(2583);
						rowValueExpression();
						}
						} 
					}
					setState(2588);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,235,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(2589);
				match(LEFT_PAREN);
				setState(2590);
				queryExpression();
				setState(2591);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeConditionContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(SqlParser.LIKE, 0); }
		public StringValueExpressionContext stringValueExpression() {
			return getRuleContext(StringValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public TerminalNode ESCAPE() { return getToken(SqlParser.ESCAPE, 0); }
		public TerminalNode CHARACTER_STRING_LITERAL() { return getToken(SqlParser.CHARACTER_STRING_LITERAL, 0); }
		public LikeConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLikeCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeConditionContext likeCondition() throws RecognitionException {
		LikeConditionContext _localctx = new LikeConditionContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_likeCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2596);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2595);
				match(NOT);
				}
			}

			setState(2598);
			match(LIKE);
			setState(2599);
			stringValueExpression(0);
			setState(2602);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
			case 1:
				{
				setState(2600);
				match(ESCAPE);
				setState(2601);
				match(CHARACTER_STRING_LITERAL);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimilarConditionContext extends ParserRuleContext {
		public TerminalNode SIMILAR() { return getToken(SqlParser.SIMILAR, 0); }
		public TerminalNode TO() { return getToken(SqlParser.TO, 0); }
		public StringValueExpressionContext stringValueExpression() {
			return getRuleContext(StringValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public TerminalNode ESCAPE() { return getToken(SqlParser.ESCAPE, 0); }
		public TerminalNode CHARACTER_STRING_LITERAL() { return getToken(SqlParser.CHARACTER_STRING_LITERAL, 0); }
		public SimilarConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_similarCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSimilarCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimilarConditionContext similarCondition() throws RecognitionException {
		SimilarConditionContext _localctx = new SimilarConditionContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_similarCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2605);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2604);
				match(NOT);
				}
			}

			setState(2607);
			match(SIMILAR);
			setState(2608);
			match(TO);
			setState(2609);
			stringValueExpression(0);
			setState(2612);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
			case 1:
				{
				setState(2610);
				match(ESCAPE);
				setState(2611);
				match(CHARACTER_STRING_LITERAL);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullConditionContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public NullConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNullCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullConditionContext nullCondition() throws RecognitionException {
		NullConditionContext _localctx = new NullConditionContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_nullCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2614);
			match(IS);
			setState(2616);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2615);
				match(NOT);
				}
			}

			setState(2618);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifiedComparisonConditionContext extends ParserRuleContext {
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public QuantifiedComparisonConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiedComparisonCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitQuantifiedComparisonCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifiedComparisonConditionContext quantifiedComparisonCondition() throws RecognitionException {
		QuantifiedComparisonConditionContext _localctx = new QuantifiedComparisonConditionContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_quantifiedComparisonCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2620);
			compOp();
			setState(2621);
			quantifier();
			setState(2622);
			match(LEFT_PAREN);
			setState(2623);
			queryExpression();
			setState(2624);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatchConditionContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(SqlParser.MATCH, 0); }
		public MatchContext match() {
			return getRuleContext(MatchContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode UNIQUE() { return getToken(SqlParser.UNIQUE, 0); }
		public MatchConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMatchCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchConditionContext matchCondition() throws RecognitionException {
		MatchConditionContext _localctx = new MatchConditionContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_matchCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2626);
			match(MATCH);
			setState(2628);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(2627);
				match(UNIQUE);
				}
			}

			setState(2630);
			match();
			setState(2631);
			match(LEFT_PAREN);
			setState(2632);
			queryExpression();
			setState(2633);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OverlapsConditionContext extends ParserRuleContext {
		public TerminalNode OVERLAPS() { return getToken(SqlParser.OVERLAPS, 0); }
		public RowValuePredicandContext rowValuePredicand() {
			return getRuleContext(RowValuePredicandContext.class,0);
		}
		public OverlapsConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overlapsCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOverlapsCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverlapsConditionContext overlapsCondition() throws RecognitionException {
		OverlapsConditionContext _localctx = new OverlapsConditionContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_overlapsCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2635);
			match(OVERLAPS);
			setState(2636);
			rowValuePredicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DistinctConditionContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlParser.DISTINCT, 0); }
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public RowValuePredicandContext rowValuePredicand() {
			return getRuleContext(RowValuePredicandContext.class,0);
		}
		public DistinctConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distinctCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDistinctCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DistinctConditionContext distinctCondition() throws RecognitionException {
		DistinctConditionContext _localctx = new DistinctConditionContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_distinctCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2638);
			match(IS);
			setState(2639);
			match(DISTINCT);
			setState(2640);
			match(FROM);
			setState(2641);
			rowValuePredicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberConditionContext extends ParserRuleContext {
		public TerminalNode MEMBER() { return getToken(SqlParser.MEMBER, 0); }
		public MultisetValueExpressionContext multisetValueExpression() {
			return getRuleContext(MultisetValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public TerminalNode OF() { return getToken(SqlParser.OF, 0); }
		public MemberConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMemberCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberConditionContext memberCondition() throws RecognitionException {
		MemberConditionContext _localctx = new MemberConditionContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_memberCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2644);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2643);
				match(NOT);
				}
			}

			setState(2646);
			match(MEMBER);
			setState(2648);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(2647);
				match(OF);
				}
			}

			setState(2650);
			multisetValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubmultisetConditionContext extends ParserRuleContext {
		public TerminalNode SUBMULTISET() { return getToken(SqlParser.SUBMULTISET, 0); }
		public TerminalNode OF() { return getToken(SqlParser.OF, 0); }
		public MultisetValueExpressionContext multisetValueExpression() {
			return getRuleContext(MultisetValueExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public SubmultisetConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_submultisetCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSubmultisetCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubmultisetConditionContext submultisetCondition() throws RecognitionException {
		SubmultisetConditionContext _localctx = new SubmultisetConditionContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_submultisetCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2653);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2652);
				match(NOT);
				}
			}

			setState(2655);
			match(SUBMULTISET);
			setState(2656);
			match(OF);
			setState(2657);
			multisetValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetConditionContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode A() { return getToken(SqlParser.A, 0); }
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public SetConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSetCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetConditionContext setCondition() throws RecognitionException {
		SetConditionContext _localctx = new SetConditionContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_setCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2659);
			match(IS);
			setState(2661);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2660);
				match(NOT);
				}
			}

			setState(2663);
			match(A);
			setState(2664);
			match(SET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeConditionContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode OF() { return getToken(SqlParser.OF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<UdtSpecificationContext> udtSpecification() {
			return getRuleContexts(UdtSpecificationContext.class);
		}
		public UdtSpecificationContext udtSpecification(int i) {
			return getRuleContext(UdtSpecificationContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode NOT() { return getToken(SqlParser.NOT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TypeConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTypeCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeConditionContext typeCondition() throws RecognitionException {
		TypeConditionContext _localctx = new TypeConditionContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_typeCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2666);
			match(IS);
			setState(2668);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2667);
				match(NOT);
				}
			}

			setState(2670);
			match(OF);
			setState(2671);
			match(LEFT_PAREN);
			setState(2672);
			udtSpecification();
			setState(2677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2673);
				match(COMMA);
				setState(2674);
				udtSpecification();
				}
				}
				setState(2679);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2680);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtSpecificationContext extends ParserRuleContext {
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public TerminalNode ONLY() { return getToken(SqlParser.ONLY, 0); }
		public UdtSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUdtSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtSpecificationContext udtSpecification() throws RecognitionException {
		UdtSpecificationContext _localctx = new UdtSpecificationContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_udtSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2683);
			_la = _input.LA(1);
			if (_la==ONLY) {
				{
				setState(2682);
				match(ONLY);
				}
			}

			setState(2685);
			udtName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowValuePredicandContext extends ParserRuleContext {
		public CommonValueExpressionContext commonValueExpression() {
			return getRuleContext(CommonValueExpressionContext.class,0);
		}
		public RowValueExpressionContext rowValueExpression() {
			return getRuleContext(RowValueExpressionContext.class,0);
		}
		public RowValuePredicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowValuePredicand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRowValuePredicand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowValuePredicandContext rowValuePredicand() throws RecognitionException {
		RowValuePredicandContext _localctx = new RowValuePredicandContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_rowValuePredicand);
		try {
			setState(2689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2687);
				commonValueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2688);
				rowValueExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowValueExpressionContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public RowValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRowValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowValueExpressionContext rowValueExpression() throws RecognitionException {
		RowValueExpressionContext _localctx = new RowValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_rowValueExpression);
		int _la;
		try {
			setState(2718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2691);
				valueExpressionPrimary(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2692);
				match(LEFT_PAREN);
				setState(2693);
				valueExpression();
				setState(2696); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2694);
					match(COMMA);
					setState(2695);
					valueExpression();
					}
					}
					setState(2698); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2700);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2702);
				match(ROW);
				setState(2703);
				match(LEFT_PAREN);
				setState(2704);
				valueExpression();
				setState(2709);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2705);
					match(COMMA);
					setState(2706);
					valueExpression();
					}
					}
					setState(2711);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2712);
				match(RIGHT_PAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2714);
				match(LEFT_PAREN);
				setState(2715);
				queryExpression();
				setState(2716);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionPrimaryContext extends ParserRuleContext {
		public ValueExpressionPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpressionPrimary; }
	 
		public ValueExpressionPrimaryContext() { }
		public void copyFrom(ValueExpressionPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnsignedLitContext extends ValueExpressionPrimaryContext {
		public UnsignedLiteralContext unsignedLiteral() {
			return getRuleContext(UnsignedLiteralContext.class,0);
		}
		public UnsignedLitContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUnsignedLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewSpecContext extends ValueExpressionPrimaryContext {
		public NewSpecificationContext newSpecification() {
			return getRuleContext(NewSpecificationContext.class,0);
		}
		public NewSpecContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNewSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastSpecContext extends ValueExpressionPrimaryContext {
		public CastSpecificationContext castSpecification() {
			return getRuleContext(CastSpecificationContext.class,0);
		}
		public CastSpecContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElementRefConcatContext extends ValueExpressionPrimaryContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ArrayValueExpressionContext> arrayValueExpression() {
			return getRuleContexts(ArrayValueExpressionContext.class);
		}
		public ArrayValueExpressionContext arrayValueExpression(int i) {
			return getRuleContext(ArrayValueExpressionContext.class,i);
		}
		public TerminalNode CONCATENATION_OPERATOR() { return getToken(SqlParser.CONCATENATION_OPERATOR, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public ArrayElementRefConcatContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayElementRefConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodInvocContext extends ValueExpressionPrimaryContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(SqlParser.PERIOD, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public SqlArgumentListContext sqlArgumentList() {
			return getRuleContext(SqlArgumentListContext.class,0);
		}
		public MethodInvocContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMethodInvoc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScalarSubqContext extends ValueExpressionPrimaryContext {
		public ScalarSubqueryContext scalarSubquery() {
			return getRuleContext(ScalarSubqueryContext.class,0);
		}
		public ScalarSubqContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitScalarSubq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultisetElementRefContext extends ValueExpressionPrimaryContext {
		public MultisetElementReferenceContext multisetElementReference() {
			return getRuleContext(MultisetElementReferenceContext.class,0);
		}
		public MultisetElementRefContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetElementRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AttributeOrMethodRefContext extends ValueExpressionPrimaryContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode DEREFERENCE_OPERATOR() { return getToken(SqlParser.DEREFERENCE_OPERATOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public SqlArgumentListContext sqlArgumentList() {
			return getRuleContext(SqlArgumentListContext.class,0);
		}
		public AttributeOrMethodRefContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAttributeOrMethodRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GeneralValueSpecContext extends ValueExpressionPrimaryContext {
		public GeneralValueSpecificationContext generalValueSpecification() {
			return getRuleContext(GeneralValueSpecificationContext.class,0);
		}
		public GeneralValueSpecContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGeneralValueSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WindowFuncContext extends ValueExpressionPrimaryContext {
		public WindowFunctionContext windowFunction() {
			return getRuleContext(WindowFunctionContext.class,0);
		}
		public WindowFuncContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtypeTreatContext extends ValueExpressionPrimaryContext {
		public SubtypeTreatmentContext subtypeTreatment() {
			return getRuleContext(SubtypeTreatmentContext.class,0);
		}
		public SubtypeTreatContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSubtypeTreat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggregateFuncContext extends ValueExpressionPrimaryContext {
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public AggregateFuncContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAggregateFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GeneralizedMethodInvocContext extends ValueExpressionPrimaryContext {
		public GeneralizedInvocationContext generalizedInvocation() {
			return getRuleContext(GeneralizedInvocationContext.class,0);
		}
		public GeneralizedMethodInvocContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGeneralizedMethodInvoc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RoutineInvocContext extends ValueExpressionPrimaryContext {
		public RoutineInvocationContext routineInvocation() {
			return getRuleContext(RoutineInvocationContext.class,0);
		}
		public RoutineInvocContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoutineInvoc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayValueConstructContext extends ValueExpressionPrimaryContext {
		public ArrayValueConstructorContext arrayValueConstructor() {
			return getRuleContext(ArrayValueConstructorContext.class,0);
		}
		public ArrayValueConstructContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayValueConstruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NextValueExpContext extends ValueExpressionPrimaryContext {
		public NextValueExpressionContext nextValueExpression() {
			return getRuleContext(NextValueExpressionContext.class,0);
		}
		public NextValueExpContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNextValueExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultisetValueConstructContext extends ValueExpressionPrimaryContext {
		public MultisetValueConstructorContext multisetValueConstructor() {
			return getRuleContext(MultisetValueConstructorContext.class,0);
		}
		public MultisetValueConstructContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetValueConstruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExpressionPrimaryParenContext extends ValueExpressionPrimaryContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ValueExpressionPrimaryParenContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitValueExpressionPrimaryParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StaticMethodInvocContext extends ValueExpressionPrimaryContext {
		public StaticMethodInvocationContext staticMethodInvocation() {
			return getRuleContext(StaticMethodInvocationContext.class,0);
		}
		public StaticMethodInvocContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStaticMethodInvoc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElementRefContext extends ValueExpressionPrimaryContext {
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public ArrayElementRefContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayElementRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReferenceResContext extends ValueExpressionPrimaryContext {
		public ReferenceResolutionContext referenceResolution() {
			return getRuleContext(ReferenceResolutionContext.class,0);
		}
		public ReferenceResContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceRes(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CaseExpContext extends ValueExpressionPrimaryContext {
		public CaseExpressionContext caseExpression() {
			return getRuleContext(CaseExpressionContext.class,0);
		}
		public CaseExpContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupingOpContext extends ValueExpressionPrimaryContext {
		public GroupingOperationContext groupingOperation() {
			return getRuleContext(GroupingOperationContext.class,0);
		}
		public GroupingOpContext(ValueExpressionPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGroupingOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionPrimaryContext valueExpressionPrimary() throws RecognitionException {
		return valueExpressionPrimary(0);
	}

	private ValueExpressionPrimaryContext valueExpressionPrimary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionPrimaryContext _localctx = new ValueExpressionPrimaryContext(_ctx, _parentState);
		ValueExpressionPrimaryContext _prevctx = _localctx;
		int _startState = 418;
		enterRecursionRule(_localctx, 418, RULE_valueExpressionPrimary, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2752);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
			case 1:
				{
				_localctx = new GeneralValueSpecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(2721);
				generalValueSpecification();
				}
				break;
			case 2:
				{
				_localctx = new UnsignedLitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2722);
				unsignedLiteral();
				}
				break;
			case 3:
				{
				_localctx = new AggregateFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2723);
				aggregateFunction();
				}
				break;
			case 4:
				{
				_localctx = new ArrayValueConstructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2724);
				arrayValueConstructor();
				}
				break;
			case 5:
				{
				_localctx = new MultisetValueConstructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2725);
				multisetValueConstructor();
				}
				break;
			case 6:
				{
				_localctx = new CaseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2726);
				caseExpression();
				}
				break;
			case 7:
				{
				_localctx = new CastSpecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2727);
				castSpecification();
				}
				break;
			case 8:
				{
				_localctx = new GroupingOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2728);
				groupingOperation();
				}
				break;
			case 9:
				{
				_localctx = new WindowFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2729);
				windowFunction();
				}
				break;
			case 10:
				{
				_localctx = new ScalarSubqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2730);
				scalarSubquery();
				}
				break;
			case 11:
				{
				_localctx = new SubtypeTreatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2731);
				subtypeTreatment();
				}
				break;
			case 12:
				{
				_localctx = new GeneralizedMethodInvocContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2732);
				generalizedInvocation();
				}
				break;
			case 13:
				{
				_localctx = new StaticMethodInvocContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2733);
				staticMethodInvocation();
				}
				break;
			case 14:
				{
				_localctx = new NewSpecContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2734);
				newSpecification();
				}
				break;
			case 15:
				{
				_localctx = new ReferenceResContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2735);
				referenceResolution();
				}
				break;
			case 16:
				{
				_localctx = new ArrayElementRefConcatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2736);
				match(LEFT_PAREN);
				setState(2737);
				arrayValueExpression(0);
				setState(2738);
				match(CONCATENATION_OPERATOR);
				setState(2739);
				arrayValueExpression(0);
				setState(2740);
				match(RIGHT_PAREN);
				setState(2741);
				match(LEFT_BRACKET);
				setState(2742);
				numericValueExpression(0);
				setState(2743);
				match(RIGHT_BRACKET);
				}
				break;
			case 17:
				{
				_localctx = new MultisetElementRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2745);
				multisetElementReference();
				}
				break;
			case 18:
				{
				_localctx = new RoutineInvocContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2746);
				routineInvocation();
				}
				break;
			case 19:
				{
				_localctx = new NextValueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2747);
				nextValueExpression();
				}
				break;
			case 20:
				{
				_localctx = new ValueExpressionPrimaryParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(2748);
				match(LEFT_PAREN);
				setState(2749);
				valueExpressionPrimary(0);
				setState(2750);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(2772);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2770);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
					case 1:
						{
						_localctx = new MethodInvocContext(new ValueExpressionPrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpressionPrimary);
						setState(2754);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(2755);
						match(PERIOD);
						setState(2756);
						methodName();
						setState(2757);
						sqlArgumentList();
						}
						break;
					case 2:
						{
						_localctx = new AttributeOrMethodRefContext(new ValueExpressionPrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpressionPrimary);
						setState(2759);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(2760);
						match(DEREFERENCE_OPERATOR);
						setState(2761);
						match(IDENTIFIER);
						setState(2763);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
						case 1:
							{
							setState(2762);
							sqlArgumentList();
							}
							break;
						}
						}
						break;
					case 3:
						{
						_localctx = new ArrayElementRefContext(new ValueExpressionPrimaryContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpressionPrimary);
						setState(2765);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(2766);
						match(LEFT_BRACKET);
						setState(2767);
						numericValueExpression(0);
						setState(2768);
						match(RIGHT_BRACKET);
						}
						break;
					}
					} 
				}
				setState(2774);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AggregateFunctionContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SqlParser.COUNT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode ASTERISK() { return getToken(SqlParser.ASTERISK, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public FilterClauseContext filterClause() {
			return getRuleContext(FilterClauseContext.class,0);
		}
		public SetFunctionContext setFunction() {
			return getRuleContext(SetFunctionContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public BinarySetFunctionContext binarySetFunction() {
			return getRuleContext(BinarySetFunctionContext.class,0);
		}
		public DependentVariableExpressionContext dependentVariableExpression() {
			return getRuleContext(DependentVariableExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SqlParser.COMMA, 0); }
		public IndependentVariableExpressionContext independentVariableExpression() {
			return getRuleContext(IndependentVariableExpressionContext.class,0);
		}
		public RankFunctionContext rankFunction() {
			return getRuleContext(RankFunctionContext.class,0);
		}
		public RankFunctionArgumentListContext rankFunctionArgumentList() {
			return getRuleContext(RankFunctionArgumentListContext.class,0);
		}
		public WithinGroupSpecificationContext withinGroupSpecification() {
			return getRuleContext(WithinGroupSpecificationContext.class,0);
		}
		public InverseDistributionFunctionContext inverseDistributionFunction() {
			return getRuleContext(InverseDistributionFunctionContext.class,0);
		}
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public AggregateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAggregateFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateFunctionContext aggregateFunction() throws RecognitionException {
		AggregateFunctionContext _localctx = new AggregateFunctionContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_aggregateFunction);
		int _la;
		try {
			setState(2817);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2775);
				match(COUNT);
				setState(2776);
				match(LEFT_PAREN);
				setState(2777);
				match(ASTERISK);
				setState(2778);
				match(RIGHT_PAREN);
				setState(2780);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
				case 1:
					{
					setState(2779);
					filterClause();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2782);
				setFunction();
				setState(2783);
				match(LEFT_PAREN);
				setState(2785);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(2784);
					setQuantifier();
					}
				}

				setState(2787);
				valueExpression();
				setState(2788);
				match(RIGHT_PAREN);
				setState(2790);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
				case 1:
					{
					setState(2789);
					filterClause();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2792);
				binarySetFunction();
				setState(2793);
				match(LEFT_PAREN);
				setState(2794);
				dependentVariableExpression();
				setState(2795);
				match(COMMA);
				setState(2796);
				independentVariableExpression();
				setState(2797);
				match(RIGHT_PAREN);
				setState(2799);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
				case 1:
					{
					setState(2798);
					filterClause();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2801);
				rankFunction();
				setState(2802);
				match(LEFT_PAREN);
				setState(2803);
				rankFunctionArgumentList();
				setState(2804);
				match(RIGHT_PAREN);
				setState(2805);
				withinGroupSpecification();
				setState(2807);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,262,_ctx) ) {
				case 1:
					{
					setState(2806);
					filterClause();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2809);
				inverseDistributionFunction();
				setState(2810);
				match(LEFT_PAREN);
				setState(2811);
				numericValueExpression(0);
				setState(2812);
				match(RIGHT_PAREN);
				setState(2813);
				withinGroupSpecification();
				setState(2815);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
				case 1:
					{
					setState(2814);
					filterClause();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RankFunctionArgumentListContext extends ParserRuleContext {
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public RankFunctionArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rankFunctionArgumentList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRankFunctionArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RankFunctionArgumentListContext rankFunctionArgumentList() throws RecognitionException {
		RankFunctionArgumentListContext _localctx = new RankFunctionArgumentListContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_rankFunctionArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2819);
			valueExpression();
			setState(2824);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2820);
				match(COMMA);
				setState(2821);
				valueExpression();
				}
				}
				setState(2826);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DependentVariableExpressionContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public DependentVariableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependentVariableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDependentVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependentVariableExpressionContext dependentVariableExpression() throws RecognitionException {
		DependentVariableExpressionContext _localctx = new DependentVariableExpressionContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_dependentVariableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2827);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndependentVariableExpressionContext extends ParserRuleContext {
		public NumericValueExpressionContext numericValueExpression() {
			return getRuleContext(NumericValueExpressionContext.class,0);
		}
		public IndependentVariableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_independentVariableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIndependentVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndependentVariableExpressionContext independentVariableExpression() throws RecognitionException {
		IndependentVariableExpressionContext _localctx = new IndependentVariableExpressionContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_independentVariableExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2829);
			numericValueExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithinGroupSpecificationContext extends ParserRuleContext {
		public TerminalNode WITHIN() { return getToken(SqlParser.WITHIN, 0); }
		public TerminalNode GROUP() { return getToken(SqlParser.GROUP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode ORDER() { return getToken(SqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public SortSpecificationListContext sortSpecificationList() {
			return getRuleContext(SortSpecificationListContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public WithinGroupSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withinGroupSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWithinGroupSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WithinGroupSpecificationContext withinGroupSpecification() throws RecognitionException {
		WithinGroupSpecificationContext _localctx = new WithinGroupSpecificationContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_withinGroupSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2831);
			match(WITHIN);
			setState(2832);
			match(GROUP);
			setState(2833);
			match(LEFT_PAREN);
			setState(2834);
			match(ORDER);
			setState(2835);
			match(BY);
			setState(2836);
			sortSpecificationList();
			setState(2837);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortSpecificationListContext extends ParserRuleContext {
		public List<SortSpecificationContext> sortSpecification() {
			return getRuleContexts(SortSpecificationContext.class);
		}
		public SortSpecificationContext sortSpecification(int i) {
			return getRuleContext(SortSpecificationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SortSpecificationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortSpecificationList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSortSpecificationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortSpecificationListContext sortSpecificationList() throws RecognitionException {
		SortSpecificationListContext _localctx = new SortSpecificationListContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_sortSpecificationList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2839);
			sortSpecification();
			setState(2844);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,266,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2840);
					match(COMMA);
					setState(2841);
					sortSpecification();
					}
					} 
				}
				setState(2846);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,266,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortSpecificationContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public OrderingSpecificationContext orderingSpecification() {
			return getRuleContext(OrderingSpecificationContext.class,0);
		}
		public NullOrderingContext nullOrdering() {
			return getRuleContext(NullOrderingContext.class,0);
		}
		public SortSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSortSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortSpecificationContext sortSpecification() throws RecognitionException {
		SortSpecificationContext _localctx = new SortSpecificationContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_sortSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2847);
			valueExpression();
			setState(2849);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(2848);
				orderingSpecification();
				}
				break;
			}
			setState(2852);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				{
				setState(2851);
				nullOrdering();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterClauseContext extends ParserRuleContext {
		public TerminalNode FILTER() { return getToken(SqlParser.FILTER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode WHERE() { return getToken(SqlParser.WHERE, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public FilterClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFilterClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterClauseContext filterClause() throws RecognitionException {
		FilterClauseContext _localctx = new FilterClauseContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_filterClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2854);
			match(FILTER);
			setState(2855);
			match(LEFT_PAREN);
			setState(2856);
			match(WHERE);
			setState(2857);
			booleanValueExpression(0);
			setState(2858);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingOperationContext extends ParserRuleContext {
		public TerminalNode GROUPING() { return getToken(SqlParser.GROUPING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ColumnReferenceContext> columnReference() {
			return getRuleContexts(ColumnReferenceContext.class);
		}
		public ColumnReferenceContext columnReference(int i) {
			return getRuleContext(ColumnReferenceContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public GroupingOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGroupingOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingOperationContext groupingOperation() throws RecognitionException {
		GroupingOperationContext _localctx = new GroupingOperationContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_groupingOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2860);
			match(GROUPING);
			setState(2861);
			match(LEFT_PAREN);
			setState(2862);
			columnReference();
			setState(2867);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2863);
				match(COMMA);
				setState(2864);
				columnReference();
				}
				}
				setState(2869);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2870);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFunctionContext extends ParserRuleContext {
		public WindowFunctionTypeContext windowFunctionType() {
			return getRuleContext(WindowFunctionTypeContext.class,0);
		}
		public TerminalNode OVER() { return getToken(SqlParser.OVER, 0); }
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public WindowSpecificationContext windowSpecification() {
			return getRuleContext(WindowSpecificationContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public WindowFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFunctionContext windowFunction() throws RecognitionException {
		WindowFunctionContext _localctx = new WindowFunctionContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_windowFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2872);
			windowFunctionType();
			setState(2873);
			match(OVER);
			setState(2879);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(2874);
				windowName();
				}
				break;
			case LEFT_PAREN:
				{
				setState(2875);
				match(LEFT_PAREN);
				setState(2876);
				windowSpecification();
				setState(2877);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFunctionTypeContext extends ParserRuleContext {
		public RankFunctionContext rankFunction() {
			return getRuleContext(RankFunctionContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode ROW_NUMBER() { return getToken(SqlParser.ROW_NUMBER, 0); }
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public WindowFunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFunctionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFunctionTypeContext windowFunctionType() throws RecognitionException {
		WindowFunctionTypeContext _localctx = new WindowFunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_windowFunctionType);
		try {
			setState(2889);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,271,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2881);
				rankFunction();
				setState(2882);
				match(LEFT_PAREN);
				setState(2883);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2885);
				match(ROW_NUMBER);
				setState(2886);
				match(LEFT_PAREN);
				setState(2887);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2888);
				aggregateFunction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowDefinitionContext extends ParserRuleContext {
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public WindowSpecificationContext windowSpecification() {
			return getRuleContext(WindowSpecificationContext.class,0);
		}
		public WindowDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowDefinitionContext windowDefinition() throws RecognitionException {
		WindowDefinitionContext _localctx = new WindowDefinitionContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_windowDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2891);
			windowName();
			setState(2892);
			match(AS);
			setState(2893);
			windowSpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowSpecificationContext extends ParserRuleContext {
		public WindowNameContext windowName() {
			return getRuleContext(WindowNameContext.class,0);
		}
		public WindowPartitionClauseContext windowPartitionClause() {
			return getRuleContext(WindowPartitionClauseContext.class,0);
		}
		public WindowOrderClauseContext windowOrderClause() {
			return getRuleContext(WindowOrderClauseContext.class,0);
		}
		public WindowFrameClauseContext windowFrameClause() {
			return getRuleContext(WindowFrameClauseContext.class,0);
		}
		public WindowSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowSpecificationContext windowSpecification() throws RecognitionException {
		WindowSpecificationContext _localctx = new WindowSpecificationContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_windowSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2896);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
			case 1:
				{
				setState(2895);
				windowName();
				}
				break;
			}
			setState(2899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				{
				setState(2898);
				windowPartitionClause();
				}
				break;
			}
			setState(2902);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				{
				setState(2901);
				windowOrderClause();
				}
				break;
			}
			setState(2905);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				{
				setState(2904);
				windowFrameClause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowPartitionClauseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SqlParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public List<ColumnReferenceContext> columnReference() {
			return getRuleContexts(ColumnReferenceContext.class);
		}
		public ColumnReferenceContext columnReference(int i) {
			return getRuleContext(ColumnReferenceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public WindowPartitionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowPartitionClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowPartitionClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowPartitionClauseContext windowPartitionClause() throws RecognitionException {
		WindowPartitionClauseContext _localctx = new WindowPartitionClauseContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_windowPartitionClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2907);
			match(PARTITION);
			setState(2908);
			match(BY);
			setState(2909);
			columnReference();
			setState(2914);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,276,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2910);
					match(COMMA);
					setState(2911);
					columnReference();
					}
					} 
				}
				setState(2916);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,276,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowOrderClauseContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public SortSpecificationListContext sortSpecificationList() {
			return getRuleContext(SortSpecificationListContext.class,0);
		}
		public WindowOrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowOrderClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowOrderClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowOrderClauseContext windowOrderClause() throws RecognitionException {
		WindowOrderClauseContext _localctx = new WindowOrderClauseContext(_ctx, getState());
		enterRule(_localctx, 448, RULE_windowOrderClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2917);
			match(ORDER);
			setState(2918);
			match(BY);
			setState(2919);
			sortSpecificationList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameClauseContext extends ParserRuleContext {
		public WindowFrameUnitsContext windowFrameUnits() {
			return getRuleContext(WindowFrameUnitsContext.class,0);
		}
		public WindowFrameStartContext windowFrameStart() {
			return getRuleContext(WindowFrameStartContext.class,0);
		}
		public WindowFrameBetweenContext windowFrameBetween() {
			return getRuleContext(WindowFrameBetweenContext.class,0);
		}
		public WindowFrameExclusionContext windowFrameExclusion() {
			return getRuleContext(WindowFrameExclusionContext.class,0);
		}
		public WindowFrameClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameClauseContext windowFrameClause() throws RecognitionException {
		WindowFrameClauseContext _localctx = new WindowFrameClauseContext(_ctx, getState());
		enterRule(_localctx, 450, RULE_windowFrameClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2921);
			windowFrameUnits();
			setState(2924);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case CURRENT:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_USER:
			case INTERVAL:
			case SESSION_USER:
			case SYSTEM_USER:
			case UNBOUNDED:
			case USER:
			case VALUE:
			case IDENTIFIER:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				{
				setState(2922);
				windowFrameStart();
				}
				break;
			case BETWEEN:
				{
				setState(2923);
				windowFrameBetween();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2927);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
			case 1:
				{
				setState(2926);
				windowFrameExclusion();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameStartContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED() { return getToken(SqlParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SqlParser.PRECEDING, 0); }
		public UnsignedValueSpecificationContext unsignedValueSpecification() {
			return getRuleContext(UnsignedValueSpecificationContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(SqlParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public WindowFrameStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameStart; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameStartContext windowFrameStart() throws RecognitionException {
		WindowFrameStartContext _localctx = new WindowFrameStartContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_windowFrameStart);
		try {
			setState(2936);
			switch (_input.LA(1)) {
			case UNBOUNDED:
				enterOuterAlt(_localctx, 1);
				{
				setState(2929);
				match(UNBOUNDED);
				setState(2930);
				match(PRECEDING);
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_USER:
			case INTERVAL:
			case SESSION_USER:
			case SYSTEM_USER:
			case USER:
			case VALUE:
			case IDENTIFIER:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(2931);
				unsignedValueSpecification();
				setState(2932);
				match(PRECEDING);
				}
				break;
			case CURRENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(2934);
				match(CURRENT);
				setState(2935);
				match(ROW);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameBetweenContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(SqlParser.BETWEEN, 0); }
		public WindowFrameBound1Context windowFrameBound1() {
			return getRuleContext(WindowFrameBound1Context.class,0);
		}
		public TerminalNode AND() { return getToken(SqlParser.AND, 0); }
		public WindowFrameBound2Context windowFrameBound2() {
			return getRuleContext(WindowFrameBound2Context.class,0);
		}
		public WindowFrameBetweenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBetween; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameBetween(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameBetweenContext windowFrameBetween() throws RecognitionException {
		WindowFrameBetweenContext _localctx = new WindowFrameBetweenContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_windowFrameBetween);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2938);
			match(BETWEEN);
			setState(2939);
			windowFrameBound1();
			setState(2940);
			match(AND);
			setState(2941);
			windowFrameBound2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameBound1Context extends ParserRuleContext {
		public WindowFrameBoundContext windowFrameBound() {
			return getRuleContext(WindowFrameBoundContext.class,0);
		}
		public WindowFrameBound1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBound1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameBound1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameBound1Context windowFrameBound1() throws RecognitionException {
		WindowFrameBound1Context _localctx = new WindowFrameBound1Context(_ctx, getState());
		enterRule(_localctx, 456, RULE_windowFrameBound1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2943);
			windowFrameBound();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameBound2Context extends ParserRuleContext {
		public WindowFrameBoundContext windowFrameBound() {
			return getRuleContext(WindowFrameBoundContext.class,0);
		}
		public WindowFrameBound2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBound2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameBound2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameBound2Context windowFrameBound2() throws RecognitionException {
		WindowFrameBound2Context _localctx = new WindowFrameBound2Context(_ctx, getState());
		enterRule(_localctx, 458, RULE_windowFrameBound2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2945);
			windowFrameBound();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameBoundContext extends ParserRuleContext {
		public WindowFrameStartContext windowFrameStart() {
			return getRuleContext(WindowFrameStartContext.class,0);
		}
		public TerminalNode UNBOUNDED() { return getToken(SqlParser.UNBOUNDED, 0); }
		public TerminalNode FOLLOWING() { return getToken(SqlParser.FOLLOWING, 0); }
		public UnsignedValueSpecificationContext unsignedValueSpecification() {
			return getRuleContext(UnsignedValueSpecificationContext.class,0);
		}
		public WindowFrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrameBound; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWindowFrameBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameBoundContext windowFrameBound() throws RecognitionException {
		WindowFrameBoundContext _localctx = new WindowFrameBoundContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_windowFrameBound);
		try {
			setState(2953);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,280,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2947);
				windowFrameStart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2948);
				match(UNBOUNDED);
				setState(2949);
				match(FOLLOWING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2950);
				unsignedValueSpecification();
				setState(2951);
				match(FOLLOWING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScalarSubqueryContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ScalarSubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarSubquery; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitScalarSubquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarSubqueryContext scalarSubquery() throws RecognitionException {
		ScalarSubqueryContext _localctx = new ScalarSubqueryContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_scalarSubquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2955);
			match(LEFT_PAREN);
			setState(2956);
			queryExpression();
			setState(2957);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseExpressionContext extends ParserRuleContext {
		public TerminalNode NULLIF() { return getToken(SqlParser.NULLIF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode COALESCE() { return getToken(SqlParser.COALESCE, 0); }
		public TerminalNode CASE() { return getToken(SqlParser.CASE, 0); }
		public RowValuePredicandContext rowValuePredicand() {
			return getRuleContext(RowValuePredicandContext.class,0);
		}
		public TerminalNode END() { return getToken(SqlParser.END, 0); }
		public TerminalNode OVERLAPS() { return getToken(SqlParser.OVERLAPS, 0); }
		public List<SimpleWhenClauseContext> simpleWhenClause() {
			return getRuleContexts(SimpleWhenClauseContext.class);
		}
		public SimpleWhenClauseContext simpleWhenClause(int i) {
			return getRuleContext(SimpleWhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SqlParser.ELSE, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public List<SearchedWhenClauseContext> searchedWhenClause() {
			return getRuleContexts(SearchedWhenClauseContext.class);
		}
		public SearchedWhenClauseContext searchedWhenClause(int i) {
			return getRuleContext(SearchedWhenClauseContext.class,i);
		}
		public CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCaseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseExpressionContext caseExpression() throws RecognitionException {
		CaseExpressionContext _localctx = new CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_caseExpression);
		int _la;
		try {
			setState(3006);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2959);
				match(NULLIF);
				setState(2960);
				match(LEFT_PAREN);
				setState(2961);
				valueExpression();
				setState(2962);
				match(COMMA);
				setState(2963);
				valueExpression();
				setState(2964);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2966);
				match(COALESCE);
				setState(2967);
				match(LEFT_PAREN);
				setState(2968);
				valueExpression();
				setState(2973);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(2969);
					match(COMMA);
					setState(2970);
					valueExpression();
					}
					}
					setState(2975);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2976);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2978);
				match(CASE);
				setState(2980);
				_la = _input.LA(1);
				if (_la==OVERLAPS) {
					{
					setState(2979);
					match(OVERLAPS);
					}
				}

				setState(2982);
				rowValuePredicand();
				setState(2984); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2983);
					simpleWhenClause();
					}
					}
					setState(2986); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(2990);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(2988);
					match(ELSE);
					setState(2989);
					result();
					}
				}

				setState(2992);
				match(END);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2994);
				match(CASE);
				setState(2996); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2995);
					searchedWhenClause();
					}
					}
					setState(2998); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(3002);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(3000);
					match(ELSE);
					setState(3001);
					result();
					}
				}

				setState(3004);
				match(END);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleWhenClauseContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(SqlParser.WHEN, 0); }
		public WhenOperandContext whenOperand() {
			return getRuleContext(WhenOperandContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SqlParser.THEN, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public SimpleWhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleWhenClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSimpleWhenClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleWhenClauseContext simpleWhenClause() throws RecognitionException {
		SimpleWhenClauseContext _localctx = new SimpleWhenClauseContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_simpleWhenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3008);
			match(WHEN);
			setState(3009);
			whenOperand();
			setState(3010);
			match(THEN);
			setState(3011);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SearchedWhenClauseContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(SqlParser.WHEN, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SqlParser.THEN, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public SearchedWhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchedWhenClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSearchedWhenClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchedWhenClauseContext searchedWhenClause() throws RecognitionException {
		SearchedWhenClauseContext _localctx = new SearchedWhenClauseContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_searchedWhenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3013);
			match(WHEN);
			setState(3014);
			booleanValueExpression(0);
			setState(3015);
			match(THEN);
			setState(3016);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_result);
		try {
			setState(3020);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case ABS:
			case ANY:
			case ARRAY:
			case AVG:
			case CARDINALITY:
			case CASE:
			case CAST:
			case CEIL:
			case CEILING:
			case CHARACTER_LENGTH:
			case CHAR_LENGTH:
			case COALESCE:
			case COLLECT:
			case COVAR_POP:
			case COVAR_SAMP:
			case COUNT:
			case CUME_DIST:
			case CURRENT_DATE:
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case CURRENT_USER:
			case DENSE_RANK:
			case DEREF:
			case ELEMENT:
			case EVERY:
			case EXISTS:
			case EXP:
			case EXTRACT:
			case FLOOR:
			case FUSION:
			case GROUPING:
			case INTERSECTION:
			case INTERVAL:
			case LN:
			case LOCALTIME:
			case LOCALTIMESTAMP:
			case LOWER:
			case MAX:
			case MIN:
			case MOD:
			case MULTISET:
			case NEW:
			case NEXT:
			case NORMALIZE:
			case NOT:
			case NULLIF:
			case OCTET_LENGTH:
			case PERCENT_RANK:
			case PERCENTILE_CONT:
			case PERCENTILE_DISC:
			case POWER:
			case RANK:
			case REGR_AVGX:
			case REGR_AVGY:
			case REGR_COUNT:
			case REGR_INTERCEPT:
			case REGR_RSQUARED:
			case REGR_SLOPE:
			case REGR_SXX:
			case REGR_SXY:
			case REGR_SYY:
			case ROW:
			case ROW_NUMBER:
			case SESSION_USER:
			case SET:
			case SOME:
			case SQRT:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBSTRING:
			case SUM:
			case SYSTEM_USER:
			case TABLE:
			case TREAT:
			case TRIM:
			case UNIQUE:
			case UPPER:
			case USER:
			case VALUE:
			case VAR_POP:
			case VAR_SAMP:
			case WIDTH_BUCKET:
			case IDENTIFIER:
			case CORR:
			case POSITION:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case LEFT_PAREN:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case PERIOD:
			case COLON:
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(3018);
				valueExpression();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3019);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenOperandContext extends ParserRuleContext {
		public RowValuePredicandContext rowValuePredicand() {
			return getRuleContext(RowValuePredicandContext.class,0);
		}
		public ComparisonConditionContext comparisonCondition() {
			return getRuleContext(ComparisonConditionContext.class,0);
		}
		public BetweenConditionContext betweenCondition() {
			return getRuleContext(BetweenConditionContext.class,0);
		}
		public InConditionContext inCondition() {
			return getRuleContext(InConditionContext.class,0);
		}
		public LikeConditionContext likeCondition() {
			return getRuleContext(LikeConditionContext.class,0);
		}
		public SimilarConditionContext similarCondition() {
			return getRuleContext(SimilarConditionContext.class,0);
		}
		public NullConditionContext nullCondition() {
			return getRuleContext(NullConditionContext.class,0);
		}
		public QuantifiedComparisonConditionContext quantifiedComparisonCondition() {
			return getRuleContext(QuantifiedComparisonConditionContext.class,0);
		}
		public MatchConditionContext matchCondition() {
			return getRuleContext(MatchConditionContext.class,0);
		}
		public OverlapsConditionContext overlapsCondition() {
			return getRuleContext(OverlapsConditionContext.class,0);
		}
		public DistinctConditionContext distinctCondition() {
			return getRuleContext(DistinctConditionContext.class,0);
		}
		public MemberConditionContext memberCondition() {
			return getRuleContext(MemberConditionContext.class,0);
		}
		public SubmultisetConditionContext submultisetCondition() {
			return getRuleContext(SubmultisetConditionContext.class,0);
		}
		public SetConditionContext setCondition() {
			return getRuleContext(SetConditionContext.class,0);
		}
		public TypeConditionContext typeCondition() {
			return getRuleContext(TypeConditionContext.class,0);
		}
		public WhenOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitWhenOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenOperandContext whenOperand() throws RecognitionException {
		WhenOperandContext _localctx = new WhenOperandContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_whenOperand);
		try {
			setState(3037);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,289,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3022);
				rowValuePredicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3023);
				comparisonCondition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3024);
				betweenCondition();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3025);
				inCondition();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3026);
				likeCondition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3027);
				similarCondition();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3028);
				nullCondition();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(3029);
				quantifiedComparisonCondition();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(3030);
				matchCondition();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(3031);
				overlapsCondition();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(3032);
				distinctCondition();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(3033);
				memberCondition();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(3034);
				submultisetCondition();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(3035);
				setCondition();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(3036);
				typeCondition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastSpecificationContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SqlParser.CAST, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public CastOperandContext castOperand() {
			return getRuleContext(CastOperandContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public CastSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastSpecificationContext castSpecification() throws RecognitionException {
		CastSpecificationContext _localctx = new CastSpecificationContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_castSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3039);
			match(CAST);
			setState(3040);
			match(LEFT_PAREN);
			setState(3041);
			castOperand();
			setState(3042);
			match(AS);
			setState(3043);
			dataType(0);
			setState(3044);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastOperandContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode ARRAY() { return getToken(SqlParser.ARRAY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public CastOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castOperand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastOperandContext castOperand() throws RecognitionException {
		CastOperandContext _localctx = new CastOperandContext(_ctx, getState());
		enterRule(_localctx, 476, RULE_castOperand);
		try {
			setState(3054);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3046);
				valueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3047);
				match(NULL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3048);
				match(ARRAY);
				setState(3049);
				match(LEFT_BRACKET);
				setState(3050);
				match(RIGHT_BRACKET);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3051);
				match(MULTISET);
				setState(3052);
				match(LEFT_BRACKET);
				setState(3053);
				match(RIGHT_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubtypeTreatmentContext extends ParserRuleContext {
		public TerminalNode TREAT() { return getToken(SqlParser.TREAT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public SubtypeTreatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtypeTreatment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSubtypeTreatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubtypeTreatmentContext subtypeTreatment() throws RecognitionException {
		SubtypeTreatmentContext _localctx = new SubtypeTreatmentContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_subtypeTreatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3056);
			match(TREAT);
			setState(3057);
			match(LEFT_PAREN);
			setState(3058);
			valueExpression();
			setState(3059);
			match(AS);
			setState(3062);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(3060);
				udtName();
				}
				break;
			case REF:
				{
				setState(3061);
				referenceType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(3064);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralizedInvocationContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode PERIOD() { return getToken(SqlParser.PERIOD, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public SqlArgumentListContext sqlArgumentList() {
			return getRuleContext(SqlArgumentListContext.class,0);
		}
		public GeneralizedInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalizedInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGeneralizedInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralizedInvocationContext generalizedInvocation() throws RecognitionException {
		GeneralizedInvocationContext _localctx = new GeneralizedInvocationContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_generalizedInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3066);
			match(LEFT_PAREN);
			setState(3067);
			valueExpressionPrimary(0);
			setState(3068);
			match(AS);
			setState(3069);
			dataType(0);
			setState(3070);
			match(RIGHT_PAREN);
			setState(3071);
			match(PERIOD);
			setState(3072);
			methodName();
			setState(3074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
			case 1:
				{
				setState(3073);
				sqlArgumentList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlArgumentListContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<SqlArgumentContext> sqlArgument() {
			return getRuleContexts(SqlArgumentContext.class);
		}
		public SqlArgumentContext sqlArgument(int i) {
			return getRuleContext(SqlArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SqlArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlArgumentList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSqlArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlArgumentListContext sqlArgumentList() throws RecognitionException {
		SqlArgumentListContext _localctx = new SqlArgumentListContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_sqlArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3076);
			match(LEFT_PAREN);
			setState(3085);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN_LITERAL) | (1L << TIMESTAMP_LITERAL) | (1L << TIME_LITERAL) | (1L << DATE_LITERAL) | (1L << BYTE_STRING_LITERAL) | (1L << BIT_STRING_LITERAL) | (1L << NATIONAL_CHARACTER_STRING_LITERAL) | (1L << ABS) | (1L << ANY) | (1L << ARRAY) | (1L << AVG) | (1L << CARDINALITY) | (1L << CASE) | (1L << CAST) | (1L << CEIL) | (1L << CEILING) | (1L << CHARACTER_LENGTH) | (1L << CHAR_LENGTH) | (1L << COALESCE) | (1L << COLLECT))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (COVAR_POP - 65)) | (1L << (COVAR_SAMP - 65)) | (1L << (COUNT - 65)) | (1L << (CUME_DIST - 65)) | (1L << (CURRENT_DATE - 65)) | (1L << (CURRENT_PATH - 65)) | (1L << (CURRENT_ROLE - 65)) | (1L << (CURRENT_TIME - 65)) | (1L << (CURRENT_TIMESTAMP - 65)) | (1L << (CURRENT_USER - 65)) | (1L << (DEFAULT - 65)) | (1L << (DENSE_RANK - 65)) | (1L << (DEREF - 65)) | (1L << (ELEMENT - 65)) | (1L << (EVERY - 65)) | (1L << (EXISTS - 65)) | (1L << (EXP - 65)) | (1L << (EXTRACT - 65)) | (1L << (FLOOR - 65)))) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & ((1L << (FUSION - 133)) | (1L << (GROUPING - 133)) | (1L << (INTERSECTION - 133)) | (1L << (INTERVAL - 133)) | (1L << (LN - 133)) | (1L << (LOCALTIME - 133)) | (1L << (LOCALTIMESTAMP - 133)) | (1L << (LOWER - 133)) | (1L << (MAX - 133)) | (1L << (MIN - 133)) | (1L << (MOD - 133)) | (1L << (MULTISET - 133)) | (1L << (NEW - 133)))) != 0) || ((((_la - 197)) & ~0x3f) == 0 && ((1L << (_la - 197)) & ((1L << (NEXT - 197)) | (1L << (NORMALIZE - 197)) | (1L << (NOT - 197)) | (1L << (NULL - 197)) | (1L << (NULLIF - 197)) | (1L << (OCTET_LENGTH - 197)) | (1L << (PERCENT_RANK - 197)) | (1L << (PERCENTILE_CONT - 197)) | (1L << (PERCENTILE_DISC - 197)) | (1L << (POWER - 197)) | (1L << (RANK - 197)) | (1L << (REGR_AVGX - 197)) | (1L << (REGR_AVGY - 197)) | (1L << (REGR_COUNT - 197)) | (1L << (REGR_INTERCEPT - 197)) | (1L << (REGR_RSQUARED - 197)) | (1L << (REGR_SLOPE - 197)) | (1L << (REGR_SXX - 197)) | (1L << (REGR_SXY - 197)) | (1L << (REGR_SYY - 197)))) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (ROW - 262)) | (1L << (ROW_NUMBER - 262)) | (1L << (SESSION_USER - 262)) | (1L << (SET - 262)) | (1L << (SOME - 262)) | (1L << (SQRT - 262)) | (1L << (STDDEV_POP - 262)) | (1L << (STDDEV_SAMP - 262)) | (1L << (SUBSTRING - 262)) | (1L << (SUM - 262)) | (1L << (SYSTEM_USER - 262)) | (1L << (TABLE - 262)) | (1L << (TREAT - 262)) | (1L << (TRIM - 262)) | (1L << (UNIQUE - 262)) | (1L << (UPPER - 262)) | (1L << (USER - 262)) | (1L << (VALUE - 262)))) != 0) || ((((_la - 326)) & ~0x3f) == 0 && ((1L << (_la - 326)) & ((1L << (VAR_POP - 326)) | (1L << (VAR_SAMP - 326)) | (1L << (WIDTH_BUCKET - 326)) | (1L << (IDENTIFIER - 326)) | (1L << (CORR - 326)))) != 0) || ((((_la - 450)) & ~0x3f) == 0 && ((1L << (_la - 450)) & ((1L << (POSITION - 450)) | (1L << (UNSIGNED_APPROXIMATE - 450)) | (1L << (UNSIGNED_INTEGER - 450)))) != 0) || ((((_la - 514)) & ~0x3f) == 0 && ((1L << (_la - 514)) & ((1L << (CHARACTER_STRING_LITERAL - 514)) | (1L << (LEFT_PAREN - 514)) | (1L << (PLUS_SIGN - 514)) | (1L << (MINUS_SIGN - 514)) | (1L << (PERIOD - 514)) | (1L << (COLON - 514)) | (1L << (QUESTION_MARK - 514)))) != 0)) {
				{
				setState(3077);
				sqlArgument();
				setState(3082);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3078);
					match(COMMA);
					setState(3079);
					sqlArgument();
					}
					}
					setState(3084);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(3087);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlArgumentContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public GeneralizedExpressionContext generalizedExpression() {
			return getRuleContext(GeneralizedExpressionContext.class,0);
		}
		public TargetSpecificationContext targetSpecification() {
			return getRuleContext(TargetSpecificationContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public TerminalNode NULL() { return getToken(SqlParser.NULL, 0); }
		public TerminalNode ARRAY() { return getToken(SqlParser.ARRAY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public SqlArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlArgument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSqlArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlArgumentContext sqlArgument() throws RecognitionException {
		SqlArgumentContext _localctx = new SqlArgumentContext(_ctx, getState());
		enterRule(_localctx, 484, RULE_sqlArgument);
		try {
			setState(3100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,295,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3089);
				valueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3090);
				generalizedExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3091);
				targetSpecification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3092);
				match(DEFAULT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3093);
				match(NULL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3094);
				match(ARRAY);
				setState(3095);
				match(LEFT_BRACKET);
				setState(3096);
				match(RIGHT_BRACKET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3097);
				match(MULTISET);
				setState(3098);
				match(LEFT_BRACKET);
				setState(3099);
				match(RIGHT_BRACKET);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralizedExpressionContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public GeneralizedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalizedExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGeneralizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralizedExpressionContext generalizedExpression() throws RecognitionException {
		GeneralizedExpressionContext _localctx = new GeneralizedExpressionContext(_ctx, getState());
		enterRule(_localctx, 486, RULE_generalizedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3102);
			valueExpression();
			setState(3103);
			match(AS);
			setState(3104);
			udtName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetSpecificationContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IndicatorVariableContext indicatorVariable() {
			return getRuleContext(IndicatorVariableContext.class,0);
		}
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public TargetArrayReferenceContext targetArrayReference() {
			return getRuleContext(TargetArrayReferenceContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public SimpleValueSpecificationContext simpleValueSpecification() {
			return getRuleContext(SimpleValueSpecificationContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public TerminalNode QUESTION_MARK() { return getToken(SqlParser.QUESTION_MARK, 0); }
		public TargetSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTargetSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetSpecificationContext targetSpecification() throws RecognitionException {
		TargetSpecificationContext _localctx = new TargetSpecificationContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_targetSpecification);
		int _la;
		try {
			setState(3117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3106);
				variableName();
				setState(3108);
				_la = _input.LA(1);
				if (_la==INDICATOR) {
					{
					setState(3107);
					indicatorVariable();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3110);
				identifierChain();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3111);
				targetArrayReference();
				setState(3112);
				match(LEFT_BRACKET);
				setState(3113);
				simpleValueSpecification();
				setState(3114);
				match(RIGHT_BRACKET);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3116);
				match(QUESTION_MARK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleTargetSpecificationContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IndicatorVariableContext indicatorVariable() {
			return getRuleContext(IndicatorVariableContext.class,0);
		}
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public SimpleTargetSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTargetSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSimpleTargetSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTargetSpecificationContext simpleTargetSpecification() throws RecognitionException {
		SimpleTargetSpecificationContext _localctx = new SimpleTargetSpecificationContext(_ctx, getState());
		enterRule(_localctx, 490, RULE_simpleTargetSpecification);
		int _la;
		try {
			setState(3124);
			switch (_input.LA(1)) {
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(3119);
				variableName();
				setState(3121);
				_la = _input.LA(1);
				if (_la==INDICATOR) {
					{
					setState(3120);
					indicatorVariable();
					}
				}

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(3123);
				identifierChain();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticMethodInvocationContext extends ParserRuleContext {
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public TerminalNode DOUBLE_COLON() { return getToken(SqlParser.DOUBLE_COLON, 0); }
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public SqlArgumentListContext sqlArgumentList() {
			return getRuleContext(SqlArgumentListContext.class,0);
		}
		public StaticMethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticMethodInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitStaticMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticMethodInvocationContext staticMethodInvocation() throws RecognitionException {
		StaticMethodInvocationContext _localctx = new StaticMethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 492, RULE_staticMethodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3126);
			udtName();
			setState(3127);
			match(DOUBLE_COLON);
			setState(3128);
			methodName();
			setState(3130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
			case 1:
				{
				setState(3129);
				sqlArgumentList();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewSpecificationContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(SqlParser.NEW, 0); }
		public RoutineInvocationContext routineInvocation() {
			return getRuleContext(RoutineInvocationContext.class,0);
		}
		public NewSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNewSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewSpecificationContext newSpecification() throws RecognitionException {
		NewSpecificationContext _localctx = new NewSpecificationContext(_ctx, getState());
		enterRule(_localctx, 494, RULE_newSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3132);
			match(NEW);
			setState(3133);
			routineInvocation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineInvocationContext extends ParserRuleContext {
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public SqlArgumentListContext sqlArgumentList() {
			return getRuleContext(SqlArgumentListContext.class,0);
		}
		public RoutineInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoutineInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineInvocationContext routineInvocation() throws RecognitionException {
		RoutineInvocationContext _localctx = new RoutineInvocationContext(_ctx, getState());
		enterRule(_localctx, 496, RULE_routineInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3135);
			routineName();
			setState(3136);
			sqlArgumentList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceResolutionContext extends ParserRuleContext {
		public TerminalNode DEREF() { return getToken(SqlParser.DEREF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public ValueExpressionPrimaryContext valueExpressionPrimary() {
			return getRuleContext(ValueExpressionPrimaryContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ReferenceResolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceResolution; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceResolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceResolutionContext referenceResolution() throws RecognitionException {
		ReferenceResolutionContext _localctx = new ReferenceResolutionContext(_ctx, getState());
		enterRule(_localctx, 498, RULE_referenceResolution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3138);
			match(DEREF);
			setState(3139);
			match(LEFT_PAREN);
			setState(3140);
			valueExpressionPrimary(0);
			setState(3141);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayValueConstructorContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(SqlParser.ARRAY, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode ORDER() { return getToken(SqlParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SqlParser.BY, 0); }
		public SortSpecificationListContext sortSpecificationList() {
			return getRuleContext(SortSpecificationListContext.class,0);
		}
		public ArrayValueConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValueConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitArrayValueConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValueConstructorContext arrayValueConstructor() throws RecognitionException {
		ArrayValueConstructorContext _localctx = new ArrayValueConstructorContext(_ctx, getState());
		enterRule(_localctx, 500, RULE_arrayValueConstructor);
		int _la;
		try {
			setState(3165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3143);
				match(ARRAY);
				setState(3144);
				match(LEFT_BRACKET);
				setState(3145);
				valueExpression();
				setState(3150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3146);
					match(COMMA);
					setState(3147);
					valueExpression();
					}
					}
					setState(3152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(3153);
				match(RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3155);
				match(ARRAY);
				setState(3156);
				match(LEFT_PAREN);
				setState(3157);
				queryExpression();
				setState(3161);
				_la = _input.LA(1);
				if (_la==ORDER) {
					{
					setState(3158);
					match(ORDER);
					setState(3159);
					match(BY);
					setState(3160);
					sortSpecificationList();
					}
				}

				setState(3163);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultisetValueConstructorContext extends ParserRuleContext {
		public TerminalNode MULTISET() { return getToken(SqlParser.MULTISET, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public MultisetValueConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multisetValueConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetValueConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultisetValueConstructorContext multisetValueConstructor() throws RecognitionException {
		MultisetValueConstructorContext _localctx = new MultisetValueConstructorContext(_ctx, getState());
		enterRule(_localctx, 502, RULE_multisetValueConstructor);
		int _la;
		try {
			setState(3189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3167);
				match(MULTISET);
				setState(3168);
				match(LEFT_BRACKET);
				setState(3169);
				valueExpression();
				setState(3174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3170);
					match(COMMA);
					setState(3171);
					valueExpression();
					}
					}
					setState(3176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(3177);
				match(RIGHT_BRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3179);
				match(MULTISET);
				setState(3180);
				match(LEFT_PAREN);
				setState(3181);
				queryExpression();
				setState(3182);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3184);
				match(TABLE);
				setState(3185);
				match(LEFT_PAREN);
				setState(3186);
				queryExpression();
				setState(3187);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultisetElementReferenceContext extends ParserRuleContext {
		public TerminalNode ELEMENT() { return getToken(SqlParser.ELEMENT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public MultisetValueExpressionContext multisetValueExpression() {
			return getRuleContext(MultisetValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public MultisetElementReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multisetElementReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMultisetElementReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultisetElementReferenceContext multisetElementReference() throws RecognitionException {
		MultisetElementReferenceContext _localctx = new MultisetElementReferenceContext(_ctx, getState());
		enterRule(_localctx, 504, RULE_multisetElementReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3191);
			match(ELEMENT);
			setState(3192);
			match(LEFT_PAREN);
			setState(3193);
			multisetValueExpression(0);
			setState(3194);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NextValueExpressionContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(SqlParser.NEXT, 0); }
		public TerminalNode VALUE() { return getToken(SqlParser.VALUE, 0); }
		public TerminalNode FOR() { return getToken(SqlParser.FOR, 0); }
		public SequenceNameContext sequenceName() {
			return getRuleContext(SequenceNameContext.class,0);
		}
		public NextValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextValueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitNextValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextValueExpressionContext nextValueExpression() throws RecognitionException {
		NextValueExpressionContext _localctx = new NextValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 506, RULE_nextValueExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3196);
			match(NEXT);
			setState(3197);
			match(VALUE);
			setState(3198);
			match(FOR);
			setState(3199);
			sequenceName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedValueSpecificationContext extends ParserRuleContext {
		public UnsignedLiteralContext unsignedLiteral() {
			return getRuleContext(UnsignedLiteralContext.class,0);
		}
		public GeneralValueSpecificationContext generalValueSpecification() {
			return getRuleContext(GeneralValueSpecificationContext.class,0);
		}
		public UnsignedValueSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedValueSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUnsignedValueSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedValueSpecificationContext unsignedValueSpecification() throws RecognitionException {
		UnsignedValueSpecificationContext _localctx = new UnsignedValueSpecificationContext(_ctx, getState());
		enterRule(_localctx, 508, RULE_unsignedValueSpecification);
		try {
			setState(3203);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case INTERVAL:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case PERIOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(3201);
				unsignedLiteral();
				}
				break;
			case CURRENT_PATH:
			case CURRENT_ROLE:
			case CURRENT_USER:
			case SESSION_USER:
			case SYSTEM_USER:
			case USER:
			case VALUE:
			case IDENTIFIER:
			case COLON:
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(3202);
				generalValueSpecification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralValueSpecificationContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode QUESTION_MARK() { return getToken(SqlParser.QUESTION_MARK, 0); }
		public TerminalNode CURRENT_PATH() { return getToken(SqlParser.CURRENT_PATH, 0); }
		public TerminalNode CURRENT_ROLE() { return getToken(SqlParser.CURRENT_ROLE, 0); }
		public TerminalNode CURRENT_USER() { return getToken(SqlParser.CURRENT_USER, 0); }
		public TerminalNode SESSION_USER() { return getToken(SqlParser.SESSION_USER, 0); }
		public TerminalNode SYSTEM_USER() { return getToken(SqlParser.SYSTEM_USER, 0); }
		public TerminalNode USER() { return getToken(SqlParser.USER, 0); }
		public TerminalNode VALUE() { return getToken(SqlParser.VALUE, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IndicatorVariableContext indicatorVariable() {
			return getRuleContext(IndicatorVariableContext.class,0);
		}
		public GeneralValueSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalValueSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGeneralValueSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralValueSpecificationContext generalValueSpecification() throws RecognitionException {
		GeneralValueSpecificationContext _localctx = new GeneralValueSpecificationContext(_ctx, getState());
		enterRule(_localctx, 510, RULE_generalValueSpecification);
		try {
			setState(3218);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3205);
				reference();
				}
				break;
			case QUESTION_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(3206);
				match(QUESTION_MARK);
				}
				break;
			case CURRENT_PATH:
				enterOuterAlt(_localctx, 3);
				{
				setState(3207);
				match(CURRENT_PATH);
				}
				break;
			case CURRENT_ROLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(3208);
				match(CURRENT_ROLE);
				}
				break;
			case CURRENT_USER:
				enterOuterAlt(_localctx, 5);
				{
				setState(3209);
				match(CURRENT_USER);
				}
				break;
			case SESSION_USER:
				enterOuterAlt(_localctx, 6);
				{
				setState(3210);
				match(SESSION_USER);
				}
				break;
			case SYSTEM_USER:
				enterOuterAlt(_localctx, 7);
				{
				setState(3211);
				match(SYSTEM_USER);
				}
				break;
			case USER:
				enterOuterAlt(_localctx, 8);
				{
				setState(3212);
				match(USER);
				}
				break;
			case VALUE:
				enterOuterAlt(_localctx, 9);
				{
				setState(3213);
				match(VALUE);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 10);
				{
				setState(3214);
				variableName();
				setState(3216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
				case 1:
					{
					setState(3215);
					indicatorVariable();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 512, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3220);
			identifierChain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndicatorVariableContext extends ParserRuleContext {
		public TerminalNode INDICATOR() { return getToken(SqlParser.INDICATOR, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IndicatorVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indicatorVariable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIndicatorVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndicatorVariableContext indicatorVariable() throws RecognitionException {
		IndicatorVariableContext _localctx = new IndicatorVariableContext(_ctx, getState());
		enterRule(_localctx, 514, RULE_indicatorVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3222);
			match(INDICATOR);
			setState(3223);
			variableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleValueSpecificationContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public IndicatorVariableContext indicatorVariable() {
			return getRuleContext(IndicatorVariableContext.class,0);
		}
		public IdentifierChainContext identifierChain() {
			return getRuleContext(IdentifierChainContext.class,0);
		}
		public SimpleValueSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleValueSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSimpleValueSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleValueSpecificationContext simpleValueSpecification() throws RecognitionException {
		SimpleValueSpecificationContext _localctx = new SimpleValueSpecificationContext(_ctx, getState());
		enterRule(_localctx, 516, RULE_simpleValueSpecification);
		int _la;
		try {
			setState(3231);
			switch (_input.LA(1)) {
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case INTERVAL:
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case CHARACTER_STRING_LITERAL:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case PERIOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(3225);
				literal();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(3226);
				variableName();
				setState(3228);
				_la = _input.LA(1);
				if (_la==INDICATOR) {
					{
					setState(3227);
					indicatorVariable();
					}
				}

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(3230);
				identifierChain();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public UnsignedNumericLiteralContext unsignedNumericLiteral() {
			return getRuleContext(UnsignedNumericLiteralContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public GeneralLiteralContext generalLiteral() {
			return getRuleContext(GeneralLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 518, RULE_literal);
		int _la;
		try {
			setState(3238);
			switch (_input.LA(1)) {
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case PLUS_SIGN:
			case MINUS_SIGN:
			case PERIOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(3234);
				_la = _input.LA(1);
				if (_la==PLUS_SIGN || _la==MINUS_SIGN) {
					{
					setState(3233);
					sign();
					}
				}

				setState(3236);
				unsignedNumericLiteral();
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case INTERVAL:
			case CHARACTER_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3237);
				generalLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedLiteralContext extends ParserRuleContext {
		public UnsignedNumericLiteralContext unsignedNumericLiteral() {
			return getRuleContext(UnsignedNumericLiteralContext.class,0);
		}
		public GeneralLiteralContext generalLiteral() {
			return getRuleContext(GeneralLiteralContext.class,0);
		}
		public UnsignedLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUnsignedLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedLiteralContext unsignedLiteral() throws RecognitionException {
		UnsignedLiteralContext _localctx = new UnsignedLiteralContext(_ctx, getState());
		enterRule(_localctx, 520, RULE_unsignedLiteral);
		try {
			setState(3242);
			switch (_input.LA(1)) {
			case UNSIGNED_APPROXIMATE:
			case UNSIGNED_INTEGER:
			case PERIOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(3240);
				unsignedNumericLiteral();
				}
				break;
			case BOOLEAN_LITERAL:
			case TIMESTAMP_LITERAL:
			case TIME_LITERAL:
			case DATE_LITERAL:
			case BYTE_STRING_LITERAL:
			case BIT_STRING_LITERAL:
			case NATIONAL_CHARACTER_STRING_LITERAL:
			case INTERVAL:
			case CHARACTER_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3241);
				generalLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedNumericLiteralContext extends ParserRuleContext {
		public TerminalNode UNSIGNED_APPROXIMATE() { return getToken(SqlParser.UNSIGNED_APPROXIMATE, 0); }
		public ExactNumericLiteralContext exactNumericLiteral() {
			return getRuleContext(ExactNumericLiteralContext.class,0);
		}
		public UnsignedNumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedNumericLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUnsignedNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedNumericLiteralContext unsignedNumericLiteral() throws RecognitionException {
		UnsignedNumericLiteralContext _localctx = new UnsignedNumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 522, RULE_unsignedNumericLiteral);
		try {
			setState(3246);
			switch (_input.LA(1)) {
			case UNSIGNED_APPROXIMATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3244);
				match(UNSIGNED_APPROXIMATE);
				}
				break;
			case UNSIGNED_INTEGER:
			case PERIOD:
				enterOuterAlt(_localctx, 2);
				{
				setState(3245);
				exactNumericLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExactNumericLiteralContext extends ParserRuleContext {
		public List<TerminalNode> UNSIGNED_INTEGER() { return getTokens(SqlParser.UNSIGNED_INTEGER); }
		public TerminalNode UNSIGNED_INTEGER(int i) {
			return getToken(SqlParser.UNSIGNED_INTEGER, i);
		}
		public TerminalNode PERIOD() { return getToken(SqlParser.PERIOD, 0); }
		public ExactNumericLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exactNumericLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExactNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExactNumericLiteralContext exactNumericLiteral() throws RecognitionException {
		ExactNumericLiteralContext _localctx = new ExactNumericLiteralContext(_ctx, getState());
		enterRule(_localctx, 524, RULE_exactNumericLiteral);
		try {
			setState(3255);
			switch (_input.LA(1)) {
			case UNSIGNED_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3248);
				match(UNSIGNED_INTEGER);
				setState(3251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
				case 1:
					{
					setState(3249);
					match(PERIOD);
					setState(3250);
					match(UNSIGNED_INTEGER);
					}
					break;
				}
				}
				break;
			case PERIOD:
				enterOuterAlt(_localctx, 2);
				{
				setState(3253);
				match(PERIOD);
				setState(3254);
				match(UNSIGNED_INTEGER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GeneralLiteralContext extends ParserRuleContext {
		public TerminalNode CHARACTER_STRING_LITERAL() { return getToken(SqlParser.CHARACTER_STRING_LITERAL, 0); }
		public TerminalNode NATIONAL_CHARACTER_STRING_LITERAL() { return getToken(SqlParser.NATIONAL_CHARACTER_STRING_LITERAL, 0); }
		public TerminalNode BIT_STRING_LITERAL() { return getToken(SqlParser.BIT_STRING_LITERAL, 0); }
		public TerminalNode BYTE_STRING_LITERAL() { return getToken(SqlParser.BYTE_STRING_LITERAL, 0); }
		public TerminalNode DATE_LITERAL() { return getToken(SqlParser.DATE_LITERAL, 0); }
		public TerminalNode TIME_LITERAL() { return getToken(SqlParser.TIME_LITERAL, 0); }
		public TerminalNode TIMESTAMP_LITERAL() { return getToken(SqlParser.TIMESTAMP_LITERAL, 0); }
		public IntervalLiteralContext intervalLiteral() {
			return getRuleContext(IntervalLiteralContext.class,0);
		}
		public TerminalNode BOOLEAN_LITERAL() { return getToken(SqlParser.BOOLEAN_LITERAL, 0); }
		public GeneralLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitGeneralLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralLiteralContext generalLiteral() throws RecognitionException {
		GeneralLiteralContext _localctx = new GeneralLiteralContext(_ctx, getState());
		enterRule(_localctx, 526, RULE_generalLiteral);
		try {
			setState(3266);
			switch (_input.LA(1)) {
			case CHARACTER_STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3257);
				match(CHARACTER_STRING_LITERAL);
				}
				break;
			case NATIONAL_CHARACTER_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(3258);
				match(NATIONAL_CHARACTER_STRING_LITERAL);
				}
				break;
			case BIT_STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(3259);
				match(BIT_STRING_LITERAL);
				}
				break;
			case BYTE_STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(3260);
				match(BYTE_STRING_LITERAL);
				}
				break;
			case DATE_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(3261);
				match(DATE_LITERAL);
				}
				break;
			case TIME_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(3262);
				match(TIME_LITERAL);
				}
				break;
			case TIMESTAMP_LITERAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(3263);
				match(TIMESTAMP_LITERAL);
				}
				break;
			case INTERVAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(3264);
				intervalLiteral();
				}
				break;
			case BOOLEAN_LITERAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(3265);
				match(BOOLEAN_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalLiteralContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(SqlParser.INTERVAL, 0); }
		public TerminalNode CHARACTER_STRING_LITERAL() { return getToken(SqlParser.CHARACTER_STRING_LITERAL, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public IntervalQualifierContext intervalQualifier() {
			return getRuleContext(IntervalQualifierContext.class,0);
		}
		public IntervalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitIntervalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalLiteralContext intervalLiteral() throws RecognitionException {
		IntervalLiteralContext _localctx = new IntervalLiteralContext(_ctx, getState());
		enterRule(_localctx, 528, RULE_intervalLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3268);
			match(INTERVAL);
			setState(3270);
			_la = _input.LA(1);
			if (_la==PLUS_SIGN || _la==MINUS_SIGN) {
				{
				setState(3269);
				sign();
				}
			}

			setState(3272);
			match(CHARACTER_STRING_LITERAL);
			setState(3274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
			case 1:
				{
				setState(3273);
				intervalQualifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropTypeStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode TYPE() { return getToken(SqlParser.TYPE, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public DropTypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTypeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropTypeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropTypeStatementContext dropTypeStatement() throws RecognitionException {
		DropTypeStatementContext _localctx = new DropTypeStatementContext(_ctx, getState());
		enterRule(_localctx, 530, RULE_dropTypeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3276);
			match(DROP);
			setState(3277);
			match(TYPE);
			setState(3278);
			udtName();
			setState(3279);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTypeStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode TYPE() { return getToken(SqlParser.TYPE, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public SubTypeClauseContext subTypeClause() {
			return getRuleContext(SubTypeClauseContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public UdtOptionsContext udtOptions() {
			return getRuleContext(UdtOptionsContext.class,0);
		}
		public MethodSpecificationsContext methodSpecifications() {
			return getRuleContext(MethodSpecificationsContext.class,0);
		}
		public PredefinedTypeContext predefinedType() {
			return getRuleContext(PredefinedTypeContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public AttributeDefinitionsContext attributeDefinitions() {
			return getRuleContext(AttributeDefinitionsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public CreateTypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTypeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateTypeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTypeStatementContext createTypeStatement() throws RecognitionException {
		CreateTypeStatementContext _localctx = new CreateTypeStatementContext(_ctx, getState());
		enterRule(_localctx, 532, RULE_createTypeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3281);
			match(CREATE);
			setState(3282);
			match(TYPE);
			setState(3283);
			udtName();
			setState(3285);
			_la = _input.LA(1);
			if (_la==UNDER) {
				{
				setState(3284);
				subTypeClause();
				}
			}

			setState(3295);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3287);
				match(AS);
				setState(3293);
				switch (_input.LA(1)) {
				case BIGINT:
				case BINARY:
				case BLOB:
				case BOOLEAN:
				case CHAR:
				case CHARACTER:
				case CLOB:
				case DATE:
				case DEC:
				case DECIMAL:
				case DOUBLE:
				case FLOAT:
				case INT:
				case INTEGER:
				case INTERVAL:
				case NATIONAL:
				case NCHAR:
				case NCLOB:
				case NUMERIC:
				case REAL:
				case SMALLINT:
				case TIME:
				case TIMESTAMP:
				case VARBINARY:
				case VARCHAR:
				case XML:
					{
					setState(3288);
					predefinedType();
					}
					break;
				case LEFT_PAREN:
					{
					setState(3289);
					match(LEFT_PAREN);
					setState(3290);
					attributeDefinitions();
					setState(3291);
					match(RIGHT_PAREN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(3298);
			_la = _input.LA(1);
			if (_la==CAST || _la==FINAL || _la==INSTANTIABLE || _la==NOT || _la==REF) {
				{
				setState(3297);
				udtOptions();
				}
			}

			setState(3301);
			_la = _input.LA(1);
			if (_la==INSTANCE || _la==METHOD || _la==OVERRIDING || _la==STATIC || _la==CONSTRUCTOR) {
				{
				setState(3300);
				methodSpecifications();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterTypeStatementContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(SqlParser.ALTER, 0); }
		public TerminalNode TYPE() { return getToken(SqlParser.TYPE, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public AlterTypeActionContext alterTypeAction() {
			return getRuleContext(AlterTypeActionContext.class,0);
		}
		public AlterTypeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTypeStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAlterTypeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterTypeStatementContext alterTypeStatement() throws RecognitionException {
		AlterTypeStatementContext _localctx = new AlterTypeStatementContext(_ctx, getState());
		enterRule(_localctx, 534, RULE_alterTypeStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3303);
			match(ALTER);
			setState(3304);
			match(TYPE);
			setState(3305);
			udtName();
			setState(3306);
			alterTypeAction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlterTypeActionContext extends ParserRuleContext {
		public AlterTypeActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTypeAction; }
	 
		public AlterTypeActionContext() { }
		public void copyFrom(AlterTypeActionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddAttributeDefinitionContext extends AlterTypeActionContext {
		public TerminalNode ADD() { return getToken(SqlParser.ADD, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(SqlParser.ATTRIBUTE, 0); }
		public AttributeDefinitionContext attributeDefinition() {
			return getRuleContext(AttributeDefinitionContext.class,0);
		}
		public AddAttributeDefinitionContext(AlterTypeActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddAttributeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropAttributeDefinitionContext extends AlterTypeActionContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(SqlParser.ATTRIBUTE, 0); }
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public TerminalNode RESTRICT() { return getToken(SqlParser.RESTRICT, 0); }
		public DropAttributeDefinitionContext(AlterTypeActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropAttributeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropMethodSpecificationContext extends AlterTypeActionContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public MethodDesignatorContext methodDesignator() {
			return getRuleContext(MethodDesignatorContext.class,0);
		}
		public TerminalNode RESTRICT() { return getToken(SqlParser.RESTRICT, 0); }
		public DropMethodSpecificationContext(AlterTypeActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropMethodSpecification(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddMethodSpecificationContext extends AlterTypeActionContext {
		public TerminalNode ADD() { return getToken(SqlParser.ADD, 0); }
		public MethodSpecificationContext methodSpecification() {
			return getRuleContext(MethodSpecificationContext.class,0);
		}
		public AddMethodSpecificationContext(AlterTypeActionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddMethodSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterTypeActionContext alterTypeAction() throws RecognitionException {
		AlterTypeActionContext _localctx = new AlterTypeActionContext(_ctx, getState());
		enterRule(_localctx, 536, RULE_alterTypeAction);
		try {
			setState(3322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
			case 1:
				_localctx = new AddAttributeDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(3308);
				match(ADD);
				setState(3309);
				match(ATTRIBUTE);
				setState(3310);
				attributeDefinition();
				}
				break;
			case 2:
				_localctx = new DropAttributeDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(3311);
				match(DROP);
				setState(3312);
				match(ATTRIBUTE);
				setState(3313);
				attributeName();
				setState(3314);
				match(RESTRICT);
				}
				break;
			case 3:
				_localctx = new AddMethodSpecificationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(3316);
				match(ADD);
				setState(3317);
				methodSpecification();
				}
				break;
			case 4:
				_localctx = new DropMethodSpecificationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(3318);
				match(DROP);
				setState(3319);
				methodDesignator();
				setState(3320);
				match(RESTRICT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDesignatorContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(SqlParser.METHOD, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public MethodDesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDesignator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMethodDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDesignatorContext methodDesignator() throws RecognitionException {
		MethodDesignatorContext _localctx = new MethodDesignatorContext(_ctx, getState());
		enterRule(_localctx, 538, RULE_methodDesignator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3325);
			_la = _input.LA(1);
			if (_la==INSTANCE || _la==STATIC || _la==CONSTRUCTOR) {
				{
				setState(3324);
				methodType();
				}
			}

			setState(3327);
			match(METHOD);
			setState(3328);
			match(IDENTIFIER);
			setState(3329);
			match(LEFT_PAREN);
			setState(3338);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)))) != 0) || ((((_la - 157)) & ~0x3f) == 0 && ((1L << (_la - 157)) & ((1L << (INT - 157)) | (1L << (INTEGER - 157)) | (1L << (INTERVAL - 157)) | (1L << (NATIONAL - 157)) | (1L << (NCHAR - 157)) | (1L << (NCLOB - 157)) | (1L << (NUMERIC - 157)))) != 0) || ((((_la - 238)) & ~0x3f) == 0 && ((1L << (_la - 238)) & ((1L << (REAL - 238)) | (1L << (REF - 238)) | (1L << (ROW - 238)) | (1L << (SMALLINT - 238)) | (1L << (TIME - 238)))) != 0) || ((((_la - 302)) & ~0x3f) == 0 && ((1L << (_la - 302)) & ((1L << (TIMESTAMP - 302)) | (1L << (VARBINARY - 302)) | (1L << (VARCHAR - 302)) | (1L << (XML - 302)) | (1L << (IDENTIFIER - 302)))) != 0)) {
				{
				setState(3330);
				dataType(0);
				setState(3335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3331);
					match(COMMA);
					setState(3332);
					dataType(0);
					}
					}
					setState(3337);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(3340);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubTypeClauseContext extends ParserRuleContext {
		public TerminalNode UNDER() { return getToken(SqlParser.UNDER, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public SubTypeClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subTypeClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSubTypeClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubTypeClauseContext subTypeClause() throws RecognitionException {
		SubTypeClauseContext _localctx = new SubTypeClauseContext(_ctx, getState());
		enterRule(_localctx, 540, RULE_subTypeClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3342);
			match(UNDER);
			setState(3343);
			udtName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeDefinitionsContext extends ParserRuleContext {
		public List<AttributeDefinitionContext> attributeDefinition() {
			return getRuleContexts(AttributeDefinitionContext.class);
		}
		public AttributeDefinitionContext attributeDefinition(int i) {
			return getRuleContext(AttributeDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public AttributeDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDefinitions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAttributeDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeDefinitionsContext attributeDefinitions() throws RecognitionException {
		AttributeDefinitionsContext _localctx = new AttributeDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 542, RULE_attributeDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3345);
			attributeDefinition();
			setState(3350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3346);
				match(COMMA);
				setState(3347);
				attributeDefinition();
				}
				}
				setState(3352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeDefinitionContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ReferenceScopeCheckContext referenceScopeCheck() {
			return getRuleContext(ReferenceScopeCheckContext.class,0);
		}
		public DeleteActionContext deleteAction() {
			return getRuleContext(DeleteActionContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public DefaultOptionContext defaultOption() {
			return getRuleContext(DefaultOptionContext.class,0);
		}
		public AttributeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAttributeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeDefinitionContext attributeDefinition() throws RecognitionException {
		AttributeDefinitionContext _localctx = new AttributeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 544, RULE_attributeDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3353);
			attributeName();
			setState(3354);
			dataType(0);
			setState(3356);
			_la = _input.LA(1);
			if (_la==REFERENCES) {
				{
				setState(3355);
				referenceScopeCheck();
				}
			}

			setState(3359);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(3358);
				deleteAction();
				}
			}

			setState(3363);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(3361);
				match(DEFAULT);
				setState(3362);
				defaultOption();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtOptionsContext extends ParserRuleContext {
		public List<UdtOptionContext> udtOption() {
			return getRuleContexts(UdtOptionContext.class);
		}
		public UdtOptionContext udtOption(int i) {
			return getRuleContext(UdtOptionContext.class,i);
		}
		public UdtOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtOptions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUdtOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtOptionsContext udtOptions() throws RecognitionException {
		UdtOptionsContext _localctx = new UdtOptionsContext(_ctx, getState());
		enterRule(_localctx, 546, RULE_udtOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3366); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3365);
				udtOption();
				}
				}
				setState(3368); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CAST || _la==FINAL || _la==INSTANTIABLE || _la==NOT || _la==REF );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UdtOptionContext extends ParserRuleContext {
		public InstantiabilityContext instantiability() {
			return getRuleContext(InstantiabilityContext.class,0);
		}
		public FinalityContext finality() {
			return getRuleContext(FinalityContext.class,0);
		}
		public ReferenceTypeSpecificationContext referenceTypeSpecification() {
			return getRuleContext(ReferenceTypeSpecificationContext.class,0);
		}
		public RefCastOptionContext refCastOption() {
			return getRuleContext(RefCastOptionContext.class,0);
		}
		public CastOptionContext castOption() {
			return getRuleContext(CastOptionContext.class,0);
		}
		public UdtOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_udtOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUdtOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UdtOptionContext udtOption() throws RecognitionException {
		UdtOptionContext _localctx = new UdtOptionContext(_ctx, getState());
		enterRule(_localctx, 548, RULE_udtOption);
		try {
			setState(3375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3370);
				instantiability();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3371);
				finality();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3372);
				referenceTypeSpecification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3373);
				refCastOption();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3374);
				castOption();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceTypeSpecificationContext extends ParserRuleContext {
		public UserDefinedRepresentationContext userDefinedRepresentation() {
			return getRuleContext(UserDefinedRepresentationContext.class,0);
		}
		public DerivedRepresentationContext derivedRepresentation() {
			return getRuleContext(DerivedRepresentationContext.class,0);
		}
		public SystemGeneratedRepresentationContext systemGeneratedRepresentation() {
			return getRuleContext(SystemGeneratedRepresentationContext.class,0);
		}
		public ReferenceTypeSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceTypeSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReferenceTypeSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeSpecificationContext referenceTypeSpecification() throws RecognitionException {
		ReferenceTypeSpecificationContext _localctx = new ReferenceTypeSpecificationContext(_ctx, getState());
		enterRule(_localctx, 550, RULE_referenceTypeSpecification);
		try {
			setState(3380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3377);
				userDefinedRepresentation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3378);
				derivedRepresentation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3379);
				systemGeneratedRepresentation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UserDefinedRepresentationContext extends ParserRuleContext {
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode USING() { return getToken(SqlParser.USING, 0); }
		public PredefinedTypeContext predefinedType() {
			return getRuleContext(PredefinedTypeContext.class,0);
		}
		public UserDefinedRepresentationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userDefinedRepresentation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUserDefinedRepresentation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserDefinedRepresentationContext userDefinedRepresentation() throws RecognitionException {
		UserDefinedRepresentationContext _localctx = new UserDefinedRepresentationContext(_ctx, getState());
		enterRule(_localctx, 552, RULE_userDefinedRepresentation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3382);
			match(REF);
			setState(3383);
			match(USING);
			setState(3384);
			predefinedType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DerivedRepresentationContext extends ParserRuleContext {
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public DerivedRepresentationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derivedRepresentation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDerivedRepresentation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DerivedRepresentationContext derivedRepresentation() throws RecognitionException {
		DerivedRepresentationContext _localctx = new DerivedRepresentationContext(_ctx, getState());
		enterRule(_localctx, 554, RULE_derivedRepresentation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3386);
			match(REF);
			setState(3387);
			match(FROM);
			setState(3388);
			match(LEFT_PAREN);
			setState(3389);
			attributeName();
			setState(3394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3390);
				match(COMMA);
				setState(3391);
				attributeName();
				}
				}
				setState(3396);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3397);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SystemGeneratedRepresentationContext extends ParserRuleContext {
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode IS() { return getToken(SqlParser.IS, 0); }
		public TerminalNode SYSTEM() { return getToken(SqlParser.SYSTEM, 0); }
		public TerminalNode GENERATED() { return getToken(SqlParser.GENERATED, 0); }
		public SystemGeneratedRepresentationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemGeneratedRepresentation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSystemGeneratedRepresentation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemGeneratedRepresentationContext systemGeneratedRepresentation() throws RecognitionException {
		SystemGeneratedRepresentationContext _localctx = new SystemGeneratedRepresentationContext(_ctx, getState());
		enterRule(_localctx, 556, RULE_systemGeneratedRepresentation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3399);
			match(REF);
			setState(3400);
			match(IS);
			setState(3401);
			match(SYSTEM);
			setState(3402);
			match(GENERATED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefCastOptionContext extends ParserRuleContext {
		public CastToRefContext castToRef() {
			return getRuleContext(CastToRefContext.class,0);
		}
		public CastToTypeContext castToType() {
			return getRuleContext(CastToTypeContext.class,0);
		}
		public RefCastOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refCastOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRefCastOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefCastOptionContext refCastOption() throws RecognitionException {
		RefCastOptionContext _localctx = new RefCastOptionContext(_ctx, getState());
		enterRule(_localctx, 558, RULE_refCastOption);
		try {
			setState(3406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,337,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3404);
				castToRef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3405);
				castToType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastToRefContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SqlParser.CAST, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode SOURCE() { return getToken(SqlParser.SOURCE, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public CastIdentifierContext castIdentifier() {
			return getRuleContext(CastIdentifierContext.class,0);
		}
		public CastToRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castToRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastToRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastToRefContext castToRef() throws RecognitionException {
		CastToRefContext _localctx = new CastToRefContext(_ctx, getState());
		enterRule(_localctx, 560, RULE_castToRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3408);
			match(CAST);
			setState(3409);
			match(LEFT_PAREN);
			setState(3410);
			match(SOURCE);
			setState(3411);
			match(AS);
			setState(3412);
			match(REF);
			setState(3413);
			match(RIGHT_PAREN);
			setState(3414);
			match(WITH);
			setState(3415);
			castIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastToTypeContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SqlParser.CAST, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode REF() { return getToken(SqlParser.REF, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode SOURCE() { return getToken(SqlParser.SOURCE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public CastIdentifierContext castIdentifier() {
			return getRuleContext(CastIdentifierContext.class,0);
		}
		public CastToTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castToType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastToType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastToTypeContext castToType() throws RecognitionException {
		CastToTypeContext _localctx = new CastToTypeContext(_ctx, getState());
		enterRule(_localctx, 562, RULE_castToType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3417);
			match(CAST);
			setState(3418);
			match(LEFT_PAREN);
			setState(3419);
			match(REF);
			setState(3420);
			match(AS);
			setState(3421);
			match(SOURCE);
			setState(3422);
			match(RIGHT_PAREN);
			setState(3423);
			match(WITH);
			setState(3424);
			castIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastOptionContext extends ParserRuleContext {
		public CastToDistinctContext castToDistinct() {
			return getRuleContext(CastToDistinctContext.class,0);
		}
		public CastToSourceContext castToSource() {
			return getRuleContext(CastToSourceContext.class,0);
		}
		public CastOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastOptionContext castOption() throws RecognitionException {
		CastOptionContext _localctx = new CastOptionContext(_ctx, getState());
		enterRule(_localctx, 564, RULE_castOption);
		try {
			setState(3428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,338,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3426);
				castToDistinct();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3427);
				castToSource();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastToDistinctContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SqlParser.CAST, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode SOURCE() { return getToken(SqlParser.SOURCE, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlParser.DISTINCT, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public CastIdentifierContext castIdentifier() {
			return getRuleContext(CastIdentifierContext.class,0);
		}
		public CastToDistinctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castToDistinct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastToDistinct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastToDistinctContext castToDistinct() throws RecognitionException {
		CastToDistinctContext _localctx = new CastToDistinctContext(_ctx, getState());
		enterRule(_localctx, 566, RULE_castToDistinct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3430);
			match(CAST);
			setState(3431);
			match(LEFT_PAREN);
			setState(3432);
			match(SOURCE);
			setState(3433);
			match(AS);
			setState(3434);
			match(DISTINCT);
			setState(3435);
			match(RIGHT_PAREN);
			setState(3436);
			match(WITH);
			setState(3437);
			castIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastToSourceContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SqlParser.CAST, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode DISTINCT() { return getToken(SqlParser.DISTINCT, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode SOURCE() { return getToken(SqlParser.SOURCE, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode WITH() { return getToken(SqlParser.WITH, 0); }
		public CastIdentifierContext castIdentifier() {
			return getRuleContext(CastIdentifierContext.class,0);
		}
		public CastToSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castToSource; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCastToSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastToSourceContext castToSource() throws RecognitionException {
		CastToSourceContext _localctx = new CastToSourceContext(_ctx, getState());
		enterRule(_localctx, 568, RULE_castToSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3439);
			match(CAST);
			setState(3440);
			match(LEFT_PAREN);
			setState(3441);
			match(DISTINCT);
			setState(3442);
			match(AS);
			setState(3443);
			match(SOURCE);
			setState(3444);
			match(RIGHT_PAREN);
			setState(3445);
			match(WITH);
			setState(3446);
			castIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropProcedureStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode PROCEDURE() { return getToken(SqlParser.PROCEDURE, 0); }
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public TerminalNode SPECIFIC() { return getToken(SqlParser.SPECIFIC, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public DropProcedureStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropProcedureStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropProcedureStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropProcedureStatementContext dropProcedureStatement() throws RecognitionException {
		DropProcedureStatementContext _localctx = new DropProcedureStatementContext(_ctx, getState());
		enterRule(_localctx, 570, RULE_dropProcedureStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3448);
			match(DROP);
			setState(3450);
			_la = _input.LA(1);
			if (_la==SPECIFIC) {
				{
				setState(3449);
				match(SPECIFIC);
				}
			}

			setState(3452);
			match(PROCEDURE);
			setState(3453);
			routineName();
			setState(3459);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3454);
				match(LEFT_PAREN);
				setState(3456);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
					{
					setState(3455);
					sqlParameterDeclarations();
					}
				}

				setState(3458);
				match(RIGHT_PAREN);
				}
			}

			setState(3461);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropFunctionStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlParser.FUNCTION, 0); }
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public TerminalNode SPECIFIC() { return getToken(SqlParser.SPECIFIC, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public DropFunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropFunctionStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropFunctionStatementContext dropFunctionStatement() throws RecognitionException {
		DropFunctionStatementContext _localctx = new DropFunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 572, RULE_dropFunctionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3463);
			match(DROP);
			setState(3465);
			_la = _input.LA(1);
			if (_la==SPECIFIC) {
				{
				setState(3464);
				match(SPECIFIC);
				}
			}

			setState(3467);
			match(FUNCTION);
			setState(3468);
			routineName();
			setState(3474);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3469);
				match(LEFT_PAREN);
				setState(3471);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
					{
					setState(3470);
					sqlParameterDeclarations();
					}
				}

				setState(3473);
				match(RIGHT_PAREN);
				}
			}

			setState(3476);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropMethodStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode METHOD() { return getToken(SqlParser.METHOD, 0); }
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SqlParser.FOR, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public DropBehaviorContext dropBehavior() {
			return getRuleContext(DropBehaviorContext.class,0);
		}
		public TerminalNode SPECIFIC() { return getToken(SqlParser.SPECIFIC, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public DropMethodStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropMethodStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropMethodStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropMethodStatementContext dropMethodStatement() throws RecognitionException {
		DropMethodStatementContext _localctx = new DropMethodStatementContext(_ctx, getState());
		enterRule(_localctx, 574, RULE_dropMethodStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3478);
			match(DROP);
			setState(3480);
			_la = _input.LA(1);
			if (_la==SPECIFIC) {
				{
				setState(3479);
				match(SPECIFIC);
				}
			}

			setState(3482);
			match(METHOD);
			setState(3483);
			routineName();
			setState(3489);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3484);
				match(LEFT_PAREN);
				setState(3486);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
					{
					setState(3485);
					sqlParameterDeclarations();
					}
				}

				setState(3488);
				match(RIGHT_PAREN);
				}
			}

			setState(3491);
			match(FOR);
			setState(3492);
			udtName();
			setState(3493);
			dropBehavior();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropTriggerStatementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SqlParser.DROP, 0); }
		public TerminalNode TRIGGER() { return getToken(SqlParser.TRIGGER, 0); }
		public TriggerNameContext triggerName() {
			return getRuleContext(TriggerNameContext.class,0);
		}
		public DropTriggerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTriggerStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropTriggerStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropTriggerStatementContext dropTriggerStatement() throws RecognitionException {
		DropTriggerStatementContext _localctx = new DropTriggerStatementContext(_ctx, getState());
		enterRule(_localctx, 576, RULE_dropTriggerStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3495);
			match(DROP);
			setState(3496);
			match(TRIGGER);
			setState(3497);
			triggerName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateProcedureStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode PROCEDURE() { return getToken(SqlParser.PROCEDURE, 0); }
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public RoutineBodyContext routineBody() {
			return getRuleContext(RoutineBodyContext.class,0);
		}
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public RoutineCharacteristicsContext routineCharacteristics() {
			return getRuleContext(RoutineCharacteristicsContext.class,0);
		}
		public CreateProcedureStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createProcedureStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateProcedureStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateProcedureStatementContext createProcedureStatement() throws RecognitionException {
		CreateProcedureStatementContext _localctx = new CreateProcedureStatementContext(_ctx, getState());
		enterRule(_localctx, 578, RULE_createProcedureStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3499);
			match(CREATE);
			setState(3500);
			match(PROCEDURE);
			setState(3501);
			routineName();
			setState(3502);
			match(LEFT_PAREN);
			setState(3504);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
				{
				setState(3503);
				sqlParameterDeclarations();
				}
			}

			setState(3506);
			match(RIGHT_PAREN);
			setState(3508);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,349,_ctx) ) {
			case 1:
				{
				setState(3507);
				routineCharacteristics();
				}
				break;
			}
			setState(3510);
			routineBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateFunctionStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode FUNCTION() { return getToken(SqlParser.FUNCTION, 0); }
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ReturnsClauseContext returnsClause() {
			return getRuleContext(ReturnsClauseContext.class,0);
		}
		public RoutineBodyContext routineBody() {
			return getRuleContext(RoutineBodyContext.class,0);
		}
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public RoutineCharacteristicsContext routineCharacteristics() {
			return getRuleContext(RoutineCharacteristicsContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(SqlParser.STATIC, 0); }
		public TerminalNode DISPATCH() { return getToken(SqlParser.DISPATCH, 0); }
		public CreateFunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFunctionStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateFunctionStatementContext createFunctionStatement() throws RecognitionException {
		CreateFunctionStatementContext _localctx = new CreateFunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 580, RULE_createFunctionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3512);
			match(CREATE);
			setState(3513);
			match(FUNCTION);
			setState(3514);
			routineName();
			setState(3515);
			match(LEFT_PAREN);
			setState(3517);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
				{
				setState(3516);
				sqlParameterDeclarations();
				}
			}

			setState(3519);
			match(RIGHT_PAREN);
			setState(3520);
			returnsClause();
			setState(3522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,351,_ctx) ) {
			case 1:
				{
				setState(3521);
				routineCharacteristics();
				}
				break;
			}
			setState(3526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,352,_ctx) ) {
			case 1:
				{
				setState(3524);
				match(STATIC);
				setState(3525);
				match(DISPATCH);
				}
				break;
			}
			setState(3528);
			routineBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateMethodStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public TerminalNode METHOD() { return getToken(SqlParser.METHOD, 0); }
		public RoutineNameContext routineName() {
			return getRuleContext(RoutineNameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode FOR() { return getToken(SqlParser.FOR, 0); }
		public UdtNameContext udtName() {
			return getRuleContext(UdtNameContext.class,0);
		}
		public RoutineBodyContext routineBody() {
			return getRuleContext(RoutineBodyContext.class,0);
		}
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public ReturnsClauseContext returnsClause() {
			return getRuleContext(ReturnsClauseContext.class,0);
		}
		public RoutineCharacteristicsContext routineCharacteristics() {
			return getRuleContext(RoutineCharacteristicsContext.class,0);
		}
		public CreateMethodStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createMethodStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateMethodStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateMethodStatementContext createMethodStatement() throws RecognitionException {
		CreateMethodStatementContext _localctx = new CreateMethodStatementContext(_ctx, getState());
		enterRule(_localctx, 582, RULE_createMethodStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3530);
			match(CREATE);
			setState(3531);
			methodType();
			setState(3532);
			match(METHOD);
			setState(3533);
			routineName();
			setState(3534);
			match(LEFT_PAREN);
			setState(3536);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
				{
				setState(3535);
				sqlParameterDeclarations();
				}
			}

			setState(3538);
			match(RIGHT_PAREN);
			setState(3540);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(3539);
				returnsClause();
				}
			}

			setState(3542);
			match(FOR);
			setState(3543);
			udtName();
			setState(3545);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,355,_ctx) ) {
			case 1:
				{
				setState(3544);
				routineCharacteristics();
				}
				break;
			}
			setState(3547);
			routineBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTriggerStatementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SqlParser.CREATE, 0); }
		public TerminalNode TRIGGER() { return getToken(SqlParser.TRIGGER, 0); }
		public TriggerNameContext triggerName() {
			return getRuleContext(TriggerNameContext.class,0);
		}
		public TriggerActionTimeContext triggerActionTime() {
			return getRuleContext(TriggerActionTimeContext.class,0);
		}
		public TriggerEventContext triggerEvent() {
			return getRuleContext(TriggerEventContext.class,0);
		}
		public TerminalNode ON() { return getToken(SqlParser.ON, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TriggeredActionContext triggeredAction() {
			return getRuleContext(TriggeredActionContext.class,0);
		}
		public TerminalNode REFERENCING() { return getToken(SqlParser.REFERENCING, 0); }
		public List<OldOrNewValueContext> oldOrNewValue() {
			return getRuleContexts(OldOrNewValueContext.class);
		}
		public OldOrNewValueContext oldOrNewValue(int i) {
			return getRuleContext(OldOrNewValueContext.class,i);
		}
		public CreateTriggerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTriggerStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCreateTriggerStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTriggerStatementContext createTriggerStatement() throws RecognitionException {
		CreateTriggerStatementContext _localctx = new CreateTriggerStatementContext(_ctx, getState());
		enterRule(_localctx, 584, RULE_createTriggerStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3549);
			match(CREATE);
			setState(3550);
			match(TRIGGER);
			setState(3551);
			triggerName();
			setState(3552);
			triggerActionTime();
			setState(3553);
			triggerEvent();
			setState(3554);
			match(ON);
			setState(3555);
			tableName();
			setState(3564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
			case 1:
				{
				setState(3556);
				match(REFERENCING);
				setState(3557);
				oldOrNewValue();
				setState(3561);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,356,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(3558);
						oldOrNewValue();
						}
						} 
					}
					setState(3563);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,356,_ctx);
				}
				}
				break;
			}
			setState(3566);
			triggeredAction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodSpecificationsContext extends ParserRuleContext {
		public List<MethodSpecificationContext> methodSpecification() {
			return getRuleContexts(MethodSpecificationContext.class);
		}
		public MethodSpecificationContext methodSpecification(int i) {
			return getRuleContext(MethodSpecificationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public MethodSpecificationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSpecifications; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMethodSpecifications(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodSpecificationsContext methodSpecifications() throws RecognitionException {
		MethodSpecificationsContext _localctx = new MethodSpecificationsContext(_ctx, getState());
		enterRule(_localctx, 586, RULE_methodSpecifications);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3568);
			methodSpecification();
			setState(3573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3569);
				match(COMMA);
				setState(3570);
				methodSpecification();
				}
				}
				setState(3575);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodSpecificationContext extends ParserRuleContext {
		public OriginalMethodSpecificationContext originalMethodSpecification() {
			return getRuleContext(OriginalMethodSpecificationContext.class,0);
		}
		public OverridingMethodSpecificationContext overridingMethodSpecification() {
			return getRuleContext(OverridingMethodSpecificationContext.class,0);
		}
		public MethodSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitMethodSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodSpecificationContext methodSpecification() throws RecognitionException {
		MethodSpecificationContext _localctx = new MethodSpecificationContext(_ctx, getState());
		enterRule(_localctx, 588, RULE_methodSpecification);
		try {
			setState(3578);
			switch (_input.LA(1)) {
			case INSTANCE:
			case METHOD:
			case STATIC:
			case CONSTRUCTOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3576);
				originalMethodSpecification();
				}
				break;
			case OVERRIDING:
				enterOuterAlt(_localctx, 2);
				{
				setState(3577);
				overridingMethodSpecification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OriginalMethodSpecificationContext extends ParserRuleContext {
		public PartialMethodSpecificationContext partialMethodSpecification() {
			return getRuleContext(PartialMethodSpecificationContext.class,0);
		}
		public List<TerminalNode> SELF() { return getTokens(SqlParser.SELF); }
		public TerminalNode SELF(int i) {
			return getToken(SqlParser.SELF, i);
		}
		public List<TerminalNode> AS() { return getTokens(SqlParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(SqlParser.AS, i);
		}
		public TerminalNode RESULT() { return getToken(SqlParser.RESULT, 0); }
		public TerminalNode LOCATOR() { return getToken(SqlParser.LOCATOR, 0); }
		public RoutineCharacteristicsContext routineCharacteristics() {
			return getRuleContext(RoutineCharacteristicsContext.class,0);
		}
		public OriginalMethodSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_originalMethodSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOriginalMethodSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OriginalMethodSpecificationContext originalMethodSpecification() throws RecognitionException {
		OriginalMethodSpecificationContext _localctx = new OriginalMethodSpecificationContext(_ctx, getState());
		enterRule(_localctx, 590, RULE_originalMethodSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3580);
			partialMethodSpecification();
			setState(3584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				{
				setState(3581);
				match(SELF);
				setState(3582);
				match(AS);
				setState(3583);
				match(RESULT);
				}
				break;
			}
			setState(3589);
			_la = _input.LA(1);
			if (_la==SELF) {
				{
				setState(3586);
				match(SELF);
				setState(3587);
				match(AS);
				setState(3588);
				match(LOCATOR);
				}
			}

			setState(3592);
			_la = _input.LA(1);
			if (_la==CALLED || _la==DETERMINISTIC || ((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & ((1L << (LANGUAGE - 168)) | (1L << (MODIFIES - 168)) | (1L << (NO - 168)) | (1L << (NOT - 168)) | (1L << (PARAMETER - 168)))) != 0) || _la==READS || _la==RETURNS || _la==CONTAINS) {
				{
				setState(3591);
				routineCharacteristics();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OverridingMethodSpecificationContext extends ParserRuleContext {
		public TerminalNode OVERRIDING() { return getToken(SqlParser.OVERRIDING, 0); }
		public PartialMethodSpecificationContext partialMethodSpecification() {
			return getRuleContext(PartialMethodSpecificationContext.class,0);
		}
		public OverridingMethodSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overridingMethodSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOverridingMethodSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OverridingMethodSpecificationContext overridingMethodSpecification() throws RecognitionException {
		OverridingMethodSpecificationContext _localctx = new OverridingMethodSpecificationContext(_ctx, getState());
		enterRule(_localctx, 592, RULE_overridingMethodSpecification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3594);
			match(OVERRIDING);
			setState(3595);
			partialMethodSpecification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartialMethodSpecificationContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(SqlParser.METHOD, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SqlParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public ReturnsClauseContext returnsClause() {
			return getRuleContext(ReturnsClauseContext.class,0);
		}
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public SqlParameterDeclarationsContext sqlParameterDeclarations() {
			return getRuleContext(SqlParameterDeclarationsContext.class,0);
		}
		public TerminalNode SPECIFIC() { return getToken(SqlParser.SPECIFIC, 0); }
		public SpecificMethodNameContext specificMethodName() {
			return getRuleContext(SpecificMethodNameContext.class,0);
		}
		public PartialMethodSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partialMethodSpecification; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPartialMethodSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartialMethodSpecificationContext partialMethodSpecification() throws RecognitionException {
		PartialMethodSpecificationContext _localctx = new PartialMethodSpecificationContext(_ctx, getState());
		enterRule(_localctx, 594, RULE_partialMethodSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3598);
			_la = _input.LA(1);
			if (_la==INSTANCE || _la==STATIC || _la==CONSTRUCTOR) {
				{
				setState(3597);
				methodType();
				}
			}

			setState(3600);
			match(METHOD);
			setState(3601);
			match(IDENTIFIER);
			setState(3602);
			match(LEFT_PAREN);
			setState(3604);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGINT) | (1L << BINARY) | (1L << BLOB) | (1L << BOOLEAN) | (1L << CHAR) | (1L << CHARACTER) | (1L << CLOB))) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (DATE - 84)) | (1L << (DEC - 84)) | (1L << (DECIMAL - 84)) | (1L << (DOUBLE - 84)) | (1L << (FLOAT - 84)) | (1L << (IN - 84)))) != 0) || ((((_la - 151)) & ~0x3f) == 0 && ((1L << (_la - 151)) & ((1L << (INOUT - 151)) | (1L << (INT - 151)) | (1L << (INTEGER - 151)) | (1L << (INTERVAL - 151)) | (1L << (NATIONAL - 151)) | (1L << (NCHAR - 151)) | (1L << (NCLOB - 151)) | (1L << (NUMERIC - 151)))) != 0) || ((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & ((1L << (OUT - 218)) | (1L << (REAL - 218)) | (1L << (REF - 218)) | (1L << (ROW - 218)) | (1L << (SMALLINT - 218)))) != 0) || ((((_la - 301)) & ~0x3f) == 0 && ((1L << (_la - 301)) & ((1L << (TIME - 301)) | (1L << (TIMESTAMP - 301)) | (1L << (VARBINARY - 301)) | (1L << (VARCHAR - 301)) | (1L << (XML - 301)) | (1L << (IDENTIFIER - 301)))) != 0)) {
				{
				setState(3603);
				sqlParameterDeclarations();
				}
			}

			setState(3606);
			match(RIGHT_PAREN);
			setState(3607);
			returnsClause();
			setState(3610);
			_la = _input.LA(1);
			if (_la==SPECIFIC) {
				{
				setState(3608);
				match(SPECIFIC);
				setState(3609);
				specificMethodName();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerEventContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SqlParser.INSERT, 0); }
		public TerminalNode DELETE() { return getToken(SqlParser.DELETE, 0); }
		public TerminalNode UPDATE() { return getToken(SqlParser.UPDATE, 0); }
		public TerminalNode OF() { return getToken(SqlParser.OF, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TriggerEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerEvent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTriggerEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerEventContext triggerEvent() throws RecognitionException {
		TriggerEventContext _localctx = new TriggerEventContext(_ctx, getState());
		enterRule(_localctx, 596, RULE_triggerEvent);
		int _la;
		try {
			setState(3626);
			switch (_input.LA(1)) {
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(3612);
				match(INSERT);
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3613);
				match(DELETE);
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(3614);
				match(UPDATE);
				setState(3624);
				_la = _input.LA(1);
				if (_la==OF) {
					{
					setState(3615);
					match(OF);
					setState(3616);
					columnName();
					setState(3621);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(3617);
						match(COMMA);
						setState(3618);
						columnName();
						}
						}
						setState(3623);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OldOrNewValueContext extends ParserRuleContext {
		public TerminalNode OLD() { return getToken(SqlParser.OLD, 0); }
		public CorrelationNameContext correlationName() {
			return getRuleContext(CorrelationNameContext.class,0);
		}
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode NEW() { return getToken(SqlParser.NEW, 0); }
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public OldOrNewValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oldOrNewValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitOldOrNewValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OldOrNewValueContext oldOrNewValue() throws RecognitionException {
		OldOrNewValueContext _localctx = new OldOrNewValueContext(_ctx, getState());
		enterRule(_localctx, 598, RULE_oldOrNewValue);
		int _la;
		try {
			setState(3656);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,375,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3628);
				match(OLD);
				setState(3630);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(3629);
					match(ROW);
					}
				}

				setState(3633);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3632);
					match(AS);
					}
				}

				setState(3635);
				correlationName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3636);
				match(NEW);
				setState(3638);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(3637);
					match(ROW);
					}
				}

				setState(3641);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3640);
					match(AS);
					}
				}

				setState(3643);
				correlationName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3644);
				match(OLD);
				setState(3645);
				match(TABLE);
				setState(3647);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3646);
					match(AS);
					}
				}

				setState(3649);
				correlationName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3650);
				match(NEW);
				setState(3651);
				match(TABLE);
				setState(3653);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3652);
					match(AS);
					}
				}

				setState(3655);
				correlationName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggeredActionContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SqlParser.BEGIN, 0); }
		public TerminalNode ATOMIC() { return getToken(SqlParser.ATOMIC, 0); }
		public RoutineBodyContext routineBody() {
			return getRuleContext(RoutineBodyContext.class,0);
		}
		public TerminalNode END() { return getToken(SqlParser.END, 0); }
		public TerminalNode FOR() { return getToken(SqlParser.FOR, 0); }
		public TerminalNode EACH() { return getToken(SqlParser.EACH, 0); }
		public TerminalNode WHEN() { return getToken(SqlParser.WHEN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public TerminalNode STATEMENT() { return getToken(SqlParser.STATEMENT, 0); }
		public TriggeredActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggeredAction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTriggeredAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggeredActionContext triggeredAction() throws RecognitionException {
		TriggeredActionContext _localctx = new TriggeredActionContext(_ctx, getState());
		enterRule(_localctx, 600, RULE_triggeredAction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
			case 1:
				{
				setState(3658);
				match(FOR);
				setState(3659);
				match(EACH);
				setState(3660);
				_la = _input.LA(1);
				if ( !(_la==ROW || _la==STATEMENT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			}
			setState(3668);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,377,_ctx) ) {
			case 1:
				{
				setState(3663);
				match(WHEN);
				setState(3664);
				match(LEFT_PAREN);
				setState(3665);
				booleanValueExpression(0);
				setState(3666);
				match(RIGHT_PAREN);
				}
				break;
			}
			setState(3676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,378,_ctx) ) {
			case 1:
				{
				setState(3670);
				match(BEGIN);
				setState(3671);
				match(ATOMIC);
				setState(3672);
				routineBody();
				setState(3673);
				match(END);
				}
				break;
			case 2:
				{
				setState(3675);
				routineBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlParameterDeclarationsContext extends ParserRuleContext {
		public List<SqlParameterDeclarationContext> sqlParameterDeclaration() {
			return getRuleContexts(SqlParameterDeclarationContext.class);
		}
		public SqlParameterDeclarationContext sqlParameterDeclaration(int i) {
			return getRuleContext(SqlParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SqlParameterDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlParameterDeclarations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSqlParameterDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlParameterDeclarationsContext sqlParameterDeclarations() throws RecognitionException {
		SqlParameterDeclarationsContext _localctx = new SqlParameterDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 602, RULE_sqlParameterDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3678);
			sqlParameterDeclaration();
			setState(3683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3679);
				match(COMMA);
				setState(3680);
				sqlParameterDeclaration();
				}
				}
				setState(3685);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlParameterDeclarationContext extends ParserRuleContext {
		public ParameterTypeContext parameterType() {
			return getRuleContext(ParameterTypeContext.class,0);
		}
		public ParameterModeContext parameterMode() {
			return getRuleContext(ParameterModeContext.class,0);
		}
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public TerminalNode RESULT() { return getToken(SqlParser.RESULT, 0); }
		public SqlParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlParameterDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSqlParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqlParameterDeclarationContext sqlParameterDeclaration() throws RecognitionException {
		SqlParameterDeclarationContext _localctx = new SqlParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 604, RULE_sqlParameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3687);
			_la = _input.LA(1);
			if (_la==IN || _la==INOUT || _la==OUT) {
				{
				setState(3686);
				parameterMode();
				}
			}

			setState(3690);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,381,_ctx) ) {
			case 1:
				{
				setState(3689);
				parameterName();
				}
				break;
			}
			setState(3692);
			parameterType();
			setState(3694);
			_la = _input.LA(1);
			if (_la==RESULT) {
				{
				setState(3693);
				match(RESULT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode LOCATOR() { return getToken(SqlParser.LOCATOR, 0); }
		public ParameterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitParameterType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterTypeContext parameterType() throws RecognitionException {
		ParameterTypeContext _localctx = new ParameterTypeContext(_ctx, getState());
		enterRule(_localctx, 606, RULE_parameterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3696);
			dataType(0);
			setState(3699);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3697);
				match(AS);
				setState(3698);
				match(LOCATOR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnsClauseContext extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(SqlParser.RETURNS, 0); }
		public ReturnsTypeContext returnsType() {
			return getRuleContext(ReturnsTypeContext.class,0);
		}
		public ReturnsClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnsClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReturnsClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnsClauseContext returnsClause() throws RecognitionException {
		ReturnsClauseContext _localctx = new ReturnsClauseContext(_ctx, getState());
		enterRule(_localctx, 608, RULE_returnsClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3701);
			match(RETURNS);
			setState(3702);
			returnsType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnsTypeContext extends ParserRuleContext {
		public ReturnsDataTypeContext returnsDataType() {
			return getRuleContext(ReturnsDataTypeContext.class,0);
		}
		public ResultCastContext resultCast() {
			return getRuleContext(ResultCastContext.class,0);
		}
		public ReturnsTableTypeContext returnsTableType() {
			return getRuleContext(ReturnsTableTypeContext.class,0);
		}
		public ReturnsTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnsType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReturnsType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnsTypeContext returnsType() throws RecognitionException {
		ReturnsTypeContext _localctx = new ReturnsTypeContext(_ctx, getState());
		enterRule(_localctx, 610, RULE_returnsType);
		try {
			setState(3709);
			switch (_input.LA(1)) {
			case BIGINT:
			case BINARY:
			case BLOB:
			case BOOLEAN:
			case CHAR:
			case CHARACTER:
			case CLOB:
			case DATE:
			case DEC:
			case DECIMAL:
			case DOUBLE:
			case FLOAT:
			case INT:
			case INTEGER:
			case INTERVAL:
			case NATIONAL:
			case NCHAR:
			case NCLOB:
			case NUMERIC:
			case REAL:
			case REF:
			case ROW:
			case SMALLINT:
			case TIME:
			case TIMESTAMP:
			case VARBINARY:
			case VARCHAR:
			case XML:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3704);
				returnsDataType();
				setState(3706);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
				case 1:
					{
					setState(3705);
					resultCast();
					}
					break;
				}
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3708);
				returnsTableType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnsDataTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode LOCATOR() { return getToken(SqlParser.LOCATOR, 0); }
		public ReturnsDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnsDataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReturnsDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnsDataTypeContext returnsDataType() throws RecognitionException {
		ReturnsDataTypeContext _localctx = new ReturnsDataTypeContext(_ctx, getState());
		enterRule(_localctx, 612, RULE_returnsDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3711);
			dataType(0);
			setState(3714);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,386,_ctx) ) {
			case 1:
				{
				setState(3712);
				match(AS);
				setState(3713);
				match(LOCATOR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultCastContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SqlParser.CAST, 0); }
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode AS() { return getToken(SqlParser.AS, 0); }
		public TerminalNode LOCATOR() { return getToken(SqlParser.LOCATOR, 0); }
		public ResultCastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultCast; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitResultCast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultCastContext resultCast() throws RecognitionException {
		ResultCastContext _localctx = new ResultCastContext(_ctx, getState());
		enterRule(_localctx, 614, RULE_resultCast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3716);
			match(CAST);
			setState(3717);
			match(FROM);
			{
			setState(3718);
			dataType(0);
			setState(3721);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,387,_ctx) ) {
			case 1:
				{
				setState(3719);
				match(AS);
				setState(3720);
				match(LOCATOR);
				}
				break;
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnsTableTypeContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(SqlParser.TABLE, 0); }
		public TableColumnsContext tableColumns() {
			return getRuleContext(TableColumnsContext.class,0);
		}
		public ReturnsTableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnsTableType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitReturnsTableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnsTableTypeContext returnsTableType() throws RecognitionException {
		ReturnsTableTypeContext _localctx = new ReturnsTableTypeContext(_ctx, getState());
		enterRule(_localctx, 616, RULE_returnsTableType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3723);
			match(TABLE);
			setState(3724);
			tableColumns();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableColumnsContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<TableColumnContext> tableColumn() {
			return getRuleContexts(TableColumnContext.class);
		}
		public TableColumnContext tableColumn(int i) {
			return getRuleContext(TableColumnContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TableColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableColumns; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableColumns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableColumnsContext tableColumns() throws RecognitionException {
		TableColumnsContext _localctx = new TableColumnsContext(_ctx, getState());
		enterRule(_localctx, 618, RULE_tableColumns);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3726);
			match(LEFT_PAREN);
			setState(3727);
			tableColumn();
			setState(3732);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3728);
				match(COMMA);
				setState(3729);
				tableColumn();
				}
				}
				setState(3734);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3735);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableColumnContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TableColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableColumn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTableColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableColumnContext tableColumn() throws RecognitionException {
		TableColumnContext _localctx = new TableColumnContext(_ctx, getState());
		enterRule(_localctx, 620, RULE_tableColumn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3737);
			columnName();
			setState(3738);
			dataType(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineCharacteristicsContext extends ParserRuleContext {
		public List<RoutineCharacteristicContext> routineCharacteristic() {
			return getRuleContexts(RoutineCharacteristicContext.class);
		}
		public RoutineCharacteristicContext routineCharacteristic(int i) {
			return getRuleContext(RoutineCharacteristicContext.class,i);
		}
		public RoutineCharacteristicsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineCharacteristics; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoutineCharacteristics(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineCharacteristicsContext routineCharacteristics() throws RecognitionException {
		RoutineCharacteristicsContext _localctx = new RoutineCharacteristicsContext(_ctx, getState());
		enterRule(_localctx, 622, RULE_routineCharacteristics);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3741); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3740);
					routineCharacteristic();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3743); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,389,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineCharacteristicContext extends ParserRuleContext {
		public TerminalNode LANGUAGE() { return getToken(SqlParser.LANGUAGE, 0); }
		public LanguageNameContext languageName() {
			return getRuleContext(LanguageNameContext.class,0);
		}
		public TerminalNode PARAMETER() { return getToken(SqlParser.PARAMETER, 0); }
		public TerminalNode STYLE() { return getToken(SqlParser.STYLE, 0); }
		public ParameterStyleContext parameterStyle() {
			return getRuleContext(ParameterStyleContext.class,0);
		}
		public DeterministicContext deterministic() {
			return getRuleContext(DeterministicContext.class,0);
		}
		public DataAccessContext dataAccess() {
			return getRuleContext(DataAccessContext.class,0);
		}
		public NullCallClauseContext nullCallClause() {
			return getRuleContext(NullCallClauseContext.class,0);
		}
		public RoutineCharacteristicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineCharacteristic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoutineCharacteristic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineCharacteristicContext routineCharacteristic() throws RecognitionException {
		RoutineCharacteristicContext _localctx = new RoutineCharacteristicContext(_ctx, getState());
		enterRule(_localctx, 624, RULE_routineCharacteristic);
		try {
			setState(3753);
			switch (_input.LA(1)) {
			case LANGUAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3745);
				match(LANGUAGE);
				setState(3746);
				languageName();
				}
				break;
			case PARAMETER:
				enterOuterAlt(_localctx, 2);
				{
				setState(3747);
				match(PARAMETER);
				setState(3748);
				match(STYLE);
				setState(3749);
				parameterStyle();
				}
				break;
			case DETERMINISTIC:
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(3750);
				deterministic();
				}
				break;
			case MODIFIES:
			case NO:
			case READS:
			case CONTAINS:
				enterOuterAlt(_localctx, 4);
				{
				setState(3751);
				dataAccess();
				}
				break;
			case CALLED:
			case RETURNS:
				enterOuterAlt(_localctx, 5);
				{
				setState(3752);
				nullCallClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RoutineBodyContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(SqlParser.END, 0); }
		public RoutineBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routineBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRoutineBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoutineBodyContext routineBody() throws RecognitionException {
		RoutineBodyContext _localctx = new RoutineBodyContext(_ctx, getState());
		enterRule(_localctx, 626, RULE_routineBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3758);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,391,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(3755);
					matchWildcard();
					}
					} 
				}
				setState(3760);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,391,_ctx);
			}
			setState(3762);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,392,_ctx) ) {
			case 1:
				{
				setState(3761);
				match(END);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertStatementContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SqlParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SqlParser.INTO, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public FromConstructorContext fromConstructor() {
			return getRuleContext(FromConstructorContext.class,0);
		}
		public FromDefaultContext fromDefault() {
			return getRuleContext(FromDefaultContext.class,0);
		}
		public FromSubqueryContext fromSubquery() {
			return getRuleContext(FromSubqueryContext.class,0);
		}
		public InsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInsertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 628, RULE_insertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3764);
			match(INSERT);
			setState(3765);
			match(INTO);
			setState(3766);
			tableName();
			setState(3770);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,393,_ctx) ) {
			case 1:
				{
				setState(3767);
				fromConstructor();
				}
				break;
			case 2:
				{
				setState(3768);
				fromDefault();
				}
				break;
			case 3:
				{
				setState(3769);
				fromSubquery();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromConstructorContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(SqlParser.VALUES, 0); }
		public List<AssignedRowContext> assignedRow() {
			return getRuleContexts(AssignedRowContext.class);
		}
		public AssignedRowContext assignedRow(int i) {
			return getRuleContext(AssignedRowContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public InsertColumnListContext insertColumnList() {
			return getRuleContext(InsertColumnListContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public OverrideClauseContext overrideClause() {
			return getRuleContext(OverrideClauseContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public FromConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFromConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromConstructorContext fromConstructor() throws RecognitionException {
		FromConstructorContext _localctx = new FromConstructorContext(_ctx, getState());
		enterRule(_localctx, 630, RULE_fromConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3776);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3772);
				match(LEFT_PAREN);
				setState(3773);
				insertColumnList();
				setState(3774);
				match(RIGHT_PAREN);
				}
			}

			setState(3779);
			_la = _input.LA(1);
			if (_la==OVERRIDING) {
				{
				setState(3778);
				overrideClause();
				}
			}

			setState(3781);
			match(VALUES);
			setState(3782);
			assignedRow();
			setState(3787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3783);
				match(COMMA);
				setState(3784);
				assignedRow();
				}
				}
				setState(3789);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromSubqueryContext extends ParserRuleContext {
		public QueryExpressionContext queryExpression() {
			return getRuleContext(QueryExpressionContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public InsertColumnListContext insertColumnList() {
			return getRuleContext(InsertColumnListContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public OverrideClauseContext overrideClause() {
			return getRuleContext(OverrideClauseContext.class,0);
		}
		public FromSubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromSubquery; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFromSubquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromSubqueryContext fromSubquery() throws RecognitionException {
		FromSubqueryContext _localctx = new FromSubqueryContext(_ctx, getState());
		enterRule(_localctx, 632, RULE_fromSubquery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3794);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,397,_ctx) ) {
			case 1:
				{
				setState(3790);
				match(LEFT_PAREN);
				setState(3791);
				insertColumnList();
				setState(3792);
				match(RIGHT_PAREN);
				}
				break;
			}
			setState(3797);
			_la = _input.LA(1);
			if (_la==OVERRIDING) {
				{
				setState(3796);
				overrideClause();
				}
			}

			setState(3799);
			queryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertColumnListContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public InsertColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertColumnList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInsertColumnList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertColumnListContext insertColumnList() throws RecognitionException {
		InsertColumnListContext _localctx = new InsertColumnListContext(_ctx, getState());
		enterRule(_localctx, 634, RULE_insertColumnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3801);
			columnName();
			setState(3806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3802);
				match(COMMA);
				setState(3803);
				columnName();
				}
				}
				setState(3808);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromDefaultContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(SqlParser.DEFAULT, 0); }
		public TerminalNode VALUES() { return getToken(SqlParser.VALUES, 0); }
		public FromDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromDefault; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFromDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromDefaultContext fromDefault() throws RecognitionException {
		FromDefaultContext _localctx = new FromDefaultContext(_ctx, getState());
		enterRule(_localctx, 636, RULE_fromDefault);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3809);
			match(DEFAULT);
			setState(3810);
			match(VALUES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteStatementContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SqlParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SqlParser.FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SqlParser.WHERE, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDeleteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 638, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3812);
			match(DELETE);
			setState(3813);
			match(FROM);
			setState(3814);
			tableName();
			setState(3817);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(3815);
				match(WHERE);
				setState(3816);
				booleanValueExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateStatementContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(SqlParser.UPDATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode SET() { return getToken(SqlParser.SET, 0); }
		public List<SetClauseContext> setClause() {
			return getRuleContexts(SetClauseContext.class);
		}
		public SetClauseContext setClause(int i) {
			return getRuleContext(SetClauseContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode WHERE() { return getToken(SqlParser.WHERE, 0); }
		public BooleanValueExpressionContext booleanValueExpression() {
			return getRuleContext(BooleanValueExpressionContext.class,0);
		}
		public UpdateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUpdateStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateStatementContext updateStatement() throws RecognitionException {
		UpdateStatementContext _localctx = new UpdateStatementContext(_ctx, getState());
		enterRule(_localctx, 640, RULE_updateStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3819);
			match(UPDATE);
			setState(3820);
			tableName();
			setState(3821);
			match(SET);
			setState(3822);
			setClause();
			setState(3827);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3823);
				match(COMMA);
				setState(3824);
				setClause();
				}
				}
				setState(3829);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3832);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(3830);
				match(WHERE);
				setState(3831);
				booleanValueExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetClauseContext extends ParserRuleContext {
		public List<SetTargetContext> setTarget() {
			return getRuleContexts(SetTargetContext.class);
		}
		public SetTargetContext setTarget(int i) {
			return getRuleContext(SetTargetContext.class,i);
		}
		public TerminalNode EQUALS_OPERATOR() { return getToken(SqlParser.EQUALS_OPERATOR, 0); }
		public UpdateSourceContext updateSource() {
			return getRuleContext(UpdateSourceContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public AssignedRowContext assignedRow() {
			return getRuleContext(AssignedRowContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public SetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetClauseContext setClause() throws RecognitionException {
		SetClauseContext _localctx = new SetClauseContext(_ctx, getState());
		enterRule(_localctx, 642, RULE_setClause);
		int _la;
		try {
			setState(3851);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(3834);
				setTarget();
				setState(3835);
				match(EQUALS_OPERATOR);
				setState(3836);
				updateSource();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3838);
				match(LEFT_PAREN);
				setState(3839);
				setTarget();
				setState(3844);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3840);
					match(COMMA);
					setState(3841);
					setTarget();
					}
					}
					setState(3846);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(3847);
				match(RIGHT_PAREN);
				setState(3848);
				match(EQUALS_OPERATOR);
				setState(3849);
				assignedRow();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetTargetContext extends ParserRuleContext {
		public List<UpdateTargetContext> updateTarget() {
			return getRuleContexts(UpdateTargetContext.class);
		}
		public UpdateTargetContext updateTarget(int i) {
			return getRuleContext(UpdateTargetContext.class,i);
		}
		public List<TerminalNode> PERIOD() { return getTokens(SqlParser.PERIOD); }
		public TerminalNode PERIOD(int i) {
			return getToken(SqlParser.PERIOD, i);
		}
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public SetTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setTarget; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSetTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetTargetContext setTarget() throws RecognitionException {
		SetTargetContext _localctx = new SetTargetContext(_ctx, getState());
		enterRule(_localctx, 644, RULE_setTarget);
		try {
			int _alt;
			setState(3865);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,406,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3853);
				updateTarget();
				setState(3858);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,405,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(3854);
						match(PERIOD);
						setState(3855);
						updateTarget();
						}
						} 
					}
					setState(3860);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,405,_ctx);
				}
				setState(3861);
				match(PERIOD);
				setState(3862);
				methodName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3864);
				updateTarget();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateTargetContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(SqlParser.LEFT_BRACKET, 0); }
		public SimpleValueSpecificationContext simpleValueSpecification() {
			return getRuleContext(SimpleValueSpecificationContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(SqlParser.RIGHT_BRACKET, 0); }
		public UpdateTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateTarget; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUpdateTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateTargetContext updateTarget() throws RecognitionException {
		UpdateTargetContext _localctx = new UpdateTargetContext(_ctx, getState());
		enterRule(_localctx, 646, RULE_updateTarget);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3867);
			columnName();
			setState(3872);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(3868);
				match(LEFT_BRACKET);
				setState(3869);
				simpleValueSpecification();
				setState(3870);
				match(RIGHT_BRACKET);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateSourceContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public SpecialValueContext specialValue() {
			return getRuleContext(SpecialValueContext.class,0);
		}
		public UpdateSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateSource; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUpdateSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateSourceContext updateSource() throws RecognitionException {
		UpdateSourceContext _localctx = new UpdateSourceContext(_ctx, getState());
		enterRule(_localctx, 648, RULE_updateSource);
		try {
			setState(3876);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3874);
				valueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3875);
				specialValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignedRowContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SqlParser.LEFT_PAREN, 0); }
		public List<UpdateSourceContext> updateSource() {
			return getRuleContexts(UpdateSourceContext.class);
		}
		public UpdateSourceContext updateSource(int i) {
			return getRuleContext(UpdateSourceContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SqlParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SqlParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SqlParser.COMMA, i);
		}
		public TerminalNode ROW() { return getToken(SqlParser.ROW, 0); }
		public AssignedRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignedRow; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAssignedRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignedRowContext assignedRow() throws RecognitionException {
		AssignedRowContext _localctx = new AssignedRowContext(_ctx, getState());
		enterRule(_localctx, 650, RULE_assignedRow);
		int _la;
		try {
			setState(3901);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3878);
				match(LEFT_PAREN);
				setState(3879);
				updateSource();
				setState(3882); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(3880);
					match(COMMA);
					setState(3881);
					updateSource();
					}
					}
					setState(3884); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(3886);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3888);
				match(ROW);
				setState(3889);
				match(LEFT_PAREN);
				setState(3890);
				updateSource();
				setState(3895);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(3891);
					match(COMMA);
					setState(3892);
					updateSource();
					}
					}
					setState(3897);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(3898);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3900);
				updateSource();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 111:
			return dataType_sempred((DataTypeContext)_localctx, predIndex);
		case 153:
			return tableReference_sempred((TableReferenceContext)_localctx, predIndex);
		case 160:
			return queryExpressionBody_sempred((QueryExpressionBodyContext)_localctx, predIndex);
		case 170:
			return numericValueExpression_sempred((NumericValueExpressionContext)_localctx, predIndex);
		case 177:
			return stringValueExpression_sempred((StringValueExpressionContext)_localctx, predIndex);
		case 181:
			return datetimeValueExpression_sempred((DatetimeValueExpressionContext)_localctx, predIndex);
		case 185:
			return intervalValueExpression_sempred((IntervalValueExpressionContext)_localctx, predIndex);
		case 188:
			return arrayValueExpression_sempred((ArrayValueExpressionContext)_localctx, predIndex);
		case 189:
			return multisetValueExpression_sempred((MultisetValueExpressionContext)_localctx, predIndex);
		case 190:
			return booleanValueExpression_sempred((BooleanValueExpressionContext)_localctx, predIndex);
		case 209:
			return valueExpressionPrimary_sempred((ValueExpressionPrimaryContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dataType_sempred(DataTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean tableReference_sempred(TableReferenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean queryExpressionBody_sempred(QueryExpressionBodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean numericValueExpression_sempred(NumericValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean stringValueExpression_sempred(StringValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean datetimeValueExpression_sempred(DatetimeValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean intervalValueExpression_sempred(IntervalValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean arrayValueExpression_sempred(ArrayValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multisetValueExpression_sempred(MultisetValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean booleanValueExpression_sempred(BooleanValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean valueExpressionPrimary_sempred(ValueExpressionPrimaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 12);
		case 19:
			return precpred(_ctx, 8);
		case 20:
			return precpred(_ctx, 5);
		}
		return true;
	}

	private static final int _serializedATNSegments = 2;
	private static final String _serializedATNSegment0 =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0250\u0f42\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\4\u00d6"+
		"\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8\4\u00d9\t\u00d9\4\u00da\t\u00da"+
		"\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd\t\u00dd\4\u00de\t\u00de\4\u00df"+
		"\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1\4\u00e2\t\u00e2\4\u00e3\t\u00e3"+
		"\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6\t\u00e6\4\u00e7\t\u00e7\4\u00e8"+
		"\t\u00e8\4\u00e9\t\u00e9\4\u00ea\t\u00ea\4\u00eb\t\u00eb\4\u00ec\t\u00ec"+
		"\4\u00ed\t\u00ed\4\u00ee\t\u00ee\4\u00ef\t\u00ef\4\u00f0\t\u00f0\4\u00f1"+
		"\t\u00f1\4\u00f2\t\u00f2\4\u00f3\t\u00f3\4\u00f4\t\u00f4\4\u00f5\t\u00f5"+
		"\4\u00f6\t\u00f6\4\u00f7\t\u00f7\4\u00f8\t\u00f8\4\u00f9\t\u00f9\4\u00fa"+
		"\t\u00fa\4\u00fb\t\u00fb\4\u00fc\t\u00fc\4\u00fd\t\u00fd\4\u00fe\t\u00fe"+
		"\4\u00ff\t\u00ff\4\u0100\t\u0100\4\u0101\t\u0101\4\u0102\t\u0102\4\u0103"+
		"\t\u0103\4\u0104\t\u0104\4\u0105\t\u0105\4\u0106\t\u0106\4\u0107\t\u0107"+
		"\4\u0108\t\u0108\4\u0109\t\u0109\4\u010a\t\u010a\4\u010b\t\u010b\4\u010c"+
		"\t\u010c\4\u010d\t\u010d\4\u010e\t\u010e\4\u010f\t\u010f\4\u0110\t\u0110"+
		"\4\u0111\t\u0111\4\u0112\t\u0112\4\u0113\t\u0113\4\u0114\t\u0114\4\u0115"+
		"\t\u0115\4\u0116\t\u0116\4\u0117\t\u0117\4\u0118\t\u0118\4\u0119\t\u0119"+
		"\4\u011a\t\u011a\4\u011b\t\u011b\4\u011c\t\u011c\4\u011d\t\u011d\4\u011e"+
		"\t\u011e\4\u011f\t\u011f\4\u0120\t\u0120\4\u0121\t\u0121\4\u0122\t\u0122"+
		"\4\u0123\t\u0123\4\u0124\t\u0124\4\u0125\t\u0125\4\u0126\t\u0126\4\u0127"+
		"\t\u0127\4\u0128\t\u0128\4\u0129\t\u0129\4\u012a\t\u012a\4\u012b\t\u012b"+
		"\4\u012c\t\u012c\4\u012d\t\u012d\4\u012e\t\u012e\4\u012f\t\u012f\4\u0130"+
		"\t\u0130\4\u0131\t\u0131\4\u0132\t\u0132\4\u0133\t\u0133\4\u0134\t\u0134"+
		"\4\u0135\t\u0135\4\u0136\t\u0136\4\u0137\t\u0137\4\u0138\t\u0138\4\u0139"+
		"\t\u0139\4\u013a\t\u013a\4\u013b\t\u013b\4\u013c\t\u013c\4\u013d\t\u013d"+
		"\4\u013e\t\u013e\4\u013f\t\u013f\4\u0140\t\u0140\4\u0141\t\u0141\4\u0142"+
		"\t\u0142\4\u0143\t\u0143\4\u0144\t\u0144\4\u0145\t\u0145\4\u0146\t\u0146"+
		"\4\u0147\t\u0147\3\2\3\2\3\2\5\2\u0292\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u02a6\n\3\3\4\3\4\3\4"+
		"\5\4\u02ab\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u02b7\n\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\5\25\u02da\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u02e5\n\26\3\27\3\27\3\27\7\27\u02ea\n\27\f\27\16\27\u02ed\13\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u0317\n\'\3(\3(\3(\5(\u031c\n(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3)\3)\5)\u0328\n)\3*\3*\3*\3+\5+\u032e\n+\3+\3+\3,\5,\u0333"+
		"\n,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\5\60\u0346\n\60\3\61\5\61\u0349\n\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0357\n\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\38\58\u0366\n8\58\u0368\n8\39\39\3:\3"+
		":\3:\3:\5:\u0370\n:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\5@\u0386\n@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3F\3F\3G\3"+
		"G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\5L\u03a3\nL\3L\3L\3M\3M\3M\3M\5M\u03ab"+
		"\nM\3N\5N\u03ae\nN\3N\3N\3O\3O\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\5Q\u03bc\nQ\3R"+
		"\3R\3R\3R\3R\3R\3R\3R\5R\u03c6\nR\3S\3S\3S\3S\3S\3T\3T\5T\u03cf\nT\3T"+
		"\3T\3T\3T\5T\u03d5\nT\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3W\3W\5W\u03e3\nW"+
		"\3W\3W\3W\3W\3W\3W\3W\5W\u03ec\nW\3W\3W\5W\u03f0\nW\3X\3X\5X\u03f4\nX"+
		"\3X\3X\3X\5X\u03f9\nX\3X\3X\3X\3X\3X\5X\u0400\nX\3X\3X\3X\3X\3X\3X\3X"+
		"\3X\3X\3X\5X\u040c\nX\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u0419\nY\3Z"+
		"\3Z\3Z\3Z\5Z\u041f\nZ\3Z\3Z\3Z\3Z\3Z\3Z\7Z\u0427\nZ\fZ\16Z\u042a\13Z\3"+
		"Z\3Z\5Z\u042e\nZ\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u0436\nZ\3[\3[\3[\3\\\3\\\3\\\3"+
		"\\\7\\\u043f\n\\\f\\\16\\\u0442\13\\\3\\\3\\\3]\3]\3]\3]\3]\5]\u044b\n"+
		"]\3^\3^\3^\3^\7^\u0451\n^\f^\16^\u0454\13^\3^\3^\3^\3^\3^\5^\u045b\n^"+
		"\3^\3^\5^\u045f\n^\3_\3_\3_\3`\3`\3`\3`\7`\u0468\n`\f`\16`\u046b\13`\3"+
		"`\3`\3a\3a\5a\u0471\na\3b\3b\3b\5b\u0476\nb\3b\5b\u0479\nb\3b\3b\5b\u047d"+
		"\nb\3b\5b\u0480\nb\3b\5b\u0483\nb\3c\3c\5c\u0487\nc\3c\3c\5c\u048b\nc"+
		"\3d\3d\3d\3d\5d\u0491\nd\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3f\3f\5f\u049f"+
		"\nf\3g\3g\3g\3g\3g\3g\3g\5g\u04a8\ng\3g\3g\3g\3g\3g\5g\u04af\ng\3g\3g"+
		"\3g\3g\3g\5g\u04b6\ng\3g\3g\3g\3g\3g\5g\u04bd\ng\3g\3g\3g\3g\3g\3g\3g"+
		"\3g\3g\3g\3g\3g\3g\5g\u04cc\ng\3h\3h\3h\3h\3h\3h\3h\3i\3i\5i\u04d7\ni"+
		"\3i\3i\5i\u04db\ni\3j\3j\3j\3j\3j\7j\u04e2\nj\fj\16j\u04e5\13j\3j\3j\3"+
		"j\3j\3j\3j\3j\3j\7j\u04ef\nj\fj\16j\u04f2\13j\3j\3j\3j\3j\3j\3j\3j\3j"+
		"\7j\u04fc\nj\fj\16j\u04ff\13j\3j\3j\3j\3j\3j\3j\3j\3j\5j\u0509\nj\3k\3"+
		"k\5k\u050d\nk\3k\3k\5k\u0511\nk\5k\u0513\nk\3l\3l\3l\3l\5l\u0519\nl\3"+
		"l\3l\3l\3l\3l\3l\3l\3l\3l\5l\u0524\nl\3l\5l\u0527\nl\3l\3l\3l\3l\3l\5"+
		"l\u052e\nl\3m\3m\3m\3m\3m\3m\7m\u0536\nm\fm\16m\u0539\13m\3m\3m\5m\u053d"+
		"\nm\3m\3m\5m\u0541\nm\3m\5m\u0544\nm\3n\3n\5n\u0548\nn\3n\3n\5n\u054c"+
		"\nn\5n\u054e\nn\3o\3o\3o\3o\3p\3p\3p\3p\3q\3q\3q\3q\3q\3q\3q\3q\7q\u0560"+
		"\nq\fq\16q\u0563\13q\3q\3q\3q\3q\3q\3q\3q\5q\u056c\nq\5q\u056e\nq\3q\3"+
		"q\3q\3q\3q\3q\5q\u0576\nq\3q\3q\7q\u057a\nq\fq\16q\u057d\13q\3r\3r\3r"+
		"\3r\3r\5r\u0584\nr\3s\3s\3s\3t\3t\3t\5t\u058c\nt\3t\3t\3t\5t\u0591\nt"+
		"\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u\3u"+
		"\5u\u05aa\nu\3v\3v\3v\3v\3v\5v\u05b1\nv\3w\3w\3w\5w\u05b6\nw\3w\3w\3w"+
		"\3w\5w\u05bc\nw\3x\3x\3x\3x\5x\u05c2\nx\3x\3x\3x\3x\5x\u05c8\nx\3y\3y"+
		"\3y\5y\u05cd\ny\3y\3y\3y\3y\5y\u05d3\ny\3z\3z\3z\3z\3z\5z\u05da\nz\3z"+
		"\3z\3z\3z\5z\u05e0\nz\3{\3{\3{\3{\3{\3{\3{\3{\5{\u05ea\n{\3{\3{\3{\3{"+
		"\5{\u05f0\n{\3|\3|\3}\3}\3}\3}\3}\5}\u05f9\n}\3~\3~\3~\5~\u05fe\n~\3~"+
		"\3~\3~\3~\5~\u0604\n~\3\177\3\177\3\177\3\177\5\177\u060a\n\177\3\177"+
		"\3\177\3\177\3\177\5\177\u0610\n\177\3\u0080\3\u0080\3\u0080\3\u0080\3"+
		"\u0080\5\u0080\u0617\n\u0080\3\u0080\3\u0080\5\u0080\u061b\n\u0080\3\u0081"+
		"\3\u0081\3\u0081\3\u0081\3\u0081\5\u0081\u0622\n\u0081\3\u0081\3\u0081"+
		"\5\u0081\u0626\n\u0081\3\u0082\3\u0082\3\u0083\3\u0083\3\u0084\3\u0084"+
		"\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\5\u0085\u0633\n\u0085\3\u0086"+
		"\3\u0086\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0089\3\u0089\3\u008a"+
		"\3\u008a\3\u008a\3\u008a\3\u008a\5\u008a\u0643\n\u008a\3\u008a\5\u008a"+
		"\u0646\n\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u064d\n"+
		"\u008b\3\u008b\5\u008b\u0650\n\u008b\3\u008c\3\u008c\3\u008c\3\u008d\3"+
		"\u008d\3\u008d\3\u008d\3\u008d\5\u008d\u065a\n\u008d\3\u008d\3\u008d\5"+
		"\u008d\u065e\n\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\5\u008d\u0665"+
		"\n\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\5\u008d\u066c\n\u008d"+
		"\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\5\u008d\u0678\n\u008d\5\u008d\u067a\n\u008d\3\u008d\3\u008d\3"+
		"\u008d\3\u008d\3\u008d\5\u008d\u0681\n\u008d\3\u008d\3\u008d\3\u008d\3"+
		"\u008d\3\u008d\3\u008d\3\u008d\3\u008d\5\u008d\u068b\n\u008d\5\u008d\u068d"+
		"\n\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\5\u008d\u0694\n\u008d"+
		"\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\5\u008d\u069c\n\u008d"+
		"\5\u008d\u069e\n\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\5\u008d\u06a8\n\u008d\5\u008d\u06aa\n\u008d\3\u008e\3"+
		"\u008e\5\u008e\u06ae\n\u008e\3\u008f\3\u008f\3\u0090\3\u0090\3\u0091\3"+
		"\u0091\3\u0092\3\u0092\3\u0093\3\u0093\5\u0093\u06ba\n\u0093\3\u0093\3"+
		"\u0093\3\u0093\5\u0093\u06bf\n\u0093\3\u0093\5\u0093\u06c2\n\u0093\3\u0093"+
		"\5\u0093\u06c5\n\u0093\3\u0093\5\u0093\u06c8\n\u0093\3\u0094\3\u0094\3"+
		"\u0094\3\u0094\7\u0094\u06ce\n\u0094\f\u0094\16\u0094\u06d1\13\u0094\5"+
		"\u0094\u06d3\n\u0094\3\u0095\3\u0095\3\u0095\5\u0095\u06d8\n\u0095\3\u0095"+
		"\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095"+
		"\3\u0095\3\u0095\7\u0095\u06e6\n\u0095\f\u0095\16\u0095\u06e9\13\u0095"+
		"\3\u0095\3\u0095\5\u0095\u06ed\n\u0095\5\u0095\u06ef\n\u0095\3\u0096\3"+
		"\u0096\3\u0096\3\u0096\7\u0096\u06f5\n\u0096\f\u0096\16\u0096\u06f8\13"+
		"\u0096\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\5\u0098\u0700\n"+
		"\u0098\3\u0098\3\u0098\3\u0098\7\u0098\u0705\n\u0098\f\u0098\16\u0098"+
		"\u0708\13\u0098\3\u0099\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\3\u009a"+
		"\7\u009a\u0711\n\u009a\f\u009a\16\u009a\u0714\13\u009a\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\5\u009b\u0722\n\u009b\5\u009b\u0724\n\u009b\3\u009b\3\u009b\3"+
		"\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\7\u009b"+
		"\u0739\n\u009b\f\u009b\16\u009b\u073c\13\u009b\3\u009c\3\u009c\3\u009c"+
		"\3\u009c\3\u009c\3\u009c\3\u009c\7\u009c\u0745\n\u009c\f\u009c\16\u009c"+
		"\u0748\13\u009c\3\u009c\3\u009c\5\u009c\u074c\n\u009c\3\u009d\3\u009d"+
		"\5\u009d\u0750\n\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\5\u009d"+
		"\u0757\n\u009d\3\u009d\3\u009d\3\u009d\3\u009d\5\u009d\u075d\n\u009d\3"+
		"\u009d\3\u009d\3\u009d\3\u009d\5\u009d\u0763\n\u009d\3\u009d\3\u009d\3"+
		"\u009d\5\u009d\u0768\n\u009d\3\u009d\5\u009d\u076b\n\u009d\3\u009d\3\u009d"+
		"\3\u009d\3\u009d\5\u009d\u0771\n\u009d\3\u009d\3\u009d\5\u009d\u0775\n"+
		"\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\5\u009d\u077c\n\u009d\5"+
		"\u009d\u077e\n\u009d\3\u009e\5\u009e\u0781\n\u009e\3\u009e\3\u009e\3\u009e"+
		"\3\u009e\3\u009e\7\u009e\u0788\n\u009e\f\u009e\16\u009e\u078b\13\u009e"+
		"\3\u009e\3\u009e\5\u009e\u078f\n\u009e\3\u009f\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\3\u009f\3\u009f\7\u009f\u07a2\n\u009f\f\u009f\16\u009f"+
		"\u07a5\13\u009f\3\u009f\3\u009f\3\u009f\3\u009f\5\u009f\u07ab\n\u009f"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a0\3\u00a0\7\u00a0\u07b2\n\u00a0\f\u00a0"+
		"\16\u00a0\u07b5\13\u00a0\3\u00a0\3\u00a0\5\u00a0\u07b9\n\u00a0\3\u00a1"+
		"\5\u00a1\u07bc\n\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2\3\u00a2\3\u00a2"+
		"\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2"+
		"\3\u00a2\7\u00a2\u07ce\n\u00a2\f\u00a2\16\u00a2\u07d1\13\u00a2\3\u00a2"+
		"\3\u00a2\5\u00a2\u07d5\n\u00a2\3\u00a2\3\u00a2\3\u00a2\5\u00a2\u07da\n"+
		"\u00a2\3\u00a2\5\u00a2\u07dd\n\u00a2\3\u00a2\3\u00a2\7\u00a2\u07e1\n\u00a2"+
		"\f\u00a2\16\u00a2\u07e4\13\u00a2\3\u00a3\3\u00a3\3\u00a3\3\u00a3\5\u00a3"+
		"\u07ea\n\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a4\7\u00a4"+
		"\u07f2\n\u00a4\f\u00a4\16\u00a4\u07f5\13\u00a4\3\u00a4\3\u00a4\5\u00a4"+
		"\u07f9\n\u00a4\3\u00a5\3\u00a5\5\u00a5\u07fd\n\u00a5\3\u00a5\6\u00a5\u0800"+
		"\n\u00a5\r\u00a5\16\u00a5\u0801\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6"+
		"\7\u00a6\u0809\n\u00a6\f\u00a6\16\u00a6\u080c\13\u00a6\3\u00a6\3\u00a6"+
		"\5\u00a6\u0810\n\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\5\u00a6"+
		"\u0817\n\u00a6\5\u00a6\u0819\n\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7\3"+
		"\u00a7\5\u00a7\u0820\n\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3"+
		"\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8"+
		"\3\u00a8\3\u00a8\5\u00a8\u0832\n\u00a8\3\u00a9\3\u00a9\3\u00a9\3\u00a9"+
		"\7\u00a9\u0838\n\u00a9\f\u00a9\16\u00a9\u083b\13\u00a9\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\5\u00a9\u0846"+
		"\n\u00a9\3\u00aa\3\u00aa\3\u00aa\5\u00aa\u084b\n\u00aa\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\5\u00ab\u0854\n\u00ab\3\u00ac"+
		"\3\u00ac\5\u00ac\u0858\n\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ac\5\u00ac\u0860\n\u00ac\3\u00ac\5\u00ac\u0863\n\u00ac\3\u00ac\3"+
		"\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\7\u00ac\u086d\n"+
		"\u00ac\f\u00ac\16\u00ac\u0870\13\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u0884\n\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u088c\n\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ad\5\u00ad\u08c7\n\u00ad\3\u00ae\3\u00ae\5\u00ae\u08cb\n"+
		"\u00ae\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b1\3\u00b1\3\u00b2\3\u00b2"+
		"\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u08d8\n\u00b3\3\u00b3\3\u00b3\3\u00b3"+
		"\7\u00b3\u08dd\n\u00b3\f\u00b3\16\u00b3\u08e0\13\u00b3\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\5\u00b4\u08e9\n\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b4\3\u00b4\5\u00b4\u0909\n\u00b4\3\u00b5\3\u00b5\3\u00b6\3\u00b6"+
		"\3\u00b7\3\u00b7\3\u00b7\5\u00b7\u0912\n\u00b7\3\u00b7\3\u00b7\5\u00b7"+
		"\u0916\n\u00b7\5\u00b7\u0918\n\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3"+
		"\u00b7\3\u00b7\7\u00b7\u0920\n\u00b7\f\u00b7\16\u00b7\u0923\13\u00b7\3"+
		"\u00b8\3\u00b8\3\u00b8\3\u00b8\3\u00b8\5\u00b8\u092a\n\u00b8\3\u00b9\3"+
		"\u00b9\5\u00b9\u092e\n\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00b9\5"+
		"\u00b9\u0935\n\u00b9\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5"+
		"\u00ba\u093d\n\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba\u0944"+
		"\n\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba\u094b\n\u00ba"+
		"\3\u00ba\3\u00ba\3\u00ba\3\u00ba\3\u00ba\5\u00ba\u0952\n\u00ba\5\u00ba"+
		"\u0954\n\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb"+
		"\u095c\n\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb"+
		"\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\5\u00bb\u096b\n\u00bb"+
		"\3\u00bb\3\u00bb\5\u00bb\u096f\n\u00bb\5\u00bb\u0971\n\u00bb\3\u00bb\3"+
		"\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\7\u00bb\u097b\n"+
		"\u00bb\f\u00bb\16\u00bb\u097e\13\u00bb\3\u00bc\3\u00bc\3\u00bd\3\u00bd"+
		"\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\7\u00be\u098a\n\u00be"+
		"\f\u00be\16\u00be\u098d\13\u00be\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00bf\5\u00bf\u0996\n\u00bf\3\u00bf\3\u00bf\3\u00bf\5\u00bf"+
		"\u099b\n\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\5\u00bf\u09a2\n"+
		"\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\3\u00bf\7\u00bf\u09a9\n\u00bf\f"+
		"\u00bf\16\u00bf\u09ac\13\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0"+
		"\3\u00c0\5\u00c0\u09b4\n\u00c0\3\u00c0\5\u00c0\u09b7\n\u00c0\5\u00c0\u09b9"+
		"\n\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\7\u00c0\u09bf\n\u00c0\f\u00c0"+
		"\16\u00c0\u09c2\13\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\5\u00c1\u09e6\n\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\5\u00c1\u0a04\n\u00c1\3\u00c2"+
		"\3\u00c2\3\u00c2\3\u00c3\5\u00c3\u0a0a\n\u00c3\3\u00c3\3\u00c3\5\u00c3"+
		"\u0a0e\n\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c3\3\u00c4\5\u00c4\u0a15\n"+
		"\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\7\u00c4\u0a1b\n\u00c4\f\u00c4\16"+
		"\u00c4\u0a1e\13\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c4\5\u00c4\u0a24\n"+
		"\u00c4\3\u00c5\5\u00c5\u0a27\n\u00c5\3\u00c5\3\u00c5\3\u00c5\3\u00c5\5"+
		"\u00c5\u0a2d\n\u00c5\3\u00c6\5\u00c6\u0a30\n\u00c6\3\u00c6\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c6\5\u00c6\u0a37\n\u00c6\3\u00c7\3\u00c7\5\u00c7\u0a3b\n"+
		"\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c8\3\u00c8"+
		"\3\u00c9\3\u00c9\5\u00c9\u0a47\n\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00c9"+
		"\3\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cb"+
		"\3\u00cc\5\u00cc\u0a57\n\u00cc\3\u00cc\3\u00cc\5\u00cc\u0a5b\n\u00cc\3"+
		"\u00cc\3\u00cc\3\u00cd\5\u00cd\u0a60\n\u00cd\3\u00cd\3\u00cd\3\u00cd\3"+
		"\u00cd\3\u00ce\3\u00ce\5\u00ce\u0a68\n\u00ce\3\u00ce\3\u00ce\3\u00ce\3"+
		"\u00cf\3\u00cf\5\u00cf\u0a6f\n\u00cf\3\u00cf\3\u00cf\3\u00cf\3\u00cf\3"+
		"\u00cf\7\u00cf\u0a76\n\u00cf\f\u00cf\16\u00cf\u0a79\13\u00cf\3\u00cf\3"+
		"\u00cf\3\u00d0\5\u00d0\u0a7e\n\u00d0\3\u00d0\3\u00d0\3\u00d1\3\u00d1\5"+
		"\u00d1\u0a84\n\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\6\u00d2\u0a8b"+
		"\n\u00d2\r\u00d2\16\u00d2\u0a8c\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2"+
		"\3\u00d2\3\u00d2\7\u00d2\u0a96\n\u00d2\f\u00d2\16\u00d2\u0a99\13\u00d2"+
		"\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\3\u00d2\5\u00d2\u0aa1\n\u00d2"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3\u0ac3\n\u00d3\3\u00d3"+
		"\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\5\u00d3"+
		"\u0ace\n\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\3\u00d3\7\u00d3\u0ad5\n"+
		"\u00d3\f\u00d3\16\u00d3\u0ad8\13\u00d3\3\u00d4\3\u00d4\3\u00d4\3\u00d4"+
		"\3\u00d4\5\u00d4\u0adf\n\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0ae4\n"+
		"\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0ae9\n\u00d4\3\u00d4\3\u00d4\3"+
		"\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0af2\n\u00d4\3\u00d4\3"+
		"\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0afa\n\u00d4\3\u00d4\3"+
		"\u00d4\3\u00d4\3\u00d4\3\u00d4\3\u00d4\5\u00d4\u0b02\n\u00d4\5\u00d4\u0b04"+
		"\n\u00d4\3\u00d5\3\u00d5\3\u00d5\7\u00d5\u0b09\n\u00d5\f\u00d5\16\u00d5"+
		"\u0b0c\13\u00d5\3\u00d6\3\u00d6\3\u00d7\3\u00d7\3\u00d8\3\u00d8\3\u00d8"+
		"\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d8\3\u00d9\3\u00d9\3\u00d9\7\u00d9"+
		"\u0b1d\n\u00d9\f\u00d9\16\u00d9\u0b20\13\u00d9\3\u00da\3\u00da\5\u00da"+
		"\u0b24\n\u00da\3\u00da\5\u00da\u0b27\n\u00da\3\u00db\3\u00db\3\u00db\3"+
		"\u00db\3\u00db\3\u00db\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\7\u00dc"+
		"\u0b34\n\u00dc\f\u00dc\16\u00dc\u0b37\13\u00dc\3\u00dc\3\u00dc\3\u00dd"+
		"\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\3\u00dd\5\u00dd\u0b42\n\u00dd"+
		"\3\u00de\3\u00de\3\u00de\3\u00de\3\u00de\3\u00de\3\u00de\3\u00de\5\u00de"+
		"\u0b4c\n\u00de\3\u00df\3\u00df\3\u00df\3\u00df\3\u00e0\5\u00e0\u0b53\n"+
		"\u00e0\3\u00e0\5\u00e0\u0b56\n\u00e0\3\u00e0\5\u00e0\u0b59\n\u00e0\3\u00e0"+
		"\5\u00e0\u0b5c\n\u00e0\3\u00e1\3\u00e1\3\u00e1\3\u00e1\3\u00e1\7\u00e1"+
		"\u0b63\n\u00e1\f\u00e1\16\u00e1\u0b66\13\u00e1\3\u00e2\3\u00e2\3\u00e2"+
		"\3\u00e2\3\u00e3\3\u00e3\3\u00e3\5\u00e3\u0b6f\n\u00e3\3\u00e3\5\u00e3"+
		"\u0b72\n\u00e3\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4\3\u00e4"+
		"\5\u00e4\u0b7b\n\u00e4\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e6"+
		"\3\u00e6\3\u00e7\3\u00e7\3\u00e8\3\u00e8\3\u00e8\3\u00e8\3\u00e8\3\u00e8"+
		"\5\u00e8\u0b8c\n\u00e8\3\u00e9\3\u00e9\3\u00e9\3\u00e9\3\u00ea\3\u00ea"+
		"\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea"+
		"\3\u00ea\7\u00ea\u0b9e\n\u00ea\f\u00ea\16\u00ea\u0ba1\13\u00ea\3\u00ea"+
		"\3\u00ea\3\u00ea\3\u00ea\5\u00ea\u0ba7\n\u00ea\3\u00ea\3\u00ea\6\u00ea"+
		"\u0bab\n\u00ea\r\u00ea\16\u00ea\u0bac\3\u00ea\3\u00ea\5\u00ea\u0bb1\n"+
		"\u00ea\3\u00ea\3\u00ea\3\u00ea\3\u00ea\6\u00ea\u0bb7\n\u00ea\r\u00ea\16"+
		"\u00ea\u0bb8\3\u00ea\3\u00ea\5\u00ea\u0bbd\n\u00ea\3\u00ea\3\u00ea\5\u00ea"+
		"\u0bc1\n\u00ea\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00eb\3\u00ec\3\u00ec"+
		"\3\u00ec\3\u00ec\3\u00ec\3\u00ed\3\u00ed\5\u00ed\u0bcf\n\u00ed\3\u00ee"+
		"\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee"+
		"\3\u00ee\3\u00ee\3\u00ee\3\u00ee\3\u00ee\5\u00ee\u0be0\n\u00ee\3\u00ef"+
		"\3\u00ef\3\u00ef\3\u00ef\3\u00ef\3\u00ef\3\u00ef\3\u00f0\3\u00f0\3\u00f0"+
		"\3\u00f0\3\u00f0\3\u00f0\3\u00f0\3\u00f0\5\u00f0\u0bf1\n\u00f0\3\u00f1"+
		"\3\u00f1\3\u00f1\3\u00f1\3\u00f1\3\u00f1\5\u00f1\u0bf9\n\u00f1\3\u00f1"+
		"\3\u00f1\3\u00f2\3\u00f2\3\u00f2\3\u00f2\3\u00f2\3\u00f2\3\u00f2\3\u00f2"+
		"\5\u00f2\u0c05\n\u00f2\3\u00f3\3\u00f3\3\u00f3\3\u00f3\7\u00f3\u0c0b\n"+
		"\u00f3\f\u00f3\16\u00f3\u0c0e\13\u00f3\5\u00f3\u0c10\n\u00f3\3\u00f3\3"+
		"\u00f3\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4\3\u00f4"+
		"\3\u00f4\3\u00f4\3\u00f4\5\u00f4\u0c1f\n\u00f4\3\u00f5\3\u00f5\3\u00f5"+
		"\3\u00f5\3\u00f6\3\u00f6\5\u00f6\u0c27\n\u00f6\3\u00f6\3\u00f6\3\u00f6"+
		"\3\u00f6\3\u00f6\3\u00f6\3\u00f6\5\u00f6\u0c30\n\u00f6\3\u00f7\3\u00f7"+
		"\5\u00f7\u0c34\n\u00f7\3\u00f7\5\u00f7\u0c37\n\u00f7\3\u00f8\3\u00f8\3"+
		"\u00f8\3\u00f8\5\u00f8\u0c3d\n\u00f8\3\u00f9\3\u00f9\3\u00f9\3\u00fa\3"+
		"\u00fa\3\u00fa\3\u00fb\3\u00fb\3\u00fb\3\u00fb\3\u00fb\3\u00fc\3\u00fc"+
		"\3\u00fc\3\u00fc\3\u00fc\7\u00fc\u0c4f\n\u00fc\f\u00fc\16\u00fc\u0c52"+
		"\13\u00fc\3\u00fc\3\u00fc\3\u00fc\3\u00fc\3\u00fc\3\u00fc\3\u00fc\3\u00fc"+
		"\5\u00fc\u0c5c\n\u00fc\3\u00fc\3\u00fc\5\u00fc\u0c60\n\u00fc\3\u00fd\3"+
		"\u00fd\3\u00fd\3\u00fd\3\u00fd\7\u00fd\u0c67\n\u00fd\f\u00fd\16\u00fd"+
		"\u0c6a\13\u00fd\3\u00fd\3\u00fd\3\u00fd\3\u00fd\3\u00fd\3\u00fd\3\u00fd"+
		"\3\u00fd\3\u00fd\3\u00fd\3\u00fd\3\u00fd\5\u00fd\u0c78\n\u00fd\3\u00fe"+
		"\3\u00fe\3\u00fe\3\u00fe\3\u00fe\3\u00ff\3\u00ff\3\u00ff\3\u00ff\3\u00ff"+
		"\3\u0100\3\u0100\5\u0100\u0c86\n\u0100\3\u0101\3\u0101\3\u0101\3\u0101"+
		"\3\u0101\3\u0101\3\u0101\3\u0101\3\u0101\3\u0101\3\u0101\5\u0101\u0c93"+
		"\n\u0101\5\u0101\u0c95\n\u0101\3\u0102\3\u0102\3\u0103\3\u0103\3\u0103"+
		"\3\u0104\3\u0104\3\u0104\5\u0104\u0c9f\n\u0104\3\u0104\5\u0104\u0ca2\n"+
		"\u0104\3\u0105\5\u0105\u0ca5\n\u0105\3\u0105\3\u0105\5\u0105\u0ca9\n\u0105"+
		"\3\u0106\3\u0106\5\u0106\u0cad\n\u0106\3\u0107\3\u0107\5\u0107\u0cb1\n"+
		"\u0107\3\u0108\3\u0108\3\u0108\5\u0108\u0cb6\n\u0108\3\u0108\3\u0108\5"+
		"\u0108\u0cba\n\u0108\3\u0109\3\u0109\3\u0109\3\u0109\3\u0109\3\u0109\3"+
		"\u0109\3\u0109\3\u0109\5\u0109\u0cc5\n\u0109\3\u010a\3\u010a\5\u010a\u0cc9"+
		"\n\u010a\3\u010a\3\u010a\5\u010a\u0ccd\n\u010a\3\u010b\3\u010b\3\u010b"+
		"\3\u010b\3\u010b\3\u010c\3\u010c\3\u010c\3\u010c\5\u010c\u0cd8\n\u010c"+
		"\3\u010c\3\u010c\3\u010c\3\u010c\3\u010c\3\u010c\5\u010c\u0ce0\n\u010c"+
		"\5\u010c\u0ce2\n\u010c\3\u010c\5\u010c\u0ce5\n\u010c\3\u010c\5\u010c\u0ce8"+
		"\n\u010c\3\u010d\3\u010d\3\u010d\3\u010d\3\u010d\3\u010e\3\u010e\3\u010e"+
		"\3\u010e\3\u010e\3\u010e\3\u010e\3\u010e\3\u010e\3\u010e\3\u010e\3\u010e"+
		"\3\u010e\3\u010e\5\u010e\u0cfd\n\u010e\3\u010f\5\u010f\u0d00\n\u010f\3"+
		"\u010f\3\u010f\3\u010f\3\u010f\3\u010f\3\u010f\7\u010f\u0d08\n\u010f\f"+
		"\u010f\16\u010f\u0d0b\13\u010f\5\u010f\u0d0d\n\u010f\3\u010f\3\u010f\3"+
		"\u0110\3\u0110\3\u0110\3\u0111\3\u0111\3\u0111\7\u0111\u0d17\n\u0111\f"+
		"\u0111\16\u0111\u0d1a\13\u0111\3\u0112\3\u0112\3\u0112\5\u0112\u0d1f\n"+
		"\u0112\3\u0112\5\u0112\u0d22\n\u0112\3\u0112\3\u0112\5\u0112\u0d26\n\u0112"+
		"\3\u0113\6\u0113\u0d29\n\u0113\r\u0113\16\u0113\u0d2a\3\u0114\3\u0114"+
		"\3\u0114\3\u0114\3\u0114\5\u0114\u0d32\n\u0114\3\u0115\3\u0115\3\u0115"+
		"\5\u0115\u0d37\n\u0115\3\u0116\3\u0116\3\u0116\3\u0116\3\u0117\3\u0117"+
		"\3\u0117\3\u0117\3\u0117\3\u0117\7\u0117\u0d43\n\u0117\f\u0117\16\u0117"+
		"\u0d46\13\u0117\3\u0117\3\u0117\3\u0118\3\u0118\3\u0118\3\u0118\3\u0118"+
		"\3\u0119\3\u0119\5\u0119\u0d51\n\u0119\3\u011a\3\u011a\3\u011a\3\u011a"+
		"\3\u011a\3\u011a\3\u011a\3\u011a\3\u011a\3\u011b\3\u011b\3\u011b\3\u011b"+
		"\3\u011b\3\u011b\3\u011b\3\u011b\3\u011b\3\u011c\3\u011c\5\u011c\u0d67"+
		"\n\u011c\3\u011d\3\u011d\3\u011d\3\u011d\3\u011d\3\u011d\3\u011d\3\u011d"+
		"\3\u011d\3\u011e\3\u011e\3\u011e\3\u011e\3\u011e\3\u011e\3\u011e\3\u011e"+
		"\3\u011e\3\u011f\3\u011f\5\u011f\u0d7d\n\u011f\3\u011f\3\u011f\3\u011f"+
		"\3\u011f\5\u011f\u0d83\n\u011f\3\u011f\5\u011f\u0d86\n\u011f\3\u011f\3"+
		"\u011f\3\u0120\3\u0120\5\u0120\u0d8c\n\u0120\3\u0120\3\u0120\3\u0120\3"+
		"\u0120\5\u0120\u0d92\n\u0120\3\u0120\5\u0120\u0d95\n\u0120\3\u0120\3\u0120"+
		"\3\u0121\3\u0121\5\u0121\u0d9b\n\u0121\3\u0121\3\u0121\3\u0121\3\u0121"+
		"\5\u0121\u0da1\n\u0121\3\u0121\5\u0121\u0da4\n\u0121\3\u0121\3\u0121\3"+
		"\u0121\3\u0121\3\u0122\3\u0122\3\u0122\3\u0122\3\u0123\3\u0123\3\u0123"+
		"\3\u0123\3\u0123\5\u0123\u0db3\n\u0123\3\u0123\3\u0123\5\u0123\u0db7\n"+
		"\u0123\3\u0123\3\u0123\3\u0124\3\u0124\3\u0124\3\u0124\3\u0124\5\u0124"+
		"\u0dc0\n\u0124\3\u0124\3\u0124\3\u0124\5\u0124\u0dc5\n\u0124\3\u0124\3"+
		"\u0124\5\u0124\u0dc9\n\u0124\3\u0124\3\u0124\3\u0125\3\u0125\3\u0125\3"+
		"\u0125\3\u0125\3\u0125\5\u0125\u0dd3\n\u0125\3\u0125\3\u0125\5\u0125\u0dd7"+
		"\n\u0125\3\u0125\3\u0125\3\u0125\5\u0125\u0ddc\n\u0125\3\u0125\3\u0125"+
		"\3\u0126\3\u0126\3\u0126\3\u0126\3\u0126\3\u0126\3\u0126\3\u0126\3\u0126"+
		"\3\u0126\7\u0126\u0dea\n\u0126\f\u0126\16\u0126\u0ded\13\u0126\5\u0126"+
		"\u0def\n\u0126\3\u0126\3\u0126\3\u0127\3\u0127\3\u0127\7\u0127\u0df6\n"+
		"\u0127\f\u0127\16\u0127\u0df9\13\u0127\3\u0128\3\u0128\5\u0128\u0dfd\n"+
		"\u0128\3\u0129\3\u0129\3\u0129\3\u0129\5\u0129\u0e03\n\u0129\3\u0129\3"+
		"\u0129\3\u0129\5\u0129\u0e08\n\u0129\3\u0129\5\u0129\u0e0b\n\u0129\3\u012a"+
		"\3\u012a\3\u012a\3\u012b\5\u012b\u0e11\n\u012b\3\u012b\3\u012b\3\u012b"+
		"\3\u012b\5\u012b\u0e17\n\u012b\3\u012b\3\u012b\3\u012b\3\u012b\5\u012b"+
		"\u0e1d\n\u012b\3\u012c\3\u012c\3\u012c\3\u012c\3\u012c\3\u012c\3\u012c"+
		"\7\u012c\u0e26\n\u012c\f\u012c\16\u012c\u0e29\13\u012c\5\u012c\u0e2b\n"+
		"\u012c\5\u012c\u0e2d\n\u012c\3\u012d\3\u012d\5\u012d\u0e31\n\u012d\3\u012d"+
		"\5\u012d\u0e34\n\u012d\3\u012d\3\u012d\3\u012d\5\u012d\u0e39\n\u012d\3"+
		"\u012d\5\u012d\u0e3c\n\u012d\3\u012d\3\u012d\3\u012d\3\u012d\5\u012d\u0e42"+
		"\n\u012d\3\u012d\3\u012d\3\u012d\3\u012d\5\u012d\u0e48\n\u012d\3\u012d"+
		"\5\u012d\u0e4b\n\u012d\3\u012e\3\u012e\3\u012e\5\u012e\u0e50\n\u012e\3"+
		"\u012e\3\u012e\3\u012e\3\u012e\3\u012e\5\u012e\u0e57\n\u012e\3\u012e\3"+
		"\u012e\3\u012e\3\u012e\3\u012e\3\u012e\5\u012e\u0e5f\n\u012e\3\u012f\3"+
		"\u012f\3\u012f\7\u012f\u0e64\n\u012f\f\u012f\16\u012f\u0e67\13\u012f\3"+
		"\u0130\5\u0130\u0e6a\n\u0130\3\u0130\5\u0130\u0e6d\n\u0130\3\u0130\3\u0130"+
		"\5\u0130\u0e71\n\u0130\3\u0131\3\u0131\3\u0131\5\u0131\u0e76\n\u0131\3"+
		"\u0132\3\u0132\3\u0132\3\u0133\3\u0133\5\u0133\u0e7d\n\u0133\3\u0133\5"+
		"\u0133\u0e80\n\u0133\3\u0134\3\u0134\3\u0134\5\u0134\u0e85\n\u0134\3\u0135"+
		"\3\u0135\3\u0135\3\u0135\3\u0135\5\u0135\u0e8c\n\u0135\3\u0136\3\u0136"+
		"\3\u0136\3\u0137\3\u0137\3\u0137\3\u0137\7\u0137\u0e95\n\u0137\f\u0137"+
		"\16\u0137\u0e98\13\u0137\3\u0137\3\u0137\3\u0138\3\u0138\3\u0138\3\u0139"+
		"\6\u0139\u0ea0\n\u0139\r\u0139\16\u0139\u0ea1\3\u013a\3\u013a\3\u013a"+
		"\3\u013a\3\u013a\3\u013a\3\u013a\3\u013a\5\u013a\u0eac\n\u013a\3\u013b"+
		"\7\u013b\u0eaf\n\u013b\f\u013b\16\u013b\u0eb2\13\u013b\3\u013b\5\u013b"+
		"\u0eb5\n\u013b\3\u013c\3\u013c\3\u013c\3\u013c\3\u013c\3\u013c\5\u013c"+
		"\u0ebd\n\u013c\3\u013d\3\u013d\3\u013d\3\u013d\5\u013d\u0ec3\n\u013d\3"+
		"\u013d\5\u013d\u0ec6\n\u013d\3\u013d\3\u013d\3\u013d\3\u013d\7\u013d\u0ecc"+
		"\n\u013d\f\u013d\16\u013d\u0ecf\13\u013d\3\u013e\3\u013e\3\u013e\3\u013e"+
		"\5\u013e\u0ed5\n\u013e\3\u013e\5\u013e\u0ed8\n\u013e\3\u013e\3\u013e\3"+
		"\u013f\3\u013f\3\u013f\7\u013f\u0edf\n\u013f\f\u013f\16\u013f\u0ee2\13"+
		"\u013f\3\u0140\3\u0140\3\u0140\3\u0141\3\u0141\3\u0141\3\u0141\3\u0141"+
		"\5\u0141\u0eec\n\u0141\3\u0142\3\u0142\3\u0142\3\u0142\3\u0142\3\u0142"+
		"\7\u0142\u0ef4\n\u0142\f\u0142\16\u0142\u0ef7\13\u0142\3\u0142\3\u0142"+
		"\5\u0142\u0efb\n\u0142\3\u0143\3\u0143\3\u0143\3\u0143\3\u0143\3\u0143"+
		"\3\u0143\3\u0143\7\u0143\u0f05\n\u0143\f\u0143\16\u0143\u0f08\13\u0143"+
		"\3\u0143\3\u0143\3\u0143\3\u0143\5\u0143\u0f0e\n\u0143\3\u0144\3\u0144"+
		"\3\u0144\7\u0144\u0f13\n\u0144\f\u0144\16\u0144\u0f16\13\u0144\3\u0144"+
		"\3\u0144\3\u0144\3\u0144\5\u0144\u0f1c\n\u0144\3\u0145\3\u0145\3\u0145"+
		"\3\u0145\3\u0145\5\u0145\u0f23\n\u0145\3\u0146\3\u0146\5\u0146\u0f27\n"+
		"\u0146\3\u0147\3\u0147\3\u0147\3\u0147\6\u0147\u0f2d\n\u0147\r\u0147\16"+
		"\u0147\u0f2e\3\u0147\3\u0147\3\u0147\3\u0147\3\u0147\3\u0147\3\u0147\7"+
		"\u0147\u0f38\n\u0147\f\u0147\16\u0147\u0f3b\13\u0147\3\u0147\3\u0147\3"+
		"\u0147\5\u0147\u0f40\n\u0147\3\u0147\3\u0eb0\r\u00e0\u0134\u0142\u0156"+
		"\u0164\u016c\u0174\u017a\u017c\u017e\u01a4\u0148\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp"+
		"rtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c"+
		"\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124"+
		"\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c"+
		"\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154"+
		"\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c"+
		"\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184"+
		"\u0186\u0188\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a\u019c"+
		"\u019e\u01a0\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4"+
		"\u01b6\u01b8\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc"+
		"\u01ce\u01d0\u01d2\u01d4\u01d6\u01d8\u01da\u01dc\u01de\u01e0\u01e2\u01e4"+
		"\u01e6\u01e8\u01ea\u01ec\u01ee\u01f0\u01f2\u01f4\u01f6\u01f8\u01fa\u01fc"+
		"\u01fe\u0200\u0202\u0204\u0206\u0208\u020a\u020c\u020e\u0210\u0212\u0214"+
		"\u0216\u0218\u021a\u021c\u021e\u0220\u0222\u0224\u0226\u0228\u022a\u022c"+
		"\u022e\u0230\u0232\u0234\u0236\u0238\u023a\u023c\u023e\u0240\u0242\u0244"+
		"\u0246\u0248\u024a\u024c\u024e\u0250\u0252\u0254\u0256\u0258\u025a\u025c"+
		"\u025e\u0260\u0262\u0264\u0266\u0268\u026a\u026c\u026e\u0270\u0272\u0274"+
		"\u0276\u0278\u027a\u027c\u027e\u0280\u0282\u0284\u0286\u0288\u028a\u028c"+
		"\2(\4\2,,\u0100\u0100\4\2__\u01c5\u01c5\4\2ss\u0095\u0095\5\2\u0085\u0085"+
		"\u0116\u0116\u01bf\u01bf\4\2\u008b\u008b\u00b1\u00b1\5\2\u0094\u0094\u0099"+
		"\u0099\u00dc\u00dc\n\2\u011b\u011b\u015b\u015b\u0162\u0162\u016c\u016c"+
		"\u0195\u0195\u01ad\u01ad\u01c0\u01c0\u01c3\u01c3\4\2\u011b\u011b\u0197"+
		"\u0197\5\2\u009d\u009d\u0121\u0121\u017d\u017d\4\2\32\32\u0128\u0128\5"+
		"\2\17\17\24\24\u0118\u0118\4\2\17\17gg\4\2!!\u0129\u0129\5\2\u0085\u0085"+
		"\u00ae\u00ae\u0105\u0105\4\2\30\30cc\6\2II``\u00e4\u00e4\u00ee\u00ee\17"+
		"\2\24\24\36\36<<EEqq\u0087\u0087\u00a2\u00a2\u00b7\u00b7\u00bb\u00bb\u0118"+
		"\u0118\u0122\u0123\u0127\u0127\u0148\u0149\5\2CD\u00f5\u00fd\u0181\u0181"+
		"\3\2\u00e5\u00e6\4\2\u00ed\u00ed\u010a\u010a\4\2\u0230\u0230\u0235\u0235"+
		"\4\2\u0231\u0231\u0233\u0233\4\2\23\23\u00d9\u00d9\3\2\u0131\u0132\5\2"+
		"\u0088\u0088\u00a8\u00a8\u00b5\u00b5\4\2\u0153\u0153\u0155\u0155\5\2r"+
		"r\u00a1\u00a1\u013e\u013e\b\2WW\u0091\u0091\u00bc\u00bc\u00c0\u00c0\u0110"+
		"\u0110\u0157\u0157\4\2\u0223\u0225\u0238\u023a\4\2--\u00b1\u00b1\4\2\16"+
		"\16\37\37\3\2\62\63\3\2YZ\3\2\u009f\u00a0\4\2\64\65\u00d1\u00d1\3\2\60"+
		"\61\4\2\u00b4\u00b4\u0143\u0143\4\2\u0108\u0108\u01e8\u01e8\u1080\2\u0291"+
		"\3\2\2\2\4\u02a5\3\2\2\2\6\u02aa\3\2\2\2\b\u02ac\3\2\2\2\n\u02b1\3\2\2"+
		"\2\f\u02b8\3\2\2\2\16\u02ba\3\2\2\2\20\u02bc\3\2\2\2\22\u02be\3\2\2\2"+
		"\24\u02c0\3\2\2\2\26\u02c2\3\2\2\2\30\u02c4\3\2\2\2\32\u02c6\3\2\2\2\34"+
		"\u02c8\3\2\2\2\36\u02ca\3\2\2\2 \u02cc\3\2\2\2\"\u02ce\3\2\2\2$\u02d0"+
		"\3\2\2\2&\u02d2\3\2\2\2(\u02d9\3\2\2\2*\u02e4\3\2\2\2,\u02e6\3\2\2\2."+
		"\u02ee\3\2\2\2\60\u02f0\3\2\2\2\62\u02f2\3\2\2\2\64\u02f4\3\2\2\2\66\u02f6"+
		"\3\2\2\28\u02f8\3\2\2\2:\u02fa\3\2\2\2<\u02fc\3\2\2\2>\u02fe\3\2\2\2@"+
		"\u0300\3\2\2\2B\u0302\3\2\2\2D\u0304\3\2\2\2F\u0309\3\2\2\2H\u030c\3\2"+
		"\2\2J\u030f\3\2\2\2L\u0316\3\2\2\2N\u0318\3\2\2\2P\u0327\3\2\2\2R\u0329"+
		"\3\2\2\2T\u032d\3\2\2\2V\u0332\3\2\2\2X\u0336\3\2\2\2Z\u0338\3\2\2\2\\"+
		"\u033a\3\2\2\2^\u0345\3\2\2\2`\u0348\3\2\2\2b\u0356\3\2\2\2d\u0358\3\2"+
		"\2\2f\u035a\3\2\2\2h\u035c\3\2\2\2j\u035e\3\2\2\2l\u0360\3\2\2\2n\u0367"+
		"\3\2\2\2p\u0369\3\2\2\2r\u036f\3\2\2\2t\u0371\3\2\2\2v\u0373\3\2\2\2x"+
		"\u0375\3\2\2\2z\u0377\3\2\2\2|\u0379\3\2\2\2~\u0385\3\2\2\2\u0080\u0387"+
		"\3\2\2\2\u0082\u0389\3\2\2\2\u0084\u038b\3\2\2\2\u0086\u038d\3\2\2\2\u0088"+
		"\u038f\3\2\2\2\u008a\u0391\3\2\2\2\u008c\u0395\3\2\2\2\u008e\u0398\3\2"+
		"\2\2\u0090\u039a\3\2\2\2\u0092\u039c\3\2\2\2\u0094\u039e\3\2\2\2\u0096"+
		"\u03a0\3\2\2\2\u0098\u03aa\3\2\2\2\u009a\u03ad\3\2\2\2\u009c\u03b1\3\2"+
		"\2\2\u009e\u03b3\3\2\2\2\u00a0\u03bb\3\2\2\2\u00a2\u03c5\3\2\2\2\u00a4"+
		"\u03c7\3\2\2\2\u00a6\u03cc\3\2\2\2\u00a8\u03d6\3\2\2\2\u00aa\u03db\3\2"+
		"\2\2\u00ac\u03e0\3\2\2\2\u00ae\u040b\3\2\2\2\u00b0\u0418\3\2\2\2\u00b2"+
		"\u0435\3\2\2\2\u00b4\u0437\3\2\2\2\u00b6\u043a\3\2\2\2\u00b8\u044a\3\2"+
		"\2\2\u00ba\u045e\3\2\2\2\u00bc\u0460\3\2\2\2\u00be\u0463\3\2\2\2\u00c0"+
		"\u0470\3\2\2\2\u00c2\u0472\3\2\2\2\u00c4\u0486\3\2\2\2\u00c6\u048c\3\2"+
		"\2\2\u00c8\u0492\3\2\2\2\u00ca\u0497\3\2\2\2\u00cc\u04cb\3\2\2\2\u00ce"+
		"\u04cd\3\2\2\2\u00d0\u04d6\3\2\2\2\u00d2\u0508\3\2\2\2\u00d4\u0512\3\2"+
		"\2\2\u00d6\u052d\3\2\2\2\u00d8\u052f\3\2\2\2\u00da\u054d\3\2\2\2\u00dc"+
		"\u054f\3\2\2\2\u00de\u0553\3\2\2\2\u00e0\u056d\3\2\2\2\u00e2\u057e\3\2"+
		"\2\2\u00e4\u0585\3\2\2\2\u00e6\u0588\3\2\2\2\u00e8\u05a9\3\2\2\2\u00ea"+
		"\u05ab\3\2\2\2\u00ec\u05b5\3\2\2\2\u00ee\u05c1\3\2\2\2\u00f0\u05cc\3\2"+
		"\2\2\u00f2\u05d9\3\2\2\2\u00f4\u05e9\3\2\2\2\u00f6\u05f1\3\2\2\2\u00f8"+
		"\u05f3\3\2\2\2\u00fa\u05fd\3\2\2\2\u00fc\u0609\3\2\2\2\u00fe\u0611\3\2"+
		"\2\2\u0100\u061c\3\2\2\2\u0102\u0627\3\2\2\2\u0104\u0629\3\2\2\2\u0106"+
		"\u062b\3\2\2\2\u0108\u062d\3\2\2\2\u010a\u0634\3\2\2\2\u010c\u0636\3\2"+
		"\2\2\u010e\u0639\3\2\2\2\u0110\u063b\3\2\2\2\u0112\u063d\3\2\2\2\u0114"+
		"\u0647\3\2\2\2\u0116\u0651\3\2\2\2\u0118\u06a9\3\2\2\2\u011a\u06ab\3\2"+
		"\2\2\u011c\u06af\3\2\2\2\u011e\u06b1\3\2\2\2\u0120\u06b3\3\2\2\2\u0122"+
		"\u06b5\3\2\2\2\u0124\u06b7\3\2\2\2\u0126\u06d2\3\2\2\2\u0128\u06ee\3\2"+
		"\2\2\u012a\u06f0\3\2\2\2\u012c\u06f9\3\2\2\2\u012e\u06fc\3\2\2\2\u0130"+
		"\u0709\3\2\2\2\u0132\u070c\3\2\2\2\u0134\u0723\3\2\2\2\u0136\u074b\3\2"+
		"\2\2\u0138\u077d\3\2\2\2\u013a\u0780\3\2\2\2\u013c\u07aa\3\2\2\2\u013e"+
		"\u07b8\3\2\2\2\u0140\u07bb\3\2\2\2\u0142\u07d4\3\2\2\2\u0144\u07e9\3\2"+
		"\2\2\u0146\u07eb\3\2\2\2\u0148\u07fa\3\2\2\2\u014a\u0803\3\2\2\2\u014c"+
		"\u081f\3\2\2\2\u014e\u0831\3\2\2\2\u0150\u0845\3\2\2\2\u0152\u084a\3\2"+
		"\2\2\u0154\u0853\3\2\2\2\u0156\u0862\3\2\2\2\u0158\u08c6\3\2\2\2\u015a"+
		"\u08ca\3\2\2\2\u015c\u08cc\3\2\2\2\u015e\u08ce\3\2\2\2\u0160\u08d0\3\2"+
		"\2\2\u0162\u08d2\3\2\2\2\u0164\u08d7\3\2\2\2\u0166\u0908\3\2\2\2\u0168"+
		"\u090a\3\2\2\2\u016a\u090c\3\2\2\2\u016c\u0917\3\2\2\2\u016e\u0924\3\2"+
		"\2\2\u0170\u0934\3\2\2\2\u0172\u0953\3\2\2\2\u0174\u0970\3\2\2\2\u0176"+
		"\u097f\3\2\2\2\u0178\u0981\3\2\2\2\u017a\u0983\3\2\2\2\u017c\u0995\3\2"+
		"\2\2\u017e\u09b8\3\2\2\2\u0180\u0a03\3\2\2\2\u0182\u0a05\3\2\2\2\u0184"+
		"\u0a09\3\2\2\2\u0186\u0a14\3\2\2\2\u0188\u0a26\3\2\2\2\u018a\u0a2f\3\2"+
		"\2\2\u018c\u0a38\3\2\2\2\u018e\u0a3e\3\2\2\2\u0190\u0a44\3\2\2\2\u0192"+
		"\u0a4d\3\2\2\2\u0194\u0a50\3\2\2\2\u0196\u0a56\3\2\2\2\u0198\u0a5f\3\2"+
		"\2\2\u019a\u0a65\3\2\2\2\u019c\u0a6c\3\2\2\2\u019e\u0a7d\3\2\2\2\u01a0"+
		"\u0a83\3\2\2\2\u01a2\u0aa0\3\2\2\2\u01a4\u0ac2\3\2\2\2\u01a6\u0b03\3\2"+
		"\2\2\u01a8\u0b05\3\2\2\2\u01aa\u0b0d\3\2\2\2\u01ac\u0b0f\3\2\2\2\u01ae"+
		"\u0b11\3\2\2\2\u01b0\u0b19\3\2\2\2\u01b2\u0b21\3\2\2\2\u01b4\u0b28\3\2"+
		"\2\2\u01b6\u0b2e\3\2\2\2\u01b8\u0b3a\3\2\2\2\u01ba\u0b4b\3\2\2\2\u01bc"+
		"\u0b4d\3\2\2\2\u01be\u0b52\3\2\2\2\u01c0\u0b5d\3\2\2\2\u01c2\u0b67\3\2"+
		"\2\2\u01c4\u0b6b\3\2\2\2\u01c6\u0b7a\3\2\2\2\u01c8\u0b7c\3\2\2\2\u01ca"+
		"\u0b81\3\2\2\2\u01cc\u0b83\3\2\2\2\u01ce\u0b8b\3\2\2\2\u01d0\u0b8d\3\2"+
		"\2\2\u01d2\u0bc0\3\2\2\2\u01d4\u0bc2\3\2\2\2\u01d6\u0bc7\3\2\2\2\u01d8"+
		"\u0bce\3\2\2\2\u01da\u0bdf\3\2\2\2\u01dc\u0be1\3\2\2\2\u01de\u0bf0\3\2"+
		"\2\2\u01e0\u0bf2\3\2\2\2\u01e2\u0bfc\3\2\2\2\u01e4\u0c06\3\2\2\2\u01e6"+
		"\u0c1e\3\2\2\2\u01e8\u0c20\3\2\2\2\u01ea\u0c2f\3\2\2\2\u01ec\u0c36\3\2"+
		"\2\2\u01ee\u0c38\3\2\2\2\u01f0\u0c3e\3\2\2\2\u01f2\u0c41\3\2\2\2\u01f4"+
		"\u0c44\3\2\2\2\u01f6\u0c5f\3\2\2\2\u01f8\u0c77\3\2\2\2\u01fa\u0c79\3\2"+
		"\2\2\u01fc\u0c7e\3\2\2\2\u01fe\u0c85\3\2\2\2\u0200\u0c94\3\2\2\2\u0202"+
		"\u0c96\3\2\2\2\u0204\u0c98\3\2\2\2\u0206\u0ca1\3\2\2\2\u0208\u0ca8\3\2"+
		"\2\2\u020a\u0cac\3\2\2\2\u020c\u0cb0\3\2\2\2\u020e\u0cb9\3\2\2\2\u0210"+
		"\u0cc4\3\2\2\2\u0212\u0cc6\3\2\2\2\u0214\u0cce\3\2\2\2\u0216\u0cd3\3\2"+
		"\2\2\u0218\u0ce9\3\2\2\2\u021a\u0cfc\3\2\2\2\u021c\u0cff\3\2\2\2\u021e"+
		"\u0d10\3\2\2\2\u0220\u0d13\3\2\2\2\u0222\u0d1b\3\2\2\2\u0224\u0d28\3\2"+
		"\2\2\u0226\u0d31\3\2\2\2\u0228\u0d36\3\2\2\2\u022a\u0d38\3\2\2\2\u022c"+
		"\u0d3c\3\2\2\2\u022e\u0d49\3\2\2\2\u0230\u0d50\3\2\2\2\u0232\u0d52\3\2"+
		"\2\2\u0234\u0d5b\3\2\2\2\u0236\u0d66\3\2\2\2\u0238\u0d68\3\2\2\2\u023a"+
		"\u0d71\3\2\2\2\u023c\u0d7a\3\2\2\2\u023e\u0d89\3\2\2\2\u0240\u0d98\3\2"+
		"\2\2\u0242\u0da9\3\2\2\2\u0244\u0dad\3\2\2\2\u0246\u0dba\3\2\2\2\u0248"+
		"\u0dcc\3\2\2\2\u024a\u0ddf\3\2\2\2\u024c\u0df2\3\2\2\2\u024e\u0dfc\3\2"+
		"\2\2\u0250\u0dfe\3\2\2\2\u0252\u0e0c\3\2\2\2\u0254\u0e10\3\2\2\2\u0256"+
		"\u0e2c\3\2\2\2\u0258\u0e4a\3\2\2\2\u025a\u0e4f\3\2\2\2\u025c\u0e60\3\2"+
		"\2\2\u025e\u0e69\3\2\2\2\u0260\u0e72\3\2\2\2\u0262\u0e77\3\2\2\2\u0264"+
		"\u0e7f\3\2\2\2\u0266\u0e81\3\2\2\2\u0268\u0e86\3\2\2\2\u026a\u0e8d\3\2"+
		"\2\2\u026c\u0e90\3\2\2\2\u026e\u0e9b\3\2\2\2\u0270\u0e9f\3\2\2\2\u0272"+
		"\u0eab\3\2\2\2\u0274\u0eb0\3\2\2\2\u0276\u0eb6\3\2\2\2\u0278\u0ec2\3\2"+
		"\2\2\u027a\u0ed4\3\2\2\2\u027c\u0edb\3\2\2\2\u027e\u0ee3\3\2\2\2\u0280"+
		"\u0ee6\3\2\2\2\u0282\u0eed\3\2\2\2\u0284\u0f0d\3\2\2\2\u0286\u0f1b\3\2"+
		"\2\2\u0288\u0f1d\3\2\2\2\u028a\u0f26\3\2\2\2\u028c\u0f3f\3\2\2\2\u028e"+
		"\u0292\5\u0124\u0093\2\u028f\u0292\5\4\3\2\u0290\u0292\5\6\4\2\u0291\u028e"+
		"\3\2\2\2\u0291\u028f\3\2\2\2\u0291\u0290\3\2\2\2\u0292\3\3\2\2\2\u0293"+
		"\u02a6\5\n\6\2\u0294\u02a6\5\b\5\2\u0295\u02a6\5\u00a6T\2\u0296\u02a6"+
		"\5\u00a4S\2\u0297\u02a6\5\u00a8U\2\u0298\u02a6\5\u00acW\2\u0299\u02a6"+
		"\5\u00aaV\2\u029a\u02a6\5\u0216\u010c\2\u029b\u02a6\5\u0214\u010b\2\u029c"+
		"\u02a6\5\u0218\u010d\2\u029d\u02a6\5\u0248\u0125\2\u029e\u02a6\5\u0240"+
		"\u0121\2\u029f\u02a6\5\u0246\u0124\2\u02a0\u02a6\5\u023e\u0120\2\u02a1"+
		"\u02a6\5\u0244\u0123\2\u02a2\u02a6\5\u023c\u011f\2\u02a3\u02a6\5\u024a"+
		"\u0126\2\u02a4\u02a6\5\u0242\u0122\2\u02a5\u0293\3\2\2\2\u02a5\u0294\3"+
		"\2\2\2\u02a5\u0295\3\2\2\2\u02a5\u0296\3\2\2\2\u02a5\u0297\3\2\2\2\u02a5"+
		"\u0298\3\2\2\2\u02a5\u0299\3\2\2\2\u02a5\u029a\3\2\2\2\u02a5\u029b\3\2"+
		"\2\2\u02a5\u029c\3\2\2\2\u02a5\u029d\3\2\2\2\u02a5\u029e\3\2\2\2\u02a5"+
		"\u029f\3\2\2\2\u02a5\u02a0\3\2\2\2\u02a5\u02a1\3\2\2\2\u02a5\u02a2\3\2"+
		"\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a4\3\2\2\2\u02a6\5\3\2\2\2\u02a7\u02ab"+
		"\5\u0276\u013c\2\u02a8\u02ab\5\u0280\u0141\2\u02a9\u02ab\5\u0282\u0142"+
		"\2\u02aa\u02a7\3\2\2\2\u02aa\u02a8\3\2\2\2\u02aa\u02a9\3\2\2\2\u02ab\7"+
		"\3\2\2\2\u02ac\u02ad\7i\2\2\u02ad\u02ae\7\u010c\2\2\u02ae\u02af\5(\25"+
		"\2\u02af\u02b0\5B\"\2\u02b0\t\3\2\2\2\u02b1\u02b2\7F\2\2\u02b2\u02b3\7"+
		"\u010c\2\2\u02b3\u02b6\5(\25\2\u02b4\u02b5\7\35\2\2\u02b5\u02b7\5\20\t"+
		"\2\u02b6\u02b4\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\13\3\2\2\2\u02b8\u02b9"+
		"\7\u0159\2\2\u02b9\r\3\2\2\2\u02ba\u02bb\7\u0159\2\2\u02bb\17\3\2\2\2"+
		"\u02bc\u02bd\7\u0159\2\2\u02bd\21\3\2\2\2\u02be\u02bf\7\u0159\2\2\u02bf"+
		"\23\3\2\2\2\u02c0\u02c1\7\u0159\2\2\u02c1\25\3\2\2\2\u02c2\u02c3\7\u0159"+
		"\2\2\u02c3\27\3\2\2\2\u02c4\u02c5\7\u0159\2\2\u02c5\31\3\2\2\2\u02c6\u02c7"+
		"\7\u0159\2\2\u02c7\33\3\2\2\2\u02c8\u02c9\7\u0159\2\2\u02c9\35\3\2\2\2"+
		"\u02ca\u02cb\7\u0159\2\2\u02cb\37\3\2\2\2\u02cc\u02cd\7\u0159\2\2\u02cd"+
		"!\3\2\2\2\u02ce\u02cf\7\u0159\2\2\u02cf#\3\2\2\2\u02d0\u02d1\7\u0159\2"+
		"\2\u02d1%\3\2\2\2\u02d2\u02d3\7\u0236\2\2\u02d3\u02d4\7\u0159\2\2\u02d4"+
		"\'\3\2\2\2\u02d5\u02d6\7\u0159\2\2\u02d6\u02d7\7\u0234\2\2\u02d7\u02da"+
		"\7\u0159\2\2\u02d8\u02da\7\u0159\2\2\u02d9\u02d5\3\2\2\2\u02d9\u02d8\3"+
		"\2\2\2\u02da)\3\2\2\2\u02db\u02dc\7\u0159\2\2\u02dc\u02dd\7\u0234\2\2"+
		"\u02dd\u02de\7\u0159\2\2\u02de\u02df\7\u0234\2\2\u02df\u02e5\7\u0159\2"+
		"\2\u02e0\u02e1\7\u0159\2\2\u02e1\u02e2\7\u0234\2\2\u02e2\u02e5\7\u0159"+
		"\2\2\u02e3\u02e5\7\u0159\2\2\u02e4\u02db\3\2\2\2\u02e4\u02e0\3\2\2\2\u02e4"+
		"\u02e3\3\2\2\2\u02e5+\3\2\2\2\u02e6\u02eb\7\u0159\2\2\u02e7\u02e8\7\u0234"+
		"\2\2\u02e8\u02ea\7\u0159\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02ed\3\2\2\2\u02eb"+
		"\u02e9\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec-\3\2\2\2\u02ed\u02eb\3\2\2\2"+
		"\u02ee\u02ef\5*\26\2\u02ef/\3\2\2\2\u02f0\u02f1\5*\26\2\u02f1\61\3\2\2"+
		"\2\u02f2\u02f3\5*\26\2\u02f3\63\3\2\2\2\u02f4\u02f5\5*\26\2\u02f5\65\3"+
		"\2\2\2\u02f6\u02f7\5*\26\2\u02f7\67\3\2\2\2\u02f8\u02f9\5*\26\2\u02f9"+
		"9\3\2\2\2\u02fa\u02fb\5*\26\2\u02fb;\3\2\2\2\u02fc\u02fd\5,\27\2\u02fd"+
		"=\3\2\2\2\u02fe\u02ff\5,\27\2\u02ff?\3\2\2\2\u0300\u0301\5,\27\2\u0301"+
		"A\3\2\2\2\u0302\u0303\t\2\2\2\u0303C\3\2\2\2\u0304\u0305\7\u00d4\2\2\u0305"+
		"\u0306\7>\2\2\u0306\u0307\t\3\2\2\u0307\u0308\7\u010a\2\2\u0308E\3\2\2"+
		"\2\u0309\u030a\t\4\2\2\u030a\u030b\7\u0186\2\2\u030bG\3\2\2\2\u030c\u030d"+
		"\t\4\2\2\u030d\u030e\7\u0092\2\2\u030eI\3\2\2\2\u030f\u0310\t\5\2\2\u0310"+
		"K\3\2\2\2\u0311\u0312\7\u0129\2\2\u0312\u0317\7\u0089\2\2\u0313\u0314"+
		"\7\u0144\2\2\u0314\u0317\7\u0089\2\2\u0315\u0317\7b\2\2\u0316\u0311\3"+
		"\2\2\2\u0316\u0313\3\2\2\2\u0316\u0315\3\2\2\2\u0317M\3\2\2\2\u0318\u0319"+
		"\7\u00f3\2\2\u0319\u031b\7\25\2\2\u031a\u031c\7\u00cc\2\2\u031b\u031a"+
		"\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u031e\7\67\2\2"+
		"\u031eO\3\2\2\2\u031f\u0328\7,\2\2\u0320\u0321\7\u0114\2\2\u0321\u0328"+
		"\7\u00cd\2\2\u0322\u0323\7\u0114\2\2\u0323\u0328\7\\\2\2\u0324\u0328\7"+
		"\u0100\2\2\u0325\u0326\7\u00c8\2\2\u0326\u0328\7\f\2\2\u0327\u031f\3\2"+
		"\2\2\u0327\u0320\3\2\2\2\u0327\u0322\3\2\2\2\u0327\u0324\3\2\2\2\u0327"+
		"\u0325\3\2\2\2\u0328Q\3\2\2\2\u0329\u032a\t\6\2\2\u032a\u032b\7\u012d"+
		"\2\2\u032bS\3\2\2\2\u032c\u032e\7\u00cc\2\2\u032d\u032c\3\2\2\2\u032d"+
		"\u032e\3\2\2\2\u032e\u032f\3\2\2\2\u032f\u0330\7\u009e\2\2\u0330U\3\2"+
		"\2\2\u0331\u0333\7\u00cc\2\2\u0332\u0331\3\2\2\2\u0332\u0333\3\2\2\2\u0333"+
		"\u0334\3\2\2\2\u0334\u0335\7}\2\2\u0335W\3\2\2\2\u0336\u0337\t\7\2\2\u0337"+
		"Y\3\2\2\2\u0338\u0339\t\b\2\2\u0339[\3\2\2\2\u033a\u033b\t\t\2\2\u033b"+
		"]\3\2\2\2\u033c\u033d\7\u0103\2\2\u033d\u033e\7\u00cd\2\2\u033e\u033f"+
		"\7\u00d4\2\2\u033f\u0340\7\u00cd\2\2\u0340\u0346\7\u009a\2\2\u0341\u0342"+
		"\7*\2\2\u0342\u0343\7\u00d4\2\2\u0343\u0344\7\u00cd\2\2\u0344\u0346\7"+
		"\u009a\2\2\u0345\u033c\3\2\2\2\u0345\u0341\3\2\2\2\u0346_\3\2\2\2\u0347"+
		"\u0349\7\u00cc\2\2\u0348\u0347\3\2\2\2\u0348\u0349\3\2\2\2\u0349\u034a"+
		"\3\2\2\2\u034a\u034b\7e\2\2\u034ba\3\2\2\2\u034c\u034d\7\u00c8\2\2\u034d"+
		"\u0357\7\u011b\2\2\u034e\u034f\7\u017f\2\2\u034f\u0357\7\u011b\2\2\u0350"+
		"\u0351\7\u00ef\2\2\u0351\u0352\7\u011b\2\2\u0352\u0357\7U\2\2\u0353\u0354"+
		"\7\u00be\2\2\u0354\u0355\7\u011b\2\2\u0355\u0357\7U\2\2\u0356\u034c\3"+
		"\2\2\2\u0356\u034e\3\2\2\2\u0356\u0350\3\2\2\2\u0356\u0353\3\2\2\2\u0357"+
		"c\3\2\2\2\u0358\u0359\t\n\2\2\u0359e\3\2\2\2\u035a\u035b\t\13\2\2\u035b"+
		"g\3\2\2\2\u035c\u035d\t\f\2\2\u035di\3\2\2\2\u035e\u035f\t\r\2\2\u035f"+
		"k\3\2\2\2\u0360\u0361\t\16\2\2\u0361m\3\2\2\2\u0362\u0368\7\u0098\2\2"+
		"\u0363\u0365\t\17\2\2\u0364\u0366\7\u00dd\2\2\u0365\u0364\3\2\2\2\u0365"+
		"\u0366\3\2\2\2\u0366\u0368\3\2\2\2\u0367\u0362\3\2\2\2\u0367\u0363\3\2"+
		"\2\2\u0368o\3\2\2\2\u0369\u036a\t\20\2\2\u036aq\3\2\2\2\u036b\u036c\7"+
		"\u01b2\2\2\u036c\u0370\7\u0194\2\2\u036d\u036e\7\u01b2\2\2\u036e\u0370"+
		"\7\u01a1\2\2\u036f\u036b\3\2\2\2\u036f\u036d\3\2\2\2\u0370s\3\2\2\2\u0371"+
		"\u0372\t\21\2\2\u0372u\3\2\2\2\u0373\u0374\t\22\2\2\u0374w\3\2\2\2\u0375"+
		"\u0376\t\23\2\2\u0376y\3\2\2\2\u0377\u0378\t\24\2\2\u0378{\3\2\2\2\u0379"+
		"\u037a\t\25\2\2\u037a}\3\2\2\2\u037b\u037c\7\u0193\2\2\u037c\u037d\7J"+
		"\2\2\u037d\u0386\7\u0108\2\2\u037e\u037f\7\u0193\2\2\u037f\u0386\7\u008d"+
		"\2\2\u0380\u0381\7\u0193\2\2\u0381\u0386\7\u01ec\2\2\u0382\u0383\7\u0193"+
		"\2\2\u0383\u0384\7\u00c8\2\2\u0384\u0386\7\u01b6\2\2\u0385\u037b\3\2\2"+
		"\2\u0385\u037e\3\2\2\2\u0385\u0380\3\2\2\2\u0385\u0382\3\2\2\2\u0386\177"+
		"\3\2\2\2\u0387\u0388\t\26\2\2\u0388\u0081\3\2\2\2\u0389\u038a\t\27\2\2"+
		"\u038a\u0083\3\2\2\2\u038b\u038c\t\30\2\2\u038c\u0085\3\2\2\2\u038d\u038e"+
		"\t\31\2\2\u038e\u0087\3\2\2\2\u038f\u0390\t\32\2\2\u0390\u0089\3\2\2\2"+
		"\u0391\u0392\t\33\2\2\u0392\u0393\7\u012f\2\2\u0393\u0394\7\u0158\2\2"+
		"\u0394\u008b\3\2\2\2\u0395\u0396\7\u00c1\2\2\u0396\u0397\t\34\2\2\u0397"+
		"\u008d\3\2\2\2\u0398\u0399\t\34\2\2\u0399\u008f\3\2\2\2\u039a\u039b\t"+
		"\35\2\2\u039b\u0091\3\2\2\2\u039c\u039d\t\36\2\2\u039d\u0093\3\2\2\2\u039e"+
		"\u039f\t\27\2\2\u039f\u0095\3\2\2\2\u03a0\u03a2\7\u0153\2\2\u03a1\u03a3"+
		"\7\u00c8\2\2\u03a2\u03a1\3\2\2\2\u03a2\u03a3\3\2\2\2\u03a3\u03a4\3\2\2"+
		"\2\u03a4\u03a5\7U\2\2\u03a5\u0097\3\2\2\2\u03a6\u03a7\7\u0097\2\2\u03a7"+
		"\u03ab\7^\2\2\u03a8\u03a9\7\u0097\2\2\u03a9\u03ab\7\u0093\2\2\u03aa\u03a6"+
		"\3\2\2\2\u03aa\u03a8\3\2\2\2\u03ab\u0099\3\2\2\2\u03ac\u03ae\7\u00cc\2"+
		"\2\u03ad\u03ac\3\2\2\2\u03ad\u03ae\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b0"+
		"\7]\2\2\u03b0\u009b\3\2\2\2\u03b1\u03b2\t\37\2\2\u03b2\u009d\3\2\2\2\u03b3"+
		"\u03b4\t \2\2\u03b4\u009f\3\2\2\2\u03b5\u03b6\7\u00e1\2\2\u03b6\u03b7"+
		"\7\u0144\2\2\u03b7\u03bc\7\u0146\2\2\u03b8\u03b9\7\u00e1\2\2\u03b9\u03ba"+
		"\7\u0129\2\2\u03ba\u03bc\7\u0146\2\2\u03bb\u03b5\3\2\2\2\u03bb\u03b8\3"+
		"\2\2\2\u03bc\u00a1\3\2\2\2\u03bd\u03c6\7\u00cd\2\2\u03be\u03bf\7\26\2"+
		"\2\u03bf\u03c0\7\u023c\2\2\u03c0\u03c6\7\u023d\2\2\u03c1\u03c2\7\u00c1"+
		"\2\2\u03c2\u03c3\7\u023c\2\2\u03c3\u03c6\7\u023d\2\2\u03c4\u03c6\7\\\2"+
		"\2\u03c5\u03bd\3\2\2\2\u03c5\u03be\3\2\2\2\u03c5\u03c1\3\2\2\2\u03c5\u03c4"+
		"\3\2\2\2\u03c6\u00a3\3\2\2\2\u03c7\u03c8\7i\2\2\u03c8\u03c9\7\u012b\2"+
		"\2\u03c9\u03ca\5.\30\2\u03ca\u03cb\5B\"\2\u03cb\u00a5\3\2\2\2\u03cc\u03ce"+
		"\7F\2\2\u03cd\u03cf\5R*\2\u03ce\u03cd\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf"+
		"\u03d0\3\2\2\2\u03d0\u03d1\7\u012b\2\2\u03d1\u03d2\5.\30\2\u03d2\u03d4"+
		"\5\u00b2Z\2\u03d3\u03d5\5D#\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5\3\2\2\2"+
		"\u03d5\u00a7\3\2\2\2\u03d6\u03d7\7\21\2\2\u03d7\u03d8\7\u012b\2\2\u03d8"+
		"\u03d9\5.\30\2\u03d9\u03da\5\u00aeX\2\u03da\u00a9\3\2\2\2\u03db\u03dc"+
		"\7i\2\2\u03dc\u03dd\7\u014d\2\2\u03dd\u03de\5.\30\2\u03de\u03df\5B\"\2"+
		"\u03df\u00ab\3\2\2\2\u03e0\u03e2\7F\2\2\u03e1\u03e3\7\u00f1\2\2\u03e2"+
		"\u03e1\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e5\7\u014d"+
		"\2\2\u03e5\u03e6\5.\30\2\u03e6\u03e7\5\u00ba^\2\u03e7\u03e8\7\27\2\2\u03e8"+
		"\u03ef\5\u0140\u00a1\2\u03e9\u03eb\7\u0153\2\2\u03ea\u03ec\5\u009cO\2"+
		"\u03eb\u03ea\3\2\2\2\u03eb\u03ec\3\2\2\2\u03ec\u03ed\3\2\2\2\u03ed\u03ee"+
		"\7\66\2\2\u03ee\u03f0\7\u00d7\2\2\u03ef\u03e9\3\2\2\2\u03ef\u03f0\3\2"+
		"\2\2\u03f0\u00ad\3\2\2\2\u03f1\u03f3\7\r\2\2\u03f2\u03f4\7=\2\2\u03f3"+
		"\u03f2\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5\u040c\5\u00c2"+
		"b\2\u03f6\u03f8\7i\2\2\u03f7\u03f9\7=\2\2\u03f8\u03f7\3\2\2\2\u03f8\u03f9"+
		"\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fb\5\24\13\2\u03fb\u03fc\5B\"\2"+
		"\u03fc\u040c\3\2\2\2\u03fd\u03ff\7\21\2\2\u03fe\u0400\7=\2\2\u03ff\u03fe"+
		"\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0401\3\2\2\2\u0401\u0402\5\24\13\2"+
		"\u0402\u0403\5\u00b0Y\2\u0403\u040c\3\2\2\2\u0404\u0405\7\r\2\2\u0405"+
		"\u040c\5\u00c4c\2\u0406\u0407\7i\2\2\u0407\u0408\7@\2\2\u0408\u0409\5"+
		"\60\31\2\u0409\u040a\5B\"\2\u040a\u040c\3\2\2\2\u040b\u03f1\3\2\2\2\u040b"+
		"\u03f6\3\2\2\2\u040b\u03fd\3\2\2\2\u040b\u0404\3\2\2\2\u040b\u0406\3\2"+
		"\2\2\u040c\u00af\3\2\2\2\u040d\u040e\7\u0114\2\2\u040e\u040f\7\\\2\2\u040f"+
		"\u0419\5\u00ccg\2\u0410\u0411\7i\2\2\u0411\u0419\7\\\2\2\u0412\u0413\7"+
		"\r\2\2\u0413\u0414\7\u010d\2\2\u0414\u0419\5.\30\2\u0415\u0416\7i\2\2"+
		"\u0416\u0417\7\u010d\2\2\u0417\u0419\5B\"\2\u0418\u040d\3\2\2\2\u0418"+
		"\u0410\3\2\2\2\u0418\u0412\3\2\2\2\u0418\u0415\3\2\2\2\u0419\u00b1\3\2"+
		"\2\2\u041a\u0436\5\u00b6\\\2\u041b\u041c\7\u00d2\2\2\u041c\u041e\5\62"+
		"\32\2\u041d\u041f\5\u00b4[\2\u041e\u041d\3\2\2\2\u041e\u041f\3\2\2\2\u041f"+
		"\u0420\3\2\2\2\u0420\u0421\5\u00b6\\\2\u0421\u0436\3\2\2\2\u0422\u0423"+
		"\7\u022e\2\2\u0423\u0428\5\24\13\2\u0424\u0425\7\u0232\2\2\u0425\u0427"+
		"\5\24\13\2\u0426\u0424\3\2\2\2\u0427\u042a\3\2\2\2\u0428\u0426\3\2\2\2"+
		"\u0428\u0429\3\2\2\2\u0429\u042b\3\2\2\2\u042a\u0428\3\2\2\2\u042b\u042c"+
		"\7\u022f\2\2\u042c\u042e\3\2\2\2\u042d\u0422\3\2\2\2\u042d\u042e\3\2\2"+
		"\2\u042e\u042f\3\2\2\2\u042f\u0430\7\27\2\2\u0430\u0431\7\u022e\2\2\u0431"+
		"\u0432\5\u0140\u00a1\2\u0432\u0433\7\u022f\2\2\u0433\u0434\5\u0096L\2"+
		"\u0434\u0436\3\2\2\2\u0435\u041a\3\2\2\2\u0435\u041b\3\2\2\2\u0435\u042d"+
		"\3\2\2\2\u0436\u00b3\3\2\2\2\u0437\u0438\7\u013d\2\2\u0438\u0439\5.\30"+
		"\2\u0439\u00b5\3\2\2\2\u043a\u043b\7\u022e\2\2\u043b\u0440\5\u00b8]\2"+
		"\u043c\u043d\7\u0232\2\2\u043d\u043f\5\u00b8]\2\u043e\u043c\3\2\2\2\u043f"+
		"\u0442\3\2\2\2\u0440\u043e\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u0443\3\2"+
		"\2\2\u0442\u0440\3\2\2\2\u0443\u0444\7\u022f\2\2\u0444\u00b7\3\2\2\2\u0445"+
		"\u044b\5\u00c2b\2\u0446\u044b\5\u00c4c\2\u0447\u044b\5\u00c6d\2\u0448"+
		"\u044b\5\u00c8e\2\u0449\u044b\5\u00caf\2\u044a\u0445\3\2\2\2\u044a\u0446"+
		"\3\2\2\2\u044a\u0447\3\2\2\2\u044a\u0448\3\2\2\2\u044a\u0449\3\2\2\2\u044b"+
		"\u00b9\3\2\2\2\u044c\u044d\7\u022e\2\2\u044d\u0452\5\24\13\2\u044e\u044f"+
		"\7\u0232\2\2\u044f\u0451\5\24\13\2\u0450\u044e\3\2\2\2\u0451\u0454\3\2"+
		"\2\2\u0452\u0450\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0455\3\2\2\2\u0454"+
		"\u0452\3\2\2\2\u0455\u0456\7\u022f\2\2\u0456\u045f\3\2\2\2\u0457\u0458"+
		"\7\u00d2\2\2\u0458\u045a\5\62\32\2\u0459\u045b\5\u00bc_\2\u045a\u0459"+
		"\3\2\2\2\u045a\u045b\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045d\5\u00be`"+
		"\2\u045d\u045f\3\2\2\2\u045e\u044c\3\2\2\2\u045e\u0457\3\2\2\2\u045f\u00bb"+
		"\3\2\2\2\u0460\u0461\7\u013d\2\2\u0461\u0462\5.\30\2\u0462\u00bd\3\2\2"+
		"\2\u0463\u0464\7\u022e\2\2\u0464\u0469\5\u00c0a\2\u0465\u0466\7\u0232"+
		"\2\2\u0466\u0468\5\u00c0a\2\u0467\u0465\3\2\2\2\u0468\u046b\3\2\2\2\u0469"+
		"\u0467\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u046c\3\2\2\2\u046b\u0469\3\2"+
		"\2\2\u046c\u046d\7\u022f\2\2\u046d\u00bf\3\2\2\2\u046e\u0471\5\u00c8e"+
		"\2\u046f\u0471\5\u00caf\2\u0470\u046e\3\2\2\2\u0470\u046f\3\2\2\2\u0471"+
		"\u00c1\3\2\2\2\u0472\u0473\5\24\13\2\u0473\u0475\5\u00e0q\2\u0474\u0476"+
		"\5N(\2\u0475\u0474\3\2\2\2\u0475\u0476\3\2\2\2\u0476\u0478\3\2\2\2\u0477"+
		"\u0479\5\u00dep\2\u0478\u0477\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047c"+
		"\3\2\2\2\u047a\u047b\7\\\2\2\u047b\u047d\5\u00ccg\2\u047c\u047a\3\2\2"+
		"\2\u047c\u047d\3\2\2\2\u047d\u047f\3\2\2\2\u047e\u0480\5\u00ceh\2\u047f"+
		"\u047e\3\2\2\2\u047f\u0480\3\2\2\2\u0480\u0482\3\2\2\2\u0481\u0483\5\u00d0"+
		"i\2\u0482\u0481\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u00c3\3\2\2\2\u0484"+
		"\u0485\7@\2\2\u0485\u0487\5\60\31\2\u0486\u0484\3\2\2\2\u0486\u0487\3"+
		"\2\2\2\u0487\u0488\3\2\2\2\u0488\u048a\5\u00d2j\2\u0489\u048b\5\u00d4"+
		"k\2\u048a\u0489\3\2\2\2\u048a\u048b\3\2\2\2\u048b\u00c5\3\2\2\2\u048c"+
		"\u048d\7\u00af\2\2\u048d\u0490\5.\30\2\u048e\u0491\5H%\2\u048f\u0491\5"+
		"F$\2\u0490\u048e\3\2\2\2\u0490\u048f\3\2\2\2\u0490\u0491\3\2\2\2\u0491"+
		"\u00c7\3\2\2\2\u0492\u0493\7\u00f2\2\2\u0493\u0494\7\u00a5\2\2\u0494\u0495"+
		"\5\24\13\2\u0495\u0496\5L\'\2\u0496\u00c9\3\2\2\2\u0497\u0498\5\24\13"+
		"\2\u0498\u0499\7\u0153\2\2\u0499\u049e\7\u00d8\2\2\u049a\u049f\5\u00e4"+
		"s\2\u049b\u049c\7\\\2\2\u049c\u049f\5\u00ccg\2\u049d\u049f\5\u00d0i\2"+
		"\u049e\u049a\3\2\2\2\u049e\u049b\3\2\2\2\u049e\u049d\3\2\2\2\u049f\u00cb"+
		"\3\2\2\2\u04a0\u04cc\5\u0208\u0105\2\u04a1\u04cc\7K\2\2\u04a2\u04a7\7"+
		"O\2\2\u04a3\u04a4\7\u022e\2\2\u04a4\u04a5\5\u011c\u008f\2\u04a5\u04a6"+
		"\7\u022f\2\2\u04a6\u04a8\3\2\2\2\u04a7\u04a3\3\2\2\2\u04a7\u04a8\3\2\2"+
		"\2\u04a8\u04cc\3\2\2\2\u04a9\u04ae\7\u00b2\2\2\u04aa\u04ab\7\u022e\2\2"+
		"\u04ab\u04ac\5\u011c\u008f\2\u04ac\u04ad\7\u022f\2\2\u04ad\u04af\3\2\2"+
		"\2\u04ae\u04aa\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04cc\3\2\2\2\u04b0\u04b5"+
		"\7P\2\2\u04b1\u04b2\7\u022e\2\2\u04b2\u04b3\5\u011c\u008f\2\u04b3\u04b4"+
		"\7\u022f\2\2\u04b4\u04b6\3\2\2\2\u04b5\u04b1\3\2\2\2\u04b5\u04b6\3\2\2"+
		"\2\u04b6\u04cc\3\2\2\2\u04b7\u04bc\7\u00b3\2\2\u04b8\u04b9\7\u022e\2\2"+
		"\u04b9\u04ba\5\u011c\u008f\2\u04ba\u04bb\7\u022f\2\2\u04bb\u04bd\3\2\2"+
		"\2\u04bc\u04b8\3\2\2\2\u04bc\u04bd\3\2\2\2\u04bd\u04cc\3\2\2\2\u04be\u04cc"+
		"\7\u0144\2\2\u04bf\u04cc\7R\2\2\u04c0\u04cc\7N\2\2\u04c1\u04cc\7\u0113"+
		"\2\2\u04c2\u04cc\7\u012a\2\2\u04c3\u04cc\7M\2\2\u04c4\u04cc\7\u00cd\2"+
		"\2\u04c5\u04c6\7\26\2\2\u04c6\u04c7\7\u023c\2\2\u04c7\u04cc\7\u023d\2"+
		"\2\u04c8\u04c9\7\u00c1\2\2\u04c9\u04ca\7\u023c\2\2\u04ca\u04cc\7\u023d"+
		"\2\2\u04cb\u04a0\3\2\2\2\u04cb\u04a1\3\2\2\2\u04cb\u04a2\3\2\2\2\u04cb"+
		"\u04a9\3\2\2\2\u04cb\u04b0\3\2\2\2\u04cb\u04b7\3\2\2\2\u04cb\u04be\3\2"+
		"\2\2\u04cb\u04bf\3\2\2\2\u04cb\u04c0\3\2\2\2\u04cb\u04c1\3\2\2\2\u04cb"+
		"\u04c2\3\2\2\2\u04cb\u04c3\3\2\2\2\u04cb\u04c4\3\2\2\2\u04cb\u04c5\3\2"+
		"\2\2\u04cb\u04c8\3\2\2\2\u04cc\u00cd\3\2\2\2\u04cd\u04ce\7\u0089\2\2\u04ce"+
		"\u04cf\7\22\2\2\u04cf\u04d0\7\27\2\2\u04d0\u04d1\7\u022e\2\2\u04d1\u04d2"+
		"\5\u0152\u00aa\2\u04d2\u04d3\7\u022f\2\2\u04d3\u00cf\3\2\2\2\u04d4\u04d5"+
		"\7@\2\2\u04d5\u04d7\5\60\31\2\u04d6\u04d4\3\2\2\2\u04d6\u04d7\3\2\2\2"+
		"\u04d7\u04d8\3\2\2\2\u04d8\u04da\5\u00d6l\2\u04d9\u04db\5\u00d4k\2\u04da"+
		"\u04d9\3\2\2\2\u04da\u04db\3\2\2\2\u04db\u00d1\3\2\2\2\u04dc\u04dd\7\u013f"+
		"\2\2\u04dd\u04de\7\u022e\2\2\u04de\u04e3\5\24\13\2\u04df\u04e0\7\u0232"+
		"\2\2\u04e0\u04e2\5\24\13\2\u04e1\u04df\3\2\2\2\u04e2\u04e5\3\2\2\2\u04e3"+
		"\u04e1\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e6\3\2\2\2\u04e5\u04e3\3\2"+
		"\2\2\u04e6\u04e7\7\u022f\2\2\u04e7\u0509\3\2\2\2\u04e8\u04e9\7\u00eb\2"+
		"\2\u04e9\u04ea\7\u00a9\2\2\u04ea\u04eb\7\u022e\2\2\u04eb\u04f0\5\24\13"+
		"\2\u04ec\u04ed\7\u0232\2\2\u04ed\u04ef\5\24\13\2\u04ee\u04ec\3\2\2\2\u04ef"+
		"\u04f2\3\2\2\2\u04f0\u04ee\3\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04f3\3\2"+
		"\2\2\u04f2\u04f0\3\2\2\2\u04f3\u04f4\7\u022f\2\2\u04f4\u0509\3\2\2\2\u04f5"+
		"\u04f6\7\u0082\2\2\u04f6\u04f7\7\u00a9\2\2\u04f7\u04f8\7\u022e\2\2\u04f8"+
		"\u04fd\5\24\13\2\u04f9\u04fa\7\u0232\2\2\u04fa\u04fc\5\24\13\2\u04fb\u04f9"+
		"\3\2\2\2\u04fc\u04ff\3\2\2\2\u04fd\u04fb\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe"+
		"\u0500\3\2\2\2\u04ff\u04fd\3\2\2\2\u0500\u0501\7\u022f\2\2\u0501\u0502"+
		"\5\u00d8m\2\u0502\u0509\3\2\2\2\u0503\u0504\7\66\2\2\u0504\u0505\7\u022e"+
		"\2\2\u0505\u0506\5\u017e\u00c0\2\u0506\u0507\7\u022f\2\2\u0507\u0509\3"+
		"\2\2\2\u0508\u04dc\3\2\2\2\u0508\u04e8\3\2\2\2\u0508\u04f5\3\2\2\2\u0508"+
		"\u0503\3\2\2\2\u0509\u00d3\3\2\2\2\u050a\u050c\5\u0098M\2\u050b\u050d"+
		"\5\u009aN\2\u050c\u050b\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u0513\3\2\2"+
		"\2\u050e\u0510\5\u009aN\2\u050f\u0511\5\u0098M\2\u0510\u050f\3\2\2\2\u0510"+
		"\u0511\3\2\2\2\u0511\u0513\3\2\2\2\u0512\u050a\3\2\2\2\u0512\u050e\3\2"+
		"\2\2\u0513\u00d5\3\2\2\2\u0514\u0515\7\u00cc\2\2\u0515\u052e\7\u00cd\2"+
		"\2\u0516\u0518\7\u013f\2\2\u0517\u0519\7\u0146\2\2\u0518\u0517\3\2\2\2"+
		"\u0518\u0519\3\2\2\2\u0519\u052e\3\2\2\2\u051a\u051b\7\u00eb\2\2\u051b"+
		"\u052e\7\u00a9\2\2\u051c\u051d\7\u00f3\2\2\u051d\u051e\5.\30\2\u051e\u051f"+
		"\7\u022e\2\2\u051f\u0520\5\24\13\2\u0520\u0523\7\u022f\2\2\u0521\u0522"+
		"\7\u00b6\2\2\u0522\u0524\5J&\2\u0523\u0521\3\2\2\2\u0523\u0524\3\2\2\2"+
		"\u0524\u0526\3\2\2\2\u0525\u0527\5\u00dan\2\u0526\u0525\3\2\2\2\u0526"+
		"\u0527\3\2\2\2\u0527\u052e\3\2\2\2\u0528\u0529\7\66\2\2\u0529\u052a\7"+
		"\u022e\2\2\u052a\u052b\5\u017e\u00c0\2\u052b\u052c\7\u022f\2\2\u052c\u052e"+
		"\3\2\2\2\u052d\u0514\3\2\2\2\u052d\u0516\3\2\2\2\u052d\u051a\3\2\2\2\u052d"+
		"\u051c\3\2\2\2\u052d\u0528\3\2\2\2\u052e\u00d7\3\2\2\2\u052f\u0530\7\u00f3"+
		"\2\2\u0530\u053c\5.\30\2\u0531\u0532\7\u022e\2\2\u0532\u0537\5\24\13\2"+
		"\u0533\u0534\7\u0232\2\2\u0534\u0536\5\24\13\2\u0535\u0533\3\2\2\2\u0536"+
		"\u0539\3\2\2\2\u0537\u0535\3\2\2\2\u0537\u0538\3\2\2\2\u0538\u053a\3\2"+
		"\2\2\u0539\u0537\3\2\2\2\u053a\u053b\7\u022f\2\2\u053b\u053d\3\2\2\2\u053c"+
		"\u0531\3\2\2\2\u053c\u053d\3\2\2\2\u053d\u0540\3\2\2\2\u053e\u053f\7\u00b6"+
		"\2\2\u053f\u0541\5J&\2\u0540\u053e\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0543"+
		"\3\2\2\2\u0542\u0544\5\u00dan\2\u0543\u0542\3\2\2\2\u0543\u0544\3\2\2"+
		"\2\u0544\u00d9\3\2\2\2\u0545\u0547\5\u00dco\2\u0546\u0548\5\u00dep\2\u0547"+
		"\u0546\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u054e\3\2\2\2\u0549\u054b\5\u00de"+
		"p\2\u054a\u054c\5\u00dco\2\u054b\u054a\3\2\2\2\u054b\u054c\3\2\2\2\u054c"+
		"\u054e\3\2\2\2\u054d\u0545\3\2\2\2\u054d\u0549\3\2\2\2\u054e\u00db\3\2"+
		"\2\2\u054f\u0550\7\u00d4\2\2\u0550\u0551\7\u0142\2\2\u0551\u0552\5P)\2"+
		"\u0552\u00dd\3\2\2\2\u0553\u0554\7\u00d4\2\2\u0554\u0555\7_\2\2\u0555"+
		"\u0556\5P)\2\u0556\u00df\3\2\2\2\u0557\u0558\bq\1\2\u0558\u056e\5\u00e8"+
		"u\2\u0559\u056e\5\62\32\2\u055a\u055b\7\u0108\2\2\u055b\u055c\7\u022e"+
		"\2\2\u055c\u0561\5\u00e6t\2\u055d\u055e\7\u0232\2\2\u055e\u0560\5\u00e6"+
		"t\2\u055f\u055d\3\2\2\2\u0560\u0563\3\2\2\2\u0561\u055f\3\2\2\2\u0561"+
		"\u0562\3\2\2\2\u0562\u0564\3\2\2\2\u0563\u0561\3\2\2\2\u0564\u0565\7\u022f"+
		"\2\2\u0565\u056e\3\2\2\2\u0566\u0567\7\u00f2\2\2\u0567\u0568\7\u022e\2"+
		"\2\u0568\u0569\5\62\32\2\u0569\u056b\7\u022f\2\2\u056a\u056c\5\u00e4s"+
		"\2\u056b\u056a\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u056e\3\2\2\2\u056d\u0557"+
		"\3\2\2\2\u056d\u0559\3\2\2\2\u056d\u055a\3\2\2\2\u056d\u0566\3\2\2\2\u056e"+
		"\u057b\3\2\2\2\u056f\u0570\f\4\2\2\u0570\u0575\7\26\2\2\u0571\u0572\7"+
		"\u023c\2\2\u0572\u0573\5\u0122\u0092\2\u0573\u0574\7\u023d\2\2\u0574\u0576"+
		"\3\2\2\2\u0575\u0571\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u057a\3\2\2\2\u0577"+
		"\u0578\f\3\2\2\u0578\u057a\7\u00c1\2\2\u0579\u056f\3\2\2\2\u0579\u0577"+
		"\3\2\2\2\u057a\u057d\3\2\2\2\u057b\u0579\3\2\2\2\u057b\u057c\3\2\2\2\u057c"+
		"\u00e1\3\2\2\2\u057d\u057b\3\2\2\2\u057e\u057f\7\u00f2\2\2\u057f\u0580"+
		"\7\u022e\2\2\u0580\u0581\5\62\32\2\u0581\u0583\7\u022f\2\2\u0582\u0584"+
		"\5\u00e4s\2\u0583\u0582\3\2\2\2\u0583\u0584\3\2\2\2\u0584\u00e3\3\2\2"+
		"\2\u0585\u0586\7\u010d\2\2\u0586\u0587\5.\30\2\u0587\u00e5\3\2\2\2\u0588"+
		"\u0589\5\22\n\2\u0589\u058b\5\u00e0q\2\u058a\u058c\5N(\2\u058b\u058a\3"+
		"\2\2\2\u058b\u058c\3\2\2\2\u058c\u0590\3\2\2\2\u058d\u058e\7\u00d4\2\2"+
		"\u058e\u058f\7_\2\2\u058f\u0591\5P)\2\u0590\u058d\3\2\2\2\u0590\u0591"+
		"\3\2\2\2\u0591\u00e7\3\2\2\2\u0592\u05aa\5\u00eav\2\u0593\u05aa\5\u00ec"+
		"w\2\u0594\u05aa\5\u00eex\2\u0595\u05aa\5\u00f0y\2\u0596\u05aa\5\u00f2"+
		"z\2\u0597\u05aa\5\u00f4{\2\u0598\u05aa\5\u00f6|\2\u0599\u05aa\5\u00fa"+
		"~\2\u059a\u05aa\5\u00f8}\2\u059b\u05aa\5\u00fc\177\2\u059c\u05aa\5\u00fe"+
		"\u0080\2\u059d\u05aa\5\u0100\u0081\2\u059e\u05aa\5\u0102\u0082\2\u059f"+
		"\u05aa\5\u0104\u0083\2\u05a0\u05aa\5\u0106\u0084\2\u05a1\u05aa\5\u0108"+
		"\u0085\2\u05a2\u05aa\5\u010a\u0086\2\u05a3\u05aa\5\u010c\u0087\2\u05a4"+
		"\u05aa\5\u010e\u0088\2\u05a5\u05aa\5\u0110\u0089\2\u05a6\u05aa\5\u0112"+
		"\u008a\2\u05a7\u05aa\5\u0114\u008b\2\u05a8\u05aa\5\u0116\u008c\2\u05a9"+
		"\u0592\3\2\2\2\u05a9\u0593\3\2\2\2\u05a9\u0594\3\2\2\2\u05a9\u0595\3\2"+
		"\2\2\u05a9\u0596\3\2\2\2\u05a9\u0597\3\2\2\2\u05a9\u0598\3\2\2\2\u05a9"+
		"\u0599\3\2\2\2\u05a9\u059a\3\2\2\2\u05a9\u059b\3\2\2\2\u05a9\u059c\3\2"+
		"\2\2\u05a9\u059d\3\2\2\2\u05a9\u059e\3\2\2\2\u05a9\u059f\3\2\2\2\u05a9"+
		"\u05a0\3\2\2\2\u05a9\u05a1\3\2\2\2\u05a9\u05a2\3\2\2\2\u05a9\u05a3\3\2"+
		"\2\2\u05a9\u05a4\3\2\2\2\u05a9\u05a5\3\2\2\2\u05a9\u05a6\3\2\2\2\u05a9"+
		"\u05a7\3\2\2\2\u05a9\u05a8\3\2\2\2\u05aa\u00e9\3\2\2\2\u05ab\u05b0\t!"+
		"\2\2\u05ac\u05ad\7\u022e\2\2\u05ad\u05ae\5\u0122\u0092\2\u05ae\u05af\7"+
		"\u022f\2\2\u05af\u05b1\3\2\2\2\u05b0\u05ac\3\2\2\2\u05b0\u05b1\3\2\2\2"+
		"\u05b1\u00eb\3\2\2\2\u05b2\u05b3\t!\2\2\u05b3\u05b6\7\u014c\2\2\u05b4"+
		"\u05b6\7\u014b\2\2\u05b5\u05b2\3\2\2\2\u05b5\u05b4\3\2\2\2\u05b6\u05bb"+
		"\3\2\2\2\u05b7\u05b8\7\u022e\2\2\u05b8\u05b9\5\u0122\u0092\2\u05b9\u05ba"+
		"\7\u022f\2\2\u05ba\u05bc\3\2\2\2\u05bb\u05b7\3\2\2\2\u05bb\u05bc\3\2\2"+
		"\2\u05bc\u00ed\3\2\2\2\u05bd\u05be\t!\2\2\u05be\u05bf\7\u00ab\2\2\u05bf"+
		"\u05c2\7\u00d0\2\2\u05c0\u05c2\78\2\2\u05c1\u05bd\3\2\2\2\u05c1\u05c0"+
		"\3\2\2\2\u05c2\u05c7\3\2\2\2\u05c3\u05c4\7\u022e\2\2\u05c4\u05c5\5\u011a"+
		"\u008e\2\u05c5\u05c6\7\u022f\2\2\u05c6\u05c8\3\2\2\2\u05c7\u05c3\3\2\2"+
		"\2\u05c7\u05c8\3\2\2\2\u05c8\u00ef\3\2\2\2\u05c9\u05ca\7\u00c2\2\2\u05ca"+
		"\u05cd\t!\2\2\u05cb\u05cd\7\u00c4\2\2\u05cc\u05c9\3\2\2\2\u05cc\u05cb"+
		"\3\2\2\2\u05cd\u05d2\3\2\2\2\u05ce\u05cf\7\u022e\2\2\u05cf\u05d0\5\u0122"+
		"\u0092\2\u05d0\u05d1\7\u022f\2\2\u05d1\u05d3\3\2\2\2\u05d2\u05ce\3\2\2"+
		"\2\u05d2\u05d3\3\2\2\2\u05d3\u00f1\3\2\2\2\u05d4\u05d5\7\u00c2\2\2\u05d5"+
		"\u05d6\t!\2\2\u05d6\u05da\7\u014c\2\2\u05d7\u05d8\7\u00c4\2\2\u05d8\u05da"+
		"\7\u014c\2\2\u05d9\u05d4\3\2\2\2\u05d9\u05d7\3\2\2\2\u05da\u05df\3\2\2"+
		"\2\u05db\u05dc\7\u022e\2\2\u05dc\u05dd\5\u0122\u0092\2\u05dd\u05de\7\u022f"+
		"\2\2\u05de\u05e0\3\2\2\2\u05df\u05db\3\2\2\2\u05df\u05e0\3\2\2\2\u05e0"+
		"\u00f3\3\2\2\2\u05e1\u05e2\7\u00c2\2\2\u05e2\u05e3\t!\2\2\u05e3\u05e4"+
		"\7\u00ab\2\2\u05e4\u05ea\7\u00d0\2\2\u05e5\u05e6\7\u00c4\2\2\u05e6\u05e7"+
		"\7\u00ab\2\2\u05e7\u05ea\7\u00d0\2\2\u05e8\u05ea\7\u00c5\2\2\u05e9\u05e1"+
		"\3\2\2\2\u05e9\u05e5\3\2\2\2\u05e9\u05e8\3\2\2\2\u05ea\u05ef\3\2\2\2\u05eb"+
		"\u05ec\7\u022e\2\2\u05ec\u05ed\5\u011a\u008e\2\u05ed\u05ee\7\u022f\2\2"+
		"\u05ee\u05f0\3\2\2\2\u05ef\u05eb\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u00f5"+
		"\3\2\2\2\u05f1\u05f2\7\u0156\2\2\u05f2\u00f7\3\2\2\2\u05f3\u05f8\7$\2"+
		"\2\u05f4\u05f5\7\u022e\2\2\u05f5\u05f6\5\u0122\u0092\2\u05f6\u05f7\7\u022f"+
		"\2\2\u05f7\u05f9\3\2\2\2\u05f8\u05f4\3\2\2\2\u05f8\u05f9\3\2\2\2\u05f9"+
		"\u00f9\3\2\2\2\u05fa\u05fb\7$\2\2\u05fb\u05fe\7\u014c\2\2\u05fc\u05fe"+
		"\7\u014a\2\2\u05fd\u05fa\3\2\2\2\u05fd\u05fc\3\2\2\2\u05fe\u0603\3\2\2"+
		"\2\u05ff\u0600\7\u022e\2\2\u0600\u0601\5\u0122\u0092\2\u0601\u0602\7\u022f"+
		"\2\2\u0602\u0604\3\2\2\2\u0603\u05ff\3\2\2\2\u0603\u0604\3\2\2\2\u0604"+
		"\u00fb\3\2\2\2\u0605\u0606\7$\2\2\u0606\u0607\7\u00ab\2\2\u0607\u060a"+
		"\7\u00d0\2\2\u0608\u060a\7%\2\2\u0609\u0605\3\2\2\2\u0609\u0608\3\2\2"+
		"\2\u060a\u060f\3\2\2\2\u060b\u060c\7\u022e\2\2\u060c\u060d\5\u011a\u008e"+
		"\2\u060d\u060e\7\u022f\2\2\u060e\u0610\3\2\2\2\u060f\u060b\3\2\2\2\u060f"+
		"\u0610\3\2\2\2\u0610\u00fd\3\2\2\2\u0611\u061a\7\u00cf\2\2\u0612\u0613"+
		"\7\u022e\2\2\u0613\u0616\5\u011e\u0090\2\u0614\u0615\7\u0232\2\2\u0615"+
		"\u0617\5\u0120\u0091\2\u0616\u0614\3\2\2\2\u0616\u0617\3\2\2\2\u0617\u0618"+
		"\3\2\2\2\u0618\u0619\7\u022f\2\2\u0619\u061b\3\2\2\2\u061a\u0612\3\2\2"+
		"\2\u061a\u061b\3\2\2\2\u061b\u00ff\3\2\2\2\u061c\u0625\t\"\2\2\u061d\u061e"+
		"\7\u022e\2\2\u061e\u0621\5\u011e\u0090\2\u061f\u0620\7\u0232\2\2\u0620"+
		"\u0622\5\u0120\u0091\2\u0621\u061f\3\2\2\2\u0621\u0622\3\2\2\2\u0622\u0623"+
		"\3\2\2\2\u0623\u0624\7\u022f\2\2\u0624\u0626\3\2\2\2\u0625\u061d\3\2\2"+
		"\2\u0625\u0626\3\2\2\2\u0626\u0101\3\2\2\2\u0627\u0628\7\u0117\2\2\u0628"+
		"\u0103\3\2\2\2\u0629\u062a\t#\2\2\u062a\u0105\3\2\2\2\u062b\u062c\7#\2"+
		"\2\u062c\u0107\3\2\2\2\u062d\u0632\7~\2\2\u062e\u062f\7\u022e\2\2\u062f"+
		"\u0630\5\u011e\u0090\2\u0630\u0631\7\u022f\2\2\u0631\u0633\3\2\2\2\u0632"+
		"\u062e\3\2\2\2\u0632\u0633\3\2\2\2\u0633\u0109\3\2\2\2\u0634\u0635\7\u00f0"+
		"\2\2\u0635\u010b\3\2\2\2\u0636\u0637\7h\2\2\u0637\u0638\7\u00e9\2\2\u0638"+
		"\u010d\3\2\2\2\u0639\u063a\7&\2\2\u063a\u010f\3\2\2\2\u063b\u063c\7V\2"+
		"\2\u063c\u0111\3\2\2\2\u063d\u0642\7\u012f\2\2\u063e\u063f\7\u022e\2\2"+
		"\u063f\u0640\5\u011c\u008f\2\u0640\u0641\7\u022f\2\2\u0641\u0643\3\2\2"+
		"\2\u0642\u063e\3\2\2\2\u0642\u0643\3\2\2\2\u0643\u0645\3\2\2\2\u0644\u0646"+
		"\5\u008aF\2\u0645\u0644\3\2\2\2\u0645\u0646\3\2\2\2\u0646\u0113\3\2\2"+
		"\2\u0647\u064c\7\u0130\2\2\u0648\u0649\7\u022e\2\2\u0649\u064a\5\u011c"+
		"\u008f\2\u064a\u064b\7\u022f\2\2\u064b\u064d\3\2\2\2\u064c\u0648\3\2\2"+
		"\2\u064c\u064d\3\2\2\2\u064d\u064f\3\2\2\2\u064e\u0650\5\u008aF\2\u064f"+
		"\u064e\3\2\2\2\u064f\u0650\3\2\2\2\u0650\u0115\3\2\2\2\u0651\u0652\7\u00a3"+
		"\2\2\u0652\u0653\5\u0118\u008d\2\u0653\u0117\3\2\2\2\u0654\u0659\7\u0157"+
		"\2\2\u0655\u0656\7\u022e\2\2\u0656\u0657\5\u011e\u0090\2\u0657\u0658\7"+
		"\u022f\2\2\u0658\u065a\3\2\2\2\u0659\u0655\3\2\2\2\u0659\u065a\3\2\2\2"+
		"\u065a\u065d\3\2\2\2\u065b\u065c\7\u0133\2\2\u065c\u065e\7\u00c0\2\2\u065d"+
		"\u065b\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u06aa\3\2\2\2\u065f\u0664\7\u00c0"+
		"\2\2\u0660\u0661\7\u022e\2\2\u0661\u0662\5\u011e\u0090\2\u0662\u0663\7"+
		"\u022f\2\2\u0663\u0665\3\2\2\2\u0664\u0660\3\2\2\2\u0664\u0665\3\2\2\2"+
		"\u0665\u06aa\3\2\2\2\u0666\u066b\7W\2\2\u0667\u0668\7\u022e\2\2\u0668"+
		"\u0669\5\u011e\u0090\2\u0669\u066a\7\u022f\2\2\u066a\u066c\3\2\2\2\u066b"+
		"\u0667\3\2\2\2\u066b\u066c\3\2\2\2\u066c\u0679\3\2\2\2\u066d\u066e\7\u0133"+
		"\2\2\u066e\u067a\7\u0091\2\2\u066f\u0670\7\u0133\2\2\u0670\u067a\7\u00bc"+
		"\2\2\u0671\u0672\7\u0133\2\2\u0672\u0677\7\u0110\2\2\u0673\u0674\7\u022e"+
		"\2\2\u0674\u0675\5\u011c\u008f\2\u0675\u0676\7\u022f\2\2\u0676\u0678\3"+
		"\2\2\2\u0677\u0673\3\2\2\2\u0677\u0678\3\2\2\2\u0678\u067a\3\2\2\2\u0679"+
		"\u066d\3\2\2\2\u0679\u066f\3\2\2\2\u0679\u0671\3\2\2\2\u0679\u067a\3\2"+
		"\2\2\u067a\u06aa\3\2\2\2\u067b\u0680\7\u0091\2\2\u067c\u067d\7\u022e\2"+
		"\2\u067d\u067e\5\u011e\u0090\2\u067e\u067f\7\u022f\2\2\u067f\u0681\3\2"+
		"\2\2\u0680\u067c\3\2\2\2\u0680\u0681\3\2\2\2\u0681\u068c\3\2\2\2\u0682"+
		"\u0683\7\u0133\2\2\u0683\u068d\7\u00bc\2\2\u0684\u0685\7\u0133\2\2\u0685"+
		"\u068a\7\u0110\2\2\u0686\u0687\7\u022e\2\2\u0687\u0688\5\u011c\u008f\2"+
		"\u0688\u0689\7\u022f\2\2\u0689\u068b\3\2\2\2\u068a\u0686\3\2\2\2\u068a"+
		"\u068b\3\2\2\2\u068b\u068d\3\2\2\2\u068c\u0682\3\2\2\2\u068c\u0684\3\2"+
		"\2\2\u068c\u068d\3\2\2\2\u068d\u06aa\3\2\2\2\u068e\u0693\7\u00bc\2\2\u068f"+
		"\u0690\7\u022e\2\2\u0690\u0691\5\u011e\u0090\2\u0691\u0692\7\u022f\2\2"+
		"\u0692\u0694\3\2\2\2\u0693\u068f\3\2\2\2\u0693\u0694\3\2\2\2\u0694\u069d"+
		"\3\2\2\2\u0695\u0696\7\u0133\2\2\u0696\u069b\7\u0110\2\2\u0697\u0698\7"+
		"\u022e\2\2\u0698\u0699\5\u011c\u008f\2\u0699\u069a\7\u022f\2\2\u069a\u069c"+
		"\3\2\2\2\u069b\u0697\3\2\2\2\u069b\u069c\3\2\2\2\u069c\u069e\3\2\2\2\u069d"+
		"\u0695\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u06aa\3\2\2\2\u069f\u06a7\7\u0110"+
		"\2\2\u06a0\u06a1\7\u022e\2\2\u06a1\u06a2\5\u011e\u0090\2\u06a2\u06a3\7"+
		"\u0232\2\2\u06a3\u06a4\5\u011c\u008f\2\u06a4\u06a5\3\2\2\2\u06a5\u06a6"+
		"\7\u022f\2\2\u06a6\u06a8\3\2\2\2\u06a7\u06a0\3\2\2\2\u06a7\u06a8\3\2\2"+
		"\2\u06a8\u06aa\3\2\2\2\u06a9\u0654\3\2\2\2\u06a9\u065f\3\2\2\2\u06a9\u0666"+
		"\3\2\2\2\u06a9\u067b\3\2\2\2\u06a9\u068e\3\2\2\2\u06a9\u069f\3\2\2\2\u06aa"+
		"\u0119\3\2\2\2\u06ab\u06ad\5\u0122\u0092\2\u06ac\u06ae\5\u0088E\2\u06ad"+
		"\u06ac\3\2\2\2\u06ad\u06ae\3\2\2\2\u06ae\u011b\3\2\2\2\u06af\u06b0\7\u0203"+
		"\2\2\u06b0\u011d\3\2\2\2\u06b1\u06b2\7\u0203\2\2\u06b2\u011f\3\2\2\2\u06b3"+
		"\u06b4\7\u0203\2\2\u06b4\u0121\3\2\2\2\u06b5\u06b6\7\u0203\2\2\u06b6\u0123"+
		"\3\2\2\2\u06b7\u06b9\7\u0111\2\2\u06b8\u06ba\5j\66\2\u06b9\u06b8\3\2\2"+
		"\2\u06b9\u06ba\3\2\2\2\u06ba\u06bb\3\2\2\2\u06bb\u06bc\5\u0126\u0094\2"+
		"\u06bc\u06be\5\u012a\u0096\2\u06bd\u06bf\5\u012c\u0097\2\u06be\u06bd\3"+
		"\2\2\2\u06be\u06bf\3\2\2\2\u06bf\u06c1\3\2\2\2\u06c0\u06c2\5\u012e\u0098"+
		"\2\u06c1\u06c0\3\2\2\2\u06c1\u06c2\3\2\2\2\u06c2\u06c4\3\2\2\2\u06c3\u06c5"+
		"\5\u0130\u0099\2\u06c4\u06c3\3\2\2\2\u06c4\u06c5\3\2\2\2\u06c5\u06c7\3"+
		"\2\2\2\u06c6\u06c8\5\u0132\u009a\2\u06c7\u06c6\3\2\2\2\u06c7\u06c8\3\2"+
		"\2\2\u06c8\u0125\3\2\2\2\u06c9\u06d3\7\u0230\2\2\u06ca\u06cf\5\u0128\u0095"+
		"\2\u06cb\u06cc\7\u0232\2\2\u06cc\u06ce\5\u0128\u0095\2\u06cd\u06cb\3\2"+
		"\2\2\u06ce\u06d1\3\2\2\2\u06cf\u06cd\3\2\2\2\u06cf\u06d0\3\2\2\2\u06d0"+
		"\u06d3\3\2\2\2\u06d1\u06cf\3\2\2\2\u06d2\u06c9\3\2\2\2\u06d2\u06ca\3\2"+
		"\2\2\u06d3\u0127\3\2\2\2\u06d4\u06d7\5\u0152\u00aa\2\u06d5\u06d6\7\27"+
		"\2\2\u06d6\u06d8\5\24\13\2\u06d7\u06d5\3\2\2\2\u06d7\u06d8\3\2\2\2\u06d8"+
		"\u06ef\3\2\2\2\u06d9\u06da\5,\27\2\u06da\u06db\7\u0234\2\2\u06db\u06dc"+
		"\7\u0230\2\2\u06dc\u06ef\3\2\2\2\u06dd\u06de\5\u0152\u00aa\2\u06de\u06df"+
		"\7\u0234\2\2\u06df\u06ec\7\u0230\2\2\u06e0\u06e1\7\27\2\2\u06e1\u06e2"+
		"\7\u022e\2\2\u06e2\u06e7\5\24\13\2\u06e3\u06e4\7\u0232\2\2\u06e4\u06e6"+
		"\5\24\13\2\u06e5\u06e3\3\2\2\2\u06e6\u06e9\3\2\2\2\u06e7\u06e5\3\2\2\2"+
		"\u06e7\u06e8\3\2\2\2\u06e8\u06ea\3\2\2\2\u06e9\u06e7\3\2\2\2\u06ea\u06eb"+
		"\7\u022f\2\2\u06eb\u06ed\3\2\2\2\u06ec\u06e0\3\2\2\2\u06ec\u06ed\3\2\2"+
		"\2\u06ed\u06ef\3\2\2\2\u06ee\u06d4\3\2\2\2\u06ee\u06d9\3\2\2\2\u06ee\u06dd"+
		"\3\2\2\2\u06ef\u0129\3\2\2\2\u06f0\u06f1\7\u0084\2\2\u06f1\u06f6\5\u0134"+
		"\u009b\2\u06f2\u06f3\7\u0232\2\2\u06f3\u06f5\5\u0134\u009b\2\u06f4\u06f2"+
		"\3\2\2\2\u06f5\u06f8\3\2\2\2\u06f6\u06f4\3\2\2\2\u06f6\u06f7\3\2\2\2\u06f7"+
		"\u012b\3\2\2\2\u06f8\u06f6\3\2\2\2\u06f9\u06fa\7\u0150\2\2\u06fa\u06fb"+
		"\5\u017e\u00c0\2\u06fb\u012d\3\2\2\2\u06fc\u06fd\7\u008d\2\2\u06fd\u06ff"+
		"\7(\2\2\u06fe\u0700\5j\66\2\u06ff\u06fe\3\2\2\2\u06ff\u0700\3\2\2\2\u0700"+
		"\u0701\3\2\2\2\u0701\u0706\5\u013c\u009f\2\u0702\u0703\7\u0232\2\2\u0703"+
		"\u0705\5\u013c\u009f\2\u0704\u0702\3\2\2\2\u0705\u0708\3\2\2\2\u0706\u0704"+
		"\3\2\2\2\u0706\u0707\3\2\2\2\u0707\u012f\3\2\2\2\u0708\u0706\3\2\2\2\u0709"+
		"\u070a\7\u008f\2\2\u070a\u070b\5\u017e\u00c0\2\u070b\u0131\3\2\2\2\u070c"+
		"\u070d\7\u0152\2\2\u070d\u0712\5\u01bc\u00df\2\u070e\u070f\7\u0232\2\2"+
		"\u070f\u0711\5\u01bc\u00df\2\u0710\u070e\3\2\2\2\u0711\u0714\3\2\2\2\u0712"+
		"\u0710\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0133\3\2\2\2\u0714\u0712\3\2"+
		"\2\2\u0715\u0716\b\u009b\1\2\u0716\u0724\5\u0138\u009d\2\u0717\u0718\7"+
		"\u012c\2\2\u0718\u0719\5l\67\2\u0719\u071a\7\u022e\2\2\u071a\u071b\5\u0156"+
		"\u00ac\2\u071b\u0721\7\u022f\2\2\u071c\u071d\7\u00ff\2\2\u071d\u071e\7"+
		"\u022e\2\2\u071e\u071f\5\u0156\u00ac\2\u071f\u0720\7\u022f\2\2\u0720\u0722"+
		"\3\2\2\2\u0721\u071c\3\2\2\2\u0721\u0722\3\2\2\2\u0722\u0724\3\2\2\2\u0723"+
		"\u0715\3\2\2\2\u0723\u0717\3\2\2\2\u0724\u073a\3\2\2\2\u0725\u0726\f\7"+
		"\2\2\u0726\u0727\7G\2\2\u0727\u0728\7\u00a7\2\2\u0728\u0739\5\u0138\u009d"+
		"\2\u0729\u072a\f\6\2\2\u072a\u072b\5n8\2\u072b\u072c\7\u00a7\2\2\u072c"+
		"\u072d\5\u0134\u009b\2\u072d\u072e\5\u0136\u009c\2\u072e\u0739\3\2\2\2"+
		"\u072f\u0730\f\5\2\2\u0730\u0731\7\u00c3\2\2\u0731\u0732\5n8\2\u0732\u0733"+
		"\7\u00a7\2\2\u0733\u0734\5\u0138\u009d\2\u0734\u0739\3\2\2\2\u0735\u0736"+
		"\f\4\2\2\u0736\u0737\7\u013e\2\2\u0737\u0739\5\u0138\u009d\2\u0738\u0725"+
		"\3\2\2\2\u0738\u0729\3\2\2\2\u0738\u072f\3\2\2\2\u0738\u0735\3\2\2\2\u0739"+
		"\u073c\3\2\2\2\u073a\u0738\3\2\2\2\u073a\u073b\3\2\2\2\u073b\u0135\3\2"+
		"\2\2\u073c\u073a\3\2\2\2\u073d\u073e\7\u00d4\2\2\u073e\u074c\5\u017e\u00c0"+
		"\2\u073f\u0740\7\u0145\2\2\u0740\u0741\7\u022e\2\2\u0741\u0746\5\24\13"+
		"\2\u0742\u0743\7\u0232\2\2\u0743\u0745\5\24\13\2\u0744\u0742\3\2\2\2\u0745"+
		"\u0748\3\2\2\2\u0746\u0744\3\2\2\2\u0746\u0747\3\2\2\2\u0747\u0749\3\2"+
		"\2\2\u0748\u0746\3\2\2\2\u0749\u074a\7\u022f\2\2\u074a\u074c\3\2\2\2\u074b"+
		"\u073d\3\2\2\2\u074b\u073f\3\2\2\2\u074c\u0137\3\2\2\2\u074d\u074f\5."+
		"\30\2\u074e\u0750\5\u013a\u009e\2\u074f\u074e\3\2\2\2\u074f\u0750\3\2"+
		"\2\2\u0750\u077e\3\2\2\2\u0751\u0752\7\u022e\2\2\u0752\u0753\5\u0134\u009b"+
		"\2\u0753\u0754\7\u022f\2\2\u0754\u077e\3\2\2\2\u0755\u0757\7\u00ac\2\2"+
		"\u0756\u0755\3\2\2\2\u0756\u0757\3\2\2\2\u0757\u0758\3\2\2\2\u0758\u0759"+
		"\7\u022e\2\2\u0759\u075a\5\u0140\u00a1\2\u075a\u075c\7\u022f\2\2\u075b"+
		"\u075d\5\u013a\u009e\2\u075c\u075b\3\2\2\2\u075c\u075d\3\2\2\2\u075d\u077e"+
		"\3\2\2\2\u075e\u075f\7\u0141\2\2\u075f\u0762\7\u022e\2\2\u0760\u0763\5"+
		"\u017a\u00be\2\u0761\u0763\5\u017c\u00bf\2\u0762\u0760\3\2\2\2\u0762\u0761"+
		"\3\2\2\2\u0763\u0764\3\2\2\2\u0764\u0767\7\u022f\2\2\u0765\u0766\7\u0153"+
		"\2\2\u0766\u0768\7\u00db\2\2\u0767\u0765\3\2\2\2\u0767\u0768\3\2\2\2\u0768"+
		"\u076a\3\2\2\2\u0769\u076b\5\u013a\u009e\2\u076a\u0769\3\2\2\2\u076a\u076b"+
		"\3\2\2\2\u076b\u077e\3\2\2\2\u076c\u076d\7\u012b\2\2\u076d\u0770\7\u022e"+
		"\2\2\u076e\u0771\5\u017a\u00be\2\u076f\u0771\5\u017c\u00bf\2\u0770\u076e"+
		"\3\2\2\2\u0770\u076f\3\2\2\2\u0771\u0772\3\2\2\2\u0772\u0774\7\u022f\2"+
		"\2\u0773\u0775\5\u013a\u009e\2\u0774\u0773\3\2\2\2\u0774\u0775\3\2\2\2"+
		"\u0775\u077e\3\2\2\2\u0776\u0777\7\u00d5\2\2\u0777\u0778\7\u022e\2\2\u0778"+
		"\u0779\5.\30\2\u0779\u077b\7\u022f\2\2\u077a\u077c\5\u013a\u009e\2\u077b"+
		"\u077a\3\2\2\2\u077b\u077c\3\2\2\2\u077c\u077e\3\2\2\2\u077d\u074d\3\2"+
		"\2\2\u077d\u0751\3\2\2\2\u077d\u0756\3\2\2\2\u077d\u075e\3\2\2\2\u077d"+
		"\u076c\3\2\2\2\u077d\u0776\3\2\2\2\u077e\u0139\3\2\2\2\u077f\u0781\7\27"+
		"\2\2\u0780\u077f\3\2\2\2\u0780\u0781\3\2\2\2\u0781\u0782\3\2\2\2\u0782"+
		"\u078e\5\36\20\2\u0783\u0784\7\u022e\2\2\u0784\u0789\5\24\13\2\u0785\u0786"+
		"\7\u0232\2\2\u0786\u0788\5\24\13\2\u0787\u0785\3\2\2\2\u0788\u078b\3\2"+
		"\2\2\u0789\u0787\3\2\2\2\u0789\u078a\3\2\2\2\u078a\u078c\3\2\2\2\u078b"+
		"\u0789\3\2\2\2\u078c\u078d\7\u022f\2\2\u078d\u078f\3\2\2\2\u078e\u0783"+
		"\3\2\2\2\u078e\u078f\3\2\2\2\u078f\u013b\3\2\2\2\u0790\u07ab\5\u013e\u00a0"+
		"\2\u0791\u0792\7\u0107\2\2\u0792\u0793\7\u022e\2\2\u0793\u0794\5\u013e"+
		"\u00a0\2\u0794\u0795\7\u022f\2\2\u0795\u07ab\3\2\2\2\u0796\u0797\7H\2"+
		"\2\u0797\u0798\7\u022e\2\2\u0798\u0799\5\u013e\u00a0\2\u0799\u079a\7\u022f"+
		"\2\2\u079a\u07ab\3\2\2\2\u079b\u079c\7\u008e\2\2\u079c\u079d\7\u01e2\2"+
		"\2\u079d\u079e\7\u022e\2\2\u079e\u07a3\5\u013c\u009f\2\u079f\u07a0\7\u0232"+
		"\2\2\u07a0\u07a2\5\u013c\u009f\2\u07a1\u079f\3\2\2\2\u07a2\u07a5\3\2\2"+
		"\2\u07a3\u07a1\3\2\2\2\u07a3\u07a4\3\2\2\2\u07a4\u07a6\3\2\2\2\u07a5\u07a3"+
		"\3\2\2\2\u07a6\u07a7\7\u022f\2\2\u07a7\u07ab\3\2\2\2\u07a8\u07a9\7\u022e"+
		"\2\2\u07a9\u07ab\7\u022f\2\2\u07aa\u0790\3\2\2\2\u07aa\u0791\3\2\2\2\u07aa"+
		"\u0796\3\2\2\2\u07aa\u079b\3\2\2\2\u07aa\u07a8\3\2\2\2\u07ab\u013d\3\2"+
		"\2\2\u07ac\u07b9\5,\27\2\u07ad\u07ae\7\u022e\2\2\u07ae\u07b3\5,\27\2\u07af"+
		"\u07b0\7\u0232\2\2\u07b0\u07b2\5,\27\2\u07b1\u07af\3\2\2\2\u07b2\u07b5"+
		"\3\2\2\2\u07b3\u07b1\3\2\2\2\u07b3\u07b4\3\2\2\2\u07b4\u07b6\3\2\2\2\u07b5"+
		"\u07b3\3\2\2\2\u07b6\u07b7\7\u022f\2\2\u07b7\u07b9\3\2\2\2\u07b8\u07ac"+
		"\3\2\2\2\u07b8\u07ad\3\2\2\2\u07b9\u013f\3\2\2\2\u07ba\u07bc\5\u0148\u00a5"+
		"\2\u07bb\u07ba\3\2\2\2\u07bb\u07bc\3\2\2\2\u07bc\u07bd\3\2\2\2\u07bd\u07be"+
		"\5\u0142\u00a2\2\u07be\u0141\3\2\2\2\u07bf\u07c0\b\u00a2\1\2\u07c0\u07d5"+
		"\5\u0134\u009b\2\u07c1\u07c2\7\u022e\2\2\u07c2\u07c3\5\u0142\u00a2\2\u07c3"+
		"\u07c4\7\u022f\2\2\u07c4\u07d5\3\2\2\2\u07c5\u07d5\5\u0124\u0093\2\u07c6"+
		"\u07c7\7\u012b\2\2\u07c7\u07d5\5.\30\2\u07c8\u07c9\7\u0147\2\2\u07c9\u07ca"+
		"\7\u022e\2\2\u07ca\u07cf\5\u0144\u00a3\2\u07cb\u07cc\7\u0232\2\2\u07cc"+
		"\u07ce\5\u0144\u00a3\2\u07cd\u07cb\3\2\2\2\u07ce\u07d1\3\2\2\2\u07cf\u07cd"+
		"\3\2\2\2\u07cf\u07d0\3\2\2\2\u07d0\u07d2\3\2\2\2\u07d1\u07cf\3\2\2\2\u07d2"+
		"\u07d3\7\u022f\2\2\u07d3\u07d5\3\2\2\2\u07d4\u07bf\3\2\2\2\u07d4\u07c1"+
		"\3\2\2\2\u07d4\u07c5\3\2\2\2\u07d4\u07c6\3\2\2\2\u07d4\u07c8\3\2\2\2\u07d5"+
		"\u07e2\3\2\2\2\u07d6\u07d7\f\b\2\2\u07d7\u07d9\5\u008eH\2\u07d8\u07da"+
		"\5j\66\2\u07d9\u07d8\3\2\2\2\u07d9\u07da\3\2\2\2\u07da\u07dc\3\2\2\2\u07db"+
		"\u07dd\5\u0146\u00a4\2\u07dc\u07db\3\2\2\2\u07dc\u07dd\3\2\2\2\u07dd\u07de"+
		"\3\2\2\2\u07de\u07df\5\u0142\u00a2\t\u07df\u07e1\3\2\2\2\u07e0\u07d6\3"+
		"\2\2\2\u07e1\u07e4\3\2\2\2\u07e2\u07e0\3\2\2\2\u07e2\u07e3\3\2\2\2\u07e3"+
		"\u0143\3\2\2\2\u07e4\u07e2\3\2\2\2\u07e5\u07ea\5\u01a2\u00d2\2\u07e6\u07ea"+
		"\5\u0154\u00ab\2\u07e7\u07ea\5\u017e\u00c0\2\u07e8\u07ea\5\u01a4\u00d3"+
		"\2\u07e9\u07e5\3\2\2\2\u07e9\u07e6\3\2\2\2\u07e9\u07e7\3\2\2\2\u07e9\u07e8"+
		"\3\2\2\2\u07ea\u0145\3\2\2\2\u07eb\u07f8\7B\2\2\u07ec\u07ed\7(\2\2\u07ed"+
		"\u07ee\7\u022e\2\2\u07ee\u07f3\5\24\13\2\u07ef\u07f0\7\u0232\2\2\u07f0"+
		"\u07f2\5\24\13\2\u07f1\u07ef\3\2\2\2\u07f2\u07f5\3\2\2\2\u07f3\u07f1\3"+
		"\2\2\2\u07f3\u07f4\3\2\2\2\u07f4\u07f6\3\2\2\2\u07f5\u07f3\3\2\2\2\u07f6"+
		"\u07f7\7\u022f\2\2\u07f7\u07f9\3\2\2\2\u07f8\u07ec\3\2\2\2\u07f8\u07f9"+
		"\3\2\2\2\u07f9\u0147\3\2\2\2\u07fa\u07fc\7\u0153\2\2\u07fb\u07fd\7\u00f1"+
		"\2\2\u07fc\u07fb\3\2\2\2\u07fc\u07fd\3\2\2\2\u07fd\u07ff\3\2\2\2\u07fe"+
		"\u0800\5\u014a\u00a6\2\u07ff\u07fe\3\2\2\2\u0800\u0801\3\2\2\2\u0801\u07ff"+
		"\3\2\2\2\u0801\u0802\3\2\2\2\u0802\u0149\3\2\2\2\u0803\u080f\5\34\17\2"+
		"\u0804\u0805\7\u022e\2\2\u0805\u080a\5\24\13\2\u0806\u0807\7\u0232\2\2"+
		"\u0807\u0809\5\24\13\2\u0808\u0806\3\2\2\2\u0809\u080c\3\2\2\2\u080a\u0808"+
		"\3\2\2\2\u080a\u080b\3\2\2\2\u080b\u080d\3\2\2\2\u080c\u080a\3\2\2\2\u080d"+
		"\u080e\7\u022f\2\2\u080e\u0810\3\2\2\2\u080f\u0804\3\2\2\2\u080f\u0810"+
		"\3\2\2\2\u0810\u0818\3\2\2\2\u0811\u0812\7\27\2\2\u0812\u0813\7\u022e"+
		"\2\2\u0813\u0814\5\u0140\u00a1\2\u0814\u0816\7\u022f\2\2\u0815\u0817\5"+
		"\u014c\u00a7\2\u0816\u0815\3\2\2\2\u0816\u0817\3\2\2\2\u0817\u0819\3\2"+
		"\2\2\u0818\u0811\3\2\2\2\u0818\u0819\3\2\2\2\u0819\u014b\3\2\2\2\u081a"+
		"\u0820\5\u014e\u00a8\2\u081b\u0820\5\u0150\u00a9\2\u081c\u081d\5\u014e"+
		"\u00a8\2\u081d\u081e\5\u0150\u00a9\2\u081e\u0820\3\2\2\2\u081f\u081a\3"+
		"\2\2\2\u081f\u081b\3\2\2\2\u081f\u081c\3\2\2\2\u0820\u014d\3\2\2\2\u0821"+
		"\u0822\7\u010f\2\2\u0822\u0823\7\u018a\2\2\u0823\u0824\7\u0194\2\2\u0824"+
		"\u0825\7(\2\2\u0825\u0826\5\u01b0\u00d9\2\u0826\u0827\7\u0114\2\2\u0827"+
		"\u0828\5\24\13\2\u0828\u0832\3\2\2\2\u0829\u082a\7\u010f\2\2\u082a\u082b"+
		"\7\u0161\2\2\u082b\u082c\7\u0194\2\2\u082c\u082d\7(\2\2\u082d\u082e\5"+
		"\u01b0\u00d9\2\u082e\u082f\7\u0114\2\2\u082f\u0830\5\24\13\2\u0830\u0832"+
		"\3\2\2\2\u0831\u0821\3\2\2\2\u0831\u0829\3\2\2\2\u0832\u014f\3\2\2\2\u0833"+
		"\u0834\7T\2\2\u0834\u0839\5\24\13\2\u0835\u0836\7\u0232\2\2\u0836\u0838"+
		"\5\24\13\2\u0837\u0835\3\2\2\2\u0838\u083b\3\2\2\2\u0839\u0837\3\2\2\2"+
		"\u0839\u083a\3\2\2\2\u083a\u0846\3\2\2\2\u083b\u0839\3\2\2\2\u083c\u083d"+
		"\7\u0114\2\2\u083d\u083e\5\24\13\2\u083e\u083f\7\u0133\2\2\u083f\u0840"+
		"\5\u0152\u00aa\2\u0840\u0846\3\2\2\2\u0841\u0842\7\\\2\2\u0842\u0846\5"+
		"\u0152\u00aa\2\u0843\u0844\7\u0145\2\2\u0844\u0846\5\24\13\2\u0845\u0833"+
		"\3\2\2\2\u0845\u083c\3\2\2\2\u0845\u0841\3\2\2\2\u0845\u0843\3\2\2\2\u0846"+
		"\u0151\3\2\2\2\u0847\u084b\5\u0154\u00ab\2\u0848\u084b\5\u017e\u00c0\2"+
		"\u0849\u084b\5\u01a2\u00d2\2\u084a\u0847\3\2\2\2\u084a\u0848\3\2\2\2\u084a"+
		"\u0849\3\2\2\2\u084b\u0153\3\2\2\2\u084c\u0854\5\u01a4\u00d3\2\u084d\u0854"+
		"\5\u0164\u00b3\2\u084e\u0854\5\u0156\u00ac\2\u084f\u0854\5\u016c\u00b7"+
		"\2\u0850\u0854\5\u0174\u00bb\2\u0851\u0854\5\u017a\u00be\2\u0852\u0854"+
		"\5\u017c\u00bf\2\u0853\u084c\3\2\2\2\u0853\u084d\3\2\2\2\u0853\u084e\3"+
		"\2\2\2\u0853\u084f\3\2\2\2\u0853\u0850\3\2\2\2\u0853\u0851\3\2\2\2\u0853"+
		"\u0852\3\2\2\2\u0854\u0155\3\2\2\2\u0855\u0857\b\u00ac\1\2\u0856\u0858"+
		"\5\u0094K\2\u0857\u0856\3\2\2\2\u0857\u0858\3\2\2\2\u0858\u0859\3\2\2"+
		"\2\u0859\u0863\5\u0158\u00ad\2\u085a\u085b\7\u022e\2\2\u085b\u085c\5\u0156"+
		"\u00ac\2\u085c\u085d\7\u022f\2\2\u085d\u0863\3\2\2\2\u085e\u0860\5\u0094"+
		"K\2\u085f\u085e\3\2\2\2\u085f\u0860\3\2\2\2\u0860\u0861\3\2\2\2\u0861"+
		"\u0863\5\u01a4\u00d3\2\u0862\u0855\3\2\2\2\u0862\u085a\3\2\2\2\u0862\u085f"+
		"\3\2\2\2\u0863\u086e\3\2\2\2\u0864\u0865\f\6\2\2\u0865\u0866\5\u0080A"+
		"\2\u0866\u0867\5\u0156\u00ac\7\u0867\u086d\3\2\2\2\u0868\u0869\f\5\2\2"+
		"\u0869\u086a\5\u0082B\2\u086a\u086b\5\u0156\u00ac\6\u086b\u086d\3\2\2"+
		"\2\u086c\u0864\3\2\2\2\u086c\u0868\3\2\2\2\u086d\u0870\3\2\2\2\u086e\u086c"+
		"\3\2\2\2\u086e\u086f\3\2\2\2\u086f\u0157\3\2\2\2\u0870\u086e\3\2\2\2\u0871"+
		"\u0872\t$\2\2\u0872\u0873\7\u022e\2\2\u0873\u0874\5\u0164\u00b3\2\u0874"+
		"\u0875\7\u022f\2\2\u0875\u08c7\3\2\2\2\u0876\u0877\7\u01c4\2\2\u0877\u0878"+
		"\7\u022e\2\2\u0878\u0879\5\u0164\u00b3\2\u0879\u087a\7\u0094\2\2\u087a"+
		"\u087b\5\u0164\u00b3\2\u087b\u087c\7\u022f\2\2\u087c\u08c7\3\2\2\2\u087d"+
		"\u087e\7y\2\2\u087e\u087f\7\u022e\2\2\u087f\u0880\5\u015a\u00ae\2\u0880";
	private static final String _serializedATNSegment1 =
		"\u0883\7\u0084\2\2\u0881\u0884\5\u016c\u00b7\2\u0882\u0884\5\u0174\u00bb"+
		"\2\u0883\u0881\3\2\2\2\u0883\u0882\3\2\2\2\u0884\u0885\3\2\2\2\u0885\u0886"+
		"\7\u022f\2\2\u0886\u08c7\3\2\2\2\u0887\u0888\7+\2\2\u0888\u088b\7\u022e"+
		"\2\2\u0889\u088c\5\u017a\u00be\2\u088a\u088c\5\u017c\u00bf\2\u088b\u0889"+
		"\3\2\2\2\u088b\u088a\3\2\2\2\u088c\u088d\3\2\2\2\u088d\u088e\7\u022f\2"+
		"\2\u088e\u08c7\3\2\2\2\u088f\u0890\7\13\2\2\u0890\u0891\7\u022e\2\2\u0891"+
		"\u0892\5\u0156\u00ac\2\u0892\u0893\7\u022f\2\2\u0893\u08c7\3\2\2\2\u0894"+
		"\u0895\7\u00bd\2\2\u0895\u0896\7\u022e\2\2\u0896\u0897\5\u0156\u00ac\2"+
		"\u0897\u0898\7\u0232\2\2\u0898\u0899\5\u0156\u00ac\2\u0899\u089a\7\u022f"+
		"\2\2\u089a\u08c7\3\2\2\2\u089b\u089c\7\u00b0\2\2\u089c\u089d\7\u022e\2"+
		"\2\u089d\u089e\5\u0156\u00ac\2\u089e\u089f\7\u022f\2\2\u089f\u08c7\3\2"+
		"\2\2\u08a0\u08a1\7w\2\2\u08a1\u08a2\7\u022e\2\2\u08a2\u08a3\5\u0156\u00ac"+
		"\2\u08a3\u08a4\7\u022f\2\2\u08a4\u08c7\3\2\2\2\u08a5\u08a6\7\u00e7\2\2"+
		"\u08a6\u08a7\7\u022e\2\2\u08a7\u08a8\5\u0156\u00ac\2\u08a8\u08a9\7\u0232"+
		"\2\2\u08a9\u08aa\5\u0156\u00ac\2\u08aa\u08ab\7\u022f\2\2\u08ab\u08c7\3"+
		"\2\2\2\u08ac\u08ad\7\u011f\2\2\u08ad\u08ae\7\u022e\2\2\u08ae\u08af\5\u0156"+
		"\u00ac\2\u08af\u08b0\7\u022f\2\2\u08b0\u08c7\3\2\2\2\u08b1\u08b2\7\177"+
		"\2\2\u08b2\u08b3\7\u022e\2\2\u08b3\u08b4\5\u0156\u00ac\2\u08b4\u08b5\7"+
		"\u022f\2\2\u08b5\u08c7\3\2\2\2\u08b6\u08b7\t%\2\2\u08b7\u08b8\7\u022e"+
		"\2\2\u08b8\u08b9\5\u0156\u00ac\2\u08b9\u08ba\7\u022f\2\2\u08ba\u08c7\3"+
		"\2\2\2\u08bb\u08bc\7\u0151\2\2\u08bc\u08bd\7\u022e\2\2\u08bd\u08be\5\u015c"+
		"\u00af\2\u08be\u08bf\7\u0232\2\2\u08bf\u08c0\5\u015e\u00b0\2\u08c0\u08c1"+
		"\7\u0232\2\2\u08c1\u08c2\5\u0160\u00b1\2\u08c2\u08c3\7\u0232\2\2\u08c3"+
		"\u08c4\5\u0162\u00b2\2\u08c4\u08c5\7\u022f\2\2\u08c5\u08c7\3\2\2\2\u08c6"+
		"\u0871\3\2\2\2\u08c6\u0876\3\2\2\2\u08c6\u087d\3\2\2\2\u08c6\u0887\3\2"+
		"\2\2\u08c6\u088f\3\2\2\2\u08c6\u0894\3\2\2\2\u08c6\u089b\3\2\2\2\u08c6"+
		"\u08a0\3\2\2\2\u08c6\u08a5\3\2\2\2\u08c6\u08ac\3\2\2\2\u08c6\u08b1\3\2"+
		"\2\2\u08c6\u08b6\3\2\2\2\u08c6\u08bb\3\2\2\2\u08c7\u0159\3\2\2\2\u08c8"+
		"\u08cb\5\u0090I\2\u08c9\u08cb\5\u0086D\2\u08ca\u08c8\3\2\2\2\u08ca\u08c9"+
		"\3\2\2\2\u08cb\u015b\3\2\2\2\u08cc\u08cd\5\u0156\u00ac\2\u08cd\u015d\3"+
		"\2\2\2\u08ce\u08cf\5\u0156\u00ac\2\u08cf\u015f\3\2\2\2\u08d0\u08d1\5\u0156"+
		"\u00ac\2\u08d1\u0161\3\2\2\2\u08d2\u08d3\5\u0156\u00ac\2\u08d3\u0163\3"+
		"\2\2\2\u08d4\u08d5\b\u00b3\1\2\u08d5\u08d8\5\u0166\u00b4\2\u08d6\u08d8"+
		"\5\u01a4\u00d3\2\u08d7\u08d4\3\2\2\2\u08d7\u08d6\3\2\2\2\u08d8\u08de\3"+
		"\2\2\2\u08d9\u08da\f\4\2\2\u08da\u08db\7\u0226\2\2\u08db\u08dd\5\u0164"+
		"\u00b3\5\u08dc\u08d9\3\2\2\2\u08dd\u08e0\3\2\2\2\u08de\u08dc\3\2\2\2\u08de"+
		"\u08df\3\2\2\2\u08df\u0165\3\2\2\2\u08e0\u08de\3\2\2\2\u08e1\u08e2\7\u0126"+
		"\2\2\u08e2\u08e3\7\u022e\2\2\u08e3\u08e4\5\u0164\u00b3\2\u08e4\u08e5\7"+
		"\u0084\2\2\u08e5\u08e8\5\u0168\u00b5\2\u08e6\u08e7\7\u0081\2\2\u08e7\u08e9"+
		"\5\u016a\u00b6\2\u08e8\u08e6\3\2\2\2\u08e8\u08e9\3\2\2\2\u08e9\u08ea\3"+
		"\2\2\2\u08ea\u08eb\7\u022f\2\2\u08eb\u0909\3\2\2\2\u08ec\u08ed\7\u0126"+
		"\2\2\u08ed\u08ee\7\u022e\2\2\u08ee\u08ef\5\u0164\u00b3\2\u08ef\u08f0\7"+
		"\u0115\2\2\u08f0\u08f1\5\u0164\u00b3\2\u08f1\u08f2\7p\2\2\u08f2\u08f3"+
		"\7\u0204\2\2\u08f3\u08f4\7\u022f\2\2\u08f4\u0909\3\2\2\2\u08f5\u08f6\t"+
		"&\2\2\u08f6\u08f7\7\u022e\2\2\u08f7\u08f8\5\u0164\u00b3\2\u08f8\u08f9"+
		"\7\u022f\2\2\u08f9\u0909\3\2\2\2\u08fa\u08fb\7\u0138\2\2\u08fb\u08fc\7"+
		"\u022e\2\2\u08fc\u08fd\5\u0164\u00b3\2\u08fd\u08fe\7\u022f\2\2\u08fe\u0909"+
		"\3\2\2\2\u08ff\u0900\7\u00ca\2\2\u0900\u0901\7\u022e\2\2\u0901\u0902\5"+
		"\u0164\u00b3\2\u0902\u0903\7\u022f\2\2\u0903\u0909\3\2\2\2\u0904\u0905"+
		"\5\u0176\u00bc\2\u0905\u0906\7\u0234\2\2\u0906\u0907\7\u011a\2\2\u0907"+
		"\u0909\3\2\2\2\u0908\u08e1\3\2\2\2\u0908\u08ec\3\2\2\2\u0908\u08f5\3\2"+
		"\2\2\u0908\u08fa\3\2\2\2\u0908\u08ff\3\2\2\2\u0908\u0904\3\2\2\2\u0909"+
		"\u0167\3\2\2\2\u090a\u090b\5\u0156\u00ac\2\u090b\u0169\3\2\2\2\u090c\u090d"+
		"\5\u0156\u00ac\2\u090d\u016b\3\2\2\2\u090e\u090f\b\u00b7\1\2\u090f\u0911"+
		"\5\u0172\u00ba\2\u0910\u0912\5\u016e\u00b8\2\u0911\u0910\3\2\2\2\u0911"+
		"\u0912\3\2\2\2\u0912\u0918\3\2\2\2\u0913\u0915\5\u01a4\u00d3\2\u0914\u0916"+
		"\5\u016e\u00b8\2\u0915\u0914\3\2\2\2\u0915\u0916\3\2\2\2\u0916\u0918\3"+
		"\2\2\2\u0917\u090e\3\2\2\2\u0917\u0913\3\2\2\2\u0918\u0921\3\2\2\2\u0919"+
		"\u091a\f\5\2\2\u091a\u091b\7\u0233\2\2\u091b\u0920\5\u0174\u00bb\2\u091c"+
		"\u091d\f\4\2\2\u091d\u091e\7\u0231\2\2\u091e\u0920\5\u0174\u00bb\2\u091f"+
		"\u0919\3\2\2\2\u091f\u091c\3\2\2\2\u0920\u0923\3\2\2\2\u0921\u091f\3\2"+
		"\2\2\u0921\u0922\3\2\2\2\u0922\u016d\3\2\2\2\u0923\u0921\3\2\2\2\u0924"+
		"\u0929\7\33\2\2\u0925\u092a\7\u00b1\2\2\u0926\u0927\7\u012f\2\2\u0927"+
		"\u0928\7\u0158\2\2\u0928\u092a\5\u0170\u00b9\2\u0929\u0925\3\2\2\2\u0929"+
		"\u0926\3\2\2\2\u092a\u016f\3\2\2\2\u092b\u092d\5\u01a4\u00d3\2\u092c\u092e"+
		"\5\u0118\u008d\2\u092d\u092c\3\2\2\2\u092d\u092e\3\2\2\2\u092e\u0935\3"+
		"\2\2\2\u092f\u0930\7\13\2\2\u0930\u0931\7\u022e\2\2\u0931\u0932\5\u0174"+
		"\u00bb\2\u0932\u0933\7\u022f\2\2\u0933\u0935\3\2\2\2\u0934\u092b\3\2\2"+
		"\2\u0934\u092f\3\2\2\2\u0935\u0171\3\2\2\2\u0936\u0954\7K\2\2\u0937\u093c"+
		"\7O\2\2\u0938\u0939\7\u022e\2\2\u0939\u093a\5\u011c\u008f\2\u093a\u093b"+
		"\7\u022f\2\2\u093b\u093d\3\2\2\2\u093c\u0938\3\2\2\2\u093c\u093d\3\2\2"+
		"\2\u093d\u0954\3\2\2\2\u093e\u0943\7P\2\2\u093f\u0940\7\u022e\2\2\u0940"+
		"\u0941\5\u011c\u008f\2\u0941\u0942\7\u022f\2\2\u0942\u0944\3\2\2\2\u0943"+
		"\u093f\3\2\2\2\u0943\u0944\3\2\2\2\u0944\u0954\3\2\2\2\u0945\u094a\7\u00b2"+
		"\2\2\u0946\u0947\7\u022e\2\2\u0947\u0948\5\u011c\u008f\2\u0948\u0949\7"+
		"\u022f\2\2\u0949\u094b\3\2\2\2\u094a\u0946\3\2\2\2\u094a\u094b\3\2\2\2"+
		"\u094b\u0954\3\2\2\2\u094c\u0951\7\u00b3\2\2\u094d\u094e\7\u022e\2\2\u094e"+
		"\u094f\5\u011c\u008f\2\u094f\u0950\7\u022f\2\2\u0950\u0952\3\2\2\2\u0951"+
		"\u094d\3\2\2\2\u0951\u0952\3\2\2\2\u0952\u0954\3\2\2\2\u0953\u0936\3\2"+
		"\2\2\u0953\u0937\3\2\2\2\u0953\u093e\3\2\2\2\u0953\u0945\3\2\2\2\u0953"+
		"\u094c\3\2\2\2\u0954\u0173\3\2\2\2\u0955\u0956\b\u00bb\1\2\u0956\u0957"+
		"\5\u0156\u00ac\2\u0957\u0958\7\u0230\2\2\u0958\u0959\5\u0174\u00bb\7\u0959"+
		"\u0971\3\2\2\2\u095a\u095c\5\u0094K\2\u095b\u095a\3\2\2\2\u095b\u095c"+
		"\3\2\2\2\u095c\u095d\3\2\2\2\u095d\u095e\7\13\2\2\u095e\u095f\7\u022e"+
		"\2\2\u095f\u0960\5\u0174\u00bb\2\u0960\u0961\7\u022f\2\2\u0961\u0971\3"+
		"\2\2\2\u0962\u0963\7\u022e\2\2\u0963\u0964\5\u016c\u00b7\2\u0964\u0965"+
		"\7\u0233\2\2\u0965\u0966\5\u016c\u00b7\2\u0966\u0967\7\u022f\2\2\u0967"+
		"\u0968\5\u0118\u008d\2\u0968\u0971\3\2\2\2\u0969\u096b\5\u0094K\2\u096a"+
		"\u0969\3\2\2\2\u096a\u096b\3\2\2\2\u096b\u096c\3\2\2\2\u096c\u096e\5\u01a4"+
		"\u00d3\2\u096d\u096f\5\u0118\u008d\2\u096e\u096d\3\2\2\2\u096e\u096f\3"+
		"\2\2\2\u096f\u0971\3\2\2\2\u0970\u0955\3\2\2\2\u0970\u095b\3\2\2\2\u0970"+
		"\u0962\3\2\2\2\u0970\u096a\3\2\2\2\u0971\u097c\3\2\2\2\u0972\u0973\f\5"+
		"\2\2\u0973\u0974\5\u0082B\2\u0974\u0975\5\u0174\u00bb\6\u0975\u097b\3"+
		"\2\2\2\u0976\u0977\f\6\2\2\u0977\u0978\5\u0080A\2\u0978\u0979\5\u0156"+
		"\u00ac\2\u0979\u097b\3\2\2\2\u097a\u0972\3\2\2\2\u097a\u0976\3\2\2\2\u097b"+
		"\u097e\3\2\2\2\u097c\u097a\3\2\2\2\u097c\u097d\3\2\2\2\u097d\u0175\3\2"+
		"\2\2\u097e\u097c\3\2\2\2\u097f\u0980\5\u01a4\u00d3\2\u0980\u0177\3\2\2"+
		"\2\u0981\u0982\5\u01a4\u00d3\2\u0982\u0179\3\2\2\2\u0983\u0984\b\u00be"+
		"\1\2\u0984\u0985\5\u01a4\u00d3\2\u0985\u098b\3\2\2\2\u0986\u0987\f\3\2"+
		"\2\u0987\u0988\7\u0226\2\2\u0988\u098a\5\u017a\u00be\4\u0989\u0986\3\2"+
		"\2\2\u098a\u098d\3\2\2\2\u098b\u0989\3\2\2\2\u098b\u098c\3\2\2\2\u098c"+
		"\u017b\3\2\2\2\u098d\u098b\3\2\2\2\u098e\u098f\b\u00bf\1\2\u098f\u0990"+
		"\7\u0114\2\2\u0990\u0991\7\u022e\2\2\u0991\u0992\5\u017c\u00bf\2\u0992"+
		"\u0993\7\u022f\2\2\u0993\u0996\3\2\2\2\u0994\u0996\5\u01a4\u00d3\2\u0995"+
		"\u098e\3\2\2\2\u0995\u0994\3\2\2\2\u0996\u09aa\3\2\2\2\u0997\u0998\f\5"+
		"\2\2\u0998\u099a\5\u008cG\2\u0999\u099b\5j\66\2\u099a\u0999\3\2\2\2\u099a"+
		"\u099b\3\2\2\2\u099b\u099c\3\2\2\2\u099c\u099d\5\u01a4\u00d3\2\u099d\u09a9"+
		"\3\2\2\2\u099e\u099f\f\4\2\2\u099f\u09a1\5\u008cG\2\u09a0\u09a2\5j\66"+
		"\2\u09a1\u09a0\3\2\2\2\u09a1\u09a2\3\2\2\2\u09a2\u09a3\3\2\2\2\u09a3\u09a4"+
		"\7\u0114\2\2\u09a4\u09a5\7\u022e\2\2\u09a5\u09a6\5\u017c\u00bf\2\u09a6"+
		"\u09a7\7\u022f\2\2\u09a7\u09a9\3\2\2\2\u09a8\u0997\3\2\2\2\u09a8\u099e"+
		"\3\2\2\2\u09a9\u09ac\3\2\2\2\u09aa\u09a8\3\2\2\2\u09aa\u09ab\3\2\2\2\u09ab"+
		"\u017d\3\2\2\2\u09ac\u09aa\3\2\2\2\u09ad\u09ae\b\u00c0\1\2\u09ae\u09af"+
		"\7\u00cc\2\2\u09af\u09b9\5\u017e\u00c0\5\u09b0\u09b6\5\u0180\u00c1\2\u09b1"+
		"\u09b3\7\u00a5\2\2\u09b2\u09b4\7\u00cc\2\2\u09b3\u09b2\3\2\2\2\u09b3\u09b4"+
		"\3\2\2\2\u09b4\u09b5\3\2\2\2\u09b5\u09b7\7\3\2\2\u09b6\u09b1\3\2\2\2\u09b6"+
		"\u09b7\3\2\2\2\u09b7\u09b9\3\2\2\2\u09b8\u09ad\3\2\2\2\u09b8\u09b0\3\2"+
		"\2\2\u09b9\u09c0\3\2\2\2\u09ba\u09bb\f\4\2\2\u09bb\u09bc\5\u0084C\2\u09bc"+
		"\u09bd\5\u017e\u00c0\5\u09bd\u09bf\3\2\2\2\u09be\u09ba\3\2\2\2\u09bf\u09c2"+
		"\3\2\2\2\u09c0\u09be\3\2\2\2\u09c0\u09c1\3\2\2\2\u09c1\u017f\3\2\2\2\u09c2"+
		"\u09c0\3\2\2\2\u09c3\u09c4\5\u01a0\u00d1\2\u09c4\u09c5\5\u0182\u00c2\2"+
		"\u09c5\u0a04\3\2\2\2\u09c6\u09c7\5\u01a0\u00d1\2\u09c7\u09c8\5\u0184\u00c3"+
		"\2\u09c8\u0a04\3\2\2\2\u09c9\u09ca\5\u01a0\u00d1\2\u09ca\u09cb\5\u0186"+
		"\u00c4\2\u09cb\u0a04\3\2\2\2\u09cc\u09cd\5\u01a0\u00d1\2\u09cd\u09ce\5"+
		"\u0188\u00c5\2\u09ce\u0a04\3\2\2\2\u09cf\u09d0\5\u01a0\u00d1\2\u09d0\u09d1"+
		"\5\u018a\u00c6\2\u09d1\u0a04\3\2\2\2\u09d2\u09d3\5\u01a0\u00d1\2\u09d3"+
		"\u09d4\5\u018c\u00c7\2\u09d4\u0a04\3\2\2\2\u09d5\u09d6\5\u01a0\u00d1\2"+
		"\u09d6\u09d7\5\u018e\u00c8\2\u09d7\u0a04\3\2\2\2\u09d8\u09d9\7v\2\2\u09d9"+
		"\u09da\7\u022e\2\2\u09da\u09db\5\u0140\u00a1\2\u09db\u09dc\7\u022f\2\2"+
		"\u09dc\u0a04\3\2\2\2\u09dd\u09de\7\u013f\2\2\u09de\u09df\7\u022e\2\2\u09df"+
		"\u09e0\5\u0140\u00a1\2\u09e0\u09e1\7\u022f\2\2\u09e1\u0a04\3\2\2\2\u09e2"+
		"\u09e3\5\u0164\u00b3\2\u09e3\u09e5\7\u00a5\2\2\u09e4\u09e6\7\u00cc\2\2"+
		"\u09e5\u09e4\3\2\2\2\u09e5\u09e6\3\2\2\2\u09e6\u09e7\3\2\2\2\u09e7\u09e8"+
		"\7\u00cb\2\2\u09e8\u0a04\3\2\2\2\u09e9\u09ea\5\u01a0\u00d1\2\u09ea\u09eb"+
		"\5\u0190\u00c9\2\u09eb\u0a04\3\2\2\2\u09ec\u09ed\5\u01a0\u00d1\2\u09ed"+
		"\u09ee\5\u0192\u00ca\2\u09ee\u0a04\3\2\2\2\u09ef\u09f0\5\u01a0\u00d1\2"+
		"\u09f0\u09f1\5\u0194\u00cb\2\u09f1\u0a04\3\2\2\2\u09f2\u09f3\5\u01a0\u00d1"+
		"\2\u09f3\u09f4\5\u0196\u00cc\2\u09f4\u0a04\3\2\2\2\u09f5\u09f6\5\u01a0"+
		"\u00d1\2\u09f6\u09f7\5\u0198\u00cd\2\u09f7\u0a04\3\2\2\2\u09f8\u09f9\5"+
		"\u01a0\u00d1\2\u09f9\u09fa\5\u019a\u00ce\2\u09fa\u0a04\3\2\2\2\u09fb\u09fc"+
		"\5\u01a0\u00d1\2\u09fc\u09fd\5\u019c\u00cf\2\u09fd\u0a04\3\2\2\2\u09fe"+
		"\u09ff\7\u022e\2\2\u09ff\u0a00\5\u017e\u00c0\2\u0a00\u0a01\7\u022f\2\2"+
		"\u0a01\u0a04\3\2\2\2\u0a02\u0a04\5\u01a4\u00d3\2\u0a03\u09c3\3\2\2\2\u0a03"+
		"\u09c6\3\2\2\2\u0a03\u09c9\3\2\2\2\u0a03\u09cc\3\2\2\2\u0a03\u09cf\3\2"+
		"\2\2\u0a03\u09d2\3\2\2\2\u0a03\u09d5\3\2\2\2\u0a03\u09d8\3\2\2\2\u0a03"+
		"\u09dd\3\2\2\2\u0a03\u09e2\3\2\2\2\u0a03\u09e9\3\2\2\2\u0a03\u09ec\3\2"+
		"\2\2\u0a03\u09ef\3\2\2\2\u0a03\u09f2\3\2\2\2\u0a03\u09f5\3\2\2\2\u0a03"+
		"\u09f8\3\2\2\2\u0a03\u09fb\3\2\2\2\u0a03\u09fe\3\2\2\2\u0a03\u0a02\3\2"+
		"\2\2\u0a04\u0181\3\2\2\2\u0a05\u0a06\5\u0092J\2\u0a06\u0a07\5\u01a0\u00d1"+
		"\2\u0a07\u0183\3\2\2\2\u0a08\u0a0a\7\u00cc\2\2\u0a09\u0a08\3\2\2\2\u0a09"+
		"\u0a0a\3\2\2\2\u0a0a\u0a0b\3\2\2\2\u0a0b\u0a0d\7\"\2\2\u0a0c\u0a0e\5f"+
		"\64\2\u0a0d\u0a0c\3\2\2\2\u0a0d\u0a0e\3\2\2\2\u0a0e\u0a0f\3\2\2\2\u0a0f"+
		"\u0a10\5\u01a0\u00d1\2\u0a10\u0a11\7\23\2\2\u0a11\u0a12\5\u01a0\u00d1"+
		"\2\u0a12\u0185\3\2\2\2\u0a13\u0a15\7\u00cc\2\2\u0a14\u0a13\3\2\2\2\u0a14"+
		"\u0a15\3\2\2\2\u0a15\u0a16\3\2\2\2\u0a16\u0a23\7\u0094\2\2\u0a17\u0a1c"+
		"\5\u01a2\u00d2\2\u0a18\u0a19\7\u0232\2\2\u0a19\u0a1b\5\u01a2\u00d2\2\u0a1a"+
		"\u0a18\3\2\2\2\u0a1b\u0a1e\3\2\2\2\u0a1c\u0a1a\3\2\2\2\u0a1c\u0a1d\3\2"+
		"\2\2\u0a1d\u0a24\3\2\2\2\u0a1e\u0a1c\3\2\2\2\u0a1f\u0a20\7\u022e\2\2\u0a20"+
		"\u0a21\5\u0140\u00a1\2\u0a21\u0a22\7\u022f\2\2\u0a22\u0a24\3\2\2\2\u0a23"+
		"\u0a17\3\2\2\2\u0a23\u0a1f\3\2\2\2\u0a24\u0187\3\2\2\2\u0a25\u0a27\7\u00cc"+
		"\2\2\u0a26\u0a25\3\2\2\2\u0a26\u0a27\3\2\2\2\u0a27\u0a28\3\2\2\2\u0a28"+
		"\u0a29\7\u00af\2\2\u0a29\u0a2c\5\u0164\u00b3\2\u0a2a\u0a2b\7p\2\2\u0a2b"+
		"\u0a2d\7\u0204\2\2\u0a2c\u0a2a\3\2\2\2\u0a2c\u0a2d\3\2\2\2\u0a2d\u0189"+
		"\3\2\2\2\u0a2e\u0a30\7\u00cc\2\2\u0a2f\u0a2e\3\2\2\2\u0a2f\u0a30\3\2\2"+
		"\2\u0a30\u0a31\3\2\2\2\u0a31\u0a32\7\u0115\2\2\u0a32\u0a33\7\u0133\2\2"+
		"\u0a33\u0a36\5\u0164\u00b3\2\u0a34\u0a35\7p\2\2\u0a35\u0a37\7\u0204\2"+
		"\2\u0a36\u0a34\3\2\2\2\u0a36\u0a37\3\2\2\2\u0a37\u018b\3\2\2\2\u0a38\u0a3a"+
		"\7\u00a5\2\2\u0a39\u0a3b\7\u00cc\2\2\u0a3a\u0a39\3\2\2\2\u0a3a\u0a3b\3"+
		"\2\2\2\u0a3b\u0a3c\3\2\2\2\u0a3c\u0a3d\7\u00cd\2\2\u0a3d\u018d\3\2\2\2"+
		"\u0a3e\u0a3f\5\u0092J\2\u0a3f\u0a40\5h\65\2\u0a40\u0a41\7\u022e\2\2\u0a41"+
		"\u0a42\5\u0140\u00a1\2\u0a42\u0a43\7\u022f\2\2\u0a43\u018f\3\2\2\2\u0a44"+
		"\u0a46\7\u00b6\2\2\u0a45\u0a47\7\u013f\2\2\u0a46\u0a45\3\2\2\2\u0a46\u0a47"+
		"\3\2\2\2\u0a47\u0a48\3\2\2\2\u0a48\u0a49\5J&\2\u0a49\u0a4a\7\u022e\2\2"+
		"\u0a4a\u0a4b\5\u0140\u00a1\2\u0a4b\u0a4c\7\u022f\2\2\u0a4c\u0191\3\2\2"+
		"\2\u0a4d\u0a4e\7\u00e0\2\2\u0a4e\u0a4f\5\u01a0\u00d1\2\u0a4f\u0193\3\2"+
		"\2\2\u0a50\u0a51\7\u00a5\2\2\u0a51\u0a52\7g\2\2\u0a52\u0a53\7\u0084\2"+
		"\2\u0a53\u0a54\5\u01a0\u00d1\2\u0a54\u0195\3\2\2\2\u0a55\u0a57\7\u00cc"+
		"\2\2\u0a56\u0a55\3\2\2\2\u0a56\u0a57\3\2\2\2\u0a57\u0a58\3\2\2\2\u0a58"+
		"\u0a5a\7\u00b8\2\2\u0a59\u0a5b\7\u00d2\2\2\u0a5a\u0a59\3\2\2\2\u0a5a\u0a5b"+
		"\3\2\2\2\u0a5b\u0a5c\3\2\2\2\u0a5c\u0a5d\5\u017c\u00bf\2\u0a5d\u0197\3"+
		"\2\2\2\u0a5e\u0a60\7\u00cc\2\2\u0a5f\u0a5e\3\2\2\2\u0a5f\u0a60\3\2\2\2"+
		"\u0a60\u0a61\3\2\2\2\u0a61\u0a62\7\u0125\2\2\u0a62\u0a63\7\u00d2\2\2\u0a63"+
		"\u0a64\5\u017c\u00bf\2\u0a64\u0199\3\2\2\2\u0a65\u0a67\7\u00a5\2\2\u0a66"+
		"\u0a68\7\u00cc\2\2\u0a67\u0a66\3\2\2\2\u0a67\u0a68\3\2\2\2\u0a68\u0a69"+
		"\3\2\2\2\u0a69\u0a6a\7\n\2\2\u0a6a\u0a6b\7\u0114\2\2\u0a6b\u019b\3\2\2"+
		"\2\u0a6c\u0a6e\7\u00a5\2\2\u0a6d\u0a6f\7\u00cc\2\2\u0a6e\u0a6d\3\2\2\2"+
		"\u0a6e\u0a6f\3\2\2\2\u0a6f\u0a70\3\2\2\2\u0a70\u0a71\7\u00d2\2\2\u0a71"+
		"\u0a72\7\u022e\2\2\u0a72\u0a77\5\u019e\u00d0\2\u0a73\u0a74\7\u0232\2\2"+
		"\u0a74\u0a76\5\u019e\u00d0\2\u0a75\u0a73\3\2\2\2\u0a76\u0a79\3\2\2\2\u0a77"+
		"\u0a75\3\2\2\2\u0a77\u0a78\3\2\2\2\u0a78\u0a7a\3\2\2\2\u0a79\u0a77\3\2"+
		"\2\2\u0a7a\u0a7b\7\u022f\2\2\u0a7b\u019d\3\2\2\2\u0a7c\u0a7e\7\u00d5\2"+
		"\2\u0a7d\u0a7c\3\2\2\2\u0a7d\u0a7e\3\2\2\2\u0a7e\u0a7f\3\2\2\2\u0a7f\u0a80"+
		"\5\62\32\2\u0a80\u019f\3\2\2\2\u0a81\u0a84\5\u0154\u00ab\2\u0a82\u0a84"+
		"\5\u01a2\u00d2\2\u0a83\u0a81\3\2\2\2\u0a83\u0a82\3\2\2\2\u0a84\u01a1\3"+
		"\2\2\2\u0a85\u0aa1\5\u01a4\u00d3\2\u0a86\u0a87\7\u022e\2\2\u0a87\u0a8a"+
		"\5\u0152\u00aa\2\u0a88\u0a89\7\u0232\2\2\u0a89\u0a8b\5\u0152\u00aa\2\u0a8a"+
		"\u0a88\3\2\2\2\u0a8b\u0a8c\3\2\2\2\u0a8c\u0a8a\3\2\2\2\u0a8c\u0a8d\3\2"+
		"\2\2\u0a8d\u0a8e\3\2\2\2\u0a8e\u0a8f\7\u022f\2\2\u0a8f\u0aa1\3\2\2\2\u0a90"+
		"\u0a91\7\u0108\2\2\u0a91\u0a92\7\u022e\2\2\u0a92\u0a97\5\u0152\u00aa\2"+
		"\u0a93\u0a94\7\u0232\2\2\u0a94\u0a96\5\u0152\u00aa\2\u0a95\u0a93\3\2\2"+
		"\2\u0a96\u0a99\3\2\2\2\u0a97\u0a95\3\2\2\2\u0a97\u0a98\3\2\2\2\u0a98\u0a9a"+
		"\3\2\2\2\u0a99\u0a97\3\2\2\2\u0a9a\u0a9b\7\u022f\2\2\u0a9b\u0aa1\3\2\2"+
		"\2\u0a9c\u0a9d\7\u022e\2\2\u0a9d\u0a9e\5\u0140\u00a1\2\u0a9e\u0a9f\7\u022f"+
		"\2\2\u0a9f\u0aa1\3\2\2\2\u0aa0\u0a85\3\2\2\2\u0aa0\u0a86\3\2\2\2\u0aa0"+
		"\u0a90\3\2\2\2\u0aa0\u0a9c\3\2\2\2\u0aa1\u01a3\3\2\2\2\u0aa2\u0aa3\b\u00d3"+
		"\1\2\u0aa3\u0ac3\5\u0200\u0101\2\u0aa4\u0ac3\5\u020a\u0106\2\u0aa5\u0ac3"+
		"\5\u01a6\u00d4\2\u0aa6\u0ac3\5\u01f6\u00fc\2\u0aa7\u0ac3\5\u01f8\u00fd"+
		"\2\u0aa8\u0ac3\5\u01d2\u00ea\2\u0aa9\u0ac3\5\u01dc\u00ef\2\u0aaa\u0ac3"+
		"\5\u01b6\u00dc\2\u0aab\u0ac3\5\u01b8\u00dd\2\u0aac\u0ac3\5\u01d0\u00e9"+
		"\2\u0aad\u0ac3\5\u01e0\u00f1\2\u0aae\u0ac3\5\u01e2\u00f2\2\u0aaf\u0ac3"+
		"\5\u01ee\u00f8\2\u0ab0\u0ac3\5\u01f0\u00f9\2\u0ab1\u0ac3\5\u01f4\u00fb"+
		"\2\u0ab2\u0ab3\7\u022e\2\2\u0ab3\u0ab4\5\u017a\u00be\2\u0ab4\u0ab5\7\u0226"+
		"\2\2\u0ab5\u0ab6\5\u017a\u00be\2\u0ab6\u0ab7\7\u022f\2\2\u0ab7\u0ab8\7"+
		"\u023c\2\2\u0ab8\u0ab9\5\u0156\u00ac\2\u0ab9\u0aba\7\u023d\2\2\u0aba\u0ac3"+
		"\3\2\2\2\u0abb\u0ac3\5\u01fa\u00fe\2\u0abc\u0ac3\5\u01f2\u00fa\2\u0abd"+
		"\u0ac3\5\u01fc\u00ff\2\u0abe\u0abf\7\u022e\2\2\u0abf\u0ac0\5\u01a4\u00d3"+
		"\2\u0ac0\u0ac1\7\u022f\2\2\u0ac1\u0ac3\3\2\2\2\u0ac2\u0aa2\3\2\2\2\u0ac2"+
		"\u0aa4\3\2\2\2\u0ac2\u0aa5\3\2\2\2\u0ac2\u0aa6\3\2\2\2\u0ac2\u0aa7\3\2"+
		"\2\2\u0ac2\u0aa8\3\2\2\2\u0ac2\u0aa9\3\2\2\2\u0ac2\u0aaa\3\2\2\2\u0ac2"+
		"\u0aab\3\2\2\2\u0ac2\u0aac\3\2\2\2\u0ac2\u0aad\3\2\2\2\u0ac2\u0aae\3\2"+
		"\2\2\u0ac2\u0aaf\3\2\2\2\u0ac2\u0ab0\3\2\2\2\u0ac2\u0ab1\3\2\2\2\u0ac2"+
		"\u0ab2\3\2\2\2\u0ac2\u0abb\3\2\2\2\u0ac2\u0abc\3\2\2\2\u0ac2\u0abd\3\2"+
		"\2\2\u0ac2\u0abe\3\2\2\2\u0ac3\u0ad6\3\2\2\2\u0ac4\u0ac5\f\16\2\2\u0ac5"+
		"\u0ac6\7\u0234\2\2\u0ac6\u0ac7\5$\23\2\u0ac7\u0ac8\5\u01e4\u00f3\2\u0ac8"+
		"\u0ad5\3\2\2\2\u0ac9\u0aca\f\n\2\2\u0aca\u0acb\7\u0222\2\2\u0acb\u0acd"+
		"\7\u0159\2\2\u0acc\u0ace\5\u01e4\u00f3\2\u0acd\u0acc\3\2\2\2\u0acd\u0ace"+
		"\3\2\2\2\u0ace\u0ad5\3\2\2\2\u0acf\u0ad0\f\7\2\2\u0ad0\u0ad1\7\u023c\2"+
		"\2\u0ad1\u0ad2\5\u0156\u00ac\2\u0ad2\u0ad3\7\u023d\2\2\u0ad3\u0ad5\3\2"+
		"\2\2\u0ad4\u0ac4\3\2\2\2\u0ad4\u0ac9\3\2\2\2\u0ad4\u0acf\3\2\2\2\u0ad5"+
		"\u0ad8\3\2\2\2\u0ad6\u0ad4\3\2\2\2\u0ad6\u0ad7\3\2\2\2\u0ad7\u01a5\3\2"+
		"\2\2\u0ad8\u0ad6\3\2\2\2\u0ad9\u0ada\7E\2\2\u0ada\u0adb\7\u022e\2\2\u0adb"+
		"\u0adc\7\u0230\2\2\u0adc\u0ade\7\u022f\2\2\u0add\u0adf\5\u01b4\u00db\2"+
		"\u0ade\u0add\3\2\2\2\u0ade\u0adf\3\2\2\2\u0adf\u0b04\3\2\2\2\u0ae0\u0ae1"+
		"\5v<\2\u0ae1\u0ae3\7\u022e\2\2\u0ae2\u0ae4\5j\66\2\u0ae3\u0ae2\3\2\2\2"+
		"\u0ae3\u0ae4\3\2\2\2\u0ae4\u0ae5\3\2\2\2\u0ae5\u0ae6\5\u0152\u00aa\2\u0ae6"+
		"\u0ae8\7\u022f\2\2\u0ae7\u0ae9\5\u01b4\u00db\2\u0ae8\u0ae7\3\2\2\2\u0ae8"+
		"\u0ae9\3\2\2\2\u0ae9\u0b04\3\2\2\2\u0aea\u0aeb\5x=\2\u0aeb\u0aec\7\u022e"+
		"\2\2\u0aec\u0aed\5\u01aa\u00d6\2\u0aed\u0aee\7\u0232\2\2\u0aee\u0aef\5"+
		"\u01ac\u00d7\2\u0aef\u0af1\7\u022f\2\2\u0af0\u0af2\5\u01b4\u00db\2\u0af1"+
		"\u0af0\3\2\2\2\u0af1\u0af2\3\2\2\2\u0af2\u0b04\3\2\2\2\u0af3\u0af4\5t"+
		";\2\u0af4\u0af5\7\u022e\2\2\u0af5\u0af6\5\u01a8\u00d5\2\u0af6\u0af7\7"+
		"\u022f\2\2\u0af7\u0af9\5\u01ae\u00d8\2\u0af8\u0afa\5\u01b4\u00db\2\u0af9"+
		"\u0af8\3\2\2\2\u0af9\u0afa\3\2\2\2\u0afa\u0b04\3\2\2\2\u0afb\u0afc\5z"+
		">\2\u0afc\u0afd\7\u022e\2\2\u0afd\u0afe\5\u0156\u00ac\2\u0afe\u0aff\7"+
		"\u022f\2\2\u0aff\u0b01\5\u01ae\u00d8\2\u0b00\u0b02\5\u01b4\u00db\2\u0b01"+
		"\u0b00\3\2\2\2\u0b01\u0b02\3\2\2\2\u0b02\u0b04\3\2\2\2\u0b03\u0ad9\3\2"+
		"\2\2\u0b03\u0ae0\3\2\2\2\u0b03\u0aea\3\2\2\2\u0b03\u0af3\3\2\2\2\u0b03"+
		"\u0afb\3\2\2\2\u0b04\u01a7\3\2\2\2\u0b05\u0b0a\5\u0152\u00aa\2\u0b06\u0b07"+
		"\7\u0232\2\2\u0b07\u0b09\5\u0152\u00aa\2\u0b08\u0b06\3\2\2\2\u0b09\u0b0c"+
		"\3\2\2\2\u0b0a\u0b08\3\2\2\2\u0b0a\u0b0b\3\2\2\2\u0b0b\u01a9\3\2\2\2\u0b0c"+
		"\u0b0a\3\2\2\2\u0b0d\u0b0e\5\u0156\u00ac\2\u0b0e\u01ab\3\2\2\2\u0b0f\u0b10"+
		"\5\u0156\u00ac\2\u0b10\u01ad\3\2\2\2\u0b11\u0b12\7\u0154\2\2\u0b12\u0b13"+
		"\7\u008d\2\2\u0b13\u0b14\7\u022e\2\2\u0b14\u0b15\7\u00da\2\2\u0b15\u0b16"+
		"\7(\2\2\u0b16\u0b17\5\u01b0\u00d9\2\u0b17\u0b18\7\u022f\2\2\u0b18\u01af"+
		"\3\2\2\2\u0b19\u0b1e\5\u01b2\u00da\2\u0b1a\u0b1b\7\u0232\2\2\u0b1b\u0b1d"+
		"\5\u01b2\u00da\2\u0b1c\u0b1a\3\2\2\2\u0b1d\u0b20\3\2\2\2\u0b1e\u0b1c\3"+
		"\2\2\2\u0b1e\u0b1f\3\2\2\2\u0b1f\u01b1\3\2\2\2\u0b20\u0b1e\3\2\2\2\u0b21"+
		"\u0b23\5\u0152\u00aa\2\u0b22\u0b24\5p9\2\u0b23\u0b22\3\2\2\2\u0b23\u0b24"+
		"\3\2\2\2\u0b24\u0b26\3\2\2\2\u0b25\u0b27\5r:\2\u0b26\u0b25\3\2\2\2\u0b26"+
		"\u0b27\3\2\2\2\u0b27\u01b3\3\2\2\2\u0b28\u0b29\7|\2\2\u0b29\u0b2a\7\u022e"+
		"\2\2\u0b2a\u0b2b\7\u0150\2\2\u0b2b\u0b2c\5\u017e\u00c0\2\u0b2c\u0b2d\7"+
		"\u022f\2\2\u0b2d\u01b5\3\2\2\2\u0b2e\u0b2f\7\u008e\2\2\u0b2f\u0b30\7\u022e"+
		"\2\2\u0b30\u0b35\5<\37\2\u0b31\u0b32\7\u0232\2\2\u0b32\u0b34\5<\37\2\u0b33"+
		"\u0b31\3\2\2\2\u0b34\u0b37\3\2\2\2\u0b35\u0b33\3\2\2\2\u0b35\u0b36\3\2"+
		"\2\2\u0b36\u0b38\3\2\2\2\u0b37\u0b35\3\2\2\2\u0b38\u0b39\7\u022f\2\2\u0b39"+
		"\u01b7\3\2\2\2\u0b3a\u0b3b\5\u01ba\u00de\2\u0b3b\u0b41\7\u00df\2\2\u0b3c"+
		"\u0b42\5 \21\2\u0b3d\u0b3e\7\u022e\2\2\u0b3e\u0b3f\5\u01be\u00e0\2\u0b3f"+
		"\u0b40\7\u022f\2\2\u0b40\u0b42\3\2\2\2\u0b41\u0b3c\3\2\2\2\u0b41\u0b3d"+
		"\3\2\2\2\u0b42\u01b9\3\2\2\2\u0b43\u0b44\5t;\2\u0b44\u0b45\7\u022e\2\2"+
		"\u0b45\u0b46\7\u022f\2\2\u0b46\u0b4c\3\2\2\2\u0b47\u0b48\7\u0109\2\2\u0b48"+
		"\u0b49\7\u022e\2\2\u0b49\u0b4c\7\u022f\2\2\u0b4a\u0b4c\5\u01a6\u00d4\2"+
		"\u0b4b\u0b43\3\2\2\2\u0b4b\u0b47\3\2\2\2\u0b4b\u0b4a\3\2\2\2\u0b4c\u01bb"+
		"\3\2\2\2\u0b4d\u0b4e\5 \21\2\u0b4e\u0b4f\7\27\2\2\u0b4f\u0b50\5\u01be"+
		"\u00e0\2\u0b50\u01bd\3\2\2\2\u0b51\u0b53\5 \21\2\u0b52\u0b51\3\2\2\2\u0b52"+
		"\u0b53\3\2\2\2\u0b53\u0b55\3\2\2\2\u0b54\u0b56\5\u01c0\u00e1\2\u0b55\u0b54"+
		"\3\2\2\2\u0b55\u0b56\3\2\2\2\u0b56\u0b58\3\2\2\2\u0b57\u0b59\5\u01c2\u00e2"+
		"\2\u0b58\u0b57\3\2\2\2\u0b58\u0b59\3\2\2\2\u0b59\u0b5b\3\2\2\2\u0b5a\u0b5c"+
		"\5\u01c4\u00e3\2\u0b5b\u0b5a\3\2\2\2\u0b5b\u0b5c\3\2\2\2\u0b5c\u01bf\3"+
		"\2\2\2\u0b5d\u0b5e\7\u00e3\2\2\u0b5e\u0b5f\7(\2\2\u0b5f\u0b64\5<\37\2"+
		"\u0b60\u0b61\7\u0232\2\2\u0b61\u0b63\5<\37\2\u0b62\u0b60\3\2\2\2\u0b63"+
		"\u0b66\3\2\2\2\u0b64\u0b62\3\2\2\2\u0b64\u0b65\3\2\2\2\u0b65\u01c1\3\2"+
		"\2\2\u0b66\u0b64\3\2\2\2\u0b67\u0b68\7\u00da\2\2\u0b68\u0b69\7(\2\2\u0b69"+
		"\u0b6a\5\u01b0\u00d9\2\u0b6a\u01c3\3\2\2\2\u0b6b\u0b6e\5|?\2\u0b6c\u0b6f"+
		"\5\u01c6\u00e4\2\u0b6d\u0b6f\5\u01c8\u00e5\2\u0b6e\u0b6c\3\2\2\2\u0b6e"+
		"\u0b6d\3\2\2\2\u0b6f\u0b71\3\2\2\2\u0b70\u0b72\5~@\2\u0b71\u0b70\3\2\2"+
		"\2\u0b71\u0b72\3\2\2\2\u0b72\u01c5\3\2\2\2\u0b73\u0b74\7\u013c\2\2\u0b74"+
		"\u0b7b\7\u00e8\2\2\u0b75\u0b76\5\u01fe\u0100\2\u0b76\u0b77\7\u00e8\2\2"+
		"\u0b77\u0b7b\3\2\2\2\u0b78\u0b79\7J\2\2\u0b79\u0b7b\7\u0108\2\2\u0b7a"+
		"\u0b73\3\2\2\2\u0b7a\u0b75\3\2\2\2\u0b7a\u0b78\3\2\2\2\u0b7b\u01c7\3\2"+
		"\2\2\u0b7c\u0b7d\7\"\2\2\u0b7d\u0b7e\5\u01ca\u00e6\2\u0b7e\u0b7f\7\23"+
		"\2\2\u0b7f\u0b80\5\u01cc\u00e7\2\u0b80\u01c9\3\2\2\2\u0b81\u0b82\5\u01ce"+
		"\u00e8\2\u0b82\u01cb\3\2\2\2\u0b83\u0b84\5\u01ce\u00e8\2\u0b84\u01cd\3"+
		"\2\2\2\u0b85\u0b8c\5\u01c6\u00e4\2\u0b86\u0b87\7\u013c\2\2\u0b87\u0b8c"+
		"\7\u0080\2\2\u0b88\u0b89\5\u01fe\u0100\2\u0b89\u0b8a\7\u0080\2\2\u0b8a"+
		"\u0b8c\3\2\2\2\u0b8b\u0b85\3\2\2\2\u0b8b\u0b86\3\2\2\2\u0b8b\u0b88\3\2"+
		"\2\2\u0b8c\u01cf\3\2\2\2\u0b8d\u0b8e\7\u022e\2\2\u0b8e\u0b8f\5\u0140\u00a1"+
		"\2\u0b8f\u0b90\7\u022f\2\2\u0b90\u01d1\3\2\2\2\u0b91\u0b92\7\u00ce\2\2"+
		"\u0b92\u0b93\7\u022e\2\2\u0b93\u0b94\5\u0152\u00aa\2\u0b94\u0b95\7\u0232"+
		"\2\2\u0b95\u0b96\5\u0152\u00aa\2\u0b96\u0b97\7\u022f\2\2\u0b97\u0bc1\3"+
		"\2\2\2\u0b98\u0b99\7:\2\2\u0b99\u0b9a\7\u022e\2\2\u0b9a\u0b9f\5\u0152"+
		"\u00aa\2\u0b9b\u0b9c\7\u0232\2\2\u0b9c\u0b9e\5\u0152\u00aa\2\u0b9d\u0b9b"+
		"\3\2\2\2\u0b9e\u0ba1\3\2\2\2\u0b9f\u0b9d\3\2\2\2\u0b9f\u0ba0\3\2\2\2\u0ba0"+
		"\u0ba2\3\2\2\2\u0ba1\u0b9f\3\2\2\2\u0ba2\u0ba3\7\u022f\2\2\u0ba3\u0bc1"+
		"\3\2\2\2\u0ba4\u0ba6\7.\2\2\u0ba5\u0ba7\7\u00e0\2\2\u0ba6\u0ba5\3\2\2"+
		"\2\u0ba6\u0ba7\3\2\2\2\u0ba7\u0ba8\3\2\2\2\u0ba8\u0baa\5\u01a0\u00d1\2"+
		"\u0ba9\u0bab\5\u01d4\u00eb\2\u0baa\u0ba9\3\2\2\2\u0bab\u0bac\3\2\2\2\u0bac"+
		"\u0baa\3\2\2\2\u0bac\u0bad\3\2\2\2\u0bad\u0bb0\3\2\2\2\u0bae\u0baf\7m"+
		"\2\2\u0baf\u0bb1\5\u01d8\u00ed\2\u0bb0\u0bae\3\2\2\2\u0bb0\u0bb1\3\2\2"+
		"\2\u0bb1\u0bb2\3\2\2\2\u0bb2\u0bb3\7n\2\2\u0bb3\u0bc1\3\2\2\2\u0bb4\u0bb6"+
		"\7.\2\2\u0bb5\u0bb7\5\u01d6\u00ec\2\u0bb6\u0bb5\3\2\2\2\u0bb7\u0bb8\3"+
		"\2\2\2\u0bb8\u0bb6\3\2\2\2\u0bb8\u0bb9\3\2\2\2\u0bb9\u0bbc\3\2\2\2\u0bba"+
		"\u0bbb\7m\2\2\u0bbb\u0bbd\5\u01d8\u00ed\2\u0bbc\u0bba\3\2\2\2\u0bbc\u0bbd"+
		"\3\2\2\2\u0bbd\u0bbe\3\2\2\2\u0bbe\u0bbf\7n\2\2\u0bbf\u0bc1\3\2\2\2\u0bc0"+
		"\u0b91\3\2\2\2\u0bc0\u0b98\3\2\2\2\u0bc0\u0ba4\3\2\2\2\u0bc0\u0bb4\3\2"+
		"\2\2\u0bc1\u01d3\3\2\2\2\u0bc2\u0bc3\7\u014e\2\2\u0bc3\u0bc4\5\u01da\u00ee"+
		"\2\u0bc4\u0bc5\7\u012e\2\2\u0bc5\u0bc6\5\u01d8\u00ed\2\u0bc6\u01d5\3\2"+
		"\2\2\u0bc7\u0bc8\7\u014e\2\2\u0bc8\u0bc9\5\u017e\u00c0\2\u0bc9\u0bca\7"+
		"\u012e\2\2\u0bca\u0bcb\5\u01d8\u00ed\2\u0bcb\u01d7\3\2\2\2\u0bcc\u0bcf"+
		"\5\u0152\u00aa\2\u0bcd\u0bcf\7\u00cd\2\2\u0bce\u0bcc\3\2\2\2\u0bce\u0bcd"+
		"\3\2\2\2\u0bcf\u01d9\3\2\2\2\u0bd0\u0be0\5\u01a0\u00d1\2\u0bd1\u0be0\5"+
		"\u0182\u00c2\2\u0bd2\u0be0\5\u0184\u00c3\2\u0bd3\u0be0\5\u0186\u00c4\2"+
		"\u0bd4\u0be0\5\u0188\u00c5\2\u0bd5\u0be0\5\u018a\u00c6\2\u0bd6\u0be0\5"+
		"\u018c\u00c7\2\u0bd7\u0be0\5\u018e\u00c8\2\u0bd8\u0be0\5\u0190\u00c9\2"+
		"\u0bd9\u0be0\5\u0192\u00ca\2\u0bda\u0be0\5\u0194\u00cb\2\u0bdb\u0be0\5"+
		"\u0196\u00cc\2\u0bdc\u0be0\5\u0198\u00cd\2\u0bdd\u0be0\5\u019a\u00ce\2"+
		"\u0bde\u0be0\5\u019c\u00cf\2\u0bdf\u0bd0\3\2\2\2\u0bdf\u0bd1\3\2\2\2\u0bdf"+
		"\u0bd2\3\2\2\2\u0bdf\u0bd3\3\2\2\2\u0bdf\u0bd4\3\2\2\2\u0bdf\u0bd5\3\2"+
		"\2\2\u0bdf\u0bd6\3\2\2\2\u0bdf\u0bd7\3\2\2\2\u0bdf\u0bd8\3\2\2\2\u0bdf"+
		"\u0bd9\3\2\2\2\u0bdf\u0bda\3\2\2\2\u0bdf\u0bdb\3\2\2\2\u0bdf\u0bdc\3\2"+
		"\2\2\u0bdf\u0bdd\3\2\2\2\u0bdf\u0bde\3\2\2\2\u0be0\u01db\3\2\2\2\u0be1"+
		"\u0be2\7/\2\2\u0be2\u0be3\7\u022e\2\2\u0be3\u0be4\5\u01de\u00f0\2\u0be4"+
		"\u0be5\7\27\2\2\u0be5\u0be6\5\u00e0q\2\u0be6\u0be7\7\u022f\2\2\u0be7\u01dd"+
		"\3\2\2\2\u0be8\u0bf1\5\u0152\u00aa\2\u0be9\u0bf1\7\u00cd\2\2\u0bea\u0beb"+
		"\7\26\2\2\u0beb\u0bec\7\u023c\2\2\u0bec\u0bf1\7\u023d\2\2\u0bed\u0bee"+
		"\7\u00c1\2\2\u0bee\u0bef\7\u023c\2\2\u0bef\u0bf1\7\u023d\2\2\u0bf0\u0be8"+
		"\3\2\2\2\u0bf0\u0be9\3\2\2\2\u0bf0\u0bea\3\2\2\2\u0bf0\u0bed\3\2\2\2\u0bf1"+
		"\u01df\3\2\2\2\u0bf2\u0bf3\7\u0136\2\2\u0bf3\u0bf4\7\u022e\2\2\u0bf4\u0bf5"+
		"\5\u0152\u00aa\2\u0bf5\u0bf8\7\27\2\2\u0bf6\u0bf9\5\62\32\2\u0bf7\u0bf9"+
		"\5\u00e2r\2\u0bf8\u0bf6\3\2\2\2\u0bf8\u0bf7\3\2\2\2\u0bf9\u0bfa\3\2\2"+
		"\2\u0bfa\u0bfb\7\u022f\2\2\u0bfb\u01e1\3\2\2\2\u0bfc\u0bfd\7\u022e\2\2"+
		"\u0bfd\u0bfe\5\u01a4\u00d3\2\u0bfe\u0bff\7\27\2\2\u0bff\u0c00\5\u00e0"+
		"q\2\u0c00\u0c01\7\u022f\2\2\u0c01\u0c02\7\u0234\2\2\u0c02\u0c04\5$\23"+
		"\2\u0c03\u0c05\5\u01e4\u00f3\2\u0c04\u0c03\3\2\2\2\u0c04\u0c05\3\2\2\2"+
		"\u0c05\u01e3\3\2\2\2\u0c06\u0c0f\7\u022e\2\2\u0c07\u0c0c\5\u01e6\u00f4"+
		"\2\u0c08\u0c09\7\u0232\2\2\u0c09\u0c0b\5\u01e6\u00f4\2\u0c0a\u0c08\3\2"+
		"\2\2\u0c0b\u0c0e\3\2\2\2\u0c0c\u0c0a\3\2\2\2\u0c0c\u0c0d\3\2\2\2\u0c0d"+
		"\u0c10\3\2\2\2\u0c0e\u0c0c\3\2\2\2\u0c0f\u0c07\3\2\2\2\u0c0f\u0c10\3\2"+
		"\2\2\u0c10\u0c11\3\2\2\2\u0c11\u0c12\7\u022f\2\2\u0c12\u01e5\3\2\2\2\u0c13"+
		"\u0c1f\5\u0152\u00aa\2\u0c14\u0c1f\5\u01e8\u00f5\2\u0c15\u0c1f\5\u01ea"+
		"\u00f6\2\u0c16\u0c1f\7\\\2\2\u0c17\u0c1f\7\u00cd\2\2\u0c18\u0c19\7\26"+
		"\2\2\u0c19\u0c1a\7\u023c\2\2\u0c1a\u0c1f\7\u023d\2\2\u0c1b\u0c1c\7\u00c1"+
		"\2\2\u0c1c\u0c1d\7\u023c\2\2\u0c1d\u0c1f\7\u023d\2\2\u0c1e\u0c13\3\2\2"+
		"\2\u0c1e\u0c14\3\2\2\2\u0c1e\u0c15\3\2\2\2\u0c1e\u0c16\3\2\2\2\u0c1e\u0c17"+
		"\3\2\2\2\u0c1e\u0c18\3\2\2\2\u0c1e\u0c1b\3\2\2\2\u0c1f\u01e7\3\2\2\2\u0c20"+
		"\u0c21\5\u0152\u00aa\2\u0c21\u0c22\7\27\2\2\u0c22\u0c23\5\62\32\2\u0c23"+
		"\u01e9\3\2\2\2\u0c24\u0c26\5&\24\2\u0c25\u0c27\5\u0204\u0103\2\u0c26\u0c25"+
		"\3\2\2\2\u0c26\u0c27\3\2\2\2\u0c27\u0c30\3\2\2\2\u0c28\u0c30\5,\27\2\u0c29"+
		"\u0c2a\5> \2\u0c2a\u0c2b\7\u023c\2\2\u0c2b\u0c2c\5\u0206\u0104\2\u0c2c"+
		"\u0c2d\7\u023d\2\2\u0c2d\u0c30\3\2\2\2\u0c2e\u0c30\7\u023b\2\2\u0c2f\u0c24"+
		"\3\2\2\2\u0c2f\u0c28\3\2\2\2\u0c2f\u0c29\3\2\2\2\u0c2f\u0c2e\3\2\2\2\u0c30"+
		"\u01eb\3\2\2\2\u0c31\u0c33\5&\24\2\u0c32\u0c34\5\u0204\u0103\2\u0c33\u0c32"+
		"\3\2\2\2\u0c33\u0c34\3\2\2\2\u0c34\u0c37\3\2\2\2\u0c35\u0c37\5,\27\2\u0c36"+
		"\u0c31\3\2\2\2\u0c36\u0c35\3\2\2\2\u0c37\u01ed\3\2\2\2\u0c38\u0c39\5\62"+
		"\32\2\u0c39\u0c3a\7\u0229\2\2\u0c3a\u0c3c\5$\23\2\u0c3b\u0c3d\5\u01e4"+
		"\u00f3\2\u0c3c\u0c3b\3\2\2\2\u0c3c\u0c3d\3\2\2\2\u0c3d\u01ef\3\2\2\2\u0c3e"+
		"\u0c3f\7\u00c6\2\2\u0c3f\u0c40\5\u01f2\u00fa\2\u0c40\u01f1\3\2\2\2\u0c41"+
		"\u0c42\5\66\34\2\u0c42\u0c43\5\u01e4\u00f3\2\u0c43\u01f3\3\2\2\2\u0c44"+
		"\u0c45\7a\2\2\u0c45\u0c46\7\u022e\2\2\u0c46\u0c47\5\u01a4\u00d3\2\u0c47"+
		"\u0c48\7\u022f\2\2\u0c48\u01f5\3\2\2\2\u0c49\u0c4a\7\26\2\2\u0c4a\u0c4b"+
		"\7\u023c\2\2\u0c4b\u0c50\5\u0152\u00aa\2\u0c4c\u0c4d\7\u0232\2\2\u0c4d"+
		"\u0c4f\5\u0152\u00aa\2\u0c4e\u0c4c\3\2\2\2\u0c4f\u0c52\3\2\2\2\u0c50\u0c4e"+
		"\3\2\2\2\u0c50\u0c51\3\2\2\2\u0c51\u0c53\3\2\2\2\u0c52\u0c50\3\2\2\2\u0c53"+
		"\u0c54\7\u023d\2\2\u0c54\u0c60\3\2\2\2\u0c55\u0c56\7\26\2\2\u0c56\u0c57"+
		"\7\u022e\2\2\u0c57\u0c5b\5\u0140\u00a1\2\u0c58\u0c59\7\u00da\2\2\u0c59"+
		"\u0c5a\7(\2\2\u0c5a\u0c5c\5\u01b0\u00d9\2\u0c5b\u0c58\3\2\2\2\u0c5b\u0c5c"+
		"\3\2\2\2\u0c5c\u0c5d\3\2\2\2\u0c5d\u0c5e\7\u022f\2\2\u0c5e\u0c60\3\2\2"+
		"\2\u0c5f\u0c49\3\2\2\2\u0c5f\u0c55\3\2\2\2\u0c60\u01f7\3\2\2\2\u0c61\u0c62"+
		"\7\u00c1\2\2\u0c62\u0c63\7\u023c\2\2\u0c63\u0c68\5\u0152\u00aa\2\u0c64"+
		"\u0c65\7\u0232\2\2\u0c65\u0c67\5\u0152\u00aa\2\u0c66\u0c64\3\2\2\2\u0c67"+
		"\u0c6a\3\2\2\2\u0c68\u0c66\3\2\2\2\u0c68\u0c69\3\2\2\2\u0c69\u0c6b\3\2"+
		"\2\2\u0c6a\u0c68\3\2\2\2\u0c6b\u0c6c\7\u023d\2\2\u0c6c\u0c78\3\2\2\2\u0c6d"+
		"\u0c6e\7\u00c1\2\2\u0c6e\u0c6f\7\u022e\2\2\u0c6f\u0c70\5\u0140\u00a1\2"+
		"\u0c70\u0c71\7\u022f\2\2\u0c71\u0c78\3\2\2\2\u0c72\u0c73\7\u012b\2\2\u0c73"+
		"\u0c74\7\u022e\2\2\u0c74\u0c75\5\u0140\u00a1\2\u0c75\u0c76\7\u022f\2\2"+
		"\u0c76\u0c78\3\2\2\2\u0c77\u0c61\3\2\2\2\u0c77\u0c6d\3\2\2\2\u0c77\u0c72"+
		"\3\2\2\2\u0c78\u01f9\3\2\2\2\u0c79\u0c7a\7l\2\2\u0c7a\u0c7b\7\u022e\2"+
		"\2\u0c7b\u0c7c\5\u017c\u00bf\2\u0c7c\u0c7d\7\u022f\2\2\u0c7d\u01fb\3\2"+
		"\2\2\u0c7e\u0c7f\7\u00c7\2\2\u0c7f\u0c80\7\u0146\2\2\u0c80\u0c81\7\u0081"+
		"\2\2\u0c81\u0c82\5:\36\2\u0c82\u01fd\3\2\2\2\u0c83\u0c86\5\u020a\u0106"+
		"\2\u0c84\u0c86\5\u0200\u0101\2\u0c85\u0c83\3\2\2\2\u0c85\u0c84\3\2\2\2"+
		"\u0c86\u01ff\3\2\2\2\u0c87\u0c95\5\u0202\u0102\2\u0c88\u0c95\7\u023b\2"+
		"\2\u0c89\u0c95\7M\2\2\u0c8a\u0c95\7N\2\2\u0c8b\u0c95\7R\2\2\u0c8c\u0c95"+
		"\7\u0113\2\2\u0c8d\u0c95\7\u012a\2\2\u0c8e\u0c95\7\u0144\2\2\u0c8f\u0c95"+
		"\7\u0146\2\2\u0c90\u0c92\5&\24\2\u0c91\u0c93\5\u0204\u0103\2\u0c92\u0c91"+
		"\3\2\2\2\u0c92\u0c93\3\2\2\2\u0c93\u0c95\3\2\2\2\u0c94\u0c87\3\2\2\2\u0c94"+
		"\u0c88\3\2\2\2\u0c94\u0c89\3\2\2\2\u0c94\u0c8a\3\2\2\2\u0c94\u0c8b\3\2"+
		"\2\2\u0c94\u0c8c\3\2\2\2\u0c94\u0c8d\3\2\2\2\u0c94\u0c8e\3\2\2\2\u0c94"+
		"\u0c8f\3\2\2\2\u0c94\u0c90\3\2\2\2\u0c95\u0201\3\2\2\2\u0c96\u0c97\5,"+
		"\27\2\u0c97\u0203\3\2\2\2\u0c98\u0c99\7\u0096\2\2\u0c99\u0c9a\5&\24\2"+
		"\u0c9a\u0205\3\2\2\2\u0c9b\u0ca2\5\u0208\u0105\2\u0c9c\u0c9e\5&\24\2\u0c9d"+
		"\u0c9f\5\u0204\u0103\2\u0c9e\u0c9d\3\2\2\2\u0c9e\u0c9f\3\2\2\2\u0c9f\u0ca2"+
		"\3\2\2\2\u0ca0\u0ca2\5,\27\2\u0ca1\u0c9b\3\2\2\2\u0ca1\u0c9c\3\2\2\2\u0ca1"+
		"\u0ca0\3\2\2\2\u0ca2\u0207\3\2\2\2\u0ca3\u0ca5\5\u0094K\2\u0ca4\u0ca3"+
		"\3\2\2\2\u0ca4\u0ca5\3\2\2\2\u0ca5\u0ca6\3\2\2\2\u0ca6\u0ca9\5\u020c\u0107"+
		"\2\u0ca7\u0ca9\5\u0210\u0109\2\u0ca8\u0ca4\3\2\2\2\u0ca8\u0ca7\3\2\2\2"+
		"\u0ca9\u0209\3\2\2\2\u0caa\u0cad\5\u020c\u0107\2\u0cab\u0cad\5\u0210\u0109"+
		"\2\u0cac\u0caa\3\2\2\2\u0cac\u0cab\3\2\2\2\u0cad\u020b\3\2\2\2\u0cae\u0cb1"+
		"\7\u0202\2\2\u0caf\u0cb1\5\u020e\u0108\2\u0cb0\u0cae\3\2\2\2\u0cb0\u0caf"+
		"\3\2\2\2\u0cb1\u020d\3\2\2\2\u0cb2\u0cb5\7\u0203\2\2\u0cb3\u0cb4\7\u0234"+
		"\2\2\u0cb4\u0cb6\7\u0203\2\2\u0cb5\u0cb3\3\2\2\2\u0cb5\u0cb6\3\2\2\2\u0cb6"+
		"\u0cba\3\2\2\2\u0cb7\u0cb8\7\u0234\2\2\u0cb8\u0cba\7\u0203\2\2\u0cb9\u0cb2"+
		"\3\2\2\2\u0cb9\u0cb7\3\2\2\2\u0cba\u020f\3\2\2\2\u0cbb\u0cc5\7\u0204\2"+
		"\2\u0cbc\u0cc5\7\t\2\2\u0cbd\u0cc5\7\b\2\2\u0cbe\u0cc5\7\7\2\2\u0cbf\u0cc5"+
		"\7\6\2\2\u0cc0\u0cc5\7\5\2\2\u0cc1\u0cc5\7\4\2\2\u0cc2\u0cc5\5\u0212\u010a"+
		"\2\u0cc3\u0cc5\7\3\2\2\u0cc4\u0cbb\3\2\2\2\u0cc4\u0cbc\3\2\2\2\u0cc4\u0cbd"+
		"\3\2\2\2\u0cc4\u0cbe\3\2\2\2\u0cc4\u0cbf\3\2\2\2\u0cc4\u0cc0\3\2\2\2\u0cc4"+
		"\u0cc1\3\2\2\2\u0cc4\u0cc2\3\2\2\2\u0cc4\u0cc3\3\2\2\2\u0cc5\u0211\3\2"+
		"\2\2\u0cc6\u0cc8\7\u00a3\2\2\u0cc7\u0cc9\5\u0094K\2\u0cc8\u0cc7\3\2\2"+
		"\2\u0cc8\u0cc9\3\2\2\2\u0cc9\u0cca\3\2\2\2\u0cca\u0ccc\7\u0204\2\2\u0ccb"+
		"\u0ccd\5\u0118\u008d\2\u0ccc\u0ccb\3\2\2\2\u0ccc\u0ccd\3\2\2\2\u0ccd\u0213"+
		"\3\2\2\2\u0cce\u0ccf\7i\2\2\u0ccf\u0cd0\7\u013a\2\2\u0cd0\u0cd1\5\62\32"+
		"\2\u0cd1\u0cd2\5B\"\2\u0cd2\u0215\3\2\2\2\u0cd3\u0cd4\7F\2\2\u0cd4\u0cd5"+
		"\7\u013a\2\2\u0cd5\u0cd7\5\62\32\2\u0cd6\u0cd8\5\u021e\u0110\2\u0cd7\u0cd6"+
		"\3\2\2\2\u0cd7\u0cd8\3\2\2\2\u0cd8\u0ce1\3\2\2\2\u0cd9\u0cdf\7\27\2\2"+
		"\u0cda\u0ce0\5\u00e8u\2\u0cdb\u0cdc\7\u022e\2\2\u0cdc\u0cdd\5\u0220\u0111"+
		"\2\u0cdd\u0cde\7\u022f\2\2\u0cde\u0ce0\3\2\2\2\u0cdf\u0cda\3\2\2\2\u0cdf"+
		"\u0cdb\3\2\2\2\u0ce0\u0ce2\3\2\2\2\u0ce1\u0cd9\3\2\2\2\u0ce1\u0ce2\3\2"+
		"\2\2\u0ce2\u0ce4\3\2\2\2\u0ce3\u0ce5\5\u0224\u0113\2\u0ce4\u0ce3\3\2\2"+
		"\2\u0ce4\u0ce5\3\2\2\2\u0ce5\u0ce7\3\2\2\2\u0ce6\u0ce8\5\u024c\u0127\2"+
		"\u0ce7\u0ce6\3\2\2\2\u0ce7\u0ce8\3\2\2\2\u0ce8\u0217\3\2\2\2\u0ce9\u0cea"+
		"\7\21\2\2\u0cea\u0ceb\7\u013a\2\2\u0ceb\u0cec\5\62\32\2\u0cec\u0ced\5"+
		"\u021a\u010e\2\u0ced\u0219\3\2\2\2\u0cee\u0cef\7\r\2\2\u0cef\u0cf0\7\u015f"+
		"\2\2\u0cf0\u0cfd\5\u0222\u0112\2\u0cf1\u0cf2\7i\2\2\u0cf2\u0cf3\7\u015f"+
		"\2\2\u0cf3\u0cf4\5\26\f\2\u0cf4\u0cf5\7\u0100\2\2\u0cf5\u0cfd\3\2\2\2"+
		"\u0cf6\u0cf7\7\r\2\2\u0cf7\u0cfd\5\u024e\u0128\2\u0cf8\u0cf9\7i\2\2\u0cf9"+
		"\u0cfa\5\u021c\u010f\2\u0cfa\u0cfb\7\u0100\2\2\u0cfb\u0cfd\3\2\2\2\u0cfc"+
		"\u0cee\3\2\2\2\u0cfc\u0cf1\3\2\2\2\u0cfc\u0cf6\3\2\2\2\u0cfc\u0cf8\3\2"+
		"\2\2\u0cfd\u021b\3\2\2\2\u0cfe\u0d00\5d\63\2\u0cff\u0cfe\3\2\2\2\u0cff"+
		"\u0d00\3\2\2\2\u0d00\u0d01\3\2\2\2\u0d01\u0d02\7\u00ba\2\2\u0d02\u0d03"+
		"\7\u0159\2\2\u0d03\u0d0c\7\u022e\2\2\u0d04\u0d09\5\u00e0q\2\u0d05\u0d06"+
		"\7\u0232\2\2\u0d06\u0d08\5\u00e0q\2\u0d07\u0d05\3\2\2\2\u0d08\u0d0b\3"+
		"\2\2\2\u0d09\u0d07\3\2\2\2\u0d09\u0d0a\3\2\2\2\u0d0a\u0d0d\3\2\2\2\u0d0b"+
		"\u0d09\3\2\2\2\u0d0c\u0d04\3\2\2\2\u0d0c\u0d0d\3\2\2\2\u0d0d\u0d0e\3\2"+
		"\2\2\u0d0e\u0d0f\7\u022f\2\2\u0d0f\u021d\3\2\2\2\u0d10\u0d11\7\u013d\2"+
		"\2\u0d11\u0d12\5\62\32\2\u0d12\u021f\3\2\2\2\u0d13\u0d18\5\u0222\u0112"+
		"\2\u0d14\u0d15\7\u0232\2\2\u0d15\u0d17\5\u0222\u0112\2\u0d16\u0d14\3\2"+
		"\2\2\u0d17\u0d1a\3\2\2\2\u0d18\u0d16\3\2\2\2\u0d18\u0d19\3\2\2\2\u0d19"+
		"\u0221\3\2\2\2\u0d1a\u0d18\3\2\2\2\u0d1b\u0d1c\5\26\f\2\u0d1c\u0d1e\5"+
		"\u00e0q\2\u0d1d\u0d1f\5N(\2\u0d1e\u0d1d\3\2\2\2\u0d1e\u0d1f\3\2\2\2\u0d1f"+
		"\u0d21\3\2\2\2\u0d20\u0d22\5\u00dep\2\u0d21\u0d20\3\2\2\2\u0d21\u0d22"+
		"\3\2\2\2\u0d22\u0d25\3\2\2\2\u0d23\u0d24\7\\\2\2\u0d24\u0d26\5\u00ccg"+
		"\2\u0d25\u0d23\3\2\2\2\u0d25\u0d26\3\2\2\2\u0d26\u0223\3\2\2\2\u0d27\u0d29"+
		"\5\u0226\u0114\2\u0d28\u0d27\3\2\2\2\u0d29\u0d2a\3\2\2\2\u0d2a\u0d28\3"+
		"\2\2\2\u0d2a\u0d2b\3\2\2\2\u0d2b\u0225\3\2\2\2\u0d2c\u0d32\5T+\2\u0d2d"+
		"\u0d32\5V,\2\u0d2e\u0d32\5\u0228\u0115\2\u0d2f\u0d32\5\u0230\u0119\2\u0d30"+
		"\u0d32\5\u0236\u011c\2\u0d31\u0d2c\3\2\2\2\u0d31\u0d2d\3\2\2\2\u0d31\u0d2e"+
		"\3\2\2\2\u0d31\u0d2f\3\2\2\2\u0d31\u0d30\3\2\2\2\u0d32\u0227\3\2\2\2\u0d33"+
		"\u0d37\5\u022a\u0116\2\u0d34\u0d37\5\u022c\u0117\2\u0d35\u0d37\5\u022e"+
		"\u0118\2\u0d36\u0d33\3\2\2\2\u0d36\u0d34\3\2\2\2\u0d36\u0d35\3\2\2\2\u0d37"+
		"\u0229\3\2\2\2\u0d38\u0d39\7\u00f2\2\2\u0d39\u0d3a\7\u0145\2\2\u0d3a\u0d3b"+
		"\5\u00e8u\2\u0d3b\u022b\3\2\2\2\u0d3c\u0d3d\7\u00f2\2\2\u0d3d\u0d3e\7"+
		"\u0084\2\2\u0d3e\u0d3f\7\u022e\2\2\u0d3f\u0d44\5\26\f\2\u0d40\u0d41\7"+
		"\u0232\2\2\u0d41\u0d43\5\26\f\2\u0d42\u0d40\3\2\2\2\u0d43\u0d46\3\2\2"+
		"\2\u0d44\u0d42\3\2\2\2\u0d44\u0d45\3\2\2\2\u0d45\u0d47\3\2\2\2\u0d46\u0d44"+
		"\3\2\2\2\u0d47\u0d48\7\u022f\2\2\u0d48\u022d\3\2\2\2\u0d49\u0d4a\7\u00f2"+
		"\2\2\u0d4a\u0d4b\7\u00a5\2\2\u0d4b\u0d4c\7\u0129\2\2\u0d4c\u0d4d\7\u0089"+
		"\2\2\u0d4d\u022f\3\2\2\2\u0d4e\u0d51\5\u0232\u011a\2\u0d4f\u0d51\5\u0234"+
		"\u011b\2\u0d50\u0d4e\3\2\2\2\u0d50\u0d4f\3\2\2\2\u0d51\u0231\3\2\2\2\u0d52"+
		"\u0d53\7/\2\2\u0d53\u0d54\7\u022e\2\2\u0d54\u0d55\7\u01e4\2\2\u0d55\u0d56"+
		"\7\27\2\2\u0d56\u0d57\7\u00f2\2\2\u0d57\u0d58\7\u022f\2\2\u0d58\u0d59"+
		"\7\u0153\2\2\u0d59\u0d5a\5\30\r\2\u0d5a\u0233\3\2\2\2\u0d5b\u0d5c\7/\2"+
		"\2\u0d5c\u0d5d\7\u022e\2\2\u0d5d\u0d5e\7\u00f2\2\2\u0d5e\u0d5f\7\27\2"+
		"\2\u0d5f\u0d60\7\u01e4\2\2\u0d60\u0d61\7\u022f\2\2\u0d61\u0d62\7\u0153"+
		"\2\2\u0d62\u0d63\5\30\r\2\u0d63\u0235\3\2\2\2\u0d64\u0d67\5\u0238\u011d"+
		"\2\u0d65\u0d67\5\u023a\u011e\2\u0d66\u0d64\3\2\2\2\u0d66\u0d65\3\2\2\2"+
		"\u0d67\u0237\3\2\2\2\u0d68\u0d69\7/\2\2\u0d69\u0d6a\7\u022e\2\2\u0d6a"+
		"\u0d6b\7\u01e4\2\2\u0d6b\u0d6c\7\27\2\2\u0d6c\u0d6d\7g\2\2\u0d6d\u0d6e"+
		"\7\u022f\2\2\u0d6e\u0d6f\7\u0153\2\2\u0d6f\u0d70\5\30\r\2\u0d70\u0239"+
		"\3\2\2\2\u0d71\u0d72\7/\2\2\u0d72\u0d73\7\u022e\2\2\u0d73\u0d74\7g\2\2"+
		"\u0d74\u0d75\7\27\2\2\u0d75\u0d76\7\u01e4\2\2\u0d76\u0d77\7\u022f\2\2"+
		"\u0d77\u0d78\7\u0153\2\2\u0d78\u0d79\5\30\r\2\u0d79\u023b\3\2\2\2\u0d7a"+
		"\u0d7c\7i\2\2\u0d7b\u0d7d\7\u0119\2\2\u0d7c\u0d7b\3\2\2\2\u0d7c\u0d7d"+
		"\3\2\2\2\u0d7d\u0d7e\3\2\2\2\u0d7e\u0d7f\7\u00ec\2\2\u0d7f\u0d85\5\66"+
		"\34\2\u0d80\u0d82\7\u022e\2\2\u0d81\u0d83\5\u025c\u012f\2\u0d82\u0d81"+
		"\3\2\2\2\u0d82\u0d83\3\2\2\2\u0d83\u0d84\3\2\2\2\u0d84\u0d86\7\u022f\2"+
		"\2\u0d85\u0d80\3\2\2\2\u0d85\u0d86\3\2\2\2\u0d86\u0d87\3\2\2\2\u0d87\u0d88"+
		"\5B\"\2\u0d88\u023d\3\2\2\2\u0d89\u0d8b\7i\2\2\u0d8a\u0d8c\7\u0119\2\2"+
		"\u0d8b\u0d8a\3\2\2\2\u0d8b\u0d8c\3\2\2\2\u0d8c\u0d8d\3\2\2\2\u0d8d\u0d8e"+
		"\7\u0086\2\2\u0d8e\u0d94\5\66\34\2\u0d8f\u0d91\7\u022e\2\2\u0d90\u0d92"+
		"\5\u025c\u012f\2\u0d91\u0d90\3\2\2\2\u0d91\u0d92\3\2\2\2\u0d92\u0d93\3"+
		"\2\2\2\u0d93\u0d95\7\u022f\2\2\u0d94\u0d8f\3\2\2\2\u0d94\u0d95\3\2\2\2"+
		"\u0d95\u0d96\3\2\2\2\u0d96\u0d97\5B\"\2\u0d97\u023f\3\2\2\2\u0d98\u0d9a"+
		"\7i\2\2\u0d99\u0d9b\7\u0119\2\2\u0d9a\u0d99\3\2\2\2\u0d9a\u0d9b\3\2\2"+
		"\2\u0d9b\u0d9c\3\2\2\2\u0d9c\u0d9d\7\u00ba\2\2\u0d9d\u0da3\5\66\34\2\u0d9e"+
		"\u0da0\7\u022e\2\2\u0d9f\u0da1\5\u025c\u012f\2\u0da0\u0d9f\3\2\2\2\u0da0"+
		"\u0da1\3\2\2\2\u0da1\u0da2\3\2\2\2\u0da2\u0da4\7\u022f\2\2\u0da3\u0d9e"+
		"\3\2\2\2\u0da3\u0da4\3\2\2\2\u0da4\u0da5\3\2\2\2\u0da5\u0da6\7\u0081\2"+
		"\2\u0da6\u0da7\5\62\32\2\u0da7\u0da8\5B\"\2\u0da8\u0241\3\2\2\2\u0da9"+
		"\u0daa\7i\2\2\u0daa\u0dab\7\u0137\2\2\u0dab\u0dac\58\35\2\u0dac\u0243"+
		"\3\2\2\2\u0dad\u0dae\7F\2\2\u0dae\u0daf\7\u00ec\2\2\u0daf\u0db0\5\66\34"+
		"\2\u0db0\u0db2\7\u022e\2\2\u0db1\u0db3\5\u025c\u012f\2\u0db2\u0db1\3\2"+
		"\2\2\u0db2\u0db3\3\2\2\2\u0db3\u0db4\3\2\2\2\u0db4\u0db6\7\u022f\2\2\u0db5"+
		"\u0db7\5\u0270\u0139\2\u0db6\u0db5\3\2\2\2\u0db6\u0db7\3\2\2\2\u0db7\u0db8"+
		"\3\2\2\2\u0db8\u0db9\5\u0274\u013b\2\u0db9\u0245\3\2\2\2\u0dba\u0dbb\7"+
		"F\2\2\u0dbb\u0dbc\7\u0086\2\2\u0dbc\u0dbd\5\66\34\2\u0dbd\u0dbf\7\u022e"+
		"\2\2\u0dbe\u0dc0\5\u025c\u012f\2\u0dbf\u0dbe\3\2\2\2\u0dbf\u0dc0\3\2\2"+
		"\2\u0dc0\u0dc1\3\2\2\2\u0dc1\u0dc2\7\u022f\2\2\u0dc2\u0dc4\5\u0262\u0132"+
		"\2\u0dc3\u0dc5\5\u0270\u0139\2\u0dc4\u0dc3\3\2\2\2\u0dc4\u0dc5\3\2\2\2"+
		"\u0dc5\u0dc8\3\2\2\2\u0dc6\u0dc7\7\u0121\2\2\u0dc7\u0dc9\7\u018d\2\2\u0dc8"+
		"\u0dc6\3\2\2\2\u0dc8\u0dc9\3\2\2\2\u0dc9\u0dca\3\2\2\2\u0dca\u0dcb\5\u0274"+
		"\u013b\2\u0dcb\u0247\3\2\2\2\u0dcc\u0dcd\7F\2\2\u0dcd\u0dce\5d\63\2\u0dce"+
		"\u0dcf\7\u00ba\2\2\u0dcf\u0dd0\5\66\34\2\u0dd0\u0dd2\7\u022e\2\2\u0dd1"+
		"\u0dd3\5\u025c\u012f\2\u0dd2\u0dd1\3\2\2\2\u0dd2\u0dd3\3\2\2\2\u0dd3\u0dd4"+
		"\3\2\2\2\u0dd4\u0dd6\7\u022f\2\2\u0dd5\u0dd7\5\u0262\u0132\2\u0dd6\u0dd5"+
		"\3\2\2\2\u0dd6\u0dd7\3\2\2\2\u0dd7\u0dd8\3\2\2\2\u0dd8\u0dd9\7\u0081\2"+
		"\2\u0dd9\u0ddb\5\62\32\2\u0dda\u0ddc\5\u0270\u0139\2\u0ddb\u0dda\3\2\2"+
		"\2\u0ddb\u0ddc\3\2\2\2\u0ddc\u0ddd\3\2\2\2\u0ddd\u0dde\5\u0274\u013b\2"+
		"\u0dde\u0249\3\2\2\2\u0ddf\u0de0\7F\2\2\u0de0\u0de1\7\u0137\2\2\u0de1"+
		"\u0de2\58\35\2\u0de2\u0de3\5\u009eP\2\u0de3\u0de4\5\u0256\u012c\2\u0de4"+
		"\u0de5\7\u00d4\2\2\u0de5\u0dee\5.\30\2\u0de6\u0de7\7\u00f4\2\2\u0de7\u0deb"+
		"\5\u0258\u012d\2\u0de8\u0dea\5\u0258\u012d\2\u0de9\u0de8\3\2\2\2\u0dea"+
		"\u0ded\3\2\2\2\u0deb\u0de9\3\2\2\2\u0deb\u0dec\3\2\2\2\u0dec\u0def\3\2"+
		"\2\2\u0ded\u0deb\3\2\2\2\u0dee\u0de6\3\2\2\2\u0dee\u0def\3\2\2\2\u0def"+
		"\u0df0\3\2\2\2\u0df0\u0df1\5\u025a\u012e\2\u0df1\u024b\3\2\2\2\u0df2\u0df7"+
		"\5\u024e\u0128\2\u0df3\u0df4\7\u0232\2\2\u0df4\u0df6\5\u024e\u0128\2\u0df5"+
		"\u0df3\3\2\2\2\u0df6\u0df9\3\2\2\2\u0df7\u0df5\3\2\2\2\u0df7\u0df8\3\2"+
		"\2\2\u0df8\u024d\3\2\2\2\u0df9\u0df7\3\2\2\2\u0dfa\u0dfd\5\u0250\u0129"+
		"\2\u0dfb\u0dfd\5\u0252\u012a\2\u0dfc\u0dfa\3\2\2\2\u0dfc\u0dfb\3\2\2\2"+
		"\u0dfd\u024f\3\2\2\2\u0dfe\u0e02\5\u0254\u012b\2\u0dff\u0e00\7\u01dd\2"+
		"\2\u0e00\u0e01\7\27\2\2\u0e01\u0e03\7\u0101\2\2\u0e02\u0dff\3\2\2\2\u0e02"+
		"\u0e03\3\2\2\2\u0e03\u0e07\3\2\2\2\u0e04\u0e05\7\u01dd\2\2\u0e05\u0e06"+
		"\7\27\2\2\u0e06\u0e08\7\u01a4\2\2\u0e07\u0e04\3\2\2\2\u0e07\u0e08\3\2"+
		"\2\2\u0e08\u0e0a\3\2\2\2\u0e09\u0e0b\5\u0270\u0139\2\u0e0a\u0e09\3\2\2"+
		"\2\u0e0a\u0e0b\3\2\2\2\u0e0b\u0251\3\2\2\2\u0e0c\u0e0d\7\u00e1\2\2\u0e0d"+
		"\u0e0e\5\u0254\u012b\2\u0e0e\u0253\3\2\2\2\u0e0f\u0e11\5d\63\2\u0e10\u0e0f"+
		"\3\2\2\2\u0e10\u0e11\3\2\2\2\u0e11\u0e12\3\2\2\2\u0e12\u0e13\7\u00ba\2"+
		"\2\u0e13\u0e14\7\u0159\2\2\u0e14\u0e16\7\u022e\2\2\u0e15\u0e17\5\u025c"+
		"\u012f\2\u0e16\u0e15\3\2\2\2\u0e16\u0e17\3\2\2\2\u0e17\u0e18\3\2\2\2\u0e18"+
		"\u0e19\7\u022f\2\2\u0e19\u0e1c\5\u0262\u0132\2\u0e1a\u0e1b\7\u0119\2\2"+
		"\u0e1b\u0e1d\5\64\33\2\u0e1c\u0e1a\3\2\2\2\u0e1c\u0e1d\3\2\2\2\u0e1d\u0255"+
		"\3\2\2\2\u0e1e\u0e2d\7\u009c\2\2\u0e1f\u0e2d\7_\2\2\u0e20\u0e2a\7\u0142"+
		"\2\2\u0e21\u0e22\7\u00d2\2\2\u0e22\u0e27\5\24\13\2\u0e23\u0e24\7\u0232"+
		"\2\2\u0e24\u0e26\5\24\13\2\u0e25\u0e23\3\2\2\2\u0e26\u0e29\3\2\2\2\u0e27"+
		"\u0e25\3\2\2\2\u0e27\u0e28\3\2\2\2\u0e28\u0e2b\3\2\2\2\u0e29\u0e27\3\2"+
		"\2\2\u0e2a\u0e21\3\2\2\2\u0e2a\u0e2b\3\2\2\2\u0e2b\u0e2d\3\2\2\2\u0e2c"+
		"\u0e1e\3\2\2\2\u0e2c\u0e1f\3\2\2\2\u0e2c\u0e20\3\2\2\2\u0e2d\u0257\3\2"+
		"\2\2\u0e2e\u0e30\7\u00d3\2\2\u0e2f\u0e31\7\u0108\2\2\u0e30\u0e2f\3\2\2"+
		"\2\u0e30\u0e31\3\2\2\2\u0e31\u0e33\3\2\2\2\u0e32\u0e34\7\27\2\2\u0e33"+
		"\u0e32\3\2\2\2\u0e33\u0e34\3\2\2\2\u0e34\u0e35\3\2\2\2\u0e35\u0e4b\5\36"+
		"\20\2\u0e36\u0e38\7\u00c6\2\2\u0e37\u0e39\7\u0108\2\2\u0e38\u0e37\3\2"+
		"\2\2\u0e38\u0e39\3\2\2\2\u0e39\u0e3b\3\2\2\2\u0e3a\u0e3c\7\27\2\2\u0e3b"+
		"\u0e3a\3\2\2\2\u0e3b\u0e3c\3\2\2\2\u0e3c\u0e3d\3\2\2\2\u0e3d\u0e4b\5\36"+
		"\20\2\u0e3e\u0e3f\7\u00d3\2\2\u0e3f\u0e41\7\u012b\2\2\u0e40\u0e42\7\27"+
		"\2\2\u0e41\u0e40\3\2\2\2\u0e41\u0e42\3\2\2\2\u0e42\u0e43\3\2\2\2\u0e43"+
		"\u0e4b\5\36\20\2\u0e44\u0e45\7\u00c6\2\2\u0e45\u0e47\7\u012b\2\2\u0e46"+
		"\u0e48\7\27\2\2\u0e47\u0e46\3\2\2\2\u0e47\u0e48\3\2\2\2\u0e48\u0e49\3"+
		"\2\2\2\u0e49\u0e4b\5\36\20\2\u0e4a\u0e2e\3\2\2\2\u0e4a\u0e36\3\2\2\2\u0e4a"+
		"\u0e3e\3\2\2\2\u0e4a\u0e44\3\2\2\2\u0e4b\u0259\3\2\2\2\u0e4c\u0e4d\7\u0081"+
		"\2\2\u0e4d\u0e4e\7k\2\2\u0e4e\u0e50\t\'\2\2\u0e4f\u0e4c\3\2\2\2\u0e4f"+
		"\u0e50\3\2\2\2\u0e50\u0e56\3\2\2\2\u0e51\u0e52\7\u014e\2\2\u0e52\u0e53"+
		"\7\u022e\2\2\u0e53\u0e54\5\u017e\u00c0\2\u0e54\u0e55\7\u022f\2\2\u0e55"+
		"\u0e57\3\2\2\2\u0e56\u0e51\3\2\2\2\u0e56\u0e57\3\2\2\2\u0e57\u0e5e\3\2"+
		"\2\2\u0e58\u0e59\7 \2\2\u0e59\u0e5a\7\34\2\2\u0e5a\u0e5b\5\u0274\u013b"+
		"\2\u0e5b\u0e5c\7n\2\2\u0e5c\u0e5f\3\2\2\2\u0e5d\u0e5f\5\u0274\u013b\2"+
		"\u0e5e\u0e58\3\2\2\2\u0e5e\u0e5d\3\2\2\2\u0e5f\u025b\3\2\2\2\u0e60\u0e65"+
		"\5\u025e\u0130\2\u0e61\u0e62\7\u0232\2\2\u0e62\u0e64\5\u025e\u0130\2\u0e63"+
		"\u0e61\3\2\2\2\u0e64\u0e67\3\2\2\2\u0e65\u0e63\3\2\2\2\u0e65\u0e66\3\2"+
		"\2\2\u0e66\u025d\3\2\2\2\u0e67\u0e65\3\2\2\2\u0e68\u0e6a\5X-\2\u0e69\u0e68"+
		"\3\2\2\2\u0e69\u0e6a\3\2\2\2\u0e6a\u0e6c\3\2\2\2\u0e6b\u0e6d\5\32\16\2"+
		"\u0e6c\u0e6b\3\2\2\2\u0e6c\u0e6d\3\2\2\2\u0e6d\u0e6e\3\2\2\2\u0e6e\u0e70"+
		"\5\u0260\u0131\2\u0e6f\u0e71\7\u0101\2\2\u0e70\u0e6f\3\2\2\2\u0e70\u0e71"+
		"\3\2\2\2\u0e71\u025f\3\2\2\2\u0e72\u0e75\5\u00e0q\2\u0e73\u0e74\7\27\2"+
		"\2\u0e74\u0e76\7\u01a4\2\2\u0e75\u0e73\3\2\2\2\u0e75\u0e76\3\2\2\2\u0e76"+
		"\u0261\3\2\2\2\u0e77\u0e78\7\u0103\2\2\u0e78\u0e79\5\u0264\u0133\2\u0e79"+
		"\u0263\3\2\2\2\u0e7a\u0e7c\5\u0266\u0134\2\u0e7b\u0e7d\5\u0268\u0135\2"+
		"\u0e7c\u0e7b\3\2\2\2\u0e7c\u0e7d\3\2\2\2\u0e7d\u0e80\3\2\2\2\u0e7e\u0e80"+
		"\5\u026a\u0136\2\u0e7f\u0e7a\3\2\2\2\u0e7f\u0e7e\3\2\2\2\u0e80\u0265\3"+
		"\2\2\2\u0e81\u0e84\5\u00e0q\2\u0e82\u0e83\7\27\2\2\u0e83\u0e85\7\u01a4"+
		"\2\2\u0e84\u0e82\3\2\2\2\u0e84\u0e85\3\2\2\2\u0e85\u0267\3\2\2\2\u0e86"+
		"\u0e87\7/\2\2\u0e87\u0e88\7\u0084\2\2\u0e88\u0e8b\5\u00e0q\2\u0e89\u0e8a"+
		"\7\27\2\2\u0e8a\u0e8c\7\u01a4\2\2\u0e8b\u0e89\3\2\2\2\u0e8b\u0e8c\3\2"+
		"\2\2\u0e8c\u0269\3\2\2\2\u0e8d\u0e8e\7\u012b\2\2\u0e8e\u0e8f\5\u026c\u0137"+
		"\2\u0e8f\u026b\3\2\2\2\u0e90\u0e91\7\u022e\2\2\u0e91\u0e96\5\u026e\u0138"+
		"\2\u0e92\u0e93\7\u0232\2\2\u0e93\u0e95\5\u026e\u0138\2\u0e94\u0e92\3\2"+
		"\2\2\u0e95\u0e98\3\2\2\2\u0e96\u0e94\3\2\2\2\u0e96\u0e97\3\2\2\2\u0e97"+
		"\u0e99\3\2\2\2\u0e98\u0e96\3\2\2\2\u0e99\u0e9a\7\u022f\2\2\u0e9a\u026d"+
		"\3\2\2\2\u0e9b\u0e9c\5\24\13\2\u0e9c\u0e9d\5\u00e0q\2\u0e9d\u026f\3\2"+
		"\2\2\u0e9e\u0ea0\5\u0272\u013a\2\u0e9f\u0e9e\3\2\2\2\u0ea0\u0ea1\3\2\2"+
		"\2\u0ea1\u0e9f\3\2\2\2\u0ea1\u0ea2\3\2\2\2\u0ea2\u0271\3\2\2\2\u0ea3\u0ea4"+
		"\7\u00aa\2\2\u0ea4\u0eac\5Z.\2\u0ea5\u0ea6\7\u00e2\2\2\u0ea6\u0ea7\7\u0124"+
		"\2\2\u0ea7\u0eac\5\\/\2\u0ea8\u0eac\5`\61\2\u0ea9\u0eac\5b\62\2\u0eaa"+
		"\u0eac\5^\60\2\u0eab\u0ea3\3\2\2\2\u0eab\u0ea5\3\2\2\2\u0eab\u0ea8\3\2"+
		"\2\2\u0eab\u0ea9\3\2\2\2\u0eab\u0eaa\3\2\2\2\u0eac\u0273\3\2\2\2\u0ead"+
		"\u0eaf\13\2\2\2\u0eae\u0ead\3\2\2\2\u0eaf\u0eb2\3\2\2\2\u0eb0\u0eb1\3"+
		"\2\2\2\u0eb0\u0eae\3\2\2\2\u0eb1\u0eb4\3\2\2\2\u0eb2\u0eb0\3\2\2\2\u0eb3"+
		"\u0eb5\7n\2\2\u0eb4\u0eb3\3\2\2\2\u0eb4\u0eb5\3\2\2\2\u0eb5\u0275\3\2"+
		"\2\2\u0eb6\u0eb7\7\u009c\2\2\u0eb7\u0eb8\7\u00a4\2\2\u0eb8\u0ebc\5.\30"+
		"\2\u0eb9\u0ebd\5\u0278\u013d\2\u0eba\u0ebd\5\u027e\u0140\2\u0ebb\u0ebd"+
		"\5\u027a\u013e\2\u0ebc\u0eb9\3\2\2\2\u0ebc\u0eba\3\2\2\2\u0ebc\u0ebb\3"+
		"\2\2\2\u0ebd\u0277\3\2\2\2\u0ebe\u0ebf\7\u022e\2\2\u0ebf\u0ec0\5\u027c"+
		"\u013f\2\u0ec0\u0ec1\7\u022f\2\2\u0ec1\u0ec3\3\2\2\2\u0ec2\u0ebe\3\2\2"+
		"\2\u0ec2\u0ec3\3\2\2\2\u0ec3\u0ec5\3\2\2\2\u0ec4\u0ec6\5\u00a0Q\2\u0ec5"+
		"\u0ec4\3\2\2\2\u0ec5\u0ec6\3\2\2\2\u0ec6\u0ec7\3\2\2\2\u0ec7\u0ec8\7\u0147"+
		"\2\2\u0ec8\u0ecd\5\u028c\u0147\2\u0ec9\u0eca\7\u0232\2\2\u0eca\u0ecc\5"+
		"\u028c\u0147\2\u0ecb\u0ec9\3\2\2\2\u0ecc\u0ecf\3\2\2\2\u0ecd\u0ecb\3\2"+
		"\2\2\u0ecd\u0ece\3\2\2\2\u0ece\u0279\3\2\2\2\u0ecf\u0ecd\3\2\2\2\u0ed0"+
		"\u0ed1\7\u022e\2\2\u0ed1\u0ed2\5\u027c\u013f\2\u0ed2\u0ed3\7\u022f\2\2"+
		"\u0ed3\u0ed5\3\2\2\2\u0ed4\u0ed0\3\2\2\2\u0ed4\u0ed5\3\2\2\2\u0ed5\u0ed7"+
		"\3\2\2\2\u0ed6\u0ed8\5\u00a0Q\2\u0ed7\u0ed6\3\2\2\2\u0ed7\u0ed8\3\2\2"+
		"\2\u0ed8\u0ed9\3\2\2\2\u0ed9\u0eda\5\u0140\u00a1\2\u0eda\u027b\3\2\2\2"+
		"\u0edb\u0ee0\5\24\13\2\u0edc\u0edd\7\u0232\2\2\u0edd\u0edf\5\24\13\2\u0ede"+
		"\u0edc\3\2\2\2\u0edf\u0ee2\3\2\2\2\u0ee0\u0ede\3\2\2\2\u0ee0\u0ee1\3\2"+
		"\2\2\u0ee1\u027d\3\2\2\2\u0ee2\u0ee0\3\2\2\2\u0ee3\u0ee4\7\\\2\2\u0ee4"+
		"\u0ee5\7\u0147\2\2\u0ee5\u027f\3\2\2\2\u0ee6\u0ee7\7_\2\2\u0ee7\u0ee8"+
		"\7\u0084\2\2\u0ee8\u0eeb\5.\30\2\u0ee9\u0eea\7\u0150\2\2\u0eea\u0eec\5"+
		"\u017e\u00c0\2\u0eeb\u0ee9\3\2\2\2\u0eeb\u0eec\3\2\2\2\u0eec\u0281\3\2"+
		"\2\2\u0eed\u0eee\7\u0142\2\2\u0eee\u0eef\5.\30\2\u0eef\u0ef0\7\u0114\2"+
		"\2\u0ef0\u0ef5\5\u0284\u0143\2\u0ef1\u0ef2\7\u0232\2\2\u0ef2\u0ef4\5\u0284"+
		"\u0143\2\u0ef3\u0ef1\3\2\2\2\u0ef4\u0ef7\3\2\2\2\u0ef5\u0ef3\3\2\2\2\u0ef5"+
		"\u0ef6\3\2\2\2\u0ef6\u0efa\3\2\2\2\u0ef7\u0ef5\3\2\2\2\u0ef8\u0ef9\7\u0150"+
		"\2\2\u0ef9\u0efb\5\u017e\u00c0\2\u0efa\u0ef8\3\2\2\2\u0efa\u0efb\3\2\2"+
		"\2\u0efb\u0283\3\2\2\2\u0efc\u0efd\5\u0286\u0144\2\u0efd\u0efe\7\u0239"+
		"\2\2\u0efe\u0eff\5\u028a\u0146\2\u0eff\u0f0e\3\2\2\2\u0f00\u0f01\7\u022e"+
		"\2\2\u0f01\u0f06\5\u0286\u0144\2\u0f02\u0f03\7\u0232\2\2\u0f03\u0f05\5"+
		"\u0286\u0144\2\u0f04\u0f02\3\2\2\2\u0f05\u0f08\3\2\2\2\u0f06\u0f04\3\2"+
		"\2\2\u0f06\u0f07\3\2\2\2\u0f07\u0f09\3\2\2\2\u0f08\u0f06\3\2\2\2\u0f09"+
		"\u0f0a\7\u022f\2\2\u0f0a\u0f0b\7\u0239\2\2\u0f0b\u0f0c\5\u028c\u0147\2"+
		"\u0f0c\u0f0e\3\2\2\2\u0f0d\u0efc\3\2\2\2\u0f0d\u0f00\3\2\2\2\u0f0e\u0285"+
		"\3\2\2\2\u0f0f\u0f14\5\u0288\u0145\2\u0f10\u0f11\7\u0234\2\2\u0f11\u0f13"+
		"\5\u0288\u0145\2\u0f12\u0f10\3\2\2\2\u0f13\u0f16\3\2\2\2\u0f14\u0f12\3"+
		"\2\2\2\u0f14\u0f15\3\2\2\2\u0f15\u0f17\3\2\2\2\u0f16\u0f14\3\2\2\2\u0f17"+
		"\u0f18\7\u0234\2\2\u0f18\u0f19\5$\23\2\u0f19\u0f1c\3\2\2\2\u0f1a\u0f1c"+
		"\5\u0288\u0145\2\u0f1b\u0f0f\3\2\2\2\u0f1b\u0f1a\3\2\2\2\u0f1c\u0287\3"+
		"\2\2\2\u0f1d\u0f22\5\24\13\2\u0f1e\u0f1f\7\u023c\2\2\u0f1f\u0f20\5\u0206"+
		"\u0104\2\u0f20\u0f21\7\u023d\2\2\u0f21\u0f23\3\2\2\2\u0f22\u0f1e\3\2\2"+
		"\2\u0f22\u0f23\3\2\2\2\u0f23\u0289\3\2\2\2\u0f24\u0f27\5\u0152\u00aa\2"+
		"\u0f25\u0f27\5\u00a2R\2\u0f26\u0f24\3\2\2\2\u0f26\u0f25\3\2\2\2\u0f27"+
		"\u028b\3\2\2\2\u0f28\u0f29\7\u022e\2\2\u0f29\u0f2c\5\u028a\u0146\2\u0f2a"+
		"\u0f2b\7\u0232\2\2\u0f2b\u0f2d\5\u028a\u0146\2\u0f2c\u0f2a\3\2\2\2\u0f2d"+
		"\u0f2e\3\2\2\2\u0f2e\u0f2c\3\2\2\2\u0f2e\u0f2f\3\2\2\2\u0f2f\u0f30\3\2"+
		"\2\2\u0f30\u0f31\7\u022f\2\2\u0f31\u0f40\3\2\2\2\u0f32\u0f33\7\u0108\2"+
		"\2\u0f33\u0f34\7\u022e\2\2\u0f34\u0f39\5\u028a\u0146\2\u0f35\u0f36\7\u0232"+
		"\2\2\u0f36\u0f38\5\u028a\u0146\2\u0f37\u0f35\3\2\2\2\u0f38\u0f3b\3\2\2"+
		"\2\u0f39\u0f37\3\2\2\2\u0f39\u0f3a\3\2\2\2\u0f3a\u0f3c\3\2\2\2\u0f3b\u0f39"+
		"\3\2\2\2\u0f3c\u0f3d\7\u022f\2\2\u0f3d\u0f40\3\2\2\2\u0f3e\u0f40\5\u028a"+
		"\u0146\2\u0f3f\u0f28\3\2\2\2\u0f3f\u0f32\3\2\2\2\u0f3f\u0f3e\3\2\2\2\u0f40"+
		"\u028d\3\2\2\2\u019e\u0291\u02a5\u02aa\u02b6\u02d9\u02e4\u02eb\u0316\u031b"+
		"\u0327\u032d\u0332\u0345\u0348\u0356\u0365\u0367\u036f\u0385\u03a2\u03aa"+
		"\u03ad\u03bb\u03c5\u03ce\u03d4\u03e2\u03eb\u03ef\u03f3\u03f8\u03ff\u040b"+
		"\u0418\u041e\u0428\u042d\u0435\u0440\u044a\u0452\u045a\u045e\u0469\u0470"+
		"\u0475\u0478\u047c\u047f\u0482\u0486\u048a\u0490\u049e\u04a7\u04ae\u04b5"+
		"\u04bc\u04cb\u04d6\u04da\u04e3\u04f0\u04fd\u0508\u050c\u0510\u0512\u0518"+
		"\u0523\u0526\u052d\u0537\u053c\u0540\u0543\u0547\u054b\u054d\u0561\u056b"+
		"\u056d\u0575\u0579\u057b\u0583\u058b\u0590\u05a9\u05b0\u05b5\u05bb\u05c1"+
		"\u05c7\u05cc\u05d2\u05d9\u05df\u05e9\u05ef\u05f8\u05fd\u0603\u0609\u060f"+
		"\u0616\u061a\u0621\u0625\u0632\u0642\u0645\u064c\u064f\u0659\u065d\u0664"+
		"\u066b\u0677\u0679\u0680\u068a\u068c\u0693\u069b\u069d\u06a7\u06a9\u06ad"+
		"\u06b9\u06be\u06c1\u06c4\u06c7\u06cf\u06d2\u06d7\u06e7\u06ec\u06ee\u06f6"+
		"\u06ff\u0706\u0712\u0721\u0723\u0738\u073a\u0746\u074b\u074f\u0756\u075c"+
		"\u0762\u0767\u076a\u0770\u0774\u077b\u077d\u0780\u0789\u078e\u07a3\u07aa"+
		"\u07b3\u07b8\u07bb\u07cf\u07d4\u07d9\u07dc\u07e2\u07e9\u07f3\u07f8\u07fc"+
		"\u0801\u080a\u080f\u0816\u0818\u081f\u0831\u0839\u0845\u084a\u0853\u0857"+
		"\u085f\u0862\u086c\u086e\u0883\u088b\u08c6\u08ca\u08d7\u08de\u08e8\u0908"+
		"\u0911\u0915\u0917\u091f\u0921\u0929\u092d\u0934\u093c\u0943\u094a\u0951"+
		"\u0953\u095b\u096a\u096e\u0970\u097a\u097c\u098b\u0995\u099a\u09a1\u09a8"+
		"\u09aa\u09b3\u09b6\u09b8\u09c0\u09e5\u0a03\u0a09\u0a0d\u0a14\u0a1c\u0a23"+
		"\u0a26\u0a2c\u0a2f\u0a36\u0a3a\u0a46\u0a56\u0a5a\u0a5f\u0a67\u0a6e\u0a77"+
		"\u0a7d\u0a83\u0a8c\u0a97\u0aa0\u0ac2\u0acd\u0ad4\u0ad6\u0ade\u0ae3\u0ae8"+
		"\u0af1\u0af9\u0b01\u0b03\u0b0a\u0b1e\u0b23\u0b26\u0b35\u0b41\u0b4b\u0b52"+
		"\u0b55\u0b58\u0b5b\u0b64\u0b6e\u0b71\u0b7a\u0b8b\u0b9f\u0ba6\u0bac\u0bb0"+
		"\u0bb8\u0bbc\u0bc0\u0bce\u0bdf\u0bf0\u0bf8\u0c04\u0c0c\u0c0f\u0c1e\u0c26"+
		"\u0c2f\u0c33\u0c36\u0c3c\u0c50\u0c5b\u0c5f\u0c68\u0c77\u0c85\u0c92\u0c94"+
		"\u0c9e\u0ca1\u0ca4\u0ca8\u0cac\u0cb0\u0cb5\u0cb9\u0cc4\u0cc8\u0ccc\u0cd7"+
		"\u0cdf\u0ce1\u0ce4\u0ce7\u0cfc\u0cff\u0d09\u0d0c\u0d18\u0d1e\u0d21\u0d25"+
		"\u0d2a\u0d31\u0d36\u0d44\u0d50\u0d66\u0d7c\u0d82\u0d85\u0d8b\u0d91\u0d94"+
		"\u0d9a\u0da0\u0da3\u0db2\u0db6\u0dbf\u0dc4\u0dc8\u0dd2\u0dd6\u0ddb\u0deb"+
		"\u0dee\u0df7\u0dfc\u0e02\u0e07\u0e0a\u0e10\u0e16\u0e1c\u0e27\u0e2a\u0e2c"+
		"\u0e30\u0e33\u0e38\u0e3b\u0e41\u0e47\u0e4a\u0e4f\u0e56\u0e5e\u0e65\u0e69"+
		"\u0e6c\u0e70\u0e75\u0e7c\u0e7f\u0e84\u0e8b\u0e96\u0ea1\u0eab\u0eb0\u0eb4"+
		"\u0ebc\u0ec2\u0ec5\u0ecd\u0ed4\u0ed7\u0ee0\u0eeb\u0ef5\u0efa\u0f06\u0f0d"+
		"\u0f14\u0f1b\u0f22\u0f26\u0f2e\u0f39\u0f3f";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}