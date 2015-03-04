package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;
import java.util.List;

public interface OrdersDao {
    void update(Order order);
    void add(Order order);
    List<Order> list();
    void delete(Order order);
    Order getById(Integer id);
}
