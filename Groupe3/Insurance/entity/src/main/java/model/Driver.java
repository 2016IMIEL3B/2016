/**
 * 
 */
package model;

import java.util.Date;

public class Driver extends User {
	int id;
	Date drivingLicenceDate;
	int accidentNumber;
	int bonusMalus;

	public Driver(String firstName, String lastName, String username, String password, Group group, Date drivingLicenceDate, int accidentNumber, int bonusMalus) {
		super(firstName, lastName, username, password, group);
		this.drivingLicenceDate = drivingLicenceDate;
		this.accidentNumber = accidentNumber;
		this.bonusMalus = bonusMalus;
	}

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
