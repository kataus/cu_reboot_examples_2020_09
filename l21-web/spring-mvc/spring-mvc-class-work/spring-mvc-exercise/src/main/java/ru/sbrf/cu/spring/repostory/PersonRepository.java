package ru.sbrf.cu.spring.repostory;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.sbrf.cu.spring.domain.Person;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    List<Person> findAll();
}
