package ru.lazarenko.partSecond.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ru.lazarenko.partSecond.beans.Employee;


public class JavaCodeConfig {

    @Bean("employee")
    @Scope("prototype")
    public Employee employee(){
        Employee employee = new Employee();
        employee.setName("Mike");
        employee.setAge(45);
        return employee;
    }
}
