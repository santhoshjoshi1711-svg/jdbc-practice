import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CRUDDemo {
    static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    static String username = "oracle";
    static String password = "YOUR_PASSWORD";

    public static void main(String[] args) {
        insertEmployee(102, "Rahul", 40000);
        updateEmployee(102, "Rahul Kumar", 50000);
        deleteEmployee(102);
    }

    static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, username, password);
    }

    static void insertEmployee(int id, String name, double salary) {
        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            System.out.println(ps.executeUpdate() + " record inserted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void updateEmployee(int id, String name, double salary) {
        String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, id);

            System.out.println(ps.executeUpdate() + " record updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            System.out.println(ps.executeUpdate() + " record deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
