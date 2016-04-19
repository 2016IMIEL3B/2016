package services;

import model.CarInsurance;
import model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DriverRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
@Service
public class DriverService implements IDriverService {
    @Autowired
    private DriverRepository driverRepository;

    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }
}
