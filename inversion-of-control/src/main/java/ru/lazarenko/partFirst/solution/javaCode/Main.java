package ru.lazarenko.partFirst.solution.javaCode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partFirst.beans.Person;
import ru.lazarenko.partFirst.config.JavaCodeConfig;

public class Main {
    public static void main(String[] args) {

        //получение контекста
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaCodeConfig.class);

        Person person1 = (Person) context.getBean("person");
        Person person2 = context.getBean(Person.class);

        System.out.println(person1);
        System.out.println(person2);
    }
}
