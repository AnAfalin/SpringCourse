package ru.lazarenko.partThird.beans;

import org.springframework.stereotype.Component;

@Component
public class Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("Bird can to fly");
    }


}
