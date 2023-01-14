package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    Connection conn;
    private String host = "localhost";
    private String port = "3306";
    private String dbName = "Spacecrafts";
    private String username = "adminSc";
    private String password = "admin";

    public Connection getConnection(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://" + this.host + ":" + this.port + "/" + this.dbName;
            conn = DriverManager.getConnection(url, this.username, this.password);
            Statement statement = conn.createStatement();
            System.out.println("Connection has been successful");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Failed to connect with database");
        }
        return conn;
    }
}
