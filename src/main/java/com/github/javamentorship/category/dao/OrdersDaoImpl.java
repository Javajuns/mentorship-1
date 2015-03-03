package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Orders;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


@Component
public class OrdersDaoImpl implements OrdersDao {

    public OrdersDaoImpl() {
    }

    @Override
    public synchronized void delete(Orders orders) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(orders);
        session.getTransaction().commit();
    }

    @Override
    public synchronized Orders getById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Orders orders = (Orders) session.get(Orders.class, id);
        session.getTransaction().commit();
        return orders;
    }

    @Override
    public synchronized void update(Orders orders) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(orders);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void add(Orders orders) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(orders);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Orders> list() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Orders> orders = session.createQuery("from Orders").list();
        session.getTransaction().commit();
        return orders;
    }

}