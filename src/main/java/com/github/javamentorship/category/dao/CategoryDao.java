package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;

import java.util.List;

public interface CategoryDao extends RepositoryDao<Category> {
    @Override
    void update(Category category);
    @Override
    void add(Category category);
    @Override
    List<Category> list();
    @Override
    void delete(Category category);
    @Override
    Category getById(Integer id);
}
