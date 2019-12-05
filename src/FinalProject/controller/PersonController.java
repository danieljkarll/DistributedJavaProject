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
import org.springframework.web.bind.annotation.RequestMethod;


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
        // Return the name of the view
        return "list-companions";
    }

    @GetMapping("/addPage")
    public String addPerson(Model theModel) {
        Person thePerson = new Person();

        theModel.addAttribute("person", thePerson);

        theModel.addAttribute("personService", personService.getPersons());
        // Add the list of donuts to the model
        // Return the name of the view
        return "createCompanion";
    }

}
