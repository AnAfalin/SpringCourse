package ru.lazarenko.web.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lazarenko.web.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public EmployeeRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    //INSERT
    public void saveEmployee(Employee employee) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            if (employee.getId() == null) {
                entityManager.persist(employee);
            } else {
                entityManager.merge(employee);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    //SELECT
    public List<Employee> getAllEmployee() {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            List<Employee> employees = entityManager
                    .createQuery("from Employee", Employee.class)
                    .getResultList();

            entityManager.getTransaction().commit();
            return employees;
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Employee employee = entityManager.find(Employee.class, id);

            entityManager.getTransaction().commit();
            return Optional.ofNullable(employee);
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    //DELETE
    public void deleteEmployee(Integer id) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("delete from Employee where id=:id");
            query.setParameter("id", id);
            query.executeUpdate();

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    //UPDATE
    public void updateEmployee(Employee employee, Integer id) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            Employee updateEmployee = entityManager.find(Employee.class, id);
            if(updateEmployee != null){
                updateEmployee.setDepartment(employee.getDepartment());
                updateEmployee.setName(employee.getName());
                updateEmployee.setSalary(employee.getSalary());
            }

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public Map<String, Integer> getMapDepartmentAggregationSalary(String query) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            class DepartmentAggregate {
                String department;
                Integer salary;
            }

            List<DepartmentAggregate> resultList = entityManager
                    .createQuery("select department " + query + "(salary) from employees group by deparment",
                            DepartmentAggregate.class)
                    .getResultList();

            Map<String, Integer> result = new HashMap<>();
            for (DepartmentAggregate element : resultList) {
                result.put(element.department, element.salary);
            }

            entityManager.getTransaction().commit();
            return result;
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}