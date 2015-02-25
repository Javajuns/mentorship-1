package hello;

import com.github.javamentorship.mentorship.CategoryDao;
import com.github.javamentorship.mentorship.DBImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController()
//TODO @RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> categories = CategoryDao.listAll();
        model.put("categories", categories);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Integer id, String name, Integer parentId) throws SQLException, ClassNotFoundException {
        //code for insert
        //"INSERT INTO category (id,name,parent_id) VALUES (null,'" + name + "','" + parentId + "')"
        int result = DBImpl.update("UPDATE category SET NAME='" + name + "', PARENT_ID='" + parentId + "' WHERE ID=" + id); //TODO prepared statement
        return "redirect:/";
    }

}