package ru.lazarenko.partThird.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partThird.entity.Car;
import ru.lazarenko.partThird.beans.CarRepository;
import ru.lazarenko.partThird.config.Configuration;


public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 400_000, "Mike", "2002");
        Car car2 = new Car("VW", 150_000, "Slava", "1998");

        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        CarRepository carRepository = context.getBean("carRepository", CarRepository.class);

//        carRepository.saveCar(car1);
        System.out.println(carRepository.getAllCars());

    }
}
