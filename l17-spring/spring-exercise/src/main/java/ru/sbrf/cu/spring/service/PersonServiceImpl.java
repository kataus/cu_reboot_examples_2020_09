package ru.sbrf.cu.spring.service;

import org.springframework.stereotype.Service;
import ru.sbrf.cu.spring.dao.PersonDao;
import ru.sbrf.cu.spring.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao dao;

    public PersonServiceImpl( PersonDao dao ) {
        this.dao = dao;
    }

    public Person getByName( String name ) {
        return dao.findByName( name );
    }
}
