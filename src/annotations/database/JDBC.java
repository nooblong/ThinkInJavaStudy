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
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/p?serverTimezone=UTC", "root", "123456");
//            s.execute("insert into class(sname) values(\"shabi\");");
//            ResultSet rs = s.executeQuery("select * from class;");
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
