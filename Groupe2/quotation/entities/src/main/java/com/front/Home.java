package com.front;

import com.back.Formul;
import com.back.HeaterType;
import com.back.HomeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Home {

    /**
     * Car id.
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
     * Home Type.
     */
    private int homeTypeId;

    /**
     * Home Type.
     */
    private int heaterTypeId;

    /**
     * Formul.
     */
    private int formulId;

    public int getFormul() {
        return formulId;
    }

    public void setFormul(int formulId) {
        this.formulId = formulId;
    }

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

    public int getHomeTypeId() {
        return homeTypeId;
    }

    public void setHomeTypeId(int homeTypeId) {
        this.homeTypeId = homeTypeId;
    }

    public int getHeaterTypeId() {
        return heaterTypeId;
    }

    public void setHeaterTypeId(int heaterTypeId) {
        this.heaterTypeId = heaterTypeId;
    }
}