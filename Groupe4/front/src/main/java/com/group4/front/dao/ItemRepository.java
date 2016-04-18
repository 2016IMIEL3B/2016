package com.group4.front.dao;

import com.group4.front.common.AppData;
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
    private AppData session;

    @Override
    public List<Item> findItemsByType(String type) {
        return null;
    }

    @Override
    public List<Item> findItemsByParentId(Integer parentId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>("");

        String url = "http://localhost:1203/api/list";
        httpEntity.getHeaders().add("Authorization", "Bearer " + session.getToken());
        ParameterizedTypeReference<List<Item>> returnedObject = new ParameterizedTypeReference<List<Item>>(){};

        ResponseEntity<List<Item>> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, returnedObject);

        System.out.println(response.toString());

        return null;
    }
}
