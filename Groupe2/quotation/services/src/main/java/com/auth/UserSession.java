package com.auth;

import com.UserLike;
import com.back.User;
import io.vertx.core.json.JsonObject;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by tlemaillet on 24/03/16 for com.group.two.root.
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
public class UserSession {

    private String token;
    private User user = new User();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public void setFromUserDetails(UserLike userDetails){
        user.setPassword(userDetails.getPassword());
        user.setFirstName(userDetails.getFirstName());
        user.setLogin(userDetails.getLogin());
        user.setLastName(userDetails.getLastName());
        user.setId(userDetails.getId());
    }
}
