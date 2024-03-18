package main.org.example.repository.implementation;

import main.org.example.model.Employee;
import main.org.example.model.system.EmployeeManagementSystem;
import main.org.example.repository.EmployeeRepo;
import main.org.example.service.EmployeeManagement;

import java.util.Map;
import java.util.Scanner;

public class EmployeeRepoImpl implements EmployeeRepo {
    Scanner sc = new Scanner(System.in);
    EmployeeManagementSystem empList;
    Employee newEmp;
    @Override
    public void search(int employeeId) {
        if(empList.getEmployeeList().containsKey(employeeId)){
            System.out.println("The Employee with id " + employeeId + " is Present");
            System.out.print(employeeId + " ");
            System.out.println("Employee Name: " + empList.getEmployeeList().get(employeeId).getEmployeeName());
            System.out.println("Employee Position: " + empList.getEmployeeList().get(employeeId).getPosition());
        }
        else{
            System.out.println("No Employee with the Id " + employeeId + " in the System");
        }
    }

    @Override
    public void search(String EmployeeDetails) {
        for(Map.Entry<Integer, Employee> entry : empList.getEmployeeList().entrySet()){
            if(entry.getValue().getEmployeeName().equals(EmployeeDetails) || entry.getValue().getPosition().equals(EmployeeDetails)){
                System.out.println("Employee with details provided is present");
                System.out.print(entry.getKey() + " ");
                System.out.println("Employee Name: " + entry.getValue().getEmployeeName());
                System.out.println("Employee Position: " + entry.getValue().getPosition());
                System.out.println("-------------------------------");
            }
            else{
                System.out.println("Employee with details provided is not present");
            }
        }
    }

    @Override
    public void update(int employeeId, int choice) {
        switch (choice){
            case 1:
                String Name = sc.nextLine();
                empList.getEmployeeList().get(employeeId).setEmployeeName(Name);
                break;
            case 2:
                String position = sc.nextLine();
                empList.getEmployeeList().get(employeeId).setPosition(position);
                break;
            case 3:
                String Name1 = sc.nextLine();
                String position1 = sc.nextLine();
                empList.getEmployeeList().get(employeeId).setEmployeeName(Name1);
                empList.getEmployeeList().get(employeeId).setPosition(position1);
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }
}
