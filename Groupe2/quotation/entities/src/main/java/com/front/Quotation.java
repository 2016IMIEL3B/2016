package com.front;

import com.back.Fuel;
import com.back.Insurance;
import com.back.Mark;
import com.back.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Quotation {

    /**
     * Car id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Quotation name.
     */
    private String name;

    /**
     * Quotation number.
     */
    private int number;

    /**
     * Quotation price.
     */
    private float price;

    /**
     * Quotation state.
     */
    private String state;


    /**
     * Quotation number step.
     */
    private int nbStep;

    public int getNbStep() {
        return nbStep;
    }

    public void setNbStep(int nbStep) {
        this.nbStep = nbStep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}