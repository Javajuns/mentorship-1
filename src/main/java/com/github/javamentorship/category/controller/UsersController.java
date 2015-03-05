package com.github.javamentorship.user.controller;

import com.github.javamentorship.category.command.UsersInsertForm;
import com.github.javamentorship.category.command.UsersUpdateForm;
import com.github.javamentorship.category.dao.UsersDao;
import com.github.javamentorship.category.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    public static final String REDIRECT_TO_INDEX = "redirect:/users";

    @Autowired
    public UsersDao usersDao;

    @RequestMapping("")
    public ModelAndView index() {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        ModelAndView modelAndView = new ModelAndView("users");
        Iterable<User> categories = usersDao.findAll();
        modelAndView.addObject("viewUsers", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertUsers View");
        ModelAndView modelAndView = new ModelAndView("user_insert");
        modelAndView.addObject("insert_form", new UsersInsertForm());
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") UsersInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}", form);
        User user = new User();
        user.setLogin(form.getLogin());
        user.setFirstName(form.getFirstName());
        user.setSecondName(form.getSecondName());
        user.setEmail(form.getEmail());
        user.setDateCreated(form.getDate_created());
        user.setIsAdmin(form.getIsAdmin());
        usersDao.save(user);
        return REDIRECT_TO_INDEX;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("user_update");
        UsersUpdateForm updateForm = new UsersUpdateForm();
        User user = usersDao.findOne(id);
        updateForm.setLogin(user.getLogin());
        updateForm.setFirstName(user.getFirstName());
        updateForm.setSecondName(user.getSecondName());
        updateForm.setEmail(user.getEmail());
        updateForm.setDate_created(user.getDateCreated());
        updateForm.setIsAdmin(user.getIsAdmin());
        modelAndView.addObject("update_form", updateForm);
        return modelAndView;

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") UsersUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (result.hasErrors()) {
            return "user_update";
        } else {
            User user = usersDao.findOne(form.getId());
            user.setLogin(form.getLogin());
            user.setFirstName(form.getFirstName());
            user.setSecondName(form.getSecondName());
            user.setEmail(form.getEmail());
            user.setDateCreated(form.getDate_created());
            user.setIsAdmin(form.getIsAdmin());
            usersDao.save(user);
            return REDIRECT_TO_INDEX;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam int id) {
        LOGGER.info("Received request for DELETE new data in table CATEGORY");
        User user = usersDao.findOne(id);
        if (user == null) {
            LOGGER.debug("Users not found");
            return REDIRECT_TO_INDEX;
        }
        usersDao.delete(user);
        return REDIRECT_TO_INDEX;
    }
}
