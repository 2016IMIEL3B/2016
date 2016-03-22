package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class CarController {

    @RequestMapping({"/Devis/Voiture"})
    public ModelAndView quotationCar(){
        ModelAndView model = new ModelAndView("QuotationCar/index.jsp");


        return model;
    }
}
