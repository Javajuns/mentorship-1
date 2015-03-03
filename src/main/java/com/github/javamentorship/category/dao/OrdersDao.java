package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {
    void update(Orders orders);

    void add(Orders orders);

    List<Orders> list();

    void delete(Orders orders);

    Orders getById(Integer id);

}
