package ru.sbrf.cu.spring.service;

import ru.sbrf.cu.spring.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
