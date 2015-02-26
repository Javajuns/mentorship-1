package com.github.javamentorship.spring;

import com.github.javamentorship.domain.CategoryInsertForm;
import com.github.javamentorship.mentorship.CategoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("/category")
    public ModelAndView viewCategory(Model model) throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        return new ModelAndView("category", "nop", categoryDao.listAll());
    }

    @RequestMapping(value = "/category_insert.html", method = RequestMethod.GET)
    public ModelAndView getInsertCategoryView() throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for get InsertCategory View");
        return new ModelAndView("category_insert", "insert_form", new CategoryInsertForm());
    }

    @RequestMapping(value = "/category_insert.html", method = RequestMethod.POST)
    public String insertCategory(@ModelAttribute("insert_form") CategoryInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}, with result={}", form, result);
        try {
            categoryDao.insert(form.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/category";
    }

    /*@RequestMapping("/categoryUpdate")
    public String updateCategory(@PathVariable int id, @PathVariable String name, @PathVariable int parent_id) throws SQLException, ClassNotFoundException {
        categoryDao.update(name, parent_id, id);
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        return "redirect:/category";
    }*/

    @RequestMapping("/categoryDelete")
    public String deleteCategory(@PathVariable int id) throws SQLException, ClassNotFoundException {
        categoryDao.delete(id);
        LOGGER.debug("Received request for DELETE new data in table CATEGORY");
        return "redirect:/category";
    }

}