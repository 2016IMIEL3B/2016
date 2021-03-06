package vertex;

import config.VertxDatabaseConfig;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class HeaterTypeHelper {

    private Vertx vertx;
    private AsyncSQLClient client;

    public HeaterTypeHelper(Vertx vertx) {
        this.vertx = vertx;
        this.client = MySQLClient.createShared(vertx, new VertxDatabaseConfig().getDBConfig());
    }

    public void getAll(RoutingContext context){
        this.client.getConnection(res -> {
            if (res.succeeded()) {
                SQLConnection connection = res.result();
                connection.query("Select * from HeaterType", resSet -> {
                    if (resSet.succeeded()) {
                        if (resSet.result().getNumRows() != 0) {
                            context.response()
                                    .putHeader("content-type", "application/json; charset=utf-8")
                                    .end(Json.encodePrettily(resSet.result().getRows()));
                        } else {
                            context.fail(401);
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
