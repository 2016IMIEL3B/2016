package entity.front;

import entity.back.Mark;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by nico on 21/03/16.
 */
@Entity
public class Driver {

    /** Driver id. */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    /** Driver lastName. */
    private String lastName;

    /** Driver firstName. */
    private String firstName;

    /** Driver principal. */
    private boolean principal;

    /** Driver licenceDate. */
    private Date licenceDate;

    /** Driver nbCrash. */
    private int nbCrash;

    /** Driver bonus penality. */
    private float bonusPenality;

    /** Driver Car. */
    private Car car;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public Date getLicenceDate() {
        return licenceDate;
    }

    public void setLicenceDate(Date licenceDate) {
        this.licenceDate = licenceDate;
    }

    public int getNbCrash() {
        return nbCrash;
    }

    public void setNbCrash(int nbCrash) {
        this.nbCrash = nbCrash;
    }

    public float getBonusPenality() {
        return bonusPenality;
    }

    public void setBonusPenality(float bonusPenality) {
        this.bonusPenality = bonusPenality;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
