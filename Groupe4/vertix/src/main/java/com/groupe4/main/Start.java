package com.groupe4.main;

import io.vertx.core.Vertx;
/**
 * Created by Mathilde on 21/03/2016.
 */
public class Start {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new VerticleService());

    }
}
