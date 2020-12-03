package ru.sbrf.cu.spring.dao;

import org.springframework.stereotype.Component;
import ru.sbrf.cu.spring.domain.Person;

@Component
public class PersonDaoSimple implements PersonDao {

    public Person findByName( String name ) {
        return new Person( name, 18 );
    }
}
