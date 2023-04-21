package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING_TASK = "Driving task";
    public static final String PAINTING_TASK = "Painting task";
    public static final String SHOPPING_TASK = "Shopping task";


    Task createTask(String task) {
        return switch (task) {
            case DRIVING_TASK -> new DrivingTask("a quick driving task", "the airport", "a car");
            case PAINTING_TASK -> new PaintingTask("an awful painting task", "pink", "bedroom");
            case SHOPPING_TASK -> new ShoppingTask("a simple shopping task", "eggs", 12.0);
            default -> null;
        };
    }
}
