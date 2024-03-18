package main.org.example.controller;

import main.org.example.service.EmployeeManagement;
import main.org.example.service.implementation.EmployeeManagementImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcome();
        EmployeeManagement emp = new EmployeeManagementImpl();
        application(sc, emp);
    }
    public static void welcome(){
        System.out.println("--------------- Welcome !!! --------------");
    }
    public static void application(Scanner sc, EmployeeManagement emp){
        while(true){
            System.out.println("-------- Select a option from the below list of tasks to execute ----------");
            System.out.println("1) Add Employee Details ------------->");
            System.out.println("2) Delete Employee Details ---------->");
            System.out.println("3) Update Employee Details ---------->");
            System.out.println("4) Display Employee Details --------->");
            System.out.println("5) Search Employee ------------------>");
            System.out.println("6) Track Attendance ----------------->");
            System.out.println("Any other number to exit ------------>");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    emp.addEmployee();
                    break;
                case 2:
                    System.out.println("Enter the Employee Id to be deleted");
                    int deleteId = sc.nextInt();
                    emp.deleteEmployee(deleteId);
                    break;
                case 3:
                    System.out.println("Enter the Employee Id to be updated");
                    int updateId = sc.nextInt();
                    emp.updateEmployee(updateId);
                    break;
                case 4:
                    emp.displayEmployees();
                    break;
                case 5:
                    emp.searchEmployee();
                    break;
                case 6:
                    System.out.println("Enter the Employee Id to check attendance");
                    int attendanceId = sc.nextInt();
                    emp.attendance(attendanceId);
                    break;
                default:
                    return;
            }
        }
    }
}
