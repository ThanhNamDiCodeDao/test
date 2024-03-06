package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {
            // Corrected JDBC connection URL for SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Fruit;encrypt=true;trustServerCertificate=true";
            String username = "sa";
            String password = "nam123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
