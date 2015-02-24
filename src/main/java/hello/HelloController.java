package hello;

import com.github.javamentorship.mentorship.DBImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) throws SQLException, ClassNotFoundException {
        ResultSet rs = DBImpl.select("SELECT * FROM category");
        List<Map<String, Object>> categories = new ArrayList<Map<String, Object>>();

        while (rs.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", String.valueOf(rs.getInt("id")));
            map.put("name", rs.getString("name"));
            map.put("parentId", String.valueOf(rs.getInt("parent_id")));
            categories.add(map);
        }
        model.put("categories", categories);
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Integer id, String name, Integer parentId) throws SQLException, ClassNotFoundException {
        //code for insert
        //"INSERT INTO category (id,name,parent_id) VALUES (null,'" + name + "','" + parentId + "')"
        int result = DBImpl.update("UPDATE category SET NAME='" + name + "', PARENT_ID='" + parentId + "' WHERE ID=" + id);
        return "redirect:/";
    }

}