package com;

import com.front.Quotation;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 22/03/16.
 */
public interface QuotationRepository extends CrudRepository<Quotation, Integer>{

    Iterable<Quotation> findByUserId(int user_Id);
    Quotation findOneById(int quotationId);

}
