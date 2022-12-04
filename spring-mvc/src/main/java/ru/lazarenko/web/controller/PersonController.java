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
import java.util.stream.Stream;

@Controller
public class PersonController {
    private static List<Person> LIST_PEOPLE = new ArrayList<>();

    static {
        LIST_PEOPLE.add(new Person("Ana", 25, "female"));
        LIST_PEOPLE.add(new Person("Slava", 45, "male"));
        LIST_PEOPLE.add(new Person("Slavik", 35, "male"));
        LIST_PEOPLE.add(new Person("Irina", 42, "female"));
        LIST_PEOPLE.add(new Person("Nikolai", 22, "male"));
    }

    @GetMapping("/")
    public String getStartPage() {
        return "start";
    }

    @GetMapping("/post-input")
    public String getPostInputPage(Model model) {
        model.addAttribute("person", new Person());
        return "form-post-request";
    }

    @GetMapping("/get-input")
    public String getGetInputPage() {
        return "form-get-request";
    }

    @GetMapping("/delete-person")
    public String getDeletePersonPage() {
        return "form-delete";
    }

    @GetMapping("/form-handler")
    public String createPersonGet(@RequestParam String name,
                                  @RequestParam Integer age,
                                  @RequestParam String gender,
                                  Model model) {
        Person person = new Person(name, age, gender);
        LIST_PEOPLE.add(person);
        model.addAttribute("person", person);
        return "form-result-input";
    }

    @PostMapping("/form-handler")
    public String createPersonPost(@ModelAttribute Person person) {
        LIST_PEOPLE.add(person);
        return "redirect:/res-input";
    }

    @GetMapping("/res-input")
    public String getInputResult(Model model) {
        model.addAttribute("people", LIST_PEOPLE);
        return "form-list-people";
    }

    @GetMapping("/create")  // /create?name=Ana&age=25&gender=female
    public String createPersonRequestParam(@RequestParam String name,
                                           @RequestParam Integer age,
                                           @RequestParam String gender,
                                           Model model) {
        Person person = new Person(name, age, gender);
        LIST_PEOPLE.add(person);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("gender", gender);
        return "person";
    }

    @GetMapping("/delete-person-by-value")
    public String getPageAfterDelete(@RequestParam String type,
                                     @RequestParam String value,
                                     Model model) {
        Stream<Person> stream = LIST_PEOPLE.stream();

        if (type.equals("age")) {
            stream = stream.filter(person -> person.getAge() != Integer.parseInt(value));
        } else if (type.equals("name")) {
            stream = stream.filter(person -> !person.getName().equalsIgnoreCase(value));
        } else {
            stream = stream.filter(person -> !person.getGender().equalsIgnoreCase(value));
        }
        LIST_PEOPLE = stream.collect(Collectors.toList());
        model.addAttribute("people", LIST_PEOPLE);
        return "form-list-people";
    }

    @GetMapping("/sort-list")
    public String getPageSortPerson() {
        return "form-sort-list-people";
    }

    @GetMapping("/show-sort-person")
    public String getPageAfterDelete(@RequestParam String count,
                                     @RequestParam String sortBy,
                                     @RequestParam String sortType,
                                     Model model) {
        Stream<Person> stream = LIST_PEOPLE.stream();

        if (sortBy.equals("name")) {
            if (sortType.equals("ascending")) {
                stream = stream.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()));
            } else {
                stream = stream.sorted((p1, p2) -> p2.getName().compareTo(p1.getName()));
            }
        } else if (sortBy.equals("age")) {
            if (sortType.equals("ascending")) {
                stream = stream.sorted((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
            } else {
                stream = stream.sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()));
            }
        } else {
            if (sortType.equals("male")) {
                stream = stream.sorted((p1, p2) -> p2.getGender().compareTo(p1.getGender()));
            } else {
                stream = stream.sorted((p1, p2) -> p1.getGender().compareTo(p2.getGender()));
            }
        }

        model.addAttribute("people", stream.limit(Integer.parseInt(count)).collect(Collectors.toList()));
        return "form-list-people";
    }
}