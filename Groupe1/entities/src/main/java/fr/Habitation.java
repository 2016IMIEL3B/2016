package fr;

// Generated 24 mars 2016 16:11:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Habitation generated by hbm2java
 */
@Entity
@Table(name = "habitation", catalog = "assurance")
public class Habitation implements java.io.Serializable {

	private Integer id;
	private Address address;
	private String type;
	private int surface;
	private int roomNumber;
	private Integer floor;
	private int bathroomNumber;
	private boolean garage;
	private Integer groundSurface;
	private int patioSurface;
	private String heatingType;
	private String option;
	private Set quotes = new HashSet(0);

	public Habitation() {
	}

	public Habitation(Address address, String type, int surface,
			int roomNumber, int bathroomNumber, boolean garage,
			int patioSurface, String heatingType, String option) {
		this.address = address;
		this.type = type;
		this.surface = surface;
		this.roomNumber = roomNumber;
		this.bathroomNumber = bathroomNumber;
		this.garage = garage;
		this.patioSurface = patioSurface;
		this.heatingType = heatingType;
		this.option = option;
	}

	public Habitation(Address address, String type, int surface,
			int roomNumber, Integer floor, int bathroomNumber, boolean garage,
			Integer groundSurface, int patioSurface, String heatingType,
			String option, Set quotes) {
		this.address = address;
		this.type = type;
		this.surface = surface;
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.bathroomNumber = bathroomNumber;
		this.garage = garage;
		this.groundSurface = groundSurface;
		this.patioSurface = patioSurface;
		this.heatingType = heatingType;
		this.option = option;
		this.quotes = quotes;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "type", nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "surface", nullable = false)
	public int getSurface() {
		return this.surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	@Column(name = "roomNumber", nullable = false)
	public int getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Column(name = "floor")
	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "bathroomNumber", nullable = false)
	public int getBathroomNumber() {
		return this.bathroomNumber;
	}

	public void setBathroomNumber(int bathroomNumber) {
		this.bathroomNumber = bathroomNumber;
	}

	@Column(name = "garage", nullable = false)
	public boolean isGarage() {
		return this.garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	@Column(name = "groundSurface")
	public Integer getGroundSurface() {
		return this.groundSurface;
	}

	public void setGroundSurface(Integer groundSurface) {
		this.groundSurface = groundSurface;
	}

	@Column(name = "patioSurface", nullable = false)
	public int getPatioSurface() {
		return this.patioSurface;
	}

	public void setPatioSurface(int patioSurface) {
		this.patioSurface = patioSurface;
	}

	@Column(name = "heatingType", nullable = false, length = 45)
	public String getHeatingType() {
		return this.heatingType;
	}

	public void setHeatingType(String heatingType) {
		this.heatingType = heatingType;
	}

	@Column(name = "option", nullable = false, length = 45)
	public String getOption() {
		return this.option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "habitation")
	public Set<Quote> getQuotes() {
		return this.quotes;
	}

	public void setQuotes(Set<Quote> quotes) {
		this.quotes = quotes;
	}

}
