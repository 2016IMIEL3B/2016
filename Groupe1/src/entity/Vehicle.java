package entity;

// Generated 22 mars 2016 11:08:52 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Vehicle generated by hbm2java
 */
public class Vehicle implements java.io.Serializable {

	private Integer id;
	private Model model;
	private String fuel;
	private String horsepower;
	private boolean sleepInside;
	private boolean anyRisk;
	private Set quotes = new HashSet(0);

	public Vehicle() {
	}

	public Vehicle(Model model, String fuel, String horsepower,
			boolean sleepInside, boolean anyRisk) {
		this.model = model;
		this.fuel = fuel;
		this.horsepower = horsepower;
		this.sleepInside = sleepInside;
		this.anyRisk = anyRisk;
	}

	public Vehicle(Model model, String fuel, String horsepower,
			boolean sleepInside, boolean anyRisk, Set quotes) {
		this.model = model;
		this.fuel = fuel;
		this.horsepower = horsepower;
		this.sleepInside = sleepInside;
		this.anyRisk = anyRisk;
		this.quotes = quotes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getFuel() {
		return this.fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getHorsepower() {
		return this.horsepower;
	}

	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}

	public boolean isSleepInside() {
		return this.sleepInside;
	}

	public void setSleepInside(boolean sleepInside) {
		this.sleepInside = sleepInside;
	}

	public boolean isAnyRisk() {
		return this.anyRisk;
	}

	public void setAnyRisk(boolean anyRisk) {
		this.anyRisk = anyRisk;
	}

	public Set getQuotes() {
		return this.quotes;
	}

	public void setQuotes(Set quotes) {
		this.quotes = quotes;
	}

}
