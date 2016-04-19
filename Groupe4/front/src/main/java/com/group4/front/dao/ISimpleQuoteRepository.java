package com.group4.front.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group4.front.entities.SimpleQuote;

import java.util.List;

public interface ISimpleQuoteRepository {
    List<SimpleQuote> findSimpleQuotesByUser(Integer userId);
    void createSimpleQuote(SimpleQuote quote) throws JsonProcessingException;
}
