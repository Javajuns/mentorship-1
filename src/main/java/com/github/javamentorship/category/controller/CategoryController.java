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
    public ModelAndView index() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        ModelAndView modelAndView = new ModelAndView("category");
        List<Category> categories = categoryDao.listCategory();
        modelAndView.addObject("viewCategory", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for get InsertCategory View");
        List<Category> parentCategories = categoryDao.listCategory();
        Map<String,String> parentCategoryItems = new LinkedHashMap<String,String>();
        for(Category category: parentCategories) {
            parentCategoryItems.put(String.valueOf(category.getId()), category.getName()); //TODO String.valueOf(parentCategory.getId() -> category.getId().toString()
        }
        ModelAndView modelAndView = new ModelAndView("category_insert");
        modelAndView.addObject("insert_form", new CategoryInsertForm());
        modelAndView.addObject("parentCategories", parentCategoryItems);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") CategoryInsertForm form, BindingResult result) throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request to create {}", form);
        try {
            categoryDao.addCategory(new Category(form.getName(), form.getParentId()));
        } catch (SQLException e) {
            e.printStackTrace(); //TODO log exceptions to LOGGER
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/category";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) throws SQLException {
        Category category = categoryDao.getById(id);
        CategoryUpdateForm updateForm = new CategoryUpdateForm();
        updateForm.setId(category.getId());
        updateForm.setName(category.getName());
        updateForm.setParentId(category.getParentId());
        return new ModelAndView("category_update", "update_form", updateForm);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") CategoryUpdateForm form, BindingResult result) throws SQLException, ClassNotFoundException {
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
    public String delete(@PathVariable("id") int id) throws SQLException, ClassNotFoundException {
        categoryDao.deleteCategory(new Category(id));
        LOGGER.debug("Received request for DELETE new data in table CATEGORY");
        return "redirect:/category";
    }
}