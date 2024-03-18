package main.org.example.service;

public interface EmployeeManagement {
    public void addEmployee();
    public void deleteEmployee(int employeeId);
    public void displayEmployees();
    public void updateEmployee(int employeeId);
    public void attendance(int employeeId);
    public void searchEmployee();
}
