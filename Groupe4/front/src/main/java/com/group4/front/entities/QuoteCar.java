package com.group4.front.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class QuoteCar {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /** The brand. */
    private String brand;
    /** The model. */
    private String model;
    /** The fuel. */
    private String fuel;
    /** The taxHorsepower. */
    private int taxHorsepower;
    /** The dateLicence. */
    private Date dateLicence;
    /** The numberAccident. */
    private int numberAccident;
    /** The bonusMalus. */
    private float bonusMalus;
    /** The garage. */
    private boolean garage;
    /** The driver. */
    private String driver;
    /** The secondaryDriver. */
    private String secondaryDriver;
    /** The address. */
    private String address;
    /** The allRisk. */
    private boolean allRisk;
    /** The tiers. */
    private boolean tiers;
    /** The idQuote. */
    private int idQuote;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuote() {
        return idQuote;
    }

    public void setIdQuote(int idQuote) {
        this.idQuote = idQuote;
    }
}
