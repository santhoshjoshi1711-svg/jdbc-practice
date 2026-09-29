import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "oracle";
        String password = "YOUR_PASSWORD";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(url, username, password);

            // Example assumes an Oracle procedure named GET_EMPLOYEE_COUNT exists.
            CallableStatement cs =
                    con.prepareCall("{call GET_EMPLOYEE_COUNT(?)}");

            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();

            System.out.println("Employee Count: " + cs.getInt(1));

            cs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
