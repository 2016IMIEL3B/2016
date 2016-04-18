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

	public CarInsurance(String secondaryDriver, int allRisks, int third, Insurance insurance) {
		this.secondaryDriver = secondaryDriver;
		this.allRisks = allRisks;
		this.third = third;
		this.insurance = insurance;
	}

	protected CarInsurance() {}
	
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

}
