package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bmille on 22/03/2016.
 */
public class UserController {

    @RequestMapping(path = "/user",method = RequestMethod.POST)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("user");
        return model;
    }
}
