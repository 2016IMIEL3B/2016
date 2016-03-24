package controller.model;

import fr.Vehicle;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
/**
 * Created by EVER on 24/03/2016.
 */


public class CarModel {

    private Vehicle vehicle;

    public CarModel(){
        vehicle = new Vehicle();
        vehicle.setCar(new Car());
    }

    public Vehicle getVehicle(){return vehicle;}

    public void setVehicle(Vehicle vehicle){this.vehicle = vehicle;}
}
