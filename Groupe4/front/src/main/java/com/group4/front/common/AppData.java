package com.group4.front.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
public class AppData {
    /**
     * User token.
     */
    private String token;

    /**
     * User id.
     */
    private Integer idUser;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "token='" + token + '\'' +
                ", idUser=" + idUser +
                '}';
    }
}
