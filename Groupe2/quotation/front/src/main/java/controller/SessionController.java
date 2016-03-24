package controller;

import com.auth.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class SessionController {

    @Autowired
    private UserSession userSession;

    @RequestMapping({"/sessiondump"})
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("Session/index", "token", userSession.getToken());
        // Recuperer le user courant

        // Ajouter au model

        return model;
    }
}
