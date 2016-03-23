package controller;

import com.ICarService;
import com.IDriverService;
import com.IHomeService;
import com.IQuotationService;
import com.front.Car;
import com.front.Driver;
import com.front.Home;
import com.front.Quotation;
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
public class QuotationHomeController {

    @Autowired
    IHomeService homeService;

    @Autowired
    IQuotationService quotationService;

    @RequestMapping(value = "/devis/{id}/maison", method = RequestMethod.GET)
    public ModelAndView quotationHome(@PathVariable int id) {
        ModelAndView model = null;

        Quotation quotation = quotationService.findOneById(id);

        if (quotation == null) {
            model = new ModelAndView("QuotationHome/stepOne");
            model.addObject("step", 1);
        } else {
            Home home = homeService.findOneByQuotationId(id);

            if (home == null) {
                model = new ModelAndView("QuotationHome/stepOne");
                model.addObject("step", 1);
            } else if (home.getNbRoom() == 0) {
                model = new ModelAndView("QuotationHome/stepTwo");
                model.addObject("step", 2);
            } else if (home.getSurfaceGround() == 0) {
                model = new ModelAndView("QuotationHome/stepThree");
                model.addObject("step", 3);
            } else {
                model = new ModelAndView("QuotationHome/stepFour");
                model.addObject("step", 4);
            }
        }



        return model;
    }
}
