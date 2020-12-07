package ru.sbrf.cu.spring.dao;

import ru.sbrf.cu.spring.domain.Person;

public interface PersonDao {
    int count();

    void insert(Person person);

    long insert2(Person person);

    Person getById(long id);

    Person getByName(String name);

    void deleteById(long id);
}
