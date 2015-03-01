package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.springframework.stereotype.Component;
import org.hibernate.Session;

import java.sql.*;
import java.util.List;

@Component
public class CategoryDaoImpl implements CategoryDao {
    public CategoryDaoImpl() {
    }

    @Override
    public synchronized void deleteCategory(Integer id) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category category = (Category) session.get(Category.class, id);
        session.delete(category);
        session.getTransaction().commit();
    }

    @Override
    public Category getById(Integer id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category category = (Category) session.get(Category.class, id);
        session.getTransaction().commit();
        return category;
    }

    @Override
    public synchronized void updateCategory(Integer id, String name, Integer parent_id) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category category = (Category) session.get(Category.class, id);
        category.setName(name);
        category.setParentId(parent_id);
        session.update(category);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void addCategory(String name, Integer parentId) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category category = new Category(name, parentId);
        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List category = session.createQuery("FROM Category").list();
        return category;
    }

    private Category hydrateCategory(ResultSet result) throws SQLException {
        Category category = new Category();
        category.setId(result.getInt("id"));
        category.setName(result.getString("name"));
        category.setParentId(result.getInt("parent_id"));
        return category;
    }
}
