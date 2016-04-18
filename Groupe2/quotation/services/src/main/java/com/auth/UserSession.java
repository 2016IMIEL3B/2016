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

    public JsonObject getHeaderToken(){
        return new JsonObject().put("Authorization", "Bearer " + this.token);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setFromUserDetails(UserLike userDetails){
        user.setPassword(userDetails.getPassword());
        user.setFirstName(userDetails.getFirstName());
        user.setLogin(userDetails.getLogin());
        user.setLastName(userDetails.getLastName());
        user.setId(userDetails.getId());
    }

    public void refreshUserSession(User user){
        if(user != null){
            this.user.setId(user.getId());
            this.user.setFirstName(user.getFirstName());
            this.user.setLastName(user.getLastName());
            this.user.setLogin(user.getLogin());
            this.user.setPassword(user.getPassword());
        }
    }
}
