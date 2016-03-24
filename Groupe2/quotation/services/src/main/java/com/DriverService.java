package com;

import com.front.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kevin on 22/03/16.
 */
@Service
public class DriverService implements IDriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Iterable<Driver> findByCarId(int carId) {
        return this.driverRepository.findByCarId(carId);
    }

    @Override
    public Driver save(Driver driver){
        return this.driverRepository.save(driver);
    }

}
