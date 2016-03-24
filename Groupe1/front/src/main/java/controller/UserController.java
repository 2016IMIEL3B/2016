package controller;

import fr.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gtostain on 24/03/2016.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView model = new ModelAndView("profile");
/*        Usera user = new Usera();
        user.setFirstname("Guillaume");
        user.setLastname("Tostain");
        Account account = new Account();
        account.setLogin("gtostain");
        account.setPassword("admin456");
        Address address = new Address();
        address.setNumber(7);
        address.setStreet("rue d'Athènes");
        address.setPostode("14120");
        address.setCity("Mondeville");
        user.setAccount(account);
        user.setAddress(address);
        model.addObject("user", user);*/
        return model;
    }
}
