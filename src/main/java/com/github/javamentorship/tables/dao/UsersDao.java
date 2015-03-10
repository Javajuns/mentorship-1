package com.github.javamentorship.tables.dao;


import com.github.javamentorship.tables.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<User, Integer> {
    User findByLoginIgnoringCase(String name);
}
