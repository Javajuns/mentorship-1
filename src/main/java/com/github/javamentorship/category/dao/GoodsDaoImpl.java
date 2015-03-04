package com.github.javamentorship.category.dao;


import com.github.javamentorship.category.domain.Goods;
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
    public synchronized void delete(Goods goods) {
        entityManager.remove(goods);
    }

    @Override
    public synchronized Goods getById(Integer id) {
        return entityManager.find(Goods.class, id);
    }

    @Transactional
    @Override
    public synchronized void update(Goods goods) {
        entityManager.persist(goods);
    }


    @Transactional
    @Override
    public synchronized void add(Goods goods) {
        entityManager.persist(goods);
    }

    @Override
    public synchronized List<Goods> list() {
        List<Goods> goods = entityManager.createQuery("from Goods", Goods.class).getResultList();
        return goods;
    }


}
