package org.example.Controller;

import org.example.Service.Administration;
import org.example.Service.Implementation.AdministrationImpl;

import java.util.Scanner;

public class Main {

    public static void roleBasedTask(String id) {

        Administration adm = new AdministrationImpl();
        Scanner sc = new Scanner(System.in);

        if (id == null) {
            System.out.println("Incorrect UserId or Password");
            id = adm.login();
            roleBasedTask(id);
        } else {
            char roleRep = id.charAt(0);
            switch (roleRep) {
                case 'A':
                    while (true) {
                        System.out.println("Selection the task you want to do");
                        System.out.println("1 for Adding new Question");
                        System.out.println("2 for Deleting the Question");
                        System.out.println("3 for view the question");
                        System.out.println("Any other number to exit to Home Page");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                adm.addQuestions();
                                break;
                            case 2:
                                adm.deleteQuestions();
                                break;
                            case 3:
                                adm.viewQuestions();
                                break;
                            default:
                                System.out.println("Incorrect option");
                                return;
                        }
                    }
                case 'T':
                    adm.setUpTest(id);
                case 'S':
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Administration adm = new AdministrationImpl();

        int choice;
        String id = null;

        while(true){
            System.out.println("Enter 1 to register as a new user.");
            System.out.println("Enter 2 if you are already an user.");
            System.out.println("Enter 3 to close the App");
            choice = sc.nextInt();
            System.out.println(choice);
            if (choice == 1) {
                adm.register();
            } else if (choice == 2) {
                id = adm.login();
                roleBasedTask(id);
            } else if (choice == 3) {
                System.out.println("Closed");
                return;
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}