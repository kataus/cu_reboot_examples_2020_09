package ru.sbrf.cu.core.dao;

import java.util.Optional;

import ru.sbrf.cu.core.model.User;
import ru.sbrf.cu.core.sessionmanager.SessionManager;

public interface UserDao {
  Optional<User> findById( long id);

  long saveUser(User user);

  SessionManager getSessionManager();
}
