package com.groupe4.controller;

import com.groupe4.entity.User;
import com.groupe4.service.UserService;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.RoutingContext;


public class AuthenticationController {
    private RoutingContext routingContext;
    private UserService userService;

    public AuthenticationController(RoutingContext routingContext) {
        this.routingContext = routingContext;
        this.userService = new UserService();
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

        this.userService.findByLogin(username, handler -> {
            if (handler.succeeded()) {
                User user = handler.result();

                if (password.equals(user.getPassword())) {
                    String token = provider.generateToken(new JsonObject().put("login", username), new JWTOptions());

                    this.routingContext.response()
                            .setStatusCode(200)
                            .putHeader("token", token)
                            .end(Json.encode(user));
                } else {
                    this.routingContext.response()
                            .setStatusCode(400)
                            .end(Json.encode("Bad login or password"));
                }
            } else {
                System.out.println("Error in AuthenticationController : " + handler.cause()
                        + " : cannot find user with login " + username);
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("Cannot find user with login " + username));
            }
        });
    }
}
