package FinalProject.service;

import FinalProject.hibernate.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();

    void savePerson(Person thePerson);

    Person getPerson(int theId);

    void deletePerson(int theId);

}
