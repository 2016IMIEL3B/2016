package com.group4.front.controller;

import com.group4.front.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(path = "/index",  method = RequestMethod.GET)
    public ModelAndView index(){
        //this.itemService.findItemsByParentId(1);

        ModelAndView model = new ModelAndView("index");

        return model;
    }
}
