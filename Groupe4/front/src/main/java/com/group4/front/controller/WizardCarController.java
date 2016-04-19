package com.group4.front.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.group4.front.common.AppData;
import com.group4.front.entities.SimpleQuote;
import com.group4.front.entities.User;
import com.group4.front.controller.model.QuoteCarModel;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteCar;
import com.group4.front.services.ItemService;
import com.group4.front.services.QuoteService;
import com.group4.front.services.SimpleQuoteService;
import com.group4.front.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WizardCarController {

    @Autowired
    AppData session;
    @Autowired
    private UserService userService;
    @Autowired
    private QuoteService quoteService;
    @Autowired
    private ItemService itemService;
    @Autowired
    SimpleQuoteService simpleQuoteService;

    private QuoteCar currentQuoteCar;
    private Quote currentQuote;

    @RequestMapping(path = "/wizard/car/1",  method = RequestMethod.GET)
    public ModelAndView wizard(){
        ModelAndView model = new ModelAndView("wizard_car");
        User user = this.userService.findUserById(this.session.getIdUser());
        String userName = user.getSurname() + " " + user.getName();

        QuoteCarModel quoteCarModel = new QuoteCarModel();
        quoteCarModel.setUserName(userName);
        quoteCarModel.setBrands(this.itemService.findItemsByType("MAR"));
        quoteCarModel.setFuels(this.itemService.findItemsByType("FUE"));
        quoteCarModel.setQuoteCar(new QuoteCar());
        quoteCarModel.setQuote(new Quote());

        model.addObject("model", quoteCarModel);
        return model;
    }

    @RequestMapping(path = "/wizard/car/2", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardCar(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_car_two");
        modelAndView.addObject("model", quoteCarModel);

        User user = this.userService.findUserById(this.session.getIdUser());
        this.currentQuoteCar = quoteCarModel.getQuoteCar();

        Quote quote = new Quote();
        quote.setLogin(user.getLogin());
        quote.setStep(1);

        this.currentQuote = quote;
        this.quoteService.insertQuote(this.currentQuote);
        this.currentQuoteCar.setIdQuote(quote.getId());
        this.quoteService.insertQuoteCar(this.currentQuoteCar);

        return modelAndView;
    }

    @RequestMapping(path = "/wizard/car/3", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardCar2(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_car_three");
        modelAndView.addObject("model", quoteCarModel);

        this.currentQuote.setStep(2);
        this.currentQuoteCar.setDateLicence(quoteCarModel.getQuoteCar().getDateLicence());
        this.currentQuoteCar.setNumberAccident(quoteCarModel.getQuoteCar().getNumberAccident());
        this.currentQuoteCar.setBonusMalus(quoteCarModel.getQuoteCar().getBonusMalus());

        this.quoteService.insertQuoteCar(this.currentQuoteCar);
        this.quoteService.insertQuote(this.currentQuote);

        return modelAndView;
    }

    @RequestMapping(path = "/wizard/car/4", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardCar3(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_car_four");
        modelAndView.addObject("model", quoteCarModel);

        this.currentQuote.setStep(3);
        this.currentQuoteCar.setDriver(quoteCarModel.getQuoteCar().getDriver());
        this.currentQuoteCar.setSecondaryDriver(quoteCarModel.getQuoteCar().getSecondaryDriver());
        this.currentQuoteCar.setGarage(quoteCarModel.getQuoteCar().isGarage());
        this.currentQuoteCar.setAddress(quoteCarModel.getQuoteCar().getAddress());
        this.currentQuoteCar.setAllRisk(quoteCarModel.getQuoteCar().isAllRisk());
        this.currentQuoteCar.setTiers(!quoteCarModel.getQuoteCar().isAllRisk());

        this.quoteService.insertQuoteCar(this.currentQuoteCar);
        this.quoteService.insertQuote(this.currentQuote);

        return modelAndView;
    }

    @RequestMapping(path = "/result", method = RequestMethod.POST)
    public ModelAndView wizardCar4(@ModelAttribute QuoteCarModel quoteCarModel) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("index");

        this.currentQuote.setStep(4);
        this.currentQuote.setName(quoteCarModel.getQuote().getName());
        this.currentQuote.setResume(quoteCarModel.getQuote().getResume());
        this.currentQuote.setPrice(quoteCarModel.getQuote().getPrice());

        SimpleQuote simpleQuote = new SimpleQuote();
        simpleQuote.setPrice(Math.round(this.currentQuote.getPrice()));
        simpleQuote.setTypeQuote("CarQuote");
        simpleQuote.setGuarantee("Standard car guarantee");
        simpleQuote.setUserId(this.session.getIdUser());

        this.quoteService.insertQuote(this.currentQuote);
        this.simpleQuoteService.createSimpleQuote(simpleQuote);

        return modelAndView;
    }
}
