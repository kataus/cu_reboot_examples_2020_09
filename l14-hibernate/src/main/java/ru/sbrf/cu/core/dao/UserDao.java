package ru.sbrf.cu.core.dao;

import ru.sbrf.cu.core.model.User;
import ru.sbrf.cu.core.sessionmanager.SessionManager;

import java.util.Optional;

public interface UserDao {
  Optional<User> findById( long id);

  long saveUser(User user);

  SessionManager getSessionManager();
}
