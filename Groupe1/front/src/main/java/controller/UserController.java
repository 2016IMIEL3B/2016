package controller;

import fr.User;
import fr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gtostain on 24/03/2016.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView model = new ModelAndView("profile");

        User user = userService.findByLogin("jonas");

        model.addObject("user", user);

        return model;
    }


}
