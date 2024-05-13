package crud;

import entities.ShopItem;

import java.sql.SQLException;
import java.util.List;

public interface ShopDAO {
    public int addItem(ShopItem shopitem) throws SQLException;
    public ShopItem viewItem(int id) throws SQLException;
    public List<ShopItem> viewItems() throws SQLException;
    public void removeItem(int id) throws SQLException;
    public void updateItem(ShopItem shopitem) throws SQLException;
    

}
