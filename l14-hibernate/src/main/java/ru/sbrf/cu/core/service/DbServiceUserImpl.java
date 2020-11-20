package ru.sbrf.cu.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbrf.cu.core.dao.UserDao;
import ru.sbrf.cu.core.model.User;
import ru.sbrf.cu.core.sessionmanager.SessionManager;

import java.util.Optional;

public class DbServiceUserImpl implements DBServiceUser {
  private static Logger logger = LoggerFactory.getLogger(DbServiceUserImpl.class);

  private final UserDao userDao;

  public DbServiceUserImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public long saveUser( User user) {
    try (SessionManager sessionManager = userDao.getSessionManager()) {
      sessionManager.beginSession();
      try {
        logger.info("----- before start save: {}", user);
        if (user.getPhones() != null){
          user.getPhones().forEach( phone ->  userDao.savePhone( phone ) );
        }
        long userId = userDao.saveUser(user);

        logger.info("----- after create user: {}", user);
//        user.setName( "Петя" );
        logger.info("----- before commit user: {}", user);
        sessionManager.commitSession();

        logger.info("----- created user: {}", userId);
        return userId;
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        sessionManager.rollbackSession();
        throw new DbServiceException(e);
      }
    }
  }

  @Override
  public void changeName( long id, String name ){
    Optional<User> user = Optional.empty();
    try (SessionManager sessionManager = userDao.getSessionManager()) {
      sessionManager.beginSession();
      try {

        user = userDao.findById( id );
        sessionManager.getCurrentSession().getHibernateSession().detach( user.get() );
        user.ifPresent( u -> u.setName( name ) );

        sessionManager.commitSession();
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        sessionManager.rollbackSession();
        throw new DbServiceException(e);
      }

    }
  }

  @Override
  public Optional<User> getUser(long id) {
    try (SessionManager sessionManager = userDao.getSessionManager()) {
      sessionManager.beginSession();
      try {
        Optional<User> userOptional = userDao.findById(id);

        logger.info("user: {}", userOptional.orElse(null));
        return userOptional;
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        sessionManager.rollbackSession();
      }
      return Optional.empty();
    }
  }
}
