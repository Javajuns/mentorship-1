package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CategoryDao {
    void update(Category category);
    void add(Category category);
    List<Category> list();
    void delete(Category category);
    Category getById(Integer id);

}
