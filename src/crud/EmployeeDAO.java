package crud;

import java.sql.SQLException;

public interface EmployeeDAO {
    public void addEmployee(EmployeeCRUD employeeCRUD) throws SQLException;
    public void viewEmployee(EmployeeCRUD employeeCRUD) throws SQLException;
    public void removeEmployee(EmployeeCRUD employeeCRUD) throws SQLException;
    public void updateEmployee(EmployeeCRUD employeeCRUD) throws SQLException;
}
