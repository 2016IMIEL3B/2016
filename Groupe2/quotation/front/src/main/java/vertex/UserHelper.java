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

        // Recuperer les données liées au formulaire du User
        JsonObject object = context.getBodyAsJson();

        // Recuperer l'id de l'utilisateur stocké dans la session
        int idUser = 1;

        User user  =  new User();

        user.setLastName(object.getString("lastName"));
        user.setFirstName(object.getString("firstName"));
        user.setLogin(object.getString("login"));
        user.setPassword(object.getString("password"));

        System.out.println(user.getLastName());

        if (user.getLastName() == null || user.getFirstName() == null || user.getLogin() == null || user.getPassword() == null) {
            context.response().end(new JsonObject().put("result", "Tous les champs ne sont pas remplis !").encodePrettily());
        } else {
            updateUserInformations(context,idUser, user);
        }

    }

    public void updateUserInformations(RoutingContext context, int idUser, User user){
        this.client.getConnection(res -> {
            System.out.println("conn -> " + res.succeeded());
            if (res.succeeded()) {

                JsonArray params = new JsonArray().add(user.getLastName()).add(user.getFirstName()).add(user.getLogin()).add(user.getPassword()).add(idUser);

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
                context.response().end(new JsonObject().put("result", "Error with Database connection.").encodePrettily());
            }

        });
    }

    public void close(){
        client.close();
    }

}
