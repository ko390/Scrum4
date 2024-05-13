package crud;

import entities.Band;

import java.sql.SQLException;

public interface BandDAO {
    public int generateBands(Band band) throws SQLException;
    public Band viewBands(int id) throws SQLException;
    public Band hireBands(int id) throws SQLException;

}
