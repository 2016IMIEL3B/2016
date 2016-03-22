package com.front;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}