package repository;

import model.HouseInsurance;
import model.Insurance;
import model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface HouseInsuranceRepository extends CrudRepository<HouseInsurance,Integer> {
    HouseInsurance findByInsurance(Insurance insurance);
}
