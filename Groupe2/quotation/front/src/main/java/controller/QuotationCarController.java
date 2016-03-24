package controller;

import com.ICarService;
import com.IDriverService;
import com.IQuotationService;
import com.front.Car;
import com.front.Driver;
import com.front.Quotation;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vertex.VerticleListener;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class QuotationCarController {

    @Autowired
    ICarService carService;

    @Autowired
    IQuotationService quotationService;

    @Autowired
    IDriverService driverService;


    @RequestMapping(value = "/devis/{id}/voiture", method = RequestMethod.GET)
    public ModelAndView quotationCar(@PathVariable int id) {
        ModelAndView model;

        Quotation quotation = quotationService.findOneById(id);

        if (quotation == null) {
            model = new ModelAndView("QuotationCar/stepOne");
            model.addObject("step", 1);
        } else {
            Car car = carService.findOneByQuotationId(id);
            Iterable<Driver> drivers = driverService.findByCarId(car.getId());

            switch(quotation.getNbStep()){
                case 1:
                    model = new ModelAndView("QuotationCar/stepOne");
                    model.addObject("step", 1);
                    break;
                case 2:
                    model = new ModelAndView("QuotationCar/stepTwo");
                    model.addObject("step", 2);
                    break;
                case 3:
                    model = new ModelAndView("QuotationCar/stepThree");
                    model.addObject("step", 3);
                    break;
                case 4:
                    model = new ModelAndView("QuotationCar/stepFour");
                    model.addObject("step", 4);
                    break;
                default:
                    model = new ModelAndView("QuotationCar/stepOne");
                    model.addObject("step", 1);
                    break;
            }
        }

        return model;
    }
}
