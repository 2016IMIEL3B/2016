package com;

import com.front.Quotation;
import com.front.TypeQuotation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 22/03/16.
 */
public interface TypeQuotationRepository extends CrudRepository<TypeQuotation, Integer>{

    TypeQuotation findOneByEntitled(String entitled);

}
