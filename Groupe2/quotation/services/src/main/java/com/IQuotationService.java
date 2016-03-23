package com;

import com.front.Quotation;

/**
 * Created by kevin on 22/03/16.
 */
public interface IQuotationService {

    Iterable<Quotation> findAll();

    Iterable<Quotation> findByUserId(int user_Id);

    void delete(int id);

    Quotation findOneById(int id);

}
