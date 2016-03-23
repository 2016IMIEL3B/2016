package com.groupe4.main;

import com.groupe4.dao.IQuoteRepository;
import com.groupe4.dao.QuoteRepository;
import com.groupe4.entity.Quote;

import java.util.List;

/**
 * Created by Link on 23/03/2016.
 */
public class QuoteService {

    private QuoteRepository quoteRepository;


    public List<Quote> getQuotes(Integer userId) {
        return quoteRepository.getQuotesByUser(userId);
    }


    IQuoteRepository test = new QuoteRepository();
    test.getQuotesByUser(1,x->{
        List<Quote> testQuote = x.result();
        for (final Quote value : testQuote) {
            System.out.println(value.getUserName());
        }
    });


}
