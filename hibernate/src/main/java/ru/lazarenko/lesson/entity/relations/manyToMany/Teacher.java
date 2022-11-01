package ru.lazarenko.lesson.entity.relations.manyToMany;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@SuppressWarnings("all")
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;
    private Integer experience;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "teachers_subjects",
            joinColumns = @JoinColumn(
                    name = "teacher_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "subject_id",
                    referencedColumnName = "id"))
    private List<Subject> subjects;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}