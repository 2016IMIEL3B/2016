package com.back;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int nbStreet;
    private String nameStreet;
    private String zip;
    private String town;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbStreet() {
        return this.nbStreet;
    }

    public void setNbStreet(int nbStreet) {
        this.nbStreet = nbStreet;
    }

    public String setNameStreet() {
        return this.nameStreet;
    }

    public void getNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}