package com.application.SchemaReader.service;

import com.application.SchemaReader.model.DBConnection;

public interface SchemaReaderService {

    public String readSchema(DBConnection dbConnection) throws Exception;
}
