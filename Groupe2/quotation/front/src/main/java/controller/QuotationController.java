package controller;

import com.IQuotationService;
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
public class QuotationController {

    @Autowired
    IQuotationService qs;

    @RequestMapping({"/devis"})
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("Quotation/index");
        return model;
    }

    @RequestMapping({"/devis/habitation"})
    public ModelAndView quotationHome(){
        ModelAndView model = new ModelAndView("Quotation_Home/index");
        return model;
    }

    @RequestMapping(path = {"/devis/supprimer/{id}"},method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id){

        ModelAndView model = null;
        try{

            qs.delete(id);
            model = new ModelAndView("redirect:/home");

        }catch (Throwable t){

            model = new ModelAndView("Error/index");
            model.addObject("message","Erreur lors de la suppression du devis");

        }
        return model;
    }

}
