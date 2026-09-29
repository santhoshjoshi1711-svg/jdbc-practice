import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "oracle";
        String password = "YOUR_PASSWORD";

        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);
            ps.setString(2, "Santhosh");
            ps.setDouble(3, 45000);

            int rows = ps.executeUpdate();

            System.out.println(rows + " record inserted successfully!");

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
