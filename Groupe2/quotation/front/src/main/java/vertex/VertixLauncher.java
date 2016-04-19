package vertex;

import io.vertx.core.Vertx;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class VertixLauncher {

    public VertixLauncher(){

    }

    public static void launch (){

    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(VerticleListener.class.getCanonicalName());



    }


}
