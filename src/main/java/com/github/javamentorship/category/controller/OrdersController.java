package com.github.javamentorship.category.controller;

import com.github.javamentorship.category.command.OrdersInsertForm;
import com.github.javamentorship.category.command.OrdersUpdateForm;
import com.github.javamentorship.category.dao.OrdersDao;
import com.github.javamentorship.category.domain.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

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
        List<Orders> orders = ordersDao.list();
        modelAndView.addObject("viewOrders", orders);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertCategory View");
        ModelAndView modelAndView = new ModelAndView("orders_insert");
        modelAndView.addObject("insert_form", new OrdersInsertForm());
        List<Orders> parentOrders = ordersDao.list();
/*            Map<String,String> parentOrderItems = new LinkedHashMap<String,String>();
            for(Orders category: parentOrders) {
                parentOrderItems.put(category.getId().toString(), category.getName());
            }
            modelAndView.addObject("parentOrders", parentOrderItems);*/
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("insert_form") OrdersInsertForm form, BindingResult result) {
        LOGGER.info("Received request to create {}", form);
        Orders orders = new Orders();
        orders.setDateCreated(form.getDateCreated());
        orders.setUserId(form.getUserId());
        orders.setGoodsId(form.getGoodsId());
        orders.setAmount(form.getAmount());
        ordersDao.add(orders);
        return REDIRECT_TO_INDEX;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        OrdersUpdateForm updateForm = new OrdersUpdateForm();
        Orders orders = ordersDao.getById(id);
        orders.setDateCreated(updateForm.getDateCreated());
        orders.setUserId(updateForm.getUserId());
        orders.setGoodsId(updateForm.getGoodsId());
        orders.setAmount(updateForm.getAmount());
        return new ModelAndView("orders_update", "update_form", updateForm);

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("update_form") OrdersUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table CATEGORY");
        if (result.hasErrors()) {
            return "orders_update";
        } else {
            Orders orders = ordersDao.getById(form.getId());
            orders.setDateCreated(form.getDateCreated());
            orders.setUserId(form.getUserId());
            orders.setGoodsId(form.getGoodsId());
            orders.setAmount(form.getAmount());
            ordersDao.update(orders);
            return REDIRECT_TO_INDEX;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam int id) {
        LOGGER.info("Received request for DELETE new data in table ORDER");
        Orders orders = ordersDao.getById(id);
        if (orders == null) {
            LOGGER.debug("Order not found");
            return REDIRECT_TO_INDEX;
        }
        ordersDao.delete(orders);
        return REDIRECT_TO_INDEX;
    }
}