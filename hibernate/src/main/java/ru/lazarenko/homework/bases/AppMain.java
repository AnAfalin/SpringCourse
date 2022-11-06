package ru.lazarenko.homework.bases;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.lazarenko.homework.bases.config.ApplicationConfiguration;
import ru.lazarenko.homework.bases.entity.Car;
import ru.lazarenko.homework.bases.repository.CarRepository;

import java.time.LocalDate;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        CarRepository carRepository = context.getBean("carRepository", CarRepository.class);

        carRepository.saveCar(new Car(null, "BMW-2018", 1_500_000, "Mike", 2018, LocalDate.of(2022, 10, 25)));
        carRepository.saveCar(new Car(null, "Porsche-2010", 500_000, "Alex", 2010, LocalDate.of(2022, 5, 1)));
        carRepository.saveCar(new Car(null, "Volkswagen-2016", 900_000, "Tim", 2016, LocalDate.of(2022, 9, 15)));

        carRepository.getAllCars().forEach(System.out::println);

        carRepository.getCarsAfterYear(2015).forEach(System.out::println);

//        carRepository.updateProduct(new Car(null, "BMW-2011", 2_500_000, "Mike", 2011, LocalDate.of(2022, 10, 27)), 1);

        carRepository.getAllCars().forEach(System.out::println);
    }
}
