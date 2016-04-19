package com.group4.front.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group4.front.common.AppData;
import com.group4.front.controller.model.QuoteHomeModel;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteHome;
import com.group4.front.entities.SimpleQuote;
import com.group4.front.entities.User;
import com.group4.front.services.ItemService;
import com.group4.front.services.QuoteService;
import com.group4.front.services.SimpleQuoteService;
import com.group4.front.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WizardHomeController {
    @Autowired
    AppData session;
    @Autowired
    private UserService userService;
    @Autowired
    private QuoteService quoteService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private SimpleQuoteService simpleQuoteService;

    private QuoteHome currentQuoteHome;
    private Quote currentQuote;


    @RequestMapping(path = "/wizard/home/1",  method = RequestMethod.GET)
    public ModelAndView wizardHome(){
        User user = this.userService.findUserById(this.session.getIdUser());
        String userName = user.getSurname() + " " + user.getName();

        ModelAndView model = new ModelAndView("wizard_home");

        QuoteHomeModel quoteHomeModel = new QuoteHomeModel();
        quoteHomeModel.setUserName(userName);
        if (currentQuoteHome == null) {
            quoteHomeModel.setQuoteHome(new QuoteHome());
        } else {
            quoteHomeModel.setQuoteHome(currentQuoteHome);
        }
        model.addObject("model", quoteHomeModel);

        return model;
    }

    @RequestMapping(path = "/wizard/home/2", method = { RequestMethod.GET, RequestMethod.POST})
    public ModelAndView wizardHome1Post(@ModelAttribute QuoteHomeModel quoteHomeModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_home_two");

        if(quoteHomeModel.getQuoteHome() != null){
            /* create a new quote */
            Quote quote = new Quote();
            quote.setName(quoteHomeModel.getUserName());
            quote.setStep(2);
            quote.setLogin(this.userService.findUserById(this.session.getIdUser()).getLogin());
            this.quoteService.insertQuote(quote);

            /* create a new quote home */
            this.currentQuoteHome = quoteHomeModel.getQuoteHome();
            this.currentQuoteHome.setIdQuote(quote.getId());
            this.quoteService.insertQuoteHome(quoteHomeModel.getQuoteHome());

        } else {
            quoteHomeModel.setQuoteHome(currentQuoteHome);
        }
        modelAndView.addObject("model", quoteHomeModel);

        return modelAndView;
    }

    @RequestMapping(path = "/wizard/home/3", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardHome2(@ModelAttribute QuoteHomeModel quoteHomeModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_home_three");

        if(quoteHomeModel.getQuoteHome() != null){
            this.currentQuoteHome.setNumberRoom(quoteHomeModel.getQuoteHome().getNumberRoom());
            this.currentQuoteHome.setFloor(quoteHomeModel.getQuoteHome().getFloor());
            this.currentQuoteHome.setNumberBathroom(quoteHomeModel.getQuoteHome().getNumberBathroom());
            this.currentQuoteHome.setGarage(quoteHomeModel.getQuoteHome().isGarage());

            /* update quote */
            this.currentQuote = this.quoteService.getQuoteById(currentQuoteHome.getIdQuote());
            this.currentQuote.setStep(3);
            this.quoteService.insertQuote(this.currentQuote);

            /* update quote home */
            this.quoteService.insertQuoteHome(this.currentQuoteHome);
        } else {
            quoteHomeModel.setQuoteHome(currentQuoteHome);
        }
        modelAndView.addObject("model", quoteHomeModel);

        return modelAndView;
    }

    @RequestMapping(path = "/wizard/home/4", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardHome3(@ModelAttribute QuoteHomeModel quoteHomeModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_home_four");

        if(quoteHomeModel.getQuoteHome() != null){
            this.currentQuoteHome.setGroundArea(quoteHomeModel.getQuoteHome().getGroundArea());
            this.currentQuoteHome.setTerraceArea(quoteHomeModel.getQuoteHome().getTerraceArea());
            this.currentQuoteHome.setTypeHeating(quoteHomeModel.getQuoteHome().getTypeHeating());
            this.currentQuoteHome.setFormula(quoteHomeModel.getQuoteHome().getFormula());

            /* update quote */
            this.currentQuote = this.quoteService.getQuoteById(currentQuoteHome.getIdQuote());
            this.currentQuote.setStep(4);
            this.quoteService.insertQuote(this.currentQuote);

            /* update quote home */
            this.quoteService.insertQuoteHome(this.currentQuoteHome);
        } else {
            quoteHomeModel.setQuoteHome(currentQuoteHome);
        }
        modelAndView.addObject("model", quoteHomeModel);

        return modelAndView;
    }

    @RequestMapping(path = "/resultHome", method = RequestMethod.POST)
    public ModelAndView wizardHomeEnd(@ModelAttribute QuoteHomeModel quoteHomeModel) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("index");

        /* update quote */
        this.currentQuote = this.quoteService.getQuoteById(currentQuoteHome.getIdQuote());
        this.currentQuote.setStep(4);
        this.currentQuote.setResume(quoteHomeModel.getQuote().getResume());
        this.currentQuote.setPrice(quoteHomeModel.getQuote().getPrice());

        SimpleQuote simpleQuote = new SimpleQuote();
        simpleQuote.setPrice(Math.round(this.currentQuote.getPrice()));
        simpleQuote.setTypeQuote("HomeQuote");
        simpleQuote.setGuarantee("Standard home guarantee");
        simpleQuote.setUserId(this.session.getIdUser());

        this.simpleQuoteService.createSimpleQuote(simpleQuote);
        this.quoteService.insertQuote(this.currentQuote);

        return modelAndView;
    }
}
