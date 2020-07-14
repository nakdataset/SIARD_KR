@ECHO off

REM - EnterUtilities
@ECHO ----- DEPLOY - EnterUtilities-master
@ECHO .
CD EnterUtilities-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcBase
@ECHO ----- DEPLOY - JdbcBase-master
@ECHO .
CD JdbcBase-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcAccess
@ECHO ----- DEPLOY - JdbcAccess-master
@ECHO .
CD JdbcAccess-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcDb2
@ECHO ----- DEPLOY - JdbcDb2-master
@ECHO .
CD JdbcDb2-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcH2
@ECHO ----- DEPLOY - JdbcH2-master
@ECHO .
CD JdbcH2-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcMsSql
@ECHO ----- DEPLOY - JdbcMsSql-master
@ECHO .
CD JdbcMsSql-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcMySql
@ECHO ----- DEPLOY - JdbcMySql-master
@ECHO .
CD JdbcMySql-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcOracle
@ECHO ----- DEPLOY - JdbcOracle-master
@ECHO .
CD JdbcOracle-master
CALL ANT deploy
@ECHO .
CD ..

REM - JdbcPostgres
@ECHO ----- DEPLOY - JdbcPostgres-master
@ECHO .
CD JdbcPostgres-master
CALL ANT deploy
@ECHO .
CD ..

REM - SqlParser
@ECHO ----- DEPLOY - SqlParser-master
@ECHO .
CD SqlParser-master
CALL ANT deploy
@ECHO .
CD ..

REM - Zip64File
@ECHO ----- DEPLOY - Zip64File-master
@ECHO .
CD Zip64File-master
CALL ANT deploy
@ECHO .
CD ..

REM - SiardApi
@ECHO ----- DEPLOY - SiardApi-master
@ECHO .
CD SiardApi-master
CALL ANT deploy
@ECHO .
CD ..

REM - SiardCmd
@ECHO ----- DEPLOY - SiardCmd-master
@ECHO .
CD SiardCmd-master
CALL ANT deploy
@ECHO .
CD ..

REM - SiardGui
@ECHO ----- DEPLOY - SiardGui-master
@ECHO .
CD SiardGui-master
CALL ANT deploy
@ECHO .
CD ..
