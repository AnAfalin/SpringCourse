package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.utils.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
Маппинг – связывает метод контроллера с адресом, по которому можно обратиться к этому методу.
Виды маппингов отличаются по HTTP методу:
@GetMapping – GET;
@PostMapping – POST;
@PutMapping – PUT;
@DeleteMapping – DELETE;
@PatchMapping – PATCH.
Контроллер (класс, помеченный аннотаций @Controller) – специальный компонент, принимающий запросы от клиента.
*/

/*First lecture*/
/*
@Controller
public class HelloController {

    private final Creator creator;

    @Autowired
    public HelloController(Creator creator) {
        this.creator = creator;
    }

//   Аннотация @GetMapping означает, что обрабатывается HTTP Get запрос.
//   Аннотация @ResponseBody означает, что сервер отвечает данным текстом на запрос (@ResponseBody – ответ сервера)
//   Добавив аннотацию @ResponseBody, контроллер не будет искать представление (html-страницу), а вернет данные (текст) напрямую в теле запроса.

    @ResponseBody
    @GetMapping("/hello")
    public String getHelloRequest(){
        return creator.createMessage().toString();
    }

    @GetMapping("/page")
    public String getPage(){
        return "hello-page";
    }
}
*/

@Controller
public class HelloController {
    private static List<User> CURRENT_USERS = new ArrayList<>();

    //RequestParam позволяет писать описывать параметры метода
    //Все параметры по умолчанию обязательные, но параметры можно сделать необязательными с помощью required = false
    @GetMapping("/hi")   //не пишем! hello?param=value
    public String getPage(@RequestParam(value = "firstname", required = false) String firstname) {
        System.out.println(firstname);
        return "hello-page";    //GET localhost::8080/hello?firstname=Mike
    }

    //Model используется для передачи данных из модели в HTML представление
    //Для добавления атрибутов, которые будут использоваться в html странице, используется метод addAttribute.
    @GetMapping("/hello")
    public String getPage(@RequestParam String firstname, Model model) {
        model.addAttribute("name", firstname);
        return "hello-page";    //GET localhost::8080/hello?firstname=Mike
    }

    @GetMapping("/input")
    public String getInputPage(Model model) {
        model.addAttribute("user", new User());
        return "input";
    }

    @GetMapping("/form-handler")
    public String handlerForm(@RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam String email,
                              Model model) {
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        model.addAttribute("email", email);
        return "data";
    }

    @PostMapping("/form-handler")
    public String handleForm(@ModelAttribute User user){
//        model.addAttribute("firstname", user.getFirstname());
//        model.addAttribute("lastname", user.getLastname());
//        model.addAttribute("email", user.getEmail());
        CURRENT_USERS.add(user);
        return "redirect:/input-result";
    }

    @GetMapping("/input-result")
    public String getInputResult(Model model){
        model.addAttribute("user", CURRENT_USERS.get(CURRENT_USERS.size() - 1));
        return "data";
    }

    @GetMapping("/list")
    public String getUserList(Model model){
        model.addAttribute("users", CURRENT_USERS);
        return "list";
    }
}
