package controller;

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

    private String[] pageViews = new String[] {"habitation-step1","habitation-step2"};

    //Première étape
    @RequestMapping
    public ModelAndView processWizard() {
        return new ModelAndView("wizard/habitation/habitation-step1","habWizard", new HabitationModel());
    }

    // Renvois de l'étape suivant le numéro d'étape
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
    @ModelAttribute("habWizard") HabitationModel habWizard) {

        // pageViews est un tableau qui renvois le nom de la vue suivant le numéro d'étape
        return new ModelAndView("wizard/"+pageViews[currentPage-1]);
    }

    /**
     * Dernière page
    */
    @RequestMapping(params = "_finish")
    public ModelAndView processFinish(@ModelAttribute("modelWizard") HabitationModel habWizard, SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return new ModelAndView("wizard/successView");
    }

    @RequestMapping(params = "_cancel")
    public String processCancel(SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return "wizard/canceledView";
    }

}
