package ru.lazarenko.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//специальный компонент, принимающий запросы от клиента.
//Контроллер принимает HTTP-запросы, поэтому в контроллере задаются методы под каждый запрос
@Controller
public class StartController {

    @ResponseBody //аннотация означает, что сервер отвечает данным текстом на запрос (@ResponseBody – ответ сервера)
    @GetMapping ("/start")//означает, что обрабатывается HTTP Get запрос.
    public String getStartPage(){
        return "Welcome!";
    }

}
