package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bmille on 22/03/2016.
 */
@Controller
public class VehiculeController {
    @RequestMapping(path = "/vehicle1",method = RequestMethod.GET)
    public ModelAndView vehicle1View(){
        ModelAndView model = new ModelAndView("vehicule1");
        return model;
    }

    @RequestMapping(path = "/vehicle2",method = RequestMethod.GET)
    public ModelAndView vehicle2View(){
        ModelAndView model = new ModelAndView("vehicule2");
        return model;
    }

    @RequestMapping(path = "/vehicle3",method = RequestMethod.GET)
    public ModelAndView vehicle3View(){
        ModelAndView model = new ModelAndView("vehicule3");
        return model;
    }

    @RequestMapping(path = "/vehicle4",method = RequestMethod.GET)
    public ModelAndView vehicle4View(){
        ModelAndView model = new ModelAndView("vehicule4");
        return model;
    }
}
