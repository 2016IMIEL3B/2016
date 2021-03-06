package fr;

// Generated 24 mars 2016 16:11:08 by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Quote generated by hbm2java
 */
@Entity
@Table(name = "quote", catalog = "assurance")
public class Quote implements java.io.Serializable {

	private Integer id;
	private Habitation habitation;
	private Vehicle vehicle;
	private String name;
	private int step;
	private boolean isCompleted;
	private float price;
	private String summary;
	private Set clients = new HashSet(0);

	public Quote() {
	}

	public Quote(String name, int step, boolean isCompleted, float price,
			String summary) {
		this.name = name;
		this.step = step;
		this.isCompleted = isCompleted;
		this.price = price;
		this.summary = summary;
	}

	public Quote(Habitation habitation, Vehicle vehicle, String name, int step,
			boolean isCompleted, float price, String summary, Set clients) {
		this.habitation = habitation;
		this.vehicle = vehicle;
		this.name = name;
		this.step = step;
		this.isCompleted = isCompleted;
		this.price = price;
		this.summary = summary;
		this.clients = clients;
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "habitationId")
	public Habitation getHabitation() {
		return this.habitation;
	}

	public void setHabitation(Habitation habitation) {
		this.habitation = habitation;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicleId")
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "step", nullable = false)
	public int getStep() {
		return this.step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@Column(name = "isCompleted", nullable = false)
	public boolean isIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "summary", nullable = false)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "quoteuser", catalog = "assurance", joinColumns = { @JoinColumn(name = "quoteId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) })
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}


}
