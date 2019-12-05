package service;

import hibernate.entity.Person;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    void savePerson(Person thePerson);

    Person getPerson(int theId);

    void deletePerson(int theId);

}
