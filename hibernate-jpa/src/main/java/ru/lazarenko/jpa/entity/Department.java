package ru.lazarenko.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Person> people;

    public Department() {
    }

    public Department(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        for (Person person : people) {
            person.setDepartment(this);
        }
        this.people = people;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", people=" + people +
                '}';
    }
}
