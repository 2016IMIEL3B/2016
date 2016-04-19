package com.group4.front.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group4.front.dao.ISimpleQuoteRepository;
import com.group4.front.entities.SimpleQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleQuoteService {
    @Autowired
    private ISimpleQuoteRepository simpleQuoteRepository;

    public List<SimpleQuote> findSimpleQuotesByUser(Integer userId) {
        return this.simpleQuoteRepository.findSimpleQuotesByUser(userId);
    }

    public void createSimpleQuote(SimpleQuote quote) throws JsonProcessingException {
        this.simpleQuoteRepository.createSimpleQuote(quote);
    }
}
