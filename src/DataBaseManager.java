import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    public DataBaseConfig params;
    public DataBaseParams database;
    public Connection myConn;

    public DataBaseManager(int portNum) {
        this.params = new DataBaseConfig();
        database = params.getParams(portNum);
        getConnection();
    }

    public int update(String s) throws SQLException {
        PreparedStatement ps = myConn.prepareStatement(s);
        System.out.println(s);
        System.out.println(ps);
        return ps.executeUpdate(s);
    }

    public List select(String s) throws SQLException {
        List<Object> tab = new ArrayList<Object>();
        Statement stm = myConn.createStatement();
        ResultSet res = stm.executeQuery(s);
        ResultSetMetaData meta = res.getMetaData();
        int nbCol = meta.getColumnCount();
        try {
            while (res.next()) {
                Object[] ligne = new Object[nbCol];
                for (int i = 0; i < nbCol; i++) {
                    ligne[i] = res.getObject(i + 1);
                }
                tab.add(ligne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tab;
    }

    public void getConnection() {
        try {
            Class.forName(database.getDriver());
            myConn = DriverManager.getConnection(this.database.getUrl(), this.database.getSession(),
                    this.database.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

