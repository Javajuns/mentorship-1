package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


@Component
@Repository
public class OrdersDaoImpl implements OrdersDao {

    @PersistenceContext
    public EntityManager entityManager;

    public OrdersDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(Order orders) {
        entityManager.remove(orders);
    }

    @Override
    public synchronized Order getById(Integer id) {
        return entityManager.find(Order.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(Order orders) {
        entityManager.persist(orders);
    }
    @Transactional
    @Override
    public synchronized void add(Order orders) {
        entityManager.persist(orders);
    }

    @Override
    public synchronized List<Order> list() {
        List<Order> orders = entityManager.createQuery("from Orders", Order.class).getResultList();
        return orders;
    }

}