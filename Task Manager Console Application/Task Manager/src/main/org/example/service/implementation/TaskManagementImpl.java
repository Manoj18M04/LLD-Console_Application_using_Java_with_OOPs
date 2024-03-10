package main.org.example.service.implementation;

import main.org.example.model.TaskManager;
import main.org.example.repository.TaskRepo;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskManagementImpl implements TaskRepo {
    Scanner sc = new Scanner(System.in);
    String title;
    String description;
    int taskNo;
    int priorityLevel;
    boolean status;
    int index = 0;
    String type;

    Map<Integer, TaskManager> taskList = new TreeMap<>();

    public void addTask(){
        index++;
        System.out.println("Please Enter the title of your task");
        title = sc.nextLine();
        status = false;
        System.out.println("Enter the short description of the task");
        description = sc.nextLine();
        System.out.println("Select Priority in the scale of 1 to 3 (1 for high priority & 3 for low priority)");
        priorityLevel = sc.nextInt();
        System.out.println("Choose a category of your task");
        type = sc.nextLine();
        taskNo = (priorityLevel*100) + index;
        TaskManager task = new TaskManager(title, description, priorityLevel, status, type);
        taskList.put(taskNo, task);
        System.out.println("Task Added Successfully");
        sc.nextLine();
    }

    public void viewTask(){
        for(Map.Entry<Integer, TaskManager> entry : taskList.entrySet()){
            System.out.print(entry.getKey() + " ");
            System.out.println("Title: " + entry.getValue().getTitle());
            System.out.println("Description: " + entry.getValue().getDescription());
            System.out.println("Status: " + entry.getValue().isStatus());
            if(entry.getValue().getPriorityLevel() == 1) System.out.println("Priority: High");;
            if(entry.getValue().getPriorityLevel() == 2) System.out.println("Priority: Middle");;
            if(entry.getValue().getPriorityLevel() == 3) System.out.println("Priority: Low");
            System.out.println("Category: " + type);
            System.out.println("------------------------------------------------");
        }
    }

    public void deleteTask(int taskNo){
        if(taskList.containsKey(taskNo)){
            taskList.remove(taskNo);
            System.out.println("The task with the number " + taskNo + " is deleted successfully");
        }
        else{
            System.out.println("No tasks available with the number given");
        }
    }

    public void markAsComplete(int taskNo){
        TaskManager update = taskList.get(taskNo);
        if(update != null){
            update.setStatus(true);
            taskList.put(taskNo, update);
            System.out.println("The task with the number " + taskNo + " is updated");
        }
    }
}
