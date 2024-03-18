package main.org.example.service.implementation;

import main.org.example.model.Employee;
import main.org.example.model.system.EmployeeManagementSystem;
import main.org.example.repository.EmployeeRepo;
import main.org.example.repository.implementation.EmployeeRepoImpl;
import main.org.example.service.EmployeeManagement;

import java.util.Map;
import java.util.Scanner;

public class EmployeeManagementImpl implements EmployeeManagement {
    Scanner sc = new Scanner(System.in);
    int index = 0;
    EmployeeManagementSystem employee;
    EmployeeRepo empRepo = new EmployeeRepoImpl();
    Employee newEmp;
    @Override
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Employee:");
        String employeeName = sc.nextLine();
        System.out.println("Enter the position of the Employee");
        String position = sc.nextLine();
        System.out.println();
        index++;
        Employee newEmp = new Employee(employeeName, position);
        EmployeeManagementSystem employee = new EmployeeManagementSystem(index, newEmp);
    }


    @Override
    public void deleteEmployee(int employeeId) {
        employee.getEmployeeList().remove(employeeId);
        System.out.println("---------- Employee with id " + employeeId + " has deleted successfully ----------");
    }

    @Override
    public void displayEmployees() {
        for(Map.Entry<Integer, Employee> entry : employee.getEmployeeList().entrySet()){
            System.out.print(entry.getKey() + " ");
            System.out.println("Employee Name: " + entry.getValue().getEmployeeName());
            System.out.println("Employee Position: " + entry.getValue().getPosition());
            System.out.println("------------------------------------");
        }
    }

    @Override
    public void searchEmployee() {
        System.out.println("Have to search employee with a id or Name or Position");
        System.out.println("1 for search employee with employee 1d");
        System.out.println("2 for search employee with employee name");
        System.out.println("3 for search employee with employee position");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                int employeeId = sc.nextInt();
                empRepo.search(employeeId);
                break;
            case 2,3:
                String name = sc.nextLine();
                empRepo.search(name);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    @Override
    public void updateEmployee(int employeeId) {
        System.out.println("What has to be updated");
        System.out.println("1 for update Name");
        System.out.println("2 for update Position");
        System.out.println("3 for update both");
        int choice = sc.nextInt();
        empRepo.update(employeeId, choice);
    }

    @Override
    public void attendance(int employeeId) {
        System.out.println("Not implemented still");
    }
}
