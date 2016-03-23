package com.groupe4.connexion;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;

/**
 * DbClient class. Give a client to access database.
 */
public class DbClient {
    /**
     * Client.
     */
    private AsyncSQLClient client;

    /**
     * DbCLient instance.
     */
    private static DbClient instance;

    /**
     * Private constructor for singleton.
     * @param vertx
     */
    private DbClient(Vertx vertx) {
        JsonObject mySQLClientConfig = new JsonObject()
                .put("host", "127.0.0.1")
                .put("port", 3306)
                .put("username", "root")
                .put("password", "1234")
                .put("database", "java_g4_ms");
        this.client = MySQLClient.createShared(vertx, mySQLClientConfig);
    }

    /**
     * Mysql client.
     *
     * @return
     */
    public AsyncSQLClient getClient() {
        return client;
    }

    /**
     * Get DbClient instance.
     * @return
     */
    public static DbClient getInstance() {
        if (null == instance) {
            instance = new DbClient(Vertx.currentContext().owner());
        }
        return instance;
    }


}
