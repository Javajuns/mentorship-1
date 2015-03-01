package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
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
        Query query = session.createQuery("delete from category where id= :id");
        query.setLong("id", category.getId());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Category getById(Category category) throws SQLException {
        Category result = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from category where id= :id");
        query.setLong("id", category.getId());
        result = (Category) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public synchronized void update(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query  query = session.createQuery("update category set name= :name parent_id:parent_id where id= :id");
        query.setParameter("name", category.getName());
        query.setInteger("parent_id", category.getParentId());
        query.setInteger("id", category.getId());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public synchronized void addCategory(Category category) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public synchronized List<Category> listCategory() throws SQLException, ClassNotFoundException {
        List<Category> categories = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        categories = session.createQuery("from Category").list();
        session.getTransaction().commit();
        session.close();
        return categories;
    }

    private Category hydrateCategory(ResultSet result) throws SQLException {
        Category category = new Category();
        category.setId(result.getInt("id"));
        category.setName(result.getString("name"));
        category.setParentId(result.getInt("parent_id"));
        return category;
    }
}
