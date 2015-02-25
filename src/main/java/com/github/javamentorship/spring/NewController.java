package com.github.javamentorship.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RestController
public class NewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewController.class);

    @RequestMapping("/")
    public ModelAndView viewTable(Map<String, Object> model) throws SQLException, ClassNotFoundException {
        ResultSet rs = DBImpl.select("SELECT * FROM category");
        List<Map<String, Object>> categories = new ArrayList<Map<String, Object>>();
        while (rs.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", String.valueOf(rs.getInt("id")));
            map.put("name", rs.getString("name"));
            map.put("parent_id", String.valueOf(rs.getInt("parent_id")));
            categories.add(map);
        }
        model.put("categories", categories);
        LOGGER.debug("Received request for create index view");
        return new ModelAndView("index", "nop", categories);
    }

}