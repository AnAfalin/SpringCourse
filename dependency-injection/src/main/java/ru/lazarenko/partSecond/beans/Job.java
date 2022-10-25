package ru.lazarenko.partSecond.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public abstract class Job {

}

@Component
class HardJob extends Job{
    @Override
    public String toString() {
        return "HardJob";
    }
}

@Primary
@Component
class MediumJob extends Job{
    @Override
    public String toString() {
        return "MediumJob";
    }
}

@Component
class EasyJob extends Job{
    @Override
    public String toString() {
        return "EasyJob";
    }
}

