package hello;

import com.github.javamentorship.mentorship.CategoryDao;
import com.github.javamentorship.mentorship.DBImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
//TODO @RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> categories = CategoryDao.listAll();
        ModelAndView modelAndView = new ModelAndView("index/index");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Integer id, String name, Integer parentId) throws SQLException, ClassNotFoundException {
        //code for insert
        //"INSERT INTO category (id,name,parent_id) VALUES (null,'" + name + "','" + parentId + "')"
        //TODO replace with CategoryDAO.update()
        int result = DBImpl.update("UPDATE category SET NAME='" + name + "', PARENT_ID='" + parentId + "' WHERE ID=" + id); //TODO prepared statement
        return "redirect:/";
    }

}