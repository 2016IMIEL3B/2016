package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class QuotationController {

    @RequestMapping({"/Devis"})
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("Quotation/index.jsp");
        return model;
    }

    @RequestMapping({"/Devis/Habitation"})
    public ModelAndView quotationHome(){
        ModelAndView model = new ModelAndView("Quotation_Home/index.jsp");
        return model;
    }
}
