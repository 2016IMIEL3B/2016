package com.group4.front.controller.model;

import com.group4.front.entities.Item;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteCar;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

public class QuoteCarModel {

    private QuoteCar quoteCar;
    private Quote quote;
    private String userName;
    private List<Item> brands;
    private List<Item> fuels;

    public QuoteCar getQuoteCar() {
        return quoteCar;
    }

    public void setQuoteCar(QuoteCar quoteCar) {
        this.quoteCar = quoteCar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Item> getBrands() {
        return brands;
    }

    public void setBrands(List<Item> brands) {
        this.brands = brands;
    }

    public List<Item> getFuels() {
        return fuels;
    }

    public void setFuels(List<Item> fuels) {
        this.fuels = fuels;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }
}
