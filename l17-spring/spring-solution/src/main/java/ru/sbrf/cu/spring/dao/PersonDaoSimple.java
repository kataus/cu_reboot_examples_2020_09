package ru.sbrf.cu.spring.dao;

import ru.sbrf.cu.spring.domain.Person;

public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 18);
    }
}
