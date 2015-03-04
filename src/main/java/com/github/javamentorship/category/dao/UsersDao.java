package com.github.javamentorship.category.dao;


import com.github.javamentorship.category.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<User, Integer> {
    User findByLoginIgnoringCase(String name);
}
