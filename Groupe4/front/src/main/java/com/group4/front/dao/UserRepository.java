package com.group4.front.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group4.front.common.CreatedResponse;
import com.group4.front.common.ApiUtils;
import com.group4.front.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRepository implements IUserRepository {
    @Autowired
    private ApiUtils apiUtils;

    @Override
    public Integer createUser(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonUser = mapper.writeValueAsString(user);

        String url = ApiUtils.API_URL + "users";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonUser, this.apiUtils.getHeaders());

        ResponseEntity<CreatedResponse> response =
                restTemplate.exchange(url, HttpMethod.POST, httpEntity, CreatedResponse.class);

        return response.getBody().getId();
    }

    @Override
    public User findUserById(Integer userId) {
        String url = ApiUtils.API_URL + "users/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(this.apiUtils.getHeaders());

        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, User.class);

        return response.getBody();
    }

    @Override
    public void updateUser(User user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonUser = mapper.writeValueAsString(user);

        String url = ApiUtils.API_URL + "users/" + user.getId();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonUser, this.apiUtils.getHeaders());

        restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
    }

    @Override
    public void deleteUser(User user) {
        String url = ApiUtils.API_URL + "users/" + user.getId();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(this.apiUtils.getHeaders());

        restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);
    }
}
