package com.groupe4.main;

import com.groupe4.connection.DbClient;
import com.groupe4.main.controller.AuthenticationController;
import com.groupe4.main.controller.ListController;
import com.groupe4.main.controller.QuoteController;
import com.groupe4.connexion.DbClient;
import com.groupe4.dao.IUserRepository;
import com.groupe4.dao.UserRepository;
import com.groupe4.main.controller.UserController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.JWTAuthHandler;

import java.util.List;
import javax.jws.soap.SOAPBinding;

public class VerticleService extends AbstractVerticle{

    @Override
    public void start() {
        DbClient.getInstance();

        IUserRepository user = new UserRepository();

        Router router = Router.router(vertx);

        JsonObject jwtAuthConfig = new JsonObject().put("keyStore", new JsonObject()
                .put("path", "config/keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));
        JWTAuth authProvider = JWTAuth.create(vertx, jwtAuthConfig);

        router.route().handler(BodyHandler.create());

        router.route("/loginAction").handler(context -> {
            context.response().headers().add(HttpHeaders.CONTENT_TYPE, "application/json");
            context.response().headers().add("content-type", "text/html;charset=UTF-8");
            context.next();
        });

        router.route("/api/*").produces("application/json");

        // API protection with JWT
        router.route("/api/*").handler(JWTAuthHandler.create(authProvider));

        router.route("/api/*").handler(context -> {
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

            context.next();
        });

        // Router begin
        router.post("/login").handler(routingContext -> {
            AuthenticationController authenticationController = new AuthenticationController(routingContext);
            authenticationController.loginAction();
        });

        router.get("/api/lists").handler(routingContext -> {
            ListController listController = new ListController(routingContext);
            listController.getListsAction();
        });

        router.get("/api/lists/:id").handler(routingContext -> {
            ListController listController = new ListController(routingContext);
            listController.getListsByParentId();
        });

        router.get("/api/users/:idUser/quotes").handler(routingContext -> {
            QuoteController quoteController = new QuoteController(routingContext);
            quoteController.getQuotesByUser();
        });

        router.post("/api/users/:idUser/quote").handler(routingContext -> {
            QuoteController quoteController = new QuoteController(routingContext);
            quoteController.createQuote();
        });

        router.get("/api/users/:idUser").handler(routingContext -> {
            UserController userController = new UserController(routingContext);
            userController.getUser();
        });

        router.delete("/api/users/:idUser").handler(routingContext -> {
            UserController userController = new UserController(routingContext);
            userController.deleteUser();
        });

        router.put("/api/users/:idUser").handler(routingContext ->{
            UserController userController = new UserController(routingContext);
            userController.updateUser();
        });

        router.post("/api/users").handler(routingContext -> {
            UserController userController = new UserController(routingContext);
            userController.createUser();
        });
        // Start server
        vertx.createHttpServer().requestHandler(router::accept).listen(1204);

        System.out.println("Http server is running on http://localhost:1204 ...");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Verticle service stopped!");
    }
}
