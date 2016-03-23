package com.group4.front.services;

import com.group4.front.common.AppData;
import com.group4.front.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "singleton")
public class AuthenticationService {
    @Autowired
    AppData session;

    /**
     * Store JWT and idUser in session and return an authenticated user.
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //Mock
        User user = new User();
        user.setId(1);
        user.setLogin(username);
        user.setActive(true);
        user.setName("Test");
        user.setSurname("Michel");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date createdAt = null;
        try {
            createdAt = dateFormat.parse("2016-03-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setCreatedAt(createdAt);

        //BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        //user.setPassword(bCryptEncoder.encode("password"));
        user.setPassword("password");

        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        user.setRoles(grantedAuths);

        this.session.setIdUser(user.getId());
        this.session.setToken("FalseToken");

        return user;
    }
}
