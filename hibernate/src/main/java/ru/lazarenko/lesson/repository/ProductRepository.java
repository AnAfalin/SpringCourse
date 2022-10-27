package ru.lazarenko.lesson.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lazarenko.lesson.entity.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class ProductRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getAllProducts(){
        Session session = null; //объявление сессии

        try {
            session = sessionFactory.getCurrentSession(); //получение сессии
            session.beginTransaction(); //начало транзакции

            //SQL

            List<Product> products = session.createQuery("from Product", Product.class)
                    .getResultList();

            //Exception - если ловится исключение, то переходим в catch

            session.getTransaction().commit();  //если всё успешно, то подтверждаем транзакцию
            return products;
        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();        //отмена изменений при исключении
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public void saveProduct(Product product){
        Session session = null; //объявление сессии

        try {
            session = sessionFactory.getCurrentSession(); //получение сессии
            session.beginTransaction(); //начало транзакции

            //SQL

            session.persist(product);

            //Exception - если ловится исключение, то переходим в catch

            session.getTransaction().commit();  //если всё успешно, то подтверждаем транзакцию
        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();        //отмена изменений при исключении
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Optional<Product> getProductById(Long id){
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession(); //получение сессии
            session.beginTransaction(); //начало транзакции

            //SQL

            Product product = session.get(Product.class, id);


            //Exception - если ловится исключение, то переходим в catch

            session.getTransaction().commit();  //если всё успешно, то подтверждаем транзакцию
            return Optional.ofNullable(product);
        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();        //отмена изменений при исключении
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public void updateProduct(Product product, Long id) {
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession(); //получение сессии
            session.beginTransaction(); //начало транзакции

            //SQL

            Product updatableProduct = session.get(Product.class, id);
            if (updatableProduct == null) {
                throw new NoSuchElementException("No product with id = " + id);
            }
            updatableProduct.setName(product.getName());
            updatableProduct.setPrice(product.getPrice());
            updatableProduct.setExpirationDate(product.getExpirationDate());
            session.persist(updatableProduct);

            session.getTransaction().commit();  //если всё успешно, то подтверждаем транзакцию

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();        //отмена изменений при исключении
            }
            throw new RuntimeException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
