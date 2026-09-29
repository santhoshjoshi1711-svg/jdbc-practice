import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "oracle";
        String password = "YOUR_PASSWORD";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
