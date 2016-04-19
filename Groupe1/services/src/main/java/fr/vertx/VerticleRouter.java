package fr.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.JWTAuthHandler;


/**
 * Created by joe on 24/03/2016.
 */
public class VerticleRouter extends AbstractVerticle{

    public void start() {

        Router router = Router.router(vertx);

        router.route("/public/*").produces("application/json");
        router.route().handler(BodyHandler.create());
        router.route("/public/*").handler(context -> {
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

            // Create a JWT Auth Provider
            JWTAuth jwt = JWTAuth.create(vertx, new JsonObject()
                    .put("keyStore", new JsonObject()
                            .put("type", "jceks")
                            .put("path", "keystore.jceks")
                            .put("password", "secret")));

            // protect the API
            router.route("/api/*").handler(JWTAuthHandler.create(jwt, "/api/newToken"));

            // this route is excluded from the auth handler
            router.get("/api/newToken").handler(ctx -> {
                ctx.response().putHeader("Content-Type", "text/plain");
                ctx.response().end(jwt.generateToken(new JsonObject(), new JWTOptions().setExpiresInSeconds(60L)));
            });

            // this is the secret API
            router.get("/api/protected").handler(ctx -> {
                ctx.response().putHeader("Content-Type", "text/plain");
                ctx.response().end("a secret you should keep for yourself...");
            });


            System.out.println("handle -> " + context.request().path());

            context.next();
        });

        router.get("/hello").handler(x -> {

            x.response().end(Json.encode("Hello world"));
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8090);
    }
}
