package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class UserController {

    @RequestMapping({"/profil"})
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("User/index");
        // Recuperer le user courant

        // Ajouter au model

        return model;
    }

    @RequestMapping({"/profil/save"})
    public ModelAndView save(){
        ModelAndView model = new ModelAndView("index");
        // Recuperer l'utilisateur modifié via le formulaire
        // Save l'utilisateur dans la BDD VertX
        // renvoyer sur la page home
        return model;
    }
}
