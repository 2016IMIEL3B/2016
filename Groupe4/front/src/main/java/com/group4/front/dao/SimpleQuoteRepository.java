package com.group4.front.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group4.front.common.ApiUtils;
import com.group4.front.entities.SimpleQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SimpleQuoteRepository implements ISimpleQuoteRepository {
    @Autowired
    private ApiUtils apiUtils;

    @Override
    public List<SimpleQuote> findSimpleQuotesByUser(Integer userId) {
        String url = ApiUtils.API_URL + "users/" + userId + "/quotes";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(this.apiUtils.getHeaders());
        ParameterizedTypeReference<List<SimpleQuote>> returnedObject =
                new ParameterizedTypeReference<List<SimpleQuote>>(){};

        ResponseEntity<List<SimpleQuote>> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, returnedObject);

        return response.getBody();
    }

    @Override
    public void createSimpleQuote(SimpleQuote quote) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonQuote = mapper.writeValueAsString(quote);

        String url = ApiUtils.API_URL + "users/" + quote.getUserId() + "/quotes";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonQuote, this.apiUtils.getHeaders());

        restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    }
}
