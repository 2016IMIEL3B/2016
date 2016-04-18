package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class ResultController {

    @RequestMapping(path = "/result",method = RequestMethod.POST)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("result");
        model.addObject("message","Hello world from indexCOntroller -> ");
        return model;
    }

}