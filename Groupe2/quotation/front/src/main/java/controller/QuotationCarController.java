package controller;

import com.ICarService;
import com.IDriverService;
import com.IQuotationService;
import com.back.Formul;
import com.back.Fuel;
import com.back.Mark;
import com.back.Model;
import com.front.Car;
import com.front.Driver;
import com.front.Quotation;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import vertex.VerticleListener;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
            model.addObject("fuels", this.getAllFuels());
            model.addObject("marks", this.getAllMarks());
            model.addObject("models", this.getAllModels());

            model.addObject("step", 1);
        } else {
            Car car = carService.findOneByQuotationId(id);
            Iterable<Driver> drivers = driverService.findByCarId(car.getId());

            switch(quotation.getNbStep()){
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


    private List<Fuel> getAllFuels() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8091/api/fuel").build().toUri();

        String result = restTemplate.getForObject(uri, String.class);

        return Json.decodeValue(result, List.class);
    }

    private List<Mark> getAllMarks() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8091/api/mark").build().toUri();

        String result = restTemplate.getForObject(uri, String.class);

        return Json.decodeValue(result, List.class);
    }

    private List<Model> getAllModels() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8091/api/model").build().toUri();

        String result = restTemplate.getForObject(uri, String.class);

        return Json.decodeValue(result, List.class);
    }

    private List<Formul> getAllFormul() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8091/api/formul").build().toUri();

        String result = restTemplate.getForObject(uri, String.class);

        return Json.decodeValue(result, List.class);
    }

}
