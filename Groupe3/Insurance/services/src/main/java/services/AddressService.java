package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.AddressRepository;
import repository.UserRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
}
