package controller;


import hibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.GenderService;
import service.PersonService;
import service.SkillService;


import javax.servlet.http.HttpServletRequest;

import java.util.List;
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private SkillService skillService;


    @Autowired
    private GenderService genderService;

    @GetMapping("/list")
    public String listPersons(Model theModel) {
        // Get donuts from service
        List<Person> personList = personService.getPersons();

        // Add the list of donuts to the model
        theModel.addAttribute("persons", personList);
        System.out.println("we in this boi");
        System.out.println("we in this boi");

        System.out.println("we in this boi");

        // Return the name of the view
        return "list-companions";
    }
}
