package com.group4.front.controller;

import com.group4.front.common.AppData;
import com.group4.front.controller.model.QuoteHomeModel;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteHome;
import com.group4.front.services.QuoteService;
import com.group4.front.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    private QuoteHome currentQuoteHome;
    private Quote currentQuote;


    @RequestMapping(path = "/wizard/home/1",  method = RequestMethod.GET)
    public ModelAndView wizardHome(){

        /* Find current user */
        User user = this.userService.findUserById(this.session.getIdUser());
        String userName = user.getSurname() + " " + user.getName();

        /* Generate model for wizard 1 */
        ModelAndView model = new ModelAndView("wizard_home");

        if(currentQuoteHome == null){
            /* new quote home */
            QuoteHomeModel quoteHomeModel = new QuoteHomeModel();
            quoteHomeModel.setUserName(userName);
            quoteHomeModel.setQuoteHome(new QuoteHome());
            model.addObject("model", quoteHomeModel);

        }else{
            /* current quote home */
            QuoteHomeModel quoteHomeModel = new QuoteHomeModel();
            quoteHomeModel.setUserName(userName);
            quoteHomeModel.setQuoteHome(currentQuoteHome);
            model.addObject("model", quoteHomeModel);
        }

        return model;
    }

    @RequestMapping(path = "/wizard/home/2", method = { RequestMethod.GET, RequestMethod.POST})
    public ModelAndView wizardHome1Post(@ModelAttribute QuoteHomeModel quoteHomeModel, BindingResult bindingResult) {

        /* Generate the new model for wizard 2 */
        ModelAndView modelAndView = new ModelAndView("wizard_home_two");

        if(quoteHomeModel.getQuoteHome() != null){

            /* create a new quote */
            Quote quote = new Quote();
            quote.setName(quoteHomeModel.getUserName());
            quote.setStep(2);
            this.quoteService.insertQuote(quote);

            /* create a new quote home */
            this.currentQuoteHome = quoteHomeModel.getQuoteHome();
            this.currentQuoteHome.setIdQuote(quote.getId());
            this.quoteService.insertQuoteHome(quoteHomeModel.getQuoteHome());

            modelAndView.addObject("model", quoteHomeModel);

        }else if(this.currentQuoteHome.getId() != 0){

            quoteHomeModel.setQuoteHome(currentQuoteHome);
            modelAndView.addObject("model", quoteHomeModel);
        }

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

            modelAndView.addObject("model", quoteHomeModel);

        }else{
            quoteHomeModel.setQuoteHome(currentQuoteHome);
            modelAndView.addObject("model", quoteHomeModel);
        }

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

            modelAndView.addObject("model", quoteHomeModel);

        }else{
            quoteHomeModel.setQuoteHome(currentQuoteHome);
            modelAndView.addObject("model", quoteHomeModel);
        }

        return modelAndView;
    }

    @RequestMapping(path = "/resultHome", method = RequestMethod.POST)
    public ModelAndView wizardHomeEnd(@ModelAttribute QuoteHomeModel quoteHomeModel) {

        ModelAndView modelAndView = new ModelAndView("index");

        /* update quote */
        this.currentQuote = this.quoteService.getQuoteById(currentQuoteHome.getIdQuote());
        this.currentQuote.setStep(4);
        this.currentQuote.setResume(quoteHomeModel.getQuote().getResume());
        this.currentQuote.setPrice(quoteHomeModel.getQuote().getPrice());
        this.quoteService.insertQuote(this.currentQuote);

        return modelAndView;
    }
}
