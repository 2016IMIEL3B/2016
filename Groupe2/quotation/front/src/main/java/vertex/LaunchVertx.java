package vertex;

import io.vertx.core.Vertx;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class LaunchVertx {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(VerticleListener.class.getCanonicalName());

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
