package org.example.controller;

import org.example.service.Matrimony;
import org.example.service.implementation.MatrimonyImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrimony matrimony = new MatrimonyImpl();
        welcome();
        application(sc, matrimony);
    }
    public static void welcome(){
        System.out.println("==============================================");
        System.out.println("============= Warm Greetings !!! =============");
        System.out.println("==============================================");
    }
    public static void application(Scanner sc, Matrimony matrimony){
        while(true) {
            System.out.println("What are you here for ?");
            System.out.println("1. To register");
            System.out.println("2. Display all the profiles");
            System.out.println("3. Update the details of your Profile");
            System.out.println("4. Change your Marital Status");
            System.out.println("5. Looking for a match");
            System.out.println("Any other numbers to Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    matrimony.addUser();
                    break;
                case 2:
                    matrimony.displayDetails();
                    break;
                case 3:
                    matrimony.updateDetails();
                    break;
                case 4:
                    matrimony.updateMaritalStatus();
                    break;
                case 5:
                    matrimony.findMatch();
                    break;
                default:
                    matrimony.exit();
                    return;
            }
        }
    }

}