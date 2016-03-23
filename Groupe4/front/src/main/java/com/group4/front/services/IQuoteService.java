package com.group4.front.services;

import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteCar;
import com.group4.front.entities.QuoteHome;

import java.util.Iterator;
import java.util.List;

public interface IQuoteService {

    QuoteHome getQuoteHomeById(int id);
    QuoteCar getQuoteCarById(int id);
    Iterable<Quote> getAll();
}
