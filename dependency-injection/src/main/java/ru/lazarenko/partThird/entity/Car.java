package ru.lazarenko.partThird.entity;

public class Car {
    private Integer id;
    private String model;
    private Integer price;
    private String owner;
    private String year;

    public Car(Integer id, String model, Integer price, String owner, String year) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.owner = owner;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Integer getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", owner='" + owner + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
