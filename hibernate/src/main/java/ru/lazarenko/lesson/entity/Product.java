package ru.lazarenko.lesson.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity//класс для таблицы бд
@Table(name="products")
public class Product {

    @Id//поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY)//стратегия генерации первичного ключа
    private Long id;
    private String name;
    private Integer price;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public Product(){}

    public Product(Long id, String name, Integer price, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
