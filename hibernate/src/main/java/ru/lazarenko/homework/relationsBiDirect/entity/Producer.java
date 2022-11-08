package ru.lazarenko.homework.relationsBiDirect.entity;

import jakarta.persistence.*;

@SuppressWarnings("all")

@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToOne(mappedBy = "producer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Product product;

    public Producer() {
    }

    public Producer(Integer id, String title) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        product.setProducer(this);
        this.product = product;
    }
}

