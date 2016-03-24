package com;

import com.front.Car;
import com.front.Driver;
import com.front.Quotation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevin on 22/03/16.
 */
public interface DriverRepository extends CrudRepository<Driver,Integer>{
    Iterable<Driver> findByCarId(int carId);
}
