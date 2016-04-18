package controller;

import fr.*;
import controller.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by user on 24/03/2016.
 */
@Controller
@RequestMapping("/habWizard.form")
@SessionAttributes("habWizard")
public class HabWizardController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private HabitationService habitationService;

    @Autowired
    private AddressService addressService;

    private String[] pageViews = new String[] {"habitation-step1","habitation-step2","habitation-step3","habitation-step4"};

    //Première étape
    @RequestMapping
    public ModelAndView processWizard() {
        return new ModelAndView("wizard/habitation/habitation-step1","habWizard", new HabitationModel());
    }

    // Renvoie de l'étape suivant le numéro d'étape
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
    @ModelAttribute("habWizard") HabitationModel habWizard) {
        boolean $status = false;

        switch (currentPage-1){
            case 1:
                $status = habWizard.checkStep1();
                break;
            case 2:
                $status = habWizard.checkStep2();
                break;
            case 3:
                $status = habWizard.checkStep3();
                break;
        }

        if($status){
            // pageViews est un tableau qui renvoie le nom de la vue suivant le numéro d'étape
            return new ModelAndView("wizard/habitation/"+pageViews[currentPage-1]);
        } else {
            // on renvoie à la page précédente
            return new ModelAndView("wizard/habitation/"+pageViews[currentPage-2]);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getFromSynthesis(@RequestParam("_quoteId") Integer quoteId) {
        Quote quote = quoteService.findOne(quoteId);
        HabitationModel habitationModel = new HabitationModel(quote);
        return new ModelAndView("wizard/habitation/habitation-step"+quote.getStep(),"habWizard", habitationModel);
    }

    /**
     * Dernière page
    */
    @RequestMapping(params = "_finish")
    public ModelAndView processFinish(@ModelAttribute("habWizard") HabitationModel habWizard, SessionStatus status) {
        addressService.save(habWizard.getQuote().getHabitation().getAddress());
        habitationService.save(habWizard.getQuote().getHabitation());
        quoteService.save(habWizard.getQuote());

        // suppression de l'objet en session
        status.setComplete();
        return new ModelAndView("successView");
    }

    @RequestMapping(params = "_cancel")
    public String processCancel(SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return "wizard/canceledView";
    }

}
