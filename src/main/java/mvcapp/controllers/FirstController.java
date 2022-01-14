package mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/first") // Добавляет префикс перед всеми представлениями контроллера (/first/.+)
public class FirstController {

    @GetMapping("/hello")
    public String getHello() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String getGoodBye() {
        return "first/goodbye";
    }
}
