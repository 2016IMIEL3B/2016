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

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class ModelHelper {

    private Vertx vertx;
    private AsyncSQLClient client;

    public ModelHelper(Vertx vertx) {
        this.vertx = vertx;
        this.client = MySQLClient.createShared(vertx, new VertxDatabaseConfig().getDBConfig());
    }

    public void getAll(RoutingContext context){
        this.client.getConnection(res -> {
            if (res.succeeded()) {
                SQLConnection connection = res.result();
                connection.query("Select * from Model", resSet -> {
                    if (resSet.succeeded()) {
                        if (resSet.result().getNumRows() != 0) {
                            context.response()
                                    .putHeader("content-type", "application/json; charset=utf-8")
                                    .end(Json.encodePrettily(resSet.result().getRows()));
                        } else {
                            context.response().end(new JsonObject().put("result", "Error with Query.").encode());
                        }
                    }
                    connection.close();
                });

            } else {
                context.fail(500);
            }

        });
    }

    public void getModelByMarkInformations(RoutingContext context){

        System.out.println(context.request().params().toString());
        int id = Integer.parseInt(context.request().getParam("id"));

        if (id == 0) {
            context.response().end(new JsonObject().put("result", "Tous les champs ne sont pas remplis !").encodePrettily());
        } else {
            getModelByMark(context,id);
        }

    }

    public void getModelByMark(RoutingContext context, int id){
        this.client.getConnection(res -> {
            if (res.succeeded()) {
                JsonArray params = new JsonArray().add(id);

                SQLConnection connection = res.result();
                connection.queryWithParams("Select * from Model Where markId = ?", params, resSet -> {
                    if (resSet.succeeded()) {
                        if (resSet.result().getNumRows() != 0) {
                            context.response()
                                    .putHeader("content-type", "application/json; charset=utf-8")
                                    .end(Json.encodePrettily(resSet.result().getRows()));
                        } else {
                            context.response().end(new JsonObject().put("result", "Error with Query.").encode());
                        }
                    }
                    connection.close();
                });

            } else {
                context.fail(500);
            }

        });
    }


}
