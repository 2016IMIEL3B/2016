package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import model.Person;

/**
 * Created by Nico on 18/02/2016.
 */
@Controller
public class DemoController {
    @RequestMapping(path = "/demo/demotp1"
            ,method = {RequestMethod.GET,RequestMethod.POST})
    public String demoTp1(ModelMap model)
    {
        model.addAttribute("message","hello world");
        return "index";
    }

    @RequestMapping(path = "/demo/demotp2"
            ,method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView demoTp2()
    {
        ModelAndView model = new ModelAndView("index");
        model.addObject("message","hello world");
        return model;
    }

    @RequestMapping(path = "/demo/demotp3/{id}"
            ,method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView demoTp3(@PathVariable Integer id)
    {
        ModelAndView model = new ModelAndView("index");
        model.addObject("message","hello world -> " + id);
        return model;
    }

    @RequestMapping(path = "/demo/demotp4"
            ,method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView demoTp4(@RequestParam(name = "name") String nom,
                                @RequestParam String prenom)
    {
        ModelAndView model = new ModelAndView("index");
        model.addObject("message","hello world -> " + nom);
        return model;
    }
    
    @RequestMapping(path = "/controller/DemoController"
            ,method = {RequestMethod.POST})
    public ModelAndView demoTp5(@ModelAttribute Person person)
    {
        ModelAndView model = new ModelAndView("index", "Person", new Person());
        model.addObject("message","hello world -> " + person.getFirstName() + " " + person.getLastName());
        return model;
    }
}
