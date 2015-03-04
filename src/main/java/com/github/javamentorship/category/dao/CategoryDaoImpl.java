package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    public EntityManager entityManager;

    public CategoryDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(Category category) {
        entityManager.remove(category);
    }

    @Override
    public synchronized Category getById(Integer id) {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    @Override
    public synchronized void add(Category category) {
        entityManager.persist(category);
    }

    @Override
    public synchronized List<Category> list() {
        List<Category> categories = entityManager.createQuery("from Category", Category.class).getResultList();
        return categories;
    }
}
