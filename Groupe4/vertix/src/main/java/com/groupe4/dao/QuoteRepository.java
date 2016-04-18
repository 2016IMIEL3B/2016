package com.groupe4.dao;

import com.groupe4.connection.DbClient;
import com.groupe4.entity.Quote;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.sql.UpdateResult;

import java.util.ArrayList;
import java.util.List;

public class QuoteRepository implements IQuoteRepository {

    /**
     *
     * @param quote
     * @param handler
     */
    @Override
    public void createQuote(Quote quote, Handler<AsyncResult<Boolean>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    //System.out.println("Connexion OK");
                    String query = "INSERT INTO quote (userName,userSurname,userId,typeQuote,guarantee,price) " +
                            "VALUES (?, ?, ?, ?, ?, ?)";
                    JsonArray params = new JsonArray()
                            .add(quote.getUserName())
                            .add(quote.getUserSurname())
                            .add(quote.getUserId())
                            .add(quote.getTypeQuote())
                            .add(quote.getGuarantee())
                            .add(quote.getPrice());

                    connection.updateWithParams(query, params, res2 -> {
                        if (res2.succeeded()) {
                            UpdateResult updateResult = res2.result();
                            handler.handle(Future.succeededFuture(true));
                        } else {
                            handler.handle(Future.failedFuture("Insert NOK"));
                        }
                    });
                    connection.close();
                } else {
                    System.out.println("Connexion NOK");
                }
            });
        });
    }

    /**
     *
     * @param userId
     * @param handler
     */
    @Override
    public void getQuotesByUser(Integer userId, Handler<AsyncResult<List<Quote>>> handler) {
        Vertx.currentContext().owner().runOnContext(x-> {
            AsyncSQLClient client = DbClient.getInstance().getClient();
            ArrayList<Quote> listQuote = new ArrayList<Quote>();
            client.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    //System.out.println("Connexion OK");
                    String query = "SELECT * FROM quote WHERE userId = ?";
                    JsonArray params = new JsonArray().add(userId);
                    connection.queryWithParams(query, params, resGet -> {
                        if (resGet.succeeded()) {
                            ResultSet rs = resGet.result();
                            List<JsonArray> results = rs.getResults();
                            for (JsonArray row : results) {
                                Quote nQuote = new Quote();
                                nQuote.setId(row.getInteger(0));
                                nQuote.setUserName(row.getString(1));
                                nQuote.setUserSurname(row.getString(2));
                                nQuote.setUserId(row.getInteger(3));
                                nQuote.setTypeQuote(row.getString(4));
                                nQuote.setGuarantee(row.getString(5));
                                nQuote.setPrice(row.getInteger(6));
                                listQuote.add(nQuote);
                            }
                            handler.handle(Future.succeededFuture(listQuote));
                        }
                    });
                    connection.close();
                } else {
                    //System.out.println("Connexion NOK");
                    handler.handle(Future.failedFuture("Connexion NOK"));
                }
            });
        });
    }

}
