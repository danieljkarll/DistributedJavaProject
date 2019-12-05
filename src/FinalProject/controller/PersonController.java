package FinalProject.controller;


import FinalProject.hibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import FinalProject.service.GenderService;
import FinalProject.service.PersonService;
import FinalProject.service.SkillService;


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
        // Get donuts from FinalProject.service
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
