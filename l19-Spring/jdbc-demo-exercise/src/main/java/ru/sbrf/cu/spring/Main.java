package ru.sbrf.cu.spring;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.sbrf.cu.spring.dao.PersonDao;
import ru.sbrf.cu.spring.domain.Person;

import java.sql.SQLException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(Main.class);

        PersonDao dao = context.getBean(PersonDao.class);

        System.out.println(String.format("We have %d persons", dao.count()));

        Person person = new Person(2, "Vasya");
        dao.insert(person);
        person = new Person(3, "Vasya");
        dao.insert(person);

        Person masha = dao.getById(1);
        System.out.println(String.format("User 1: %s", masha.toString()));

        dao.deleteById(2);

        System.out.println(String.format("User 2: %s", dao.getByName("Vasya")));

        Person lena = new Person(0, "Lena");
        long id = dao.insert2(person);

        System.out.println(String.format("User 2: %s", dao.getById(id)));

        System.out.println("All count " + dao.count());

        Console.main(args);
    }
}
