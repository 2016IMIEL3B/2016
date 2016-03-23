package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bmille on 22/03/2016.
 */
@Controller
public class UserController {

    @RequestMapping(path = "/user",method = RequestMethod.GET)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("user");
        return model;
    }
}
