package com.group4.front.services;

import com.group4.front.common.AppData;
import com.group4.front.entities.User;
import com.group4.front.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

        System.out.println("Entering AuthenticationService.login");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");

        String url = "http://localhost:1204/login";
        ParameterizedTypeReference<User> returnedObject = new ParameterizedTypeReference<User>(){};

        try{
            ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, User.class);
            User user = response.getBody();

            System.out.println("Token: " + response.getHeaders().getFirst("token"));
            System.out.println("user: " + user.toString());
            this.session.setIdUser(user.getId());

            this.session.setToken(response.getHeaders().getFirst("token"));
            System.out.println("Exiting AuthenticationService.login");
            return user;
        }catch (Exception e){
            return null;
        }

    }
}
