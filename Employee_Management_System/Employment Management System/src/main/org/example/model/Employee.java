package main.org.example.model;

public class Employee {
    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String EmployeeName;
    private String position;



    public String getEmployeeName() {
        return EmployeeName;
    }

    public String getPosition() {
        return position;
    }

    public Employee(String EmployeeName, String position) {
        this.EmployeeName = EmployeeName;
        this.position = position;
    }
}
