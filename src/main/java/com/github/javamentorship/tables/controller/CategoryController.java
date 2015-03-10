package com.github.javamentorship.tables.controller;

import com.github.javamentorship.tables.command.CategoryInsertForm;
import com.github.javamentorship.tables.command.CategoryUpdateForm;
import com.github.javamentorship.tables.dao.CategoryDao;
import com.github.javamentorship.tables.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    public static final String REDIRECT_TO_INDEX = "redirect:/category";

    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("")
    public ModelAndView index() {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        ModelAndView modelAndView = new ModelAndView("category");
        Iterable<Category> categories = categoryDao.findAll();
        modelAndView.addObject("viewCategory", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertCategory View");
        ModelAndView modelAndView = new ModelAndView("category_insert");
        modelAndView.addObject("insert_form", new CategoryInsertForm());
        Iterable<Category> parentCategories = categoryDao.findAll();
        Map<String, String> parentCategoryItems = new LinkedHashMap<String, String>();
        for (Category category : parentCategories) {
            parentCategoryItems.put(category.getId().toString(), category.getName());
        }
        modelAndView.addObject("parentCategories", parentCategoryItems);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") CategoryInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}", form);
        if (!result.hasErrors()) {
            Category category = new Category();
            category.setName(form.getName());
            category.setParentId(form.getParentId());
            categoryDao.save(category);
            return REDIRECT_TO_INDEX;
        } else {
            return "redirect:/users/add";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("category_update");
        CategoryUpdateForm updateForm = new CategoryUpdateForm();
        Iterable<Category> parentCategories = categoryDao.findAll();
        Map<String, String> parentCategoryItems = new LinkedHashMap<String, String>();
        for (Category category : parentCategories) {
            parentCategoryItems.put(category.getId().toString(), category.getName());
        }
        modelAndView.addObject("parentCategories", parentCategoryItems);
        Category category = categoryDao.findOne(id);
        updateForm.setId(category.getId());
        updateForm.setName(category.getName());
        updateForm.setParentId(category.getParentId());
        modelAndView.addObject("update_form", updateForm);

        return modelAndView;

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") CategoryUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (!result.hasErrors()) {
            Category category = categoryDao.findOne(form.getId());
            category.setName(form.getName());
            category.setParentId(form.getParentId());
            categoryDao.save(category);
            return REDIRECT_TO_INDEX;
        } else {
            return "category_update";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam int id) {
        LOGGER.info("Received request for DELETE new data in table CATEGORY");
        Category category = categoryDao.findOne(id);
        if (category == null) {
            LOGGER.debug("Category not found");
            return REDIRECT_TO_INDEX;
        }
        categoryDao.delete(category);
        return REDIRECT_TO_INDEX;
    }

    //TODO show action ie. /tables/show/{id} and target from goods controller
}