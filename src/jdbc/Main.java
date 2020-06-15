package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {

//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
//                "root","123456");
//        String sql = "update courses set PreCno = 1 where Cno = \"C1\"";
//        Statement statement = c.createStatement();
//        int count = statement.executeUpdate(sql);
//        System.out.println(count);
//        statement.close();
//        c.close();

        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
