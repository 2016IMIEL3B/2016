package com.groupe4.dao;

import com.groupe4.entity.Quote;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

import java.util.List;

/**
 * Created by Link on 22/03/2016.
 */
public class QuoteRepository {

    private SQLConnection connection;

    public QuoteRepository(SQLConnection connection) {
        this.connection = connection;
    }

    /*
    public List<Quote> getQuotes() {
        List<Quote> listQuote;
        connection.query("SELECT * FROM quote", res2 -> {
            if (res2.succeeded()) {
                ResultSet rs = res2.result();

                List<String> columnNames = rs.getColumnNames();
                List<JsonArray> results = rs.getResults();



                for (JsonArray row: results) {
                    Quote nQuote = new Quote();
                    //listQuote.add(nQuote);

                    //System.out.println("User "+row.getString(1));

                }
            }
        });
        return List<Quote> listQuote;
    }
    */
}
