package ru.andrey.SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrey.SpringBoot.dao.UserDao;
import ru.andrey.SpringBoot.model.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user, int id) {
        userDao.updateUser(user, id);
    }

    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }
}
