package controller;

import com.ICarService;
import com.IQuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class CarController {

    @Autowired
    ICarService carService;

    @RequestMapping({"/devis/voiture"})
    public ModelAndView quotationCar(){
        ModelAndView model = new ModelAndView("QuotationCar/index.jsp");


        return model;
    }
}
