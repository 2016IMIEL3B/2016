package fr;

// Generated 22 mars 2016 11:08:52 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class Usera implements java.io.Serializable {

	private Integer id;
	private Account account;
	private Address address;
	private String firstname;
	private String lastname;
	private int bonus;
	private Date drivingLicenceDate;
	private int accidentNumber;
	private boolean isSecondary;
	private Set quotes = new HashSet(0);

	public Usera() {
	}

	public Usera(Account account, Address address, String firstname,
			String lastname, int bonus, Date drivingLicenceDate,
			int accidentNumber, boolean isSecondary) {
		this.account = account;
		this.address = address;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bonus = bonus;
		this.drivingLicenceDate = drivingLicenceDate;
		this.accidentNumber = accidentNumber;
		this.isSecondary = isSecondary;
	}

	public Usera(Account account, Address address, String firstname,
			String lastname, int bonus, Date drivingLicenceDate,
			int accidentNumber, boolean isSecondary, Set quotes) {
		this.account = account;
		this.address = address;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bonus = bonus;
		this.drivingLicenceDate = drivingLicenceDate;
		this.accidentNumber = accidentNumber;
		this.isSecondary = isSecondary;
		this.quotes = quotes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getBonus() {
		return this.bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public Date getDrivingLicenceDate() {
		return this.drivingLicenceDate;
	}

	public void setDrivingLicenceDate(Date drivingLicenceDate) {
		this.drivingLicenceDate = drivingLicenceDate;
	}

	public int getAccidentNumber() {
		return this.accidentNumber;
	}

	public void setAccidentNumber(int accidentNumber) {
		this.accidentNumber = accidentNumber;
	}

	public boolean isIsSecondary() {
		return this.isSecondary;
	}

	public void setIsSecondary(boolean isSecondary) {
		this.isSecondary = isSecondary;
	}

	public Set getQuotes() {
		return this.quotes;
	}

	public void setQuotes(Set quotes) {
		this.quotes = quotes;
	}

}
