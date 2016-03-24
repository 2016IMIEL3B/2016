package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import controller.model.CarModel;

/**
 * Created by EVER on 24/03/2016.
 */

@Controller
@RequestMapping("/carwizard.form")
@SessionAttributes("CarModel")
public class CarWizardController {


    private String[] pageViews = new String[] {"car-step1","car-step2","car-step3","car-step4"};

    @RequestMapping
    public ModelAndView processWizard() {
        return new ModelAndView("wizard/car/car-step1", "CarModel", new CarModel());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
    @ModelAttribute("CarModel") CarModel carModel) {
        return new ModelAndView("wizard/car/"+pageViews[currentPage-1]);
    }

    @RequestMapping(params = "_finish")
     public ModelAndView processFinish(@ModelAttribute("CarModel") CarModel carModel, SessionStatus status){
        status.setComplete();
        return new ModelAndView("successView");
     }

    @RequestMapping (params = "_cancel")
    public String processCancel(SessionStatus status){
        status.setComplete();
        return "canceledView";
    }

}
