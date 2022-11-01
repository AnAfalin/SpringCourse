package ru.lazarenko.lesson.entity.relations.oneToMany;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@SuppressWarnings("all")
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;
    private String job;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public Employee(){}

    public Employee(Integer id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}