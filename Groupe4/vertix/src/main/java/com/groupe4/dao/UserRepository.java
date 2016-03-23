package com.groupe4.dao;

import com.groupe4.connexion.DbClient;
import com.groupe4.entity.User;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mathilde on 23/03/2016.
 */
public class UserRepository implements IUserRepository {

    @Override
    public Integer createUser(String name, String surname, String login, String password) {

        AsyncSQLClient client = DbClient.getInstance().getClient();
        client.getConnection(res -> {
            if (res.succeeded()) {
                System.out.println("OK Connexion");
                SQLConnection connection = res.result();

                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date today = Calendar.getInstance().getTime();
                String createdAt = df.format(today);
                String updatedAt = df.format(today);

                String query = "INSERT INTO user (name,surname,login,password,createdAt,updatedAt) VALUES(?,?,?,?,?,?)";
                JsonArray params = new JsonArray().add(name)
                                                  .add(surname)
                                                  .add(login)
                                                  .add(password)
                                                  .add(createdAt)
                                                  .add(updatedAt);

                connection.updateWithParams(query, params, res2 -> {
                    checkUpdateResponse(res, res2);
                });
                connection.close();

            } else {
                // Failed to get connection - deal with it
                System.out.println("NOK Connexion");
            }
        });
        return null;
    }

    @Override
    public Integer updateUser(Integer id, String name, String surname, String login, String password) {
        AsyncSQLClient client = DbClient.getInstance().getClient();
        client.getConnection(res -> {
        if (res.succeeded()) {
            System.out.println("OK Connexion");
            SQLConnection connection = res.result();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date today = Calendar.getInstance().getTime();
            String updatedAt = df.format(today);

            System.out.println(updatedAt);

            String query = "UPDATE user SET name=?, surname=?, login=?, password=?, updatedAt=? WHERE id = ?;";
            JsonArray params = new JsonArray()
                    .add(name)
                    .add(surname)
                    .add(login)
                    .add(password)
                    .add(updatedAt)
                    .add(id);

            connection.updateWithParams(query, params, res2 -> {
                checkUpdateResponse(res, res2);
            });
            connection.close();

        } else {
            // Failed to get connection - deal with it
            System.out.println("NOK Connexion");
        }
    });
        return null;
    }

    @Override
    public Integer deleteUser(Integer id) {
        AsyncSQLClient client = DbClient.getInstance().getClient();
        client.getConnection(res -> {
            if (res.succeeded()) {
                System.out.println("OK Connexion");
                SQLConnection connection = res.result();

                String query = "UPDATE user SET active = 0 where id = ?";
                JsonArray params = new JsonArray()
                        .add(id);

                connection.updateWithParams(query, params, res2 -> {
                    checkUpdateResponse(res, res2);
                });
                connection.close();

            } else {
                // Failed to get connection - deal with it
                System.out.println("NOK Connexion");
            }
        });
        return null;
    }

    @Override
    public User findById(Integer id, Handler<AsyncResult<User>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    System.out.println("OK Connexion");
                    SQLConnection connection = res.result();

                    String query = "SELECT * FROM user WHERE id = ?";
                    JsonArray params = new JsonArray().add(id);

                    connection.queryWithParams(query, params, res2 -> {
                        checkFindResponse(res, res2, handler);

                    });
                    connection.close();

                } else {
                    // Failed to get connection - deal with it
                    System.out.println("NOK Connexion");
                }
            });
        });

        return null;
    }

    @Override
    public void findByLogin(String login) {
        AsyncSQLClient client = DbClient.getInstance().getClient();
        client.getConnection(res -> {
            if (res.succeeded()) {
                System.out.println("OK Connexion");
                SQLConnection connection = res.result();

                String query = "SELECT * FROM user WHERE login = ?";
                JsonArray params = new JsonArray().add(login);

                connection.queryWithParams(query, params, res2 -> {
                    //checkFindResponse(res, res2);
                });

            } else {
                // Failed to get connection - deal with it
                System.out.println("NOK Connexion");
            }
        });
    }

    private void checkFindResponse(AsyncResult<SQLConnection> res, AsyncResult<ResultSet>res2, Handler<AsyncResult<User>> handler){
        if (res.succeeded()) {
            ResultSet resultSet = res2.result();
            List<JsonArray> results = resultSet.getResults();
            User user = new User();

            for (JsonArray row: results) {
                int userId = row.getInteger(0);
                String name = row.getString(1);
                String surname = row.getString(2);

                user.setId(row.getInteger(0));
                user.setName(row.getString(1));
                user.setSurname(row.getString(2));
                user.setLogin(row.getString(3));
                user.setPassword(row.getString(4));
                user.setActive(row.getBoolean(5));

//                System.out.println(userId);
//                System.out.println(name);
//                System.out.println(surname);
            }

            handler.handle(Future.succeededFuture(user));

        } else {
            // Failed!
            System.out.println("NOK Request");
        }
    }

    private Integer checkUpdateResponse(AsyncResult<SQLConnection> res, AsyncResult<UpdateResult>res2){
        if (res.succeeded()) {

                UpdateResult updateResult = res2.result();
                System.out.println("No. of rows updated: " + updateResult.getUpdated());
                return 1;

        } else {
            // Failed!
            System.out.println("NOK Request");
        }
    }
}
