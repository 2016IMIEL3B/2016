package com.groupe4.entity;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * User entity.
 */
public class User {
    /**
     * User id.
     */
    private Integer id;

    /**
     * User name.
     */
    private String name;
    /**
     * User surname.
     */
    private String surname;
    /**
     * User login.
     */
    private String login;
    /**
     * User password.
     */
    private String password;
    /**
     * User active status.
     */
    private Boolean active;
    /**
     * User creation date.
     */
    private Date createdAt;
    /**
     * User update date.
     */
    private DateTime updatedAt;

    /**
     * User roles;
     */
    private List<String> roles;

    public User() {
    }

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

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        this.roles.add(role);
    }

    public void removeRole(String role) {
        this.roles.remove(role);
    }
}