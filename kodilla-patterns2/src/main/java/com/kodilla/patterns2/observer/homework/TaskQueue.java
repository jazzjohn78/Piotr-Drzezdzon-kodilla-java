package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements Observable {
    private final String studentName;
    private List<String> taskList;
    private Observer mentor;


    public TaskQueue(String studentName) {
        this.studentName = studentName;
        taskList = new ArrayList<>();
    }

    public void addTask(String task) {
        taskList.add(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.mentor = observer;
    }

    @Override
    public void notifyObserver() {
        if (mentor != null) mentor.update(this);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.mentor = null;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getTaskList() {
        return taskList;
    }
}
