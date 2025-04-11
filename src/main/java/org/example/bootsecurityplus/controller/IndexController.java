package org.example.bootsecurityplus.controller;

import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("msg", "Hello World!");
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("msg", "Hello Admin!");
        return "index";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("msg", "Hello User!");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
