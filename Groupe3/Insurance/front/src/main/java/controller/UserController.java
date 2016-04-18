package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.IUserService;

/**
 * Created by bmille on 22/03/2016.
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userView() {
        ModelAndView model = new ModelAndView("user");
        model.addObject("user", userService.getUser(1));
        return model;
    }
}
