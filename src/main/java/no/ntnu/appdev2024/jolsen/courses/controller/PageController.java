package no.ntnu.appdev2024.jolsen.courses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String getHome(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        return "contact";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {
        return "signup";
    }

    @GetMapping("/courses")
    public String getCources(Model model) {
        return "courses";
    }
}
