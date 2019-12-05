package FinalProject.service;
import FinalProject.dao.PersonDAO;
import FinalProject.hibernate.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public List<Person> getPersons() {
        return personDAO.getPersons();
    }

    @Override
    @Transactional
    public void savePerson(Person thePerson) {
        personDAO.savePerson(thePerson);
    }

    @Override
    @Transactional
    public Person getPerson(int theId) {
        return personDAO.readPerson(theId);
    }

    @Override
    @Transactional
    public void deletePerson(int theId) {
        personDAO.deletePerson(theId);
    }

}
