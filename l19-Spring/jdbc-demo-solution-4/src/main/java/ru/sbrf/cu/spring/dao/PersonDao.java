package ru.sbrf.cu.spring.dao;

import ru.sbrf.cu.spring.domain.Person;

public interface PersonDao {

    int count();

    void insert(Person person);
}
