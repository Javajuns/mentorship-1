package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Good;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Component
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @PersistenceContext
    public EntityManager entityManager;

    public GoodsDaoImpl() {
    }

    @Transactional
    @Override
    public synchronized void delete(Good good) {
        entityManager.remove(good);
    }

    @Override
    public synchronized Good getById(Integer id) {
        return entityManager.find(Good.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(Good good) {
        entityManager.persist(good);
    }


    @Transactional
    @Override
    public synchronized void add(Good good) {
        entityManager.persist(good);
    }

    @Override
    public synchronized List<Good> list() {
        List<Good> goods = entityManager.createQuery("from Good", Good.class).getResultList();
        return goods;
    }
}
