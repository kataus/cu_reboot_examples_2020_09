package ru.sbrf.cu.spring.rest;

import ru.sbrf.cu.spring.repostory.PersonRepository;

public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }
}
