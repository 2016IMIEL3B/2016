package repository;

import model.Vehicule;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface VehiculeRepository extends CrudRepository<Vehicule,Integer> {
}
