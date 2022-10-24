package ru.lazarenko.partFirst.solution.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partFirst.beans.Person;
import ru.lazarenko.partFirst.config.ApplicationConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Person person1 = (Person) context.getBean("person");
        Person person2 = context.getBean(Person.class);

        System.out.println(person1);
        System.out.println(person2);
    }
}
