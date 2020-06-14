package com.application.SchemaReader.utils;

import static com.application.SchemaReader.contant.DBType.DB2;
import static com.application.SchemaReader.contant.DBType.HSQL;
import static com.application.SchemaReader.contant.DBType.MYSQL;
import static com.application.SchemaReader.contant.DBType.ORACLE;
import static com.application.SchemaReader.contant.DBType.POSTGRESQL;
import static com.application.SchemaReader.contant.DBType.SQLITE;
import static com.application.SchemaReader.contant.DBType.SQL_SERVER;

import java.sql.Connection;

import com.application.SchemaReader.contant.Constants;
import com.application.SchemaReader.model.DBConnection;

import schemacrawler.tools.databaseconnector.DatabaseConnectionSource;
import schemacrawler.tools.databaseconnector.SingleUseUserCredentials;

public class Utils {

    public static Connection getConnection(DBConnection dbConnection) {
        final String connectionUrl = getConnectionUrl(dbConnection);
        final DatabaseConnectionSource dataSource =
                new DatabaseConnectionSource(connectionUrl);
        dataSource.setUserCredentials(new SingleUseUserCredentials(dbConnection.getUser(), dbConnection.getPassword().length() == 0 ? "" : dbConnection.getPassword()));
        return dataSource.get();
    }

    private static String getConnectionUrl(DBConnection dbConnection) {

        String connection_url = "";
        switch (dbConnection.getDbType()) {
            case SQL_SERVER:
                connection_url = SQL_SERVER.DBUrl;
                break;
            case DB2:
                connection_url = DB2.DBUrl;
                break;
            case HSQL:
                connection_url = HSQL.DBUrl;
                break;
            case ORACLE:
                connection_url = ORACLE.DBUrl;
                break;
            case MYSQL:
                connection_url = MYSQL.DBUrl;
                break;
            case POSTGRESQL:
                connection_url = POSTGRESQL.DBUrl;
                break;
            case SQLITE:
                connection_url = SQLITE.DBUrl;
                break;
            default:
                return null;
        }
        connection_url = connection_url.replace(Constants.PORT, dbConnection.getPort())
                .replace(Constants.SCHEMA, dbConnection.getDBName())
                .replace(Constants.URL, dbConnection.getDbUrl());
        return connection_url;
    }
}
