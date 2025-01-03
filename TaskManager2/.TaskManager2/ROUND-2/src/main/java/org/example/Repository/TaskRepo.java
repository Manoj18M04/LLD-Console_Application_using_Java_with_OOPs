package org.example.Repository;

import org.example.Model.Task;

import java.util.*;

public class TaskRepo {
    Task task;
    static List<Task> map = new ArrayList<>();
    public void addTask(Task task) {
        map.add(task);
        map.sort(Comparator.comparing(Task::getPriority));
    }

    public List<Task> fetch() {
        if(map.isEmpty()) {
            return null;
        }
        return map;
    }
    public void updateStatus(Task task) {
        task.updateStatus();
        removeTask(task);
    }
    public void updateStatus(int id) {
        for(Task task : map) {
            if(task.getId() == id) {
                task.updateStatus();
                removeTask(task);
            }
        }
    }
    public void removeTask(Task task) {
        map.remove(task);
    }
}
