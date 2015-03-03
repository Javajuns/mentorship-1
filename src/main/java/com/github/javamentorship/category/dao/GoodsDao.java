package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.domain.Goods;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface GoodsDao {
    void update(Goods goods);

    void add(Goods goods);

    List<Goods> list();

    void delete(Goods goods);

    Goods getById(Integer id);
}
