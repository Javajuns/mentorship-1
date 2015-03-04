package com.github.javamentorship.category.dao;

import com.github.javamentorship.category.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryDao extends CrudRepository<Category, Integer> {

}
