package com.group4.front.common;

import org.springframework.format.datetime.standard.DateTimeContextHolder;

import java.util.Date;

/**
 * User class.
 */
public class User {
    /**
     * User id.
     */
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
