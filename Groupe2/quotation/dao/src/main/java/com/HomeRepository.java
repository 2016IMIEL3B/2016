package com;

import com.front.Driver;
import com.front.Home;
import com.front.Quotation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 22/03/16.
 */
public interface HomeRepository extends CrudRepository<Home, Integer>{
    Home findOneByQuotationId(int id);
}
