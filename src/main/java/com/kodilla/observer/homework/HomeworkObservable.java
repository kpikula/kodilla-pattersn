package com.kodilla.observer.homework;

public interface HomeworkObservable {
    void registerMentor(Mentor mentor);
    void notifyMentor();
    void removeMentor(Mentor mentor);
}
