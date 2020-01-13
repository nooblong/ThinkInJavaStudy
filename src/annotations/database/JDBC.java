package annotations.database;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        getConnection();
    }

    public static void execute(String s){
        Connection c = getConnection();
        try {
            Statement statement = c.createStatement();
            statement.execute(s);
            System.out.println("execute successful");
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("java.util.Arrays");
            connection = DriverManager.getConnection("jdbc:mysql://134.175.52.170:3306/?serverTimezone=UTC", "root",
                    "12345678");
//            s.execute("insert into class(sname) values(\"shabi\");");
//            ResultSet rs = s.executeQuery("select * from class;");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
