package com.group4.front.dao;

import com.group4.front.entities.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {
}
