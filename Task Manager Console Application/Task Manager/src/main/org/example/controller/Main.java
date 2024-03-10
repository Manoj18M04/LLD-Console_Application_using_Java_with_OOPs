package main.org.example.controller;

import main.org.example.repository.TaskRepo;
import main.org.example.service.implementation.TaskManagementImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        welcome();
        Scanner scan = new Scanner(System.in);
        TaskRepo taskRepo = new TaskManagementImpl();
        application(taskRepo, scan);
    }

    public static void welcome() {
        System.out.println("---------- Welcome !!! ----------");
    }

    public static void application(TaskRepo taskRepo, Scanner scan) {
        while (true){

            System.out.println();
            System.out.println("Please select an option from below: ");
            System.out.println("1. Add a Task");
            System.out.println("2. Delete a Task");
            System.out.println("3. View Task list");
            System.out.println("4. Update Completed tasks");
            System.out.println("Any other number to exit");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    taskRepo.addTask();
                    break;
                case 2:
                    int deleteTask = scan.nextInt();
                    taskRepo.deleteTask(deleteTask);
                    break;
                case 3:
                    taskRepo.viewTask();
                    break;
                case 4:
                    int updateTask = scan.nextInt();
                    taskRepo.markAsComplete(updateTask);
                    break;
                default:
                    return;
            }
        }
    }
}
