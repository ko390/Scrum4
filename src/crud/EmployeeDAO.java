package crud;

import entities.Employee;

import java.sql.SQLException;

public interface EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException;
    public void viewEmployee(Employee employee) throws SQLException;
    public void removeEmployee(Employee employee) throws SQLException;
    public void updateEmployee(Employee employee) throws SQLException;
}
