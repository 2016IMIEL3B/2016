package controller;

import model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import services.IHouseInsuranceService;
import services.IInsuranceService;

/**
 * Created by bmille on 22/03/2016.
 */
@Controller
public class HomeController {
    @Autowired
    private IHouseInsuranceService houseInsuranceService;
    @Autowired
    private IInsuranceService insuranceService;

    @RequestMapping(path = "/home1",method = RequestMethod.GET)
    public @ResponseBody ModelAndView index1View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("home1");
        return model;
    }

    @RequestMapping(path = "/home2/{idInsurance}",method = RequestMethod.GET)
    public @ResponseBody ModelAndView index2View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("home2");
        Insurance insurance = insuranceService.findByIdInsurance(idInsurance);
        model.addObject("carInsurance", houseInsuranceService.findByInsurance(insurance));
        return model;
    }

    @RequestMapping(path = "/home3/{idInsurance}",method = RequestMethod.GET)
    public @ResponseBody ModelAndView index3View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("home3");
        Insurance insurance = insuranceService.findByIdInsurance(idInsurance);
        model.addObject("carInsurance", houseInsuranceService.findByInsurance(insurance));
        return model;
    }

    @RequestMapping(path = "/home4/{idInsurance}",method = RequestMethod.GET)
    public @ResponseBody ModelAndView index4View(@PathVariable int idInsurance){
        ModelAndView model = new ModelAndView("home4");
        Insurance insurance = insuranceService.findByIdInsurance(idInsurance);
        model.addObject("carInsurance", houseInsuranceService.findByInsurance(insurance));
        return model;
    }
}
