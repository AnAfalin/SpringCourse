package ru.lazarenko.partFirst.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private Pet pet;
    private House house;

    @Autowired
    public Person(Pet pet, House house) {
        this.pet = pet;
        this.house = house;
        System.out.println("Initialization Person");
    }

    public Pet getPet() {
        return pet;
    }

    public House getHouse() {
        return house;
    }
}
