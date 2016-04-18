package controller;

import com.auth.UserSession;
import com.back.User;
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

        String url = "http://localhost:8091/api/profil/save";

        String result = new RestTemplate().postForObject(url,user,String.class);

        if(result.contains("OK")) {
            userSession.refreshUserSession(user);
            return "redirect:/home";
        }
        else
            return "redirect:/error";
    }
}
