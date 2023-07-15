package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWorkTestSuite {

    @Test
    public void testQueueUpdate() {
        //Given
        TaskQueue student1 = new TaskQueue("Student 1");
        TaskQueue student2 = new TaskQueue("Student 2");
        TaskQueue student3 = new TaskQueue("Student 3");
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        student1.registerObserver(mentor1);
        student2.registerObserver(mentor1);
        student3.registerObserver(mentor2);
        //When
        student1.addTask("Task 1");
        student2.addTask("Task 2");
        student3.addTask("Task 3");
        student1.addTask("Task 4");
        student2.addTask("Task 5");
        //Then
        assertEquals(4, mentor1.getUpdateCount());
        assertEquals(1, mentor2.getUpdateCount());
    }
}
