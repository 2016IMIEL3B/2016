package services;

import model.Insurance;
import model.User;
import model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VehiculeRepository;

import java.util.List;

/**
 * Created by Enzo on 18/04/2016.
 */
@Service
public class VehiculeService implements IVehiculeService {
        @Autowired
        private VehiculeRepository vehiculeRepository;

        public Vehicule saveAndgetVehicule(Vehicule vehicule) {
                vehiculeRepository.save(vehicule);
                vehicule.setId(vehicule.getId());
                return vehicule;
        }

        public void saveVehicule(Vehicule vehicule) {
                vehiculeRepository.save(vehicule);
        }
}
