package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;

import java.util.List;

public interface CategoryDao {
    void update(Category category);
    void add(Category category);
    List<Category> list();
    void delete(Category category);
    Category getById(Integer id);
}
