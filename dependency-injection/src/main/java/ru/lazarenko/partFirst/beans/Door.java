package ru.lazarenko.partFirst.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Door {
    @Value("Metal door")
    private String type;

    @Override
    public String toString() {
        return type;
    }
}
