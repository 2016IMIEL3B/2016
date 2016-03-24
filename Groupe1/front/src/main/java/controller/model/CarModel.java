package controller.model;

import fr.Quote;
import fr.Vehicle;
import fr.Model;
import fr.Brand;


/**
 * Created by EVER on 24/03/2016.
 */


public class CarModel {

    private Quote quote;

    public CarModel(){
        quote = new Quote();
        quote.setVehicle(new Vehicle());
        quote.getVehicle().setModel(new Model());
        quote.getVehicle().getModel().setBrand(new Brand());
    }

    public Quote getQuote(){return quote;}

    public void setQuote(Quote quote){this.quote = quote;}
}
