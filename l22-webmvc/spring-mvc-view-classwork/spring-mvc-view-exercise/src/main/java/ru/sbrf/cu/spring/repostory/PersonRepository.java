package ru.sbrf.cu.spring.repostory;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.cu.spring.domain.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();
}
