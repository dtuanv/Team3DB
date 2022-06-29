package manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatabaseController {
    @RequestMapping("/database")
    public String displayDatabase(){
        return "database.html";
    }
}
