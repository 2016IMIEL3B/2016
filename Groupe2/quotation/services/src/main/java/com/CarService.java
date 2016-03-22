package com;

import com.front.Car;
import com.front.Quotation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kevin on 22/03/16.
 */
public class CarService implements ICarService {

    @Autowired
    private CarRepository carDao;

}
