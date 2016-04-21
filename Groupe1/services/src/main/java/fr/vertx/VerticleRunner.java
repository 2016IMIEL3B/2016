package fr.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
/**
 * Created by joe on 23/03/2016.
 */
public class VerticleRunner {

    public static void launch() {

        System.out.println("vtx start !!");
        Vertx vertx = Vertx.vertx();
        //vertx.deployVerticle(VertxService.class.getCanonicalName());
        vertx.deployVerticle(VerticleRouter.class.getCanonicalName());


    }


}
