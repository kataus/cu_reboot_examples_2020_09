package ru.sbrf.cu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.sbrf.cu.spring.dao.PersonDao;

import org.h2.tools.Console;

@SpringBootApplication
public class Main {

    public static void main( String[] args ) throws Exception {

        ApplicationContext context = SpringApplication.run( Main.class );

        PersonDao dao = context.getBean( PersonDao.class );

        Console.main( args );
    }
}
