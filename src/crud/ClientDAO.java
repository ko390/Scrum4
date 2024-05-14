package crud;

import entities.Client;

import java.sql.SQLException;

public interface ClientDAO {
    public void addClient(Client client) throws SQLException;
    public void viewClients(Client client) throws SQLException;
    public void removeClient(Client client) throws SQLException;
    public void updateClient(Client client) throws SQLException;
}
