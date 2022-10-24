package ru.lazarenko.partSecond.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partSecond.config.ApplicationConfig;
import ru.lazarenko.partSecond.config.JavaCodeConfig;
import ru.lazarenko.partSecond.beans.Employee;

public class Main {
    public static void main(String[] args) {
        ApplicationContext contextJavaCode = new AnnotationConfigApplicationContext(JavaCodeConfig.class);
        Employee employee1 = contextJavaCode.getBean("employee", Employee.class);
        System.out.println(employee1);

        ApplicationContext contextAplCont = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Employee employee2 = contextAplCont.getBean("worker", Employee.class);
        System.out.println(employee2);
    }
}
