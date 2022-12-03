package com.example.web.utils;

import com.example.web.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Creator {
    @Value("${message.text}")
    private String text;

    public Message createMessage(){
        Message message = new Message();
        message.setText(text);
        return message;
    }
}