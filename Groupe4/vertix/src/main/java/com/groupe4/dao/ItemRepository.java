package com.groupe4.dao;


import com.groupe4.connexion.DbClient;
import com.groupe4.entity.Item;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;

import java.util.List;

public class ItemRepository implements IItemRepository {
    @Override
    public List<Item> findItemListByKey(String key) {
        AsyncSQLClient client = DbClient.getInstance().getClient();

        Item<Quote> listQuote;
        connection.query("SELECT * FROM quote", res2 -> {
            if (res2.succeeded()) {
                ResultSet rs = res2.result();

                Item<String> columnNames = rs.getColumnNames();
                Item<JsonArray> results = rs.getResults();



                for (JsonArray row: results) {
                    Quote nQuote = new Quote();
                    //listQuote.add(nQuote);

                    //System.out.println("User "+row.getString(1));

                }
            }
        });
        return Item<Quote> listQuote;
    }
}
