package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    public void addCategory(String name, Integer parentId) throws SQLException, ClassNotFoundException;

    public List<Category> listCategory() throws SQLException, ClassNotFoundException;

    public void deleteCategory(Integer id) throws SQLException, ClassNotFoundException;

    Category getById(Integer id) throws SQLException;

    public void updateCategory(Integer id, String name, Integer parent_id) throws SQLException, ClassNotFoundException;
}
