package vertex;

import com.back.User;
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
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by kevin on 24/03/16.
 */
public class UserHelper {

    private Vertx vertx;
    private AsyncSQLClient client;
    private JWTAuth authProvider;

    public UserHelper(Vertx vertx) {
        this.vertx = vertx;
        this.client = MySQLClient.createShared(vertx, new VertxDatabaseConfig().getDBConfig());
        this.authProvider = JWTAuth.create(vertx, new VertxAuthConfig().getAuthConfig());
    }

    public void getUserInformationsForm(RoutingContext context){

        User user  =  new User();
        System.out.println(context.request().params().toString());
        user.setId(Integer.parseInt(context.request().getParam("id")));
        user.setLastName(context.request().getParam("lastName"));
        user.setFirstName(context.request().getParam("firstName"));
        user.setLogin(context.request().getParam("login"));
        user.setPassword(context.request().getParam("password"));

        System.out.println(user.getLastName());

        if (user.getLastName() == null || user.getFirstName() == null || user.getLogin() == null || user.getPassword() == null) {
            context.response().end(new JsonObject().put("result", "Tous les champs ne sont pas remplis !").encodePrettily());
        } else {
            updateUserInformations(context,user);
        }

    }

    public void updateUserInformations(RoutingContext context, User user){
        this.client.getConnection(res -> {
            System.out.println("conn -> " + res.succeeded());
            if (res.succeeded()) {

                JsonArray params = new JsonArray().add(user.getLastName()).add(user.getFirstName()).add(user.getLogin()).add(user.getPassword()).add(user.getId());

                SQLConnection connection = res.result();
                connection.updateWithParams("Update User SET lastName = ?, firstName = ?, login = ?, password = ?  where id = ?", params, resSet -> {
                    System.out.println("resSet -> " + resSet.succeeded());
                    if (resSet.succeeded()){
                            context.response().end("OK");
                    } else {
                        context.response().end(new JsonObject().put("result", "Error with the Query").encodePrettily());
                    }
                    connection.close();
                });
            } else {
                context.fail(500);
            }

        });
    }

    public void close(){
        client.close();
    }

}
