package fr;

/**
 * Created by joe on 18/04/2016.
 */
public interface IAddressService {

    Address save (Address address);

    Address findOne(Integer integer);

    Iterable<Address> findAll();

    void delete(Integer integer);
}
