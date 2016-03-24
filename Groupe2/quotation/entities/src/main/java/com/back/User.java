package com.back;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kevin on 24/03/16.
 */
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String lastName;
    private String firstName;
    private String login;
    private String password;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
}
