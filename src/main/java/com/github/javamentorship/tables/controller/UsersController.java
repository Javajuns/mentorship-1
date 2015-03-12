package com.github.javamentorship.tables.controller;

import com.github.javamentorship.tables.command.UsersInsertForm;
import com.github.javamentorship.tables.command.UsersUpdateForm;
import com.github.javamentorship.tables.dao.UsersDao;
import com.github.javamentorship.tables.domain.Address;
import com.github.javamentorship.tables.domain.User;
import com.github.stokito.gag.annotation.remark.WTF;
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
        ModelAndView modelAndView = new ModelAndView("users_insert");
        modelAndView.addObject("insert_form", new UsersInsertForm());
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") UsersInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}", form);
        if (!result.hasErrors()) {
            User user = new User();
            user.setLogin(form.getLogin());
            user.setFirstName(form.getFirstName());
            user.setSecondName(form.getSecondName());
            user.setEmail(form.getEmail());
            user.setIsAdmin(form.getIsAdmin());
            usersDao.save(user);
            return REDIRECT_TO_INDEX;
        } else {
            return "redirect:/users/add";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("users_update");
        UsersUpdateForm updateForm = new UsersUpdateForm();
        User user = usersDao.findOne(id);
        updateForm.setId(user.getId());
        updateForm.setLogin(user.getLogin());
        updateForm.setFirstName(user.getFirstName());
        updateForm.setSecondName(user.getSecondName());
        updateForm.setEmail(user.getEmail());
        updateForm.setDateCreated(user.getDateCreated());
        updateForm.setIsAdmin(user.getIsAdmin());
        updateForm.setAddress(user.getAddress());
        modelAndView.addObject("update_form", updateForm);
        return modelAndView;

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") UsersUpdateForm updateForm, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table USERS");
        if (!result.hasErrors()) {
            User user = usersDao.findOne(updateForm.getId());
            user.setLogin(updateForm.getLogin());
            user.setFirstName(updateForm.getFirstName());
            user.setSecondName(updateForm.getSecondName());
            user.setEmail(updateForm.getEmail());
            user.setDateCreated(updateForm.getDateCreated());
            user.setIsAdmin(updateForm.getIsAdmin());
            Address address = updateForm.getAddress();
            address.setCountry(updateForm.getAddress().getCountry());
            address.setCity(updateForm.getAddress().getCity());
            address.setStreet(updateForm.getAddress().getStreet());
            address.setBuilding(updateForm.getAddress().getBuilding());
            user.setAddress(address);
            usersDao.save(user);
            return REDIRECT_TO_INDEX;
        } else {
            return "users_update";
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
