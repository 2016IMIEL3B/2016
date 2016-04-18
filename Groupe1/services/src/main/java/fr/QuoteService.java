package fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joe on 24/03/2016.
 */
@Service
public class QuoteService implements IQuoteService{

    @Autowired
    private QuoteRepository quoteDao;

    @Override
    public Quote save(Quote quote) {
        return quoteDao.save(quote);
    }

    @Override
    public Quote findOne(Integer id) { return quoteDao.findOne(id) ;}

    @Override
    public Iterable<Quote> findAll() {
        return quoteDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
