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

        JsonObject bodyRequest = this.routingContext.getBodyAsJson();
        String username = bodyRequest.getString("username");
        String password = bodyRequest.getString("password");

        //mock findUserByLogin to get User
        User user = new User();
        user.setPassword("password");
        user.setId(1);
        user.setLogin("michel");

        if (password.equals(user.getPassword())) {
            String token = provider.generateToken(new JsonObject().put("login", username), new JWTOptions());

            this.routingContext.response()
                 .setStatusCode(200)
                 .putHeader("token", token)
                 .end(Json.encode(user));
        } else {
            this.routingContext.response()
                 .setStatusCode(400)
                 .end(Json.encode("Bad loginAction or password"));
        }
    }
}
