package ru.lazarenko.partFirst.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("person")
@Scope("prototype")
public class Person {
}
