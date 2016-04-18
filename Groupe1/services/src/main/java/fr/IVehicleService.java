package fr;

/**
 * Created by joe on 18/04/2016.
 */
public interface IVehicleService {

    Vehicle save (Vehicle vehicle);

    Vehicle findOne(Integer integer);

    Iterable<Vehicle> findAll();

    void delete(Integer integer);
}
