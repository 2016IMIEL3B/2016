package controller;

import com.ICarService;
import com.IDriverService;
import com.IQuotationService;
import com.ITypeQuotationService;
import com.auth.UserSession;
import com.back.*;
import com.front.Car;
import com.front.Driver;
import com.front.Quotation;
import com.front.TypeQuotation;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import vertex.VerticleListener;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    ITypeQuotationService typeQuotationService;

    @Autowired
    IDriverService driverService;

    @Autowired
    UserSession userSession;

    Driver principalDriver;


    @RequestMapping(value = "/devis/{id}/voiture", method = RequestMethod.GET)
    public ModelAndView quotationCar(@PathVariable int id) {
        ModelAndView model = null;

        Quotation quotation = quotationService.findOneById(id);

        if (quotation == null) {
            model = new ModelAndView("QuotationCar/stepOne", "car", new Car());
            model.addObject("fuels", this.getAllFuels());
            model.addObject("marks", this.getAllMarks());
            model.addObject("models", this.getAllModels());
            model.addObject("horsepowers", this.getAllHorsePowers());
            model.addObject("step", 1);
        } else {
            Car car = carService.findOneByQuotationId(id);
            car.setQuotation(quotation);

            Iterable<Driver> drivers = driverService.findByCarId(car.getId());

            switch(quotation.getNbStep()){
                case 2:
                    model = new ModelAndView("QuotationCar/stepTwo", "driver", new Driver());
                    model.addObject("step", 2);
                    break;
                case 3:
                    drivers.forEach(driver -> { QuotationCarController.this.principalDriver = driver; } );
                    this.principalDriver.setCar(car);
                    model = new ModelAndView("QuotationCar/stepThree", "driver", this.principalDriver);
                    model.addObject("step", 3);
                    break;
                case 4:
                    drivers.forEach(driver -> { if (driver.isPrincipal()) QuotationCarController.this.principalDriver = driver; } );
                    this.principalDriver.setCar(car);
                    model = new ModelAndView("QuotationCar/stepFour", "driver", this.principalDriver);
                    model.addObject("step", 4);
                    break;
                default:
                    model = new ModelAndView("QuotationCar/stepOne", "car", new Car());
                    model.addObject("step", 1);
                    break;
            }

            model.addObject("id", id);
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
            car.getQuotation().setState("En Cours");
            car.getQuotation().setTypeQuotation(this.typeQuotationService.findOneByEntitled("Voiture"));
            car.getQuotation().setUserId(this.userSession.getUser().getId());

            Driver driver = new Driver();

            this.quotationService.save(car.getQuotation());

            Car carResult = this.carService.save(car);
            driver.setCar(carResult);

            this.driverService.save(driver);

            model = new ModelAndView(String.format("redirect:/devis/%d/voiture", carResult.getQuotation().getId()));
        }
        return model;
    }



    @RequestMapping(value = "/devis/{id}/voiture/send/2", method = RequestMethod.POST)
    public ModelAndView quotationDriverStepTwo(@ModelAttribute Driver driver, @PathVariable int id) {
        ModelAndView model = null;
        Quotation quotation = this.quotationService.findOneById(id);
        Car car = this.carService.findOneByQuotationId(quotation.getId());

        this.driverService.findByCarId(car.getId()).forEach(obj -> QuotationCarController.this.principalDriver = obj);

        this.principalDriver.setLicenceDate(driver.getLicenceDate());
        this.principalDriver.setBonusPenality(driver.getBonusPenality());
        this.principalDriver.setNbCrash(driver.getNbCrash());

        if ((driver != null && driver.getLicenceDate() != null)
                && (driver.getNbCrash() > -1)) {
            quotation.setNbStep(3);
            this.quotationService.save(quotation);
            this.driverService.save(this.principalDriver);
            model = new ModelAndView(String.format("redirect:/devis/%d/voiture", this.principalDriver.getCar().getQuotation().getId()));
        } else {
            model = new ModelAndView("redirect:/error");
        }

        return model;
    }


    @RequestMapping(value = "/devis/{id}/voiture/send/3", method = RequestMethod.POST)
    public ModelAndView quotationCarStepThree(@ModelAttribute Driver driver, @PathVariable int id,
                                              @RequestParam("secondFirstName") String secondFirstName,
                                              @RequestParam("secondLastName") String secondLastName) {
        ModelAndView model = null;
        Quotation quotation = this.quotationService.findOneById(id);
        Car car = this.carService.findOneByQuotationId(quotation.getId());
        Driver secondDriver =  null;
        if (secondFirstName != "" && secondLastName != "") {
            secondDriver = new Driver();

            secondDriver.setFirstName(secondFirstName);
            secondDriver.setLastName(secondLastName);
            secondDriver.setCar(car);
            secondDriver.setPrincipal(false);

            this.driverService.save(secondDriver);
        }

        this.driverService.findByCarId(car.getId()).forEach(obj -> QuotationCarController.this.principalDriver = obj);

        this.principalDriver.setFirstName(driver.getFirstName());
        this.principalDriver.setLastName(driver.getLastName());
        this.principalDriver.setPrincipal(true);

        car.setSleepGarage(driver.getCar().isSleepGarage());
        car.setAddress(driver.getCar().getAddress());

        quotation.setNbStep(4);

        this.carService.save(car);
        this.quotationService.save(quotation);
        this.driverService.save(this.principalDriver);

        model = new ModelAndView(String.format("redirect:/devis/%d/voiture", this.principalDriver.getCar().getQuotation().getId()));

        return model;
    }

    @RequestMapping(value = "/devis/{id}/voiture/send/4", method = RequestMethod.POST)
    public ModelAndView quotationCarStepFour(@ModelAttribute Driver driver, @PathVariable int id) {

        ModelAndView model = null;

        Quotation quotation = this.quotationService.findOneById(id);
        Car car = this.carService.findOneByQuotationId(quotation.getId());

        this.driverService.findByCarId(car.getId()).forEach(obj -> QuotationCarController.this.principalDriver = obj);

        this.principalDriver.setBonusPenality(driver.getBonusPenality());
        this.principalDriver.setLicenceDate(driver.getLicenceDate());
        this.principalDriver.setNbCrash(driver.getNbCrash());

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

    private List<Formul> getAllFormuls() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8091/api/formul").build().toUri();

        String result = restTemplate.getForObject(uri, String.class);

        return Json.decodeValue(result, List.class);
    }

    private List<HorsePower> getAllHorsePowers() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8091/api/horsepower").build().toUri();

        String result = restTemplate.getForObject(uri, String.class);

        return Json.decodeValue(result, List.class);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
