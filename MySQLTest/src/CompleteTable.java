import java.sql.*;

public class CompleteTable {

    public void show(String url, String query) {
        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connection to MySQL has been established.");

            Statement sts = conn.createStatement();
            ResultSet rs = sts.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("id") + " - " + rs.getString("name")
                        + " - " + rs.getString("dept") + " - " + rs.getString("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void agrega(String url, String query) {
        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connection to MySQL has been established");

            Statement sts = conn.createStatement();
            sts.executeUpdate(query);
            System.out.println("Record has been inserted/Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
