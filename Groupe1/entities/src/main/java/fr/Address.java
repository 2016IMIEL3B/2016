package fr;

// Generated 24 mars 2016 16:11:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "address", catalog = "assurance")
public class Address implements java.io.Serializable {

	private Integer id;
	private int number;
	private String street;
	private int postcode;
	private String city;
	private Set habitations = new HashSet(0);
	private Set vehicles = new HashSet(0);
	private Set users = new HashSet(0);

	public Address() {
	}


	public Address(int number, String street, int postcode, String city) {

		this.number = number;
		this.street = street;
		this.postcode = postcode;
		this.city = city;
	}



	public Address(int number, String street, int postcode, String city,
			Set habitations, Set vehicles, Set users) {

		this.number = number;
		this.street = street;
		this.postcode = postcode;
		this.city = city;
		this.habitations = habitations;
		this.vehicles = vehicles;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "number", nullable = false)
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name = "street", nullable = false, length = 45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	@Column(name = "postcode", nullable = false)
	public int getPostcode() {
		return this.postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	@Column(name = "city", nullable = false, length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Habitation> getHabitations() {
		return this.habitations;
	}

	public void setHabitations(Set<Habitation> habitations) {
		this.habitations = habitations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
