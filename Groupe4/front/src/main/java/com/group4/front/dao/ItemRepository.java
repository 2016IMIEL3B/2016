package com.group4.front.dao;

import com.group4.front.common.ApiUtils;
import com.group4.front.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ItemRepository implements IItemRepository {
    @Autowired
    private ApiUtils apiUtils;

    @Override
    public List<Item> findItemsByType(String type) {
        String url = ApiUtils.API_URL + "lists?type=" + type;

        return this.findItems(url);
    }

    @Override
    public List<Item> findItemsByParentId(Integer parentId) {
        String url = ApiUtils.API_URL + "lists/" + parentId;

        return this.findItems(url);
    }

    private List<Item> findItems(String url) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(this.apiUtils.getHeaders());
        ParameterizedTypeReference<List<Item>> returnedObject = new ParameterizedTypeReference<List<Item>>(){};

        ResponseEntity<List<Item>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, returnedObject);

        return response.getBody();
    }
}
