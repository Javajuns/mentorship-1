package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Good;
import org.springframework.data.repository.CrudRepository;

public interface GoodsDao extends CrudRepository<Good, Integer> {

}