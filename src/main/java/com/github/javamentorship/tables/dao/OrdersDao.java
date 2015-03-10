package com.github.javamentorship.tables.dao;

import com.github.javamentorship.tables.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersDao extends CrudRepository<Order, Integer> {

}
