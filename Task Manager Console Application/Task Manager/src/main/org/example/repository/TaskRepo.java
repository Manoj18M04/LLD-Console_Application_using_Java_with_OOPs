package main.org.example.repository;

public interface TaskRepo {
    public void addTask();
    public void viewTask();
    public void deleteTask(int taskNo);
    public void markAsComplete(int taskNo);
}
