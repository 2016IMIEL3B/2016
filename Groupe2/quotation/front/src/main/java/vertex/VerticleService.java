package vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;

/**
 * Created by Nico on 18/02/2016.
 */
public class VerticleService extends AbstractVerticle {

    @Override
    public void start(){

        vertx.eventBus().consumer("MY_EVENT", this::consumeMyEvent);

    }

    private void consumeMyEvent(Message<String> context){
        String message = context.body();
        message += "-> hello from VerticleService";
        context.reply(message);


    }
}
