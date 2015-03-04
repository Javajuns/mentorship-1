package com.github.javamentorship.category.dao;

import java.util.List;

public interface RepositoryDao<T> {
    void update(T upd_obj);
    void add(T add_obj);
    List<T> list();
    void delete(T del_obj);
    T getById(Integer id);
}
