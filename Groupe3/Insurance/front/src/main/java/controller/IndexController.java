package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.IInsuranceService;
import services.IUserService;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class IndexController {
    @Autowired
    private IInsuranceService insuranceService;
    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView indexView(){
        ModelAndView model = new ModelAndView("index");
        User user = userService.getUser(11);
        model.addObject("insurances", insuranceService.findByStatementAndUser("En cours", user));
        return model;
    }
}
