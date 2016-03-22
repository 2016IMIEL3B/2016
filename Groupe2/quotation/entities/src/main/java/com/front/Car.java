package com.front;

import com.back.Fuel;
import com.back.Insurance;
import com.back.Mark;
import com.back.Model;

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
    private Fuel fuel;

    /**
     * Car Mark.
     */
    private Mark mark;

    /**
     * Car Model.
     */
    private Model model;

    /**
     * Car Insurance.
     */
    private Insurance insurance;

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
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

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}