package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class Board {
    private final String name;
    private final List<TaskList> taskLists = new ArrayList<>();

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TaskList taskList) {
        return taskLists.remove(taskList);
    }

    public String getName() {
        return name;
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", taskLists=" + taskLists +
                '}';
    }
}
