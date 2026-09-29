import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchProcessingDemo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "oracle";
        String password = "YOUR_PASSWORD";

        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 103);
            ps.setString(2, "Anil");
            ps.setDouble(3, 42000);
            ps.addBatch();

            ps.setInt(1, 104);
            ps.setString(2, "Kiran");
            ps.setDouble(3, 48000);
            ps.addBatch();

            int[] result = ps.executeBatch();

            System.out.println(result.length + " statements executed in batch.");

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
