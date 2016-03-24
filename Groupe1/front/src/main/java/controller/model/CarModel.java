package controller.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
/**
 * Created by EVER on 24/03/2016.
 */

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
public class CarModel {

    private CarStep1 carStep1;
    public CarStep1 getCarStep1(){return carStep1 ;}
    public void setCarStep1(CarStep1 carStep1) {this.carStep1= carStep1;}
}
