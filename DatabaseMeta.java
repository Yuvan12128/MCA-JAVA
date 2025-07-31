import java.sql.Connection; 
import java.sql.DatabaseMetaData; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
public class DatabaseMeta { 
public static void main(String[] args) { 
// Database URL, username, and password (replace with your database details) 
String url = "jdbc:mysql://localhost:3306/db"; 
String username = "root"; 
String password = ""; 
// Establish the connection 
try (Connection connection = DriverManager.getConnection(url, username, password)) { 
// Print connection success message 
System.out.println("Connected to the database successfully!"); 
// Retrieve and print database metadata 
DatabaseMetaData metadata = connection.getMetaData(); 
// Print some useful metadata information 
System.out.println("Database Product Name: " + metadata.getDatabaseProductName()); 
System.out.println("Database Product Version: " + 
metadata.getDatabaseProductVersion()); 
System.out.println("Driver Name: " + metadata.getDriverName()); 
System.out.println("Driver Version: " + metadata.getDriverVersion()); 
System.out.println("JDBC Major Version: " + metadata.getJDBCMajorVersion()); 
System.out.println("JDBC Minor Version: " + metadata.getJDBCMinorVersion()); 
System.out.println("URL: " + metadata.getURL()); 
System.out.println("User Name: " + metadata.getUserName()); 
} catch (SQLException e) { 
System.err.println("Connection failed: " + e.getMessage()); 
} 
} 
} 