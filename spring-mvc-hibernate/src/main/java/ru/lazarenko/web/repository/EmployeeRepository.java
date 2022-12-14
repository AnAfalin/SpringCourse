package ru.lazarenko.web.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lazarenko.web.entity.Employee;
import ru.lazarenko.web.model.DepartmentAggregate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;
    private static final String sqlQueryMaxSalaryByDepartment = "SELECT " +
            "NEW ru.lazarenko.web.model.DepartmentAggregate(em.department, max(em.salary)) " +
            "FROM Employee em " +
            "GROUP BY department";

    private static final String sqlQueryMinSalaryByDepartment = "SELECT " +
            "NEW ru.lazarenko.web.model.DepartmentAggregate(em.department, min(em.salary)) " +
            "FROM Employee em " +
            "GROUP BY department";

    private static final String sqlQueryAvgSalaryByDepartment = "SELECT " +
            "NEW ru.lazarenko.web.model.DepartmentAggregate(em.department, avg(em.salary)) " +
            "FROM Employee em " +
            "GROUP BY department";

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
            if (updateEmployee != null) {
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

    public Map<String, Double> getMapDepartmentAggregationSalary(String query) {

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            List<DepartmentAggregate> resultList;
            if (query.equalsIgnoreCase("max")) {
                resultList = entityManager
                        .createQuery(sqlQueryMaxSalaryByDepartment, DepartmentAggregate.class)
                        .getResultList();
            } else if (query.equalsIgnoreCase("min")) {
                resultList = entityManager
                        .createQuery(sqlQueryMinSalaryByDepartment, DepartmentAggregate.class)
                        .getResultList();
            } else {
                resultList = entityManager
                        .createQuery(sqlQueryAvgSalaryByDepartment, DepartmentAggregate.class)
                        .getResultList();
            }
            Map<String, Double> result = new HashMap<>();
            for (DepartmentAggregate element : resultList) {
                result.put(element.getDepartment(), element.getSalary());
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