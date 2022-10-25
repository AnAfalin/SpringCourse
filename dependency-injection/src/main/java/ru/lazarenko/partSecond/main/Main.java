package ru.lazarenko.partSecond.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partSecond.beans.Employee;
import ru.lazarenko.partSecond.config.AnnotationConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        Employee employee = context.getBean("employee", Employee.class);

        //решение проблемы с внедрением зависимости Job:
        //1.способ внедрения с помощью аннотации @Qualifier в конструкторе Employee
        //2.способ внедрения с помощью аннотации @Primary над классом, бин которого будет являться текущим

        System.out.println(employee);
    }
}
