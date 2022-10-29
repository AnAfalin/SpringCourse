package ru.lazarenko.homework.condition.repository;

import org.springframework.stereotype.Component;
import ru.lazarenko.homework.condition.entity.Car;

@Component
public class CarMapper {

    public void updateFieldsCar(Car oldCar, Car newCar){
        oldCar.setModel(newCar.getModel());
        oldCar.setPrice(newCar.getPrice());
        oldCar.setOwner(newCar.getOwner());
        oldCar.setYear(newCar.getYear());
    }
}
