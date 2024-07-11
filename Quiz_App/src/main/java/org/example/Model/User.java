package org.example.Model;

public class User {
    String userId;
    String role;
    String name;
    String password;

    public User(String userId, String role, String name, String password) {
        this.userId = userId;
        this.role = role;
        this.name = name;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
}