package crud;

import entities.Zone;

import java.sql.SQLException;
import java.util.List;

public interface ZoneDAO {
    public int addZone(Zone zone) throws SQLException;
    public Zone viewZone(int id) throws SQLException;
    public List<Zone> viewZones() throws SQLException;
    public void removeZone(int id) throws SQLException;
    public void updateZone(Zone zone) throws SQLException;
}
