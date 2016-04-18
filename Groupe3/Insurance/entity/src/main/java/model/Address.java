/**
 * 
 */
package model;

import javax.persistence.*;

/**
 * @author Enzo
 *
 */
@Entity
@Table(name="adress")
public class Address {
	@Id
	@Column(name="idAdress")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="street")
	String street;
	@Column(name="city")
	String city;
	@Column(name="code")
	String postalCode;
	@Column(name="country")
	String country;
	
	public Address(String street, String city, String postalCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}

	protected Address() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
}
