package org.example.Services;

import org.example.Model.Task;
import org.example.Repository.TaskRepo;

import java.util.*;

public class TaskServices {
    static int id = 1;
    public void addTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Task description:");
        String desc = sc.nextLine();
        System.out.println("Enter the priority of the task:");
        System.out.println("Enter 1 for high Priority");
        System.out.println("Enter 2 for middle Priority");
        System.out.println("Enter 3 for low Priority");
        int priority = sc.nextInt();
        System.out.println("Enter the execution time for the task (in min):");
        int time = sc.nextInt();
        Task task = new Task(id, desc, priority, time);
        TaskRepo repo = new TaskRepo();
        repo.addTask(task);
        System.out.print("Task Added: ");
        System.out.print("[ID: " + id);
        System.out.print(", Name: " + desc);
        System.out.print(", Priority: " + priority);
        System.out.println(", Time: " + time + "]");
        id++;
    }

    public void viewTask() {
        TaskRepo repo = new TaskRepo();
        List<Task> tasks = repo.fetch();
        int f1 = 0, f2 = 0, f3 = 0;
        if(tasks != null) {
            for (Task task : tasks) {
                if(f1 == 0 && task.getPriority() == 1) {
                    f1++;
                    System.out.println("Priority 1:");
                }
                if(f2 == 0 && task.getPriority() == 2) {
                    f2++;
                    System.out.println("Priority 2:");
                }
                if(f3 == 0 && task.getPriority() == 3) {
                    f3++;
                    System.out.println("Priority 3:");
                }
                System.out.print("[Id: " + task.getId());
                System.out.print(" ,Description: " + task.getDescription());
                System.out.print(" ,Status: " + task.getStatus());
                System.out.print(" ,Priority: " + task.getPriority());
                System.out.println(" ,Time: " + task.getTime() + "mins ]");
            }
        }
        else {
            System.out.println("No tasks found");
        }
    }

    public void markAsCompleted(int ID) {
        TaskRepo repo = new TaskRepo();
        repo.updateStatus(ID);
    }

    public void timeRequired() {
        TaskRepo repo = new TaskRepo();
        List<Task> tasks = repo.fetch();
        int time = 0;
        for(Task task : tasks) {
            time += task.getTime();
        }
        System.out.println("Total time required: " + time + "mins");
    }

    public void simulate() {
        TaskRepo repo = new TaskRepo();
        List<Task> tasks = repo.fetch();
        for(Task task : tasks) {
            int time = task.getTime();
            for(int i = time - 1; i > 0; i--) {
                if(task.getStatus()) break;
                System.out.println("Executing Task: " + task.getDescription() + ", Remaining Time: " + i + "mins");
            }
            System.out.println("Executing Task: " + task.getDescription() + ", Completed");
            repo.updateStatus(task);
        }
    }
}
