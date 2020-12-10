package ru.sbrf.cu.spring24.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.sbrf.cu.spring24.domain.Person;

import java.util.List;

@Service
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAllByName( String name);
}
