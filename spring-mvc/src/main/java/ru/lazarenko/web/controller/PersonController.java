package ru.lazarenko.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lazarenko.web.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PersonController {
    private static List<Person> LIST_PERSONS = new ArrayList<>();

    static {
        LIST_PERSONS.add(new Person("Ana", 25, "female"));
        LIST_PERSONS.add(new Person("Slava", 45, "male"));
        LIST_PERSONS.add(new Person("Slavik", 35, "male"));
        LIST_PERSONS.add(new Person("Irina", 42, "female"));
        LIST_PERSONS.add(new Person("Nikolai", 22, "male"));
    }

    @GetMapping("/")
    public String getStartPage() {
        return "start";
    }

    @GetMapping("/postInput")
    public String getPostInputPage(Model model) {
        model.addAttribute("person", new Person());
        return "form-post-request";
    }

    @GetMapping("/getInput")
    public String getGetInputPage() {
        return "form-get-request";
    }

    @GetMapping("/deletePerson")
    public String getDeletePersonPage() {
        return "form-delete";
    }

    @GetMapping("/form-handler")
    public String createPersonGet(@RequestParam String name,
                                  @RequestParam Integer age,
                                  @RequestParam String gender,
                                  Model model) {
        Person person = new Person(name, age, gender);
        LIST_PERSONS.add(person);
        model.addAttribute("person", person);
        return "form-result-input";
    }

    @PostMapping("/form-handler")
    public String createPersonPost(@ModelAttribute Person person) {
        LIST_PERSONS.add(person);
        return "redirect:/resInput";
    }

    @GetMapping("/resInput")
    public String getInputResult(Model model) {
        model.addAttribute("persons", LIST_PERSONS);
        return "form-list-person";
    }

    @GetMapping("/create")  // /create?name=Ana&age=25&gender=female
    public String createPersonRequestParam(@RequestParam String name,
                                           @RequestParam Integer age,
                                           @RequestParam String gender,
                                           Model model) {
        Person person = new Person(name, age, gender);
        LIST_PERSONS.add(person);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("gender", gender);
        return "person";
    }

    @GetMapping("/deletePersonByValue")
    public String getPageAfterDelete(@RequestParam String type,
                                     @RequestParam String value,
                                     Model model) {
        if (type.equals("age")) {
            LIST_PERSONS = LIST_PERSONS
                    .stream()
                    .filter(person -> person.getAge() != Integer.parseInt(value))
                    .collect(Collectors.toList());
        } else if (type.equals("name")) {
            LIST_PERSONS = LIST_PERSONS
                    .stream()
                    .filter(person -> !person.getName().equalsIgnoreCase(value))
                    .collect(Collectors.toList());
        } else {
            LIST_PERSONS = LIST_PERSONS
                    .stream()
                    .filter(person -> !person.getGender().equalsIgnoreCase(value))
                    .collect(Collectors.toList());
        }
        model.addAttribute("persons", LIST_PERSONS);
        return "form-list-person";
    }

    @GetMapping("/sortList")
    public String getPageSortPerson() {
        return "form-sort-list-person";
    }

    @GetMapping("/showSortPerson")
    public String getPageAfterDelete(@RequestParam String count,
                                     @RequestParam String sortBy,
                                     @RequestParam String sortType,
                                     Model model) {
        if (sortBy.equals("name")) {
            if (sortType.equals("ascending")) {
                model.addAttribute("persons", LIST_PERSONS
                        .stream()
                        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                        .limit(Integer.parseInt(count)));
            } else {
                model.addAttribute("persons", LIST_PERSONS
                        .stream()
                        .sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
                        .limit(Integer.parseInt(count)));
            }

        } else if (sortBy.equals("age")) {
            if (sortType.equals("ascending")) {
                model.addAttribute("persons", LIST_PERSONS
                        .stream()
                        .sorted((p1, p2) -> p1.getAge().compareTo(p2.getAge()))
                        .limit(Integer.parseInt(count)));
            } else {
                model.addAttribute("persons", LIST_PERSONS
                        .stream()
                        .sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()))
                        .limit(Integer.parseInt(count)));
            }
        } else {
            if (sortType.equals("male")) {
                model.addAttribute("persons", LIST_PERSONS
                        .stream()
                        .sorted((p1, p2) -> p2.getGender().compareTo(p1.getGender()))
                        .limit(Integer.parseInt(count)));
            } else {
                model.addAttribute("persons", LIST_PERSONS
                        .stream()
                        .sorted((p1, p2) -> p1.getGender().compareTo(p2.getGender()))
                        .limit(Integer.parseInt(count)));
            }
        }
        return "form-list-person";
    }
}
