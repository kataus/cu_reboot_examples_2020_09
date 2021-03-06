package ru.sbrf.cu.hibernate.dao;


import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbrf.cu.core.model.Phone;
import ru.sbrf.cu.core.model.User;
import ru.sbrf.cu.hibernate.sessionmanager.DatabaseSessionHibernate;
import ru.sbrf.cu.hibernate.sessionmanager.SessionManagerHibernate;
import ru.sbrf.cu.core.dao.UserDao;
import ru.sbrf.cu.core.dao.UserDaoException;
import ru.sbrf.cu.core.sessionmanager.SessionManager;

import java.util.Optional;

public class UserDaoHibernate implements UserDao {
  private static Logger logger = LoggerFactory.getLogger(UserDaoHibernate.class);

  private final SessionManagerHibernate sessionManager;

  public UserDaoHibernate(SessionManagerHibernate sessionManager) {
    this.sessionManager = sessionManager;
  }


  @Override
  public Optional<User> findById( long id) {
    DatabaseSessionHibernate currentSession = sessionManager.getCurrentSession();
    try {
      return Optional.ofNullable(currentSession.getHibernateSession().find(User.class, id));
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
    return Optional.empty();
  }


  @Override
  public long saveUser(User user) {
    DatabaseSessionHibernate currentSession = sessionManager.getCurrentSession();
    try {
      Session hibernateSession = currentSession.getHibernateSession();
      if (user.getId() > 0) {
        hibernateSession.merge(user);
      } else {
        hibernateSession.persist(user);
      }
      return user.getId();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new UserDaoException(e);
    }
  }

  @Override
  public void savePhone( Phone phone ) {
    DatabaseSessionHibernate currentSession = sessionManager.getCurrentSession();
    try {
      Session hibernateSession = currentSession.getHibernateSession();
      if (phone.getId() > 0) {
        hibernateSession.merge(phone);
      } else {
        hibernateSession.persist(phone);
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new UserDaoException(e);
    }
  }

  @Override
  public SessionManager getSessionManager() {
    return sessionManager;
  }
}
