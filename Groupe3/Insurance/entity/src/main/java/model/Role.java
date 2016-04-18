/**
 * 
 */
package model;

/**
 * @author Enzo
 *
 */
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
	@Id
	@Column(name="idRole")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="grouprole",
		joinColumns=@JoinColumn(name="idRole"),
		inverseJoinColumns=@JoinColumn(name="idGroup"))
	private List<Group> groups;
	
	public Role(String name) {
		super();
		this.name = name;
	}

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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
	public String getAuthority() {
		return name;
	}
}
