package controller.model;

import fr.*;


/**
 * Created by EVER on 24/03/2016.
 */


public class CarModel {

    private Client client;
    private Quote quote;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CarModel(){
        client = new Client();
        address = new Address();
        quote = new Quote();
        quote.setVehicle(new Vehicle());
        quote.getVehicle().setModel(new Model());
        quote.getVehicle().getModel().setBrand(new Brand());
    }

    public CarModel(Quote myQuote) {
        quote = myQuote;
    }

    public Quote getQuote(){return quote;}

    public void setQuote(Quote quote){this.quote = quote;}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
