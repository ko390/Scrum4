package crud;

import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImplements implements ClientDAO {
    static Connection con = Conexion.getConnection();

    @Override
    public void addClient(Client client) throws SQLException {
        String query = "INSERT INTO Client (name, surname, age, dni, entry_type) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, client.getName());
        ps.setString(2, client.getSurname());
        ps.setInt(3, client.getAge());
        ps.setString(4, client.getDni());
        ps.setString(5, client.getEntryType());

        ps.executeUpdate();
        System.out.println("Client added successfully to the database.");
    }

    @Override
    public void viewClients(Client client) throws SQLException {
        String query = "SELECT * FROM Client";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        System.out.println("Listado de clientes: ");
        System.out.println("ID | Name | Surname | Age | DNI | Entry Type");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            String dni = rs.getString("dni");
            String entryType = rs.getString("entry_type");
            System.out.println(id + " | " + name + " | " + surname + " | " + age + " | " + dni + " | " + entryType);
        }
    }

    @Override
    public void removeClient(Client client) throws SQLException {
        String query = "DELETE FROM Client WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, client.getId());

        int deletedRows = ps.executeUpdate();
        if (deletedRows > 0) {
            System.out.println("Client removed successfully from the database.");
        } else {
            System.out.println("Client with ID " + client.getId() + " not found in the database.");
        }
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        String query = "UPDATE Client SET name = ?, surname = ?, age = ?, dni = ?, entry_type = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, client.getName());
        ps.setString(2, client.getSurname());
        ps.setInt(3, client.getAge());
        ps.setString(4, client.getDni());
        ps.setString(5, client.getEntryType());
        ps.setInt(6, client.getId());

        int updatedRows = ps.executeUpdate();
        if (updatedRows > 0) {
            System.out.println("Client updated successfully in the database.");
        } else {
            System.out.println("Client with ID " + client.getId() + " not found in the database.");
        }
    }
}

