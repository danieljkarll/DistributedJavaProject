package dao;

import hibernate.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void savePerson(Person thePerson) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save/update the donut
        session.saveOrUpdate(thePerson);
    }

    @Override
    public Person readPerson(int personID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, personID);
    }
    @Override
    public void deletePerson(int theId) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Delete object using primary key
        Query query = session.createQuery("delete from Person where id = :doomedPersonId");
        // Set parameter value
        query.setParameter("doomedPersonId", theId);

        // Perform the delete
        query.executeUpdate();
    }

    @Override
    public List<Person> getPersons() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get list of donuts from query
        List<Person> personList = session.createQuery("from Person", Person.class).getResultList();

        // Return results
        return personList;
    }

}
