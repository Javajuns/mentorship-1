package com.github.javamentorship.spring;

import com.github.javamentorship.domain.CategoryInsertForm;
import com.github.javamentorship.mentorship.CategoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping("/hello")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("/")
    public String index() {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        return "redirect:/category.html";
    }

    @RequestMapping("/category.html")
    public ModelAndView viewCategory() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        return new ModelAndView("category", "selectResult", categoryDao.listAll());
    }

    @RequestMapping(value = "/category_insert.html", method = RequestMethod.GET)
    public ModelAndView getInsertCategoryView() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for get InsertCategory View");
        return new ModelAndView("category_insert", "insert_form", new CategoryInsertForm());
    }

    @RequestMapping(value = "/category_insert.html", method = RequestMethod.POST)
    public String insertCategory(@ModelAttribute("insert_form") CategoryInsertForm form) {
        LOGGER.debug("Received request to create {}", form);
        try {
            categoryDao.insert(form.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/category.html";
    }

    /*@RequestMapping("/categoryUpdate")
    public String updateCategory(@PathVariable int id, @PathVariable String name, @PathVariable int parent_id) throws SQLException, ClassNotFoundException {
        categoryDao.update(name, parent_id, id);
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        return "redirect:/category";
    }*/

    @RequestMapping("/category_delete.html/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) throws SQLException, ClassNotFoundException {
        categoryDao.delete(id);
        LOGGER.debug("Received request for DELETE new data in table CATEGORY");
        return "redirect:/category.html";
    }

}