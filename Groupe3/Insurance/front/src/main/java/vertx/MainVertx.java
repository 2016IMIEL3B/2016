package vertx;

import io.vertx.core.Vertx;

/**
 * Created by Jerome on 23/03/2016.
 */
public class MainVertx {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(RestApiVertx.class.getCanonicalName());
    }
}
