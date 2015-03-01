package com.github.javamentorship.category.service;

import com.github.javamentorship.category.dao.CategoryDAO;
import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public void update(Category category) throws SQLException, ClassNotFoundException {
        categoryDAO.update(category);
    }

    @Override
    @Transactional
    public void addCategory(Category category) throws SQLException, ClassNotFoundException {
        categoryDAO.addCategory(category);
    }

    @Override
    @Transactional
    public List<Category> listCategory() throws SQLException, ClassNotFoundException {
        return categoryDAO.listCategory();
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        categoryDAO.deleteCategory(category);
    }

    @Override
    @Transactional
    public Category getById(Category category) throws SQLException {
        return categoryDAO.getById(category);
    }
}
