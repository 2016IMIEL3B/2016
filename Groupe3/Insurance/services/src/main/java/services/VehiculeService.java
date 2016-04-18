package services;

import org.springframework.beans.factory.annotation.Autowired;
import repository.VehiculeRepository;

/**
 * Created by Enzo on 18/04/2016.
 */
public class VehiculeService implements IVehiculeService {
        @Autowired
        private VehiculeRepository vehiculeRepository;
}
