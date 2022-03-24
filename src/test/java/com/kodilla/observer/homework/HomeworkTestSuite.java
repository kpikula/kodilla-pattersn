package com.kodilla.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeworkTestSuite {

    @Test
    public void testNotify() {
        //Given
        Homework moduleNo1Homework = new ModuleNo1Homework();
        Homework moduleNo2Homework = new ModuleNo2Homework();
        Mentor jacekKasprzykowski = new Mentor("Jacek", "Kasprzykowski");
        moduleNo1Homework.registerMentor(jacekKasprzykowski);
        moduleNo2Homework.registerMentor(jacekKasprzykowski);

        //When
        moduleNo1Homework.addHomework("Module #1 - Java Introduction");
        moduleNo2Homework.addHomework("Module #2 - Java Collections");

        //Then
        Assertions.assertEquals(2, jacekKasprzykowski.getNotifyCount());
        Assertions.assertEquals("Module #1 - Java Introduction", moduleNo1Homework.getName());
        Assertions.assertEquals("Jacek", jacekKasprzykowski.getMentorFirstName());
    }

    @Test
    public void testRemoveMentor() {
        //Given
        Homework moduleNo1Homework = new ModuleNo1Homework();
        Homework moduleNo2Homework = new ModuleNo2Homework();
        Mentor jacekKasprzykowski = new Mentor("Jacek", "Kasprzykowski");
        moduleNo1Homework.registerMentor(jacekKasprzykowski);
        moduleNo2Homework.registerMentor(jacekKasprzykowski);

        //When
        moduleNo1Homework.removeMentor(jacekKasprzykowski);
        moduleNo1Homework.addHomework("Module #1 - Java Introduction");
        moduleNo2Homework.addHomework("Module #2 - Java Collections");

        //Then
        Assertions.assertEquals(1, jacekKasprzykowski.getNotifyCount());
    }
}