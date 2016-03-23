package com.group4.front.controller.model;

import com.group4.front.entities.QuoteCar;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

public class QuoteCarModel {

    private QuoteCar quoteCar;
    private String userName;

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
}
