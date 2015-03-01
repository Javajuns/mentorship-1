package com.github.javamentorship.category.service;

import com.github.javamentorship.category.dao.CategoryDao;
import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryDao categoryDao;

    @Override
    @Transactional
    public void update(Category category) throws SQLException, ClassNotFoundException {
        categoryDao.update(category);
    }

    @Override
    @Transactional
    public void addCategory(Category category) throws SQLException, ClassNotFoundException {
        categoryDao.addCategory(category);
    }

    @Override
    @Transactional
    public List<Category> listCategory() throws SQLException, ClassNotFoundException {
        return categoryDao.listCategory();
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        categoryDao.deleteCategory(category);
    }

    @Override
    @Transactional
    public Category getById(Category category) throws SQLException {
        return categoryDao.getById(category);
    }
}
