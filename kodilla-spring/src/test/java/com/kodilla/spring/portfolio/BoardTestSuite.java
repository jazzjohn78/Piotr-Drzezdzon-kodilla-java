package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().addTask("task to do");
        board.getInProgressList().addTask("task in progress");
        board.getDoneList().addTask("task done");

        //Then
        assertEquals("task to do", board.getToDoList().getTasks().get(0));
        assertEquals("task in progress", board.getInProgressList().getTasks().get(0));
        assertEquals("task done", board.getDoneList().getTasks().get(0));
    }
}
