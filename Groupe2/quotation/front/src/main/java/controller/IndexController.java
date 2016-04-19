package controller;

import com.IQuotationService;
import com.QuotationRepository;

import com.auth.UserSession;
import com.front.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    UserSession usersession;

    @Autowired
    IQuotationService qs;

    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home(){

        ModelAndView model = new ModelAndView("index");

        if(usersession.getUser() != null){
            // FindById Quotation and Add to Model
            if(usersession.getUser().getId() != 0)
                model.addObject("quotations", qs.findByUserId(usersession.getUser().getId()));
            else{
                model = new ModelAndView("Error/index");
                model.addObject("message", "L'id de l'utilisateur n'est pas présent dans la BDD");
            }
        }else{
            model = new ModelAndView("login");
        }

        return model;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = {"/error"}, method = RequestMethod.GET)
    public ModelAndView error(){
        ModelAndView model = new ModelAndView("Error/index");

        model.addObject("message", "Une erreur est survenue lors de l'éxecution de l'application");

        return model;
    }

}
