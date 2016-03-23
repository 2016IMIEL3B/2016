/**
 * 
 */
package model;

import model.Driver;

/**
 * @author Enzo
 *
 */
public class Vehicule {
	int id;
	String brand;
	String model;
	String fuel;
	int horsePowerTax;
	int inGarage;
	Driver driver;
	
	public Vehicule(String brand, String model, String fuel, int horsePowerTax, int inGarage, Driver driver) {
		super();
		this.brand = brand;
		this.model = model;
		this.fuel = fuel;
		this.horsePowerTax = horsePowerTax;
		this.inGarage = inGarage;
		this.driver = driver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getHorsePowerTax() {
		return horsePowerTax;
	}

	public void setHorsePowerTax(int horsePowerTax) {
		this.horsePowerTax = horsePowerTax;
	}

	public int getInGarage() {
		return inGarage;
	}

	public void setInGarage(int inGarage) {
		this.inGarage = inGarage;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}
