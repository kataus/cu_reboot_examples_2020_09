package ru.sbrf.cu.j8.service;

import ru.sbrf.cu.j8.model.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    List<User> getActiveUsers();

    /**
     * Возвращает имя пользователя. Если нет - то "не найдено"
     * @param id
     * @return
     */
    String getUserName(Integer id);

    //TODO Возвращает имена (firstName) пользователей с active = true
    List<String> getActiveUsersName();

    // TODO Возвращает уникальные имена (fisrtName) пользователей с active = true
    Collection<String> getActiveNames();


    User insert(User user);

    User update(User user);
}
