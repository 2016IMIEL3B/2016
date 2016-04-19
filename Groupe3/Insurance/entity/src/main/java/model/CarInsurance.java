/**
 * 
 */
package model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Enzo
 *
 */
@Entity
@Table(name="carinsurance")
public class CarInsurance {
	@Id
	@Column(name="idCarInsurance")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="secondaryDriver")
	String secondaryDriver;
	@Column(name="allRisks")
	int allRisks;
	@Column(name="third")
	int third;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idInsurance")
	private Insurance insurance;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idVehicule")
	private Vehicule vehicule;

	public CarInsurance() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSecondaryDriver() {
		return secondaryDriver;
	}
	public void setSecondaryDriver(String secondaryDriver) {
		this.secondaryDriver = secondaryDriver;
	}
	public int getAllRisks() {
		return allRisks;
	}
	public void setAllRisks(int allRisks) {
		this.allRisks = allRisks;
	}
	public int getThird() {
		return third;
	}
	public void setThird(int third) {
		this.third = third;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}
