package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.User;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UsersDaoImpl implements UsersDao<User> {

    public UsersDaoImpl() {
    }

    @Override
    public synchronized void delete(User del_obj) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(del_obj);
        session.getTransaction().commit();
    }

    @Override
    public synchronized User getById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User result = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return result;
    }

    @Override
    public synchronized void update(User user) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void add(User user) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<User> list() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> categories = session.createQuery("from Users").list();
        session.getTransaction().commit();
        return categories;
    }

}
