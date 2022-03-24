package com.kodilla.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework implements HomeworkObservable {
    private final List<HomeworkObserver> mentors;
    private final List<String> homeworks;
    private final String name;

    public Homework(String name) {
        mentors = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.name = name;
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyMentor();
    }

    @Override
    public void registerMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyMentor() {
        for (HomeworkObserver mentor : mentors) {
            mentor.update(this);
        }
    }

    @Override
    public void removeMentor(Mentor mentor) {
        mentors.remove(mentor);
    }
}
