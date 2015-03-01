package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


@Component
public class CategoryDaoImpl implements CategoryDao {
    public CategoryDaoImpl() {
    }

    @Override
    public synchronized void deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Category where id= :id");
        query.setLong("id", category.getId());
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public synchronized Category getById(Category category) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Category where id= :id");
        query.setLong("id", category.getId());
        Category result = (Category) query.uniqueResult();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public synchronized void update(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void addCategory(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Category> categories = session.createQuery("from Category").list();
        session.getTransaction().commit();
        return categories;
    }

}
