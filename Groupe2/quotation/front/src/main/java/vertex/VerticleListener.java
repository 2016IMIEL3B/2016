package vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Created by Theo Lemaillet on 21/03/16 for project.
 */
public class VerticleListener extends AbstractVerticle {

    AuthHelper authHelper;
    FuelHelper fuelHelper;
    MarkHelper markHelper;
    ModelHelper modelHelper;
    FormulHelper formulHelper;
    PriceHelper priceHelper;
    UserHelper userHelper;
    HomeTypeHelper homeTypeHelper;
    HeaterTypeHelper heaterTypeHelper;
    HorsePowerHelper horsePowerHelper;

    @Override
    public void start(){
        Router router = Router.router(vertx);
        this.authHelper = new AuthHelper(vertx);
        this.homeTypeHelper = new HomeTypeHelper(vertx);
        this.heaterTypeHelper = new HeaterTypeHelper(vertx);
        this.fuelHelper = new FuelHelper(vertx);
        this.markHelper = new MarkHelper(vertx);
        this.modelHelper = new ModelHelper(vertx);
        this.formulHelper = new FormulHelper(vertx);
        this.priceHelper = new PriceHelper(vertx);
        this.horsePowerHelper = new HorsePowerHelper(vertx);

        userHelper = new UserHelper(vertx);

        router.route().handler(BodyHandler.create());
        router.route("/*").handler(this::getDefaultHeader);

        router.post("/auth/api/login").handler(this.authHelper::getUserDetails);
        router.get("/api/fuel").handler(this.fuelHelper::getAll);
        router.get("/api/homeType").handler(this.homeTypeHelper::getAll);
        router.get("/api/heaterType").handler(this.heaterTypeHelper::getAll);
        router.get("/api/mark").handler(this.markHelper::getAll);
        router.get("/api/price").handler(this.priceHelper::getPriceByType);
        router.get("/api/model").handler(this.modelHelper::getAll);
        router.get("/api/formul").handler(this.formulHelper::getAll);
        router.get("/api/horsepower").handler(this.horsePowerHelper::getAll);
        router.post("/api/profil/save").handler(userHelper::getUserInformationsForm);

        router.route("/api/*").handler(context -> {
            Boolean ok = context.request().getParam("token") != null;
            if (ok) context.next();
            else context.fail(401);
        });

        router.route("/api/*").failureHandler(failureRoutingContext ->{
            int statusCode = failureRoutingContext.statusCode();
            HttpServerResponse resp = failureRoutingContext.response();

            if (statusCode <=0 || statusCode == 403) {
                resp.setStatusCode(403).end("Not Authorized");
            } else if(statusCode == 401) {
                resp.setStatusCode(statusCode).end("Bad Login");
            } else if(statusCode == 501) {
                resp.setStatusCode(statusCode).end("Querry Sided Error");
            } else if(statusCode == 400) {
                resp.setStatusCode(statusCode).end("Hep Hep Hep, on aime pas trop les tricheurs par chez nous");
            } else {
                resp.setStatusCode(statusCode).end();
            }


            failureRoutingContext.response().setStatusCode(statusCode).end("Not Authorized");
        });

        router.route("/api/*").handler(authHelper.getAuthHandler());

        vertx.createHttpServer().requestHandler(router::accept).listen(8091);
    }

    private void getDefaultHeader(RoutingContext context){
        context.response().headers().add(HttpHeaders.CONTENT_TYPE, "application/json");
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



