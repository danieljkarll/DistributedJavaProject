package dao;

import hibernate.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenderDAOImpl implements GenderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveGender(Gender theGender) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save/update the donut
        session.saveOrUpdate(theGender);
    }


    @Override
    public Gender getGender(int genderId) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Gender aGender = session.get(Gender.class, genderId);

        if (aGender == null) {
            return null;
        } else {
           return aGender;
        }
    }
    @Override
    public void deleteGender(int genderID) {
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        //Gender doomedGender = session.get(Gender.class, genderID);
        Query query = session.createQuery("delete from Gender where id = :doomedDonutId");
        query.setParameter("doomedDonutId", genderID);
        query.executeUpdate();

        //if (doomedGender == null){
         //   System.out.println("No gender for ID " + doomedGender);
        //} else {
         //   session.delete(doomedGender);
        //}

        session.getTransaction().commit();
    }

}
