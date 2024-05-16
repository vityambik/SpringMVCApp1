package ru.klishin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message","Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodBye")
    public String goodByePage() {
        return "first/goodBye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action, Model model) {
        double result = -0;
        String operatioin;
        switch (action) {
            case "multiplication":
                result = a * b;
                operatioin = a + " * " + b;
                break;
                case "division":
                    result = a / (double) b;
                    operatioin = a + " / " + b;
                    break;
                    case "addition":
                        result = a + b;
                        operatioin = a + " + " + b;
                        break;
                        case "subtraction":
                            result = a - b;
                            operatioin = a + " - " + b;
                            break;
            default: operatioin = "error";
        }
        model.addAttribute("result", "Result: " + operatioin + " = " + result);
        return "first/calculator";
    }
}
