package com.group4.front.entities;

import javax.persistence.*;

@Entity
public class QuoteHome {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeHome;
    private int area;
    private int numberRoom;
    private int floor;
    private int numberBathroom;
    private boolean garage;
    private int groundArea;
    private int terraceArea;
    private String typeHeating;
    private String formula;
    private String address;
    private int idQuote;

    public String getTypeHome() {
        return typeHome;
    }

    public void setTypeHome(String typeHome) {
        this.typeHome = typeHome;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberBathroom() {
        return numberBathroom;
    }

    public void setNumberBathroom(int numberBathroom) {
        this.numberBathroom = numberBathroom;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public int getGroundArea() {
        return groundArea;
    }

    public void setGroundArea(int groundArea) {
        this.groundArea = groundArea;
    }

    public int getTerraceArea() {
        return terraceArea;
    }

    public void setTerraceArea(int terraceArea) {
        this.terraceArea = terraceArea;
    }

    public String getTypeHeating() {
        return typeHeating;
    }

    public void setTypeHeating(String typeHeating) {
        this.typeHeating = typeHeating;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
