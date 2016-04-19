package repository;

import model.CarInsurance;
import model.Insurance;
import model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface CarInsuranceRepository extends CrudRepository<CarInsurance,Integer> {
    CarInsurance findByInsurance(Insurance insurance);
}
