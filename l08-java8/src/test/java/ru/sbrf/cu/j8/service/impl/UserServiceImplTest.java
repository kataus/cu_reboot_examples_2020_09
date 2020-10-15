package ru.sbrf.cu.j8.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sbrf.cu.j8.model.User;
import ru.sbrf.cu.j8.service.UserService;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Сервис работы с пользователями")
class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();

    @DisplayName("должен возвращать имя запрашиваемого пользователя, если он есть")
    @Test
    public void getUserNameIfExists(){
        String userName = userService.getUserName(1);
        assertNotNull(userName);
        assertEquals("Иван",userName);
    }

    @DisplayName("должен возвращать 'не найдено', если запрашиваемого пользователя нет")
    @Test
    public void getNotFoundIfUserNotExists(){
        String userName = userService.getUserName(-1);
        assertNotNull(userName);
        assertEquals("не найдено",userName);
    }

    @DisplayName("корректно возвращать список активных пользователей")
    @Test
    public void checkActiveUsers(){
        List<String> names = userService.getActiveUsersName();
        assertNotNull(names);
        assertEquals(5, names.size());
    }

    @DisplayName("корректно возвращать список уникальных активных имен")
    @Test
    public void checkActiveName(){
        Collection<String> names = userService.getActiveNames();
        assertNotNull(names);
        assertEquals(4, names.size());
    }

}