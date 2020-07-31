package github.nooblong.dao;

import github.nooblong.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
