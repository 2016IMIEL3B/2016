package com.group4.front.controller;

import com.group4.front.common.AppData;
import com.group4.front.common.User;
import com.group4.front.services.AuthenticationService;
import com.group4.front.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WizardCarController {

    @Autowired
    AppData session;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/wizard", method = RequestMethod.GET)
    public ModelAndView wizard(){
        ModelAndView model = new ModelAndView("wizard_car");
        User user = this.userService.findUserById(this.session.getIdUser());
        String userName = user.getSurname() + " " + user.getName();

        model.addObject("user_name", userName);
        return model;
    }
}
