package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Jerome on 22/03/2016.
 */
@Controller
public class LoginController {

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public ModelAndView loginView(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public ModelAndView logoutView(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }
}
