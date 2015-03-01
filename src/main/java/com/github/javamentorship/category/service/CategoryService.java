package com.github.javamentorship.category.service;

import com.github.javamentorship.category.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    void update(Category category) throws SQLException, ClassNotFoundException;

    void addCategory(Category category) throws SQLException, ClassNotFoundException;

    List<Category> listCategory() throws SQLException, ClassNotFoundException;

    void deleteCategory(Category category) throws SQLException, ClassNotFoundException;

    Category getById(Category category) throws SQLException;
}
