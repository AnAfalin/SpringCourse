package ru.lazarenko.partThird.beans;

import org.springframework.stereotype.Component;

@Component
public class Plane implements Flyable{
    @Override
    public void fly() {
        System.out.println("Plane can to fly");
    }
}
