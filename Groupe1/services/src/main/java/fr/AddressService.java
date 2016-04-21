package fr;

import org.springframework.stereotype.Service;

/**
 * Created by joe on 18/04/2016.
 */
@Service
public class AddressService implements IAddressService {

    AddressRepository addressDao;
    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address findOne(Integer integer) {
        return addressDao.findOne(integer);
    }

    @Override
    public Iterable<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
