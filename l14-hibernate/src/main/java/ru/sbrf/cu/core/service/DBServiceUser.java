package ru.sbrf.cu.core.service;

import ru.sbrf.cu.core.model.User;

import java.util.Optional;

public interface DBServiceUser {

  long saveUser( User user);

  void changeName( long id, String name );

  Optional<User> getUser( long id);

}
