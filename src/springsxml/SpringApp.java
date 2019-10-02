package springsxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springsxml.Services.LogService;
import springsxml.beans.Person;

public class SpringApp {
    public static void main(String[] args){
        System.out.println("UpdateSqlLog Class: ");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Person person1 = context.getBean("Person", Person.class);
        person1.getName();
        person1.getBio();
        person1.getGenderID();
        person1.getSelfieFileName();
        //ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext2.xml");

       // System.out.println(person1.getName());
        // LogService updateThis = context.getBean()
        context.close();
    }
}
