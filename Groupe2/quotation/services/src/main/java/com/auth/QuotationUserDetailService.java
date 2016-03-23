package com.auth;

import com.QuotationUserDetails;
import io.vertx.core.json.JsonObject;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
public class QuotationUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QuotationUserDetails userDetails = new QuotationUserDetails();
        RestTemplate rt = new RestTemplate();
        JsonObject u = new JsonObject();
        Map<String, ?> vars= null;
        rt.postForObject("localhost:8090/auth/api/login", u, JsonObject.class, vars);

        return null;
    }
}
