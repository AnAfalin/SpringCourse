package ru.lazarenko.lesson;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.lesson.config.AppConfiguration;
import ru.lazarenko.lesson.entity.Product;
import ru.lazarenko.lesson.repository.ProductRepository;

import java.time.LocalDate;

public class ApplicationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        ProductRepository repository = context.getBean(ProductRepository.class);

        //repository.saveProduct(new Product(null, "Milk", 100, LocalDate.of(2022, 7, 30)));

        //System.out.println(repository.getAllProducts());

        //repository.getProductById(1L).ifPresent(System.out::println);

        repository.updateProduct(new Product(null, "Milk", 150, LocalDate.of(2022, 8, 30)), 1L);
        System.out.println(repository.getAllProducts());
        context.close();
    }
}
