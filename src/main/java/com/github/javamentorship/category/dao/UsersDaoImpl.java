package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.User;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Component
public class UsersDaoImpl implements UsersDao<Users> {

    @PersistenceContext
    public EntityManager entityManager;

    public UsersDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(Users del_obj) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(del_obj);
        session.getTransaction().commit();
    }

    @Override
    public synchronized Users getById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Users result = (Users) session.get(Users.class, id);
        session.getTransaction().commit();
        return result;
    }

    @Transactional
    @Override
    public synchronized void update(Users user) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Transactional
    @Override
    public synchronized void add(Users user) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Users> list() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Users> categories = session.createQuery("from Users").list();
        session.getTransaction().commit();
        return categories;
    }

}
