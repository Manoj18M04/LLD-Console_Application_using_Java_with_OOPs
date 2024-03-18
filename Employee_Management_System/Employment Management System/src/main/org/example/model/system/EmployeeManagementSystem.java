package main.org.example.model.system;

import main.org.example.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManagementSystem {

    public EmployeeManagementSystem(int index, Employee emp) {
        employeeList.put(index, emp);
    }

    public Map<Integer, Employee> getEmployeeList() {
        return employeeList;
    }

    private Map<Integer, Employee> employeeList = new HashMap<>();


}
