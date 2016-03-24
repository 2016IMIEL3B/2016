package com;

import com.front.Driver;

/**
 * Created by kevin on 22/03/16.
 */
public interface IDriverService {
    Iterable<Driver> findByCarId(int carId);
    Driver save(Driver driver);
}