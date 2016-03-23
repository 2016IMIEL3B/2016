package controller;

import com.IQuotationService;
import com.QuotationRepository;

import com.front.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.QuotationService;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class IndexController {

    @Autowired
    IQuotationService qs;

    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home(){

        ModelAndView model = new ModelAndView("index");

        // Recuperer L'id de l'utilisateur courant

        // FindById Quotation and Add to Model
        model.addObject("quotations", qs.findAll());
        return model;

    }

}
