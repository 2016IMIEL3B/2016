package vertex;

import io.vertx.core.AbstractVerticle;

/**
 * Created by Nico on 18/02/2016.
 */
public class VerticleRunner extends AbstractVerticle {


    @Override
    public void start(){

        vertx.deployVerticle(VerticleListener.class.getCanonicalName());
        vertx.deployVerticle(VerticleService.class.getCanonicalName());
    }

}
