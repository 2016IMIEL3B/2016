/**
 * 
 */
package model;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.print.DocFlavor;
import java.util.Collection;
import java.util.List;


/**
 * @author Enzo
 *
 */
@Entity
@Table(name="user")
public class User implements UserDetails {
	@Id
	@Column(name="idUser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idGroup")
	private Group group;

	public User(String firstName, String lastName, String username, String password, Group group) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.group = group;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return group.getRoles();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
