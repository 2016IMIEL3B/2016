package com;

import com.front.Car;
import com.front.Quotation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 22/03/16.
 */
public interface CarRepository extends CrudRepository<Quotation,Integer>{
    Car findOneById(int quotationId);
}
