package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    void update(Category category) throws SQLException;

    void addCategory(Category category) throws SQLException;

    List<Category> listCategory() throws SQLException;

    void deleteCategory(Category category) throws SQLException;

    Category getById(Integer id) throws SQLException;

}
