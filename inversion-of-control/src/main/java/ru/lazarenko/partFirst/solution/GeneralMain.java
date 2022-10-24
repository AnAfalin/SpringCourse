package ru.lazarenko.partFirst.solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lazarenko.partFirst.beans.Person;
import ru.lazarenko.partFirst.config.ApplicationConfig;
import ru.lazarenko.partFirst.config.JavaCodeConfig;

public class GeneralMain {
    public static void main(String[] args) {
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext contextAppC = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationContext contextJavaCode = new AnnotationConfigApplicationContext(JavaCodeConfig.class);

        Person personXML = contextXML.getBean("person", Person.class);
        Person personAppC = contextAppC.getBean("person", Person.class);
        Person personJavaCode = contextJavaCode.getBean("person", Person.class);

        //Ссылки на объекты разные, т.к. три разных контекста
        System.out.println(personXML);
        System.out.println(personAppC);
        System.out.println(personJavaCode);

        System.out.println(personXML == personAppC);        //false
        System.out.println(personAppC == personJavaCode);   //false
        System.out.println(personXML == personJavaCode);    //false

    }
}
