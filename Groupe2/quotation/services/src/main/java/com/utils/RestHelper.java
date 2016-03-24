package com.utils;

import com.back.User;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tlemaillet on 24/03/16 for com.group.two.root.
 */
public class RestHelper {

    MultiValueMap<String, String> headers;
    RestTemplate restTemplate;
    HttpEntity<JsonObject> request;

    public RestHelper() {
        selfInit();
        validate();
    }

    public RestHelper(JsonObject headParams) {
        selfInit();
        headers.add("Cache-Control", "no-store, no-cache");
        validate();
    }

    private void selfInit(){
        headers = new LinkedMultiValueMap<>();
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        headers.add("Content-Type", "application/json");
    }
    private void validate() {
        JsonObject body = new JsonObject().put("Hey", "Bonjour");
        request = new HttpEntity<>(body, headers);
    }

    public <T> HttpEntity<T> postRequest(Class<T> clazz,String url, String params) {
        return restTemplate.exchange(
                url + "?" + params,
                HttpMethod.POST,
                request,
                clazz
        );
    }

    public HttpEntity<JsonObject> loginRequest(String username) {
        String loginUrl = "http://localhost:8091/auth/api/login";
        return postRequest(JsonObject.class, loginUrl, "login=" + username);
    }

    public HttpEntity<String> userRequest(User user){
        String userJson = Json.encode(user);
        String userUrl = "http://localhost:8091/api/profil/save";
        return restTemplate.postForObject(userUrl, user, String.class);
    }
}
