package org.example.repository;

import org.example.model.Requirements;
import org.example.model.User;

import java.util.Map;

public interface UserDatabase {
    void setUser(String name, String dob, boolean gender, String phone, String occupation, int salary, String location, String asset);
    void display();
    void UpdateUser(int id, String name, String dob, boolean gender, String phone, String occupation, int salary, String location, String asset);
    Map<Integer, User> getUserDetails();
    Map<Integer, Requirements> getUserRequirements();

}
