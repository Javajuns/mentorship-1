package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    void update(Category category) throws SQLException, ClassNotFoundException;

    //TODO remove public modifier - all methods in interface are already public
    public void addCategory(Category category) throws SQLException, ClassNotFoundException;

    public List<Category> listCategory() throws SQLException, ClassNotFoundException;

    public void deleteCategory(Category category) throws SQLException, ClassNotFoundException;

    Category getById(Category category) throws SQLException;

}
