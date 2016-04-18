package com.group4.front.controller;

import com.group4.front.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(path = "/index",  method = RequestMethod.GET)
    public ModelAndView index(){
        ItemService itemService = new ItemService();

        itemService.findItemsByParentId(1);

        ModelAndView model = new ModelAndView("index");

        return model;
    }
}
