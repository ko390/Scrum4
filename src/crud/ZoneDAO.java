package crud;

import entities.Zone;

import java.sql.SQLException;

public interface ZoneDAO {
    public void addZone(ZoneCRUD zoneCRUD) throws SQLException;
    public void viewZone(ZoneCRUD zoneCRUD) throws SQLException;
    public void removeZone(ZoneCRUD zoneCRUD) throws SQLException;
    public void updateZone(ZoneCRUD zoneCRUD) throws SQLException;
}
