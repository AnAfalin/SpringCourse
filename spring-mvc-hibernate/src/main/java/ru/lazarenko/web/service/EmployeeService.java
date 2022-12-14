package ru.lazarenko.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lazarenko.web.entity.Employee;
import ru.lazarenko.web.repository.EmployeeRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Order with id = '%d' not found".formatted(id)));
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    public void deleteById(Integer id){
        employeeRepository.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee, employee.getId());
//        employeeRepository.saveEmployee(employee);
    }

    public Map<String, Double> getMapDepartmentAggregationSalary(String query){
        return employeeRepository.getMapDepartmentAggregationSalary(query);
    }
}
