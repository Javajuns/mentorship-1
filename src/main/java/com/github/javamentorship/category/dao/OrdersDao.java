package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersDao extends CrudRepository<Order, Integer> {

}
