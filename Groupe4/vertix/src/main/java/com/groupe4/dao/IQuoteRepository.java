package com.groupe4.dao;

import com.groupe4.entity.Quote;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Link on 23/03/2016.
 */
public interface IQuoteRepository {
    void createQuote(Quote quote);
    void getQuotesByUser(Integer userId,Handler<AsyncResult<List<Quote>>> handler);
}
