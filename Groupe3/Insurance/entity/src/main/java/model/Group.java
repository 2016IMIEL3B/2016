/**
 * 
 */
package model;

import java.util.List;
import javax.persistence.*;

/**
 * @author Enzo
 *
 */
@Entity
@Table(name="group")
public class Group {
	@Id
	@Column(name="idGroup")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="grouprole",
		joinColumns=@JoinColumn(name="idGroup"),
		inverseJoinColumns=@JoinColumn(name="idRole"))
	private List<Role> roles;

	public Group(String name, List<Role> roles) {
		this.name = name;
		this.roles = roles;
	}

	protected Group() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
