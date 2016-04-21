package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 24/03/2016.
 */
public interface QuoteRepository extends CrudRepository<Quote,Integer> {

    Quote save (Quote quote);
    Quote findOne(Integer integer);
    Iterable<Quote> findAll();
    void delete(Integer integer);

}
