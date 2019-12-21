package annotations.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306?serverTimezone=UTC", "root", "123456");
            Statement s = connection.createStatement();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
