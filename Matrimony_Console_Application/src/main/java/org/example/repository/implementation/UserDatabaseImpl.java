package org.example.repository.implementation;

import org.example.model.Requirements;
import org.example.model.User;
import org.example.repository.UserDatabase;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserDatabaseImpl implements UserDatabase {
    static Map<Integer, User> userDetails = new TreeMap<>();
    static Map<Integer, Requirements> userRequirements = new TreeMap<>();
    Scanner sc = new Scanner(System.in);
    User user;
    Requirements requirements;
    static int id = 0;

    public void setUser(String name, String dob, boolean gender, String phone, String occupation, int salary, String location, String asset){
        int index = id++;
        user = new User(name, dob, gender, phone, occupation, salary, location, asset);
        userDetails.put(index, user);
        System.out.println("Please enter the following details as per your requirements of partner");
        System.out.println("At what age range you are expecting a partner:");
        System.out.println("Should be older than...");
        int minAge = sc.nextInt();
        System.out.println("Should be younger than...");
        int maxAge = sc.nextInt();
        sc.nextLine();
        System.out.println("What is the occupation you expect from your partner");
        String reqOccupation = sc.nextLine();
        System.out.println("How much should your partner expected to earn");
        int reqSalary = sc.nextInt();
        sc.nextLine();
        System.out.println("What location you are ready to look for a partner");
        String reqLocation = sc.nextLine();
        requirements = new Requirements(minAge, maxAge, reqOccupation, reqSalary, reqLocation);
        userRequirements.put(index, requirements);
    }

    public void display(){
        for(Map.Entry<Integer, User> i: userDetails.entrySet()){
            System.out.println(i.getKey()+" "+i.getValue().getUserName());
        }
    }

    @Override
    public void UpdateUser(int id, String name, String dob, boolean gender, String phone, String occupation, int salary, String location, String asset){
        user = new User(name, dob, gender, phone, occupation, salary, location, asset);
        userDetails.put(id, user);
    }

    public Map<Integer, User> getUserDetails() {
        return userDetails;
    }

    public Map<Integer, Requirements> getUserRequirements() {
        return userRequirements;
    }
}
