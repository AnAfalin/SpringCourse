package ru.lazarenko.web.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.lazarenko.web.model.Message;
import ru.lazarenko.web.model.User;

@Component
public class Creator {
    @Value("${user.Name}")
    private String name;
    @Value("${user.age}")
    private Integer age;
    @Value("${user.profession}")
    private String profession;

    @Value("${message.text}")
    private String text;

    public User createUser() {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setProfession(profession);
        return user;
    }

    public Message createMassage() {
        Message message = new Message();
        message.setText(text);
        return message;
    }

}
