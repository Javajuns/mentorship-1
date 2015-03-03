package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Goods;
import com.github.javamentorship.category.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


@Component
public class GoodsDaoImpl implements GoodsDao {

    public GoodsDaoImpl() {
    }

    @Override
    public synchronized void delete(Goods goods) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(goods);
        session.getTransaction().commit();
    }

    @Override
    public synchronized Goods getById(Integer id) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Goods goods = (Goods) session.get(Goods.class, id);
        session.getTransaction().commit();
        return goods;
    }

    @Override
    public synchronized void update(Goods goods) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(goods);
        session.getTransaction().commit();
    }

    @Override
    public synchronized void add(Goods goods) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(goods);
        session.getTransaction().commit();
    }

    @Override
    public synchronized List<Goods> list() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Goods> goods = session.createQuery("from Goods").list();
        session.getTransaction().commit();
        return goods;
    }

}
