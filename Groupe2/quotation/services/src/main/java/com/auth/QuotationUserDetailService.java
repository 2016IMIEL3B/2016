package com.auth;

import com.QuotationUserDetails;
import com.utils.RestHelper;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
@Component

public class QuotationUserDetailService implements UserDetailsService {
    @Autowired
    private UserSession userSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QuotationUserDetails userDetails;

        ResponseEntity<JsonObject> response = new RestHelper().loginRequest(username);

        if (response.getStatusCode().value() != 200) {
            userSession.setToken(response.getHeaders().get("Token").get(0));

            List<String> s = response.getHeaders().get("UserDetails");
            JsonObject rawUserDetails = Json.decodeValue(s.get(0), JsonObject.class);
            userSession.setFromUserDetails(rawUserDetails);

            userDetails = new QuotationUserDetails(rawUserDetails);
        } else {
            userDetails = new QuotationUserDetails(username, "0");
        }

        return userDetails;
    }


}
