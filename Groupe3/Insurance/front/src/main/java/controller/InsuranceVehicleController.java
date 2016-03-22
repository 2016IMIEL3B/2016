package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.IHelloService;

/**
 * Created by bmille on 22/03/2016.
 */
public class InsuranceVehicleController {
    @Autowired
    private IHelloService helloService;

    @RequestMapping(path = "/vehicle1",method = RequestMethod.GET)
    public ModelAndView index1View(){
        ModelAndView model = new ModelAndView("vehicle1");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }

    @RequestMapping(path = "/vehicle2",method = RequestMethod.GET)
    public ModelAndView index2View(){
        ModelAndView model = new ModelAndView("vehicle2");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }

    @RequestMapping(path = "/vehicle3",method = RequestMethod.GET)
    public ModelAndView index3View(){
        ModelAndView model = new ModelAndView("vehicle3");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }

    @RequestMapping(path = "/vehicle4",method = RequestMethod.GET)
    public ModelAndView index4View(){
        ModelAndView model = new ModelAndView("vehicle4");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }
}
