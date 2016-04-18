package repository;

import model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface AddressRepository extends CrudRepository<Address,Integer> {

}
