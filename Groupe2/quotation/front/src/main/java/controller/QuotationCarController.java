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
        ModelAndView model = null;

        Quotation quotation = quotationService.findOneById(id);

        if (quotation == null) {
            model = new ModelAndView("QuotationCar/stepOne");
            model.addObject("step", 1);
        } else {
            Car car = carService.findById(id);
            Driver driver = driverService.findOneByCarId(car.getId());

            if (driver == null) {
                model = new ModelAndView("QuotationCar/stepTwo");
                model.addObject("step", 2);
            } else if (car.getAddress() == null) {
                model = new ModelAndView("QuotationCar/stepThree");
                model.addObject("step", 3);
            } else if (car.getInsuranceId() == 0) {
                model = new ModelAndView("QuotationCar/stepFour");
                model.addObject("step", 4);
            }
        }

        return model;
    }
}
