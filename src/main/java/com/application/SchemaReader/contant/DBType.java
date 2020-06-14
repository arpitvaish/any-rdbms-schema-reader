package com.application.SchemaReader.contant;

public enum DBType {
    ORACLE(Constants.ORACLE_CONNECTION_PATH),
    MYSQL(Constants.MYSQL_CONNECTION_PATH),
    DB2(Constants.DB2_CONNECTION_PATH),
    SQL_SERVER(Constants.SQLSERVER_CONNECTION_PATH),
    POSTGRESQL(Constants.POSTGRESQL_CONNECTION_PATH),
    SQLITE(Constants.SQLLITE_CONNECTION_PATH),
    HSQL(Constants.HSQL_CONNECTION_PATH);
    public final String DBUrl;

    private DBType(String DBUrl) {
        this.DBUrl = DBUrl;
    }
}
