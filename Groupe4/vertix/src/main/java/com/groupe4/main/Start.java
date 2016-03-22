package com.groupe4.main;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.SQLConnection;

/**
 * Created by Mathilde on 21/03/2016.
 */
public class Start {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VerticleService());

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
            } else {
                // Failed to get connection - deal with it
                System.out.println("Connexion NOK");
            }
        });

    }
}
