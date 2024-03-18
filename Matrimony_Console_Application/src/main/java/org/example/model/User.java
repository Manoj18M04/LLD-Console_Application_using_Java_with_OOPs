package org.example.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class User {
    private String userName;
    private String occupation;
    private String dateOfBirth;
    private boolean gender;
    private String location;
    private int salary;
    private boolean maritalStatus;
    private String phone;
    private String asset;
    private int age;


    public User(String userName, String dateOfBirth, boolean gender, String phone, String occupation, int salary, String location, String asset) {
        Scanner sc = new Scanner(System.in);
        this.userName = userName;
        this.occupation = occupation;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.maritalStatus = false;
        this.phone = phone;
        this.asset = asset;
        this.location = location;
        this.gender = gender;
        calculateAge(dateOfBirth);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


    public int getSalary() {
        return salary;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhone() {
        return phone;
    }


    public String getAsset() {
        return asset;
    }


    public void calculateAge(String dateOfBirth){
        LocalDate dob = LocalDate.parse(dateOfBirth);
        LocalDate curr = LocalDate.now();
        setAge( Period.between(dob, curr).getYears());
    }
}
