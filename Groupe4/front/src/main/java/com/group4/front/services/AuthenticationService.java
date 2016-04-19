package com.group4.front.services;

import com.group4.front.common.ApiUtils;
import com.group4.front.common.AppData;
import com.group4.front.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity =
                new HttpEntity<String>("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
        String url = ApiUtils.BASE_URL + "login";

        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, User.class);

        User user = response.getBody();
        this.session.setIdUser(user.getId());
        this.session.setToken(response.getHeaders().getFirst("token"));

        return user;
    }
}
