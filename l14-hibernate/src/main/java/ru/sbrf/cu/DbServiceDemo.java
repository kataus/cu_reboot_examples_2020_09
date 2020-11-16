package ru.sbrf.cu;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    SessionFactory sessionFactory = HibernateUtils.buildSessionFactory("hibernate.cfg.xml", User.class);

    SessionManagerHibernate sessionManager = new SessionManagerHibernate(sessionFactory);
    UserDao userDao = new UserDaoHibernate(sessionManager);
    DBServiceUser dbServiceUser = new DbServiceUserImpl(userDao);


    long id = dbServiceUser.saveUser(new User(0, "Вася"));
    Optional<User> mayBeCreatedUser = dbServiceUser.getUser(id);

    id = dbServiceUser.saveUser(new User(1L, "А! Нет. Это же совсем не Вася"));
    Optional<User> mayBeUpdatedUser = dbServiceUser.getUser(id);

    outputUserOptional("Created user", mayBeCreatedUser);
    outputUserOptional("Updated user", mayBeUpdatedUser);
  }

  private static void outputUserOptional(String header, Optional<User> mayBeUser) {
    System.out.println("-----------------------------------------------------------");
    System.out.println(header);
    mayBeUser.ifPresentOrElse(System.out::println, () -> logger.info("User not found"));
  }
}
