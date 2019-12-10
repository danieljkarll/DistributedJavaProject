package FinalProject.controller;


import FinalProject.hibernate.entity.Gender;
import FinalProject.hibernate.entity.Person;
import FinalProject.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import FinalProject.service.GenderService;
import FinalProject.service.PersonService;
import FinalProject.service.SkillService;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @GetMapping("/listGenders")
    public String listGenders(Model theModel) {
        // Get donuts from FinalProject.service
        List<Gender> genderList = genderService.listGenders();

        // Add the list of donuts to the model
        theModel.addAttribute("genders", genderList);
        // Return the name of the view
        return "list-genders";
    }
    @GetMapping("/addPage")
    public String addPerson(Model theModel) {
        Person thePerson = new Person();
        System.out.println("here");
        theModel.addAttribute("person", thePerson);

        theModel.addAttribute("personService", personService.getPersons());
        // Add the list of donuts to the model
        // Return the name of the view
        return "createCompanion";
    }

    @GetMapping("/showAddPersonForm")
    public String showAddDonutForm(Model theModel) {
        Person plainPerson = new Person();

        theModel.addAttribute("aPerson", plainPerson);
        //theModel.addAttribute("skills", personService.getPerson());
        return "createCompanion";
    }
    @GetMapping("/showAddGenderForm")
    public String showAddGenderForm(Model theModel) {
        //Person plainPerson = new Person();
        Gender plainGender = new Gender();
        theModel.addAttribute("aGender", plainGender);
        //theModel.addAttribute("aPerson", plainPerson);
        //theModel.addAttribute("skills", personService.getPerson());
        return "createGender";
    }

    @PostMapping("/save")
    public String saveDonut(
                           @ModelAttribute(name = "aPerson") Person thePerson,
                            Model theModel) {
  /*      if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);

            theModel.addAttribute("persons", personService.getPersons());

            return "createCompanion";
        }
*/
        //personService.savePerson(thePerson);
        personService.savePerson(thePerson);
       // return "redirect:/donut/list";
        return "list-companions";

    }
    @PostMapping("/saveGender")
    public String saveGender(
            @ModelAttribute(name = "aGender") Gender theGender,
            Model theModel) {
     /*   if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);

            theModel.addAttribute("persons", personService.getPersons());

            return "createCompanion";
        }
    */
        //personService.savePerson(thePerson);
        genderService.saveGender(theGender);
        // return "redirect:/donut/list";
        return "list-genders";

    }


}
