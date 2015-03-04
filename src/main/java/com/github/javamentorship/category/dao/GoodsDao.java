package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Good;

import java.util.List;

public interface GoodsDao extends RepositoryDao<Good> {
    @Override
    void update(Good good);
    @Override
    void add(Good good);
    @Override
    List<Good> list();
    @Override
    void delete(Good good);
    @Override
    Good getById(Integer id);
}
