package hibernate;

import hibernate.entity.Gender;
import hibernate.entity.Person;
import hibernate.entity.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class HibernateApp {

    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Gender.class)
                .addAnnotatedClass(Skill.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();
    }

    public void close() {
        factory.close();
    }

    public static void main(String[] args) {
        HibernateApp demo = new HibernateApp();
        try {
            demo.readGenderId(1);


            //demo.deleteDonut(301);
            //demo.deleteDonutTen();
            //demo.createCityAndShop();

        } finally {
            demo.close();
        }
    }

    private void readGenderId(int genderId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Gender aGender = session.get(Gender.class, genderId);

        if (aGender == null) {
            System.out.println("No genders");
        } else {
            System.out.println(aGender);
        }
        session.getTransaction().commit();
    }




}
