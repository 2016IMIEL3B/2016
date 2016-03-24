package com.auth;

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
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public void setFromUserDetails(JsonObject userDetails){

    }
}
