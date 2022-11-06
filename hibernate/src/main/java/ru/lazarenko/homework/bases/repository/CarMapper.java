package ru.lazarenko.homework.bases.repository;

import org.springframework.stereotype.Component;
import ru.lazarenko.homework.bases.entity.Car;

@Component
public class CarMapper {

    public void updateFieldsCar(Car oldCar, Car newCar){
        oldCar.setModel(newCar.getModel());
        oldCar.setPrice(newCar.getPrice());
        oldCar.setOwner(newCar.getOwner());
        oldCar.setYear(newCar.getYear());
    }
}
