import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // 1. Database Credentials
        String url = "jdbc:mysql://localhost:3306/dbmsl?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "F0rdmib@1234"; // Enter your password if you have one

        System.out.println("-------- MySQL JDBC Connection Testing --------");

        // 2. Explicitly load the driver to verify the JAR is active
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Step 1: MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Step 1 Failure: MySQL JDBC Driver not found. Check your Referenced Libraries!");
            e.printStackTrace();
            return;
        }

        // 3. Attempt Connection
        System.out.println("Step 2: Connecting to database...");
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Step 3: Success! Connected to 'dbmsl' database.");
                
                // Optional: Print database metadata to confirm
                System.out.println("Connected to: " + connection.getMetaData().getDatabaseProductVersion());
            } else {
                System.out.println("Step 3 Failure: Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Step 3 Failure: Connection Error!");
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}