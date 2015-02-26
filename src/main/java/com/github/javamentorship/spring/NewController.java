package com.github.javamentorship.spring;

import com.github.javamentorship.mentorship.CategoryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Map;

@RestController
public class NewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewController.class);

    @RequestMapping("/")
    public ModelAndView viewTable(Map<String, Object> model) throws SQLException, ClassNotFoundException {
        LOGGER.debug("Received request for create index view");
        return new ModelAndView("index", "nop", new CategoryDao().listAll());
    }

}