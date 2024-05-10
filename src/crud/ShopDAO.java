package crud;

import java.sql.SQLException;

public interface ShopDAO {
    public void addItem(ShopCRUD shopCRUD) throws SQLException;
    public void viewItems(ShopCRUD shopCRUD) throws SQLException;
    public void removeItem(ShopCRUD shopCRUD) throws SQLException;
    public void updateItem(ShopCRUD shopCRUD) throws SQLException;
    

}
