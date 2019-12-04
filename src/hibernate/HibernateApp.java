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

            //demo.createGender("stuff");
            //demo.updateGender(3,"idk3");
            //demo.readGenderId(2);
            //demo.deleteGender(3);
            //demo.readGenderId(3);


           // demo.createPerson("Paul","paul.jpg","he is paul-like");
         // demo.updatePerson(1,"Joe","joe.jpg","joe is joey");
            demo.readPerson(0);
            //demo.deletePerson(2);
            //demo.readPerson(2);

            //demo.createSkill("testSkill",1);
            //demo.updateSkill(2,"test2",2);
            //demo.deleteSkill(1);
            demo.readSkill(2);
        } finally {
            demo.close();
        }
    }
    private void createGender(String genderName){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Gender gender = new Gender(genderName);
        session.save(gender);
        session.getTransaction().commit();
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

    private void updateGender(int id, String updatedGender) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        //TO DO if deleting gender delete gender from
        // all of the person entities and replace it
        Gender gender = session.get(Gender.class, id);
        gender.setGender(updatedGender);

        session.getTransaction().commit();
    }
    private void deleteGender(int genderID) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Gender doomedGender = session.get(Gender.class, genderID);

        if (doomedGender == null){
            System.out.println("No gender for ID " + doomedGender);
        } else {
            session.delete(doomedGender);
        }

        session.getTransaction().commit();
    }

/*Person*/
private void createPerson(String name, String selfiefile, String bio){
    Session session = factory.getCurrentSession();

    session.beginTransaction();
    //TO DO get get a gender and if that gender is not \
    //Already created create it and then add it to here    // Do stuff
    Person aPerson = new Person(name,selfiefile,bio);
    session.save(aPerson);
    session.getTransaction().commit();
}


    private void readPerson(int personID) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Person aPerson = session.get(Person.class, personID);

        if (aPerson == null) {
            System.out.println("No people");
        } else {
            System.out.println(aPerson);
        }
        session.getTransaction().commit();
    }

    private void updatePerson(int personID, String name, String selfiefile, String bio) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Person aPerson = session.get(Person.class, personID);
        aPerson.setBio(bio);
        aPerson.setName(name);
        aPerson.setSelfiefile(selfiefile);

        //TO DO get get a gender and if that gender is not \
        //Already created create it and then add it to here

        session.getTransaction().commit();
    }
    private void deletePerson(int personID) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Person doomedPerson = session.get(Person.class, personID);

        if (doomedPerson == null){
            System.out.println("No person for ID " + doomedPerson);
        } else {
            session.delete(doomedPerson);
        }

        session.getTransaction().commit();
    }

/*Skills*/
private void createSkill(String name, int level) {
    Session session = factory.getCurrentSession();

    session.beginTransaction();

    // Do stuff
    Skill aSKill = new Skill( name, level);
    session.save(aSKill);

    session.save(aSKill);

    session.getTransaction().commit();
}


    private void readSkill(int skillID) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/
        Skill aSkill = session.get(Skill.class, skillID);

        if (aSkill == null) {
            System.out.println("No skills");
        } else {
            System.out.println(aSkill);
        }
        System.out.println(aSkill);

        session.getTransaction().commit();
    }

    private void updateSkill(int skillID,String name, int level) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Skill aSkill = session.get(Skill.class, skillID);
        aSkill.setLevel(level);
        aSkill.setName(name);

        session.getTransaction().commit();
    }
    private void deleteSkill(int skillID) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        //TO DO delete skill from person if it is there
        Skill doomedSKill = session.get(Skill.class, skillID);

        if (doomedSKill == null){
            System.out.println("No skill for ID " + doomedSKill);
        } else {
            session.delete(doomedSKill);
        }

        session.getTransaction().commit();
    }


}
