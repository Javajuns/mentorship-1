package com.github.javamentorship.tables.dao;

import com.github.javamentorship.tables.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends CrudRepository<Order, Integer> {

}
