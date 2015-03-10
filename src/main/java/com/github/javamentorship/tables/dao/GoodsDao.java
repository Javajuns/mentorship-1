package com.github.javamentorship.tables.dao;

import com.github.javamentorship.tables.domain.Good;
import org.springframework.data.repository.CrudRepository;

public interface GoodsDao extends CrudRepository<Good, Integer> {

}