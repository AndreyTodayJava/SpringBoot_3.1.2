package ru.andrey.SpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.andrey.SpringBoot.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(showUser(id));
    }
    @Override
    public void updateUser(User user, int id) {
        User updatedUser = entityManager.find(User.class, id);
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        entityManager.merge(updatedUser);
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

}
