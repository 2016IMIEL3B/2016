package com.groupe4.main;

import com.groupe4.dao.IQuoteRepository;
import com.groupe4.dao.QuoteRepository;
import com.groupe4.entity.Quote;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;

/**
 * Created by Link on 23/03/2016.
 */
public class QuoteService {

    /**
     * Quote Dao
     */
    private IQuoteRepository quoteDao;

    /**
     * Quote Service
     */
    public QuoteService() {
        this.quoteDao = new QuoteRepository();
    }

    /**
     * Return a list of Quote by userId
     *
     * @param userId
     * @param handler
     */
    public void getQuotesByUser(Integer userId, Handler<AsyncResult<List<Quote>>> handler) {
        this.quoteDao.getQuotesByUser(userId, handler);
    }

    /**
     * Return true if succeed
     *
     * @param quote
     * @param handler
     */
    public void createQuote(Quote quote, Handler<AsyncResult<Boolean>> handler) {
        this.quoteDao.createQuote(quote, handler);
    }

}