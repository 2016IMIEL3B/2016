package com.group4.front.controller;

import com.group4.front.common.AppData;
import com.group4.front.common.User;
import com.group4.front.controller.model.QuoteCarModel;
import com.group4.front.entities.Quote;
import com.group4.front.entities.QuoteCar;
import com.group4.front.services.QuoteService;
import com.group4.front.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WizardHomeController {

    @Autowired
    AppData session;
    @Autowired
    private UserService userService;
    @Autowired
    private QuoteService quoteService;

    private QuoteCar currentQuoteCar;

    @RequestMapping(path = "/car/wizard",  method = RequestMethod.GET)
    public ModelAndView wizard(){
        ModelAndView model = new ModelAndView("wizard_car");
        User user = this.userService.findUserById(this.session.getIdUser());
        String userName = user.getSurname() + " " + user.getName();

        QuoteCarModel quoteCarModel = new QuoteCarModel();
        quoteCarModel.setUserName(userName);
        quoteCarModel.setQuoteCar(new QuoteCar());

        model.addObject("model", quoteCarModel);
        return model;
    }

    @RequestMapping(path = "/car/step/1", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardCar(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_car_two");
        modelAndView.addObject("model", quoteCarModel);

        this.currentQuoteCar = quoteCarModel.getQuoteCar();

        return modelAndView;
    }

    @RequestMapping(path = "/car/step/2", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardCar2(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_car_three");
        modelAndView.addObject("model", quoteCarModel);

        this.currentQuoteCar.setDateLicence(quoteCarModel.getQuoteCar().getDateLicence());
        this.currentQuoteCar.setNumberAccident(quoteCarModel.getQuoteCar().getNumberAccident());
        this.currentQuoteCar.setBonusMalus(quoteCarModel.getQuoteCar().getBonusMalus());

        return modelAndView;
    }

    @RequestMapping(path = "/car/step/3", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView wizardCar3(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("wizard_car_four");
        modelAndView.addObject("model", quoteCarModel);

        this.currentQuoteCar.setDriver(quoteCarModel.getQuoteCar().getDriver());
        this.currentQuoteCar.setSecondaryDriver(quoteCarModel.getQuoteCar().getSecondaryDriver());
        this.currentQuoteCar.setGarage(quoteCarModel.getQuoteCar().isGarage());
        this.currentQuoteCar.setAddress(quoteCarModel.getQuoteCar().getAddress());

        return modelAndView;
    }

    @RequestMapping(path = "/result", method = RequestMethod.POST)
    public ModelAndView wizardCarEnd(@ModelAttribute QuoteCarModel quoteCarModel) {
        ModelAndView modelAndView = new ModelAndView("index");

        this.currentQuoteCar.setAllRisk(quoteCarModel.getQuoteCar().isAllRisk());
        this.currentQuoteCar.setTiers(!quoteCarModel.getQuoteCar().isAllRisk());

        Quote quote = new Quote();
        quote.setName("Devis pouf");
        quote.setPrice(10);
        quote.setResume("Bla bla");
        quote.setLogin("JEan mi");
        quote.setStep(2);

        this.quoteService.insertQuote(quote);

        this.currentQuoteCar.setIdQuote(quote.getId());

        this.quoteService.insertQuoteCar(this.currentQuoteCar);

        return modelAndView;
    }
}
