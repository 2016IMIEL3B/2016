package controller.model;

import fr.Address;
import fr.Habitation;
import fr.Quote;

/**
 * Created by Manon on 23/03/2016.
 */
public class HabitationModel {

    private Quote quote;

    public HabitationModel(){
        quote = new Quote();
        quote.setHabitation(new Habitation());
        quote.getHabitation().setAddress(new Address());
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public boolean checkStep1() {
        boolean $status = false;
        String name = this.quote.getName();
        String type = this.quote.getHabitation().getType();
        Integer surface = this.quote.getHabitation().getSurface();

        if(!name.isEmpty() && !type.isEmpty() && surface > 9){
            $status = true;
        }

        return $status;
    }

    public boolean checkStep2() {
        boolean $status = false;
        Integer roomNumber = this.quote.getHabitation().getRoomNumber();
        Integer bathroomNumber = this.quote.getHabitation().getBathroomNumber();

        if(bathroomNumber > 0 && bathroomNumber <= roomNumber){
            $status = true;
        }
        return $status;
    }

    public boolean checkStep3() {
        boolean $status = false;
        Integer number = this.quote.getHabitation().getAddress().getNumber();
        String street = this.quote.getHabitation().getAddress().getStreet();
        String postcode = this.quote.getHabitation().getAddress().getPostcode();
        String city = this.quote.getHabitation().getAddress().getCity();

        if(number >0 && !street.isEmpty() && !postcode.isEmpty() && !city.isEmpty()){
            $status = true;
        }
        return $status;
    }
}
