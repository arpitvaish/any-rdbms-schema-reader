package com.application.SchemaReader.model;

import com.application.SchemaReader.contant.DBType;

public class DBConnection {

    private DBType dbType;
    private String dbUrl;
    private String DBName;
    private String port;
    private String user;
    private String password;

    public DBConnection(DBType dbType, String dbUrl, String DBName, String port, String user, String password) {
        this.dbType = dbType;
        this.dbUrl = dbUrl;
        this.DBName = DBName;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public DBType getDbType() {
        return dbType;
    }

    public void setDbType(DBType dbType) {
        this.dbType = dbType;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
