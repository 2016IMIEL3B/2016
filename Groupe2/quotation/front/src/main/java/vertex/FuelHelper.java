package vertex;

import config.VertxDatabaseConfig;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;

import java.util.List;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class FuelHelper {

    private Vertx vertx;
    private AsyncSQLClient client;

    public FuelHelper(Vertx vertx) {
        this.vertx = vertx;
        this.client = MySQLClient.createShared(vertx, new VertxDatabaseConfig().getDBConfig());
    }

    public void getAll(RoutingContext context){
        this.client.getConnection(res -> {
            if (res.succeeded()) {
                SQLConnection connection = res.result();
                connection.query("Select * from Fuel", resSet -> {
                    if (resSet.succeeded()) {
                        if (resSet.result().getNumRows() != 0) {

                            List<JsonArray> results = resSet.result().getResults();

                            for (JsonArray row: results) {
                                context.response()
                                        .putHeader("content-type", "application/json; charset=utf-8")
                                        .end(Json.encodePrettily(resSet.result().getRows() ));
                            }
                        } else {
                            context.response().end(new JsonObject().put("result", "Error with Query.").encode());
                        }
                    }
                    connection.close();
                });

            } else {
                context.response().end("Error with Database connection.");
            }

        });
    }


}
