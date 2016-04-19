package com.auth;

import com.QuotationUserDetails;
import com.UserLike;
import com.back.User;
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
 *  Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
@Component

public class QuotationUserDetailService implements UserDetailsService {
    @Autowired
    private UserSession userSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QuotationUserDetails userDetails;

        ResponseEntity<UserLike> response = new RestHelper().loginRequest(username);

        if (response.getStatusCode().value() == 200) {


            UserLike pouet = response.getBody();
            /*pouet = Json.decodeValue(response.getHeaders().get("UserDetails").get(0), UserLike.class);
            pouet = Json.decodeValue(response.getBody().encode(), UserLike.class);
            pouet = Json.mapper.convertValue(response.getBody(), UserLike.class);*/

            userSession.setFromUserDetails(pouet);
            userSession.setToken(response.getHeaders().get("Token").get(0));
            userDetails = new QuotationUserDetails(pouet);
        } else {
            throw new UsernameNotFoundException("Bad Login");
        }

        return userDetails;
    }


}
