package com.group4.front.controller.model;

import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteHome;

public class QuoteHomeModel {

    private QuoteHome quoteHome;
    private Quote  quote;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public QuoteHome getQuoteHome() {
        return quoteHome;
    }

    public void setQuoteHome(QuoteHome quoteHome) {
        this.quoteHome = quoteHome;
    }

    public Quote getQuote() {return quote; }

    public void setQuote(Quote quote) { this.quote = quote; }
}
