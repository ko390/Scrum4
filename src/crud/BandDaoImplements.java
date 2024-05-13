package crud;

import entities.Band;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BandDaoImplements implements BandDAO {
    static Connection con = Conexion.getConnection();

    @Override
    public int generateBands(Band band) throws SQLException {
        String query = "INSERT INTO Band (name, available, genre, country) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, band.getName());
        ps.setBoolean(2, band.isAvailable());
        ps.setString(3, band.getGenre());
        ps.setString(4, band.getCountry());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int n = rs.getInt(1);
        return n;
    }

    @Override
    public Band viewBands(int id) throws SQLException {
        String query = "SELECT * FROM Band WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Band band = new Band();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            band.setId(rs.getInt("id"));
            band.setName(rs.getString("name"));
            band.setAvailable(rs.getBoolean("available"));
            band.setGenre(rs.getString("genre"));
            band.setCountry(rs.getString("country"));

        }
        if (check) {
            return band;
        } else {
            return null;
        }
    }

    @Override
    public Band hireBands(int id) throws SQLException {
        String query = "SELECT * FROM Band WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Band band = new Band();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            band.setId(rs.getInt("id"));
            band.setName(rs.getString("name"));
            band.setAvailable(rs.getBoolean("available"));
            band.setGenre(rs.getString("genre"));
            band.setCountry(rs.getString("country"));

        }
        if (check) {
            return band;
        } else {
            return null;
        }
    }
}
