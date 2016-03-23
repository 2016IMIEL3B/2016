package com.groupe4.main;

import com.groupe4.connexion.DbClient;
import io.vertx.core.Vertx;

public class Start {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        new DbClient(vertx);
        vertx.deployVerticle(new VerticleService());
    }
}
