package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(new ComboPooledDataSource());
        
    }
}
