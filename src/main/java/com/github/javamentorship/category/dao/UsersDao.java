package com.github.javamentorship.category.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao<T> {
    void update(T upd_obj);

    void add(T add_obj);

    List<T> list();

    void delete(T del_obj);

    T getById(Integer id);
}
