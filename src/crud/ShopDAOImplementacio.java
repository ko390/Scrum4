package crud;

import entities.ShopItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDAOImplementacio implements ShopDAO{
    static Connection con = Conexion.getConnection();

    @Override
    public int addItem(ShopItem shopitem) throws SQLException {
        String query = "insert into ShopItem(name, price) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, shopitem.getName());
        ps.setDouble(2, shopitem.getPrice());
        ps.executeUpdate();
        // Obtenim claus autogenerades
        ResultSet rs = ps.getGeneratedKeys();
        rs.next(); // Sabem que només n'hi ha una

        int n = rs.getInt(1);
        ps.close();
        rs.close();
        return n;

    }

    @Override
    public ShopItem viewItem(int id) throws SQLException {
        String query = "select * from ShopItem where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        ShopItem shopitem = new ShopItem();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            shopitem.setId(rs.getInt("id"));
            shopitem.setName(rs.getString("name"));
            shopitem.setPrice(rs.getInt("price"));
            shopitem.setNumberSold(rs.getInt("numberSold"));
            shopitem.setTotalPrice(rs.getInt("totalPrice"));
        }
        ps.close();
        rs.close();
        if (check) {
            return shopitem;
        }
        else
            return null;
    }

    @Override
    public List<ShopItem> viewItems() throws SQLException {
        String query = "select * from ShopItem";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<ShopItem> ls = new ArrayList();

        while (rs.next()) {
            ShopItem shopItem = new ShopItem();
            shopItem.setId(rs.getInt("id"));
            shopItem.setName(rs.getString("name"));
            shopItem.setPrice(rs.getDouble("price"));
            shopItem.setNumberSold(rs.getInt("numberSold"));
            shopItem.setTotalPrice(rs.getDouble("totalPrice"));
            ls.add(shopItem);
        }
        ps.close();
        rs.close();
        return ls;
    }

    @Override
    public void removeItem(int id) throws SQLException {
        String query = "delete from ShopItem where id =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void updateItem(ShopItem shopitem) throws SQLException {
        String query= "update ShopItem set id=?, name= ?, price=?, numberSold=?, totalPrice=? where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, shopitem.getId());
        ps.setString(2, shopitem.getName());
        ps.setDouble(3, shopitem.getPrice());
        ps.setInt(4, shopitem.getNumberSold());
        ps.setDouble(5, shopitem.getTotalPrice());
        ps.setInt(6, shopitem.getId());
        ps.executeUpdate();
        ps.close();
    }
}
