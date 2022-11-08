package ru.lazarenko.homework.relationsBiDirect.entity;

import jakarta.persistence.*;

import java.util.List;

@SuppressWarnings("all")

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {
    }

    public Category(Integer id, String title) {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        product.getCategories().add(this);
        this.products = products;
    }
}
