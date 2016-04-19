package controller;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.*;

import java.util.Date;

/**
 * Created by bmille on 22/03/2016.
 */
@Controller
@RequestMapping("/wizard.form")
@SessionAttributes("modelWizard")
public class VehiculeController {
    @Autowired
    private ICarInsuranceService carInsuranceService;
    @Autowired
    private IInsuranceService insuranceService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IVehiculeService vehiculeService;
    @Autowired
    private IDriverService driverService;

    private String[] pageViews = new String[] {"vehicule1","vehicule2", "vehicule3", "vehicule4", "vehicule5"};

    @RequestMapping(path = "/vehicle1",method = RequestMethod.GET)
    public ModelAndView vehicle1View(){
        ModelAndView model = new ModelAndView("wizard/vehicule1","modelWizard", new ModelWizard());
        return model;
    }

    @RequestMapping(path = "/vehicle2/{idInsurance}",method = RequestMethod.GET)
    public @ResponseBody ModelAndView vehicle2View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("vehicule2");
        Insurance insurance = insuranceService.findByIdInsurance(idInsurance);
        model.addObject("carInsurance", carInsuranceService.findByInsurance(insurance));
        return model;
    }
/*
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView vehicle2View(@RequestParam("/vehicle2") int currentPage,
                                     @ModelAttribute("modelWizard") ModelWizard modelWizard,
                                     @RequestParam String insuranceName,
                                     @RequestParam String vehicleBrand,
                                     @RequestParam String vehicleFuel,
                                     @RequestParam int vehicleHorspowerTax,
                                     @RequestParam String vehicleModel) {

        CarInsurance carInsurance = new CarInsurance();
        Insurance insurance = new Insurance();
        Driver driver = new Driver();
        Vehicule vehicule = new Vehicule();
        driver.setUser(userService.getUser(1));
        vehicule.setDriver(driver);
        vehicule.setBrand(vehicleBrand);
        vehicule.setModel(vehicleModel);
        vehicule.setFuel(vehicleFuel);
        vehicule.setHorsePowerTax(vehicleHorspowerTax);
        insurance.setName(insuranceName);
        insurance.setStep(2);
        insurance.setStatement("En cours");
        carInsurance.setVehicule(vehiculeService.saveAndgetVehicule(vehicule));
        carInsurance.setInsurance(insuranceService.saveAndgetInsurance(insurance));
        carInsurance = carInsuranceService.saveAndgetCarInsurance(carInsurance);

        // pageViews est un tableau qui renvois le nom de la vue suivant le numéro d'étape
        return new ModelAndView("wizard/"+pageViews[currentPage-1]);
    }*/

    @RequestMapping(path = "/vehicle3/{idInsurance}",method = RequestMethod.GET)
    public @ResponseBody ModelAndView vehicle3View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("vehicule3");
        Insurance insurance = insuranceService.findByIdInsurance(idInsurance);
        model.addObject("carInsurance", carInsuranceService.findByInsurance(insurance));
        return model;
    }

   /* @RequestMapping(path = "/vehicle3",method = RequestMethod.POST)
    public ModelAndView vehicle2View(@RequestParam Date userDrivingLicenseDate,
                                     @RequestParam int userAccidentNumber,
                                     @RequestParam int userBonusMalus){
        ModelAndView model = new ModelAndView("vehicule3");

        driver.setDrivingLicenceDate(userDrivingLicenseDate);
        driver.setAccidentNumber(userAccidentNumber);
        driver.setBonusMalus(userBonusMalus);

        driverService.saveDriver(driver);

        model.addObject("carInsurance", carInsurance);
        model.addObject("driver", driver);
        model.addObject("insurance", insurance);
        model.addObject("vehicule", vehicule);
        return model;
    }*/

    @RequestMapping(path = "/vehicle4/{idInsurance}",method = RequestMethod.GET)
    public @ResponseBody ModelAndView vehicle4View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("vehicule4");
        Insurance insurance = insuranceService.findByIdInsurance(idInsurance);
        model.addObject("carInsurance", carInsuranceService.findByInsurance(insurance));
        return model;
    }

    /*@RequestMapping(path = "/vehicle4",method = RequestMethod.POST)
    public ModelAndView vehicle2View(@RequestParam String carInsuranceSecondaryDriver,
                                     @RequestParam int vehicleInGarage){
        ModelAndView model = new ModelAndView("vehicule4");
        carInsurance.getSecondaryDriver(carInsuranceSecondaryDriver);
        vehicule.setInGarage(vehicleInGarage);
        model.addObject("carInsurance", carInsurance);
        model.addObject("driver", driver);
        model.addObject("insurance", insurance);
        model.addObject("vehicule", vehicule);
        return model;
    }*/

   /* @RequestMapping(path = "/vehicle5",method = RequestMethod.POST)
    public ModelAndView vehicle2View(@RequestParam String insuranceSummary,
                                     @RequestParam int insuranceAllRisks,
                                     @RequestParam int insurancePrice,
                                     @RequestParam int insuranceThird){
        ModelAndView model = new ModelAndView("vehicule5");
        insurance.setPrice(insurancePrice);
        insurance.setSummary(insuranceSummary);
        carInsurance.setAllRisks(insuranceAllRisks);
        carInsurance.setPrice(insurancePrice);
        carInsurance.setThird(insuranceThird);
        return model;
    }*/
}
