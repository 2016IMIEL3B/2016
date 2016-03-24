package controller;

import com.back.User;
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

    @RequestMapping({"/profil"})
    public ModelAndView home(){

        return new ModelAndView("User/index","user", new User());
    }

    @RequestMapping(path = {"/profil/save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute User user){

        String url = "http://localhost:8091/api/profil/save";

        String result = new RestTemplate().postForObject(url,user,String.class);

        if(result.equals("OK"))
            return "redirect:/home";
        else
            return "redirect:/error";
    }
}
