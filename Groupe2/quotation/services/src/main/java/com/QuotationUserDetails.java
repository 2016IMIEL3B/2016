package com;

import io.vertx.core.json.JsonObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class QuotationUserDetails implements UserDetails {

    private String username = null;
    private String password = null;


    public QuotationUserDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public QuotationUserDetails(UserLike userDetails) {
        this.username = userDetails.getLogin();
        this.password = userDetails.getPassword();
    }

    @Override
    public Collection<? extends SimpleGrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
