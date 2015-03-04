package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
        List<Order> orders = entityManager.createQuery("from Order", Order.class).getResultList();
        return orders;
    }
}