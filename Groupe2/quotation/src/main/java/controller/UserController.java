package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class UserController {

    @RequestMapping({"/Utilisateurs"})
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("User/index");
        return model;
    }
}
