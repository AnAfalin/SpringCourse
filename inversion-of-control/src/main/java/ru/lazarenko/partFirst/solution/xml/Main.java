package ru.lazarenko.partFirst.solution.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lazarenko.partFirst.beans.Person;

public class Main {
    public static void main(String[] args) {
        //создание контекста
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //получение бина класса Person
        Person person1 = (Person) context.getBean("person");    //по id
        Person person2 = context.getBean(Person.class);           //по классу

        System.out.println(person1);
        System.out.println(person2);
    }
}
