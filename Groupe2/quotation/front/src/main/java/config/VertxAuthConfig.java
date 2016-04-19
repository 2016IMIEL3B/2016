package config;

import io.vertx.core.json.JsonObject;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class VertxAuthConfig {
    private String path = "keystore.jceks";
    private String type = "jceks";
    private String password = "secret";

    public VertxAuthConfig() {}
    public VertxAuthConfig(String path, String type, String password) {
        this.path = path;
        this.type = type;
        this.password = password;
    }

    public JsonObject getAuthConfig(){
        return new JsonObject().put(
                "keyStore",
                new JsonObject()
                        .put("path", path)
                        .put("type", type)
                        .put("password", password)
        );
    }

}
