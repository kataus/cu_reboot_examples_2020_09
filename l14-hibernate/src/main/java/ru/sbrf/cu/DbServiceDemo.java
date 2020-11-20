package ru.sbrf.cu;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbrf.cu.core.model.Phone;
import ru.sbrf.cu.core.model.User;
import ru.sbrf.cu.core.dao.UserDao;
import ru.sbrf.cu.hibernate.dao.UserDaoHibernate;
import ru.sbrf.cu.core.service.DBServiceUser;
import ru.sbrf.cu.core.service.DbServiceUserImpl;
import ru.sbrf.cu.hibernate.HibernateUtils;
import ru.sbrf.cu.hibernate.sessionmanager.SessionManagerHibernate;

import java.util.Optional;

public class DbServiceDemo {
  private static Logger logger = LoggerFactory.getLogger(DbServiceDemo.class);

  public static void main(String[] args) {
    // Все главное см в тестах
    SessionFactory sessionFactory = HibernateUtils.buildSessionFactory("hibernate.cfg.xml", User.class, Phone.class );

    SessionManagerHibernate sessionManager = new SessionManagerHibernate(sessionFactory);
    UserDao userDao = new UserDaoHibernate(sessionManager);
    DBServiceUser dbServiceUser = new DbServiceUserImpl(userDao);

    logger.info( "----- start create user -----" );
    long id = dbServiceUser.saveUser(new User(0, "Вася"));
    logger.info( "----- finish create user -----" );

    logger.info( "----- start get user -----" );
    Optional<User> mayBeCreatedUser = dbServiceUser.getUser(id);
    mayBeCreatedUser.ifPresent( u -> u.getPhones().add( new Phone(0, "12345") ) );
    mayBeCreatedUser.ifPresent( u -> u.getPhones().add( new Phone(0, "54321") ) );
    mayBeCreatedUser.ifPresent( u -> dbServiceUser.saveUser( u ) );
    logger.info( "----- finish get user -----" );


    id = dbServiceUser.saveUser(new User(1L, "А! Нет. Это же совсем не Вася"));
    Optional<User> mayBeUpdatedUser = dbServiceUser.getUser(id);

    User newUser = new User();
    newUser.setName( "Коля" );
    dbServiceUser.saveUser( newUser );

    dbServiceUser.changeName( newUser.getId(), "Оля" );

    outputUserOptional("Created user", mayBeCreatedUser);
    outputUserOptional("Updated user", mayBeUpdatedUser);

    mayBeCreatedUser = dbServiceUser.getUser( newUser.getId() );
    outputUserOptional( "New updated user", mayBeCreatedUser );
  }

  private static void outputUserOptional(String header, Optional<User> mayBeUser) {
    System.out.println("-----------------------------------------------------------");
    System.out.println(header);
    mayBeUser.ifPresentOrElse(System.out::println, () -> logger.info("User not found"));
  }
}
