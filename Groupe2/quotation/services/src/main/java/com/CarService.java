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
    public Car findById(int carId) {
        return this.carRepository.findOneById(carId);
    }

}
