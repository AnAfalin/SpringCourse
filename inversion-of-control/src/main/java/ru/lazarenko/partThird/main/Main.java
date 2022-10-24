package ru.lazarenko.partThird.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.partSecond.config.ApplicationConfig;
import ru.lazarenko.partSecond.config.JavaCodeConfig;
import ru.lazarenko.partThird.beans.Bird;
import ru.lazarenko.partThird.beans.Flyable;
import ru.lazarenko.partThird.beans.Helicopter;
import ru.lazarenko.partThird.beans.Plane;

public class Main {
    public static void main(String[] args) {
        //1.
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        //2.
        //ApplicationContext context = new AnnotationConfigApplicationContext(JavaCodeConfig.class);


        Bird bird = context.getBean("bird", Bird.class);
        Helicopter helicopter = context.getBean("helicopter", Helicopter.class);
        Plane plane = context.getBean("plane", Plane.class);

        System.out.println(bird);
        System.out.println(helicopter);
        System.out.println(plane);


        //3 - 4.
        //так будет работать, если у интерфейса будет только один класс-наследник
        Flyable bean = context.getBean(Flyable.class);
        System.out.println(bean);


    }
}
