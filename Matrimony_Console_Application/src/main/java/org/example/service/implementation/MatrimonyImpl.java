package org.example.service.implementation;

import org.example.model.User;
import org.example.repository.UserDatabase;
import org.example.repository.implementation.UserDatabaseImpl;
import org.example.service.Matrimony;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class MatrimonyImpl implements Matrimony {
    Scanner sc = new Scanner(System.in);
    UserDatabase userDatabase = new UserDatabaseImpl();

    @Override
    public void addUser() {
        System.out.println("===== Warm Greetings form Kongu Matrimony =====");
        System.out.println("Please Enter the following details");
        System.out.println("1. Please Enter your Name:");
        String name = sc.nextLine();
        System.out.println("2. Please Enter you Date of Birth (Format: YYYY-MM-DD):");
        String dob = sc.nextLine();
        System.out.println("3. Please Enter your Gender:");
        System.out.println("If male enter 1, 0 for female");
        int ch = sc.nextInt();
        boolean gender;
        gender = ch == 1;
        sc.nextLine();
        System.out.println("4. Please Enter your Phone Number:");
        String phone = sc.nextLine();
        System.out.println("5. Please Enter your Occupation:");
        String occupation = sc.nextLine();
        System.out.println("6. Please Enter your Salary:");
        int salary = sc.nextInt();
        sc.nextLine();
        System.out.println("7. Please enter your Location:");
        String location = sc.nextLine();
        System.out.println("6. Please Enter your Asset Value (in Lakhs):");
        String asset = sc.nextLine();
        userDatabase.setUser(name, dob, gender, phone, occupation, salary, location, asset);
    }

    @Override
    public void displayDetails() {
        for(Map.Entry<Integer, User> entry : userDatabase.getUserDetails().entrySet()){
            System.out.println("User Id: " + entry.getKey());
            System.out.println("User Name: " +  entry.getValue().getUserName());
            System.out.println("Age: " + entry.getValue().getAge());
            System.out.println("Date of Birth: " + entry.getValue().getDateOfBirth());
            System.out.println("Phone: " + entry.getValue().getPhone());
            System.out.println("Occupation: " + entry.getValue().getOccupation());
            System.out.println("Marital Status: " + entry.getValue().isMaritalStatus());
            System.out.println("Salary: " + entry.getValue().getSalary());
            System.out.println("Asset: " + entry.getValue().getAsset());
            System.out.println("================================================");
        }
    }

    @Override
    public void updateDetails() {
        System.out.println("Enter your User Id to update");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Please Re-Enter the following details to Update");
        System.out.println("1. Please Enter your Name:");
        String name = sc.nextLine();
        System.out.println("2. Please Enter you Date of Birth (Format: YYYY-MM-DD):");
        String dob = sc.nextLine();
        System.out.println("3. Please Enter your Phone Number:");
        String phone = sc.nextLine();
        System.out.println("4. Please Enter your Occupation:");
        String occupation = sc.nextLine();
        System.out.println("5. Please Enter your Salary:");
        int salary = sc.nextInt();
        sc.nextLine();
        System.out.println("6. Please Enter your Current location:");
        String location = sc.nextLine();
        System.out.println("7. Please Enter your Asset Value (in Lakhs):");
        String asset = sc.nextLine();
        boolean gender;
        gender = userDatabase.getUserDetails().get(id).isGender();
        userDatabase.UpdateUser(id, name, dob, gender, phone, occupation, salary, location, asset);
        System.out.println("================================================");
    }

    @Override
    public void updateMaritalStatus() {
        System.out.println("Enter your User Id to update");
        int id = sc.nextInt();
        boolean status = userDatabase.getUserDetails().get(id).isMaritalStatus();
        if(!status){
            System.out.println("Your Marital Status is marked as Non-married");
        }
        else {
            System.out.println("Your Marital Status is marked as Married");
        }
        System.out.println("Are you sure?, you want to change marital status");
        System.out.println("1. Yes, I want to Change my marital status");
        System.out.println("0. No, The current status is correct, I don't want to change");
        int choice = sc.nextInt();
        if(choice == 1) userDatabase.getUserDetails().get(id).setMaritalStatus(!status);
        System.out.println("======================== Updated Completely ========================");
    }

    @Override
    public void findMatch() {
        System.out.println("Please Enter your id to proceed");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(userDatabase.getUserDetails());
        for (Map.Entry<Integer, User> entry : userDatabase.getUserDetails().entrySet()){
            if(entry.getValue().isGender() != userDatabase.getUserRequirements().get(id).isReqGender() && (!entry.getValue().isMaritalStatus())
                    && (entry.getValue().getAge() <= userDatabase.getUserRequirements().get(id).getMaxAge() && entry.getValue().getAge() >= userDatabase.getUserRequirements().get(id).getMinAge())
                    && (entry.getValue().getSalary() >= userDatabase.getUserRequirements().get(id).getReqSalary()
                    || Objects.equals(entry.getValue().getOccupation(), userDatabase.getUserRequirements().get(id).getReqOccupation())
                    || Objects.equals(entry.getValue().getLocation(), userDatabase.getUserRequirements().get(id).getReqLocation())))
            {
                System.out.println("You have found some matches !!!");
                System.out.println("User Id: " + entry.getKey());
                System.out.println("User Name: " +  entry.getValue().getUserName());
                System.out.println("Age: " + entry.getValue().getAge());
                System.out.println("Date of Birth: " + entry.getValue().getDateOfBirth());
                System.out.println("Phone: " + entry.getValue().getPhone());
                System.out.println("Occupation: " + entry.getValue().getOccupation());
                System.out.println("Marital Status: " + entry.getValue().isMaritalStatus());
                System.out.println("Salary: " + entry.getValue().getSalary());
                System.out.println("Asset: " + entry.getValue().getAsset());
                System.out.println("================================================");
            }
        }
    }

    @Override
    public void exit() {
        System.out.println("==============================================");
        System.out.println("======== Thanks for using our Service ========");
        System.out.println("=========== Always here to help you ==========");
        System.out.println("==============================================");
    }
}
