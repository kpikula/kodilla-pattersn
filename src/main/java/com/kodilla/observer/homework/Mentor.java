package com.kodilla.observer.homework;

public class Mentor implements HomeworkObserver {
    private final String mentorFirstName;
    private final String mentorLastName;
    private int updateCount;

    public Mentor(String mentorFirstName, String mentorLastName) {
        this.mentorFirstName = mentorFirstName;
        this.mentorLastName = mentorLastName;
    }

    @Override
    public void update(Homework homework) {
        System.out.println(mentorFirstName + " " + mentorLastName + ": The student submitted a new homework " + homework.getName() + "\n" +
                " (total: " + homework.getHomeworks().size() + " messages)");
        updateCount++;
    }

    public String getMentorFirstName() {
        return mentorFirstName;
    }

    public String getMentorLastName() {
        return mentorLastName;
    }

    public int getNotifyCount() {
        return updateCount;
    }
}
