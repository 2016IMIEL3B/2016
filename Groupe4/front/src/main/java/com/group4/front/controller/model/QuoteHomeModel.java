package com.group4.front.controller.model;

import com.group4.front.entities.Item;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteHome;

import java.util.List;

public class QuoteHomeModel {

    private QuoteHome quoteHome;
    private Quote  quote;
    private String userName;
    private List<Item> heatMode;

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

    public List<Item> getHeatMode() {
        return heatMode;
    }

    public void setHeatMode(List<Item> heatMode) {
        this.heatMode = heatMode;
    }
}
