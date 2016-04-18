package repository;

import model.Insurance;
import model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface InsuranceRepository extends CrudRepository<Insurance,Integer> {
    List<Insurance> findByStatementAndUser(String statement, User user);
}
