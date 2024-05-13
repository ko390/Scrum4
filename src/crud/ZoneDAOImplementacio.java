package crud;

import entities.ShopItem;
import entities.Zone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZoneDAOImplementacio implements ZoneDAO{
    static Connection con = Conexion.getConnection();
    @Override
    public int addZone(Zone zone) throws SQLException {
        String query = "insert into Zone(name, capacity) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, zone.getName());
        ps.setDouble(2, zone.getCapacity());
        ps.executeUpdate();
        // Obtenim claus autogenerades
        ResultSet rs = ps.getGeneratedKeys();
        rs.next(); // Sabem que només n'hi ha una
        int n = rs.getInt(1);
        return n;
    }

    @Override
    public Zone viewZone(int id) throws SQLException {
        String query = "select * from Zone where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Zone zone = new Zone();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            zone.setId(rs.getInt("id"));
            zone.setName(rs.getString("name"));
            zone.setCapacity(rs.getInt("capacity"));
            zone.setVip(rs.getInt("vip"));
        }

        if (check) {
            return zone;
        }
        else
            return null;
    }

    @Override
    public List<Zone> viewZones() throws SQLException {
        String query = "select * from Zone";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Zone> ls = new ArrayList();

        while (rs.next()) {
            Zone zone = new Zone();
            zone.setId(rs.getInt("id"));
            zone.setName(rs.getString("name"));
            zone.setCapacity(rs.getInt("price"));
            zone.setVip(rs.getInt("vip"));
            ls.add(zone);
        }
        return ls;
    }

    @Override
    public void removeZone(int id) throws SQLException {
        String query = "delete from Zone where id =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void updateZone(Zone zone) throws SQLException {
        String query= "update Zone set id=?, name= ?, capacity=?, vip=? where id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, zone.getId());
        ps.setString(2, zone.getName());
        ps.setDouble(3, zone.getCapacity());
        ps.setInt(4, zone.getVip());
        ps.setInt(5, zone.getId());
        ps.executeUpdate();
    }
}
