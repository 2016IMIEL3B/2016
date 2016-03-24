package controller.model;

import fr.Quote;
import fr.Vehicle;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
/**
 * Created by EVER on 24/03/2016.
 */


public class CarModel {

    private Quote quote;

    public CarModel(){
        quote = new Quote();
        quote.setVehicle(new Vehicle());
    }

    public Quote getQuote(){return quote;}

    public void setQuote(Quote quote){this.quote = quote;}
}
