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
}
