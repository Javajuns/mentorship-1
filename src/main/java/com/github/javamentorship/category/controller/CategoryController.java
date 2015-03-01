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
//TODO     @RequestMapping(value = "/category")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryDao categoryDao;

    //TODO  /category -> /
    @RequestMapping("/category")
    public ModelAndView viewCategory() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        ModelAndView modelAndView = new ModelAndView("category");
        List<Category> categories = categoryDao.listCategory();
        modelAndView.addObject("viewCategory", categories);
        return modelAndView;
    }

    //TODO  /category_insert.html -> /add
    @RequestMapping(value = "/category_insert.html", method = RequestMethod.GET)
    public ModelAndView getInsertCategoryView() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for get InsertCategory View");
        List<Category> parentCategories = categoryDao.listCategory();
        Map<String,String> parentCategoryItems = new LinkedHashMap<String,String>();
        for(Category a: parentCategories) { //TODO rename (Shift+F6) a -> parentCategory
            parentCategoryItems.put(String.valueOf(a.getId()), a.getName()); //TODO String.valueOf(parentCategory.getId() -> category.getId().toString()
        }
        ModelAndView modelAndView = new ModelAndView("category_insert");
        modelAndView.addObject("insert_form", new CategoryInsertForm());
        modelAndView.addObject("parentCategories", parentCategoryItems);
        return modelAndView;
    }

     //TODO  /category_insert.html (POST) -> /save (POST)
    @RequestMapping(value = "/category_insert.html", method = RequestMethod.POST)
    public String insertCategory(@Valid @ModelAttribute("insert_form") CategoryInsertForm form, BindingResult result) throws SQLException, ClassNotFoundException {
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

    //TODO  /category_update_form.html -> /edit
    @RequestMapping(value = "/category_update_form.html/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateCategoryView(@PathVariable("id") int id) throws SQLException {
        Category category = categoryDao.getById(new Category(id));
        CategoryUpdateForm updateForm = new CategoryUpdateForm();
        updateForm.setId(category.getId());
        updateForm.setName(category.getName());
        updateForm.setParentId(category.getParentId());
        return new ModelAndView("category_update", "update_form", updateForm);
    }

    //TODO  /category_update_form.html (POST) -> /update (POST)
    @RequestMapping(value = "/category_update.html", method = RequestMethod.POST)
    public String updateCategory(@Valid @ModelAttribute("update_form") CategoryUpdateForm form, BindingResult result) throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (result.hasErrors()) {
            return "category_update";
        } else {
            categoryDao.update(new Category(form.getId(), form.getName(), form.getParentId()));
            return "redirect:/category";
        }
    }

    //TODO delete request IS changing data. So it can't be called via GET request.
    //TODO  /category_delete.html (GET) -> /delete (POST)
    @RequestMapping("/category_delete.html/{id}")
    public String deleteCategory(@PathVariable("id") int id) throws SQLException, ClassNotFoundException {
        categoryDao.deleteCategory(new Category(id));
        LOGGER.debug("Received request for DELETE new data in table CATEGORY");
        return "redirect:/category";
    }
}