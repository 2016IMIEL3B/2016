package com.group4.front.services;

import com.group4.front.common.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "singleton")
public class UserService {
    //Mock
    public User findUserByLogin(String login) {
        User user = new User();
        user.setId(1);
        user.setLogin(login);
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

        return user;
    }

    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("Paul");
        user.setSurname("Jean");

        return user;
    }
}
