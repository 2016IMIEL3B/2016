package fr;

// Generated 22 mars 2016 11:08:52 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Account generated by hbm2java
 */
public class Account implements java.io.Serializable {

	private Integer id;
	private boolean isAdmin;
	private String login;
	private String password;
	private Set users = new HashSet(0);

	public Account() {
	}

	public Account(boolean isAdmin, String login, String password) {
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
	}

	public Account(boolean isAdmin, String login, String password, Set users) {
		this.isAdmin = isAdmin;
		this.login = login;
		this.password = password;
		this.users = users;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}
