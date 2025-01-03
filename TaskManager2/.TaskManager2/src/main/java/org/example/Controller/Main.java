package org.example.Controller;

import org.example.Services.TaskServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskServices taskServices = new TaskServices();
        while(true) {
            System.out.println("====================");
            System.out.println("Welcome to the task scheduling system");
            System.out.println("Enter the choice of operation needed to do:");
            System.out.println("1. Add Task");
            System.out.println("2. View tasks by priority");
            System.out.println("3. Simulate task Execution");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Calculate Total time");
            System.out.println("6. Exit");
            System.out.println("====================");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    taskServices.addTask();
                    break;
                case 2:
                    taskServices.viewTask();
                    break;
                case 3:
                    taskServices.simulate();
                    break;
                case 4:
                    System.out.println("Enter Id to change the status:");
                    int id = sc.nextInt();
                    taskServices.markAsCompleted(id);
                    break;
                case 5:
                    taskServices.timeRequired();
                    break;
                default:
                    return;
            }
        }

    }
}
