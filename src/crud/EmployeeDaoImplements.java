package crud;

import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImplements implements EmployeeDAO {
    static Connection con = Conexion.getConnection();

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO Employee (name, surname, age, dni, job, pay) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSurname());
        ps.setInt(3, employee.getAge());
        ps.setString(4, employee.getDni());
        ps.setString(5, employee.getJob());
        ps.setDouble(6, employee.getPay());

        ps.executeUpdate();
        System.out.println("Employee added successfully to the database.");
    }

    @Override
    public void viewEmployee(Employee employee) throws SQLException {
        String query = "SELECT * FROM Employee";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        System.out.println("List of employees:");
        System.out.println("ID | Name | Surname | Age | DNI | Job | Pay");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            String dni = rs.getString("dni");
            String job = rs.getString("job");
            double pay = rs.getDouble("pay");
            System.out.println(id + " | " + name + " | " + surname + " | " + age + " | " + dni + " | " + job + " | " + pay);
        }
    }

    @Override
    public void removeEmployee(Employee employee) throws SQLException {
        String query = "DELETE FROM Employee WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, employee.getId());

        int deletedRows = ps.executeUpdate();
        if (deletedRows > 0) {
            System.out.println("Employee removed successfully from the database.");
        } else {
            System.out.println("Employee with ID " + employee.getId() + " not found in the database.");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE Employee SET name = ?, surname = ?, age = ?, dni = ?, job = ?, pay = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, employee.getName());
        ps.setString(2, employee.getSurname());
        ps.setInt(3, employee.getAge());
        ps.setString(4, employee.getDni());
        ps.setString(5, employee.getJob());
        ps.setDouble(6, employee.getPay());
        ps.setInt(7, employee.getId());

        int updatedRows = ps.executeUpdate();
        if (updatedRows > 0) {
            System.out.println("Employee updated successfully in the database.");
        } else {
            System.out.println("Employee with ID " + employee.getId() + " not found in the database.");
        }
    }
}

