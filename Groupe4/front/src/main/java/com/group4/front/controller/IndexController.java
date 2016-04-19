package com.group4.front.controller;

import com.group4.front.common.AppData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private AppData session;

    @RequestMapping(path = "/",  method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        System.out.println(session);

        return model;
    }
}
