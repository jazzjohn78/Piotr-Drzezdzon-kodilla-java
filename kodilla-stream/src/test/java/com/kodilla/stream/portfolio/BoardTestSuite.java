package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());

    }

    @Test
    void testAddTaskListFindUserTasks() {
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user))
                .collect(Collectors.toList());

        //Then
        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> outdatedTasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        //Then
        assertEquals(1, outdatedTasks.size());
        assertEquals("HQLs for analysis", outdatedTasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        assertEquals(2, longTasks);
    }

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        double countProgress = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(task -> task.getCreated().toEpochDay())
                .map(day -> LocalDate.now().toEpochDay() - day)
                .count();
        double sumProgress = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(task -> task.getCreated().toEpochDay())
                .map(day -> LocalDate.now().toEpochDay() - day)
                .reduce(0L, (sum, current) -> sum += current);
        double averageProgress = sumProgress / countProgress;

        double directAverageProgress = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(task -> LocalDate.now().toEpochDay() - task.getCreated().toEpochDay())
                .mapToLong(days -> days)
                .average()
                .getAsDouble();

        //Then
        assertEquals(10.0, averageProgress);
        assertEquals(10.0, directAverageProgress);
    }

    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
}
