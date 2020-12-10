package ru.sbrf.cu.spring24.repostory;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.cu.spring24.domain.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();

    Person findByName(String s);
}
