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
import org.springframework.web.bind.annotation.ModelAttribute;
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
            model = new ModelAndView("QuotationCar/stepOne", "car", new Car());
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

    @RequestMapping(value = "/devis/voiture/send/1", method = RequestMethod.POST)
    public ModelAndView quotationCarStepOne(@ModelAttribute Car car) {

        ModelAndView model = null;

        if ((car.getQuotation().getName() != "")
                && (car.getMark() != "")
                && (car.getModel() != "")
                && (car.getFuel() != "")
                && (car.getTaxableHorsePower() != 0)) {
            car.getQuotation().setNbStep(2);
            Quotation result = this.quotationService.save(car.getQuotation());
            Car carResult = this.carService.save(car);
            model = new ModelAndView(String.format("redirect:/devis/%d/voiture", carResult.getQuotation().getId()));
        }
        return model;
    }



    @RequestMapping(value = "/devis/voiture/send/2", method = RequestMethod.POST)
    public ModelAndView quotationDriverStepTwo(@ModelAttribute Driver driver) {

        ModelAndView model = null;

        if ((driver.getLicenceDate() != null)
                && (driver.getNbCrash() > -1)) {
            driver.getCar().getQuotation().setNbStep(3);
            Quotation result = this.quotationService.save( driver.getCar().getQuotation());
            Driver driverResult = this.driverService.save(driver);
            model = new ModelAndView(String.format("redirect:/devis/%d/voiture", driverResult.getCar().getQuotation().getId()));
        }
        return model;
    }


    @RequestMapping(value = "/devis/voiture/send/3", method = RequestMethod.POST)
    public ModelAndView quotationCarStepThree(@ModelAttribute Car car) {

        ModelAndView model = null;

        if ((car.getAddress() != "")) {
            car.getQuotation().setNbStep(4);
            Quotation result = this.quotationService.save(car.getQuotation());
            Car carResult = this.carService.save(car);
            model = new ModelAndView(String.format("redirect:/devis/%d/voiture", carResult.getQuotation().getId()));
        }
        return model;
    }

    @RequestMapping(value = "/devis/voiture/send/4", method = RequestMethod.POST)
    public ModelAndView quotationCarStepFour(@ModelAttribute Car car) {

        ModelAndView model = null;

        if ((car.getInsurance() != "")) {
            car.getQuotation().setNbStep(0);
            Quotation result = this.quotationService.save(car.getQuotation());
            Car carResult = this.carService.save(car);
            model = new ModelAndView(String.format("redirect:/"));
        }
        return model;
    }

}
