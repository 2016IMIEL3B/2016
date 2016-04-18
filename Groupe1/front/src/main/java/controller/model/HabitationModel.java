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

    public HabitationModel(Quote myQuote){
        quote = myQuote;
    }
}
