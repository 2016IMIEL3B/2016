package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.IHelloService;

/**
 * Created by bmille on 22/03/2016.
 */
public class UserController {
    @Autowired
    private IHelloService helloService;

    @RequestMapping(path = "/user",method = RequestMethod.POST)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("user");
        model.addObject("message","Hello world from indexCOntroller -> " + helloService.hello());
        return model;
    }
}
