package FinalProject.dao;

import FinalProject.hibernate.entity.Person;

import java.util.List;

public interface PersonDAO {
    void savePerson(Person thePerson);
    Person readPerson(int personID);
    void deletePerson(int theId);
    List<Person> getPersons();
}



