package ru.sbrf.cu.j8.service.impl;

import ru.sbrf.cu.j8.dao.UserDao;
import ru.sbrf.cu.j8.dao.impl.UserDaoImpl;
import ru.sbrf.cu.j8.model.User;
import ru.sbrf.cu.j8.service.UserService;

import java.util.Collection;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public String getUserName(Integer id) {
        // TODO 1 - optional
        return null;
    }

    @Override
    public List<User> getActiveUsers() {
        // TODO 2 - streams
        return null;
    }

    @Override
    public List<String> getActiveUsersName() {
        // TODO 2 - streams
        return null;
    }

    @Override
    public Collection<String> getActiveNames() {
        // TODO 2 - streams
        return null;
    }

    @Override
    public User insert(User user) {
        // TODO 2 - streams
        return null;
    }

    @Override
    public User update(User user) {
        // TODO 2 - streams
        return null;
    }
}
