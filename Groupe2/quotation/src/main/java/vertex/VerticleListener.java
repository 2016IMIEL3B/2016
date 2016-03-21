package vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by tlemaillet on 21/03/16.
 */
public class VerticleListener extends AbstractVerticle {
    @Override
    public void start(){
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route("/auth/*").handler(context -> {

            context.response().headers().add(HttpHeaders.CONTENT_TYPE, "application/json");
            context.response().headers().add("content-type", "text/html;charset=UTF-8");

            context.response()
                    // do not allow proxies to cache the data
                    .putHeader("Cache-Control", "no-store, no-cache")
                    // prevents Internet Explorer from MIME - sniffing a
                    // response away from the declared content-type
                    .putHeader("X-Content-Type-Options", "nosniff")
                    // Strict HTTPS (for about ~6Months)
                    .putHeader("Strict-Transport-Security", "max-age=" + 15768000)
                    // IE8+ do not allow opening of attachments in the context
                    // of this resource
                    .putHeader("X-Download-Options", "noopen")
                    // enable XSS for IE
                    .putHeader("X-XSS-Protection", "1; mode=block")
                    // deny frames
                    .putHeader("X-FRAME-OPTIONS", "DENY")
                    // Accept all
                    .putHeader("Access-Control-Allow-Origin", "*");

            System.out.println("handle -> " + context.request().path());

            context.next();
        });

        router.get("/public/hello").handler(x -> x.response().end(Json.encode("Hello world")));

        router.get("/public/message").handler(x ->
                vertx.eventBus().send("MY_EVENT", "hello from VerticleFront",
                        r -> x.response().end(Json.encode(r.result().body().toString()))
                )
        );

        router.post("/public/query").consumes("application/json").handler(x ->{
            JsonObject queryJson = x.getBodyAsJson();
            x.response().end(Json.encode(Json.decodeValue(queryJson.encode(), String.class) + " ok from vertx front"));
        });


        vertx.createHttpServer().requestHandler(router::accept).listen(8090);


    }
}

