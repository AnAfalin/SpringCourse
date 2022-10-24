package ru.lazarenko.partFirst.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class Window {
    @Value("50")
    private int amount;

    @Override
    public String toString() {
        return Integer.toString(amount);
    }
}
