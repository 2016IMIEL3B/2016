package controller;

import com.auth.UserSession;
import com.back.User;
import com.utils.CPrint;
import com.utils.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

/**
 * Created by kevin on 22/03/16.
 */
@Controller
public class UserController {

    @Autowired
    private UserSession userSession;

    @RequestMapping({"/profil"})
    public ModelAndView home(){

        return new ModelAndView("User/index","user", userSession.getUser());
    }

    @RequestMapping(path = {"/profil/save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute User user){
        String result = new RestHelper().defaultRequest("/api/profil/save", user.getAllParams(), HttpMethod.POST, String.class).getBody();

        if(result.contains("OK")) {
            userSession.refreshUserSession(user);
            return "redirect:/profil";
        }
        else
            return "redirect:/error";
    }
}
