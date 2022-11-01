package ru.lazarenko.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.lesson.config.AppConfiguration;
import ru.lazarenko.lesson.entity.Product;
import ru.lazarenko.lesson.entity.relations.manyToMany.Subject;
import ru.lazarenko.lesson.entity.relations.manyToMany.Teacher;
import ru.lazarenko.lesson.entity.relations.oneToMany.Department;
import ru.lazarenko.lesson.entity.relations.oneToMany.Employee;
import ru.lazarenko.lesson.entity.relations.oneToOne.Passport;
import ru.lazarenko.lesson.entity.relations.oneToOne.Person;
import ru.lazarenko.lesson.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

public class ApplicationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        /*Lesson 1*/
//        ProductRepository repository = context.getBean(ProductRepository.class);
//        Product product = new Product(null, "Milk", 150, LocalDate.of(2022, 5, 31));
//        repository.saveProduct(product);
//        System.out.println(repository.getProductById(1L));

        /*Lesson 2*/
//        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
//
//        Session session = sessionFactory.getCurrentSession();
//        session.getTransaction().begin();

        /* one-to-one */
        Person person = new Person(null, "Kate");
//        Passport passport = new Passport(null, 1234, 56);
//        person.setPassport(passport);
//        session.persist(person);

        /* one-to-many */
//        Department department = new Department(null, "IT");
//        List<Employee> employees = List.of(
//                new Employee(null, "Mike", "Java"),
//                new Employee(null, "Bob", "C++"));
//
//        department.setEmployees(employees);
//        session.persist(department);

        /* many-to-many */
//        Teacher t1 = new Teacher(null, "Mike", 5);
//        Teacher t2 = new Teacher(null, "Kate", 10);
//
//        Subject s1 = new Subject(null, "Math");
//        Subject s2 = new Subject(null, "History");
//        Subject s3 = new Subject(null, "Informatics");
//
//        t1.setSubjects(List.of(s1, s2));
//        t2.setSubjects(List.of(s2, s3));
//
//        session.persist(t1);
//        session.persist(t2);
    }
}
