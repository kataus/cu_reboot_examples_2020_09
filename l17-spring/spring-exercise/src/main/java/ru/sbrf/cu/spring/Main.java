package ru.sbrf.cu.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.sbrf.cu.spring.domain.Person;
import ru.sbrf.cu.spring.service.PersonService;

@Configuration
@ComponentScan
public class Main {

    public static void main( String[] args ) {
        // TODO: создайте здесь класс контекста
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext( Main.class );

        // TODO: Получите Person Service
        PersonService personService = context.getBean( PersonService.class );

        // Получите Person "Ivan"
        Person ivan = personService.getByName( "Ivan" );
        System.out.println( "name: " + ivan.getName() + " age: " + ivan.getAge() );
    }

}
