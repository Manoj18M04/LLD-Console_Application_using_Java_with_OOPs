package org.example.model;

public class Requirements {
    private int id;
    private int maxAge;
    private int minAge;
    private String occupation;
    private int salary;
    private String location;
    private boolean gender;

    public int getMaxAge() {
        return maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public boolean isReqGender() {
        return gender;
    }

    public String getReqOccupation() {
        return occupation;
    }

    public int getReqSalary() {
        return salary;
    }

    public String getReqLocation() {
        return location;
    }

    public Requirements(int minAge, int maxAge, String occupation, int salary, String location) {
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.occupation = occupation;
        this.salary = salary;
        this.location = location;
    }
}
