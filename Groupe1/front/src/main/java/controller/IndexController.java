package controller;

import controller.model.CarModel;
import controller.model.CarStep1;
import controller.model.HabStep1;
import controller.model.HabitationModel;
import excep.MyException;
import fr.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Nico on 09/02/2016.
 */
@Controller
public class IndexController {

    @Autowired
    private HabitationModel habitationModel;



    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping({"/","/index"})
    public String welcome(Map<String, Object> model) {
        String m = message;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() != null && auth.getPrincipal() instanceof User) {
            User user = (User)auth.getPrincipal();
            m = String.format("Hello %s", user.getUsername());
        }
        model.put("message", m);
        return "index";
    }



    @RequestMapping("/private/client")
    public String dash(Map<String, Object> model) {
        model.put("message", "Vous êtes sur une page privée sans rôle");
        return "client";
    }


    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/private/admin", method = RequestMethod.GET)
    public ModelAndView admin(){
        ModelAndView model = new ModelAndView("admin");
        model.addObject("message", "Vous êtes sur une page privée avec le rôle ROLE_ADMIN");
        return model;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(){
        ModelAndView model = new ModelAndView("profile");
        return model;
    }



    @RequestMapping(value = "/habitation/1", method = RequestMethod.GET)
    public ModelAndView habitation1(){
        ModelAndView model = new ModelAndView("habitation-step1");
        habitationModel.setHabStep1(new HabStep1()) ;
        model.addObject("habStep1", habitationModel.getHabStep1());
        return model;
    }

    @RequestMapping(value = "/habitation/2", method = RequestMethod.POST)
    public ModelAndView habitation1form(@ModelAttribute HabStep1 habStep1){
        System.out.println(habStep1.getName());
        System.out.println(habStep1.getSurface());
        System.out.println(habStep1.getSurface());
        ModelAndView model = new ModelAndView("habitation-step2");
        return model;
    }

    @RequestMapping(value = "/synthesis", method = RequestMethod.GET)
    public ModelAndView synthesis(){
        ModelAndView model = new ModelAndView("synthesis");
        return model;
    }

    @RequestMapping("/fail")
    public String fail() throws MyException {
        throw new MyException("Oupss!!");
    }

    @RequestMapping("/fail2")
    public String fail2() {
        throw new IllegalStateException();
    }



    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleMyRuntimeException(MyException exception) {
        return "Error -> " + exception.getMessage();
    }

}
