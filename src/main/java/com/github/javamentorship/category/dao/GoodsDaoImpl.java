package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Good;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GoodsDaoImpl implements GoodsDao {

    public GoodsDaoImpl() {
    }

    @Override
    public synchronized void delete(Good good) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(good);
        session.getTransaction().commit();
    }

    @Override
    public synchronized Good getById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Good good = (Good) session.get(Good.class, id);
        session.getTransaction().commit();
        return good;
    }

    @Override
    public synchronized void update(Good good) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(good);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void add(Good good) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(good);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Good> list() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Good> goods = session.createQuery("from Goods").list();
        session.getTransaction().commit();
        return goods;
    }

}
