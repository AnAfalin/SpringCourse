package ru.lazarenko.partFirst.beans;

import org.springframework.stereotype.Component;

@Component
public class Pet {

    public Pet() {
        System.out.println("Initialization Pet");
    }

    @Override
    public String toString() {
        return "Pet";
    }
}
