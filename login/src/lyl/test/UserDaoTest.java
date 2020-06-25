package lyl.test;

import lyl.dao.UserDao;
import lyl.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){

        User user = new User();
        user.setUsername("lyl");
        user.setPassword("fuck1");

        UserDao dao = new UserDao();
        User userAfter = dao.login(user);

        System.out.println(userAfter);
    }

}
