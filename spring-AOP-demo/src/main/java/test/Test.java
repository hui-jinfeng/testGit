package test;

import anoXML.Person;
import aopanno.User;
import config.ConfigAOP;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testAnno(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("classpath:bean1.xml");

        User user = (User) context.getBean("user");
        user.add();
    }

    @org.junit.Test
    public void testXML(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("classpath:bean2.xml");
        Person person = (Person) context.getBean("person");
        person.eat();
    }

    @org.junit.Test//完全注解开发
    public void test(){
        ApplicationContext context=
                new AnnotationConfigApplicationContext(ConfigAOP.class);
        User user = (User) context.getBean("user");
        user.add();
    }
}
