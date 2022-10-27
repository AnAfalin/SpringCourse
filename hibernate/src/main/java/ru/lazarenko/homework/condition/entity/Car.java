package ru.lazarenko.homework.condition.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import java.time.LocalDate;
import java.time.Year;

@Entity
@DynamicUpdate
@Table(name = "cars")
public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer price;

    private String owner;

    @Column(nullable = false)
    private String year;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    public Car() {
    }

    /*if field 'id' is Integer*/
    //
    // public Car(Integer id, String model, Integer price, String owner, Integer year, LocalDate insuranceExpirationDate) {
    //     this.id = id;
    //     this.model = model;
    //     this.price = price;
    //     this.owner = owner;
    //     this.year = Year.of(year).toString();
    //     this.insuranceExpirationDate = insuranceExpirationDate;
    // }
    //
    // public Integer getId() {
    //     return id;
    // }
    //
    // public void setId(Integer id) {
    //     this.id = id;
    // }

    public Car(String id, String model, Integer price, String owner, Integer year, LocalDate insuranceExpirationDate) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.owner = owner;
        this.year = Year.of(year).toString();
        this.insuranceExpirationDate = insuranceExpirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getInsuranceExpirationDate() {
        return insuranceExpirationDate;
    }

    public void setInsuranceExpirationDate(LocalDate insuranceExpirationDate) {
        this.insuranceExpirationDate = insuranceExpirationDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", owner='" + owner + '\'' +
                ", year='" + year + '\'' +
                ", insuranceExpirationDate=" + insuranceExpirationDate +
                '}';
    }
}
