package ru.lazarenko.partSecond.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private Job job;
    private Pet pet;

    public Employee(/*@Qualifier("hardJob")*/Job job, Pet pet) {
        this.job = job;
        this.pet = pet;
    }

    @Autowired(required=false)
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "job=" + job +
                ", pet=" + pet +
                '}';
    }
}
