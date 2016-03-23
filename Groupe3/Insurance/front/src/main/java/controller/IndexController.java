package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class IndexController {

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

}
