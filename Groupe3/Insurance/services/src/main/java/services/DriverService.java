package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.DriverRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class DriverService implements IDriverService {
    @Autowired
    private DriverRepository driverRepository;
}
