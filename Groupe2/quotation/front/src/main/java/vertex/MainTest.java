package vertex;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by tlemaillet on 21/03/16.
 */
public class MainTest {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

        vertx.deployVerticle(new VerticleListener());

        while (true){
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
