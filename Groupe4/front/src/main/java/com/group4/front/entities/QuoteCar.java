package com.group4.front.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class QuoteCar extends Quote {

    private String brand;
    private String model;
    private String fuel;
    private int taxHorsepower;
    private Date dateLicence;
    private int numberAccident;
    private float bonusMalus;
    private boolean garage;
    private String driver;
    private String secondaryDriver;
    private String address;
    private boolean allRisk;
    private boolean tiers;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

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

    public int getTaxHorsepower() {
        return taxHorsepower;
    }

    public void setTaxHorsepower(int taxHorsepower) {
        this.taxHorsepower = taxHorsepower;
    }

    public Date getDateLicence() {
        return dateLicence;
    }

    public void setDateLicence(Date dateLicence) {
        this.dateLicence = dateLicence;
    }

    public int getNumberAccident() {
        return numberAccident;
    }

    public void setNumberAccident(int numberAccident) {
        this.numberAccident = numberAccident;
    }

    public float getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(float bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getSecondaryDriver() {
        return secondaryDriver;
    }

    public void setSecondaryDriver(String secondaryDriver) {
        this.secondaryDriver = secondaryDriver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAllRisk() {
        return allRisk;
    }

    public void setAllRisk(boolean allRisk) {
        this.allRisk = allRisk;
    }

    public boolean isTiers() {
        return tiers;
    }

    public void setTiers(boolean tiers) {
        this.tiers = tiers;
    }
}
