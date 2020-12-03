package ru.sbrf.cu.spring.dao;

import ru.sbrf.cu.spring.domain.Person;

public interface PersonDao {

    Person findByName( String name);
}
