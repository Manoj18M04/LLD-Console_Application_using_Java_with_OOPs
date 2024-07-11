package org.example.Service.Implementation;

import org.example.Repository.Implementation.ManagementImpl;
import org.example.Repository.Management;
import org.example.Service.Administration;

import java.util.Scanner;

public class AdministrationImpl implements Administration {

    Management mngmnt = new ManagementImpl();
    @Override
    public void register() {

        System.out.println("Register Page");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter your Name:");
        String name = sc.next();
        System.out.println("For which role are you registering ?");
        System.out.println("Enter 1 for Admin, Enter 2 for Trainer, Enter 3 for Student.");
        int roleChoice = sc.nextInt();
        String role;
        switch (roleChoice){
            case 1:
                role = "Admin";
                break;
            case 2:
                role = "Trainer";
                break;
            case 3:
                role = "Student";
                break;
            default:
                System.out.println("You have entered an invalid choice. Please enter any one from below.");
                return;
        }
        System.out.println("Enter your Password for Log in later");
        String password = sc.next();
        mngmnt.registerUser(role, name, password);
    }

    @Override
    public String login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your user id:");
        String userId = sc.next();
        System.out.println("Enter your Password:");
        String password = sc.next();
        String id = mngmnt.validateUser(userId, password);
        return id;
    }

    public void addQuestions(){
        Scanner sc = new Scanner(System.in);
        String ques;
        String oA;
        String oB;
        String oC;
        String oD;
        String ans;
        String diff = null;
        System.out.println("Please Enter the Question");
        ques = sc.nextLine();
        System.out.println("Please give option - A");
        oA = sc.nextLine();
        System.out.println("Please give option - B");
        oB = sc.nextLine();
        System.out.println("Please give option - C");
        oC = sc.nextLine();
        System.out.println("Please give option - D");
        oD = sc.nextLine();
        System.out.println("Please give the correct answer");
        ans = sc.nextLine();
        System.out.println("Select Difficulty level");
        System.out.println("1 for easy, 2 for medium, 3 for hard");
        int option = sc.nextInt();
        diff = switch (option) {
            case 1 -> "Easy";
            case 2 -> "Medium";
            case 3 -> "Hard";
            default -> diff;
        };
        mngmnt.addQuestion(ques, oA, oB, oC, oD, ans, diff);
    }

    @Override
    public void deleteQuestions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the question number to delete");
        int num = sc.nextInt();
        mngmnt.deleteQuestion(num);
    }

    @Override
    public void viewQuestions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You want to see all the questions or any specific questions ?");
        System.out.println("Enter 1 to see all the questions");
        System.out.println("Enter 2 to see any specific question");
        int choice = sc.nextInt();
        mngmnt.viewQuestion(choice);
    }

    @Override
    public void setUpTest(String userId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many questions are has to be in the test ?");
        int noOfQuestions = sc.nextInt();
        System.out.println("How many previous test's questions that you want to exclude");
        int noOfTestToBeOmitted = sc.nextInt();
        mngmnt.setUpTest(userId, noOfQuestions, noOfTestToBeOmitted);
    }
}