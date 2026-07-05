package intern.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    // Todo-list: Xu ly dieu huong ve 404 khi nguoi dung truy cap vao cac Routes chua duoc dinh nghia tai Controllers
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
