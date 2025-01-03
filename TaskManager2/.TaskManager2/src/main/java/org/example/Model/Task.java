package org.example.Model;

public class Task {
    private int id;
    private String description;
    private boolean status = false;
    private int priority;
    private int time;

    public Task(int id, String description, int priority, int time) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public void updateStatus() {
        status = true;
    }
}
