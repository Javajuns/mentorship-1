package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


@Component
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    public EntityManager entityManager;

    public CategoryDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(Category category) throws SQLException {
        entityManager.remove(category);
    }

    @Override
    public synchronized Category getById(Integer id) throws SQLException {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(Category category) throws SQLException {
        entityManager.persist(category);
    }

    @Transactional
    @Override
    public synchronized void add(Category category) throws SQLException {
        entityManager.persist(category);
    }

    @Override
    public synchronized List<Category> list() throws SQLException {
        List<Category> categories = entityManager.createQuery("from Category", Category.class).getResultList();
        return categories;
    }
}
