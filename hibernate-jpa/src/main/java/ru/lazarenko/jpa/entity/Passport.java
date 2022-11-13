package ru.lazarenko.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passports")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String series;
    private String number;

    @OneToOne(mappedBy = "passport", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Person person;

    public Passport() {
    }

    public Passport(Integer id, String series, String number) {
        this.id = id;
        this.series = series;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        person.setPassport(this);
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", series=" + series +
                ", number=" + number +
                ", person=" + person +
                '}';
    }
}
