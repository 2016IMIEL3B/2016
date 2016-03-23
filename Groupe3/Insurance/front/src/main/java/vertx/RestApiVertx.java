package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.List;


/**
 * Created by Jerome on 23/03/2016.
 */
public class RestApiVertx extends AbstractVerticle {

    private AsyncSQLClient client;

    @Override
    public void start() {

        RestApiVertx that = this;
        client = MySQLClient.createShared(vertx, getDbConfig());
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.route("/api/user/:userLogin/:userPassword").handler(routingContext -> {
            client.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection conn = res.result();

                    // save the connection on the context
                    routingContext.put("conn", conn);
                    //routingContext.addHeadersEndHandler(done -> conn.close(v -> { }));
                    routingContext.next();
                } else {
                    routingContext.fail(res.cause());
                }
            });
        }).failureHandler(routingContext -> {
            SQLConnection conn = routingContext.get("conn");
            if (conn != null) {
                routingContext.response()
                    .putHeader("content-type", "application/json; charset=utf-8")
                    .end("<h1>Failed to Connect the DB</h1>" + conn);
            }
        });

 router.get("/api/user/:userLogin/:userPassword").handler(that::handleGetUser);
        vertx.createHttpServer().requestHandler(router::accept).listen(8090);
    }

    private void handleGetUser(RoutingContext routingContext) {
        String userID = routingContext.request().getParam("userID");
        String userLogin = routingContext.request().getParam("userLogin");
        String userPassword = routingContext.request().getParam("userPassword");
        HttpServerResponse response = routingContext.response();
        if (userID == null) sendError(400, response);
        else {
            SQLConnection conn = routingContext.get("conn");
            String query = "SELECT * FROM user WHERE login =? AND password = ?";
            JsonArray params = new JsonArray().add(userLogin).add(userPassword);

            conn.queryWithParams(query, params, res -> {
                if (res.failed()) sendError(500, response);
                else if (res.result().getNumRows() == 0){sendError(404, response);
                } else {
                    ResultSet result = res.result();
                    List<JsonObject> list = sanitizeResponseData(result);

                    JsonObject config = getJwtConfig();
                    JWTAuth provider = JWTAuth.create(vertx, config);

                    String sub = userPassword + userLogin;
                    String token = provider.generateToken(new JsonObject().put("sub", sub), new JWTOptions());
                    //Authorization: Bearer <token>


                    response
                        .putHeader("content-type", "application/json; charset=utf-8")
                        .end(Json.encodePrettily(result.getRows()));
                    //sanitizeResponseData(result);
                }
            });
        }
    }

    private List<JsonObject> sanitizeResponseData(ResultSet result)
    {
        List<JsonObject> response = result.getRows();
        System.out.println(response);
        return response;
    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }

    private JsonObject getDbConfig()
    {
        return new JsonObject()
            .put("host", "127.0.0.1")
            .put("port", 3306)
            .put("maxPoolSize", 10)
            .put("username", "root")
            .put("password", "root")
            .put("database", "dbinsurance");
    }

    private JsonObject getJwtConfig()
    {
        return new JsonObject()
            .put("keyStore", new JsonObject()
                .put("path", "keystore.jceks")
                .put("type", "jceks")
                .put("password", "secret"));

    }
}
