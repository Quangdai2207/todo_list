package intern.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home", "/", ""})
public class HomeController {

    // Todo-list: Trang chu render mac dinh cua ung dung Todo-list
    @GetMapping({"/index", "/", ""})
    public String index() {
        return "web/views/home/index";
    }
}
