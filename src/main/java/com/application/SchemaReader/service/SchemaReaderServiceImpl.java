package com.application.SchemaReader.service;

import com.application.SchemaReader.model.DBConnection;
import com.application.SchemaReader.utils.Utils;
import org.springframework.stereotype.Component;
import schemacrawler.schema.*;
import schemacrawler.schemacrawler.RegularExpressionInclusionRule;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaCrawlerOptionsBuilder;
import schemacrawler.schemacrawler.SchemaInfoLevelBuilder;
import schemacrawler.utility.SchemaCrawlerUtility;

import java.util.Collection;
import java.util.HashMap;

@Component
public class SchemaReaderServiceImpl implements SchemaReaderService {

    @Override
    public String readSchema(DBConnection dbConnection) throws Exception {
        final SchemaCrawlerOptionsBuilder optionsBuilder =
                SchemaCrawlerOptionsBuilder.builder()
                        .withSchemaInfoLevel(SchemaInfoLevelBuilder.standard())
                        .includeSchemas(new RegularExpressionInclusionRule(dbConnection.getDBName()));
                        //.includeTables(tableFullName -> tableFullName.contains("PERSON"));
        final SchemaCrawlerOptions options = optionsBuilder.toOptions();

        // Get the schema definition
        final Catalog catalog =
                SchemaCrawlerUtility.getCatalog(Utils.getConnection(dbConnection), options);
        StringBuffer dbOutput = new StringBuffer();
        Collection<Schema> schemaCollection = catalog.getSchemas();
        if(schemaCollection.size() == 0) return "No data found";
        for (final Schema schema : schemaCollection) {
            System.out.println(schema);
            dbOutput.append(schema);
            for (final Table table : catalog.getTables(schema)) {
                System.out.print("o--> " + table);
                dbOutput.append("o--> " + table);
                if (table instanceof View) {
                    System.out.println(" (VIEW)");
                    dbOutput.append(" (VIEW)");
                } else {
                    System.out.println();
                    dbOutput.append(" ");
                }

                for (final Column column : table.getColumns()) {
                    System.out.println(
                            "     o--> " + column + " (" + column.getColumnDataType() + ")");
                    dbOutput.append("     o--> " + column + " (" + column.getColumnDataType() + ")");
                }
            }
        }

        return dbOutput.toString();
    }
}
