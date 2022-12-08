package ru.andrey.SpringBoot.dao;

import ru.andrey.SpringBoot.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

    void deleteById(int id);

    void updateUser(User user, int id);

    User showUser(int id);

}
