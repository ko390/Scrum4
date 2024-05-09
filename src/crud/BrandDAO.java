package crud;

import java.sql.SQLException;

public interface BrandDAO {
    public void generateBands(BrandCRUD brandCRUD) throws SQLException;
    public void viewBands(BrandCRUD brandCRUD) throws SQLException;
    public void hireBands(BrandCRUD brandCRUD) throws SQLException;

}
