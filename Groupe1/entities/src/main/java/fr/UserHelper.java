package fr;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by joe on 25/03/2016.
 */
public class UserHelper implements UserDetails {

    private String password;
    private String login;
    private Collection<Role> roles;

    public UserHelper() {
    }

    public UserHelper(String password, String login) {
        this.password = password;
        this.login = login;

    }

    @Override
    /*@Transient
    @ElementCollection*/
    /*@OneToMany(targetEntity=User.class,
            mappedBy="user")*/
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
