package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 18/04/2016.
 */
public interface VehicleRepository extends CrudRepository<Vehicle,Integer>{

    Vehicle save(Vehicle vehicle);
    Vehicle findOne(Integer integer);

    Iterable<Vehicle> findAll();

    void delete(Integer integer);
}
