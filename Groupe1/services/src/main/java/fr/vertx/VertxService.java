package fr.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

public class VertxService extends AbstractVerticle {

public void start() {



JsonObject jsonConfig  = new JsonObject()
        .put("url","localhost:3306")
        .put("user","root");


	JDBCClient client = JDBCClient.createShared(vertx, jsonConfig);

	client.getConnection(res -> {
		  if (res.succeeded()) {

		    SQLConnection connection = res.result();

		    connection.query("SELECT * FROM user", res2 -> {
		      if (res2.succeeded()) {

		        ResultSet rs = res2.result();
		        // Do something with results
                  System.err.println("OKOKOKOK");
		      }
		    });
		  } else {
		    // Failed to get connection - deal with it
              System.err.println("failed");
		  }
		});
}

}

