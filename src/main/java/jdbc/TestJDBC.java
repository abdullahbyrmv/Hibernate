package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "legendonline1";
        String password = "legendonline1";

        try {
            System.out.println("Connecting to Database: " + jdbcUrl);

            Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("Connection Successful!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
