package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;

import java.util.List;

public interface OrdersDao extends RepositoryDao<Order> {
    @Override
    void update(Order order);
    @Override
    void add(Order order);
    @Override
    List<Order> list();
    @Override
    void delete(Order order);
    @Override
    Order getById(Integer id);
}
