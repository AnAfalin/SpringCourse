package ru.lazarenko.jpa.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("ru.lazarenko")
public class AppConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return Persistence
                .createEntityManagerFactory("persistenceLesson");
    }
}
