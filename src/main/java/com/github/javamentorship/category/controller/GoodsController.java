package com.github.javamentorship.category.controller;

import com.github.javamentorship.category.command.GoodsInsertForm;
import com.github.javamentorship.category.command.GoodsUpdateForm;
import com.github.javamentorship.category.dao.CategoryDao;
import com.github.javamentorship.category.dao.GoodsDao;
import com.github.javamentorship.category.domain.Category;
import com.github.javamentorship.category.domain.Good;
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
@RequestMapping(value = "/goods")
public class GoodsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);
    public static final String REDIRECT_TO_INDEX = "redirect:/goods";

    @Autowired
    public GoodsDao goodsDao;
    @Autowired
    public CategoryDao categoryDao;

    @RequestMapping("")
    public ModelAndView index() {
        LOGGER.debug("Received request for SELECT from table GOODS");
        ModelAndView modelAndView = new ModelAndView("goods");
        Iterable<Good> goods = goodsDao.findAll();
        modelAndView.addObject("viewGoods", goods);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        LOGGER.debug("Received request for get InsertGoods View");
        ModelAndView modelAndView = new ModelAndView("goods_insert");
        modelAndView.addObject("insert_form", new GoodsInsertForm());
        Iterable<Category> parentCategories = categoryDao.findAll();
        Map<String, String> parentGoodsItems = new LinkedHashMap<String, String>();
        for (Category category : parentCategories) {
            parentGoodsItems.put(category.getId().toString(), category.getName());
        }
        modelAndView.addObject("parentCategories", parentGoodsItems);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("insert_form") GoodsInsertForm form, BindingResult result) {
        LOGGER.debug("Received request to create {}", form);
        if (!result.hasErrors()) {
            Good good = new Good();
            good.setName(form.getName());
            good.setPrice(form.getPrice());
            good.setCategoryId(form.getCategoryId());
            good.setRest(form.getRest());
            goodsDao.save(good);
            return REDIRECT_TO_INDEX;
        } else {
            return "redirect:/goods/add";
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("goods_update");
        GoodsUpdateForm updateForm = new GoodsUpdateForm();
        Iterable<Category> parentCategories = categoryDao.findAll();
        Map<String, String> parentCategoryItems = new LinkedHashMap<String, String>();
        for (Category category : parentCategories) {
            parentCategoryItems.put(category.getId().toString(), category.getName());
        }
        Good good = goodsDao.findOne(id);
        updateForm.setId(good.getId());
        updateForm.setName(good.getName());
        updateForm.setPrice(good.getPrice());
        updateForm.setCategoryId(good.getCategoryId());
        updateForm.setRest(good.getRest());
        modelAndView.addObject("update_form", updateForm);
        modelAndView.addObject("parentCategories", parentCategoryItems);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("update_form") GoodsUpdateForm form, BindingResult result) {
        LOGGER.debug("Received request for UPDATE data in table GOODS");
        if (!result.hasErrors()) {
            Good good = goodsDao.findOne(form.getId());
            good.setName(form.getName());
            good.setPrice(form.getPrice());
            good.setCategoryId(form.getCategoryId());
            good.setRest(form.getRest());
            goodsDao.save(good);
            return REDIRECT_TO_INDEX;
        } else {
            return "goods_update";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam int id) {
        LOGGER.debug("Received request for DELETE new data in table GOODS");
        Good good = goodsDao.findOne(id);
        if (good == null) {
            LOGGER.debug("Goods not found");
            return REDIRECT_TO_INDEX;
        }
        goodsDao.delete(good);
        return REDIRECT_TO_INDEX;
    }
}