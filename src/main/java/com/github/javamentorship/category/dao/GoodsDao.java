package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    void update(Good good);

    void add(Good good);

    List<Good> list();

    void delete(Good good);

    Good getById(Integer id);
}
