package mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/first") // Добавляет префикс перед всеми представлениями контроллера (/first/.+)
public class FirstController {

    @GetMapping("/hello")
    public String getHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Hello, "+ name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String getGoodBye() {
        return "first/goodbye";
    }
}
