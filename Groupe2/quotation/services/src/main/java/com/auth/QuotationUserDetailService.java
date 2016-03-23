package com.auth;

import com.QuotationUserDetails;
import io.vertx.core.json.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
@Component
public class QuotationUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        QuotationUserDetails userDetails = new QuotationUserDetails();
//        RestTemplate rt = new RestTemplate();
//        JsonObject u = new JsonObject();
//        Map<String, ?> vars= null;
//        rt.postForObject("localhost:8090/auth/api/login", u, JsonObject.class, vars);
        //===========================================================================================================
        String urlPost = "http://localhost:8091/auth/api/login";
        String token = "Mouahahah";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<JsonObject> request = new HttpEntity<>(new JsonObject().put("login", username), headers);

        JsonObject pouet = restTemplate.postForObject(urlPost, request, JsonObject.class);

        System.out.println("\\u001B[31mPouet!-----------------------------------------\\u001B[0m");

        return null;
    }
}
