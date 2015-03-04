package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Good;

import java.util.List;

public interface GoodsDao {
    void update(Good good);
    void add(Good good);
    List<Good> list();
    void delete(Good good);
    Good getById(Integer id);
}
