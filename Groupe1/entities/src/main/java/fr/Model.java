package fr;

// Generated 22 mars 2016 11:08:52 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Model generated by hbm2java
 */
public class Model implements java.io.Serializable {

	private Integer id;
	private Brand brand;
	private String name;
	private Set vehicles = new HashSet(0);

	public Model() {
	}

	public Model(Brand brand, String name) {
		this.brand = brand;
		this.name = name;
	}

	public Model(Brand brand, String name, Set vehicles) {
		this.brand = brand;
		this.name = name;
		this.vehicles = vehicles;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Set vehicles) {
		this.vehicles = vehicles;
	}

}