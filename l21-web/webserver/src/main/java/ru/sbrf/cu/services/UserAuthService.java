package ru.sbrf.cu.services;

public interface UserAuthService {
    boolean authenticate(String login, String password);
}
