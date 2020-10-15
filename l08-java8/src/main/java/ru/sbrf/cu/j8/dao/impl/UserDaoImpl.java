package ru.sbrf.cu.j8.dao.impl;

import ru.sbrf.cu.j8.dao.UserDao;
import ru.sbrf.cu.j8.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {
    private final List<User> users;

    private final Map<Integer, User> userMap;

    public UserDaoImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1, "Иван", "Иванов", true));
        users.add(new User(2, "Иван", "Петров", true));
        users.add(new User(3, "Иван", "Сидоров", false));
        users.add(new User(4, "Петр", "Петров", true));
        users.add(new User(5, "Александр", "Тестов", false));
        users.add(new User(6, "Ольга", "Иванова", true));
        users.add(new User(7, "Алексей", "Александров", true));


        userMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }

    @Override
    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public Optional<User> getById(Integer id) {
        // TODO - 1. сделать корректное создание результата
        User user = null;
        for (User item : users){
            if (id == item.getId()){
                user = item;
                break;
            }
        }
        return Optional.ofNullable(user);
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
