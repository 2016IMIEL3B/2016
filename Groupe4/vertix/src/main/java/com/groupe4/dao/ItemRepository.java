package com.groupe4.dao;

import com.groupe4.connection.DbClient;
import com.groupe4.entity.Item;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Item repository.
 */
public class ItemRepository implements IItemRepository {
    /**
     * Return a list of Item by Key.
     * @param key
     * @return
     */
    @Override
    public void findItemListByKey(String key, Handler<AsyncResult<List<Item>>> handler) {
        Vertx.currentContext().owner().runOnContext(x -> {
            AsyncSQLClient client = DbClient.getInstance().getClient();

            client.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    String query = "SELECT * FROM list WHERE listKey = ?";
                    JsonArray params = new JsonArray();
                    params.add(key);

                    this.resolveQuery(connection, query, params, handler);
                } else {
                    handler.handle(Future.failedFuture("Error in ItemRepository : " + res.cause()));
                }
            });
        });
    }

    /**
     * Return a list of Item by id.
     *
     * @param id
     * @param handler
     */
    @Override
    public void findItemListByParentId(Integer id, Handler<AsyncResult<List<Item>>> handler) {
        Vertx.currentContext().owner().runOnContext(x -> {
            AsyncSQLClient client = DbClient.getInstance().getClient();

            client.getConnection(res -> {
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    String query = "SELECT * FROM list WHERE parent_id = ?";
                    JsonArray params = new JsonArray();
                    params.add(id);

                    this.resolveQuery(connection, query, params, handler);
                } else {
                    handler.handle(Future.failedFuture("Error in ItemRepository : " + res.cause()));
                }
            });
        });
    }

    /**
     * Resolve query.
     *
     * @param connection
     * @param query
     * @param params
     * @param handler
     */
    private void resolveQuery(SQLConnection connection, String query, JsonArray params, Handler<AsyncResult<List<Item>>> handler) {
        connection.queryWithParams(query, params, response -> {
            if (response.succeeded()) {
                List<Item> items = new ArrayList<Item>();
                ResultSet result = response.result();
                List<JsonArray> rows = result.getResults();

                for (JsonArray row : rows) {
                    Item item = this.populateItem(row);
                    items.add(item);
                }

                handler.handle(Future.succeededFuture(items));
            } else {
                handler.handle(Future.failedFuture("Error in ItemRepository : " + response.cause()));
            }

            connection.close();
        });
    }

    /**
     * Populate an Item from request response.
     *
     * @param row
     * @return
     */
    private Item populateItem(JsonArray row) {
        Item item = new Item();
        item.setId(row.getInteger(0));
        item.setListKey(row.getString(1));
        item.setValue(row.getString(2));
        item.setParentId(row.getInteger(3));

        return item;
    }
}
