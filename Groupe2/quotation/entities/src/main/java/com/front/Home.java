package com.front;

import com.back.Formul;
import com.back.HeaterType;
import com.back.HomeType;

import javax.persistence.*;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Home {

    /**
     * Home id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Home name.
     */
    private float surface;

    /**
     * Home number room.
     */
    private int nbRoom;

    /**
     * Home number floor.
     */
    private int floor;

    /**
     * Home number bathroom.
     */
    private int nbBathroom;

    /**
     * Home garage.
     */
    private boolean garage;

    /**
     * Home surface ground.
     */
    private int surfaceGround;

    /**
     * Home surface terrace.
     */
    private int surfaceTerrace;

    /**
     * Home Address.
     */
    private String address;

    /**
     * Home Type.
     */
    private String homeType;

    /**
     * Home Type.
     */
    private String heaterType;

    /**
     * Home Formul.
     */
    private String formul;

    /** Home Quotation. */
    @OneToOne
    @JoinColumn(name = "quotationId")
    private Quotation quotation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public int getNbRoom() {
        return nbRoom;
    }

    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    public int getFloor() { return floor; }

    public void setFloor(int floor) { this.floor = floor; }

    public int getNbBathroom() {
        return nbBathroom;
    }

    public void setNbBathroom(int nbBathroom) {
        this.nbBathroom = nbBathroom;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public int getSurfaceGround() {
        return surfaceGround;
    }

    public void setSurfaceGround(int surfaceGround) {
        this.surfaceGround = surfaceGround;
    }

    public int getSurfaceTerrace() {
        return surfaceTerrace;
    }

    public void setSurfaceTerrace(int surfaceTerrace) {
        this.surfaceTerrace = surfaceTerrace;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Quotation getQuotation() { return quotation; }

    public void setQuotation(Quotation quotation) { this.quotation = quotation; }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public String getHeaterType() {
        return heaterType;
    }

    public void setHeaterType(String heaterType) {
        this.heaterType = heaterType;
    }

    public String getFormul() {
        return formul;
    }

    public void setFormul(String formul) {
        this.formul = formul;
    }
}