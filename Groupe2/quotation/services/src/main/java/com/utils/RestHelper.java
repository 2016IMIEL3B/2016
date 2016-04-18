package com.utils;

import com.UserLike;
import com.auth.UserSession;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.List;


/**
 * Created by tlemaillet on 24/03/16 for com.group.two.root.
 */
public class RestHelper {

    /*@Autowired
    UserSession usersession;*/

    MultiValueMap<String, String> headers;
    RestTemplate restTemplate;
    HttpEntity<JsonObject> request;

    public RestHelper() {
        selfInit();
        validate();
    }

    public RestHelper(JsonObject headParams) {
        selfInit();
        headParams.forEach(headParam -> headers.add(headParam.getKey(), headParam.getValue().toString()));
        validate();
    }

    private void selfInit(){
        headers = new LinkedMultiValueMap<>();
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        headers.add("Content-Type", "application/json");
        headers.add("Cache-Control", "no-store, no-cache");
        /*String token = usersession.getToken();
        if (!token.equals("")) {
            headers.add("Authorization", "Bearer " + token );
        }*/

    }
    private void validate() {
        JsonObject body = new JsonObject().put("Hey", "Bonjour");
        request = new HttpEntity<>(body, headers);
    }

    public <T> ResponseEntity<T> doRequest(String url, String params, HttpMethod method, Class<T> clazz) {
        return restTemplate.exchange(
                url + "?" + params,
                method,
                request,
                clazz
        );
    }

    public <T> ResponseEntity<T> defaultRequest(String path, String params, HttpMethod method, Class<T> clazz) {
        return doRequest(getDefaultServer() + path, params, method, clazz);
    }

    public ResponseEntity<UserLike> loginRequest(String username) {
        return defaultRequest("/auth/api/login", "login=" + username, HttpMethod.POST, UserLike.class);
    }

    public ResponseEntity<List> apiRequest(String path) {
        return defaultRequest(path, "", HttpMethod.GET, List.class);
    }

    private String getDefaultServer(){
       return "http://localhost:8091";
    }
}
