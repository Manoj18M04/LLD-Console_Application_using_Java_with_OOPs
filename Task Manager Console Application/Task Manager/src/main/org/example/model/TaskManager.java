package main.org.example.model;

public class TaskManager {
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TaskManager(String title, String description, int priorityLevel, boolean status, String type) {
        this.title = title;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.status = status;
        this.type = type;
    }

    private final String title;
    private final String description;
    private final int priorityLevel;

    public String getType() {
        return type;
    }

    private final String type;
    private boolean status;
}
