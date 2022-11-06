package ru.lazarenko.homework.relations.partFourth.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private List<Student> students;

    public Group() {
    }

    public Group(Integer id, String title) {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
