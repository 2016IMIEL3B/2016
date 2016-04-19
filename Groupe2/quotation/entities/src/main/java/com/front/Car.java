package com.front;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Car {

    /**
     * Car id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Car tax horse power.
     */
    private int taxableHorsePower;

    /**
     * Car is sleeping in garage.
     */
    private boolean sleepGarage;

    /**
     * Car Address.
     */
    private String address;

    /**
     * Car fuel.
     */
    private String fuel;

    /**
     * Car Mark.
     */
    private String mark;

    /**
     * Car Model.
     */
    private String model;

    /**
     * Car Insurance.
     */
    private String insurance;

    /**
     * Car is Tier
     */
    private boolean tier;

    /** Car Quotation. */
    @OneToOne
    @JoinColumn(name = "quotationId")
    private Quotation quotation;

    public String getInsurance() {
        return this.insurance;
    }

    public void setInsurance(String insuranceId) {
        this.insurance = insuranceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaxableHorsePower() {
        return taxableHorsePower;
    }

    public void setTaxableHorsePower(int taxableHorsePower) {
        this.taxableHorsePower = taxableHorsePower;
    }

    public boolean isSleepGarage() {
        return sleepGarage;
    }

    public void setSleepGarage(boolean sleepGarage) {
        this.sleepGarage = sleepGarage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Quotation getQuotation() { return quotation; }

    public void setQuotation(Quotation quotation) { this.quotation = quotation; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isTier() {
        return sleepGarage;
    }

    public void setTier(boolean tier) {
        this.tier = tier;
    }
}