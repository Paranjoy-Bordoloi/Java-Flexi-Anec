import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbmsl?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "F0rdmib@1234"; // Add your password here

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to dbmsl.");

            // 1. CREATE TABLE
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                    "name VARCHAR(100), " +
                                    "email VARCHAR(100))";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Step 1: Table 'students' is ready.");
            }

            // 2. INSERT DATA (Using PreparedStatement)
            String insertSQL = "INSERT INTO students (name, email) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                // First Insert
                pstmt.setString(1, "Alice Smith");
                pstmt.setString(2, "alice@example.com");
                pstmt.executeUpdate();

                // Second Insert
                pstmt.setString(1, "Bob Jones");
                pstmt.setString(2, "bob@example.com");
                pstmt.executeUpdate();
                
                System.out.println("Step 2: Two records inserted successfully.");
            }

            // 3. RETRIEVE DATA
            String selectSQL = "SELECT id, name, email FROM students";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                
                System.out.println("\nStep 3: Displaying Records:");
                System.out.println("------------------------------------");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println("ID: " + id + " | Name: " + name + " | Email: " + email);
                }
                System.out.println("------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}