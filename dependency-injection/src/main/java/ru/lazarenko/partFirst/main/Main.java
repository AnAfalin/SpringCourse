package ru.lazarenko.partFirst.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partFirst.beans.Person;
import ru.lazarenko.partFirst.config.AnnotationConfig;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        Person person = context.getBean("person", Person.class);

        System.out.println(person);
        System.out.println(person.getHouse());
    }
}
