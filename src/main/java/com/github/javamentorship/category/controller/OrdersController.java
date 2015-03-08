package com.github.javamentorship.category.controller;

import com.github.javamentorship.category.command.OrdersInsertForm;
import com.github.javamentorship.category.command.OrdersUpdateForm;
import com.github.javamentorship.category.dao.OrdersDao;
import com.github.javamentorship.category.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);
    public static final String REDIRECT_TO_INDEX = "redirect:/orders";

    @Autowired
    public OrdersDao ordersDao;

    @RequestMapping("")
    public ModelAndView index() {
        LOGGER.debug("Received request for SELECT from table CATEGORY");
        ModelAndView modelAndView = new ModelAndView("orders");
        Iterable<Order> orders = ordersDao.findAll();
        modelAndView.addObject("viewOrders", orders);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertCategory View");
        ModelAndView modelAndView = new ModelAndView("orders_insert");
        modelAndView.addObject("insert_form", new OrdersInsertForm());
        Iterable<Order> parentOrders = ordersDao.findAll();
        modelAndView.addObject("parentOrders", parentOrders);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("insert_form") OrdersInsertForm form, BindingResult result) {
        LOGGER.info("Received request to create {}", form);
        Order order = new Order();
        order.setDateCreated(form.getDateCreated());
        order.setUserId(form.getUserId());
        order.setGoodsId(form.getGoodsId());
        order.setAmount(form.getAmount());
        ordersDao.save(order);
        return REDIRECT_TO_INDEX;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        OrdersUpdateForm updateForm = new OrdersUpdateForm();
        Order order = ordersDao.findOne(id);
        order.setDateCreated(updateForm.getDateCreated());
        order.setUserId(updateForm.getUserId());
        order.setGoodsId(updateForm.getGoodsId());
        order.setAmount(updateForm.getAmount());
        return new ModelAndView("orders_update", "update_form", updateForm);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("update_form") OrdersUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (result.hasErrors()) {
            return "orders_update";
        } else {
            Order order = ordersDao.findOne(form.getId());
            order.setDateCreated(form.getDateCreated());
            order.setUserId(form.getUserId());
            order.setGoodsId(form.getGoodsId());
            order.setAmount(form.getAmount());
            ordersDao.save(order);
            return REDIRECT_TO_INDEX;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam int id) {
        LOGGER.info("Received request for DELETE new data in table ORDER");
        Order order = ordersDao.findOne(id);
        if (order == null) {
            LOGGER.debug("Order not found");
            return REDIRECT_TO_INDEX;
        }
        ordersDao.delete(order);
        return REDIRECT_TO_INDEX;
    }
}