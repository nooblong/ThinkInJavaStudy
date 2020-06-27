package table.service.impl;

import table.dao.UserDao;
import table.dao.impl.UserDaoImpl;
import table.domain.User;
import table.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        /**
         * 调用dao完成查询
         */
        return userDao.findAll();
    }
}
