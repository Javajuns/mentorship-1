package com.github.javamentorship.tables.dao;

import com.github.javamentorship.tables.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category, Integer> {

}
