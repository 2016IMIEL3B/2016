package fr;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by joe on 18/04/2016.
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {

    Address save (Address address);

    Address findOne(Integer integer);

    Iterable<Address> findAll();

    void delete(Integer integer);

}
