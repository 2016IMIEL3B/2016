package com.auth;

import com.QuotationUserDetails;
import com.utils.RestHelper;
import io.vertx.core.json.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by tlemaillet on 23/03/16 for com.group.two.root.
 */
@Component
public class QuotationUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QuotationUserDetails userDetails = new QuotationUserDetails();
        HttpEntity<JsonObject> pouet = new RestHelper().loginRequest(username);
        pouet.getHeaders();


        System.out.println(pouet);

        return null;
    }
}
