package vertex;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by tlemaillet on 21/03/16.
 */
public class MainTest {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));

        vertx.setPeriodic(1000, id -> {
            // This handler will get called every second
            System.out.println("timer fired!");
        });
        vertx.setPeriodic(500, id -> {
            // This handler will get called every second
            System.out.println("Plus vite!");
        });

        while (true){
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}