package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OrdersDaoImpl implements OrdersDao {

    public OrdersDaoImpl() {
    }

    @Override
    public synchronized void delete(Order order) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
    }

    @Override
    public synchronized Order getById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Order order = (Order) session.get(Order.class, id);
        session.getTransaction().commit();
        return order;
    }

    @Override
    public synchronized void update(Order order) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void add(Order order) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Order> list() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Order> orders = session.createQuery("from Orders").list();
        session.getTransaction().commit();
        return orders;
    }

}