package com.groupe4;

import com.groupe4.service.RouterService;
import io.vertx.core.Vertx;

public class Start {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new RouterService());
    }
}
