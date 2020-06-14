package com.application.SchemaReader.controller;

import com.application.SchemaReader.contant.Constants;
import com.application.SchemaReader.contant.DBType;
import com.application.SchemaReader.model.DBConnection;
import com.application.SchemaReader.service.SchemaReaderService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schemaReader")
public class Controller {

    @Autowired
    SchemaReaderService schemaReaderService;

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<Object> setPlantParameters(@ApiParam(value = "Please Type as one of the following: MYSQL, ORACLE, DB2, SQL_SERVER, POSTGRESQL, SQLITE, HSQL", required = true) @RequestHeader("DBTYPE") String dbType,
                                                     @ApiParam(value = "URL where the db is hosted", required = true) @RequestHeader(Constants.DBURL) String dbUrl,
                                                     @ApiParam(value = "" +
                                                             "Name of the Schema", required = true) @RequestHeader(Constants.SCHEMA) String schema,
                                                     @ApiParam(value = "Port no of the hosted DB ", required = true) @RequestHeader(Constants.PORT) String port,
                                                     @ApiParam(value = "User Name", required = false) @RequestHeader(Constants.USER) String user,
                                                     @ApiParam(value = Constants.PASSWORD, required = false) @RequestHeader(value = Constants.PASSWORD, defaultValue =  "") String password) {
        try {
            DBConnection dbConnection = new DBConnection(DBType.valueOf(dbType), dbUrl, schema, port, user, password);
            return ResponseEntity.status(200).body(schemaReaderService.readSchema(dbConnection));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Bad Request");
        }


    }
}
