package com.group4.front.controller;

import com.group4.front.common.AppData;
import com.group4.front.common.User;
import com.group4.front.controller.model.QuoteHomeModel;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteHome;
import com.group4.front.services.QuoteService;
import com.group4.front.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class WizardHomeController {

    @Autowired
    AppData session;
    @Autowired
    private UserService userService;
    @Autowired
    private QuoteService quoteService;

    private QuoteHome currentQuoteHome;

    @RequestMapping(path = "/wizard/home/1",  method = RequestMethod.GET)
    public ModelAndView wizardHome(){
        ModelAndView model = new ModelAndView("wizard_home");
        User user = this.userService.findUserById(this.session.getIdUser());
        String userName = user.getSurname() + " " + user.getName();

        QuoteHomeModel quoteHomeModel = new QuoteHomeModel();
        quoteHomeModel.setUserName(userName);
        quoteHomeModel.setQuoteHome(new QuoteHome());

        model.addObject("model", quoteHomeModel);
        return model;
    }

    @RequestMapping(path = "/wizard/home/2", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardHome1(@ModelAttribute QuoteHomeModel quoteHomeModel, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("wizard_home_two");
        modelAndView.addObject("model", quoteHomeModel);

        this.currentQuoteHome = quoteHomeModel.getQuoteHome();

        return modelAndView;
    }

    @RequestMapping(path = "/wizard/home/3", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardHome2(@ModelAttribute QuoteHomeModel quoteHomeModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_home_three");
        modelAndView.addObject("model", quoteHomeModel);

        return modelAndView;
    }

    @RequestMapping(path = "/wizard/home/4", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardHome3(@ModelAttribute QuoteHomeModel quoteHomeModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_home_four");
        modelAndView.addObject("model", quoteHomeModel);

        return modelAndView;
    }

    @RequestMapping(path = "/resultHome", method = RequestMethod.POST)
    public ModelAndView wizardHomeEnd(@ModelAttribute QuoteHomeModel quoteHomeModel) {
        ModelAndView modelAndView = new ModelAndView("index");

        Quote quote = new Quote();
        quote.setName("Devis pouf");
        quote.setPrice(10);
        quote.setResume("Bla bla");
        quote.setLogin("JEan mi");
        quote.setStep(2);

        this.quoteService.insertQuote(quote);

        this.currentQuoteHome.setIdQuote(quote.getId());

        this.quoteService.insertQuoteHome(this.currentQuoteHome);

        return modelAndView;
    }
}
