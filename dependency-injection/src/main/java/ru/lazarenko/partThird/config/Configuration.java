package ru.lazarenko.partThird.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ComponentScan("ru.lazarenko.partThird")
@PropertySource("classpath:application.properties")
public class Configuration {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;


    @Bean
    public Connection connection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Bean
//    public CarRepository carRepository(){
//        return new CarRepository(connection());
//    }

}

