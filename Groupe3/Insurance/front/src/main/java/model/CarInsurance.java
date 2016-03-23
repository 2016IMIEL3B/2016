/**
 * 
 */
package model;

import java.util.Date;
import model.Insurance;

/**
 * @author Enzo
 *
 */
public class CarInsurance extends Insurance {
	
	int id;
	String secondaryDriver;
	int allRisks;
	int third;
	
	public CarInsurance(String name, Date created_date, int price, String summary, int step, Statement statement,
			User user, String secondaryDriver, int allRisks, int third) {
		super(name, created_date, price, summary, step, statement, user);
		this.secondaryDriver = secondaryDriver;
		this.allRisks = allRisks;
		this.third = third;
	}
	
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
