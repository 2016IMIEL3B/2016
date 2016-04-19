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
import com.utils.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
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
            model.addObject("horsepowers", this.getAllHorsePowers());
            model.addObject("userSession", userSession.getUser());
            model.addObject("step", 1);
        } else {
            Car car = carService.findOneByQuotationId(id);
            car.setQuotation(quotation);

            switch(quotation.getNbStep()){
                case 0:
                    this.principalDriver = driverService.findOneByCarIdAndPrincipal(car.getId(), false);

                    model = new ModelAndView("QuotationCar/index","driver", this.principalDriver);
                    break;
                case 2:
                    model = new ModelAndView("QuotationCar/stepTwo", "driver", new Driver());
                    model.addObject("step", 2);
                    break;
                case 3:
                    this.principalDriver = driverService.findOneByCarIdAndPrincipal(car.getId(), false);

                    this.principalDriver.setCar(car);
                    model = new ModelAndView("QuotationCar/stepThree", "driver", this.principalDriver);
                    model.addObject("step", 3);
                    break;
                case 4:
                    this.principalDriver = driverService.findOneByCarIdAndPrincipal(car.getId(), true);
                    Driver secondDriver = driverService.findOneByCarIdAndPrincipal(car.getId(), true);

                    this.principalDriver.setCar(car);
                    quotation.setPrice(359.45f);
                    this.principalDriver.getCar().setQuotation(quotation);
                    model = new ModelAndView("QuotationCar/stepFour", "driver", this.principalDriver);
                    model.addObject("secondDriver", secondDriver);
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

        this.principalDriver = this.driverService.findOneByCarIdAndPrincipal(car.getId(), false);

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

        this.principalDriver = this.driverService.findOneByCarIdAndPrincipal(car.getId(), false);

        this.principalDriver.setFirstName(driver.getFirstName());
        this.principalDriver.setLastName(driver.getLastName());
        this.principalDriver.setPrincipal(true);

        car.setSleepGarage(driver.getCar().isSleepGarage());
        car.setAddress(driver.getCar().getAddress());

        quotation.setNbStep(4);

        this.carService.save(car);
        this.quotationService.save(quotation);
        this.driverService.save(this.principalDriver);

        if (secondFirstName != "" && secondLastName != "") {
            secondDriver = new Driver();

            secondDriver.setFirstName(secondFirstName);
            secondDriver.setLastName(secondLastName);
            secondDriver.setCar(car);
            secondDriver.setPrincipal(false);

            this.driverService.save(secondDriver);
        }

        model = new ModelAndView(String.format("redirect:/devis/%d/voiture", this.principalDriver.getCar().getQuotation().getId()));

        return model;
    }

    @RequestMapping(value = "/devis/{id}/voiture/send/4", method = RequestMethod.POST)
    public ModelAndView quotationCarStepFour(@ModelAttribute Driver driver, @PathVariable int id) {

        ModelAndView model = null;

        Quotation quotation = this.quotationService.findOneById(id);
        Car car = this.carService.findOneByQuotationId(quotation.getId());
        this.principalDriver = this.driverService.findOneByCarIdAndPrincipal(car.getId(), true);

        car.setTier(driver.getCar().isTier());
        quotation.setState("Fini");
        quotation.setNbStep(0);

        this.quotationService.save(car.getQuotation());
        this.carService.save(car);

        model = new ModelAndView(String.format("redirect:/"));

        return model;
    }


    private List<Fuel> getAllFuels() {
        return (List<Fuel>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/fuel").getBody();
    }

    private List<Mark> getAllMarks() {
        return (List<Mark>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/mark").getBody();
    }

    private List<Model> getAllModels() {
        return (List<Model>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/model").getBody();
    }

    private List<HorsePower> getAllHorsePowers() {
        return (List<HorsePower>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/horsepower").getBody();
    }

    private List<Price> getAllPrice() {
        return (List<Price>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/price").getBody();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
