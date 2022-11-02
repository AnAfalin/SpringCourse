package ru.lazarenko.homework.condition.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.lazarenko.homework.condition.entity.Car;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class CarRepository {
    private final SessionFactory sessionFactory;

    private final CarMapper carMapper;

    public CarRepository(SessionFactory sessionFactory, @Qualifier("carMapper") CarMapper carMapper) {
        this.sessionFactory = sessionFactory;
        this.carMapper = carMapper;
    }

    public List<Car> getAllCars(){
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            //SQL
            List<Car> cars = session.createQuery("from Car", Car.class).getResultList();

            session.getTransaction().commit();
            return cars;
        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public Optional<Car> getCarById(Integer id){
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Car car = session.get(Car.class, id);
            session.getTransaction().commit();
            return Optional.ofNullable(car);
        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public List<Car> getCarsAfterYear(Integer year){
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Car> carsAfterCurrentYear = session.createQuery("from Car where year > " + year, Car.class)
                    .getResultList();
            session.getTransaction().commit();
            return carsAfterCurrentYear;
        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public void saveCar(Car car){
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            session.persist(car);
            session.getTransaction().commit();

        }
        catch (Exception ex){
            if(session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
        finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public void deleteCarById(Integer id) {
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Car deleteCar = session.get(Car.class, id);
            if (deleteCar == null) {
                throw new NoSuchElementException("No car by id " + id);
            }
            session.remove(deleteCar);
            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateProduct(Car car, Integer id) {
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Car updatableCar = session.get(Car.class, id);
            if (updatableCar == null) {
                throw new NoSuchElementException("No car with id = " + id);
            }
            carMapper.updateFieldsCar(updatableCar, car);
            session.persist(updatableCar);

            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
