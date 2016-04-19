package com;

/**
 * Created by tlemaillet on 24/03/16 for com.group.two.root.
 */
public class UserLike {
    private int id;
    private String lastName;
    private String firstName;
    private String login;
    private String password;
    private int roleId;
    private int addressId;
    private int iat;

    public int getIat() {
        return iat;
    }

    public void setIat(int iat) {
        this.iat = iat;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

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
