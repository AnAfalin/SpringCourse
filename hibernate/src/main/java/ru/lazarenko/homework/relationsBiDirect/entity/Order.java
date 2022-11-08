package ru.lazarenko.homework.relationsBiDirect.entity;

import jakarta.persistence.*;

import java.util.List;

@SuppressWarnings("all")

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private Buyer buyer;

    @ManyToMany(mappedBy = "orders", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Product> products;

    public Order() {
    }

    public Order(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducr(Product product) {
        product.getOrders().add(this);
        this.products = products;
    }
}
