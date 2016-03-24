package com.groupe4.dao;

import com.groupe4.connection.DbClient;
import com.groupe4.entity.User;
import com.sun.deploy.util.StringUtils;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;
import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mathilde on 23/03/2016.
 */
public class UserRepository implements IUserRepository {

    private int id;

    @Override
    public void createUser(User user, Handler<AsyncResult<Integer>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    System.out.println("OK Connexion");
                    SQLConnection connection = res.result();

                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date today = Calendar.getInstance().getTime();
                    String createdAt = df.format(today);
                    String updatedAt = df.format(today);

                    String query = "INSERT INTO user (name,surname,login,password,createdAt,updatedAt,roles) " +
                            "VALUES(?,?,?,?,?,?,?)";
                    JsonArray params = new JsonArray()
                            .add(user.getName())
                            .add(user.getSurname())
                            .add(user.getLogin())
                            .add(user.getPassword())
                            .add(createdAt)
                            .add(updatedAt)
                            .add(StringUtils.join(user.getRoles(), ","));

                    connection.updateWithParams(query, params, res2 -> {
                        checkUpdateResponse(res, res2, handler);
                    });
                    connection.close();

                } else {
                    handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
                }
            });
        });
    }

    @Override
    public void updateUser(User user, Handler<AsyncResult<Integer>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    System.out.println("OK Connexion");
                    SQLConnection connection = res.result();

                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date today = Calendar.getInstance().getTime();
                    String updatedAt = df.format(today);

                    System.out.println(updatedAt);

                    String query = "UPDATE user SET name=?, surname=?, login=?, password=?, updatedAt=?, roles=? " +
                            "WHERE id = ?";
                    JsonArray params = new JsonArray()
                            .add(user.getName())
                            .add(user.getSurname())
                            .add(user.getLogin())
                            .add(user.getPassword())
                            .add(updatedAt)
                            .add(StringUtils.join(user.getRoles(), ","))
                            .add(user.getId());

                    connection.updateWithParams(query, params, res2 -> {
                        checkUpdateResponse(res, res2, handler);
                    });
                    connection.close();

                } else {
                    handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
                }
            });
        });
    }

    @Override
    public void deleteUser(Integer id, Handler<AsyncResult<Integer>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    System.out.println("OK Connexion");
                    SQLConnection connection = res.result();

                    String query = "UPDATE user SET active = 0 where id = ?";
                    JsonArray params = new JsonArray()
                            .add(id);

                    connection.updateWithParams(query, params, res2 -> {
                        checkUpdateResponse(res, res2, handler);
                    });
                    connection.close();

                } else {
                    handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
                }
            });
        });
    }

    @Override
    public void findById(Integer id, Handler<AsyncResult<User>> handler) {
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
                    handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
                }
            });
        });
    }

    @Override
    public void findByLogin(String login, Handler<AsyncResult<User>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    System.out.println("OK Connexion");
                    SQLConnection connection = res.result();

                    String query = "SELECT * FROM user WHERE login = ?";
                    JsonArray params = new JsonArray().add(login);

                    connection.queryWithParams(query, params, res2 -> {
                        checkFindResponse(res, res2, handler);
                    });

                } else {
                    handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
                }
            });
        });
    }

    private void checkFindResponse(AsyncResult<SQLConnection> res, AsyncResult<ResultSet>res2, Handler<AsyncResult<User>> handler){
        if (res.succeeded()) {
            ResultSet resultSet = res2.result();
            List<JsonArray> results = resultSet.getResults();
            User user = new User();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

            for (JsonArray row: results) {
                try {
                    user.setId(row.getInteger(0));
                    user.setName(row.getString(1));
                    user.setSurname(row.getString(2));
                    user.setLogin(row.getString(3));
                    user.setPassword(row.getString(4));
                    if (row.getInteger(5).equals(1)) {
                        user.setActive(true);
                    } else {
                        user.setActive(false);
                    }
                    user.setCreatedAt(dateFormatter.parse(row.getString(6)));
                    user.setUpdatedAt(new DateTime(row.getString(7)));
                    user.setRoles(Arrays.asList(row.getString(8).split(",")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            handler.handle(Future.succeededFuture(user));
        } else {
            handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
        }
    }

    private void checkUpdateResponse(AsyncResult<SQLConnection> res, AsyncResult<UpdateResult>res2, Handler<AsyncResult<Integer>> handler){
        if (res.succeeded()) {

                UpdateResult updateResult = res2.result();
                Integer id =  updateResult.getKeys().getInteger(0);

                handler.handle(Future.succeededFuture(id));
        } else {
            handler.handle(Future.failedFuture("Error in UserRepository : " + res.cause()));
        }
    }
}
