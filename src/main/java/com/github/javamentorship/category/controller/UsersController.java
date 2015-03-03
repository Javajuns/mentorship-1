package com.github.javamentorship.category.controller;

import com.github.javamentorship.category.domain.Users;
import com.github.javamentorship.category.command.UsersInsertForm;
import com.github.javamentorship.category.command.UsersUpdateForm;
import com.github.javamentorship.category.dao.UsersDao;
import com.github.javamentorship.category.domain.Users;
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
@RequestMapping(value = "/users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    public static final String REDIRECT_TO_INDEX = "redirect:/users";

    @Autowired
    public UsersDao usersDao;

    @RequestMapping("")
    public ModelAndView index() {
        LOGGER.debug("Received request for SELECT from table USERS");
        ModelAndView modelAndView = new ModelAndView("users");
        List<Users> categories = usersDao.list();
        modelAndView.addObject("viewUsers", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertUsers View");
        ModelAndView modelAndView = new ModelAndView("users_insert");
        modelAndView.addObject("insert_form", new UsersInsertForm());
        /*List<Users> parentCategories = usersDao.list();
        Map<String, String> parentUsersItems = new LinkedHashMap<String, String>();
        for (Users users : parentCategories) {
            parentUsersItems.put(users.getId().toString(), users.getName());
        }
        modelAndView.addObject("parentCategories", parentUsersItems);*/
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") UsersInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}", form);
        Users users = new Users();
     /*   users.setName(form.getName());
        users.setParentId(form.getParentId());*/
        usersDao.add(users);
        return REDIRECT_TO_INDEX;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        UsersUpdateForm updateForm = new UsersUpdateForm();
        Users user = (Users) usersDao.getById(id);
/*
        updateForm.setId(users.getId());
        updateForm.setName(users.getName());
        updateForm.setParentId(users.getParentId());
*/
        return new ModelAndView("users_update", "update_form", updateForm);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") UsersUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (result.hasErrors()) {
            return "users_update";
        } else {

            Users users = (Users) usersDao.getById(form.getId());
/*
            users.setName(form.getName());
            users.setParentId(form.getParentId());
*/
            usersDao.update(users);
            return REDIRECT_TO_INDEX;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam int id) {
        LOGGER.info("Received request for DELETE new data in table CATEGORY");
        Users users = (Users) usersDao.getById(id);
        if (users == null) {
            LOGGER.debug("Users not found");
            return REDIRECT_TO_INDEX;
        }
        usersDao.delete(users);
        return REDIRECT_TO_INDEX;
    }
}