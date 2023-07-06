package org.launchcode.liftoffgroupproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String displayHomepage(Model model) {
        return "index";
    }
}
