package vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by Theo Lemaillet on 21/03/16 for project.
 */
public class VerticleListener extends AbstractVerticle {

    AuthHelper authHelper;
    FuelHelper fuelHelper;

    @Override
    public void start(){
        Router router = Router.router(vertx);
        authHelper = new AuthHelper(vertx);
        fuelHelper = new FuelHelper(vertx);


        router.route("/*").handler(this::getDefaultHeader);

        router.post("/auth/api/login").handler(authHelper::getUserDetails);
        router.post("/api/fuel").handler(fuelHelper::getAll);

        router.route("/api/*").handler(context -> {
            Boolean ok = context.request().getParam("token") != null;
            if (ok) context.next();
            else context.fail(401);
        });

        router.route("/api/*").failureHandler(failureRoutingContext ->{
            int statusCode = failureRoutingContext.statusCode();
            if (statusCode <=0) {
                statusCode = 403;
            }
            failureRoutingContext.response().setStatusCode(statusCode).end("Not Authorized");
        });

        router.route("/api/*").handler(authHelper.getAuthHandler());

        vertx.createHttpServer().requestHandler(router::accept).listen(8091);
    }

    private void getDefaultHeader(RoutingContext context){
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
    }

    @Override
    public void stop() throws Exception {
        authHelper.close();
    }
}


