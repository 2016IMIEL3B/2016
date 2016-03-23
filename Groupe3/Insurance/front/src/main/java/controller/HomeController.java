package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.IHelloService;

/**
 * Created by bmille on 22/03/2016.
 */
public class HomeController {
    @Autowired
    private IHelloService helloService;

    @RequestMapping(path = "/home1",method = RequestMethod.GET)
    public ModelAndView index1View(){
        ModelAndView model = new ModelAndView("home1");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }

    @RequestMapping(path = "/home2",method = RequestMethod.GET)
    public ModelAndView index2View(){
        ModelAndView model = new ModelAndView("home2");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }

    @RequestMapping(path = "/home3",method = RequestMethod.GET)
    public ModelAndView index3View(){
        ModelAndView model = new ModelAndView("home3");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }

    @RequestMapping(path = "/home4",method = RequestMethod.GET)
    public ModelAndView index4View(){
        ModelAndView model = new ModelAndView("home4");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }
}
