package ru.lazarenko.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.lazarenko.web.util.Creator;
import ru.lazarenko.web.beans.Message;
import ru.lazarenko.web.beans.User;

@Controller
public class SentController {
    private final Creator creator;

    @Autowired
    public SentController(Creator creator) {
        this.creator = creator;
    }

    @ResponseBody //аннотация означает, что сервер отвечает данным текстом на запрос (@ResponseBody – ответ сервера)
    @GetMapping("/user")
    public String sentStringUser() {
        User user = creator.createUser();
        System.out.println(user);
        return user.toString();
    }

    @ResponseBody
    @GetMapping("/message")
    public String sentStringMassage(){
        Message message = creator.createMassage();
        System.out.println(message);
        return message.toString();
    }
}
