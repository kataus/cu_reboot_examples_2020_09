package ru.sbrf.cu.j8.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sbrf.cu.j8.dao.UserDao;
import ru.sbrf.cu.j8.model.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(" userDao должен")
class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @DisplayName("Возвращать Optional с пользователем внури если есть")
    @Test
    public void getUserExist(){
        Optional<User> optUser = userDao.getById(2);
        assertNotNull(optUser);
        assertTrue(optUser.isPresent());
        assertEquals(2, optUser.get().getId());
    }

    @DisplayName("Возвращать пустой Optional если пользователя нет")
    @Test
    public void getUserNotExist(){
        Optional<User> optUser = userDao.getById(-2);
        assertNotNull(optUser);
        assertFalse(optUser.isPresent());
    }

}