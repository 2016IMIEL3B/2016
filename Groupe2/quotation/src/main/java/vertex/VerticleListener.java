package vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by Theo Lemaillet on 21/03/16 for project.
 */
public class VerticleListener extends AbstractVerticle {
    @Override
    public void start(){
        Router router = Router.router(vertx);

        router.route("/*").handler(this::getDefaultHeader);

        router.get("/auth/api/login").handler(this::getUserDetails);

        vertx.createHttpServer().requestHandler(router::accept).listen(8090);
    }

    private void getUserDetails(RoutingContext context){
        //String login = context.request().getHeader("Login");
        String login = context.request().getParam("login");

        System.out.println("login -> " + login);
        if (login == null) {
            context.response().end("Nope!");
        } else {
            JsonObject clientConfig = new JsonObject()
                    .put("host", "localhost")
                    .put("port", 3306)
                    .put("username", "root")
                    .put("password", "Revelefu1!")
                    .put("database", "quotation_back");
            AsyncSQLClient client = MySQLClient.createShared(vertx, clientConfig);

            client.getConnection(res -> {
                System.out.println("conn -> " + res.succeeded());
                if (res.succeeded()) {
                    JsonArray params = new JsonArray().add(login);
                    SQLConnection connection = res.result();
                    connection.queryWithParams("Select * from User where login = ?", params, resSet -> {
                        System.out.println("resSet -> " + resSet.succeeded());
                        if (resSet.succeeded()){
                            if(resSet.result().getNumRows()!= 0){
                                JsonObject userDetail = resSet.result().getRows().get(0);

                                context.response().putHeader("UserDetails", userDetail.toString());
                                context.response().end("Ok!");
                            } else {
                                context.response().end("Bad Login...");
                            }
                        } else {
                            context.response().end("Error with Querry...");
                        }
                    });
                } else {
                    context.response().end("Error with DB...");
                }
            });
            client.close();
        }
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


}



