package ru.lazarenko.partSecond.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("worker")
@Scope("prototype")
public class Employee {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @PostConstruct
//    public void init(){
//        this.name = "Filip";
//        this.age = 20;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
