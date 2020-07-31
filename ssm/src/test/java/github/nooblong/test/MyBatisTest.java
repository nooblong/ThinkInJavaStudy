package github.nooblong.test;

import github.nooblong.dao.IUserDao;
import github.nooblong.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        //使用工厂产生的SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //使用SqlSession创建Dao接口的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users = iUserDao.findAll();
        for (User user : users)
            System.out.println(user);
        //释放资源
        sqlSession.close();
        inputStream.close();
    }
}
