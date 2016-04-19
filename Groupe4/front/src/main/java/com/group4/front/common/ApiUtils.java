package com.group4.front.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ApiUtils {
    public static final String BASE_URL = "http://localhost:1204/";
    public static final String API_URL = BASE_URL + "api/";

    @Autowired
    private AppData session;

    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer " + this.session.getToken());

        return headers;
    }
}
