package ru.lazarenko.partFirst.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Material {
    @Value("Brick")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
