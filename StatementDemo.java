import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "oracle";
        String password = "YOUR_PASSWORD";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            String sql = "CREATE TABLE employee (id NUMBER PRIMARY KEY, name VARCHAR2(50), salary NUMBER)";
            st.executeUpdate(sql);

            System.out.println("Table created successfully!");

            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
