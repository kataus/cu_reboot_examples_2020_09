package ru.sbrf.cu.j8.dao.impl;

import ru.sbrf.cu.j8.dao.UserDao;
import ru.sbrf.cu.j8.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final List<User> users;

    public UserDaoImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1, "Иван", "Иванов", true));
        users.add(new User(2, "Иван", "Петров", true));
        users.add(new User(3, "Иван", "Сидоров", false));
        users.add(new User(4, "Петр", "Петров", true));
        users.add(new User(5, "Александр", "Тестов", false));
        users.add(new User(6, "Ольга", "Иванова", true));
        users.add(new User(7, "Алексей", "Александров", true));
    }

    @Override
    public List<User> getAll() {
        //TODO что тут неправильно и опасно?
        return users;
    }

    @Override
    public Optional<User> getById(Integer id) {
        // TODO - 1. сделать корректное создание результата
        return Optional.empty();
    }

    @Override
    public User update(User user) {
        // TODO - 1. Решить используя getById
        return null;
    }

    @Override
    public User insert(User user) {
        // TODO - 2. Решить используя getById и определяя свежий Id
        return null;
    }
}
