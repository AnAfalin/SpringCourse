package ru.lazarenko.web.model;

public class DepartmentAggregate {
    private String department;
    private Double salary;

    public DepartmentAggregate(String department, Double salary) {
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}