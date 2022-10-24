package ru.lazarenko.partFirst.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class House {
    private Window window;
    private Door door;
    private Material material;

    @Autowired
    public House(Window window, Door door, Material material) {
        this.window = window;
        this.door = door;
        this.material = material;
        System.out.println("Initialization House");
    }

    @Override
    public String toString() {
        return "House{" +
                "window=" + window +
                ", door=" + door +
                ", material=" + material +
                '}';
    }
}


