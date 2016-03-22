package controller;

import com.QuotationRepository;

import com.front.Quotation;
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

    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home(){
        // Recuperer L'utilisateur courant
        ModelAndView model = new ModelAndView("Quotation/index");
        // Recuperer le id du User courant
        QuotationService qs = new QuotationService();
        Iterable<Quotation> quotations = qs.findAll();
        // FindById Quotation and Add to Model
        return model;
    }

}
