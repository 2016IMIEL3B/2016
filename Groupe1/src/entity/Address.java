package entity;

// Generated 22 mars 2016 11:08:52 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
public class Address implements java.io.Serializable {

	private Integer id;
	private int number;
	private String street;
	private String postode;
	private String city;
	private Set users = new HashSet(0);

	public Address() {
	}

	public Address(int number, String street, String postode, String city) {
		this.number = number;
		this.street = street;
		this.postode = postode;
		this.city = city;
	}

	public Address(int number, String street, String postode, String city,
			Set users) {
		this.number = number;
		this.street = street;
		this.postode = postode;
		this.city = city;
		this.users = users;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostode() {
		return this.postode;
	}

	public void setPostode(String postode) {
		this.postode = postode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}
