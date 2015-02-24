package hello;

import com.github.javamentorship.mentorship.DBImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/")
    public String index(Model model) {
        rs = DBImpl.select()

        List<Map<String, Object>> categories =[[id:
        1, name:'phones', parentid:1]];
        model.addAttribute("categories", categories);
        return "/hello/index.jsp";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Integer id, String name, Integer parentId) {
        //TODO save to db
        return "redirect:/";
    }

}