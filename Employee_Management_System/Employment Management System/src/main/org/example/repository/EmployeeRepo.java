package main.org.example.repository;

public interface EmployeeRepo {
    public void search(int EmployeeId);
    public void search(String EmployeeName);
    public void update(int employeeId, int choice);

}
