package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {
    private static TaskFactory factory;

    @BeforeAll
    public static void createTaskFactory() {
        factory = new TaskFactory();
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        //When
        Task drivingTask = factory.createTask(TaskFactory.DRIVING_TASK);
        //Then
        assertEquals("a quick driving task", drivingTask.getTaskName());
        assertEquals(false, drivingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        //When
        Task paintingTask = factory.createTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();
        //Then
        assertEquals("an awful painting task", paintingTask.getTaskName());
        assertEquals(true, paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        //When
        Task shoppingTask = factory.createTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();
        //Then
        assertEquals("a simple shopping task", shoppingTask.getTaskName());
        assertEquals(true, shoppingTask.isTaskExecuted());
    }
}
