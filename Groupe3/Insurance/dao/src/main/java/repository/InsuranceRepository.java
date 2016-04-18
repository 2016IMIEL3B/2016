package repository;

import model.Insurance;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface InsuranceRepository extends CrudRepository<Insurance,Integer> {
}
