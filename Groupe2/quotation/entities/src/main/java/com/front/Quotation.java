package com.front;

import com.back.Fuel;
import com.back.Insurance;
import com.back.Mark;
import com.back.Model;

import javax.persistence.*;

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

    /**
     * Quotation UserId.
     */
    private int userId;

    /**
     * Quotation TypeQuotation.
     */
    @ManyToOne
    @JoinColumn(name = "typeQuotationId")
    private TypeQuotation typeQuotation;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TypeQuotation getTypeQuotation() {
        return typeQuotation;
    }

    public void setTypeQuotation(TypeQuotation typeQuotation) {
        this.typeQuotation = typeQuotation;
    }
}