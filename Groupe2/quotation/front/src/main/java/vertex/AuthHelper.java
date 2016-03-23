package vertex;

import config.VertxAuthConfig;
import config.VertxDatabaseConfig;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.JWTAuthHandler;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class AuthHelper {

    private Vertx vertx;
    private AsyncSQLClient client;
    private JWTAuth authProvider;

    public AuthHelper(Vertx vertx) {
        this.vertx = vertx;
        this.client = MySQLClient.createShared(vertx, new VertxDatabaseConfig().getDBConfig());
        this.authProvider = JWTAuth.create(vertx, new VertxAuthConfig().getAuthConfig());
    }

    public void getUserDetails(RoutingContext context){
        String login = context.request().getParam("login");
        System.out.println("login -> " + login);
        if (login == null) {
            context.response().end("Nope!");
        } else {
            getDetailsFromLogin(context, login);
        }
    }

    public void getDetailsFromLogin(RoutingContext context, String login) {
        this.client.getConnection(res -> {
            System.out.println("conn -> " + res.succeeded());
            if (res.succeeded()) {
                JsonArray params = new JsonArray().add(login);
                SQLConnection connection = res.result();
                connection.queryWithParams("Select * from User where login = ?", params, resSet -> {
                    System.out.println("resSet -> " + resSet.succeeded());
                    if (resSet.succeeded()){
                        if(resSet.result().getNumRows() != 0){

                            JsonObject userDetails = resSet.result().getRows().get(0);
                            String token = authProvider.generateToken(userDetails, new JWTOptions());
                            context.response().putHeader("UserDetails", userDetails.toString());
                            context.response().putHeader("Token", token);
                            context.response().end("Ok!");

                        } else {
                            context.response().end("Bad Login");
                        }
                    } else {
                        context.response().end("Error with Query.");
                    }
                    connection.close();
                });
            } else {
                context.response().end("Error with Database connection.");
            }

        });
    }


    /*private void getUserDetails(RoutingContext context){

        //String login = context.request().getHeader("Login");
        String login = context.request().getParam("login");

        System.out.println("login -> " + login);
        if (login == null) {
            context.response().end("Nope!");
        } else {
            try {

                getDetailsFromLogin(context, "toto", x -> {
                    if (x.succeeded()){
                        System.out.println(x.result().encodePrettily());
                    } else {
                        System.out.println(x.cause());
                    }
                });


            } catch(Exception e) {
                // context.response().setStatusCode(403).end(e.getMessage());
                context.fail(403);
            }
        }
    }

    public void getDetailsFromLogin(RoutingContext context, String login, Handler<AsyncResult<JsonObject>> handler) {

        vertx.runOnContext(x -> {

            JsonObject mySQLClientConfig = new JsonObject()
                    .put("host", "127.0.0.1")
                    .put("port",3306)
                    .put("username", "root")
                    .put("password", "sql2k")
                    .put("database", "exostarter");
            AsyncSQLClient client = MySQLClient.createShared(vertx, mySQLClientConfig);
            client.getConnection(res -> {
                System.out.println("conn -> " + res.succeeded());
                if (res.succeeded()) {
                    JsonArray params = new JsonArray().add(login);
                    SQLConnection connection = res.result();
                    connection.queryWithParams("Select * from user where login = ?", params, resSet -> {
                        System.out.println("resSet -> " + resSet.succeeded());
                        if (resSet.succeeded()){
                            if(resSet.result().getNumRows() != 0){
                                String token = "token";// authProvider.generateToken(userDetails, new JWTOptions());
                                JsonObject result = new JsonObject()
                                        .put("UserDetails",resSet.result().getRows().get(0).toString())
                                        .put("Token", token);
                                handler.handle(Future.succeededFuture(result));
                            } else {
                                handler.handle(Future.failedFuture(new IllegalStateException("Bad Login")));
                            }
                        } else {
                            handler.handle(Future.failedFuture(new IllegalStateException("Error with Querry.")));
                        }
                    });
                } else {
                    handler.handle(Future.failedFuture(new IllegalStateException("Error with Database connection.")));
                }
            });
        });


    }*/

    public JWTAuthHandler getAuthHandler(){
        return JWTAuthHandler.create(authProvider);
    }


    public void close(){
        client.close();
    }
}
