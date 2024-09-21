import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/microproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "jacob";
    Statement s;

    public static void main(String[] args) {
        try {
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement s = conn.createStatement();

            System.out.println("Connected to database successfully!"); 
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}