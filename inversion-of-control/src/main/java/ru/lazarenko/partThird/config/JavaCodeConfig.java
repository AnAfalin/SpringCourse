package ru.lazarenko.partThird.config;

import org.springframework.context.annotation.Bean;
import ru.lazarenko.partThird.beans.Bird;
import ru.lazarenko.partThird.beans.Helicopter;
import ru.lazarenko.partThird.beans.Plane;


public class JavaCodeConfig {
    @Bean
    public Bird bird(){
        return new Bird();
    }

    @Bean
    public Helicopter helicopter(){
        return new Helicopter();
    }

    @Bean
    public Plane plane(){
        return new Plane();
    }


}
