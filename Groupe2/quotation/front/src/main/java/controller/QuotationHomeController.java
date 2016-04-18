package controller;

import com.IHomeService;
import com.IQuotationService;
import com.auth.UserSession;
import com.back.HeaterType;
import com.back.HomeType;
import com.front.Home;
import com.front.Quotation;
import com.utils.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class QuotationHomeController {

    @Autowired
    IHomeService homeService;

    @Autowired
    IQuotationService quotationService;

    @Autowired
    UserSession userSession;


    @RequestMapping(value = "/devis/{id}/habitation", method = RequestMethod.GET)
    public ModelAndView quotationHome(@PathVariable int id) {
        ModelAndView model = null;

        Quotation quotation = quotationService.findOneById(id);

        if (quotation == null) {
            model = new ModelAndView("QuotationHome/stepOne", "home", new Home());
            model.addObject("homeType", this.getAllHomeType());
            model.addObject("heaterType", this.getAllHeaterType());
            model.addObject("step", 1);
        } else {
            Home home = homeService.findOneByQuotationId(id);

            switch(quotation.getNbStep()){
                case 1:
                    model = new ModelAndView("QuotationHome/stepOne","home",home);
                    model.addObject("step", 1);
                    break;
                case 2:
                    model = new ModelAndView("QuotationHome/stepTwo","home",home);
                    model.addObject("step", 2);
                    break;
                case 3:
                    model = new ModelAndView("QuotationHome/stepThree","home",home);
                    model.addObject("step", 3);
                    break;
                case 4:
                    model = new ModelAndView("QuotationHome/stepFour","home",home);
                    model.addObject("step", 4);
                    break;
                default:
                    model = new ModelAndView("QuotationHome/stepOne","home", new Home());
                    model.addObject("step", 1);
                    break;
            }
        }

        return model;
    }

    @RequestMapping(value = "/devis/habitation/send/1", method = RequestMethod.POST)
    public ModelAndView quotationHomeStepOne(@ModelAttribute Home home) {

        ModelAndView model = null;

        if ((home.getQuotation().getName() != "")
                && (home.getHomeType() != "")
                && (home.getSurface() != 0)) {
            home.getQuotation().setNbStep(2);
            Quotation result = this.quotationService.save(home.getQuotation());
            Home homeResult = this.homeService.save(home);
            model = new ModelAndView(String.format("redirect:/devis/%d/habitation", homeResult.getQuotation().getId()));
        }
        return model;
    }
    @RequestMapping(value = "/devis/habitation/send/2", method = RequestMethod.POST)
    public ModelAndView quotationHomeStepTwo(@ModelAttribute Home home) {

        ModelAndView model = null;

        if ((home.getNbRoom() != 0)
                && (home.getNbBathroom() != 0)) {
            home.getQuotation().setNbStep(3);
            Quotation result = this.quotationService.save(home.getQuotation());
            Home homeResult = this.homeService.save(home);
            model = new ModelAndView(String.format("redirect:/devis/%d/habitation", homeResult.getQuotation().getId()));
        }
        return model;
    }
    @RequestMapping(value = "/devis/habitation/send/3", method = RequestMethod.POST)
    public ModelAndView quotationHomeStepThree(@ModelAttribute Home home) {

        ModelAndView model = null;

        if ((home.getSurfaceGround() != 0)
                && (home.getSurfaceTerrace() != 0)
                && (home.getHeaterType() != "")) {
            home.getQuotation().setNbStep(4);
            Quotation result = this.quotationService.save(home.getQuotation());
            Home homeResult = this.homeService.save(home);
            model = new ModelAndView(String.format("redirect:/devis/%d/habitation", homeResult.getQuotation().getId()));
        }
        return model;
    }
    @RequestMapping(value = "/devis/habitation/send/4", method = RequestMethod.POST)
    public ModelAndView quotationHomeStepFour(@ModelAttribute Home home) {

        ModelAndView model = null;

        if ((home.getFormul() != "")) {
            home.getQuotation().setNbStep(0);
            Quotation result = this.quotationService.save(home.getQuotation());
            Home homeResult = this.homeService.save(home);
            model = new ModelAndView(String.format("redirect:/"));
        }
        return model;
    }

    private List<HomeType> getAllHomeType() {
        return (List<HomeType>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/homeType").getBody();
    }

    private List<HeaterType> getAllHeaterType() {
        return (List<HeaterType>) new RestHelper(userSession.getHeaderToken()).apiRequest("/api/homeType").getBody();
    }
}
