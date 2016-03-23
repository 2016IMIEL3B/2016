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
    private int fuelId;

    /**
     * Car Mark.
     */
    private int markId;

    /**
     * Car Model.
     */
    private int modelId;

    /**
     * Car Insurance.
     */
    private int insuranceId;

    /** Car Quotation. */
    @OneToOne
    @JoinColumn(name = "quotationId")
    private Quotation quotation;

    public int getInsuranceId() {
        return this.insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
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

    public int getFuelId() {
        return this.fuelId;
    }

    public void setFuelId(int fuelId) {
        this.fuelId = fuelId;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Quotation getQuotation() { return quotation; }

    public void setQuotation(Quotation quotation) { this.quotation = quotation; }
}