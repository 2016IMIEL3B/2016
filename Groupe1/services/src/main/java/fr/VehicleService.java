package fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by joe on 18/04/2016.
 */
@Service
public class VehicleService implements IVehicleService{

    @Autowired
    private VehicleRepository vehicleDao;


    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public Vehicle findOne(Integer integer) {
        return vehicleDao.findOne(integer);
    }

    @Override
    public Iterable<Vehicle> findAll() {
        return vehicleDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
