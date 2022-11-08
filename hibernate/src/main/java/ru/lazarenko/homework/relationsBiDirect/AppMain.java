package ru.lazarenko.homework.relationsBiDirect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lazarenko.homework.relationsBiDirect.config.ApplicationConfiguration;
import ru.lazarenko.homework.relationsBiDirect.entity.*;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        /*первое добавление*/
//        Category cat1 = new Category(null, "Car");
//        Category cat2 = new Category(null, "Yacht");
//
//        Producer producer1 = new Producer(null, "OOO \"Cars\"");
//        Producer producer2 = new Producer(null, "OAO \"Yacht\"");
//
//        Product p1 = new Product(null, "BMW");
//        Product p2 = new Product(null, "Mercedes");
//        Product p3 = new Product(null, "Yacht Wave");
//
//        producer1.setProduct(p1);
//        producer1.setProduct(p2);
//        producer2.setProduct(p3);
//
//        List<Product> list = new ArrayList<>();
//        list.add(p1);
//        list.add(p2);
//        cat1.setProducts(list);
//        cat2.setProducts(List.of(p3));
//
//        session.persist(cat1);
//        session.persist(cat2);
//        session.persist(producer1);
//        session.persist(producer2);


        /*второе добавление*/
//        Account account1 = new Account(null, "miki", "12345");
//        Account account2 = new Account(null, "svetkins", "sss");
//
//        Buyer buyer1 = new Buyer(null, "Mike", "Moscow");
//        Buyer buyer2 = new Buyer(null, "Sveta", "Sochi");
//
//        buyer1.setAccount(account1);
//        account2.setBuyer(buyer2);
//
//        Order order1 = new Order(null, "Y1-1");
//        Order order2 = new Order(null, "C1-2");
//
//        buyer1.setOrderList(List.of(order2));
//        buyer2.setOrderList(List.of(order1));
//
//        session.persist(buyer1);
//        session.persist(buyer2);

        /*третье добавление для удаления*/
//        Buyer buyer = new Buyer(null, "Alexander", "SP");
//        Account account = new Account(null, "alex", "alex");
//        buyer.setAccount(account);
//        session.persist(buyer);

        /*для реализации удаления дочерних сущностей при удалении родительской, необходимо изменить CascadeType=REMOVE*/
//        Buyer buyer = session.get(Buyer.class, 9);
//        session.remove(buyer);

        /*для каскадного сохранения связанных сущностей необходимо указывать CascadeType=PERSIST*/
//        Buyer buyer = new Buyer(null, "Alexander", "SP");
//        Account account = new Account(null, "alex", "alex");
//        buyer.setAccount(account);
//        session.persist(account);


        /*тест загрузки с FetchType.LAZY - обычный select запрос*/
//        Buyer buyer = session.get(Buyer.class, 2);
//        System.out.println(buyer);

        /*тест загрузки с FetchType.EAGER - результат с Join с теми сущностями, у которых указано FetchType.EAGER*/
//        Buyer buyer = session.get(Buyer.class, 2);
//        System.out.println(buyer);

//        Account account = session.get(Account.class, 1);
//        System.out.println(account);
//        System.out.println(account.getBuyer());
//        session.getTransaction().commit();

    }
}
