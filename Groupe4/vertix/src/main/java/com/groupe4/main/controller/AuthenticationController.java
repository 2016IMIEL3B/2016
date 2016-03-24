package com.groupe4.main.controller;

import com.groupe4.main.common.User;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.RoutingContext;

public class AuthenticationController {
    private RoutingContext routingContext;

    public AuthenticationController(RoutingContext routingContext) {
        this.routingContext = routingContext;
    }

    public void loginAction() {
        JsonObject config = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "config/keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));
        JWTAuth provider = JWTAuth.create(Vertx.currentContext().owner(), config);

        String username = this.routingContext.request().getParam("username");
        String password = this.routingContext.request().getParam("password");

        //mock findUserByLogin to get User
        User user = new User();
        user.setPassword("password");

        if (password.equals(user.getPassword())) {
            String token = provider.generateToken(new JsonObject().put("loginAction", username), new JWTOptions());
            JsonObject responseBody = new JsonObject();
            responseBody.put("user", Json.encode(user)).put("token", token);

            this.routingContext.response()
                    .setStatusCode(200)
                    .end(Json.encode(responseBody));
        } else {
            this.routingContext.response()
                    .setStatusCode(400)
                    .end(Json.encode("Bad loginAction or password"));
        }
    }
}
