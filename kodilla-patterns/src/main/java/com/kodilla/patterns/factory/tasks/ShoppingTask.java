package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    private final String taskName;
    private final String whatDoBuy;
    private final double quantity;
    private boolean isExecuted = false;

    public ShoppingTask(final String taskName, final String whatDoBuy, final double quantity) {
        this.taskName = taskName;
        this.whatDoBuy = whatDoBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing " + taskName + " buying " + quantity + " pcs of " + whatDoBuy);
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
