package ru.sbrf.cu.spring24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import ru.sbrf.cu.spring24.domain.Email;
import ru.sbrf.cu.spring24.domain.Person;
import ru.sbrf.cu.spring24.repository.EmailRepository;
import ru.sbrf.cu.spring24.repository.PersonRepository;
//import ru.otus.spring10.repostory.PersonRepository;

import javax.annotation.PostConstruct;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Autowired
    private PersonRepository repository;

    @Autowired
    private EmailRepository emailRepository;

    @PostConstruct
    public void init() {
        repository.save(new Person("Pushkin"));
        repository.save(new Person("Pushkin"));
        repository.save(new Person("Pushkin"));

        System.out.println(repository.findAllByName( "Pushkin" ).toString());

        emailRepository.save( new Email("1@sbrf.ru") );
        emailRepository.save( new Email("9@sbrf.ru") );
        emailRepository.save( new Email("3@sbrf.ru") );
        emailRepository.save( new Email("5@sbrf.ru") );

        System.out.println(emailRepository.findAll( Sort.by( "email" )).toString());


    }
}
