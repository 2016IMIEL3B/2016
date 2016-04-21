package controller;

import fr.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gtostain on 24/03/2016.
 */
@Controller
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping(value = "/synthesis", method = RequestMethod.GET)
    public ModelAndView synthesis(){
        ModelAndView model = new ModelAndView("synthesis");
        Iterable<Quote> quotes = quoteService.findAll();
        model.addObject("quotes", quotes);
        return model;
    }
}
