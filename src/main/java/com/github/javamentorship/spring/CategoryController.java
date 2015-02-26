package com.github.javamentorship.spring;

import com.github.javamentorship.mentorship.CategoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@RestController
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("/category")
    public ModelAndView viewTable(Model model) throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for create index view");
        return new ModelAndView("index", "nop", categoryDao.listAll());
    }

    @RequestMapping("/categoryInsert")
    public String insertTable(@PathVariable String name) throws SQLException, ClassNotFoundException {
        categoryDao.insert(name);
        LOGGER.debug("Received request for insert new data in table CATEGORY");
        return "redirect:/category";
    }

    @RequestMapping("/categoryUpdate")
    public String updateTable(@PathVariable int id, @PathVariable String name, @PathVariable int parent_id) throws SQLException, ClassNotFoundException {
        categoryDao.update(name, parent_id, id);
        LOGGER.debug("Received request for update data in table CATEGORY");
        return "redirect:/category";
    }
}