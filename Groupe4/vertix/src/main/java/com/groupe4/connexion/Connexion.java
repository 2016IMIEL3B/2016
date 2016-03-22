package com.groupe4.connexion;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

import java.util.List;

/**
 * Created by Link on 22/03/2016.
 */
public class Connexion {

    public Connexion(Vertx vertx) {
        JsonObject mySQLClientConfig = new JsonObject()
                .put("host", "127.0.0.1")
                .put("port", 3306)
                .put("username", "root")
                .put("password", "toto")
                .put("database", "java_g4_ms");
        AsyncSQLClient mySQLClient = MySQLClient.createShared(vertx, mySQLClientConfig);

        mySQLClient.getConnection(res -> {

            if (res.succeeded()) {
                SQLConnection connection = res.result();
                // Got a connection
                System.out.println("Connexion OK");

                connection.query("SELECT * FROM user", res2 -> {
                    if (res2.succeeded()) {

                        ResultSet rs = res2.result();
                        // Do something with results

                        List<String> columnNames = rs.getColumnNames();

                        List<JsonArray> results = rs.getResults();

                        for (JsonArray row: results) {

                            /*
                            String id = row.getString(0);
                            String fName = row.getString(1);
                            String lName = row.getString(2);
                            int shoeSize = row.getInteger(3);
                            */
                            System.out.println("User "+row.getString(1));

                        }


                    }
                });

            } else {
                // Failed to get connection - deal with it
                System.out.println("Connexion NOK");
            }
        });
    }

}
