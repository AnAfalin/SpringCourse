package ru.lazarenko.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lazarenko.web.model.Person;

@Controller
public class PersonController {

    @GetMapping("/create")  // /create?name=Ana&age=25&gender=female
    public String createPersonRequestParam(@RequestParam String name,
                          @RequestParam Integer age,
                          @RequestParam String gender,
                          Model model){
        Person person = new Person(name, age, gender);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("gender", gender);
        return "person";
    }

    @GetMapping("/input")
    public String getCreatePersonPage(Model model){
        model.addAttribute("person", new Person());
        return "input-person";
    }

    @GetMapping("/form-handler")
    public String createPersonGet(@RequestParam String name,
                               @RequestParam Integer age,
                               @RequestParam String gender,
                               Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("gender", gender);
        return "result-input";
    }

    @PostMapping("/form-handler")
    public String createPersonPost(@ModelAttribute Person person, Model model) {
        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());
        model.addAttribute("gender", person.getGender());
        return "result-input";
    }
}
