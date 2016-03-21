package com.groupe4.main;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
/**
 * Created by Mathilde on 21/03/2016.
 */
public class VerticleService extends AbstractVerticle{

    @Override
    public void start(Future<Void> startFuture) {
        System.out.println("MyVerticle started!");
    }

    @Override
    public void stop(Future stopFuture) throws Exception {
        System.out.println("MyVerticle stopped!");
    }
}
