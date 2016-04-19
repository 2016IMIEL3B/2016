package com.groupe4.controller;

import com.groupe4.entity.User;
import com.groupe4.service.UserService;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class UserController {

    private RoutingContext routingContext;
    private UserService userService;

    public UserController(RoutingContext routingContext) {
        this.routingContext = routingContext;
        this.userService = new UserService();
    }

    /**
     * Return a user.
     * GET /api/users/:idUser
     */
    public void getUser(){
        Integer id = Integer.parseInt(routingContext.request().getParam("idUser"));

        this.userService.findById(id, handler -> {
            if (handler.succeeded()){
                User user = handler.result();

                if (user != null) {
                    this.routingContext.response()
                            .setStatusCode(200)
                            .end(Json.encode(user));
                } else {
                    this.routingContext.response()
                        .setStatusCode(404)
                        .end(Json.encode("User not found."));
                }
            } else {
                this.routingContext.response()
                    .setStatusCode(500)
                    .end(Json.encode("We messed up, dude !"));
            }
        });
    }

    /**
     * Return nothing
     * DELETE /api/users/:idUser
     */
    public void deleteUser(){
        Integer idUser = Integer.parseInt(routingContext.request().getParam("idUser"));

        this.userService.deleteUser(idUser, handler ->{
            if (handler.succeeded()){

                Integer id = handler.result();
                if (id != null){
                    this.routingContext.response()
                            .setStatusCode(204)
                            .end(Json.encode(id));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("User doesn't delete"));
                }

            } else {
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("We messed up, dude !"));
            }
        });
    }

    /**
     * Return nothing
     * PUT /api/users/:idUser
     */
    public void updateUser(){
        Integer idUser = Integer.parseInt(routingContext.request().getParam("idUser"));
        User user = Json.decodeValue(this.routingContext.getBodyAsJson().encode(), User.class);

        this.userService.updateUser(user, handler ->{
            if (handler.succeeded()){

                Integer id = handler.result();
                if (id != null){
                    this.routingContext.response()
                            .setStatusCode(204)
                            .end(Json.encode("Update successful"));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("User doesn't delete"));
                }
            } else {
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("We messed up, dude !"));
            }
        });
    }

    /**
     * Return id user
     * POST /api/users
     */
    public void createUser(){
        User user = Json.decodeValue(this.routingContext.getBodyAsJson().encode(), User.class);

        this.userService.createUser(user, handler ->{
            if (handler.succeeded()){

                Integer id = handler.result();
                if (id != null){
                    JsonObject responseBody = new JsonObject();
                    responseBody
                        .put("message", "User created.")
                        .put("id", id);

                    this.routingContext.response()
                        .setStatusCode(200)
                        .end(Json.encode(responseBody));
                } else {
                    this.routingContext.response()
                            .setStatusCode(404)
                            .end(Json.encode("User doesn't created"));
                }
            } else {
                this.routingContext.response()
                        .setStatusCode(500)
                        .end(Json.encode("We messed up, dude !"));
            }
        });
    }
}
