package services;

import model.Vehicule;

/**
 * Created by Enzo on 18/04/2016.
 */
public interface IVehiculeService {
    Vehicule saveAndgetVehicule(Vehicule vehicule);
    void saveVehicule(Vehicule vehicule);
}
