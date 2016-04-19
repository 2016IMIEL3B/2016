package com.group4.front.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

/**
 * User class.
 */
public class User {
    /**
     * User id.
     */
    private Integer id;

    /**
     * User lastname.
     */
    private String name;

    /**
     * User firstname.
     */
    private String surname;

    /**
     * User email.
     */
    private String login;

    /**
     * User password.
     */
    private String password;

    /**
     * User roles.
     */
    private List<SimpleGrantedAuthority> roles;

    /**
     * Is a active user.
     */
    private Boolean active;

    /**
     * Creation date.
     */
    private Date createdAt;

    /**
     * Last update datetime.
     */
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<SimpleGrantedAuthority> getRoles() { return roles; }

    public void setRoles(List<SimpleGrantedAuthority> roles) { this.roles = roles; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
