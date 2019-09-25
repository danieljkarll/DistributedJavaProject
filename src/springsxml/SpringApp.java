package springsxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springsxml.beans.Person;

public class SpringApp {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         Person person1 = context.getBean("Person", Person.class);

        person1

        context.close();
    }
}
