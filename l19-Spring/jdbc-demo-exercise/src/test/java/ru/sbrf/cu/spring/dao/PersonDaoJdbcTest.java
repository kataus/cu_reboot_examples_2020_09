package ru.sbrf.cu.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.sbrf.cu.spring.dao.PersonDaoJdbc;
import ru.sbrf.cu.spring.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@DisplayName("Проверяем данные в БД: ")
@JdbcTest
@Import(PersonDaoJdbc.class)
public class PersonDaoJdbcTest {

    @Autowired
    private PersonDaoJdbc dao;

    @DisplayName("а есть ли Маша?")
    @Test
    public void checkMasha(){
        Person person = dao.getById(1);
        assertNotNull(person);
    }

    @DisplayName("а есть ли Вася?")
    @Test
    public void checkVasia(){
        Person person = dao.getByName("vasya");
        assertNotNull(person);
    }
}
