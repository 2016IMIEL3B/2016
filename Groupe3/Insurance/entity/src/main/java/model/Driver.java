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
@Table(name="driver")
public class Driver {
	@Id
	@Column(name="idDriver")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	@Column(name="drivingLicenseDate")
	Date drivingLicenceDate;

	@Column(name="accidentNumber")
	int accidentNumber;

	@Column(name="bonusMalus")
	int bonusMalus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idUser")
	private User user;

	public Driver(Date drivingLicenceDate, int accidentNumber, int bonusMalus, User user) {
		this.drivingLicenceDate = drivingLicenceDate;
		this.accidentNumber = accidentNumber;
		this.bonusMalus = bonusMalus;
		this.user = user;
	}

	protected Driver() {}

	public Date getDrivingLicenceDate() {
		return drivingLicenceDate;
	}

	public void setDrivingLicenceDate(Date drivingLicenceDate) {
		this.drivingLicenceDate = drivingLicenceDate;
	}

	public int getAccidentNumber() {
		return accidentNumber;
	}

	public void setAccidentNumber(int accidentNumber) {
		this.accidentNumber = accidentNumber;
	}

	public int getBonusMalus() {
		return bonusMalus;
	}

	public void setBonusMalus(int bonusMalus) {
		this.bonusMalus = bonusMalus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
