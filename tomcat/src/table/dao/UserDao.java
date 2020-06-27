package table.dao;

import table.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
