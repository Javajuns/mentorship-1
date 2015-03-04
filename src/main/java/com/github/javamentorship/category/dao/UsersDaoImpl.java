package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.domain.Users;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UsersDaoImpl implements UsersDao<Users> {

    @PersistenceContext
    public EntityManager entityManager;

    public UsersDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(Users user) {
        entityManager.remove(user);
    }

    @Override
    public synchronized Users getById(Integer id) {
        return entityManager.find(Users.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(Users user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public synchronized void add(Users user) {
        entityManager.persist(user);
    }

    @Override
    public synchronized List<Users> list() {
        List<Users> users = entityManager.createQuery("from Users", Users.class).getResultList();
        return users;

    }

}
