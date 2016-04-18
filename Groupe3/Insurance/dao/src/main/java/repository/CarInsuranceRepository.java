package repository;

import model.CarInsurance;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface CarInsuranceRepository extends CrudRepository<CarInsurance,Integer> {
}
