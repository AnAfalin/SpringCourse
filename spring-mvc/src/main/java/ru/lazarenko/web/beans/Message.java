package ru.lazarenko.web.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Message {
    private UUID id;
    private String text;
    private LocalDateTime sentDataTime;

    public Message() {
        this.id = UUID.randomUUID();
        sentDataTime = LocalDateTime.now();
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", sentDataTime=" + sentDataTime +
                '}';
    }
}
