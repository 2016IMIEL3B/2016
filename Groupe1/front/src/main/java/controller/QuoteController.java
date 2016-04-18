package controller;

import fr.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtostain on 24/03/2016.
 */
@Controller
public class QuoteController {

    @RequestMapping(value = "/synthesis", method = RequestMethod.GET)
    public ModelAndView synthesis(){
        ModelAndView model = new ModelAndView("synthesis");

        List<Quote> quotes = new ArrayList<Quote>();

        Brand brand = new Brand();
        brand.setName("Renault");

        Model myModel = new Model();
        myModel.setName("Clio IV");
        myModel.setBrand(brand);

        Vehicle vehicle = new Vehicle();
        vehicle.setModel(myModel);

        Quote quote1 = new Quote();

        quote1.setName("monDevis");
        quote1.setStep(2);
        quote1.setIsCompleted(false);
        quote1.setVehicle(vehicle);
        quote1.setPrice(800);
        quote1.setSummary("Devis Clio IV 2014");
        quotes.add(quote1);

        Habitation habitation = new Habitation();
        habitation.setType("Maison");
        habitation.setSurface(100);

        Quote quote2 = new Quote();

        quote2.setName("devisHabitation");
        quote2.setStep(3);
        quote2.setIsCompleted(false);
        quote2.setHabitation(habitation);
        quote2.setPrice(1000);
        quote2.setSummary("Devis maison centre rennes");
        quotes.add(quote2);


        model.addObject("quotes", quotes);
        return model;
    }
}
