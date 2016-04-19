package config;

import io.vertx.core.json.JsonObject;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class VertxDatabaseConfig {

    private String host = "localhost";
    private int port = 3306;
    private String username = "root";
    private String password = "password";
    private String database = "quotation_back";

    public VertxDatabaseConfig(){}

    public VertxDatabaseConfig(String database) {
        this.database = database;
    }

    public VertxDatabaseConfig(String host, int port, String username, String password, String database) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public JsonObject getDBConfig(){
        return new JsonObject()
                .put("host", host)
                .put("port", port)
                .put("username", username)
                .put("password", password)
                .put("database", database);
    }
}
