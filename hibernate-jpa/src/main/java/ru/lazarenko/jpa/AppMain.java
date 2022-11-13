package ru.lazarenko.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.jpa.config.AppConfig;
import ru.lazarenko.jpa.entity.Department;
import ru.lazarenko.jpa.entity.Passport;
import ru.lazarenko.jpa.entity.Person;
import ru.lazarenko.jpa.entity.Project;

import java.util.ArrayList;
import java.util.List;


public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);

        EntityManager manager = entityManagerFactory.createEntityManager();

        manager.getTransaction().begin();

//        Person person = new Person(null, "Mike");
//        Passport passport = new Passport(null, "1500", "11111");
//        passport.setPerson(person);

//        Person person = new Person(null, "Peter");
//        Passport passport = new Passport(null, "2200", "789475");
//        passport.setPerson(person);

//        Person person = new Person(null, "Ana");
//        Passport passport = new Passport(null, "4514", "597456");
//        passport.setPerson(person);

//        Person person = new Person(null, "Slava");
//        Passport passport = new Passport(null, "8745", "457455");
//        passport.setPerson(person);
//
//        manager.persist(person);

//        Department department1 = new Department(null, "Development dep.");
//        Department department2 = new Department(null, "Test dep.");
//
//        Project project1 = new Project(null, "frontend");
//        Project project2 = new Project(null, "backend");
//
//        manager.persist(department1);
//        manager.persist(department2);
//        manager.persist(project1);
//        manager.persist(project2);



//        List<Person> personListIT = new ArrayList<>();
//        personListIT.add(manager.find(Person.class, 1));
//        personListIT.add(manager.find(Person.class, 2));
//        personListIT.add(manager.find(Person.class, 3));
//
//        Person person4 = manager.find(Person.class, 4);
//
//        Department depDev = manager.find(Department.class, 1);
//        Department depTest = manager.find(Department.class, 2);
//
//        for (Person person : personListIT) {
//            person.setDepartment(depDev);
//        }
//
//        person4.setDepartment(depTest);
//
//        manager.persist(depDev);
//        manager.persist(depTest);



//        Person person4 = manager.find(Person.class, 4);
//        Department depDev = manager.find(Department.class, 2);
//        person4.setDepartment(depDev);
//        manager.persist(person4);

//        Project front = manager.find(Project.class, 1);
//        Project back = manager.find(Project.class, 2);
//
//        Person person1 = manager.find(Person.class, 1);
//        Person person2 = manager.find(Person.class, 2);
//        Person person3 = manager.find(Person.class, 3);
//        Person person4 = manager.find(Person.class, 4);
//
//        front.addPerson(person1);
//        front.addPerson(person2);
//        back.addPerson(person3);
//        back.addPerson(person4);
        /*обновление объекта с помощью Query*/
//        Query query = manager.createQuery("update Person set name = 'Vaycheslav' where id = 4");
//        int i = query.executeUpdate();

        /*другой способ обновления*/
//        Person person = manager.find(Person.class, 4);
//        Passport passport = new Passport(null, "1000", "555555");
//        person.setPassport(passport);

        /*еще один способ обновления - с установленным у связей CascadeType.MERGE*/
//        Person person = manager.find(Person.class, 4);
//        person.setName("Slava");

//        manager.getTransaction().commit();


        /* Перевод сущности перевести из состояния Transient в Persistence, затем в Removed, затем в Detached с помощью методов EntityManager.*/
//        //transient - объекты находятся в переходном состоянии, т.е не в контексте и без идентификатора
//        Person person = new Person(null, "Irina");
//
//        //persistence - объекты сохранены или обновлены в контексте
//        manager.persist(person);
//
//        //removed - объекты удалены из контекста и бд
//        manager.remove(person);
//
//        //закрытие сессии
//        manager.getTransaction().commit();
//
//        //detached - все объекты, которые не управляются контекстом, после закрытия сессии
//        manager.persist(person);
    }
}
