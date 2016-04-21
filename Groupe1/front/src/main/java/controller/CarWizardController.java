package controller;


import controller.model.CarModel;
import fr.BrandService;
import fr.Quote;
import fr.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by EVER on 24/03/2016.
 */

@Controller
@RequestMapping("/carWizard.form")
@SessionAttributes("carWizard")
public class CarWizardController {

    private String[] pageViews = new String[] {"car-step1","car-step2","car-step3","car-step4"};

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private BrandService brandService;

    @RequestMapping
    public ModelAndView processWizard() {

         List<String> brands = Arrays.asList( brandService.findAll().iterator().getClass().getName());

            Map parameterMap = new HashMap<String, Object>();
            parameterMap.put("brands", brands);
            parameterMap.put("carWizard", new CarModel());


        return new ModelAndView("wizard/car/car-step1",  parameterMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
    @ModelAttribute("carWizard") CarModel carWizard) {
        return new ModelAndView("wizard/car/"+pageViews[currentPage-1]);
    }

    @RequestMapping(value = "/quote/{quoteId}", method = RequestMethod.GET)
    public ModelAndView getFromSynthesis(@PathVariable Integer quoteId) {
        Quote quote = quoteService.findOne(quoteId);
        CarModel carModel = new CarModel(quote);
        return new ModelAndView("wizard/car/car-step"+quote.getStep(),"carWizard", carModel);
    }
    @RequestMapping(params = "_finish")

    public ModelAndView processFinish(@ModelAttribute("habWizard") CarModel carWizard, SessionStatus status) {
        try {
            quoteService.save(carWizard.getQuote());
        } catch (Exception e){
            System.out.print(e.getMessage());
        }

        // suppression de l'objet en session
        status.setComplete();
        return new ModelAndView("successView");
    }

    @RequestMapping(params = "_cancel")
    public String processCancel(SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return "wizard/canceledView";
    }

}