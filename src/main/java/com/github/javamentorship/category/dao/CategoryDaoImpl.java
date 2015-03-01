package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


@Component
public class CategoryDaoImpl implements CategoryDao {

    public SessionFactory sessionFactory;

    public CategoryDaoImpl() {
    }

    @Override
    public synchronized void deleteCategory(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
    }

    @Override
    public synchronized Category getById(Integer id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Category result =  (Category) session.get(Category.class, id);
        session.getTransaction().commit();
        return result;
    }

    @Override
    public synchronized void update(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(category);
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
