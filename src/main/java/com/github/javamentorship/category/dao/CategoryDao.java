package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    public void addCategory(String name) throws SQLException, ClassNotFoundException;

    public List<Category> listCategory() throws SQLException, ClassNotFoundException;

    public void deleteCategory(int id) throws SQLException, ClassNotFoundException;
}
