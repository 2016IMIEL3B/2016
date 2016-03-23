package com.groupe4.main.verticles;

import com.groupe4.main.common.User;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.RoutingContext;

public class Authentication {
    public void login(RoutingContext routingContext) {
        JsonObject config = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "config/keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));
        JWTAuth provider = JWTAuth.create(Vertx.currentContext().owner(), config);

        String username = routingContext.request().getParam("username");
        String password = routingContext.request().getParam("password");

        //mock findUserByLogin to get User
        User user = new User();
        user.setPassword("password");

        if (password.equals(user.getPassword())) {
            String token = provider.generateToken(new JsonObject().put("login", username), new JWTOptions());
            JsonObject responseBody = new JsonObject();
            responseBody.put("user", Json.encode(user)).put("token", token);

            routingContext.response()
                    .setStatusCode(200)
                    .end(Json.encode(responseBody));
        } else {
            routingContext.response()
                    .setStatusCode(400)
                    .end(Json.encode("Bad login or password"));
        }
    }
}
