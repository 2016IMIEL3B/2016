package fr;

/**
 * Created by joe on 24/03/2016.
 */
public interface IQuoteService {

    Quote save (Quote quote);

     Quote findOne(Integer integer);

     Iterable<Quote> findAll();

     void delete(Integer integer);


}
