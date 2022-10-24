package ru.lazarenko.partFirst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ru.lazarenko.partFirst.beans.Person;

public class JavaCodeConfig {

    @Bean()
    @Scope("prototype")
    public Person person(){
        return new Person();
    }
}
