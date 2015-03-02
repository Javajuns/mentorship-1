package com.github.javamentorship.category.controller;

import com.github.javamentorship.category.command.CategoryInsertForm;
import com.github.javamentorship.category.command.CategoryUpdateForm;
import com.github.javamentorship.category.dao.CategoryDao;
import com.github.javamentorship.category.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("")
    public ModelAndView index() {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        ModelAndView modelAndView = new ModelAndView("category");
        List<Category> categories = categoryDao.listCategory();
        modelAndView.addObject("viewCategory", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertCategory View");
        List<Category> parentCategories = categoryDao.listCategory();
        Map<String,String> parentCategoryItems = new LinkedHashMap<String,String>();
        for(Category category: parentCategories) {
            parentCategoryItems.put(category.getId().toString(), category.getName());
        }
        ModelAndView modelAndView = new ModelAndView("category_insert");
        modelAndView.addObject("insert_form", new CategoryInsertForm());
        modelAndView.addObject("parentCategories", parentCategoryItems);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") CategoryInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}", form);
        Category category = new Category();
        category.setName(form.getName());
        category.setParentId(form.getParentId());
        try {
            categoryDao.addCategory(category);
        } catch (SQLException e) {
            LOGGER.error("Error during saving", e);
        }
        return "redirect:/category";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        Category category = categoryDao.getById(id);
        CategoryUpdateForm updateForm = new CategoryUpdateForm();
        updateForm.setId(category.getId());
        updateForm.setName(category.getName());
        updateForm.setParentId(category.getParentId());
        return new ModelAndView("category_update", "update_form", updateForm);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") CategoryUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (result.hasErrors()) {
            return "category_update";
        } else {
            Category category = categoryDao.getById(form.getId());
            category.setName(form.getName());
            category.setParentId(form.getParentId());
            categoryDao.update(category);
            return "redirect:/category";
        }
    }

    //TODO delete request IS changing data. So it can't be called via GET request.
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        LOGGER.debug("Received request for DELETE new data in table CATEGORY");
        Category category = categoryDao.getById(id);
        if (category == null) {
            LOGGER.debug("Category not found");
            return "redirect:/category";
        }
        categoryDao.deleteCategory(category);
        return "redirect:/category";
    }
}