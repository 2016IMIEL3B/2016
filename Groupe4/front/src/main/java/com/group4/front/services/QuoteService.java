package com.group4.front.services;


import com.group4.front.dao.QuoteCarRepository;
import com.group4.front.dao.QuoteHomeRepository;
import com.group4.front.dao.QuoteRepository;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteCar;
import com.group4.front.entities.QuoteHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService implements IQuoteService {

    @Autowired
    private QuoteRepository quoteDAO;
    @Autowired
    private QuoteHomeRepository quoteHomeDAO;
    @Autowired
    private QuoteCarRepository quoteCarDAO;

    @Override
    public QuoteCar getQuoteCarById(int id) {
        return quoteCarDAO.findOne(id);
    }

    @Override
    public QuoteHome getQuoteHomeById(int id) {
        return quoteHomeDAO.findOne(id);
    }

    @Override
    public Quote getQuoteById(int id) { return quoteDAO.findOne(id); }

    @Override
    public Iterable<Quote> getAll() {
        return this.quoteDAO.findAll();
    }

    public void insertQuoteCar(QuoteCar quoteCar) {
        this.quoteCarDAO.save(quoteCar);
    }

    public void insertQuote(Quote quote) {
        this.quoteDAO.save(quote);
    }

    public void insertQuoteHome(QuoteHome quoteHome) {
        this.quoteHomeDAO.save(quoteHome);
    }
}
