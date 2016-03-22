package controller;

import dao.QuotationRepository;
import entity.back.Model;

import entity.front.Quotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.QuotationService;

import java.util.ArrayList;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/home"})
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("index");
        // Recuperer le id du User courant

        // FindById Quotation and Add to Model
        return model;
    }

}
