package mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first") // Добавляет префикс перед всеми представлениями контроллера (/first/.+)
public class FirstController {

    @GetMapping("/hello")
    public String getHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model) {

        // System.out.println("Hello, "+ name + " " + surname);
        model.addAttribute("hello_message", "Hello, "+ name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String getGoodBye() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "action") String action,
                            Model model) {
        double solution;
        switch (action) {
            case "mul": solution = a * b; break;
            case "add": solution = a + b; break;
            case "sub": solution = a - b; break;
            case "div": solution = (double)a / b; break;
            default: solution = 0;
        }
        model.addAttribute("calculator_solution", solution);
        return "first/calculator";
    }
}
