package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UsersDaoImpl implements RepositoryDao<User> {

    @PersistenceContext
    public EntityManager entityManager;

    public UsersDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public synchronized User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public synchronized void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public synchronized List<User> list() {
        List<User> users = entityManager.createQuery("from User").getResultList();
        return users;
    }

}
