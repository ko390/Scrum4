package crud;

import java.sql.SQLException;

public interface ClientDAO {
    public void addClient(ClientCRUD clientCRUD) throws SQLException;
    public void viewClients(ClientCRUD clientCRUD) throws SQLException;
    public void removeClient(ClientCRUD clientCRUD) throws SQLException;
    public void updateClient(ClientCRUD clientCRUD) throws SQLException;
}
