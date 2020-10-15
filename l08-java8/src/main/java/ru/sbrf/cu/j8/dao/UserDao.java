package ru.sbrf.cu.j8.dao;

import ru.sbrf.cu.j8.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAll();

    Optional<User> getById(Integer id);

    User update(User user);

    User insert(User user);
}
