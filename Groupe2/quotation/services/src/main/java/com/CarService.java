package com;

import com.front.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 22/03/16.
 */
@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car findOneByQuotationId(int id) {
        return this.carRepository.findOneByQuotationId(id);
    }

    @Override
    public Car save(Car car){
        return this.carRepository.save(car);
    }
}
