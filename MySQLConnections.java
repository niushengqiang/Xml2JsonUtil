package test.cyberhouse;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnections {
    private String driver = "";
    private String dbURL = "";
    private String user = "";
    private String password = "";
    private static MySQLConnections connection = null;

    private MySQLConnections() throws Exception {
        driver = "com.mysql.jdbc.Driver";
        dbURL = "jdbc:mysql://127.0.0.1:3306/ceshi";
        user = "root";
        password = "root";
        System.out.println("dbURL:" + dbURL);
    }

    public static Connection getConnection() {
        Connection conn = null;
        if (connection == null) {
            try {
                connection = new MySQLConnections();
                System.out.println(connection);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            Class.forName(connection.driver);
            conn = DriverManager.getConnection(connection.dbURL,
                    connection.user, connection.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}