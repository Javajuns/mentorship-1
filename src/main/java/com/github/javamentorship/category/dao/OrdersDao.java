package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    void update(Order order);

    void add(Order order);

    List<Order> list();

    void delete(Order order);

    Order getById(Integer id);

}
